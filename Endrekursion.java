public class Endrekursion{
    
    public static void main(String[] args){
        Endrekursion endRek = new Endrekursion();
        long result, zeitStart, zeitStop;
        short fakultaetAnz = 20, sumAnz = 10000, potenz = 10;
        int potenzBase = 32767;

        //Fakultät
        zeitStart = System.nanoTime();
        result = endRek.iterativFakultaet(fakultaetAnz);
        zeitStop = System.nanoTime();
        System.out.printf("Iterativ: \t%d! = %d\tZeit: %dµs\n", fakultaetAnz, result, (zeitStop-zeitStart)/1000);

        zeitStart = System.nanoTime();
        result = endRek.rekursivFakultaet(fakultaetAnz);
        zeitStop = System.nanoTime();
        System.out.printf("Rekursiv: \t%d! = %d\tZeit: %dµs\n", fakultaetAnz, result, (zeitStop-zeitStart)/1000);

        zeitStart = System.nanoTime();
        result = endRek.endrekursivFakultaet(1, fakultaetAnz);
        zeitStop = System.nanoTime();
        System.out.printf("Endrekursiv: \t%d! = %d\tZeit: %dµs\n", fakultaetAnz, result, (zeitStop-zeitStart)/1000);

        //Summe
        zeitStart = System.nanoTime();
        result = endRek.iterativSum(sumAnz);
        zeitStop = System.nanoTime();
        System.out.printf("\nIterativ: \tsum(%d) = %d\tZeit: %dµs\n", sumAnz, result, (zeitStop-zeitStart)/1000);

        zeitStart = System.nanoTime();
        result = endRek.rekursivSum(sumAnz);
        zeitStop = System.nanoTime();
        System.out.printf("Rekursiv: \tsum(%d) = %d\tZeit: %dµs\n", sumAnz, result, (zeitStop-zeitStart)/1000);

        zeitStart = System.nanoTime();
        result = endRek.endrekursivSum(0, sumAnz);
        zeitStop = System.nanoTime();
        System.out.printf("Endrekursiv: \tsum(%d) = %d\tZeit: %dµs\n", sumAnz, result, (zeitStop-zeitStart)/1000);

        //Potenzen
        zeitStart = System.nanoTime();
        result = endRek.iterativPowfak(potenzBase, potenz);
        zeitStop = System.nanoTime();
        System.out.printf("\nIterativ: \tpowfak(%d, %d) = %d\tZeit: %dµs\n", potenzBase, potenz, result, (zeitStop-zeitStart)/1000);

        zeitStart = System.nanoTime();
        result = endRek.rekursivPowfak(potenzBase, potenz);
        zeitStop = System.nanoTime();
        System.out.printf("Rekursiv: \tpowfak(%d, %d) = %d\tZeit: %dµs\n", potenzBase, potenz, result, (zeitStop-zeitStart)/1000);

        zeitStart = System.nanoTime();
        result = endRek.endrekursivPowfak(1, potenzBase, potenz);
        zeitStop = System.nanoTime();
        System.out.printf("Endrekursiv: \tpowfak(%d, %d) = %d\tZeit: %dµs\n", potenzBase, potenz, result, (zeitStop-zeitStart)/1000);

    }

    private long iterativFakultaet(short anz){
        long result = 1;

        for(short i = 1; i <= anz; i++)
            result *= i;
        
        return result;
    }

    private long rekursivFakultaet(short anz){
        if(anz == 1)
            return 1;

        return anz * rekursivFakultaet((short)(anz-1)); 
    }

    private long endrekursivFakultaet(long result, short anz){
        if(anz <= 0)
            return result;

       return endrekursivFakultaet(result*anz, (short)(anz-1)); 
    }


    private long iterativSum(short length){
        long result = 0;

        for(short i = 0; i < length; i++)
            result += i;
        
        return result;
    }

    private long rekursivSum(short length){       
        if(length == 0)
            return 0;

        return (length-1)+rekursivSum((short)(length-1));   
    }

    private long endrekursivSum(long result, short length){
        if(length == 0)
            return result;
        
        return endrekursivSum(result+length-1, (short)(length-1));
    }

    private long iterativPowfak(final int base, short num){
        long result = 1;

        if(base == 1)
            return 1;

        for(int i = 0; i < num; i++)
            result *= base;
        
        return result;
    }

    private long rekursivPowfak(final int base, short num){
        if(num == 0)
            return 1;

        if(base == 1)
            return 1;

        return base*rekursivPowfak(base, (short)(num-1));
    }

    private long endrekursivPowfak(long result, final int base, short num){
        if(num == 0)
            return result;

        if(base == 1)
            return 1;

        return endrekursivPowfak(result*base, base, (short)(num-1));
    }
}