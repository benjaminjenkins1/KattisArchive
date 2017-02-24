import java.util.*;
import java.io.*;

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

    //debug only
    for(float[] gear : gearList){
      System.out.println("Read: "+gear[0]+", "+gear[1]+", "+gear[2]+", ");
    }

    boolean isLocked = false;

    //set origin turning cw (1) at ratio 1
    //3 - direction
    //4 - ratio
    gearList.get(0)[3] = 1;
    gearList.get(0)[4] = 1;

    for(int i=0; i<gearList.size(); i++){
      for(int j=0; j<gearList.size(); j++){
        if(i != j){
          boolean isTangent = checkTangent(gearList.get(i), gearList.get(j));
          if(isTangent && gearList.get(i)[3] != gearList.get(j)[3]){
            System.out.println("Gear "+i+" is tangent to gear "+j+" and not turning the same direction.");
            //set direction and ratio
            gearList.get(j)[3] = gearList.get(i)[3] * -1;
            gearList.get(j)[4] = gearList.get(i)[4] * gearList.get(i)[2] /
                gearList.get(j)[2];
          }
          else if(isTangent && gearList.get(i)[3] == gearList.get(j)[3]){
            System.out.println("Gear "+i+" was turning the same direction as gear "+j+" so the system is now locked.");
            isLocked = true;
            break;
          }
        }
      }
    }
  }

  public static boolean checkTangent(float[] first, float[] second){
    float x1 = first[0];
    float x2 = second[0];
    float y1 = first[1];
    float y2 = second[1];
    int radiusSum = (int) (first[2]+second[2]);
    System.out.println("Sum of radii is "+radiusSum);
    double distance = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
    System.out.println("Distance is "+distance);
    int distAsInt = (int) Math.round(distance);
    if(distAsInt == radiusSum){
      System.out.println("Gear was tangent.");
      return true;
    }
    else{
      System.out.println("Gear was not tangent.");
      return false;
    }
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
