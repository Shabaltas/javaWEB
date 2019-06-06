package by.training.task2.parser;

import by.training.task2.composite.Text;
import by.training.task2.composite.Paragraph;
import by.training.task2.composite.Component;
import by.training.task2.composite.Composite;
import by.training.task2.composite.constants.ComponentType;
import org.apache.log4j.Logger;

public class TextParser extends CompositeParser {
	private static final Logger LOGGER = Logger
			.getLogger(Text.class.getSimpleName());
	private static final String SPLIT_REGEX = "\\r\\n\\t";
	private static final String TOREPLACE  = "[\\r\\n\\s]+";

	public TextParser() {
		super();
		componentType = ComponentType.TEXT;
	}

	@Override
	protected void doParsing(Composite<? extends Component> composite, String text) {
		if (!"".equals(text)) {
			String[] paragraphs = text.split(SPLIT_REGEX);
			for (String paragraphText : paragraphs) {
				LOGGER.debug("PARAGRAPH: " + paragraphText);
				paragraphText = paragraphText.replaceAll(TOREPLACE, " ");
				Paragraph paragraph = new Paragraph();
				parse(paragraph, paragraphText);
				((Text) composite).addComponent(paragraph);
			}
		}
	}
}
