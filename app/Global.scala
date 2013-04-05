package root

import play.api._
import com.mongodb.casbah.Imports._

object Global extends GlobalSettings {
  val collection = MongoClient("localhost")("segments")("captures")
}
