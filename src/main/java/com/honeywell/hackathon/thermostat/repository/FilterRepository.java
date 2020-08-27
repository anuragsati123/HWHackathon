package com.honeywell.hackathon.thermostat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.honeywell.hackathon.thermostat.entity.FilterEntity;

@Repository
public interface FilterRepository extends JpaRepository<FilterEntity, Long> {

  FilterEntity findByDeviceId(long deviceId);

}
