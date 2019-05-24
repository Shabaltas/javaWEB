package by.training.task2.composite;

import org.apache.commons.collections4.CollectionUtils;

public class Text extends Composite<Paragraph>{

	public Text() {
		super();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Text)) return false;
		Text that = (Text) o;
		return count == that.count &&
				CollectionUtils.isEqualCollection(components, that.components);
	}
}
