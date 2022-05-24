package controllers;

import models.Member;
import play.Logger;
import play.mvc.Controller;
// controller handles sign up login register and authentication
public class Accounts extends Controller {
  public static void signup() {
    render("signup.html");
  }

  public static void login() {
    render("login.html");
  }
// register the member
  public static void register(String firstname, String lastname, String email, String password) {
    Logger.info("Registering new user " + email);
    Member member = new Member(firstname, lastname, email, password);
    member.save();
    redirect("/");

  }
// authentication
  public static void authenticate(String email, String password) {
    Logger.info("Attempting to authenticate with " + email + ":" + password);

    Member member = Member.findByEmail(email);
    if ((member != null) && (member.checkPassword(password) == true)) {
      Logger.info("Authentication successful");
      session.put("logged_in_Memberid", member.id);
      redirect("/dashboard");
    } else {
      Logger.info("Authentication failed");
      redirect("/login");
    }
  }

  public static void account() {
    Member member = getLoggedInMember();
    render("account.html", member);
  }
// this is used to edit the member details . other than email which cannot be changed
  public static void edit(String firstname, String lastname, String email, String password) {
    Member member = getLoggedInMember();
    member.firstname = firstname;
    member.lastname = lastname;
    //member.email=email;
    if (!password.isEmpty()) {
      member.password = password;
    }
    member.save();
    //render("account.html", member);
    redirect("/dashboard");


  }

  public static void logout() {
    session.clear();
    redirect("/");
  }

  public static Member getLoggedInMember() {
    Member member = null;
    if (session.contains("logged_in_Memberid")) {
      String memberId = session.get("logged_in_Memberid");
      member = Member.findById(Long.parseLong(memberId));
    } else {
      login();
    }
    return member;
  }
}