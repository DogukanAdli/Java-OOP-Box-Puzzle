package boxes;
import Enums.Direction;
import Enums.Letter;
import exceptions.EmptyBoxException;
import mains.BoxGrid;
import specialtools.SpecialTool;

public class FixedBox extends Box{

    boolean isOpened = false;

    public FixedBox(Letter top, Letter bottom, Letter front, Letter back, Letter left, Letter right) {
        super(top, bottom, front, back, left, right);
        super.setSpecialtool(null);  // Fixed Boxes cannot contain special tools. 
    }

    @Override
    public void slide(Direction direction,BoxGrid boxGrid,int row,int col) {
        // Fix Boxes cannot slide!
    }

    @Override
    public SpecialTool open() throws EmptyBoxException {
        if(super.getSpecialTool() != null){
            isOpened = true;
            return super.getSpecialTool(); 
        }else{
            isOpened = true;
            throw new EmptyBoxException("Empty Box!");
        }    
    }
    public String getSymbol(){
        if(isOpened == false){
            return "X-" + getTop() + "-M";
        }else{
            return "X-" + getTop() + "-O";
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
}
