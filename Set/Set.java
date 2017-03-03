
import java.util.Scanner;
import java.util.ArrayList;

public class Set{
  public static void main(String[] args){
    Scanner io = new Scanner(System.in);
    char[][] inputChars = new char[12][4];
    for(int i=0; i<12; i++){
      inputChars[i] = io.next().toCharArray();
    }
    int num = 0;
    ArrayList<int[]> sets = new ArrayList<int[]>();
    for(int i=0; i<12; i++){
      for(int j=i+1; j<12; j++){
        for(int k=j+1; k<12; k++){
          boolean set = true;
          for(int l=0; l<4; l++){
            if(!(inputChars[i][l] != inputChars[j][l] && (inputChars[j][l] != inputChars[k][l] && inputChars[i][l] != inputChars[k][l])) && !(inputChars[i][l] == inputChars[j][l] && inputChars[j][l] == inputChars[k][l])){
              set = false;
            }
          }
          if(set == true){
            int one = i+1;
            int two = j+1;
            int three = k+1;
            System.out.println(one+" "+two+" "+three);
            num ++;
          }
        }
      }
    }
    if(num == 0){
      System.out.println("no sets");
    }
  }
}
