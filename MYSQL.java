import java.sql.*;
import javax.swing.JOptionPane;
import mysql.CRUD;
public class MYSQL {

    public static void main(String[] args) throws SQLException {
        CRUD crud = new CRUD();
        String opcion;
        int id, cantidad;
        String nombre, descripcion;
        double precio;

        try {
            while (true) {
                opcion = JOptionPane.showInputDialog(null, "Seleccione una opción:\n1. Listar productos\n2. Agregar producto\n3. Modificar producto\n4. Eliminar producto\n5. Salir");
                if (opcion == null) {
                    break;
                }
                switch (opcion) {
                    case "1":
                        ResultSet rs = crud.listar();
                        String lista = "";
                        while (rs.next()) {
                            lista += rs.getInt("id") + " - " + rs.getString("nombre") + " - " + rs.getString("descripcion") + " - " + rs.getDouble("precio") + " - " + rs.getInt("cantidad") + "\n";
                        }
                        JOptionPane.showMessageDialog(null, lista);
                        break;
                    case "2":
                        nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto:");
                        descripcion = JOptionPane.showInputDialog(null, "Ingrese la descripción del producto:");
                        precio = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el precio del producto:"));
                        cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad del producto:"));
                        crud.agregar(nombre, descripcion, precio, cantidad);
                        break;
                    case "3":
                        id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del producto que desea modificar:"));
                        nombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre del producto:");
                        descripcion = JOptionPane.showInputDialog(null, "Ingrese la nueva descripción del producto:");
                        precio = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el nuevo precio del producto:"));
                        cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la nueva cantidad del producto:"));
                        crud.modificar(id, nombre, descripcion, precio, cantidad);
                        break;
                    case "4":
                        id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del producto que desea eliminar:"));
                        crud.eliminar(id);
                        break;
                    case "5":
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida.");
                        break;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos: " + ex.getMessage());
        }
    }

}
