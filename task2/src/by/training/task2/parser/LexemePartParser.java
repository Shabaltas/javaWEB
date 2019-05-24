package by.training.task2.parser;

import by.training.task2.composite.Component;
import by.training.task2.composite.Composite;
import by.training.task2.composite.LexemePart;
import by.training.task2.composite.Symbol;
import by.training.task2.composite.constants.ComponentType;
import org.apache.log4j.Logger;

public class LexemePartParser extends CompositeParser{
	private static final Logger LOGGER = Logger.getLogger(LexemePartParser.class.getSimpleName());

	private String regex = "";

	public LexemePartParser() {
		super();
		componentType = ComponentType.LEXEME_PART;
	}

	@Override
	protected void doParsing(Composite<? extends Component> composite, String text) {
		String[] symbols = text.split(regex);
		for(String symbol : symbols){
			LOGGER.debug("SYMBOL: " + symbol);
			((LexemePart)composite).addComponent(new Symbol(symbol.charAt(0)));
		}
	}
}
