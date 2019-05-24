package by.training.task2.composite;

import org.apache.commons.collections4.CollectionUtils;

public class Sequence extends Composite<Lexeme>{

	public Sequence() {
		super();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Sequence)) return false;
		Sequence that = (Sequence) o;
		return count == that.count &&
				CollectionUtils.isEqualCollection(components, that.components);
	}
}
