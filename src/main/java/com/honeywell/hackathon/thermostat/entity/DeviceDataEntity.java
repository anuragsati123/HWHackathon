package com.honeywell.hackathon.thermostat.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceDataEntity implements Serializable {

  private static final long serialVersionUID = -3176022443000309686L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Long deviceId;
  private Long temperature;

  public DeviceDataEntity(long deviceId, long temperature) {
    this.deviceId = deviceId;
    this.temperature = temperature;
  }

}
