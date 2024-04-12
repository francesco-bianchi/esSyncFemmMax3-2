package prog.es3;


public class Bagno {
    private boolean disponibile=true;
    private int contaD=1;

    public synchronized void entra(ThreadB t){
        String name = Thread.currentThread().getName();
        try {
            while(!disponibile || contaD>0 && t.getGenere().equals("m")){
                wait();
                System.out.println(name +" è in attesa di entrare");
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        disponibile=false;
        contaD--;
        System.out.println(name + " e' entrato in bagno");
    }

    public synchronized void esci(){
        String name = Thread.currentThread().getName();
        disponibile=true;
        notifyAll();
        System.out.println(name + " e' uscito dal bagno");        
    }

}
