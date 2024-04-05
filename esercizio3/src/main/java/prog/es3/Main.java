package prog.es3;

public class Main {
    public static void main(String[] args) {
        Bagno b1 = new Bagno();
        String[] nomi = {"Marco", "Marta", "Francesco","Lorenzo"};

        for(String s: nomi){
            ThreadB t = new ThreadB(b1, s);
            t.start();
        }
    }
}