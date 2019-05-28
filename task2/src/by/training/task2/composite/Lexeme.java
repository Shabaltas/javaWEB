package by.training.task2.composite;

public class Lexeme extends Composite<LexemePart>{

	public Lexeme() {
		super();
	}
	
	@Override
	public StringBuilder compose(){
		StringBuilder result = new StringBuilder();
		for (Component component : components){
			result.append(component.compose());
		}
		result.append(" ");
		return result;
	}
}
