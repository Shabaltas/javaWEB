package by.training.task2.parser;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.training.task2.composite.*;
import by.training.task2.composite.constants.ComponentType;
import org.apache.log4j.Logger;

public class LexemeParser extends CompositeParser{
	private static final Logger LOGGER = Logger.getLogger(LexemeParser.class.getSimpleName());

	private String speachRegex = "\".*?\"";
	private String wordRegex = "([A-Za-z]+-?[A-Za-z]*)";
	private String markRegex = "[!\\?\\.,;:-]+";
	private String regex = "(" + speachRegex + ")|(" + wordRegex + ")|(" + markRegex + ")";

	public LexemeParser(){
		super();
		componentType = ComponentType.LEXEME;
	}
	@Override
	protected void doParsing(Composite<? extends Component> composite, String text) {
		final HashMap<Integer, LexemePart> mapa = new HashMap<>();
		String subText;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()){
			subText = text.substring(matcher.start(), matcher.end());
			LexemePart part;
			if (Pattern.matches(markRegex, subText)){
				LOGGER.debug("PUNCTUAL MARK: " + subText);
				part = new PunctualMark();
			}else {
				LOGGER.debug("WORD: " + subText);
				part = new Word();
			}
			parse(part, subText);
			mapa.put(matcher.start(), part);
		}
		mapa.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByKey())
				.forEachOrdered((entry) -> ((Lexeme)composite).addComponent(entry.getValue()));

	}
}
