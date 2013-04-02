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
      val x: Long = parsed.X.toString.toDouble.toLong
      val y: Long = parsed.Y.toString.toDouble.toLong
      Capture.create(id, x, y)
      Ok
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
