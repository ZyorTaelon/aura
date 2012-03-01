CREATE TABLE invGroups (
	groupID INTEGER PRIMARY KEY,
	categoryID INTEGER,
	groupName VARCHAR(100),
	description VARCHAR(3000),
	iconID INTEGER,
	useBasePrice INTEGER,
	allowManufacture INTEGER,
	allowRecycler INTEGER,
	anchored INTEGER,
	anchorable INTEGER,
	fittableNonSingleton INTEGER,
	published INTEGER
);
INSERT INTO invGroups VALUES (26,6,'Cruiser','',NULL,0,1,1,0,0,0,1);