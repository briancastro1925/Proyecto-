package Tarea;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Modelo {
    private String url = "jdbc:mysql://localhost/db_modelos";
    private String user = "root";
    private String password = "";

    public Modelo() {}

    public void agregar(String idTexto, String marca, String modelo, String desc, String status) {
        try {
            Connection cnx = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = cnx.prepareStatement("insert into modelo(id, marca, modelo, descripcion, status) values(?, ?, ?, ?, ?)");
            ps.setInt(1, Integer.parseInt(idTexto.trim()));
            ps.setString(2, marca);
            ps.setString(3, modelo);
            ps.setString(4, desc);
            ps.setString(5, status);
            ps.execute();
            ps.close();
            cnx.close();
            System.out.println("Registro agregado");
        } catch(SQLException ex){
            System.out.println("Error de SQL: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            System.out.println("El ID debe ser un número entero.");
        }
    }

    public void eliminar(String idTexto, String marcaTexto) {
        try {
            Connection cnx = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = null;

            if (!idTexto.isEmpty()) {
                ps = cnx.prepareStatement("DELETE FROM modelo WHERE id = ?");
                ps.setInt(1, Integer.parseInt(idTexto));
            } else if (!marcaTexto.isEmpty()) {
                ps = cnx.prepareStatement("DELETE FROM modelo WHERE marca = ?");
                ps.setString(1, marcaTexto);
            } 

            if (ps != null) {
                ps.executeUpdate();
                ps.close();
            }
            cnx.close();
            System.out.println("Registro eliminado");
        } catch (SQLException ex) {
            System.out.println("Error de SQL: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            System.out.println("El ID debe ser un número entero.");
        }
    }

    public void consultar(DefaultTableModel modeloTabla) {
        try {
            Connection cnx = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = cnx.prepareStatement("select * from modelo");
            ResultSet rs = ps.executeQuery();

            modeloTabla.setRowCount(0);

            while (rs.next()) {
                int id = rs.getInt("id");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String descripcion = rs.getString("descripcion");
                String status = rs.getString("status");

                modeloTabla.addRow(new Object[]{id, marca, modelo, descripcion, status});
            }

            System.out.println("Conexion exitosa");
            cnx.close();
        } catch (SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public void actualizar(String idTexto, String marca, String modelo, String desc, String status) {
        try {
            Connection cnx = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = cnx.prepareStatement("update modelo set marca = ?, modelo = ?, descripcion = ?, status = ? where id = ?");
            ps.setString(1, marca);
            ps.setString(2, modelo);
            ps.setString(3, desc);
            ps.setString(4, status);
            ps.setInt(5, Integer.parseInt(idTexto));
            ps.executeUpdate();
            
            ps.close();
            cnx.close();
            System.out.println("Registro actualizado");
        } catch (SQLException ex) {
            System.out.println("Error de SQL: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            System.out.println("El ID debe ser un número entero para actualizar.");
        }
    }
}
