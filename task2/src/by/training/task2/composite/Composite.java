package by.training.task2.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class Composite<T extends Component> implements Component{
	
	protected List<T> components = new ArrayList<>();
	
	protected Composite() {
	}
	
	public List<T> getComponents(){
		return components;
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
	
}
