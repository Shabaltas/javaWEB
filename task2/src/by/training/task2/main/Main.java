package by.training.task2.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import by.training.task2.composite.*;
import by.training.task2.parser.*;
import by.training.task2.sort.ComponentSorter;

import static by.training.task2.utility.ComponentWorker.getAllComponents;
import static by.training.task2.utility.ComponentWorker.printComponent;

public class Main {

	public Main() {
	}

	public static void main(String[] args) {
		String dir = System.getProperty("user.dir") + "\\data\\dots.txt";
		try{
			String textStr = new String(Files.readAllBytes(Paths.get(dir)));
			System.out.println(textStr);
			TextParser textParser = new TextParser();
			ParagraphParser paragraphParser = (ParagraphParser)textParser.setNext(new ParagraphParser());
			SequenceParser sequenceParser = (SequenceParser)paragraphParser.setNext(new SequenceParser());
			LexemeParser lexemeParser = (LexemeParser)sequenceParser.setNext(new LexemeParser());
			LexemePartParser lexemePartParser = (LexemePartParser)lexemeParser.setNext(new LexemePartParser());

			Text text = new Text();
			textParser.parse(text, textStr);
			printComponent(text);

			ComponentSorter sorter = new ComponentSorter();

			/*List<Paragraph> paragraphs = Sorter.getAllComponents(text);
			Sorter.sortList(paragraphs);
			text.removeAll();
			text.addComponents(paragraphs);*/
			sorter.sortComponents(text);
			printComponent(text);
			/*System.out.println("SORTED PARAGRAPHS");
			paragraphs.forEach(paragraph -> System.out.print(paragraph.compose()));*/

			Sequence seq = text.getComponent(1).getComponent(0);
			List<Lexeme> lexemes = getAllComponents(seq);
			sorter.sortWords(lexemes);
			System.out.println("SORTED LEXEMES");
			lexemes.forEach(lexeme -> System.out.print(lexeme.compose()));

			List<Lexeme> sequences = getAllComponents(text.getComponent(1).getComponent(0));
			sorter.sortBySymbol(sequences, 'o');
			System.out.println("\nSORTED SEQUENCES");
			sequences.forEach(sequence -> System.out.print(sequence.compose()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
