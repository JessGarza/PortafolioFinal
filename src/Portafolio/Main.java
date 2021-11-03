package Portafolio;

public class Main {
    public static void main(String[] args) throws Exception {

        //Declaración de variable
        short opcionSeleccionada;

        //Crear una instancia de Menu llamada menu para poder ejecutar el método Opciones().
        Menu menu = new Menu();


        //Crear una instancia de Lector llamada lector apra poder ejecutar el método leeOpcion().
        Lector lector = new Lector();

        ListasTareas listasTareas = new ListasTareas();

        //Metodo Do while para mostrar el menu indefinidamente hasta que el usuario seleccione la opción 6 Salir.
        do {
            menu.Opciones();
            opcionSeleccionada = lector.leeOpcion("Selecciona el número de la opción deseada:");
            //System.out.println("La opción seleccionada es: " + opcionSeleccionada);
            System.out.printf("%n%nLa opción seleccionada es: %d%n", opcionSeleccionada);


            switch (opcionSeleccionada) {
                case 1:
                    listasTareas.crearNuevaListaDeTareas();
                    break;
                case 2:
                    listasTareas.verListasDeTareas();
                    break;
                case 3:
                    listasTareas.verTareasDeLista();
                    break;
                case 4:
                    listasTareas.actualizarListaDeTareas();
                    break;
                case 5:
                    listasTareas.eliminarListaDeTareas();
                    break;
                case 6:
                    listasTareas.guardarTareas();
                    System.out.println("Saliendo de la aplicación.");
                    break;
                default:
                    System.out.println("Opción invalida.");
                }



            }
                 while ((opcionSeleccionada >=1 && opcionSeleccionada <=5) || opcionSeleccionada !=6);

    }
}
