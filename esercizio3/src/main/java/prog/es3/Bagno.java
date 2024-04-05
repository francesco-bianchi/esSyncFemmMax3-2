package prog.es3;


public class Bagno {
    private boolean disponibile=true;

    public synchronized void entra(){
        String name = Thread.currentThread().getName();
        try {
            while(!disponibile){
                wait();
                System.out.println(name +" è in attesa di entrare");
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        disponibile=false;
        System.out.println(name + " e' entrato in bagno");
    }

    public synchronized void esci(){
        String name = Thread.currentThread().getName();
        disponibile=true;
        notifyAll();
        System.out.println(name + " e' uscito dal bagno");        
    }

}
