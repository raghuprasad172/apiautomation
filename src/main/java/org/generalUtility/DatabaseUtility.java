package org.generalUtility;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DatabaseUtility {
    FileUtility fileUtility = new FileUtility();
    Connection connection = null;
    ResultSet resultSet =null;
    public void connectToDB(){
        try {
             connection = DriverManager.getConnection(fileUtility.getDataFromPropertyFile("DB_URL"),
                    fileUtility.getDataFromPropertyFile("DB_Username"),
                    fileUtility.getDataFromPropertyFile("DB_Password"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void closeDb(){
        try {
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query){
            try {
              resultSet= connection.createStatement().executeQuery(query);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        return resultSet;
    }
    public void executeQueryAndVerifyData(String query, int colummnIndex, String expectedData){
        boolean flag = false;
        try {
           resultSet= connection.createStatement().executeQuery(query);
           while (resultSet.next()){
               if (resultSet.getString(colummnIndex).equals(expectedData)){
                   flag = true;
                   break;
               }

           }
           if (flag){
               System.out.println(expectedData+" data verified in the data base table");
           }
           else
               System.out.println(colummnIndex+"data not found in the data vase table");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
