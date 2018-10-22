import java.io.File;

public class subCategorias {
	private String idSubCat,nombreSubCategoria, nombrePadre;
	String [] nombresProductos;
	public Producto []  Productos;
	int numProductos=0;
	public subCategorias(String nombre, String id, String papi) {
		Productos =new Producto[20];
		nombreSubCategoria=nombre;
		idSubCat=id;
		nombrePadre=papi;
	}
	public String getNombreSubCat() {
		return nombreSubCategoria;
	}
	public String getIdCat() {
		return idSubCat;
	}
	public String getNombrePadre() {
		return nombrePadre;
	}
	public void setIdCat(String id) {
		idSubCat=id;
	}
	public void setNombresProductos(String idSubCat) {
		//System.arraycopy(nombresProds,0,nombresProductos,0,nombresProds.length);
		try {
		String path = new File(".").getCanonicalPath()+ "\\productos\\" +idSubCat;
		//System.out.println(path+ "\\productos\\" +idSubCat);
		File dir = new File(path );
		String[] ficheros = dir.list();
		int numFicheros=ficheros.length;
		if (ficheros == null) {
			  System.out.println("No hay ficheros en el directorio especificado");
		}
		
		else { 
			  for (int i=0;i<numFicheros;i++) {
			    //System.out.println(ficheros[i]);
			    numProductos++;
			    Productos[i]=new Producto(path+ "\\" +ficheros[i],nombrePadre,nombreSubCategoria);
			   
			  }
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void listarProductos() {
		System.out.println("Lista de productos");
		System.out.println("N�mero de productos:" + numProductos);
		System.out.println(idSubCat);
		for(int i=0;i<numProductos;i++) {
			System.out.println(Productos[i].nombreProducto);
			System.out.println(Productos[i].precio);
			System.out.println(Productos[i].valoracion);
		}
	}
}
