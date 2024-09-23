package app.project.uno.project1.database;

import java.sql.*;


public class Concepts {

    public String sqlQuery(int ID){
        StringBuilder output = new StringBuilder();

        String hostname = "localhost";
        String port = "1521";
        String serviceName = "XEPDB1";
        String username = "hr";
        String p = "hr";

        String jdbcUrl = "jdbc:oracle:thin:@" + hostname + ":" + port + "/" + serviceName;

        Connection con = null;

        //try catch block
        try{
            //load jdbc driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //Establish the connection
            con = DriverManager.getConnection(jdbcUrl,username,p);
            output.append("Connected\n");

            //Create a statement
            Statement statement = con.createStatement();

            //Execute query
            String sql = "select  first_name as FirstName,last_name, salary, hire_date  from employees where employee_id= " + ID;
            //Store in the resultset
            ResultSet resultSet = statement.executeQuery(sql);

            //get the resultset metadata
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();


//            output.append("---------Table Data----------\n");
//            for(int i = 1; i <= columnCount; i++){
//                output.append(rsmd.getColumnName(i) + "\t");
//            }

            System.out.println();

//            for(int i = 1; i <= columnCount; i++){
//                System.out.print("---------- \t");
//            }

            //print result set
            while(resultSet.next()){
                for(int i = 1; i <= columnCount; i++){
                    String value = resultSet.getString(i);
                    output.append(value + "\t");
                }
                System.out.println();


            }

        }catch(Exception e){
            System.out.println(e);
        }


        return output.toString();
    }
    public String sqlQuery2(int ID, int salary){
        StringBuilder output = new StringBuilder();

        String hostname = "localhost";
        String port = "1521";
        String serviceName = "XEPDB1";
        String username = "hr";
        String p = "hr";

        String jdbcUrl = "jdbc:oracle:thin:@" + hostname + ":" + port + "/" + serviceName;

        Connection con = null;

        //try catch block
        try{
            //load jdbc driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //Establish the connection
            con = DriverManager.getConnection(jdbcUrl,username,p);
            output.append("Connected\n");

            //Create a statement
            Statement statement = con.createStatement();

            //Execute query
            String sql1 = "update employees\n" +
                    "set salary = \n" + salary +
                    "where employee_id =" + ID;

            String sql = "select  first_name as FirstName,last_name, salary, hire_date  from employees where employee_id= " + ID;
            //Store in the resultset
            statement.executeQuery(sql1);
            ResultSet resultSet = statement.executeQuery(sql);

            //get the resultset metadata
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();


//            output.append("---------Table Data----------\n");
//            for(int i = 1; i <= columnCount; i++){
//                output.append(rsmd.getColumnName(i) + "\t");
//            }

            System.out.println();

//            for(int i = 1; i <= columnCount; i++){
//                System.out.print("---------- \t");
//            }

            //print result set
            while(resultSet.next()){
                for(int i = 1; i <= columnCount; i++){
                    String value = resultSet.getString(i);
                    output.append(value + "\t");
                }
                System.out.println();


            }

        }catch(Exception e){
            System.out.println(e);
        }


        return output.toString();
    }



    public static void main(String args[]){

        Concepts query = new Concepts();
//        query.sqlQuery2Insert(2220,131);
        query.sqlQuery(131);
//        query.sqlQuery3();





    }
}

