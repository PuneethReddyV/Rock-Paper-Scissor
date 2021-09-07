name := "RockPaperScissor"

version := "0.1"

scalaVersion := "2.13.3"

resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq (
  "org.scalamock" %% "scalamock" % "5.1.0" % Test,
  "org.scalatest" %% "scalatest" % "3.1.0" % Test
)
