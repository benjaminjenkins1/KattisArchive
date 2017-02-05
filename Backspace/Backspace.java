import java.util.Scanner;

public class Backspace {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] arr = line.toCharArray();
        int count = 0;
        for(int i = arr.length -1; i>=0; i--){
            if(arr[i] == '<'){
                arr[i] = ' ';
                count ++;
            }
            else if(count > 0){
                arr[i] = ' ';
                count --;
            }
        }
        line = new String(arr);
        System.out.println(line.replaceAll(" ",""));
    }
}