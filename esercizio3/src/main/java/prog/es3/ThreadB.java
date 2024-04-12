package prog.es3;

public class ThreadB extends Thread{
    private Bagno b;
    private String genere;

    public ThreadB(Bagno b, String name, String genere){
        super(name);
        this.genere = genere;
        this.b = b;
    }

    @Override
    public void run(){
        String name = Thread.currentThread().getName();
        try{
            b.entra(this);
            int t = 2000 + (int) (Math.random()*3000);
            System.out.println(name + " occupa il bagno per: " + (t/1000) + " secondi");
            Thread.sleep(t);
            b.esci();
        }
        catch(InterruptedException i){
            i.printStackTrace();
        }
    }

    public String getGenere() {
        return genere;
    }
}
