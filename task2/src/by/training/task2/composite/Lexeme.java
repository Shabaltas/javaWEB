package by.training.task2.composite;

public class Lexeme extends Composite<LexemePart>{

	public Lexeme() {
		super();
	}
	
	@Override
	public String compose(){
		String result = " ";
		for (Component component : components){
			result += component.compose();
		}
		result += " ";
		return result;
	}
}
