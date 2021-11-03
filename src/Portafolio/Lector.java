package Portafolio;

import java.util.Scanner;

public class Lector {

        private Scanner scan = new Scanner(System.in);

        public byte leeOpcion(String mensajeUsuario){
            System.out.println("\n" + mensajeUsuario);
            return scan.nextByte();
        }

        public String leeCadena(String mensajeUsuario){
            System.out.println(mensajeUsuario);
            return scan.nextLine();
        }
    }

