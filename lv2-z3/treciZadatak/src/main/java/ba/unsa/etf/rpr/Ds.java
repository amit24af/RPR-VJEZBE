package ba.unsa.etf.rpr;
import java.util.List;
import java.util.ArrayList;
public class Ds {
    public static Double min(List<Double> l){
        Double min=l.get(0);
        for(Double x:l){
            if(x<min){
                min=x;
            }
        } return min;
    }
    public static Double max(List<Double> l){
        Double max=l.get(0);
        for(Double x:l){
            if(x>max){
                max=x;
            }
        } return max;
    }
    public static Double mean(List<Double> l){
        double mean=0;
        for(Double x:l){
            mean=mean+x;
        } return mean/(l.size());
    }
    public static Double standardna_devijacija(List<Double> l){
        double m=mean(l); double s=0;
        for(Double x:l){
            s=s+((x-m)*(x-m));
        } return s;
    }
}
