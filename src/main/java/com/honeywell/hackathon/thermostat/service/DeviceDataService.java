package com.honeywell.hackathon.thermostat.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.honeywell.hackathon.thermostat.entity.DeviceDataEntity;
import com.honeywell.hackathon.thermostat.repository.DeviceDataRepository;

@Service
public class DeviceDataService {

  @Autowired
  DeviceDataRepository deviceDataRepository;

  public void saveTelemetryData(long deviceId, List<Long> temperatures) {
    List<DeviceDataEntity> deviceDataEntities = new ArrayList<DeviceDataEntity>();
    for (Long temperature : temperatures) {
      deviceDataEntities.add(new DeviceDataEntity(deviceId, temperature));
    }
    deviceDataRepository.saveAll(deviceDataEntities);
  }

  public List<Long> getTelemetryDataMoreThanGivenTemp(Long deviceId, Long temperature) {
    List<DeviceDataEntity> list =
        deviceDataRepository.findByDeviceIdAndTemperatureGreaterThan(deviceId, temperature);
    return list.stream().map(e -> e.getTemperature()).collect(Collectors.toList());
  }

  public List<Long> getTelemetryDataLessThanGivenTemp(Long deviceId, Long temperature) {
    List<DeviceDataEntity> list =
        deviceDataRepository.findByDeviceIdAndTemperatureLessThan(deviceId, temperature);
    return list.stream().map(e -> e.getTemperature()).collect(Collectors.toList());
  }

}
