name := "WikiSparkJobServer"

version := "1.0.0"

scalaVersion := "2.11.7"

scalacOptions ++= Seq("-deprecation")

lazy val buildSettings = Seq(
  version := "0.1-SNAPSHOT"
)

resolvers += "Ooyala Bintray" at "http://dl.bintray.com/ooyala/maven"

libraryDependencies ++= Seq (
  "joda-time" % "joda-time" % "2.3",
  "org.joda" % "joda-convert" % "1.2",
"org.apache.spark" %% "spark-core" % "1.3.1" % "provided",
  "ooyala.cnd" % "job-server" % "0.4.0" % "provided"
)


    