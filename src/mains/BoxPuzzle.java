package mains;
import Enums.Direction;
import Enums.Letter;
import boxes.FixedBox;
import boxes.RegularBox;
import boxes.UnchangingBox;
import exceptions.BoxAlreadyFixedException;
import exceptions.EmptyBoxException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import specialtools.SpecialTool;

public class BoxPuzzle {
    private BoxGrid boxGrid;
    private ArrayList<ArrayList<Integer>> gridMapping;
    private Random rand;

    

    public BoxPuzzle(){
        this.boxGrid = new BoxGrid(8,8);
        this.rand = new Random();
        this.gridMapping = new ArrayList<>();
        int numberOfTurns = 4;
        
        for (int i = 0; i < 8; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                row.add(null);
            }
            gridMapping.add(row);
        }
    }
    
    int row;
    int col;
    Scanner scanner = new Scanner(System.in);

    public void generate() throws EmptyBoxException, InterruptedException{
            int numberOfTurns = 4;
            System.out.println("Welcome to Box Top Side Matching Puzzle App. An 8x8 box grid is being generated.");
            Thread.sleep(2000); 
            System.out.println("\nYour goal is to maximize the letter '"+boxGrid.getTargetLetter() +"' on the top sides of the boxes.\r");
            Thread.sleep(2000); 
            System.out.print("\nTHE BOX GRİD İS BEİNG CREATED, THE GAME İS STARTİNG");
            
            try {
                for(int i=0; i<5; i++){
                Thread.sleep(600); 
                System.out.print(".");
            }
            }catch (Exception e) {
            }
            System.out.println("");
            
            this.boxGrid = generateBoxes();
            boxGrid.printMapSlow();
            for(int turn = 1; turn<=numberOfTurns; turn++){

                try{
                    if(turn!=1){
                        boxGrid.printMap();
                    }

                
                System.out.println("=====> TURN "+ turn +":\n");
                Thread.sleep(1000);
                int input = askObserveSurfaces();
                if(input == 1){
                    System.out.println("Please enter the location of the box you want to view.");
                    requestCoordinate();
                    System.out.print("Observing selected box");
                    for(int i=0; i<4; i++){
                        Thread.sleep(500); 
                        System.out.print(".");
                    }
                    System.out.println();
                    boxGrid.getBoxAt(row, col).observeSurfaces();
                }
                System.out.println("=====> TURN "+ turn +"- FIRST STAGE:\n");
                Thread.sleep(1000);    
                System.out.println("Please enter the location of the edge box you want to roll.");
                requestCoordinate();
                int rowTemp = row;
                int columnTemp = col;
                while(row != 0 && row != 7 && col != 0 && col != 7){
                    System.out.println("INCORRECT INPUT: The chosen box is not on any of the edges. Please reenter the location");
                    requestCoordinate();
                    rowTemp = row;
                    columnTemp = col;
                }
                    if(row>=1 & row<=6 & col == 0){
                        boxGrid.getBoxAt(row, col).slide(Direction.RIGHT, boxGrid,row,col);
                        System.out.print("The chosen box and any box on its path have been rolled to the right. The new state of the box grid:");
                        for(int i=0; i<5; i++){
                            Thread.sleep(600); 
                            System.out.print(".");
                        }
                        System.out.println();
                        boxGrid.printMap();

                        System.out.println("=====> TURN "+ turn +"– SECOND STAGE:\n");
                        Thread.sleep(1000);
                        System.out.println("Please enter the location of the box you want to open:");
                        requestCoordinate();
                        while(row != rowTemp ){
                            System.out.println("INCORRECT INPUT: The chosen box was not rolled during the first stage. Please reenter the location:");
                            requestCoordinate();
                        }
                        SpecialTool acquariedTool = boxGrid.getBoxAt(row, col).open();
                        Thread.sleep(500);
                        useTool(acquariedTool);
                        
                    }else if(row>=1 & row<=6 & col == 7){
                        boxGrid.getBoxAt(row, col).slide(Direction.LEFT, boxGrid,row,col);
                        System.out.print("The chosen box and any box on its path have been rolled to the left. The new state of the box grid:");
                        for(int i=0; i<5; i++){
                            Thread.sleep(600); 
                            System.out.print(".");
                        }
                        System.out.println();
                        boxGrid.printMap();

                        System.out.println("=====> TURN "+ turn +"– SECOND STAGE:\n");
                        Thread.sleep(1000);
                        System.out.println("Please enter the location of the box you want to open:");
                        requestCoordinate();
                        while(row != rowTemp ){
                            System.out.println("INCORRECT INPUT: The chosen box was not rolled during the first stage. Please reenter the location:");
                            requestCoordinate();
                        }
                        SpecialTool acquariedTool = boxGrid.getBoxAt(row, col).open();
                        Thread.sleep(500);
                        useTool(acquariedTool);

                    }else if(col>=1 & col<=6 & row == 0){
                        boxGrid.getBoxAt(row, col).slide(Direction.DOWN, boxGrid,row,col);
                        System.out.print("The chosen box and any box on its path have been rolled to the down. The new state of the box grid:");
                        for(int i=0; i<5; i++){
                            Thread.sleep(600); 
                            System.out.print(".");
                        }
                        System.out.println();
                        boxGrid.printMap();

                        System.out.println("=====> TURN "+ turn +"– SECOND STAGE:\n");
                        Thread.sleep(1000); 
                        System.out.println("Please enter the location of the box you want to open:");
                        requestCoordinate();
                        while(col != columnTemp ){
                            System.out.println("INCORRECT INPUT: The chosen box was not rolled during the first stage. Please reenter the location:");
                            requestCoordinate();
                        }
                        SpecialTool acquariedTool = boxGrid.getBoxAt(row, col).open();
                        Thread.sleep(500); 
                        useTool(acquariedTool);
                        
                    }else if(col>=1 & col<=6 & row == 7){
                        boxGrid.getBoxAt(row, col).slide(Direction.UP, boxGrid,row,col);
                        System.out.print("The chosen box and any box on its path have been rolled to the UP. The new state of the box grid:");
                        for(int i=0; i<5; i++){
                            Thread.sleep(600); 
                            System.out.print(".");
                        }
                        System.out.println();
                        boxGrid.printMap();

                        System.out.println("=====> TURN "+ turn +"– SECOND STAGE:\n");
                        Thread.sleep(1000); 
                        System.out.println("Please enter the location of the box you want to open:");
                        requestCoordinate();
                        while(col != columnTemp ){
                            System.out.println("INCORRECT INPUT: The chosen box was not rolled during the first stage. Please reenter the location:");
                            requestCoordinate();
                        }
                        SpecialTool acquariedTool = boxGrid.getBoxAt(row, col).open();
                        Thread.sleep(500); 
                        useTool(acquariedTool);

                    }else if(row == 7 & col == 0){   // Left Bottom Corner
                        int directioninput = askDirectionForLeftBottomCorner();
                        if(directioninput==1){
                            boxGrid.getBoxAt(row, col).slide(Direction.RIGHT, boxGrid,row,col);
                            System.out.print("The chosen box and any box on its path have been rolled to the right. The new state of the box grid:");
                            for(int i=0; i<5; i++){
                                Thread.sleep(600); 
                                System.out.print(".");
                            }
                            System.out.println();
                            boxGrid.printMap();

                            System.out.println("=====> TURN "+ turn +"– SECOND STAGE:\n");
                            Thread.sleep(1000); 
                            System.out.println("Please enter the location of the box you want to open:");
                            requestCoordinate();
                            while(row != rowTemp ){
                                System.out.println("INCORRECT INPUT: The chosen box was not rolled during the first stage. Please reenter the location:");
                                requestCoordinate();
                            }
                            SpecialTool acquariedTool = boxGrid.getBoxAt(row, col).open();
                            Thread.sleep(500); 
                            useTool(acquariedTool);
                        }else{
                            boxGrid.getBoxAt(row, col).slide(Direction.UP, boxGrid,row,col);
                            System.out.print("The chosen box and any box on its path have been rolled to the UP. The new state of the box grid:");
                            for(int i=0; i<5; i++){
                                Thread.sleep(600); 
                                System.out.print(".");
                            }
                            System.out.println();
                            boxGrid.printMap();

                            System.out.println("=====> TURN "+ turn +"– SECOND STAGE:\n");
                            Thread.sleep(1000); 
                            System.out.println("Please enter the location of the box you want to open:");
                            requestCoordinate();
                            while(col != columnTemp ){
                                System.out.println("INCORRECT INPUT: The chosen box was not rolled during the first stage. Please reenter the location:");
                                requestCoordinate();
                            }
                            SpecialTool acquariedTool = boxGrid.getBoxAt(row, col).open();
                            Thread.sleep(500); 
                            useTool(acquariedTool);
                        }
                    }else if(row == 7 & col == 7){ // Right Bottom Corner
                        int directioninput = askDirectionForRightBottomCorner();
                        if(directioninput==1){
                            boxGrid.getBoxAt(row, col).slide(Direction.LEFT, boxGrid,row,col);
                            System.out.print("The chosen box and any box on its path have been rolled to the left. The new state of the box grid:");
                            for(int i=0; i<5; i++){
                                Thread.sleep(600); 
                                System.out.print(".");
                            }
                            System.out.println();
                            boxGrid.printMap();

                            System.out.println("=====> TURN "+ turn +"– SECOND STAGE:\n");
                            Thread.sleep(1000); 
                            System.out.println("Please enter the location of the box you want to open:");
                            requestCoordinate();
                            while(row != rowTemp ){
                                System.out.println("INCORRECT INPUT: The chosen box was not rolled during the first stage. Please reenter the location:");
                                requestCoordinate();
                            }
                            SpecialTool acquariedTool = boxGrid.getBoxAt(row, col).open();
                            Thread.sleep(500); 
                            useTool(acquariedTool);

                        }else{
                            boxGrid.getBoxAt(row, col).slide(Direction.UP, boxGrid,row,col);
                            System.out.print("The chosen box and any box on its path have been rolled to the UP. The new state of the box grid:");
                            for(int i=0; i<5; i++){
                                Thread.sleep(600); 
                                System.out.print(".");
                            }
                            System.out.println();
                            boxGrid.printMap();

                            System.out.println("=====> TURN "+ turn +"– SECOND STAGE:\n");
                            Thread.sleep(1000); 
                            System.out.println("Please enter the location of the box you want to open:");
                            requestCoordinate();
                            while(col != columnTemp ){
                                System.out.println("INCORRECT INPUT: The chosen box was not rolled during the first stage. Please reenter the location:");
                                requestCoordinate();
                            }
                            SpecialTool acquariedTool = boxGrid.getBoxAt(row, col).open();
                            Thread.sleep(500); 
                            useTool(acquariedTool);
                        }
                    }else if (row == 0 & col == 0) {    // Left Top corner
                        int directioninput = askDirectionForLeftTopCorner();
                        if(directioninput==1){
                            boxGrid.getBoxAt(row, col).slide(Direction.RIGHT, boxGrid,row,col);
                            System.out.print("The chosen box and any box on its path have been rolled to the right. The new state of the box grid:");
                            for(int i=0; i<5; i++){
                                Thread.sleep(600); 
                                System.out.print(".");
                            }
                            System.out.println();
                            boxGrid.printMap();

                            System.out.println("=====> TURN "+ turn +"– SECOND STAGE:\n");
                            Thread.sleep(1000); 
                            System.out.println("Please enter the location of the box you want to open:");
                            requestCoordinate();
                            while(row != rowTemp ){
                                System.out.println("INCORRECT INPUT: The chosen box was not rolled during the first stage. Please reenter the location:");
                                requestCoordinate();
                            }
                            SpecialTool acquariedTool = boxGrid.getBoxAt(row, col).open();
                            Thread.sleep(500); 
                            useTool(acquariedTool);
                        }else{
                            boxGrid.getBoxAt(row, col).slide(Direction.DOWN, boxGrid,row,col);
                            System.out.print("The chosen box and any box on its path have been rolled to the down. The new state of the box grid:");
                            for(int i=0; i<5; i++){
                                Thread.sleep(600); 
                                System.out.print(".");
                            }
                            System.out.println();
                            boxGrid.printMap();

                            System.out.println("=====> TURN "+ turn +"– SECOND STAGE:\n");
                            Thread.sleep(1000); 
                            System.out.println("Please enter the location of the box you want to open:");
                            requestCoordinate();
                            while(col != columnTemp ){
                                System.out.println("INCORRECT INPUT: The chosen box was not rolled during the first stage. Please reenter the location:");
                                requestCoordinate();
                            }
                            SpecialTool acquariedTool = boxGrid.getBoxAt(row, col).open();
                            Thread.sleep(500); 
                            useTool(acquariedTool);
                        }
                    }else if(row == 0 & col == 7){  // Right Top Corner
                        int directioninput = askDirectionForRightTopCorner();
                        if(directioninput==1){
                            boxGrid.getBoxAt(row, col).slide(Direction.LEFT, boxGrid,row,col);
                            System.out.print("The chosen box and any box on its path have been rolled to the left. The new state of the box grid:");
                            for(int i=0; i<5; i++){
                                Thread.sleep(600); 
                                System.out.print(".");
                            }
                            System.out.println();
                            boxGrid.printMap();

                            System.out.println("=====> TURN "+ turn +"– SECOND STAGE:\n");
                            Thread.sleep(1000); 
                            System.out.println("Please enter the location of the box you want to open:");
                            requestCoordinate();
                            while(row != rowTemp ){
                                System.out.println("INCORRECT INPUT: The chosen box was not rolled during the first stage. Please reenter the location:");
                                requestCoordinate();
                            }
                            SpecialTool acquariedTool = boxGrid.getBoxAt(row, col).open();
                            Thread.sleep(500); 
                            useTool(acquariedTool);
                        }else{
                            boxGrid.getBoxAt(row, col).slide(Direction.DOWN, boxGrid,row,col);
                            System.out.print("The chosen box and any box on its path have been rolled to the down. The new state of the box grid:");
                            for(int i=0; i<5; i++){
                                Thread.sleep(600); 
                                System.out.print(".");
                            }
                            System.out.println();
                            boxGrid.printMap();
                            
                            System.out.println("=====> TURN "+ turn +"– SECOND STAGE:\n");
                            Thread.sleep(1000); 
                            System.out.println("Please enter the location of the box you want to open:");
                            requestCoordinate();
                            while(col != columnTemp ){
                                System.out.println("INCORRECT INPUT: The chosen box was not rolled during the first stage. Please reenter the location:");
                                requestCoordinate();
                            }
                            SpecialTool acquariedTool = boxGrid.getBoxAt(row, col).open();
                            Thread.sleep(500); 
                            useTool(acquariedTool);
                        }
                    }
            

                }catch (EmptyBoxException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Turn Wasted.");
                }catch (BoxAlreadyFixedException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Turn Wasted.");
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        try {
            System.out.println("\n******** GAME OVER ********\n");
            System.out.println("The final state of the box grid:");
            for(int i=0; i<4; i++){
                Thread.sleep(600); 
                System.out.print(".");
            }
            System.out.println();
            boxGrid.printMap();
            int targetLetterNumber=0;
            for(int r = 0; r<boxGrid.getNumberOfRows(); r++){
                for(int c = 0; c<boxGrid.getNumberOfColumns(); c++){
                    if(boxGrid.getBoxAt(r, c).getTop() == boxGrid.getTargetLetter()){
                        targetLetterNumber++;
                    }
                }
            }
            System.out.print("CALCULATING RESULTS");
            for(int i=0; i<4; i++){
            Thread.sleep(800); 
            System.out.print(".");
        }
        System.out.println();
        System.out.println("THE TOTAL NUMBER OF TARGET LETTER '"+boxGrid.getTargetLetter()+"' IN THE BOX GRID --> "+targetLetterNumber);
        System.out.println("\nThe game has been SUCCESSFULLY completed!\r");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }       
    }

    public <T extends SpecialTool> void useTool(T tool) throws BoxAlreadyFixedException {
        tool.useTool(this.boxGrid); 
    }

    public int askObserveSurfaces(){
        int input;
        while (true) { 
            System.out.print("---> Do you want to view all surfaces of a box? [1] Yes or [2] No? ");
            try {
                input = scanner.nextInt();
                if (input == 1 || input == 2) {
                    return input;
                } else {
                    System.out.println("Please enter 1 or 2 !");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); 
            }
        }
    }

    public int askDirectionForRightTopCorner(){
        int input;
        while (true) { 
            System.out.print("The chosen box can be rolled to either [1] left or [2] downwards: ");
            try {
                input = scanner.nextInt();
                if (input == 1 || input == 2) {
                    return input;
                } else {
                    System.out.println("Please enter 1 or 2 !");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); 
            }
        }
    }

    public int askDirectionForLeftTopCorner(){
        int input;
        while (true) { 
            System.out.print("The chosen box can be rolled to either [1] right or [2] downwards: ");
            try {
                input = scanner.nextInt();
                if (input == 1 || input == 2) {
                    return input;
                } else {
                    System.out.println("Please enter 1 or 2 !");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); 
            }
        }
    }

    public int askDirectionForRightBottomCorner(){
        int input;
        while (true) { 
            System.out.print("The chosen box can be rolled to either [1] left or [2] upwards: ");
            try {
                input = scanner.nextInt();
                if (input == 1 || input == 2) {
                    return input;
                } else {
                    System.out.println("Please enter 1 or 2 !");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); 
            }
        }
    }

    public int askDirectionForLeftBottomCorner(){
        int input;
        while (true) { 
            System.out.print("The chosen box can be rolled to either [1] right or [2] upwards: ");
            try {
                input = scanner.nextInt();
                if (input == 1 || input == 2) {
                    return input;
                } else {
                    System.out.println("Please enter 1 or 2 !");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); 
            }
        }
    }

    public void requestCoordinate(){
        while (true) {
                System.out.print("(Please enter coordinates in 'Row-Column' format (e.g., 1-2)) ");
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
                }catch (NumberFormatException e) {
                    System.out.println("Error: Please enter valid numbers!");
                }
            }
    }

    public BoxGrid generateBoxes(){

        for(int x = 0; x<boxGrid.getNumberOfRows(); x++){
            for(int y = 0; y<boxGrid.getNumberOfColumns(); y++){
                int number = rand.nextInt(1, 21);
                if(number<=17){      // % 85 to be generated

                    Letter[] letters = Letter.generateRandomFaces();
                    RegularBox regularBox = new RegularBox(letters[0], letters[1], letters[2], letters[3], letters[4], letters[5]);
                    boxGrid.addBox(x,y, regularBox);

                }else if(number>17 & number<=19){    // % 10 to be generated

                    Letter[] letters = Letter.generateRandomFaces();
                    UnchangingBox unchangingBox  = new UnchangingBox(letters[0], letters[1], letters[2], letters[3], letters[4], letters[5]);
                    boxGrid.addBox(x,y, unchangingBox);

                }else{          // % 5 to be generated

                    Letter[] letters = Letter.generateRandomFaces();
                    FixedBox fixedBox  = new FixedBox(letters[0], letters[1], letters[2], letters[3], letters[4], letters[5]);
                    boxGrid.addBox(x,y, fixedBox);  

                }
            }
        }
    return boxGrid;
    }
}
