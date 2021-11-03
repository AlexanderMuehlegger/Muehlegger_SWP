public class SummenFunktion {
    
    public static void main(String[] args){
        long timeRekurStart, timeRekurStop, timeIterStart, timeIterStop;
        SummenFunktion summ = new SummenFunktion();
        

        timeRekurStart = System.nanoTime();
        System.out.println(summ.rekursivSum(10000));
        timeRekurStop = System.nanoTime();
        timeIterStart = System.nanoTime();
        System.out.println(summ.iterativSum(10000));
        timeIterStop = System.nanoTime();

        System.out.printf("Zeit der Rekursiven-Methode: %d µs\nZeit der Iterativen-Methode: %d µs\n",(timeRekurStop-timeRekurStart)/1000, (timeIterStop-timeIterStart)/1000);
    }

    private int rekursivSum(int length){
        
        if(length == 0)
            return 0;

        return (length-1)+rekursivSum(length-1);   
    }

    private int iterativSum(int length){
        int result = 0;
        for(int i = 0; i < length; i++){
            result += i;
        }

        return result;
    }

}
