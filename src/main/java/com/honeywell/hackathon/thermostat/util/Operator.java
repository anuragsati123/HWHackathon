package com.honeywell.hackathon.thermostat.util;

public enum Operator {

  Greater(">"), Smaller("<");

  String value;

  public String getValue() {
    return value;
  }

  Operator(String op) {
    this.value = op;
  }

}
