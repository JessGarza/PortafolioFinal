package Portafolio.Modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Tarea implements Serializable {

    //Declaración de atributos de la clase Tarea
    private String nombre;
    private final LocalDate fechaCreacion;
    private LocalDate fechaExpiracion;
    private boolean realizada;
    private LocalDate fechaRealizacion;

    //Bloque de inicialización que inicialice la fecha de creación al momento actual
    {
        fechaCreacion = LocalDate.now();
    }

    //constructor de la clase Tarea
    public Tarea(String nombre){
        this.nombre = nombre;
    }

    //Creación de Getters y Setters de los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    public LocalDate getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(LocalDate fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }
}
