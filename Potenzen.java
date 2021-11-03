public class Potenzen {
    
    public static void main(String[] args){
        Potenzen potenz = new Potenzen();
        System.out.println(potenz.powfak(15, 5));
    }

    private int powfak(int base, int num){
        if(num == 0)
            return 1;

        return base*powfak(base, (num-1));
    }
}
