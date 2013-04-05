package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.iteratee._
import models._

object Application extends Controller {

  def index = Action {
    Ok(views.html.Application.index("Your new application is ready."))
  }

  def capture(id: Long) = Action {
    Ok(views.html.Application.capture(id))
  }

  def ws = WebSocket.using[String] { request =>
    val in = Iteratee.foreach[String](Capture.createFromString)
    val out = Enumerator("OK")

    (in, out)
  }

  def display(id: Long) = Action {
    val list : Array[Map[String,Long]] = Capture.all(id).map{
      obj => Map("id" -> obj.get("id").toString.toDouble.toLong,
                  "x" -> obj.get("x").toString.toDouble.toLong,
                  "y" -> obj.get("y").toString.toDouble.toLong)
    }
    val jsonString = Json.stringify(Json.toJson(list))
    Ok(views.html.Application.display(jsonString))
  }

}
