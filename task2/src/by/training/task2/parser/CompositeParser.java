package by.training.task2.parser;

import by.training.task2.composite.Component;
import by.training.task2.composite.Composite;
import by.training.task2.composite.constants.ComponentType;
import org.apache.log4j.Logger;

public abstract class CompositeParser{
	private static final Logger LOGGER = Logger.getLogger(CompositeParser.class.getSimpleName());

	protected ComponentType componentType;
	protected CompositeParser next;

	public CompositeParser setNext(CompositeParser parser){
		next = parser;
		return parser;
	}
	
	protected CompositeParser() {
	}
	
	public void parse(Composite<? extends Component> composite, String text){
		if (composite.getClass().getSimpleName().equals(componentType.getTitle())){
			LOGGER.debug("DO PARSE");
			doParsing(composite, text);			
		}else if (next != null){
			LOGGER.debug("NEXT PARSE");
			next.doParsing(composite, text);
		}
	}
	protected abstract void doParsing(Composite<? extends Component> composite, String text);
}
