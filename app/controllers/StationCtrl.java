package controllers;

import java.time.LocalDateTime;
import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class StationCtrl extends Controller {
  public static void index(Long id) {
    Station station = Station.findById(id);
    Logger.info("Station id = " + Station.count());
    render("station.html", station);
  }

  public static void deletereading(Long id, Long readingid) {
    Station station = Station.findById(id);
    Reading reading = Reading.findById(readingid);
    Logger.info("Removing" + reading.name);
    station.readings.remove(reading);
    station.save();
    reading.delete();
    render("station.html", station);
  }


  public static void addReading(Long id, String name, int code, String weather, double temperature, double windSpeed, double windDirection, int pressure) {
    if (code == 100 || code == 200 || code == 300 || code == 400 || code == 500 || code == 600 || code == 700 || code == 800) {
      Reading reading = new Reading(name, code, weather, temperature, windSpeed, windDirection, pressure);
      Station station = Station.findById(id);
      station.readings.add(reading);
      station.save();
      //redirect("/stations/" + id);
    } else {
      Logger.warn("code invalid");
    }
    redirect("/stations/" + id);
  }
}
