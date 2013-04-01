package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.Application.index("Your new application is ready."))
  }

  def capture(id: Long) = Action {
    Ok(views.html.Application.capture())
  }

  def display(id: Long) = Action {
    Ok(views.html.Application.display())
  }

}
