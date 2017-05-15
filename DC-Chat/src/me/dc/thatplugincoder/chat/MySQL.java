package me.dc.thatplugincoder.chat;

import org.bukkit.entity.Player;

import java.sql.*;

/**
 * Created by gebruiker on 11-3-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: DC-Chat
 * Package: me.dc.thatplugincoder.chat
 */
public class MySQL {

    public MySQL(String h, String d, String u, String p, Integer port) {
        MySQL.database = d;
        MySQL.username = u;
        MySQL.password = p;
        MySQL.port = port;
        MySQL.host = h;
    }
    public static Connection connection;
    private static String host, database, username, password;
    private static int port;

    public static void openConnection(String h, String d, String u, String p, Integer port) throws SQLException, ClassNotFoundException {
        if (connection != null && !connection.isClosed()) {
            return;
        }

        synchronized (MySQL.class) {
            if (connection != null && !connection.isClosed()) {
                return;
            }
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://"+MySQL.host+":"+MySQL.port+"/"+ MySQL.database,MySQL.username,MySQL.password);
        }
    }
    public static void closeConnection() {
        try {
            MySQL.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static String get(Player player) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT rank FROM Users where uuid=?;");
            statement.setString(1, player.getUniqueId().toString());
            statement.executeQuery();
            ResultSet rs = statement.getResultSet();
            if (rs.next()) {
                return rs.getString("rank");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "[[Failed to connect]]";
        }
        return "404 Error";
    }

    public static void set(Player player, String Rank) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Users(UUID, Rank, Name) VALUES (?, ?, ?);");
            statement.setString(1, player.getUniqueId().toString());
            statement.setString(2, Rank);
            statement.setString(3, player.getName().toString());
            statement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean playerExists(Player p) {
        try {
            PreparedStatement st = MySQL.connection.prepareStatement("SELECT * FROM Users WHERE UUID=?;");
            st.setString(1, p.getUniqueId().toString());
            st.executeQuery();
            ResultSet rs = st.getResultSet();


            if(rs.absolute(1)) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public static void setRank(Player player, String Rank) {
        try {
            PreparedStatement statement = MySQL.connection.prepareStatement("UPDATE Users SET Rank=? WHERE UUID=?;");
            statement.setString(1, Rank);
            statement.setString(2, player.getUniqueId().toString());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
