import java.util.Arrays;
import java.util.Scanner;

public class binarySearch{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int toFind = -1;
        int[] zahlen = {1,2,3,5,5,8,9,9,15,22,32,51,52,53,60,64,65,66,87,354,502};
        String result;

        System.out.print("Geben Sie die zu suchende Zahl ein:");
        
        try{
            toFind = Integer.parseInt(scanner.nextLine());
        }catch(Exception e){
            e.printStackTrace();
        }

        result = String.valueOf(iterativSearch(zahlen, toFind)+1);

        if(result.equals("-1")){
            System.out.println("Die Zahl ist im Array nicht vorhanden!");
        }else{
            System.out.printf("\nDie Zahl: %d wurde am Index: %s gefunden!", toFind, result);
        }

        scanner.close();
    }

    public static int iterativSearch(int[] array, int toFind) {
        return iterativSearch(array, 0, array.length, toFind);
    }
      
      public static int iterativSearch(int[] array, int fromIndex, int toIndex, int toFind) {
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

}