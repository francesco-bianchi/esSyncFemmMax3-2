package prog.es3;

public class Main {
    public static void main(String[] args) {
        Bagno b1 = new Bagno();
        String[] nomi = {"Marco", "Marta", "Francesco","Lorenzo", "Maria"};
        String[] generi = {"m", "f", "m","m", "f"};
        
        for(int i=0; i<nomi.length;i++){
            ThreadB t = new ThreadB(b1, nomi[i], generi[i]);
            t.start();
        }
    }
}