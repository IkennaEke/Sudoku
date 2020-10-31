import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Sudoku{
	protected int[][] board = new int[9][9];
	protected int n;
	private void fillBoard(){
		fillBoard(0,0);
	}
	
	private boolean fillBoard(int row, int col){
		if(row>8){
			return true;
		}
		if(col>8){
			fillBoard(row+1, 0);
		}
		else{
			Integer[] numbers = randomNumbers();
			for(int i = 0;i<9;i++){
				if(CheckRC(row, col, numbers[i])==false&&checkGrid(row, col, numbers[i])==false){
					board[row][col] = numbers[i];
					if(fillBoard(row, col+1)){
						return true;
					}
				}
				
			
			}
			board[row][col] = 0;
			return false;
		
			}
		return true;
	
		}


	
	private boolean CheckRC(int row, int col, int number){
		for(int i =0; i<9;i++){
			for(int j=0; j<9;j++){
				if(i!=row ){
					if(board[i][col]==number){
						return true;
					}
				}
				if(j!=col){
					if(board[row][j]==number){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean checkGrid(int row, int col, int number){
		int r = (row/3) *3;
		int c = (col/3) *3;
		for(int i = r; i<r+3; i++){
			for(int j = c; j<c+3; j++){
				if(!(i==row && j==col)){
					if(board[i][j]==number){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private void printBoard(){
		for(int i =0; i<9;i++){
			for(int j=0; j<9;j++){
				System.out.print(board[i][j] + " ");
				if((j+1)%3==0){
					System.out.print("| ");
				}
			}
			System.out.println();
			if((i+1)%3==0){
				for(int j=0; j<12;j++){
				System.out.print("- ");
			}
				System.out.println();
			}
		}
	}
	
	
	private Integer[] randomNumbers(){
		ArrayList<Integer> r = new ArrayList<Integer>();
		for(int i = 0; i<9; i++){
			r.add(i+1);
		}
		
		Collections.shuffle(r);
		return r.toArray(new Integer[9]);
	}
	
	public static void main(String []args){
		Sudoku sudoku = new Sudoku();
		sudoku.fillBoard();
		sudoku.printBoard();
	}
}