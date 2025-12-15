import java.util.concurrent.Callable;

public class Comvertidor implements Callable<Double> {
    private double tempCelsius;

    public Comvertidor(double temp){
        this.tempCelsius = temp;
    }

    @Override
    public Double call(){
        return ((tempCelsius * 9)/5) + 32;
    }
}
