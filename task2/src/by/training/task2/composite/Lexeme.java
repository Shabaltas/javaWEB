package by.training.task2.composite;

import org.apache.commons.collections4.CollectionUtils;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Lexeme)) return false;
		Lexeme that = (Lexeme) o;
		return count == that.count &&
				CollectionUtils.isEqualCollection(components, that.components);
	}
}
