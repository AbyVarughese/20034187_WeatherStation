package models;
import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Reading extends Model {
  public String name;
  public int code;
  public String weather;
  public double temperature;
  public double windSpeed;
  public double windDirection;
  public int pressure;


  public Reading(String name,  int code, String weather, double temperature, double windSpeed, double windDirection, int pressure) {
    this.name = name;
    this.code = code;
    this.weather = weather;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.windDirection = windDirection;
    this.pressure = pressure;
  }
}
