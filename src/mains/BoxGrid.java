package mains;
import Enums.Letter;
import boxes.Box;
import java.util.ArrayList;
/*
 * ANSWER TO COLLECTIONS QUESTION: 
 * I chose to use a nested ArrayList structure (List<List<Box>>) to represent the 8x8 grid. 
 * Since the grid requires frequent access to specific boxes by their row and column indices 
 * to handle the rolling logic and check neighbors, ArrayList is the optimal choice due to 
 * its O(1) random access time performance. Unlike LinkedList, which is slower for positional 
 * access, ArrayList efficiently simulates a 2D matrix while adhering to the Collections 
 * Framework requirement.
 */
public class BoxGrid {
    private final ArrayList<ArrayList<Box>> grid;
    private final int row;
    private final int column;
    private Letter targetLetter;

    public BoxGrid(int row , int column){
        this.row=row;
        this.column=column;
        this.grid= new ArrayList<>();
        this.targetLetter = Letter.getRandomLetter();
        for(int i = 0 ; i<row ;i++){
            ArrayList<Box> tList = new ArrayList<>();
            for(int j = 0 ; j <column ;j++){
                tList.add(null);
            }
            grid.add(tList);
        }
    }
    public Box addBox(int x , int y , Box box){
        if(x>= 0 && x<row && y>= 0 &&y<column ){
            if(grid.get(x).get(y)== null){
               grid.get(x).set(y ,box);
        }else System.out.println("Full !" + grid.get(x).get(y).toString());
            return grid.get(x).get(y);
        }
        else System.out.println("Out of grid");
        return null;
    }
    public void removeBoxAt(int x , int y){
        if(x>= 0 && x<row && y>= 0 &&y<column ){
            if(grid.get(x).get(y) != null){
               grid.get(x).set(y ,null);
            }else{
                System.out.println("Out of grid");
            }
        }
    }

    public void printMap() {
    try{
    System.out.print("      "); 
    for (int k = 1; k <= column; k++) {
        System.out.print("   C" + k + "    ");
        Thread.sleep(10);
    }
    System.out.println();
    for (int i = 0; i < row; i++) {
        drawHorizontalLine();
        Thread.sleep(10);
        System.out.print(" R" + (i + 1) + "   "); 
        Thread.sleep(10);
        for (int j = 0; j < column; j++) {
            System.out.print("|"); // Sol duvar
            Thread.sleep(10);
            if (grid.get(i).get(j) != null) {
                 // String ortalı görünsün diye boşluk ayarı
                System.out.print(" " + grid.get(i).get(j).getSymbol() + "  ");
                Thread.sleep(10);
            } else {
                System.out.print("       "); // Boşsa boşluk
            }
        }
        System.out.println("|"); // Satır sonu duvarı
        Thread.sleep(10);
    }
    // En alt çizgi
    drawHorizontalLine();
    }catch(Exception e){

    }
}
    public void printMapSlow() {
    try{
    System.out.print("      "); 
    for (int k = 1; k <= column; k++) {
        System.out.print("   C" + k + "    ");
        Thread.sleep(50);
    }
    System.out.println();
    for (int i = 0; i < row; i++) {
        drawHorizontalLine();
        Thread.sleep(50);
        System.out.print(" R" + (i + 1) + "   "); 
        Thread.sleep(50);
        for (int j = 0; j < column; j++) {
            System.out.print("|"); // Sol duvar
            Thread.sleep(50);
            if (grid.get(i).get(j) != null) {
                 // String ortalı görünsün diye boşluk ayarı
                System.out.print(" " + grid.get(i).get(j).getSymbol() + "  ");
                Thread.sleep(50);
            } else {
                System.out.print("       "); // Boşsa boşluk
            }
        }
        System.out.println("|"); // Satır sonu duvarı
        Thread.sleep(50);
    }
    // En alt çizgi
    drawHorizontalLine();
    }catch(Exception e){

    }
}
    private void drawHorizontalLine() {
        System.out.print("     ");
        for (int k = 0; k < column; k++) {
            System.out.print("---------");
        }
        System.out.println();
    }
    
    public Box getBoxAt(int row, int col){
        if((row< 0 || row>=8) || ((col)< 0 || (col)>=8)){
            return null;
        }else{
            return grid.get(row).get(col);
        }
    }
    public ArrayList<ArrayList<Box>> getGrid(){
        return  grid;
    }
    public int getNumberOfRows(){
        return row;
    }
    public int getNumberOfColumns(){
        return column;
    }
    public Letter getTargetLetter(){
        return targetLetter;
    }
}
