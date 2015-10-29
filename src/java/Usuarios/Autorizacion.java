/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.sql.*;

/**
 *
 * @author alumno
 */
public class Autorizacion {

  private String usuario;
  private String password;

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean comprobar() throws SQLException {
    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
    Connection conexion = DriverManager.getConnection(
        "jdbc:oracle:thin:@localhost:1521:XE", "system", "javaoracle");

    String query = "SELECT COUNT(*) AS EXISTE FROM USUARIOS WHERE USUARIO = ? "
        + "AND PASSWORD = ?";
    PreparedStatement sql = conexion.prepareStatement(query);
    sql.setString(1, this.usuario);
    sql.setString(2, this.password);
    ResultSet datos = sql.executeQuery();
    boolean ok = false;
    if (datos.next())
      ok = (datos.getInt("EXISTE") == 1);
    datos.close();
    sql.close();
    conexion.close();
    return ok;
  }
}
