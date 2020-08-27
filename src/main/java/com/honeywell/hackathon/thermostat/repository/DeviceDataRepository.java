package com.honeywell.hackathon.thermostat.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.honeywell.hackathon.thermostat.entity.DeviceDataEntity;

@Repository
public interface DeviceDataRepository extends JpaRepository<DeviceDataEntity, Long> {

  List<DeviceDataEntity> findByDeviceIdAndTemperatureGreaterThan(long deviceId, long temperature);

  List<DeviceDataEntity> findByDeviceIdAndTemperatureLessThan(long deviceId, long temperature);

}
