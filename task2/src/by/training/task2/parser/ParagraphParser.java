package by.training.task2.parser;

import java.util.regex.Pattern;

import by.training.task2.composite.Component;
import by.training.task2.composite.Composite;
import by.training.task2.composite.Paragraph;
import by.training.task2.composite.Sequence;
import by.training.task2.composite.constants.ComponentType;
import org.apache.log4j.Logger;

public class ParagraphParser extends CompositeParser {
	private static final Logger LOGGER = Logger.getLogger(ParagraphParser.class.getSimpleName());
	private static final String BEGIN_REGEX = "[A-Z\"]";
	private static final String INSIDE_REGEX = "[^\\.\\?!]";
	private static final String END_REGEX = "[\\.\\?!\"]";

	public ParagraphParser() {
		super();
		componentType = ComponentType.PARAGRAPH;
	}
	@Override
	protected void doParsing(Composite<? extends Component> composite, String text) {
		String[] chars = text.chars()
				.mapToObj(c -> String.valueOf((char) c))
				.toArray(String[]::new);
		int i = 0;
		while (i < chars.length) {
			if (Pattern.matches(BEGIN_REGEX, chars[i])) {
				int begin = i;
				while (i < chars.length
						&& Pattern.matches(INSIDE_REGEX, chars[i])) {
					i++;
				}
				while (i < chars.length
						&& Pattern.matches(END_REGEX, chars[i])) {
					i++;
				}
				String sequenceText = text.substring(begin, i) + " ";
				LOGGER.debug("SEQUENCE: " +  sequenceText);
				Sequence sequence = new Sequence();
				parse(sequence, sequenceText);
				((Paragraph) composite).addComponent(sequence);
			} else {
				i++;
			}
		}
	}
}
