package Portafolio.Modelo;

import Portafolio.Lector;

import java.time.LocalDate;

public class ManejadorDeTareas {

    private final Lector lector = new Lector();

    public Tarea nuevaTarea() {
        System.out.println("Nueva Tarea");
        System.out.println("Introduce los datos de la nueva tarea. ");
        String nombreTarea = lector.leeCadena("Escribe el nombre de la nueva tarea:");
        return new Tarea(nombreTarea);
    }

    public Tarea eliminaTarea(ListaTareas listaTareas) {
        System.out.println("Eliminar tarea");
        byte indice = lector.leeOpcion("Indica el índice de la tarea a eliminar");
        if (indice > listaTareas.cantidadTareas()) {
            System.out.println("La tarea indicada no existe.");
            return null;
        }
        return listaTareas.eliminarTarea(indice - 1);

    }

    public Tarea marcarTareaRealizada(ListaTareas listaTareas) {
        System.out.println("Tarea Realizada");

        byte indice = lector.leeOpcion("Indica el índice de la tarea a marcar como realizada");

        if (indice > listaTareas.cantidadTareas()) {
            System.out.println("La tarea indicada no existe.");
            return null;
        }

        Tarea tarea = listaTareas.getTareas().get(indice - 1);
        tarea.setFechaRealizacion(LocalDate.now());
        tarea.setRealizada(true);

        return tarea;
    }
}