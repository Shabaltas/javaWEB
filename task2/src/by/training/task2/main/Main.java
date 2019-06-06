package by.training.task2.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import by.training.task2.composite.*;
import by.training.task2.parser.*;
import by.training.task2.reader.Reader;
import by.training.task2.sort.ComponentSorter;
import by.training.task2.utility.ComponentWorker;
import by.training.task2.utility.FileWriteException;
import org.apache.log4j.Logger;

public class Main {
	private static final Logger LOGGER = Logger.getLogger(Main.class.getSimpleName());
	private static final Path OUTPUT = Paths.get("data\\output.txt");

	public Main() {
	}

	public static void main(String[] args) {
		String dir = System.getProperty("user.dir") + "\\data\\input.txt";
		ComponentWorker worker = new ComponentWorker();
		String textStr = new Reader().readFileToString(Paths.get(dir));
		TextParser textParser = new TextParser();
		ParagraphParser paragraphParser = (ParagraphParser) textParser.setNext(new ParagraphParser());
		SequenceParser sequenceParser = (SequenceParser) paragraphParser.setNext(new SequenceParser());
		LexemeParser lexemeParser = (LexemeParser) sequenceParser.setNext(new LexemeParser());
		LexemePartParser lexemePartParser = (LexemePartParser) lexemeParser.setNext(new LexemePartParser());

		if (!Files.exists(OUTPUT)) {
			try {
				Files.createFile(OUTPUT);
			} catch (IOException e) {
				throw new RuntimeException();
			}
		}

		Text text = new Text();
		textParser.parse(text, textStr);
		try {
			worker.printComponent(text, OUTPUT);
		} catch (FileWriteException e) {
			LOGGER.warn("Wasn't printed: line 33");
		}

		ComponentSorter sorter = new ComponentSorter();

		List<Lexeme> sequence = worker.getAllComponents(text.getComponent(0).getComponent(0));
		sorter.sortWords(sequence);
		try {
			Files.writeString(OUTPUT, "SORTED WORDS\n", StandardOpenOption.APPEND);
		} catch (IOException e) {
			LOGGER.warn(e);
		}
		sequence.forEach(lexeme -> {
			try {
				worker.printComponent(lexeme, Paths.get("data\\output.txt"));
			} catch (FileWriteException e) {
				LOGGER.warn("Wasn't printed: line 48");
			}
		});

		sorter.sortComponents(text);
		try {
			Files.writeString(OUTPUT, "\nSORTED PARAGRAPHS\n", StandardOpenOption.APPEND);
		} catch (IOException e) {
			LOGGER.warn(e);
		}
		try {
			worker.printComponent(text, Paths.get("data\\output.txt"));
		} catch (FileWriteException e) {
			LOGGER.warn("Wasn't printed: line 56");
		}

		sorter.sortComponentsBySymbol(text, 'a');
		try {
			Files.writeString(OUTPUT, "SORTED PARAGRAPHS BY 'a'\n", StandardOpenOption.APPEND);
		} catch (IOException e) {
			LOGGER.warn(e);
		}
		try {
			worker.printComponent(text, Paths.get("data\\output.txt"));
		} catch (FileWriteException e) {
			LOGGER.warn("Wasn't printed: line 33");
		}
	}
}
