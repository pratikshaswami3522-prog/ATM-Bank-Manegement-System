package bank.manegement.system;

import java.sql.*;

public class Connector {
    Connection connection;
    Statement statement;
    public Connector()
    {
        try
        {
          connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem","root","1234567");
          statement = connection.createStatement();
        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
