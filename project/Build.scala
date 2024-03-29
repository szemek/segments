import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "segments"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    "com.propensive" % "rapture-io" % "0.7.2",
    "org.mongodb" %% "casbah" % "2.5.0",
    jdbc,
    anorm
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
