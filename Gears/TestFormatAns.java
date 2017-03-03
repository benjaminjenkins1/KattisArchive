public class TestFormatAns{
  public static void main(String[] args){
    int dir = -1;
    float ratio = 3.774193548f;
    System.out.println(formatAnswer(dir, ratio));
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
