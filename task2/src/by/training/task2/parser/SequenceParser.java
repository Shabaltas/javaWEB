package by.training.task2.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.training.task2.composite.Component;
import by.training.task2.composite.Composite;
import by.training.task2.composite.Lexeme;
import by.training.task2.composite.Sequence;
import by.training.task2.composite.constants.ComponentType;
import org.apache.log4j.Logger;

public class SequenceParser extends CompositeParser{
	private static final Logger LOGGER = Logger.getLogger(SequenceParser.class.getSimpleName());

	private static final String REGEX = "((\\S*(\".*\")\\S*)|(\\S+))\\s+";

	public SequenceParser(){
		super();
		componentType = ComponentType.SEQUENCE;
	}
	@Override
	protected void doParsing(Composite<? extends Component> composite, String text) {
		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()){					
			String lexemeText = text.substring(matcher.start(), matcher.end()-1);
			LOGGER.debug("LEXEME: " + lexemeText);
			Lexeme lexeme = new Lexeme();
			parse(lexeme, lexemeText);
			((Sequence)composite).addComponent(lexeme);
		}
	}
}
