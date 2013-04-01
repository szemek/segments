package models

import com.mongodb.casbah.Imports._

case class Capture(id: Long, x: Integer, y: Integer)

object Capture {
  val client = MongoClient()
  val collection = client("segments")("captures")

  def create(id: Long, x: Integer, y: Integer) {
    val capture = MongoDBObject("id" -> id, "x" -> x, "y" -> y)
    collection.insert(capture)
  }

  def all(id: Long) {
    val query = MongoDBObject("id" -> id)
    collection.find(query).toList
  }
}
