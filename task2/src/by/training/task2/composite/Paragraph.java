package by.training.task2.composite;

import org.apache.commons.collections4.CollectionUtils;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Paragraph)) return false;
		Paragraph that = (Paragraph) o;
		return count == that.count &&
				CollectionUtils.isEqualCollection(components, that.components);
	}
}
