package DBTest;

import java.sql.*;

public class DatabaseTest {
    public static void main(String[] args) {
        /* to build the connection with the database
        we need 3 things, URL, usernme, password*/
       String url="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
       String username="syntax_hrm";
       String password="syntaxhrm123";

       //we need to establish the connection to the datatbase
        try {
           Connection conn= DriverManager.getConnection(url,username,password);
            System.out.println("Connection is created for batch 15");
            //create a statement to send sql queries
            Statement statement=conn.createStatement();

            //when we  sendd any query to the database then db returns
            //result set(tables with rows and columns)
           ResultSet rset= statement.executeQuery("select FirstName, LastName from person");
           rset.next();

           String fName=rset.getString("FirstName");
           String lNname= rset.getNString("LastName");

            rset.next();
            fName=rset.getString("FirstName");
            lNname= rset.getNString("LastName");
            System.out.println(fName+" "+lNname);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
