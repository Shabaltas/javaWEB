package by.training.task2.composite;

public class Paragraph extends Composite<Sequence>{

	public Paragraph() {
		super();
	}

	@Override
	public String compose(){
		String result = "\t";
		for (Component component : components){
			result += component.compose();
		}
		result += "\r\n";
		return result;
	}
}
