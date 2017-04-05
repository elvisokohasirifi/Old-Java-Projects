import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database1 {	
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String dbDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
		String dbDriverString = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=C:\\Users\\sirel\\Desktop\\DatabaseTrial.mdb;DriverID=22;READONLY=false}";
		Class.forName(dbDriver);
		Connection con = DriverManager.getConnection(dbDriverString, "", "");
		Statement stmt = con.createStatement();
		ResultSet results = stmt.executeQuery("SELECT [Employee name], Salary, [Employee number], department FROM Employees where [Created by] = 'Emma Forson'");
		//results.next();
		String s = "";
		while(results.next()){
			for(int i = 1 ; i <= results.getMetaData().getColumnCount();i++)
				s += (results.getString(i) + "\t");
			s += "\n";
		}
//		int updatecount = stmt.executeUpdate("INSERT INTO Users(Username,email,password) VALUES ('Dickson','fredallotey200@gmail.com','frederick')");
//		con.commit();
//		stmt.close();
//		con.close();
	}

}
