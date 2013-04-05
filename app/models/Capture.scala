package models

import root._
import com.mongodb.casbah.Imports._

case class Capture(id: Long, x: Double, y: Double)

object Capture {

 def create(id: Long, x: Long, y: Long) {
   val capture = MongoDBObject("id" -> id, "x" -> x, "y" -> y)
   Global.collection.insert(capture)
 }

 def all(id: Long) = {
   val query = MongoDBObject("id" -> id)
   Global.collection.find(query).toArray
 }

 def createFromString(string: String) = {
   val parsed: rapture.io.Json = rapture.io.Json.parse(string)
   val id: Long = parsed.id.toString.toDouble.toLong
   val x: Long = parsed.X.toString.toDouble.toLong
   val y: Long = parsed.Y.toString.toDouble.toLong
   create(id, x, y)
 }
}
