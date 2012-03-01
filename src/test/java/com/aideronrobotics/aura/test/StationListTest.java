package com.aideronrobotics.aura.test;

import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.eve.conquerablestationlist.ApiStation;
import com.beimin.eveapi.eve.conquerablestationlist.ConquerableStationListParser;
import com.beimin.eveapi.eve.conquerablestationlist.StationListResponse;

public class StationListTest {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void getStations() throws ApiException {
		ConquerableStationListParser stationListParser = ConquerableStationListParser.getInstance();
		StationListResponse stationListResponse = stationListParser.getResponse();
		Map<Integer, ApiStation> stations = stationListResponse.getStations();
		for (ApiStation station : stations.values()) {
			logger.info(station.getSolarSystemID()+" - "+station.getStationName()+" - "+station.getCorporationName());
		}
	}
}