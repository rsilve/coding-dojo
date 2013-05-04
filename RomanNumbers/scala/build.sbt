import sbt._

name := "RomanNumber"

version := "1.0"


addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.4.0")

libraryDependencies += "org.specs2" %% "specs2" % "1.12.3" % "test"


resolvers ++= Seq("snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
                  "releases"  at "http://oss.sonatype.org/content/repositories/releases")
