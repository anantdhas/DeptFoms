lazy val scalaV = "2.12.4"

// val initCommands =
//   """import schedule._; import Aug2016Scheduler._; import Aug2016._"""

libraryDependencies += "com.lihaoyi" % "ammonite" % "1.0.3" % "test" cross CrossVersion.full

libraryDependencies += "net.jcazevedo" %% "moultingyaml" % "0.4.1-SNAPSHOT"

sourceGenerators in Test += Def.task {
  val file = (sourceManaged in Test).value / "amm.scala"
  val initCommands =
    """import schedule._; import Jan2018Scheduler._; import Jan2018._; import net.jcazevedo.moultingyaml._; import net.jcazevedo.moultingyaml.DefaultYamlProtocol._"""
  IO.write(
    file,
    s"""object amm extends App { ammonite.Main("$initCommands").run() }""")
  Seq(file)
}.taskValue

lazy val root = (project in file("."))
  .settings(name := "Course-Timings", version := "1.0", scalaVersion := scalaV)
