package Portafolio;

import Portafolio.Modelo.ListaTareas;
import Portafolio.Modelo.ManejadorDeTareas;
import Portafolio.Modelo.Tarea;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

        public class ListasTareas {

        private static final String PortafolioJess = System.getProperty("user.home") + "/.tareas";



        public ListasTareas() throws Exception {
        cargaTareas();
    }



        //Crear una instancia de lector para poder usarlo para leer el nombre de la Lista de Tarea asignada por el usuario
        private Lector lector = new Lector();

         //Crear una lista que agrupará Listas de Tareas que a su vez contendrán Tareas
           private List<ListaTareas> listasDeTareas = new ArrayList<>();



        //Crear métodos para cada opción del menu principal

        //En este metódo se crea una nueva instancia de Lista de Tareas y se utiliza el método de Lector --> leeCadena para leer y
        // posteriormente asignar el nombre a la nueva listatareas.
        //Con el método add lo que hago es agregar esta nueva instancia de ListaTareas "listatareas" a la Lista de listasDeTarea.
        public void crearNuevaListaDeTareas(){
            System.out.println("----> Crear nueva Lista de Tareas." );
            ListaTareas listatareas = new ListaTareas(lector.leeCadena("Indica el nombre de la Nueva Lista de Tareas:"));
            listasDeTareas.add(listatareas);
        }


        //En este método se enlistan las Listas de Tareas existentes
        //Primero se utiliza el método validaExistenciaLista para conocer si ya existe una Lista de Listas creada.
        public void verListasDeTareas() {
            System.out.println("----> Ver Listas de Tareas existentes:");
            if (!validaExistenciaLista()){ return;}
                for (int i = 0; i < listasDeTareas.size(); i++) {
                    //System.out.println((i + 1) + ".- " + listasDeTareas.get(i).getNombre());
                    System.out.printf("%d - %s%n", (i + 1), listasDeTareas.get(i).getNombre());
                }
            }


        //En este método podemos ver las Tareas dentro de la lista seleccionada por el usuario a través del método leeOpcion de lector.
        public void verTareasDeLista(){
            System.out.println("----> Ver Tareas de la Lista seleccionada.");
            byte indice = validaIndice();

            if(indice == 0){
                return;
            }
            ListaTareas lista = listasDeTareas.get(indice - 1);
            if (lista.cantidadTareas() == 0) {
                System.out.println("Aún no hay tareas en la lista.");
            }

            lista.mostrarTareas();
        }

        private Menu menu = new Menu();
        private ManejadorDeTareas tareas = new ManejadorDeTareas();

        public void actualizarListaDeTareas(){
            System.out.println("----> Actualizar la Lista de Tareas seleccionada.");

            byte indice = validaIndice();

            if (indice == 0) {
                return;
            }
            ListaTareas listaActual = listasDeTareas.get(indice - 1);

            menu.OpcionesTarea();
            byte opcionSeleccionada = lector.leeOpcion("Seleccion:");
            switch (opcionSeleccionada){
                case 1:
                    Tarea nuevaTarea = tareas.nuevaTarea();
                    listaActual.agregarTarea(nuevaTarea);
                    break;
                case 2:
                    Tarea t1 = tareas.eliminaTarea(listaActual);
                    if(t1 != null) {
                        System.out.printf("Se eliminó la tarea %s%n ", t1.getNombre());
                    }
                    else {
                        System.out.println("No se pudo eliminar la tarea.");
                    }
                    break;
                case 3:
                    Tarea t2 = tareas.marcarTareaRealizada(listaActual);
                    if(t2 != null) {
                        //System.out.println("La tarea " + t2.getNombre() + " se completó el " + t2.getFechaRealizacion());
                        System.out.printf("La tarea %s se completó el %2$te de %2$tB de %2$tY%n", t2.getNombre(), t2.getFechaRealizacion());
                    }else{
                        System.out.println("La tarea no pudo ser marcada como finalizada.");
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción desconocida.");
            }
        }

        public void eliminarListaDeTareas(){
            System.out.println("----> Eliminar la lista de tareas seleccionada.");
            byte indice = validaIndice();

            if (indice == 0) {
                return;
            }
            ListaTareas listaEliminada = listasDeTareas.remove((indice - 1));

            System.out.printf("Se eliminó la lista de tareas: %s%n ", listaEliminada.getNombre());
        }

        public void salir(){
            System.out.println("----> Salir de la aplicación.");
        }

        //Con este método se valida la existencía de una Lista de Listas de Tarea en este caso listasDeTareas, que exista y que no este vacía.
         private boolean validaExistenciaLista() {
        if (listasDeTareas != null && !listasDeTareas.isEmpty()) {
            return true;
        }

        System.out.println("Aún no se ha creado ninguna lista de tareas.");
        return false;
    }

    //Con este método se valida si el indice seleccionado por el usuario se refiere a alguna lista de tareas ya creada.
    private byte validaIndice() {
        byte indice = 0;

        if (!validaExistenciaLista()) {
            return indice;
        }

        indice = lector.leeOpcion("Indique el índice de la lista de tareas.");

        if (indice > listasDeTareas.size() || indice < 0) {
            System.out.println("No existen listas de tareas en el índice seleccionado.");
            indice = 0;
        }

        return indice;
    }
    public void cargaTareas() throws Exception {
        if (new File(PortafolioJess).exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PortafolioJess));
            listasDeTareas = (List<ListaTareas>) ois.readObject();
        }
    }

    public void guardarTareas() throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PortafolioJess));
        oos.writeObject(listasDeTareas);
    }


}

