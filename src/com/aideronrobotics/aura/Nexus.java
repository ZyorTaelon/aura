/* 
 * Copyright (C) 2012 Jason Parks
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/. 
 */

package com.aideronrobotics.aura;

/*
 * The Nexus is used to bridge all calls to the underlying Datacore's.
 */
public final class Nexus {
	private static final Nexus INSTANCE = new Nexus();
	
	public static final Nexus getInstance() {
		return INSTANCE;
	}
	
	private Datacore datacore;
	
	private Nexus() {
	}
	
	public void setDatacore(Datacore datacore) {
		this.datacore = datacore;
	}
	
	private void ensureDatacore() {
		if (datacore == null) {
			throw new IllegalStateException("Datacore was not set");
		}
	}
	
	public Type getType(int typeID) {
		ensureDatacore();
		return datacore.getType(typeID);
	}
}
