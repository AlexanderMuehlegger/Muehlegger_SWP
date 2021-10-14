import java.sql.Date;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class binarySearch {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int toFind = -1;
    int[] zahlen;
    String result, result2;
    long timeStart, timeStop;

    System.out.print("Geben sie die Länge der Array ein: ");
    int length = scanner.nextInt();
    zahlen = new int[length];

    for(int i = 0; i < length; i++){
      zahlen[i] = i;
    }
    
    System.out.println("Array erstellt!");

    while (true) {
      System.out.print("Geben Sie die zu suchende Zahl ein:");

      try {
        toFind = Integer.parseInt(scanner.next());
      } catch (Exception e) {
        e.printStackTrace();
      }

      timeStart = System.currentTimeMillis();
      result = String.valueOf(iterativBinarySearch(zahlen, toFind) + 1);
      timeStop = System.currentTimeMillis();

      result2 = String.valueOf(iterativeSearch(zahlen, toFind));

      if (result.equals("-1")) {
        System.out.println("Die Zahl ist im Array nicht vorhanden!");
      } else {
        System.out.printf("\nDie Zahl: %d wurde am Index: %s gefunden!", toFind, result);
        System.out.printf("\nDie Binäre Suche hat %d Millisekunden benötigt.", (timeStop - timeStart));
        System.out.printf("\nDie iterative Suche hat %s Millisekunden benötigt.", result2);
        break;
      }
    }

    scanner.close();

  }

  public static int iterativBinarySearch(int[] array, int toFind) {
    return iterativBinarySearch(array, 0, array.length, toFind);
  }

  public static int iterativBinarySearch(int[] array, int fromIndex, int toIndex, int toFind) {
    int low = fromIndex;
    int high = toIndex;

    while (low < high) {
      int mid = (low + high) >>> 1;
      int midVal = array[mid];

      if (toFind == midVal) {
        return mid;
      } else if (toFind < midVal) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }

    return -1;
  }


  private static int iterativeSearch(int[] array, int toFind){
    boolean found = false;
    long timeStart = System.currentTimeMillis();
    for(int i = 0; i < array.length; i++){
      if(array[i] == toFind){
        found = true;
        break;
      }
    }
    long timeStop = System.currentTimeMillis();

    if(found){
      return (int)(timeStop - timeStart);
    }else{
      return -1;
    }
  }

}