package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import models._

object Application extends Controller {

  def index = Action {
    Ok(views.html.Application.index("Your new application is ready."))
  }

  def capture(id: Long) = Action {
    Ok(views.html.Application.capture(id))
  }

  def create(id: Long) = Action {
    implicit request =>
      val body: AnyContent = request.body
      val value = body.asJson.get.toString
      val parsed: rapture.io.Json = rapture.io.Json.parse(value)
      val x: Double = parsed.X.toString.toDouble
      val y: Double = parsed.Y.toString.toDouble
      Capture.create(id, x, y)
      Ok
  }

  def display(id: Long) = Action {
    Ok(views.html.Application.display())
  }

}
