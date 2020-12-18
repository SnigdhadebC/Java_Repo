package com.application;

import java.sql.*;

public class OracleDBConnection {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        String url = "";
        String username = "";
        String password = "";
        //1. Register the driver class
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //2. Establish Connection to the DB and created a connection object
            connection = DriverManager.getConnection(url,username,password);
            //3. Create a statement object
            statement = connection.createStatement();
            //4. Execute the query using statement object and it returns a result set
            String sql = "select emp_id,emp_name,sal from Employee";
            rs = statement.executeQuery(sql);

            // iterate
            while(rs.next())
            {
                System.out.println(rs.getString("emp_id")); // 01
                System.out.println(rs.getString("emp_name")); // Snigdhadeb
                System.out.println(rs.getInt("sal")); // 10
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        // Close the connection objects
        finally {
            statement.close();
            rs.close();
            connection.close();
        }

    }
}
