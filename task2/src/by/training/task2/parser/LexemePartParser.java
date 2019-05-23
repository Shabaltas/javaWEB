package by.training.task2.parser;

import by.training.task2.composite.Component;
import by.training.task2.composite.Composite;
import by.training.task2.composite.LexemePart;
import by.training.task2.composite.Symbol;
import by.training.task2.constants.ComponentType;

public class LexemePartParser extends CompositeParser{

	private String regex = "";
	public LexemePartParser() {
		super();
		componentType = ComponentType.LEXEME_PART;
	}

	@Override
	public void doParsing(Composite<? extends Component> composite, String text) {
		String[] symbols = text.split(regex);
		for(String symbol : symbols){
			Symbol symbolChar = new Symbol(symbol.charAt(0));
			((LexemePart)composite).addComponent(symbolChar);
		}
		System.out.println("LEXEMEPART " + composite.getComponents().size());	
	}
}
