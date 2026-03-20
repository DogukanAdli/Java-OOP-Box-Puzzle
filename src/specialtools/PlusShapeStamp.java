package specialtools;

import java.util.Scanner;
import mains.BoxGrid;


public class PlusShapeStamp implements SpecialTool{
    private final String name = "Plus Shape Stamp";

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
                    break;
                } else {
                    System.out.println("Error: Coordinates must be between 1 and 8!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter valid numbers!");
            }
        }
        
        boxGrid.getBoxAt(row, col).setTop(boxGrid.getTargetLetter());   // For itself

        if(row + 1 == 8 ){          // For bottom 
            // Do nothing
        }else{
            boxGrid.getBoxAt(row + 1, col).setTop(boxGrid.getTargetLetter());
        }
        
        if(row - 1 == -1 ){         // For Top
            // // Do nothing
        }else{
            boxGrid.getBoxAt(row - 1, col).setTop(boxGrid.getTargetLetter());
        }

        if(col + 1 == 8 ){          // For Right
            // Do nothing
        }else{
            boxGrid.getBoxAt(row, col + 1).setTop(boxGrid.getTargetLetter());
        }

        if(col - 1 == -1 ){          // For Left
            // Do nothing
        }else{
            boxGrid.getBoxAt(row, col - 1).setTop(boxGrid.getTargetLetter());
        }
        scanner.close();
    }
    
    @Override
    public String getName(){
        return name;
    }
}
