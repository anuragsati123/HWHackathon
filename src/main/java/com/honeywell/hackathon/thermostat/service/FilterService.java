package com.honeywell.hackathon.thermostat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.honeywell.hackathon.thermostat.FilterDto;
import com.honeywell.hackathon.thermostat.entity.FilterEntity;
import com.honeywell.hackathon.thermostat.repository.FilterRepository;

@Service
public class FilterService {

  @Autowired
  FilterRepository filterRepository;

  public FilterDto getFilterData(Long deviceId) {
    FilterDto filterDto = new FilterDto(">", 0L);
    FilterEntity filterEntity = filterRepository.findByDeviceId(deviceId);
    if (filterEntity != null) {
      filterDto.setComparisonOperator(filterEntity.getComparisonOperator());
      filterDto.setFilterValue(filterEntity.getFilterValue());
    }
    return filterDto;
  }

  public void setFilterData(Long deviceId, String comparisonOperator, Long filterValue) {
    FilterEntity filterEntity = new FilterEntity(deviceId, comparisonOperator, filterValue);
    filterRepository.save(filterEntity);
  }
}
