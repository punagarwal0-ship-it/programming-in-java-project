package ims;

import java.sql.*;

public class DB {
    private static final String URL="jdbc:h2:./data/inventory";

    public static Connection con() throws SQLException {
        return DriverManager.getConnection(URL,"sa","");
    }

    public static void init() {
        try(Connection c=con(); Statement s=c.createStatement()) {
            s.executeUpdate("""
                CREATE TABLE IF NOT EXISTS products(
                id INT PRIMARY KEY,
                name VARCHAR(100),
                price DOUBLE,
                qty INT,
                minQty INT,
                type VARCHAR(30))
                """);

            s.executeUpdate("""
                CREATE TABLE IF NOT EXISTS suppliers(
                id INT PRIMARY KEY,
                name VARCHAR(100),
                phone VARCHAR(30))
                """);

            s.executeUpdate("""
                CREATE TABLE IF NOT EXISTS stock(
                sid INT AUTO_INCREMENT PRIMARY KEY,
                pid INT,
                changeQty INT,
                dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP)
                """);
        } catch(SQLException e) {
            System.out.println("DB error: "+e.getMessage());
        }
    }

    public static void save(Product p) {
        String q="MERGE INTO products KEY(id) VALUES(?,?,?,?,?,?)";
        try(Connection c=con(); PreparedStatement ps=c.prepareStatement(q)) {
            ps.setInt(1,p.getId());
            ps.setString(2,p.getName());
            ps.setDouble(3,p.getPrice());
            ps.setInt(4,p.getQty());
            ps.setInt(5,p.getMinQty());
            ps.setString(6,p.getType());
            ps.executeUpdate();
        } catch(SQLException e) {
            System.out.println("DB error: "+e.getMessage());
        }
    }

    public static void delete(int id) {
        try(Connection c=con();
            PreparedStatement ps=c.prepareStatement("DELETE FROM products WHERE id=?")) {
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch(SQLException e) {
            System.out.println("DB error: "+e.getMessage());
        }
    }

    public static void addSup(Supplier s) {
        String q="MERGE INTO suppliers KEY(id) VALUES(?,?,?)";
        try(Connection c=con(); PreparedStatement ps=c.prepareStatement(q)) {
            ps.setInt(1,s.getId());
            ps.setString(2,s.getName());
            ps.setString(3,s.getPhone());
            ps.executeUpdate();
        } catch(SQLException e) {
            System.out.println("DB error: "+e.getMessage());
        }
    }

    public static void stockLog(int id,int n) {
        try(Connection c=con();
            PreparedStatement ps=c.prepareStatement(
                "INSERT INTO stock(pid,changeQty) VALUES(?,?)")) {
            ps.setInt(1,id);
            ps.setInt(2,n);
            ps.executeUpdate();
        } catch(SQLException e) {
            System.out.println("DB error: "+e.getMessage());
        }
    }

    public static void showStockLog() {
        try(Connection c=con();
            Statement s=c.createStatement();
            ResultSet r=s.executeQuery("SELECT * FROM stock ORDER BY sid")) {
            System.out.println("\nStock Movement History");
            while(r.next())
                System.out.println(r.getInt("pid")+" | "+r.getInt("changeQty")+" | "+r.getTimestamp("dt"));
        } catch(SQLException e) {
            System.out.println("DB error: "+e.getMessage());
        }
    }
}
