package boxes;

import Enums.Direction;
import Enums.Letter;
import java.util.Random;
import mains.BoxGrid;
import specialtools.BoxFixer;
import specialtools.BoxFlipper;
import specialtools.MassColumnStamp;
import specialtools.MassRowStamp;
import specialtools.PlusShapeStamp;
import specialtools.SpecialTool;

public class UnchangingBox extends Box{
    private Random rand;
    boolean isOpened = false;

    public UnchangingBox(Letter top, Letter bottom, Letter front, Letter back, Letter left, Letter right) {
        super(top, bottom, front, back, left, right);
        this.rand = new Random();
        super.setSpecialtool(getRandomSpecialTool()); /** Unchancging Boxes are                                                   
                                                        guaranteed to contain a SpecialTools**/
    }

   @Override
    public void slide(Direction direction, BoxGrid boxGrid, int row, int col) {
        if(boxGrid.getBoxAt(row, col) instanceof FixedBox){
            System.out.println("Fixed Box cannot start sliding!");
            
        }else{
            Letter tempTop = getTop();
            Letter tempBottom = getBottom();
            Letter tempLeft = getLeft();
            Letter tempRight = getRight();
            Letter tempFront = getFront();
            Letter tempBack = getBack();

        switch (direction) {
            case RIGHT:
                if(!(boxGrid.getBoxAt(row, col) instanceof UnchangingBox)){
                    setTop(tempLeft);
                    setLeft(tempBottom);
                    setBottom(tempRight);
                    setRight(tempTop);
                }
                col++;
                if(boxGrid.getBoxAt(row, col) instanceof FixedBox){
                    System.out.println("The box sliding stopped at "+(row+1)+"-"+ (col+1) +" due to fixed box");
                }else if(col==boxGrid.getNumberOfColumns()){
                    // Just do nothing. stops.
                }else{
                    boxGrid.getBoxAt(row, col).slide(Direction.RIGHT, boxGrid,row, col);// Pushes the next Box
                }
                break;

            case LEFT:
                if(!(boxGrid.getBoxAt(row, col) instanceof UnchangingBox)){
                    setTop(tempRight);
                    setRight(tempBottom);
                    setBottom(tempLeft);
                    setLeft(tempTop);
                }
                col--;
                if(boxGrid.getBoxAt(row, col--) instanceof FixedBox){
                    System.out.println("The box sliding stopped at "+(row+1)+"-"+ (col+1) +" due to fixed box");
                }else if (col == -1) {
                    
                }else{
                    boxGrid.getBoxAt(row, col).slide(Direction.LEFT, boxGrid,row, col);// Pushes the next Box
                }
                break;

            case UP:
                if(!(boxGrid.getBoxAt(row, col) instanceof UnchangingBox)){
                    setTop(tempBack);
                    setFront(tempTop);
                    setBottom(tempFront);
                    setBack(tempBottom);
                }
                row--;
                if(boxGrid.getBoxAt(row, col) instanceof FixedBox){
                    System.out.println("The box sliding stopped at "+(row+1)+"-"+ (col+1) +" due to fixed box");
                }
                else if (row == -1) {
                    
                }else{
                    boxGrid.getBoxAt(row, col).slide(Direction.UP, boxGrid,row, col);// Pushes the next Box
                }
                break;

            case DOWN:
                if(!(boxGrid.getBoxAt(row, col) instanceof UnchangingBox)){
                    setTop(tempFront);
                    setBack(tempTop);
                    setBottom(tempBack);
                    setFront(tempBottom);
                }
                row++;
                if(boxGrid.getBoxAt(row, col) instanceof FixedBox){
                    System.out.println("The box sliding stopped at "+(row+1)+"-"+ (col+1) +" due to fixed box");
                }else if (row == boxGrid.getNumberOfRows()) {
                    
                }else{
                    boxGrid.getBoxAt(row, col).slide(Direction.DOWN, boxGrid,row, col); // Pushes the next Box
                }
                break;
        } 
    }
        
}
    @Override
    public SpecialTool open(){
            System.out.println("It contains a SpecialTool --> " + super.getSpecialTool().getName());
            isOpened = true;
            return super.getSpecialTool(); 
    }

    public String getSymbol(){
        if(isOpened == false){
            return "U-" + getTop() + "-M";
        }else{
            return "R-" + getTop() + "-O";
        }
    }
    @Override
    public void observeSurfaces() {
        System.out.println("    -----    ");
        System.out.println("    | " + super.getFront() + " |");
        System.out.println("-------------");
        System.out.println("| " + super.getLeft() + " | " + super.getTop() + " | "+ super.getRight() + " |" );
        System.out.println("--------------");
        System.out.println("    | " + super.getBack() + " |");
        System.out.println("    -----    ");
        System.out.println("    | " + super.getBottom() + " |");
        System.out.println("    -----");
    }
    
    private SpecialTool getRandomSpecialTool(){
        int number = rand.nextInt(0, 5);
        SpecialTool returnedTool;
        switch (number) {
            case 0:
                returnedTool = new BoxFixer(); 
                break;
            case 1:
                returnedTool = new BoxFlipper(); 
                break;
            case 2:
                returnedTool = new MassColumnStamp(); 
                break;
            case 3:
                returnedTool = new MassRowStamp(); 
                break;
            case 4:
                returnedTool = new PlusShapeStamp(); 
                break;
            default:
                throw new AssertionError();
        }
        return returnedTool;
    }
    
}
