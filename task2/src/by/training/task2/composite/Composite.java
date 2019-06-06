package by.training.task2.composite;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Composite<T extends Component> implements Component, Comparable<Composite<T>> {
	protected List<T> components = new ArrayList<>();
	protected Composite() {
	}
	public T getComponent(int index) {
		return components.get(index);
	}

	@Override
	public StringBuilder compose() {
		StringBuilder result = new StringBuilder();
		for (Component component : components) {
			result.append(component.compose());
		}
		return result;
	}

	public void addComponent(T component) {
		components.add(component);
	}

	public void addComponents(List<T> listComponents) {
		components.addAll(listComponents);
	}

	public void removeComponent(T component) {
		components.remove(component);
	}

	public void removeAll() {
		components.clear();
	}

	public int getCount() {
		return components.size();
	}

	@Override
	public int compareTo(Composite<T> o) {
		return Integer.compare(getCount(), o.getCount());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Composite)) {
			return false;
		}
		Composite<?> composite = (Composite<?>) o;
		return CollectionUtils.isEqualCollection(components, composite.components);
	}

	@Override
	public int hashCode() {
		return Objects.hash(components);
	}

	@Override
	public String toString() {
		return "Composite{"
				+ "components="
				+ components
				+ '}';
	}
}
