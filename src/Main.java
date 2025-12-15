import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{
    public static void main(String[] args){

        // Creamos una lista de temperaturas.
        ArrayList<Double> temperaturas = new ArrayList<Double>(List.of(0.0,5.0,10.0,50.0,70.0,95.0));

        // Declaramos una pull de 2 hilos fijos
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Declaramos la futura lista de temperatura ya convertida
        List<Future<Double>> temperaturasFahrenheit = new ArrayList<>();

        try{
            // Por cada temperatura
            for(double temp : temperaturas){
                // Se calcula el resultado y se guarda en la lista.
                temperaturasFahrenheit.add(executor.submit(new Comvertidor(temp)));
            }

            // TAble*
            System.out.println("\n-- Convertidor de Temperaturas --");
            System.out.println("_________________________________");

            // Mostramos Datos
            for(int i = 0; i<temperaturas.size(); i++){
                double temp = temperaturas.get(i);
                double fahrenheit = temperaturasFahrenheit.get(i).get();
                System.out.println("Celsius: " + temp + " | " + fahrenheit + ": Fahrenheit");
            }
        }catch (InterruptedException | ExecutionException e){
            // En caso de error
            System.out.println("Error: " + e.getMessage());
        }finally {
            // Cerramos la pool de hilos
            executor.shutdown();

            try {
                // Esperamos 5 segundos a ver si termia de ejercutar
                executor.awaitTermination(5, TimeUnit.SECONDS);
            }catch (InterruptedException e){
                // Cortamos el funcionamiento de raiz
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
}
