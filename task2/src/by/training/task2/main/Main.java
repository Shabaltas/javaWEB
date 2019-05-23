package by.training.task2.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import by.training.task2.composite.Sequence;
import by.training.task2.composite.Text;
import by.training.task2.parser.*;
import by.training.task2.sort.Sorter;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String dir = System.getProperty("user.dir") + "\\data\\input.txt";
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
			Sorter.sortByComponents(text);
			str = text.compose();
			System.out.println(str);
			Sequence seq = text.getComponents().get(0).getComponents().get(0);
			Sorter.sortLexemeByWords(seq);
			System.out.println(seq.compose());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
