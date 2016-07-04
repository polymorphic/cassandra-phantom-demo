import sbt.Keys._
import sbt._
import com.websudos.phantom.sbt.PhantomSbtPlugin

lazy val commonSettings = Seq(
  organization := "com.microworkflow"
  , scalaVersion := "2.11.8"
  , version := "0.0.1-SNAPSHOT"
  , resolvers ++= Seq("Websudos releases" at "https://dl.bintray.com/websudos/oss-releases/")
  , libraryDependencies ++= {
    val akkaVersion = "2.4.2"
    val phantomVersion = "1.25.4" // http://outworkers.github.io/phantom/
    Seq("com.github.nscala-time" %% "nscala-time" % "2.12.0"
      , "com.typesafe.akka" %% "akka-actor" % akkaVersion
      , "com.typesafe.akka" %% "akka-testkit" % akkaVersion
      , "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.7.2"
      , "com.websudos" %% "phantom-dsl" % phantomVersion
      , "com.websudos" %% "phantom-testkit" % "1.12.2" % "test"
      , "org.scalatest" %% "scalatest" % "2.2.6" % "test"
      , "org.scalacheck" %% "scalacheck" % "1.12.5" % "test"
    )
  }
  , javaOptions ++= Seq("-Djava.net.preferIPv4Stack=true")
  , scalacOptions ++= Seq("-unchecked", "-deprecation", "-Xlint", "-Ywarn-dead-code", "-encoding", "UTF-8")
)

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .enablePlugins(PhantomSbtPlugin)

fork in run := true