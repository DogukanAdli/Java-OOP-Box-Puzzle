package specialtools;

import Enums.Letter;
import boxes.Box;
import boxes.UnchangingBox;
import java.util.InputMismatchException;
import java.util.Scanner;
import mains.BoxGrid;



public class MassRowStamp implements SpecialTool{
    private final String name = "Mass Row Stamp";
    
    

    @Override
    public String getName(){
        return name;
    }

    @Override
    public void useTool(BoxGrid boxGrid) {
        
        Letter selectedLetter = null;
        int selectedRow; 
        Scanner keyboard = new Scanner(System.in);
        while (true) { 
        System.out.print("Enter a Letter ");
        String input = keyboard.next().toUpperCase();
        try {
            selectedLetter = Letter.valueOf(input);
            break;
            
        } catch (IllegalArgumentException e) {
            // 3. Eğer geçersiz bir harf (Z, X, 5 vs.) girildiyse buraya düşer
            System.out.println("Invalid input! Please enter one of the letters that  A, B, C, D, E, F, G, H.");
        }
    }
    while (true) { 
        System.out.print("Enter a row (1-8): ");
        try {
            int row = keyboard.nextInt();
            if (row >= 1 && row <= 8) {
                selectedRow =  row - 1; 
                break;
            } else {
                System.out.println("Please enter a number between 1 and 8!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a number.");
            keyboard.nextLine(); 
        }
    }

    int col = 0;
    while (col<boxGrid.getNumberOfColumns()) { 
        Box box = boxGrid.getBoxAt(selectedRow, col);
        if(box instanceof UnchangingBox){
            col++;
        }
        if(col < boxGrid.getNumberOfColumns()){     // to check if Unchancing Box is the last box.
            box = boxGrid.getBoxAt(selectedRow, col);
            box.setTop(selectedLetter);
        }
        col++;
        }
    keyboard.close();
    }
    
}
