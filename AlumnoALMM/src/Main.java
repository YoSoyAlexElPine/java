
public class Main {

	/**
	 * 
	 * @param args
	 * 
	 * @author Alex Pineño Sachez
	 * @author Luis Manuel Exposito
	 * @author Miguel Angel Guitierrez
	 * @author Marrio Cerro
	 */
	
	public static void main(String[] args) {
		
		  alumnoALMM alumnoALMM = new alumnoALMM();
	        
	        // Conexión a la base de datos
	        alumnoALMM.conectar();
	        
	        // Inserción de un nuevo alumno
	        alumnoALMM.insertarAlumno("Nombre", "Apellidos", 8.5, 7.8);
	        
	        // Modificación de un alumno existente
	        alumnoALMM.modificarAlumno(1, "Nuevo Nombre", "Nuevos Apellidos", 9.0, 8.2);
	        
	        // Eliminación de un alumno
	        alumnoALMM.eliminarAlumno(1);
	        
	        // Obtención del listado de alumnos
	        alumnoALMM.obtenerAlumnos();
	        
	        // Desconexión de la base de datos
	        alumnoALMM.desconectar();
	    }

	}

