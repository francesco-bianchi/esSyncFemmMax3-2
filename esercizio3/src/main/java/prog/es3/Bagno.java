package prog.es3;


public class Bagno {
    private boolean disponibile=true;
    private int contaD=0;
    private int contaEntr=0;
    private boolean entrPossD=true;

    public synchronized void entra(ThreadB t){
        String name = Thread.currentThread().getName();
        if(t.getGenere().equals("f")){
            contaD++;
        }
        try {
            while(!disponibile || (contaD>0 && t.getGenere().equals("m") && entrPossD==true) ||  (t.getGenere().equals("f") && entrPossD==false)){
                wait();
                //System.out.println(name +" è in attesa di entrare");
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        disponibile=false;
        if(t.getGenere().equals("f")){
            contaD--;
            contaEntr++;
            if(contaEntr==3)
                entrPossD=false;
        } 
        else{
            entrPossD=true;
            contaEntr=0;
        }
        System.out.println(name + " è in bagno");
    }

    public synchronized void esci(){
        String name = Thread.currentThread().getName();
        disponibile=true;
        notifyAll();
        System.out.println(name + " ha lasciato il bagno");        
    }

}
