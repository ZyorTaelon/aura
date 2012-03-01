CREATE TABLE invTypes (
	typeID INTEGER PRIMARY KEY,
	groupID INTEGER,
	typeName VARCHAR(100),
	description VARCHAR(3000),
	graphicID INTEGER,
	radius FLOAT,
	mass FLOAT,
	volume FLOAT,
	capacity FLOAT,
	portionSize INTEGER,
	raceID INTEGER,
	basePrice FLOAT,
	published INTEGER,
	marketGroupID INTEGER,
	chanceOfDuplicating FLOAT,
	iconID INTEGER
);
INSERT INTO invTypes VALUES (626,26,'Vexor','The Vexor is a strong combat ship that is also geared to operate in a variety of other roles. The Vexor is especially useful for surveying in potentially hostile sectors as it can stay on duty for a very long time before having to return to base. Furthermore, it is well capable of defending itself against even concentrated attacks.\n\nGallente Cruiser Skill Bonus: 5% bonus to Medium Hybrid Turret damage and 10% bonus to drone hitpoints, damage and mining yield per skill level.\n\n',62,110,10310000,115000,480,1,8,4377500,1,76,0.07,NULL);
