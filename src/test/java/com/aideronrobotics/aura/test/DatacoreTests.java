/* 
 * Copyright (C) 2012 Jason Parks
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/. 
 */

package com.aideronrobotics.aura.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.aideronrobotics.aura.Nexus;
import com.aideronrobotics.aura.Type;

public class DatacoreTests {
	
	@Before
	public void setup() {
		InMemoryDb.loadSql("/invTypes.sql");
		InMemoryDb.loadSql("/invGroups.sql");
		
		Nexus nexus = Nexus.getInstance();
		nexus.setDatacore(new TestDatacore());
	}
	
	@Test
	public void testTypeLoad() {
		Nexus nexus = Nexus.getInstance();
		Type type = nexus.getType(626);
		
		assertNotNull(type);
		
		assertEquals(626, type.getTypeID());
		assertEquals("Vexor", type.getTypeName());
		assertEquals(26, type.getGroupID());
		
		assertNotNull(type.getDescription());
		
		float delta = 0.001f;
		
		assertEquals(110, type.getRadius(), delta);
		assertEquals(10310000, type.getMass(), delta);
		assertEquals(115000, type.getVolume(), delta);
		assertEquals(480, type.getCapacity(), delta);
		
		assertEquals(1, type.getPortionSize());
		assertEquals(8, type.getRaceID());
		assertEquals(1, type.getPublished());
		assertEquals(76, type.getMarketGroupID());
		assertEquals(6, type.getCategoryID());
	}
}
