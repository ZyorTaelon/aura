/* 
 * Copyright (C) 2012 Jason Parks
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/. 
 */

package com.aideronrobotics.aura;

public class Type {
    private int typeID;
    private int groupID;
    private String typeName;
    private String description;
    private float radius;
    private float mass;
    private float volume;
    private float capacity;
    private int portionSize;
    private int raceID;
    private int published;
    private int marketGroupID;
    private int categoryID;
    
    public Type() {
    }
    
	public int getTypeID() {
		return typeID;
	}

	public int getGroupID() {
		return groupID;
	}

	public String getTypeName() {
		return typeName;
	}

	public String getDescription() {
		return description;
	}

	public float getRadius() {
		return radius;
	}

	public float getMass() {
		return mass;
	}

	public float getVolume() {
		return volume;
	}

	public float getCapacity() {
		return capacity;
	}

	public int getPortionSize() {
		return portionSize;
	}

	public int getRaceID() {
		return raceID;
	}

	public int getPublished() {
		return published;
	}

	public int getMarketGroupID() {
		return marketGroupID;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	public void setMass(float mass) {
		this.mass = mass;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public void setCapacity(float capacity) {
		this.capacity = capacity;
	}

	public void setPortionSize(int portionSize) {
		this.portionSize = portionSize;
	}

	public void setRaceID(int raceID) {
		this.raceID = raceID;
	}

	public void setPublished(int published) {
		this.published = published;
	}

	public void setMarketGroupID(int marketGroupID) {
		this.marketGroupID = marketGroupID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
}
