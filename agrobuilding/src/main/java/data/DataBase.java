package data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//	Database class provides methods for working with database.

public class DataBase {

	private Connection connection = null;
	private static final Logger log = LogManager.getLogger(DataBase.class);

// 	For AgroBuild BD
	private String MySQL_PADB_DB_USER = "ship";
	private String MySQL_PADB_DB_PASSWORD = "onRequest";
// 	I will provide password ("onRequest") on demand to email: comsilium@gmail.com
	
	// Constructor opens connection to database using connection string
	public DataBase(String dataBaseURL, String driver) throws IOException,
				ClassNotFoundException, SQLException {

// 		Load driver for JDBC class
		Class.forName(driver);

// 		Create a connection to the database
		connection = DriverManager.getConnection(dataBaseURL,
				MySQL_PADB_DB_USER, MySQL_PADB_DB_PASSWORD);
		log.info("Connection: " + connection);
	}
	
	/*
	 * That method gets SQL [Select COLUMN_NAME from TABLE_NAME where ...] query
	 * as parameter and returns result as String
	 */
	public String selectValue(String query) throws SQLException {

// 		Create statement for connection, execute query and save outcome in
// 		ResultSet
		Statement stm = connection.createStatement();
		ResultSet rSet = stm.executeQuery(query);
		ResultSetMetaData meta = rSet.getMetaData();

// 		Retrieve value from ResultSet
		String value = "";

		if (rSet.next()) {
			if (rSet.getObject(1) != null) {
				value = rSet.getObject(1).toString();

				if (meta.getColumnType(1) == 93) {
					value = value.substring(0, value.length() - 2);
				}
			}
		}

		stm.close();
		value = value.trim();
		return value;
	}
	
// 	Close connection to the database
	public void close() throws SQLException {
		connection.close();
	}
}
