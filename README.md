# Convertidor de Temperaturas

## Descripción
Creamos un programa en JAVA usando la concurrencia que nos ofrece *ExecutorService*

## Clases
En este proyecto tenemos 2 clases principales:

### Comveridor
Clase donde se hace la conversión de la temperatura, donde implementamos el Callable para ser llamada desde Main.

### Main
· Creamos una lista de temperaturas.
· Creamos una pool de hilos Fija de 2 hilos.
· Le pasamos las tareas de conversor al Executor.
· Recuperamos y guardamos los datos con Fute
· Mostramos los datos en un formato comodo, limpio y simple.
· Cerramos el ejecutor, dejandole tiempo para que termine.
