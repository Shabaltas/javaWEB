package by.training.task2.utility;

import by.training.task2.composite.Component;
import by.training.task2.composite.Composite;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public final class ComponentWorker {
    private static final Logger LOGGER = Logger
            .getLogger(ComponentWorker.class.getSimpleName());

    public ComponentWorker() { }

    public <T extends Component> List<T> getAllComponents(Composite<T> composite) {
        List<T> components = new ArrayList<>();
        for (int i = 0; i < composite.getCount(); i++) {
            components.add(composite.getComponent(i));
        }
        return components;
    }

    public void printComponent(Component component) {
        System.out.println(component.compose());
    }

    public void printComponent(Component component, Path path) throws FileWriteException {
        try {
            Files.writeString(path, component.compose().toString(), StandardOpenOption.APPEND);
            LOGGER.warn("Printed into file successfully");
        } catch (IOException e) {
            LOGGER.warn("Printing into file failed.", e);
            throw new FileWriteException(e);
        }
    }
}
