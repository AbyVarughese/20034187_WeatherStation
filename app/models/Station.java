package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model
{
  public String name;
  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();
  public int code;
  public String weather;
  public double temperature;
  public double windSpeed;
  public int pressure;



  public Station(String name, int code, String weather, double temperature, double windSpeed, int pressure)
  {
    this.name = name;
    this.code = code;
    this.weather = weather;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.pressure = pressure;
  }
  public double getTemperatureC() {
        Reading reading = this.readings.get(this.readings.size()-1);
  return reading.temperature;
  }
  public double getTemperatureF() {
    if (readings.size() == 0)  { return 0.0; }
    Reading reading = this.readings.get(this.readings.size()-1);
    return Math.round(reading.temperature * (9.0 / 5.0) + 32);
  }
  public String getWeather() {
    if (readings.size() == 0)  { return ""; }
    Reading reading = this.readings.get(this.readings.size()-1);
    if(reading.code == 100) { return "Clear"; }
    if(reading.code == 200) { return "Partial clouds"; }
    if(reading.code == 300) { return "Cloudy"; }
    if(reading.code == 400) { return "Light Showers"; }
    if(reading.code == 500) { return "Heavy Showers"; }
    if(reading.code == 600) { return "Rain"; }
    if(reading.code == 700) { return "Snow"; }
    if(reading.code == 800) { return "Thunder"; }
    return "0";
  }
  public String getWindSpeed(){
    if (readings.size() == 0)  { return ""; }
    Reading reading = this.readings.get(this.readings.size()-1);
    if(reading.windSpeed == 1) { return "0"; }
    if(reading.windSpeed >= 2 && reading.windSpeed <=5 ){ return "1"; }
    if(reading.windSpeed >= 6 && reading.windSpeed <=11) { return "2"; }
    if(reading.windSpeed >= 12 && reading.windSpeed <=19) { return "3"; }
    if(reading.windSpeed >= 20 && reading.windSpeed <=28) { return "4"; }
    if(reading.windSpeed >= 29 && reading.windSpeed <=38) { return "5"; }
    if(reading.windSpeed >= 39 && reading.windSpeed <=49) { return "6"; }
    if(reading.windSpeed >= 50 && reading.windSpeed <=61) { return "7"; }
    if(reading.windSpeed >= 62 && reading.windSpeed <=74) { return "8"; }
    if(reading.windSpeed >= 75 && reading.windSpeed <=88) { return "9"; }
    if(reading.windSpeed >= 89 && reading.windSpeed <=102) { return "10"; }
    if(reading.windSpeed >= 103 && reading.windSpeed <=117) { return "11"; }
    return "0";
  }
  public int getPressure() {
    if (readings.size() == 0)  { return 0; }
    Reading reading = this.readings.get(this.readings.size()-1);
    return reading.pressure;
  }
}