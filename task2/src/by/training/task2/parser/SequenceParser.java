package by.training.task2.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.training.task2.composite.Component;
import by.training.task2.composite.Composite;
import by.training.task2.composite.Lexeme;
import by.training.task2.composite.Sequence;
import by.training.task2.constants.ComponentType;

public class SequenceParser extends CompositeParser{
	
	private String regex = "(\".*\")?\\S*\\s+"; 
	//private String regex = "\\s+";
	//private String regex = ".*(\".*\")?.?\\s+";
	public SequenceParser(){
		super();
		componentType = ComponentType.SEQUENCE;
	}
	@Override
	public void doParsing(Composite<? extends Component> composite, String text) {
				/*
				String[] lexemes = text.split(regex);
				for(String lexemeText : lexemes){
					Lexeme lexeme = new Lexeme();
					parse(lexeme, lexemeText);
					((Sequence)composite).addComponent(lexeme);
				}
				*/
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()){					
			String lexemeText = text.substring(matcher.start(), matcher.end()-1);
			Lexeme lexeme = new Lexeme();
			parse(lexeme, lexemeText);
			((Sequence)composite).addComponent(lexeme);
		}
	}
}
