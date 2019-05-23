package by.training.task2.parser;

import by.training.task2.composite.*;
import by.training.task2.composite.constants.ComponentType;

public class TextParser extends CompositeParser{

	//private String regex = ".+?\\r\\n\\t";
	private final String regex = "\\r\\n\\t";
	private final String toReplace  = "[\\r\\n\\s]+";

	public TextParser(){
		super();
		componentType = ComponentType.TEXT;
	}

	@Override
	public void doParsing(Composite<? extends Component> composite, String text) {
		String[] paragraphs = text.split(regex);
		for (String paragraphText : paragraphs){
			paragraphText = paragraphText.replaceAll(toReplace, " ");
			Paragraph paragraph = new Paragraph();
			parse(paragraph, paragraphText);
			((Text)composite).addComponent(paragraph);
		}
	}
}
