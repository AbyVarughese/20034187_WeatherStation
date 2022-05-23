package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Member;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;



public class Dashboard extends Controller {
  public static void index() {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();

    List<Station> stations = member.stations;

    render("dashboard.html", member, stations);
  }


  public static void addStation(String name, String weather,double latitude, double longitude ) {
    if (!name.isBlank()){
      Station station = new Station(name,latitude,longitude);
      Logger.info("Adding a new station called " + name);
      station.save();

      Member member = Accounts.getLoggedInMember();
      Logger.info("Adding a new station to member " + member.email);

      member.stations.add(station);
      member.save();
    }
    redirect("/dashboard");
  }

}
