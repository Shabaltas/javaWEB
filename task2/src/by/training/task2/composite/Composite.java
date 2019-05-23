package by.training.task2.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class Composite<T extends Component> implements Component{
	
	protected List<T> components = new ArrayList<>();
	protected int count;
	
	protected Composite() {
	}
	
	public T getComponent(int index){
		return components.get(index);
	}

	@Override
	public String compose() {
		String result = "";
		for (Component component : components){
			result += component.compose();
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

	public void removeAll(){
		components.clear();
	}

	public int getCount() {
		return components.size();
	}
}
