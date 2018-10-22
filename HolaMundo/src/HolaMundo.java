import java.util.Scanner;

public class HolaMundo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hello world!");
		int a=5;
		System.out.println(a);
		String st="Saludos, escribe algo.";
		System.out.println(st);
		String entradaTeclado = "";

        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner

        entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
        
        System.out.println ("Entrada recibida por teclado es: \"" + entradaTeclado +"\"");
        System.out.println("Escribe un número entero");
        a=entradaEscaner.nextInt();
        System.out.println ("Entrada recibida por teclado es: \"" + a +"\"");
        for(int i=0; i<=a; i++) {
        	System.out.println("Hola Mundo" + i);
        }
	}

}
