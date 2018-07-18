name := """JavaAuthService"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "io.jsonwebtoken" % "jjwt" % "0.6.0"
)
libraryDependencies += filters