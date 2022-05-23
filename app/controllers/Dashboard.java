package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    if (member != null) {
      List<Station> stations = member.stations;
      Collections.sort(stations, new Comparator<Station>() {
        @Override
        public int compare(Station s1, Station s2) {
          return s1.name.compareTo(s2.name);
        }
      });
      render("dashboard.html", member, stations);
    }
    else {
      render("login.html");
        }
  }

  public static String getMemberName() {
    Member member = Accounts.getLoggedInMember();
    return member.firstname + " " + member.lastname;
  }

  public static void addStation(String name, String weather, double latitude, double longitude) {
    if (!name.isBlank()) {
      Station station = new Station(name, latitude, longitude);
      Logger.info("Adding a new station called " + name);
      station.save();

      Member member = Accounts.getLoggedInMember();
      Logger.info("Adding a new station to member " + member.email);

      member.stations.add(station);
      member.save();
    }
    redirect("/dashboard");
  }

  public static void deleteStation(Long id) {
    Station station = Station.findById(id);
    Logger.info("Removing id " + station.id);
    List<Member> allMembers = Member.findAll();
    for (int i = 0; i < allMembers.size(); i++) {
      Member member = allMembers.get(i);
      member.stations.remove(station);
      member.save();
    }
    station.delete();
    redirect("/dashboard");
  }
}
