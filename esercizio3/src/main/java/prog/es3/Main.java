package prog.es3;

public class Main {
    public static void main(String[] args) {
        Bagno b1 = new Bagno();
        String[] nomi = {"Marco", "Marta", "Martina", "Francesca","Lorenzo", "Maria", "Angela", "Franca", "Gianna", "Anna", "Carlo",  "Antonio"};
        String[] generi = {"m", "f", "f", "f", "m", "f", "f", "f", "f", "f", "m", "m"};
        
        for(int i=0; i<nomi.length;i++){
            ThreadB t = new ThreadB(b1, nomi[i], generi[i]);
            t.start();
        }
    }
}