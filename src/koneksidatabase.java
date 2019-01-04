import com.sun.istack.internal.logging.Logger;
import java.sql.*;
import java.util.logging.Level;
public class koneksidatabase {
private static Connection koneksi;
public static Connection getKoneksi(){
    if(koneksi == null){
        try {String url =
                "jdbc:mysql://3306/login";
                String user="root";
                String pass="";
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        koneksi = DriverManager.getConnection(url, user, pass);
                }
        catch(SQLException t){
            System.out.println("Gagal melakukan koneksi ke database");
        }
    }
    return koneksi;
}

public static int execute(String SQL){
//    ResultSet rs = null;
    int status = 0;
    
    Connection koneksi = getKoneksi();
    
    try {
        Statement st = koneksi.createStatement();
        status = st.executeUpdate(SQL);
    } catch (SQLException ex) {
      //Logger.getLogger(koneksidatabase.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return status;
}

public static ResultSet executeQuery(String SQL){
    ResultSet rs = null;
//    int status = 0;
    
    Connection koneksi = getKoneksi();
    
    try {
        Statement st = koneksi.createStatement();
        rs = st.executeQuery(SQL);
    } catch (SQLException ex) {
//        Logger.getLogger(koneksidatabase.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return rs;
}

}
