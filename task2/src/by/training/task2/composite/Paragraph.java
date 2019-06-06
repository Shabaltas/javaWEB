package by.training.task2.composite;

public final class Paragraph extends Composite<Sequence> {

	public Paragraph() {
		super();
	}

	@Override
	public StringBuilder compose() {
		StringBuilder result = new StringBuilder("\t");
		for (Component component : components) {
			result.append(component.compose());
		}
		result.append("\r\n");
		return result;
	}
}
