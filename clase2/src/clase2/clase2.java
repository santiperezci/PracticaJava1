package clase2;

import java.util.Scanner;

public class clase2 {
	public static int cuadrado(int num) {
		int cd=num*num;
		return cd;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double r,ar, c, a;
		Scanner entradaEscaner = new Scanner (System.in);
		System.out.println("Escribe un n�mero entero");
        a=entradaEscaner.nextDouble();
        //c=cuadrado(a);
        c=maths.cuadrado(a);
        System.out.println ("El cuadrado el n�mero es: \"" + c +"\"");
        System.out.println("Escribe el radio");
        r=entradaEscaner.nextDouble();
        ar=maths.areaCirculo(r);
        System.out.println ("El �rea del c�rculo es: \"" + ar +"\"");
	}
}
