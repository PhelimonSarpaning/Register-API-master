package edu.uark.dataaccess;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

import com.heroku.sdk.jdbc.DatabaseUrl;

public class DatabaseAccessor {
	public static Connection getDatabaseConnection() throws SQLException, URISyntaxException {
		return DatabaseUrl.extract().getConnection();
	}
}
