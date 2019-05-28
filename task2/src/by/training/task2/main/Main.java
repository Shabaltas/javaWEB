package by.training.task2.main;

import java.io.IOException;
import java.util.List;

import by.training.task2.composite.*;
import by.training.task2.parser.*;
import by.training.task2.reader.Reader;
import by.training.task2.sort.ComponentSorter;
import org.apache.log4j.Logger;

import static by.training.task2.utility.ComponentWorker.printComponent;

public class Main {
	private static final Logger LOGGER = Logger.getLogger(Main.class.getSimpleName());

	public Main() {
	}

	public static void main(String[] args) {
		String dir = System.getProperty("user.dir") + "\\data\\input.txt";
		try{
			String textStr = new Reader().readFileToString(dir);
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
			sorter.sortComponentsBySymbol(text, 'a');
			printComponent(text);

			/*System.out.println("SORTED PARAGRAPHS");
			paragraphs.forEach(paragraph -> System.out.print(paragraph.compose()));*/

			/*Sequence seq = text.getComponent(1).getComponent(0);
			List<Lexeme> lexemes = getAllComponents(seq);
			sorter.sortWords(lexemes);
			System.out.println("SORTED LEXEMES");
			lexemes.forEach(lexeme -> System.out.print(lexeme.compose()));

			List<Lexeme> sequences = getAllComponents(text.getComponent(1).getComponent(0));
			sorter.sortBySymbol(sequences, 'o');
			System.out.println("\nSORTED SEQUENCES");
			sequences.forEach(sequence -> System.out.print(sequence.compose()));*/
		} catch (IOException e){
			LOGGER.warn(e);
		}
	}
}