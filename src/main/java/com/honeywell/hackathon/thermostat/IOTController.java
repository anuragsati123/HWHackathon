package com.honeywell.hackathon.thermostat;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/device/{deviceId}")
public class IOTController {

  @Autowired
  IOTFactory iotFactory;

  /***
   * 
   * This API accepts the temperature data from the device
   * 
   * @param deviceId
   * @param temperatures
   * @return
   */
  @PostMapping(value = "/data", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> acceptTelemetryData(@PathVariable long deviceId,
      @RequestBody List<Long> temperatures) {
    return iotFactory.acceptTelemetryData(deviceId, temperatures);
  }

  /***
   * This API helps to set the filter on the device data
   * 
   * @param deviceId
   * @param filterData
   * @return
   */
  @PostMapping(value = "/filter", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> setDeviceFilter(@PathVariable long deviceId,
      @RequestParam("filterData") String filterData) {
    return iotFactory.setFilter(deviceId, filterData);
  }

  /***
   * This API helps fetch the fitered data for a device
   * 
   * @param deviceId
   * @return
   */
  @GetMapping(value = "/data", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getTelemetryData(@PathVariable long deviceId) {
    return iotFactory.getTelemetryData(deviceId);
  }

}
