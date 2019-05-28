package by.training.task2.sort;

import java.util.*;

import by.training.task2.composite.*;
import org.apache.log4j.Logger;

import static by.training.task2.utility.ComponentWorker.getAllComponents;

public class ComponentSorter {

	//передаем тот композит, чьи составляющие мы должны отсортировать по количеству их составляющих
	public <T extends Composite> void sortComponents(T composite){
		List<? extends Composite> compositeList = getAllComponents(composite);
		sortByComponents(compositeList);
		composite.removeAll();
		composite.addComponents(compositeList);
	}

	public <T extends Composite> void sortByComponents(List<T> compositeList){
		compositeList.sort(new CompositeComparator());
	}

	public void sortSequence(Sequence sequence){
		List<Lexeme> parts = getAllComponents(sequence);
		sortWords(parts);
		sequence.removeAll();
		sequence.addComponents(parts);
	}

	//lexeme has only ONE word
	public void sortWords(List<Lexeme> lexemes){
		final LinkedHashMap<Lexeme, Word> allWords = new LinkedHashMap<>();
		//для сохранения лексем, состоящих только из знака и их последовательности в списке/предложении
		final HashMap<Integer, Lexeme> allMarks = new HashMap<>();
		lexemes.forEach(lexeme -> {
			List<LexemePart> parts = getAllComponents(lexeme);
			parts.forEach(part -> {
				if (part instanceof PunctualMark){
					allMarks.put(lexemes.indexOf(lexeme), lexeme);
				}
				if (part instanceof Word){
					allWords.put(lexeme, (Word) part);
				}
			});
		});
		lexemes.clear();
		allWords.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue(new CompositeComparator()))
				.forEachOrdered(entry -> lexemes.add(entry.getKey()));
		allMarks.forEach((i, lex) -> {
			if (!lexemes.contains(lex)){
				lexemes.add(i, lex);
			}
		});
	}

	public <T extends Composite> void sortComponentsBySymbol(T composite, char symbol){
		List<? extends Composite> compositeList = getAllComponents(composite);
		sortBySymbol(compositeList, symbol);
		composite.removeAll();
		composite.addComponents(compositeList);
	}

	public <T extends Composite> void sortBySymbol(List<T> compositeList, char symbol){
		LinkedHashMap<T, Long> counts = new LinkedHashMap<>();
		compositeList.forEach(component -> counts.put(component, component.compose().chars().mapToObj(c -> (char)c).filter(c -> c.equals(symbol)).count()));
		compositeList.clear();
		counts.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(entry -> compositeList.add(entry.getKey()));
	}
}
