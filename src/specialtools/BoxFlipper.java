package specialtools;

import Enums.Letter;
import boxes.Box;
import boxes.FixedBox;
import exceptions.UnmovableFixedBoxException;
import java.util.Scanner;
import mains.BoxGrid;


public class BoxFlipper implements SpecialTool {
    private final String name = "Box Flipper";

    @Override
    public String getName(){
        return name;
    }

    @Override
    public void useTool(BoxGrid boxGrid) {
        Scanner scanner = new Scanner(System.in);
        int row;
        int col;
        while (true) {
            System.out.print("Please enter coordinates in 'Row-Column' format (e.g., 1-2): ");
            String input = scanner.next();

            try {
                String[] parts = input.split("-");

                if (parts.length != 2) {
                    System.out.println("Invalid format! Please use a hyphen (-) between numbers. Example: 1-2");
                    continue;
                }
                row = Integer.parseInt(parts[0].trim()) - 1;
                col = Integer.parseInt(parts[1].trim()) - 1;

                if (row >= 0 && row < 8 && col >= 0 && col < 8) {
                    if(boxGrid.getBoxAt(row, col) instanceof FixedBox){
                        throw new UnmovableFixedBoxException("Fixed Boxes cannot move!");
                    }else{
                        break;
                    }
                } else {
                    System.out.println("Error: Coordinates must be between 1 and 8!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter valid numbers!");
            }  catch (UnmovableFixedBoxException e) {
                System.out.println(e.getMessage());
            }
        }
        Box Selectedbox = boxGrid.getBoxAt(row, col);
        Letter bottomLetter = Selectedbox.getBottom();
        Selectedbox.setBottom(Selectedbox.getTop());
        Selectedbox.setTop(bottomLetter);
        scanner.close();
    }
}
