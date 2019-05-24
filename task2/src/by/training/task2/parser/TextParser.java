package by.training.task2.parser;

import by.training.task2.composite.*;
import by.training.task2.composite.constants.ComponentType;
import org.apache.log4j.Logger;

public class TextParser extends CompositeParser{
	private static final Logger LOGGER = Logger.getLogger(Sequence.class.getSimpleName());

	//private String regex = ".+?\\r\\n\\t";
	private final String regex = "\\r\\n\\t";
	private final String toReplace  = "[\\r\\n\\s]+";

	public TextParser(){
		super();
		componentType = ComponentType.TEXT;
	}

	@Override
	protected void doParsing(Composite<? extends Component> composite, String text) {
		String[] paragraphs = text.split(regex);
		for (String paragraphText : paragraphs){
			LOGGER.debug("PARAGRAPH: " + paragraphText);
			paragraphText = paragraphText.replaceAll(toReplace, " ");
			Paragraph paragraph = new Paragraph();
			parse(paragraph, paragraphText);
			((Text)composite).addComponent(paragraph);
		}
	}
}
