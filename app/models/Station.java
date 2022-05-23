package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model {
  public String name;
  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();
  public double latitude;
  public double longitude;

  public Station(String name,double latitude, double longitude) {
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public double getTemperatureC() {
    if (readings.size() == 0)  { return 0.0; }
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


  public double getMaxTemp() {
    if (readings.size() == 0)  { return 0.0; }
    double max = -100.0;
    for (int i = 0; i < readings.size(); i++) {
      Reading reading = readings.get(i);
      if (reading.temperature > max) {
        max = reading.temperature;
      }
    }
    return max;
  }
  public double getMinTemp() {
    if (readings.size() == 0)  { return 0.0; }
    double min = 100;
    for (int i = 0; i < readings.size(); i++) {
      Reading reading = readings.get(i);
      if (reading.temperature < min) {
        min = reading.temperature;
      }
    }
    return min;
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

  public double getMaxWindSpeed() {
    if (readings.size() == 0)  { return 0.0; }
    double max = -100.0;
    for (int i = 0; i < readings.size(); i++) {
      Reading reading = readings.get(i);
      if (reading.windSpeed > max) {
        max = reading.windSpeed;
      }
    }
    return max;
  }
  public double getMinWindSpeed() {
    if (readings.size() == 0)  { return 0; }
    double min = 100.0;
    for (int i = 0; i < readings.size(); i++) {
      Reading reading = readings.get(i);
      if (reading.windSpeed < min) {
        min = reading.windSpeed;
      }
    }
    return min;
  }

  public double getWindChill() {
    if (readings.size() == 0)  { return 0.0; }
    Reading reading = this.readings.get(this.readings.size()-1);

    return Math.round(13.12 + (0.6215 * reading.temperature ) - (11.37 * Math.pow(reading.windSpeed, 0.16)) + (0.3965 * reading.temperature) * (Math.pow(reading.windSpeed, 0.16)) );
   }

  public String getWindDirection(){
    if (readings.size() == 0)  { return ""; }
    Reading reading = this.readings.get(this.readings.size()-1);
    if(reading.windDirection >= 348.76 && reading.windDirection <= 11.25 ){ return "North"; }
    if(reading.windDirection >= 11.26 && reading.windDirection <= 33.75) { return "NorthNorthEast"; }
    if(reading.windDirection >= 33.76 && reading.windDirection <= 56.25) { return "NorthEast"; }
    if(reading.windDirection >= 56.26 && reading.windDirection <= 78.75) { return "EastNorthEast"; }
    if(reading.windDirection >= 78.76 && reading.windDirection <= 101.25) { return "East"; }
    if(reading.windDirection >= 101.25 && reading.windDirection <= 123.75) { return "EastSouthEast"; }
    if(reading.windDirection >= 123.76 && reading.windDirection <= 146.25) { return "SouthEast"; }
    if(reading.windDirection >= 146.26 && reading.windDirection <= 168.75) { return "SouthSouthEast"; }
    if(reading.windDirection >= 168.76 && reading.windDirection <= 191.25) { return "South"; }
    if(reading.windDirection >= 191.26 && reading.windDirection <= 213.75) { return "SouthSouthWest"; }
    if(reading.windDirection >= 213.76 && reading.windDirection <= 235.25) { return "SouthWest"; }
    if(reading.windDirection >= 235.26 && reading.windDirection <= 258.75) { return "WestSouthWest"; }
    if(reading.windDirection >= 258.76 && reading.windDirection <= 281.25) { return "West"; }
    if(reading.windDirection >= 281.26 && reading.windDirection <= 303.75) { return "WestNorthWest"; }
    if(reading.windDirection >= 303.76 && reading.windDirection <= 326.25) { return "NorthWest"; }
    if(reading.windDirection >= 326.26 && reading.windDirection <= 348.75) { return "NorthNorthWest"; }
    return "0";
  }

  public int getPressure() {
    if (readings.size() == 0)  { return 0; }
    Reading reading = this.readings.get(this.readings.size()-1);
    return reading.pressure;
  }
  public int getMaxPressure() {
    if (readings.size() == 0)  { return 0; }
    int max = -1000;
    for (int i = 0; i < readings.size(); i++) {
      Reading reading = readings.get(i);
      if (reading.pressure > max) {
        max = reading.pressure;
      }
    }
    return max;
  }
  public int getMinPressure() {
    if (readings.size() == 0)  { return 0; }
    int min = 10000;
    for (int i = 0; i < readings.size(); i++) {
      Reading reading = readings.get(i);
      if (reading.pressure < min) {
        min = reading.pressure;
      }
    }
    return min;
  }


}