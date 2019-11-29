package clean_code;

import java.util.Collections;
import java.util.List;

public class G31 {
    Gradient gradient;
    List<Spline> splines;

    class Gradient{

    }

    class Spline{

    }

    public void dive_ruim(String reason){
        saturateGradient1();
        reticulateSplines2();
        diveForMoog3(reason);
    }

    private void saturateGradient1(){

    }

    private void reticulateSplines2(){

    }

    private void diveForMoog3(String reason){

    }

    /**
     * Acoplamentos temporaris ocultos
     *
     * A ordem das três funções pe importante.
     */
    public void dive(String reason){
        Gradient gradient = saturateGradient();
        List<Spline> splines = reticulateSplines(gradient);
        diveForMoog(splines, reason);
    }

    private Gradient saturateGradient(){
        return new Gradient();
    }

    private List<Spline> reticulateSplines(Gradient gradient){
        return Collections.emptyList();
    }

    private void diveForMoog(List<Spline> splines, String reason){

    }

}
