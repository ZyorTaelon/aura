/* 
 * Copyright (C) 2012 Jason Parks
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/. 
 */

package com.aideronrobotics.aura.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.aideronrobotics.aura.Datacore;
import com.aideronrobotics.aura.Type;

public class TestDatacore implements Datacore {
	private Connection connection;
	
    public TestDatacore() {
        String url = "jdbc:hsqldb:mem:aura";
        String user = "sa";
        String password = "";
        try {
        	Class.forName("org.hsqldb.jdbcDriver");
        	connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
        	System.out.println("Error issuing query. " + e.toString());
        	e.printStackTrace();
        } catch (ClassNotFoundException e) {
        	System.out.println("Error setting up in memory database." + e.toString());
        	e.printStackTrace();
		}
    }
    
    public Type getType(int typeID) {
    	try {
			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT " +
					"i.typeID,i.groupID,typeName,i.description,radius,mass,volume,capacity," +
					"portionSize,raceID,i.published,marketGroupID,g.categoryID " +
					"FROM invTypes AS i LEFT JOIN invGroups AS g ON g.groupID = i.groupID " +
					"WHERE typeID = " + typeID);
			if (rs.next()) {
				Type type = new Type();
				type.setCapacity(rs.getFloat("capacity"));
				type.setCategoryID(rs.getInt("categoryID"));
				type.setDescription(rs.getString("description"));
				type.setGroupID(rs.getInt("groupID"));
				type.setMarketGroupID(rs.getInt("marketGroupID"));
				type.setMass(rs.getFloat("mass"));
				type.setPortionSize(rs.getInt("portionSize"));
				type.setPublished(rs.getInt("published"));
				type.setRaceID(rs.getInt("raceID"));
				type.setRadius(rs.getFloat("radius"));
				type.setTypeID(rs.getInt("typeID"));
				type.setTypeName(rs.getString("typeName"));
				type.setVolume(rs.getFloat("volume"));
				
				return type;
			}
		} catch (SQLException e) {
			System.out.println("Error issuing query. " + e.toString());
        	e.printStackTrace();
		}
    	
    	return null;
    }
}
