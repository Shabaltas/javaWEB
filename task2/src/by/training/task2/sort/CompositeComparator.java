package by.training.task2.sort;

import java.util.Comparator;

import by.training.task2.composite.Composite;

public class CompositeComparator implements Comparator<Composite<?>>{

	public CompositeComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Composite<?> arg0, Composite<?> arg1) {
		return Integer.compare(arg0.getComponents().size(), arg1.getComponents().size());
	}

}
