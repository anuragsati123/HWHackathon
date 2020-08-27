package com.honeywell.hackathon.thermostat;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.honeywell.hackathon.thermostat.service.DeviceDataService;
import com.honeywell.hackathon.thermostat.service.FilterService;

@Service
public class IOTFactory {

  private static final Logger LOG = LoggerFactory.getLogger(IOTFactory.class);

  @Autowired
  DeviceDataService deviceDataService;

  @Autowired
  FilterService filterService;

  public ResponseEntity<Object> acceptTelemetryData(long deviceId, List<Long> temperatures) {
    try {
      deviceDataService.saveTelemetryData(deviceId, temperatures);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      LOG.error("Exception", e);
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }



  public ResponseEntity<Object> setFilter(long deviceId, String filterData) {
    try {
      String operator = filterData.substring(4, 5);
      Long value = Long.valueOf(filterData.substring(5));
      filterService.setFilterData(deviceId, operator, value);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      LOG.error("Exception", e);
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  public ResponseEntity<Object> getTelemetryData(long deviceId) {
    try {
      List<Long> list = new ArrayList<>();
      FilterDto filterDto = filterService.getFilterData(deviceId);
      if (filterDto.getComparisonOperator().equals("<")) {
        list = deviceDataService.getTelemetryDataLessThanGivenTemp(deviceId,
            filterDto.getFilterValue());
      } else {
        list = deviceDataService.getTelemetryDataMoreThanGivenTemp(deviceId,
            filterDto.getFilterValue());
      }
      return new ResponseEntity<>(list, HttpStatus.OK);
    } catch (Exception e) {
      LOG.error("Exception", e);
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

}
