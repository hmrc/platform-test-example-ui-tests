import sbt.*

object Dependencies {

  val test: Seq[ModuleID] = Seq(
//    "uk.gov.hmrc" %% "ui-test-runner" % "0.51.0" % Test
//    "uk.gov.hmrc" %% "ui-test-runner" % "0.53.0-SNAPSHOT" % Test
    "uk.gov.hmrc" %% "ui-test-runner-platui-3896" % "0.7.0" % Test
  )

}
