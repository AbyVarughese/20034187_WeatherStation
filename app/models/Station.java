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
  public double temp;
  public double wind;



  public Station(String name, int code, String weather, double temp, double wind)
  {
    this.name = name;
    this.code = code;
    this.weather = weather;
    this.temp = temp;
    this.wind = wind;
  }
}