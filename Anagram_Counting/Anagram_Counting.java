import java.util.Scanner;
import java.math.BigInteger;

public class Anagram_Counting {
    static BigInteger fact(int in){
        BigInteger result = BigInteger.valueOf(1);
        for(int i=1; i <= in; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
    static BigInteger count(String in){
        BigInteger numerator = fact(in.length());
        BigInteger denominator = BigInteger.valueOf(1);
        String first;
        int occurrences;
        while(in.length() > 0){
            occurrences = 1;
            first = String.valueOf(in.charAt(0));
            occurrences = in.length() - in.replace(first,"").length();
            in = in.replace(first,"");
            denominator = denominator.multiply(fact(occurrences));
        }
        return numerator.divide(denominator);
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        try 
        {
            while (scan.hasNextLine())
            {
                String line = scan.nextLine();
            System.out.println(count(line));    
        }
        } 
        finally 
        {
            if (scan != null)
            {scan.close();}
        }
    }
}