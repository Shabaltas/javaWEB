package by.training.task2.sort;

import java.util.*;
import java.util.stream.Collectors;

import by.training.task2.composite.*;

public class Sorter {

	public Sorter() {
		// TODO Auto-generated constructor stub
	}

	public static <T extends Composite> void sortByComponents(T composite){
		List<? extends Composite> compositeList = getAllComponents(composite);
		sortList(compositeList);
		composite.removeAll();
		composite.addComponents(compositeList);
	}

	public static <T extends Composite> void sortList(List<T> compositeList){
		compositeList.sort(new CompositeComparator());
	}
	//lexeme has only ONE word
	public static void sortLexemeByWords(List<Lexeme> lexemes){
		final LinkedHashMap<Lexeme, Word> allWords = new LinkedHashMap<>();
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

	public static <T extends Composite> void sortBySymbol(List<T> compositeList, char symbol){
		LinkedHashMap<T, Long> counts = new LinkedHashMap<>();
		compositeList.forEach(component -> {
			counts.put(component, component.compose().chars().mapToObj(c -> (char)c).filter(c -> c.equals(symbol)).count());
		});
		compositeList.clear();
		counts.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(entry -> compositeList.add(entry.getKey()));
	}

	public static <T extends Component> List<T> getAllComponents(Composite<T> composite){
		List<T> components = new ArrayList<>();
		for (int i = 0; i < composite.getCount(); i++){
			components.add(composite.getComponent(i));
		}
		return components;
	}
}
