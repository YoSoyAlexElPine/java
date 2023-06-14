import java.sql.*;

public class alumnoALMM {
	private Connection connection;
    private Statement statement;
    
    // Método para establecer la conexión con la base de datos
    public void conectar() {
        try {
            String url = "jdbc:mysql://localhost:3306/tunombrebd"; // Cambiar "tunombrebd" por el nombre de tu base de datos
            String usuario = "usuario"; // Cambiar "usuario" por tu usuario de MySQL
            String contraseña = "contraseña"; // Cambiar "contraseña" por tu contraseña de MySQL
            
            connection = DriverManager.getConnection(url, usuario, contraseña);
            statement = connection.createStatement();
            
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
    
    // Método para insertar un nuevo alumno en la tabla
    public void insertarAlumno(String nombre, String apellidos, double notaPROG, double notaENDES) {
        try {
            String sql = "INSERT INTO Alumnos (nombre, apellidos, notaPROG, notaENDES) VALUES ('" +
                         nombre + "', '" + apellidos + "', " + notaPROG + ", " + notaENDES + ")";
            statement.executeUpdate(sql);
            System.out.println("Alumno insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el alumno: " + e.getMessage());
        }
    }
    
    // Método para modificar los datos de un alumno existente en la tabla
    public void modificarAlumno(int id, String nombre, String apellidos, double notaPROG, double notaENDES) {
        try {
            String sql = "UPDATE Alumnos SET nombre = '" + nombre + "', apellidos = '" + apellidos +
                         "', notaPROG = " + notaPROG + ", notaENDES = " + notaENDES + " WHERE id = " + id;
            statement.executeUpdate(sql);
            System.out.println("Alumno modificado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al modificar el alumno: " + e.getMessage());
        }
    }
    
    // Método para eliminar un alumno de la tabla
    public void eliminarAlumno(int id) {
        try {
            String sql = "DELETE FROM Alumnos WHERE id = " + id;
            statement.executeUpdate(sql);
            System.out.println("Alumno eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el alumno: " + e.getMessage());
        }
    }
    
    // Método para obtener el listado de todos los alumnos de la tabla
    public void obtenerAlumnos() {
        try {
            String sql = "SELECT * FROM Alumnos";
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                double notaPROG = resultSet.getDouble("notaPROG");
                double notaENDES = resultSet.getDouble("notaENDES");
                
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Apellidos: " + apellidos +
                                   ", Nota PROG: " + notaPROG + ", Nota ENDES: " + notaENDES);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los alumnos: " + e.getMessage());
        }
    }
    
    // Método para cerrar la conexión con la base de datos
    public void desconectar() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
                System.out.println("Desconexión exitosa de la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
