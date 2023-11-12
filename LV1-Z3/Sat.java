 package ba.unsa.etf.rpr;
import java.util.Scanner;
class Sat {
    private int sati;
    private int minute;
    private int sekunde;
    public Sat(int sati, int minute, int sekunde) {
        postavi(sati,minute,sekunde);
    }
    public void postavi(int sati, int minute, int sekunde) {
        this.sati=sati; this.minute=minute; this.sekunde=sekunde;
    }
    public void sljedeci() {
        this.sekunde++;
        if (sekunde==60) {
            this.sekunde=0;
            this.minute++;
        } if (this.minute==60) {
            this.minute=0;
            this.sati++;
        }
        if (this.sati==24){
            this.sati=0;
        }
    }
    public void prethodni() {
        this.sekunde--;
        if (this.sekunde==-1) {
            this.sekunde=59; this.minute--;
        } if (this.minute==-1) {
            this.minute=59; this.sati--;
        }
        if (this.sati==-1) {
            this.sati = 23;
        }
    }
    public void pomjeriZa(int pomak) {
        if (pomak>0) {
            for (int i=0; i<pomak; i++) {
                this.sljedeci();
            }
        } else{
            for (int i=0; i<pomak ; i++){
                this.prethodni();
            }
        }
    }
    public int dajSate()  {
        return this.sati;
    }
    public int dajMinute()  {
        return this.minute;
    }
    public int dajSekunde() {
        return this.sekunde;
    }
    public void ispisi() {
        System.out.println(this.sati+":"+this.minute+":"+this.sekunde);
    }

    public static void main(String[] args){
        Sat s=new Sat(13, 57, 33);
        s.ispisi();
    }

};
