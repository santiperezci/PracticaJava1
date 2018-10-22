import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
public class Amazon {
		static User usuario;
		static Users usuarios;
		static boolean usuarioRegistrado;
		static Categor�as amazonia;
	public static void main (String[] arg){
		usuarioRegistrado=false;
		System.out.println("Bienvenido a nuestra web");
		leerPropiedades();
		usuarios=new Users();
		if(usuarios.verificar(usuario)==false) {
			System.out.println("Usuario no registrado");
			registrarUsuario();
		}
		else {
			usuarioRegistrado=true;
			System.out.println("Bienvenido, �stos son dus datos");
			System.out.println(usuario.email);
	        System.out.println(usuario.name);
	        System.out.println(usuario.password);
		}
		amazonia=new Categor�as();
		System.out.println("Gracias por comprar en Amazonia");
		System.out.println("Escriba el el Id de la subcategoria para ver sus productos");
		Scanner entradaEscaner = new Scanner (System.in);
		String subCat=entradaEscaner.nextLine ();
		subCategorias sc= amazonia.encontrarSubCategoria(subCat);
		sc.listarProductos();
		menu();
	}
	public static void menu() {
		System.out.println("Pulse 1 para comprar un producto, o pulse 2 para volver a categorias");
		Scanner entradaEscaner = new Scanner (System.in);
		int opcion=Integer.valueOf(entradaEscaner.nextLine());
		switch(opcion) {
		case 1:
			comprarProducto();
			break;
		case 2:
			listar();
			System.out.println("Escriba el el Id de la subcategoria para ver sus productos");
			String subCat=entradaEscaner.nextLine ();
			subCategorias sc= amazonia.encontrarSubCategoria(subCat);
			sc.listarProductos();
			menu();
			break;
		default:
			System.out.println("Numero incorrecto");
			menu();
		}
	}
	public static boolean comprarProducto() {
		boolean productoComprado=false;
		System.out.println("Escriba el nombre del producto que desea comprar");
		Scanner entradaEscaner = new Scanner (System.in);
		String comprado=entradaEscaner.nextLine ();
		System.out.println("Producto comprado");
		productoComprado=true;
		return productoComprado;
	}
	public static void listar() {
		amazonia.listar();
	}
	public static void registrarUsuario() {
		Scanner entradaEscaner = new Scanner (System.in);
		System.out.println("Escribe tu nombre de usuario");
		String usuario = "";
        usuario = entradaEscaner.nextLine ();
		System.out.println("Escriba su email");
		String email = "";
        email = entradaEscaner.nextLine ();
        System.out.println("Escriba su contrase�a");
        String contrase�a = "";
        contrase�a = entradaEscaner.nextLine ();
        escribirPropiedades(usuario, email, contrase�a);
	}
	public static void escribirPropiedades(String usuario, String email, String contrase�a) {
		 Properties properties = new Properties();
		 properties.setProperty("username", usuario);
		 properties.setProperty("email", email);
		 properties.setProperty("password", contrase�a);
		 try {
			 properties.store(new FileWriter("Config"),"");
			 boolean a�adido=usuarios.addUsuario(usuario, email, contrase�a);
			 if(a�adido==true) {
				 usuarioRegistrado=true;
				 System.out.println("Bienvenido, �stos son dus datos");
				 System.out.println(email);
			     System.out.println(usuario);
			     System.out.println(contrase�a);
			 }
			 else {
				 System.out.println("Se ha producido un error al a�adir al usuario");
			 }
		 }
		 catch(IOException ioex) {
			 System.out.println(ioex.getMessage());
		 }
	}
	public static void leerPropiedades() {
		try(FileReader reader =  new FileReader("config")) {
	        Properties properties = new Properties();
	        properties.load(reader);
	        String email = properties.getProperty("email");
	        String username = properties.getProperty("username");
	        String password = properties.getProperty("password");
	        if(email!=null && username!=null && password!=null) {
	        	usuario=new User(username, email, password);
	        	/*System.out.println(usuario.email);
		        System.out.println(usuario.name);
		        System.out.println(usuario.password);*/
	        }
	        
	       }catch (Exception e) {;
	       e.printStackTrace();
	       }
	}
}
