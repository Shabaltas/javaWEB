package by.training.task3.entity.resource;

import by.training.task3.entity.matrix.Matrix;

public class MatrixResource extends CommonResource<Matrix> {

    private int index;
    public MatrixResource(Matrix object) {
        super(object);
        index = object.getNumberOfRows() - 1;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
