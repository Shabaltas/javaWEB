package by.training.task2.parser;

import by.training.task2.composite.Component;
import by.training.task2.composite.Composite;
import by.training.task2.composite.constants.ComponentType;

public abstract class CompositeParser{

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
			doParsing(composite, text);			
		}else if (next != null){
			next.doParsing(composite, text);
		}
	}
	protected abstract void doParsing(Composite<? extends Component> composite, String text);
}
