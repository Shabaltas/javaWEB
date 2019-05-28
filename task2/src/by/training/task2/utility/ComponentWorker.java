package by.training.task2.utility;

import by.training.task2.composite.Component;
import by.training.task2.composite.Composite;

import java.util.ArrayList;
import java.util.List;

public class ComponentWorker {
    private ComponentWorker(){}

    public static <T extends Component> List<T> getAllComponents(Composite<T> composite){
        List<T> components = new ArrayList<>();
        for (int i = 0; i < composite.getCount(); i++){
            components.add(composite.getComponent(i));
        }
        return components;
    }

    public static void printComponent(Component component){
        System.out.println(component.compose());
    }
}
