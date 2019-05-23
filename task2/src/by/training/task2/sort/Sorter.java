package by.training.task2.sort;

import java.util.*;
import java.util.stream.Collectors;

import by.training.task2.composite.*;

public class Sorter {

	public Sorter() {
		// TODO Auto-generated constructor stub
	}

	public static void sortByComponents(Composite composite){
		//Comparator<Component> comparator = new Comparator();
		composite.getComponents().sort(new CompositeComparator());;
	}

	public static void sortLexemeByWords(Sequence sequence){
		HashMap<Integer, Word> allWords = new HashMap<>();
		List<Lexeme> lexemes = sequence.getComponents();
		int[] i = new int[]{0};
		int size = lexemes.size();
		while (i[0] < size){
			lexemes.get(i[0]).getComponents().stream().filter(part -> part instanceof Word).forEachOrdered(word -> allWords.put(i[0], (Word)word));
			i[0]++;
		}
        LinkedHashMap<Integer, Word> sortedWords = allWords.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(new CompositeComparator()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                        LinkedHashMap::new));
		sortedWords.entrySet().stream().forEachOrdered(word -> System.out.print(word.getValue().compose() + " "));
        //System.out.println("SORTEEEEEEEED\n" + sorted);
		//allWords.entrySet().stream().sorted(Comparator.comparing(word -> word.getValue())).forEach(System.out::println);
	}
	
}
