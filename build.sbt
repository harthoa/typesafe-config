name := "proj-template"
organization := "com.hart"
version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "3.7" % "test",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.4.0",
  "ch.qos.logback" % "logback-classic" % "1.1.7",

  "com.typesafe" % "config" % "1.3.1"
)