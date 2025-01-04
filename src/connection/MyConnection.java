package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class MyConnection {
    public static final String username = "ITITIU21146"; // Tên đăng nhập SQL Server
    public static final String password = "1";          // Mật khẩu SQL Server
    public static final String url = "jdbc:sqlserver://localhost:1433;databaseName=furnitured;encrypt=true;trustServerCertificate=true;";
    public static Connection con = null;
    public static Connection getConnection() {
        try {
            // Load driver SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Kết nối SQL Server
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Kết nối thất bại: " + ex.getMessage(), "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
        return con;
    }
}
