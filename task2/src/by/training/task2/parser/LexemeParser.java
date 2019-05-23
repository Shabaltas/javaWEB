package by.training.task2.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.training.task2.composite.Component;
import by.training.task2.composite.Composite;
import by.training.task2.composite.Lexeme;
import by.training.task2.composite.LexemePart;
import by.training.task2.composite.PunctualMark;
import by.training.task2.composite.Word;
import by.training.task2.constants.ComponentType;

public class LexemeParser extends CompositeParser{
	private String speachRegex = "\".*?\"";
	private String wordRegex = "([A-Za-z]+-?[A-Za-z]*)";
	private String markRegex = "[!\\?\\.,;:-]+";

	public LexemeParser(){
		super();
		componentType = ComponentType.LEXEME;
	}
	@Override
	public void doParsing(Composite<? extends Component> composite, String text) {
		String subText;
		Pattern pattern = Pattern.compile(speachRegex);
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()){
			subText= text.substring(matcher.start(), matcher.end());
			Word speach = new Word();
			parse(speach, subText);
			((Lexeme)composite).addComponent(speach);
		}
		text = text.replaceAll(speachRegex, " ");
		pattern = Pattern.compile(wordRegex);
		matcher = pattern.matcher(text);
		while (matcher.find()){
			subText = text.substring(matcher.start(), matcher.end());
			Word word = new Word();
			parse(word, subText);
			((Lexeme)composite).addComponent(word);
		}
		text = text.replaceAll(wordRegex, " ");
		pattern = Pattern.compile(markRegex);
		matcher = pattern.matcher(text);
		while (matcher.find()){
			subText = text.substring(matcher.start(), matcher.end());
			PunctualMark punctualMark = new PunctualMark();
			parse(punctualMark, subText);
			((Lexeme)composite).addComponent(punctualMark);
		}
	}
}
