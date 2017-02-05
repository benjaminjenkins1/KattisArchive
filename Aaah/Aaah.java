import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Aaah {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        

        int Jon = reader.readLine().length();
        int Doc = reader.readLine().length();
        

        if(Doc <= Jon){
            System.out.println("go");
        }
        else{
            System.out.println("no");
        }
        
    }
}