package by.training.task2.composite;

import org.apache.commons.collections4.CollectionUtils;

public class LexemePart extends Composite<Symbol>{

	public LexemePart() {
		super();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof LexemePart)) return false;
		LexemePart that = (LexemePart) o;
		return count == that.count &&
				CollectionUtils.isEqualCollection(components, that.components);
	}
}
