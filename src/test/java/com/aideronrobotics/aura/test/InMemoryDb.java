package com.aideronrobotics.aura.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InMemoryDb {

	public static void loadSql(String sqlFile) {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection connection = DriverManager.getConnection("jdbc:hsqldb:mem:aura", "sa", "");
			Statement statement = connection.createStatement();
			List<String> queries = getQueries(sqlFile);
			for (String query : queries) {
				System.out.println("\""+query+";\"");
				statement.execute(query);
			}
		} catch (SQLException e) {
			System.out.println("Error issuing query. ");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Error setting up in memory database." + e.toString());
        	e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading from sql file." + e.toString());
        	e.printStackTrace();
		}
	}

	private static List<String> getQueries(String sqlFile) throws IOException {
		List<String> queries = new ArrayList<String>();
		InputStream sqlStream = getSqlStream(sqlFile);
		DataInputStream in = new DataInputStream(sqlStream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		StringBuilder query = new StringBuilder();
		while ((strLine = br.readLine()) != null) {
			// Print the content on the console
			strLine = strLine.trim();
			if(!strLine.contains(";")) {
				if(query.length() > 0)
					query.append(' ');
				query.append(strLine);
			} else {
				String[] split = strLine.split(";");
				if(query.length() > 0)
					query.append(' ');
				query.append(split[0]);
				queries.add(query.toString());
				query = new StringBuilder();
				if(split.length > 1)
					query.append(split[1]);
			}
		}
		in.close();
		return queries;
	}

	private static InputStream getSqlStream(String sqlFile) throws IOException {
		URL url = InMemoryDb.class.getResource(sqlFile);
		URLConnection urlConn = url.openConnection();
		urlConn.setUseCaches(false);
		return urlConn.getInputStream();
	}
}