package by.training.task2.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import by.training.task2.composite.*;
import by.training.task2.parser.*;
import by.training.task2.sort.Sorter;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String dir = System.getProperty("user.dir") + "\\data\\dots.txt";
		System.out.println(dir);
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

			String str = text.compose();
			System.out.println(str);

			/*List<Paragraph> paragraphs = Sorter.getAllComponents(text);
			Sorter.sortList(paragraphs);
			text.removeAll();
			text.addComponents(paragraphs);*/
			Sorter.sortByComponents(text);
			System.out.println("SORTED TEXT\n" + text.compose());
			/*System.out.println("SORTED PARAGRAPHS");
			paragraphs.forEach(paragraph -> System.out.print(paragraph.compose()));*/

			Sequence seq = text.getComponent(1).getComponent(0);
			List<Lexeme> lexemes = Sorter.getAllComponents(seq);
			Sorter.sortLexemeByWords(lexemes);
			System.out.println("SORTED LEXEMES");
			lexemes.forEach(lexeme -> System.out.print(lexeme.compose()));

			List<Sequence> sequences = Sorter.getAllComponents(text.getComponent(1));
			Sorter.sortBySymbol(sequences, 'a');
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
