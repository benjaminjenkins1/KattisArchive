import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class Bus_Numbers{
  public static void main( String[] args ){
    //read input
    Kattio io = new Kattio(System.in);
    int n = io.getInt();
    int[] busNumbers = new int[n];
    for(int i=0; i<n; i++){
      busNumbers[i] = io.getInt();
    }
    Arrays.sort(busNumbers);
    //for(int k=0; k<n; k++) {
    //  System.out.println(busNumbers[k]);
    //}
    
    int i=0;
    int last = 0;
    ArrayList<String> results = new ArrayList<String>();
    
    while(i<n){
      last = longest(busNumbers[i], busNumbers);
      if(busNumbers[i] + 1 == last){
        results.add(String.valueOf(busNumbers[i]));
        results.add(String.valueOf(last));
      }
      else if(busNumbers[i] != last){
        results.add(busNumbers[i]+"-"+last);
      }
      else results.add(String.valueOf(busNumbers[i]));
      i = java.util.Arrays.binarySearch(busNumbers, last);
      i++;
    }
    for(int j=0; j<results.size(); j++){
      System.out.print(results.get(j)+" ");
    }
    
    io.close();
  }
  static int longest(int number, int[] numbers){
    boolean contains = true;
    int last = number;
    int next = number + 1;
    while(contains == true){
      final Integer next2 = new Integer(next);
      if(IntStream.of(numbers).anyMatch(x -> x == next2)){
        last = next;
        next++;
      }
      else contains = false;
    }
    return last;
  }
}






//############## Kattio #################


class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }



    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
 