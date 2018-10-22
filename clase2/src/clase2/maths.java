package clase2;

public class maths {
	public static final double pi=3.1416;
	public static double cuadrado(double num) {
		try {
			double cd=num*num;
			return cd;
		}
		catch  (java.util.InputMismatchException imEX) {
			System.out.println(imEX.getMessage());
			return 0;
			
		}
	}
	public static double areaCirculo(double radio) {
		double area= Math.pow(radio, 2)*pi;
		return area;
	}
}
