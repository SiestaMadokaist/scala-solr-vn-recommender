name := "ez-dance"

version := "0.1.0"

scalaVersion := "2.11.3"

libraryDependencies ++= Seq(
  "com.github.takezoe" %% "solr-scala-client" % "0.0.13",
  "org.scalacheck" %% "scalacheck" % "1.13.2" % "test",
  "com.typesafe.slick" %% "slick" % "2.1.0",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "mysql" % "mysql-connector-java" % "5.1.+"
)
