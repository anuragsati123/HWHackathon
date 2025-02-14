package com.honeywell.hackathon.thermostat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterDto {

  private String comparisonOperator;
  private Long filterValue;

}
