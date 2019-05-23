package by.training.task2.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.training.task2.composite.*;
import by.training.task2.constants.ComponentType;

public class TextParser extends CompositeParser{

	//private String regex = ".+?\\r\\n\\t";
	private String regex = "\\r\\n\\t";
	public TextParser(){
		super();
		componentType = ComponentType.TEXT;
	}

	@Override
	public void doParsing(Composite<? extends Component> composite, String text) {
				/*
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(text);
				while (matcher.find()){
					String paragraphText = text.substring(matcher.start(), matcher.end());
					Paragraph paragraph = new Paragraph();
					parse(paragraph, paragraphText);
					((Text)composite).addComponent(paragraph);
				}
				*/
		String[] paragraphs = text.split(regex);
		for (String paragraphText : paragraphs){
			paragraphText = paragraphText.replaceAll("[\\r\\n\\s]+", " ");
			Paragraph paragraph = new Paragraph();
			parse(paragraph, paragraphText);
			((Text)composite).addComponent(paragraph);
		}
	}
}
