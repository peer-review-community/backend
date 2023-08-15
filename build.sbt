ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.0"

// versions

val cucumberVersion = "8.16.0"
val cucumberJUnitVersion = "7.13.0"
val junitVersion = "4.13.2"
val junitInterfaceVersion = "0.11"
val http4sVersion = "1.0.0-M40"

// settings

lazy val root = (project in file("."))
  .settings(
    name := "Peer Review Community",
    idePackagePrefix := Some("community.review"),
    libraryDependencies ++= Seq(

      // BDD configuration

      "io.cucumber" %% "cucumber-scala" % cucumberVersion % "test",
      "io.cucumber" % "cucumber-junit" % cucumberJUnitVersion % "test",
      "junit" % "junit" % junitVersion % "test",
      "com.novocode" % "junit-interface" % junitInterfaceVersion % "test",

      // Property testing configuration

      "org.scalactic" %% "scalactic" % "3.2.16",
      "org.scalatest" %% "scalatest" % "3.2.16" % "test",
      "org.scalacheck" %% "scalacheck" % "1.17.0" % "test",
      "org.scalatestplus" %% "scalacheck-1-17" % "3.2.16.0" % "test",

      // cats + cats-effect

      "org.typelevel" %% "cats-core" % "2.10.0",
      "org.typelevel" %% "cats-effect" % "3.5.1",

      // Slick for database access

      "com.typesafe.slick" %% "slick" % "3.5.0-M4",
      "org.slf4j" % "slf4j-nop" % "1.7.26",
      "com.typesafe.slick" %% "slick-hikaricp" % "3.5.0-M4",

      // http4s

      "org.http4s" %% "http4s-ember-server" % http4sVersion,
      "org.http4s" %% "http4s-ember-client" % http4sVersion,
      "org.http4s" %% "http4s-dsl" % http4sVersion,

    )
  )
