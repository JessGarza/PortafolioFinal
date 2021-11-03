package Portafolio.Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ListaTareas implements Serializable {

    //Declaración de atributos de la clase ListaTareas
    private String nombre;
    private final LocalDate fechaCreacion;
    private List<Tarea> tareas = new ArrayList<>();

    //Bloque de inicialización que inicialice la fecha de creación al momento actual
    {
        fechaCreacion = LocalDate.now();
    }


    //constructor de la clase ListaTareas
    public ListaTareas(String nombre){
        this.nombre = nombre;
    }


    //Método creado para agregar tareas a las Listas de Tareas
    public void agregarTarea(Tarea tarea){
        tareas.add(tarea);
    }

    //Método crearo para eliminar la tarea indicada por el usuario a través del indice.
    //Primero se verifica que el indice sea un número correcto.
    public Tarea eliminarTarea(int indice){
        if (indice > tareas.size()) {
            System.out.println("La tarea indicada no se encuentra en la lista.");
            return null;
        }

        return tareas.remove(indice);
    }

   //Método creado para mostrar las tareas con su indice
    public void mostrarTareas() {
        for (int i = 0; i < tareas.size(); i++) {
            Tarea tarea = tareas.get(i);
            System.out.println((i + 1) + " - " + tarea.getNombre() + " Creada: "+tarea.getFechaCreacion() + " [" + (tarea.isRealizada() ? "█" : " ")  + "] " + (tarea.isRealizada() ? tarea.getFechaRealizacion() : ""));
        }
    }

    //Método creado para conocer la cantidad de tareas dentro de la lista tareas.
    public int cantidadTareas(){
        return tareas.size();
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    //Declaración de métodos Getter y Setters de los atributos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

}
