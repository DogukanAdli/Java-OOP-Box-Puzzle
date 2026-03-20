package boxes;

import Enums.Direction;
import Enums.Letter;
import exceptions.EmptyBoxException;
import mains.BoxGrid;
import specialtools.SpecialTool;

public abstract class Box {
    private Letter top, bottom, front, back, left, right;
    private SpecialTool specialTool;
    

    public Box(Letter top, Letter bottom,Letter front,Letter back,Letter left,Letter right ){

        this.top = top;
        this.bottom = bottom;
        this.front = front;
        this.back = back;
        this.left = left;
        this.right = right;
    }

    public abstract void slide(Direction direction, BoxGrid grid,int row, int col);
    public abstract SpecialTool open() throws EmptyBoxException;
    public abstract void observeSurfaces();

    public SpecialTool getSpecialTool() {
        return specialTool;
    }
    public void setSpecialtool(SpecialTool specialTool) {
        this.specialTool = specialTool;
    }
    public abstract String getSymbol();

    public Letter getTop() {
        return top;
    }

    public Letter getBottom() {
        return bottom;
    }

    public Letter getFront() {
        return front;
    }

    public Letter getBack() {
        return back;
    }

    public Letter getLeft() {
        return left;
    }

    public Letter getRight() {
        return right;
    }

    public void setTop(Letter top) {
        this.top = top;
    }

    public void setBottom(Letter bottom) {
        this.bottom = bottom;
    }

    public void setFront(Letter front) {
        this.front = front;
    }

    public void setBack(Letter back) {
        this.back = back;
    }

    public void setLeft(Letter left) {
        this.left = left;
    }

    public void setRight(Letter right) {
        this.right = right;
    }    
}
