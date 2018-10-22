
public class Users {
	int numUsers;
	User [] nombreUsers;
	public Users () {
		nombreUsers=new User[100];
		nombreUsers[0]=new User("Javier", "javier@gmail.com", "javier123");
		nombreUsers[1]=new User("Santiago",	"santiperezci@gmail.com", "pass123");
		nombreUsers[2]=new User("Daniel", "tradeos@gmail.com", "daniel123");
		numUsers=3;
	}
	public boolean verificar(User usuario) {
	
		boolean existe=false;
		for(int i=0;i<numUsers;i++) {
			//
			
			if(usuario.name.equals(nombreUsers[i].name) && nombreUsers[i].email.equals(usuario.email) 
					&& nombreUsers[i].password.equals(usuario.password))  {
				
				existe=true;
				
				break;
			}
		}
		return existe;
	}
	public boolean addUsuario(String usuario, String email, String contraseña) {
		boolean added=false;
		User nuevoUser;
		nuevoUser=new User(usuario,email,contraseña);
		try {
			nombreUsers[numUsers+1]=nuevoUser;
			numUsers++;
			added=true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return added;
	}
}
