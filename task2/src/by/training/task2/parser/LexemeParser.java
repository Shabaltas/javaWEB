package by.training.task2.parser;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.training.task2.composite.*;
import by.training.task2.composite.constants.ComponentType;

public class LexemeParser extends CompositeParser{
	private String speachRegex = "\".*?\"";
	private String wordRegex = "([A-Za-z]+-?[A-Za-z]*)";
	private String markRegex = "[!\\?\\.,;:-]+";
	private String regex = "(" + speachRegex + ")|(" + wordRegex + ")|(" + markRegex + ")";

	public LexemeParser(){
		super();
		componentType = ComponentType.LEXEME;
	}
	@Override
	public void doParsing(Composite<? extends Component> composite, String text) {
		final HashMap<Integer, LexemePart> mapa = new HashMap<>();
		String subText;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()){
			subText= text.substring(matcher.start(), matcher.end());
			Word speach = new Word();
			parse(speach, subText);
			mapa.put(matcher.start(), speach);
		}
		mapa.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByKey())
				.forEachOrdered((entry) -> ((Lexeme)composite).addComponent(entry.getValue()));
	}
}
