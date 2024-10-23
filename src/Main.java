

import java.sql.*;

public class Main {

    public static final String DB_URL = "jdbc:mysql://localhost:3306/sakila";
    public static final String USER = "root";
    public static final String PASSWORD = "05xJunaid";


    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Connecting to DB...");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Successfully connected to MySQL");


            statement = connection.createStatement();

            String querry = "SELECT * FROM actor";
            ResultSet resultSet = statement.executeQuery(querry);



            while(resultSet.next()){
                int id = resultSet.getInt("actor_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Timestamp lastUpdated = resultSet.getTimestamp("last_update");
                System.out.println("ID: "+ id+", First Name: "+ firstName+", Last Name: "+lastName+", Last Update: "+lastUpdated);
            }
            resultSet.close();



        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }finally{

            try{
                if(connection!=null){
                    connection.close();
                }
            }catch(SQLException se){
                se.printStackTrace();
            }

        }

    }
}