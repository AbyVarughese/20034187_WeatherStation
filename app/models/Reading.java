package models;
import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Reading extends Model
{
  public String name;
  public int code;
  public String weather;
  public double temp;
  public double wind;


  
  public Reading(String name, int code, String weather, double temp, double wind)
  {
    this.name = name;
    this.code = code;
    this.weather = weather;
    this.temp = temp;
    this.wind = wind;
  }
}
