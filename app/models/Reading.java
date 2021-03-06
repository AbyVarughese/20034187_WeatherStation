package models;

import javax.persistence.Entity;
import java.util.Date;

import play.db.jpa.Model;
// this class represents the single reading
@Entity
public class Reading extends Model {
  public String name;
  public Date dateTime;
  public int code;
  public String weather;
  public double temperature;
  public double windSpeed;
  public double windDirection;
  public int pressure;

  public Reading(String name, int code, String weather, double temperature, double windSpeed, double windDirection, int pressure) {
    this.name = name;
    this.dateTime = new Date();
    this.code = code;
    this.weather = weather;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.windDirection = windDirection;
    this.pressure = pressure;
  }
}
