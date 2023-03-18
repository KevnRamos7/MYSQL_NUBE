/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mysql;

import java.sql.*;

/**
 *
 * @author kevin
 */
public class CRUD {
    private Connection connection;
    private String url = "jdbc:mysql://u07cpq7qccc3pwus:22f4GUIUxQPbRIijYVa3@blpd3doggzap9szm7slg-mysql.services.clever-cloud.com:3306/blpd3doggzap9szm7slg"; // cambiar dbname por el nombre de la base de datos
    private String username = "u07cpq7qccc3pwus"; // cambiar username por el nombre de usuario de la base de datos
    private String password = "22f4GUIUxQPbRIijYVa3"; // cambiar password por la contraseña de la base de datos
    
    public CRUD() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }
    
    public ResultSet listar() throws SQLException {
        String query = "SELECT * FROM productos";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }
    
    public void agregar(String nombre, String descripcion, double precio, int cantidad) throws SQLException {
        String query = "INSERT INTO productos (nombre, descripcion, precio, cantidad) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, nombre);
        preparedStatement.setString(2, descripcion);
        preparedStatement.setDouble(3, precio);
        preparedStatement.setInt(4, cantidad);
        preparedStatement.executeUpdate();
    }
    
    public void modificar(int id, String nombre, String descripcion, double precio, int cantidad) throws SQLException {
        String query = "UPDATE productos SET nombre=?, descripcion=?, precio=?, cantidad=? WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, nombre);
        preparedStatement.setString(2, descripcion);
        preparedStatement.setDouble(3, precio);
        preparedStatement.setInt(4, cantidad);
        preparedStatement.setInt(5, id);
        preparedStatement.executeUpdate();
    }
    
    public void eliminar(int id) throws SQLException {
        String query = "DELETE FROM productos WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
    
    public void cerrarConexion() throws SQLException {
        connection.close();
    }

}
