package by.training.task2.parser;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.training.task2.composite.*;
import by.training.task2.composite.constants.ComponentType;
import org.apache.log4j.Logger;

public class LexemeParser extends CompositeParser{
	private static final Logger LOGGER = Logger.getLogger(LexemeParser.class.getSimpleName());

	private static final String SPEACH_REGEX = "\".*?\"";
	private static final String WORD_REGEX = "([A-Za-z]+-?[A-Za-z]*)";
	private static final String MARK_REGEX = "[!\\?\\.,;:-]+";
	private static final String REGEX = "(" + SPEACH_REGEX + ")|(" + WORD_REGEX + ")|(" + MARK_REGEX + ")";

	public LexemeParser(){
		super();
		componentType = ComponentType.LEXEME;
	}
	@Override
	protected void doParsing(Composite<? extends Component> composite, String text) {
		String subText;
		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()){
			subText = text.substring(matcher.start(), matcher.end());
			LexemePart part;
			if (Pattern.matches(MARK_REGEX, subText)){
				LOGGER.debug("PUNCTUAL MARK: " + subText);
				part = new PunctualMark();
			}else {
				LOGGER.debug("WORD: " + subText);
				part = new Word();
			}
			parse(part, subText);
			((Lexeme)composite).addComponent(part);
		}
	}
}
