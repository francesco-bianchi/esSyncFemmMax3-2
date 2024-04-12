package prog.es3;


public class Bagno {
    private boolean disponibile=true;
    private int contaD=0;
    private int contaEntr=0;
    private int x=0;

    public synchronized void entra(ThreadB t){
        String name = Thread.currentThread().getName();
        if(t.getGenere().equals("f")){
            contaD++;
            contaEntr++;
        }
        try {
            while(!disponibile || contaD>0 && t.getGenere().equals("m") && contaEntr==x+3){
                wait();
                System.out.println(name +" è in attesa di entrare");
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        disponibile=false;
        if(t.getGenere().equals("f")) contaD--;
        System.out.println(name + " e' entrato in bagno");
    }

    public synchronized void esci(){
        String name = Thread.currentThread().getName();
        disponibile=true;
        notifyAll();
        System.out.println(name + " e' uscito dal bagno");        
    }

}
