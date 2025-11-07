import sbt.*

object Dependencies {

  val test: Seq[ModuleID] = Seq(
    // "uk.gov.hmrc"            %% "ui-test-runner" % "0.48.0" % Test,
    "ch.qos.logback"              % "logback-classic" % "1.5.20",
    "com.typesafe"                % "config"          % "1.4.5",
    "com.typesafe.scala-logging" %% "scala-logging"   % "3.9.6",
    "com.vladsch.flexmark"        % "flexmark-all"    % "0.64.8",
    "org.scalatest"              %% "scalatest"       % "3.2.19",
    "org.seleniumhq.selenium"     % "selenium-java"   % "4.38.0"
  )

}
