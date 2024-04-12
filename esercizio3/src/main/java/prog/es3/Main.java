package prog.es3;

public class Main {
    public static void main(String[] args) {
        Bagno b1 = new Bagno();
        String[] nomi = {"Marco", "Marta", "Francesco","Lorenzo"};
        ThreadB t = new ThreadB(b1, nomi[0], "m");
        ThreadB t1 = new ThreadB(b1, nomi[1], "f");
        ThreadB t2 = new ThreadB(b1, nomi[2], "m");
        ThreadB t3 = new ThreadB(b1, nomi[3], "m");
        t.start();
        t1.start();
        t2.start();
        t3.start();
    }
}