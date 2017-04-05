
import java.sql.*;
public class AccessDB{
    private static Connection con = null;
    public static void main(String[] args){
    try{
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=C:\\Users\\sirel\\Desktop\\DatabaseTrial.mdb;DriverID=22;READONLY=false}","","");
        if(con!=null){
            Statement stm = con.createStatement();
            // create statement is used to create a table
            try {stm.execute("create table studentdata ( roll_no number, name varchar(20), address varchar(30) )");}
            catch(Exception e){}
            // insert statement is used to insert new record into a table
            stm.execute("insert into studentdata values(01,'Bhagirath Kumar','Rajrappa')");
            stm.execute("insert into studentdata values(02,'Arvind Kumar','Ramgarh')");
            stm.execute("insert into studentdata values(03,'Saurav Kumar','Ranchi')");
           // update statement is used to update existing records in a table
           stm.execute("update studentdata set name='Kamla Kant', address='Kolkata' where roll_no=01");
           // select statement is used to retrieve record from table
           stm.execute("select * from studentdata");
           ResultSet rs = stm.getResultSet();
           if (rs != null){
               while ( rs.next() ){
                   System.out.println("========================================" );
                   System.out.println("Roll Number : " + rs.getString(1) );
                   System.out.println("Name : " + rs.getString(2) );
                   System.out.println("Address : " + rs.getString(3) );
                   System.out.println("========================================" );
             }
         }
        // delete statement is used to delete record from table
       //stm.execute("delete * from studentdata");
   }
   con.close();
} catch (Exception e) {
e.printStackTrace();
}
}
}