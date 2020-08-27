package com.honeywell.hackathon.thermostat.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterEntity implements Serializable {

  private static final long serialVersionUID = 3932999313153584306L;

  @Id
  private Long deviceId;
  private String comparisonOperator;
  private Long filterValue;

}
