ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.0"

// versions

val cucumberVersion = "8.16.0"
val cucumberJUnitVersion = "7.13.0"
val junitVersion = "4.13.2"
val junitInterfaceVersion = "0.11"

// settings

lazy val root = (project in file("."))
  .settings(
    name := "Peer Review Community",
    idePackagePrefix := Some("community.review"),
    libraryDependencies ++= Seq(
      "io.cucumber" %% "cucumber-scala" % cucumberVersion % "test",
      "io.cucumber" % "cucumber-junit" % cucumberJUnitVersion % "test",
      "junit" % "junit" % junitVersion % "test",
      "com.novocode" % "junit-interface" % junitInterfaceVersion % "test"
    )
  )
