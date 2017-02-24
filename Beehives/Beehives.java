import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class Beehives{
  public static void main( String[] args ){
    //read input
    Kattio io = new Kattio(System.in);
    Double minDistance = 1.0;
    int n = 1;
    while(n != 0 && minDistance != 0.0){
      minDistance = io.getDouble();
      n = io.getInt();
      if(n != 0 && minDistance != 0.0){
        Double[] positions = new Double[2*n];
        for(int i=0; i<2*n; i+=2){
          positions[i] = io.getDouble();
          positions[i+1] = io.getDouble();
        }

        int sweet = 0;
        int sour = 0;

        Double distance = 0.0;
        String sweetSour = null;
        for(int i=0; i<2*n; i+=2){
          sweetSour = "sweet";
          for(int j=0; j<2*n; j+=2){
            distance = Math.sqrt((positions[j]-positions[i])*(positions[j]-positions[i])+(positions[j+1]-positions[i+1])*(positions[j+1]-positions[i+1]));
            if(distance < minDistance && distance != 0.0){
              sweetSour = "sour";
            }
          }
          if(sweetSour == "sour") sour ++;
          else sweet ++;
        }

        System.out.println(sour+" sour, "+sweet+" sweet");
      }
    }
    io.close();
  }
}






//############## Kattio #################
//
//
// class Kattio extends PrintWriter {
//     public Kattio(InputStream i) {
//         super(new BufferedOutputStream(System.out));
//         r = new BufferedReader(new InputStreamReader(i));
//     }
//     public Kattio(InputStream i, OutputStream o) {
//         super(new BufferedOutputStream(o));
//         r = new BufferedReader(new InputStreamReader(i));
//     }
//
//     public boolean hasMoreTokens() {
//         return peekToken() != null;
//     }
//
//     public int getInt() {
//         return Integer.parseInt(nextToken());
//     }
//
//     public double getDouble() {
//         return Double.parseDouble(nextToken());
//     }
//
//     public long getLong() {
//         return Long.parseLong(nextToken());
//     }
//
//     public String getWord() {
//         return nextToken();
//     }
//
//
//
//     private BufferedReader r;
//     private String line;
//     private StringTokenizer st;
//     private String token;
//
//     private String peekToken() {
//         if (token == null)
//             try {
//                 while (st == null || !st.hasMoreTokens()) {
//                     line = r.readLine();
//                     if (line == null) return null;
//                     st = new StringTokenizer(line);
//                 }
//                 token = st.nextToken();
//             } catch (IOException e) { }
//         return token;
//     }
//
//     private String nextToken() {
//         String ans = peekToken();
//         token = null;
//         return ans;
//     }
// }
