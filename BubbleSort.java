import java.util.Random;

public class BubbleSort {
    public static void main(String[] args){
        BubbleSort bubble = new BubbleSort();
        long randomTime, manualTime, measureStart, measureStop;

        measureStart = System.nanoTime();
        int[] toSortManual = {62, 14, 88, 3, 73, 91, 81, 4, 68, 81, 4, 51, 62, 11, 50, 55, 65, 84, 72, 44, 80, 88, 64, 70, 16, 59, 51, 98, 23, 48, 31, 39, 34, 91, 74, 18, 58, 55, 66, 24, 52, 40, 28, 76, 78, 41, 48, 30, 41, 6, 14, 31, 6, 8, 23, 79, 42, 5, 67, 58, 81, 16, 51, 34, 79, 99, 21, 53, 69, 73, 19, 11, 48, 30, 25, 92, 77, 32, 39, 50, 89, 28, 19, 80, 23, 48, 73, 90, 60, 85, 11, 21, 87, 96, 56, 96, 74, 65, 0, 58, 46, 19, 70, 15, 90, 9, 57, 69, 83, 59, 81, 30, 84, 16, 82, 1, 93, 70, 46, 31, 66, 79, 67, 77, 46, 13, 32, 64, 83, 30, 40, 36, 73, 27, 63, 21, 42, 23, 38, 84, 96, 23, 9, 23, 31, 4, 36, 45, 87, 9};
        int[] sortedManual = bubble.bubbleSortInteger(toSortManual);
        measureStop = System.nanoTime();

        manualTime = measureStop - measureStart;
        
        measureStart = System.nanoTime();
        int[] toSortRandom = bubble.getRandomIntegerArray(150);
        int[] sortedRandom = bubble.bubbleSortInteger(toSortRandom);
        measureStop = System.nanoTime();

        randomTime = measureStop - measureStart;

        System.out.println("Sortieren mit bereitsvorhandenen Zahlen:");
        System.out.printf("     Zeit: %d µs", manualTime/1000);
        bubble.printArray(sortedManual);
        System.out.println("\nSortieren mit zufällig erzeugten Zahlen:");
        System.out.printf("     Zeit: %d µs", randomTime/1000);
        bubble.printArray(sortedRandom);
        
    }

    private int[] getRandomIntegerArray(final int length){
        int[] array = new int[length];
        Random r = new Random();
        for(int i = 0; i < length; i++){
            array[i] = r.nextInt(100-0)+0;
        }
        return array;
    }

    private int[] bubbleSortInteger(int[] array){
        int tempInt = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length-1; j++){
                if(array[j] > array[j+1]){
                    tempInt = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tempInt;
                }
            }
        }
        return array;
    }

    private void printArray(int[] array){
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        for(int i : array){
            builder.append(i);
            builder.append(", ");
        }
        String finished = builder.toString();
        System.out.println(finished.substring(0, finished.length()-2));        
    }
}
