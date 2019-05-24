package by.training.task2.composite;

import org.apache.commons.collections4.CollectionUtils;

public class Word extends LexemePart{
	public Word(){
		super();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Word)) return false;
		Word that = (Word) o;
		return count == that.count &&
				CollectionUtils.isEqualCollection(components, that.components);
	}
}
