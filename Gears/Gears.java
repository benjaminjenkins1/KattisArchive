import java.util.*;
import java.io.*;
import java.math.*;

public class Gears{
  public static void main(String[] args){
    Kattio io = new Kattio(System.in, System.out);
    int numberOfGears = io.getInt();
    List<float[]> gearList = new ArrayList<float[]>();

    for(int i=0; i<numberOfGears; i++){
      float[] gear = new float[5];
      gear[0] = io.getInt();
      gear[1] = io.getInt();
      gear[2] = io.getInt();
      gear[3] = 0;
      gearList.add(gear);
    }

    boolean isLocked = false;

    //set origin turning cw (1) at ratio 1
    //3 - direction
    //4 - ratio
    gearList.get(0)[3] = 1;
    gearList.get(0)[4] = 1;

    for(int i=0; i<gearList.size(); i++){
      //System.out.println("Examining gear "+i);
      for(int j=0; j<gearList.size(); j++){
        if(i != j){
          //System.out.println("--Checking gear "+i+" against gear "+j);
          boolean isTangent = checkTangent(gearList.get(i), gearList.get(j));
          if(isTangent && gearList.get(i)[3] != gearList.get(j)[3]){
            //System.out.println("----Gear "+i+" is tangent to gear "+j+" and not turning the same direction.");
            //set direction
            gearList.get(j)[3] = gearList.get(i)[3] * -1;
            //System.out.println("------Gear "+j+" direction set to "+gearList.get(j)[3]);
            //set ratio
            gearList.get(j)[4] = gearList.get(i)[4] * gearList.get(i)[2] /
                gearList.get(j)[2];
            //System.out.println("------Gear "+j+" ratio set to "+gearList.get(j)[4]);
          }
          else if(isTangent && gearList.get(i)[3] == gearList.get(j)[3]){
            //System.out.println("----Gear "+i+" was turning the same direction as gear "+j+" so the system is now locked.");
            isLocked = true;
            break;
          }
          }
        }
      }
    }

    if(isLocked){
      System.out.println("-1");
    }
    else if(gearList.get(gearList.size() - 1)[3] == 0){
      System.out.println("0");
    }
    else{
      int targetDirection = (int) gearList.get(gearList.size() - 1)[3];
      float targetRatio = gearList.get(gearList.size() - 1)[4];
      //System.out.println(targetDirection);
      System.out.println(formatAnswer(targetDirection, targetRatio));
    }

  }

  public static boolean checkTangent(float[] first, float[] second){
    float x1 = first[0];
    float x2 = second[0];
    float y1 = first[1];
    float y2 = second[1];
    int radiusSum = (int) (first[2]+second[2]);
    //System.out.println("Sum of radii is "+radiusSum);
    double distance = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
    //System.out.println("Distance is "+distance);
    int distAsInt = (int) Math.round(distance);
    if(distAsInt == radiusSum){
      //System.out.println("a gear was tangent.");
      return true;
    }
    else{
      //System.out.println("a gear was not tangent.");
      return false;
    }
  }

  public static String formatAnswer(int direction, float ratio){
    float factor = 1;
    for(int i=1; i<100000; i++){
      if((i * ratio) % 1 == 0){
        factor = i;
        break;
      }
    }
    return((int) factor+" "+(int)(factor*ratio*direction));
  }
}


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
