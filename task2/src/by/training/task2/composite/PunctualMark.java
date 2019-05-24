package by.training.task2.composite;

import org.apache.commons.collections4.CollectionUtils;

public class PunctualMark extends LexemePart{
	public PunctualMark(){
		super();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PunctualMark)) return false;
		PunctualMark that = (PunctualMark) o;
		return count == that.count &&
				CollectionUtils.isEqualCollection(components, that.components);
	}
}
