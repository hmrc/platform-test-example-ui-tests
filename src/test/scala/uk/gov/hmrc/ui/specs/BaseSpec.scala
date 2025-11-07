/*
 * Copyright 2023 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ui.specs

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.{BeforeAndAfterEach, GivenWhenThen}

trait BaseSpec extends AnyFeatureSpec with GivenWhenThen with Matchers with BeforeAndAfterEach {

  object Driver {

    implicit var instance: WebDriver = new ChromeDriver(chromeOptions())

  }

//  override def beforeEach(): Unit =
//    Driver.instance.manage().window().maximize()

//  override def afterEach(): Unit =
//  //  Driver.instance.quit()
//
}

def chromeOptions(): ChromeOptions = {
  val options: ChromeOptions = new ChromeOptions
  options.setBrowserVersion("128")
  options.addArguments("--disable-search-engine-choice-screen")
  options.addArguments(
    "--disable-features=OptimizationGuideModelDownloading,OptimizationHintsFetching,OptimizationTargetPrediction,OptimizationHints"
  )
  // options.addArguments("--remote-debugging-pipe")
  options.addArguments("--enable-unsafe-extension-debugging")
  options.addArguments(
    "--disable-backgrounding-occluded-window"
  )
  options.addArguments("--disable-gpu")
  options.addArguments("--disable-renderer-backgrounding")
  options.addArguments("--disable-background-timer-throttling")
  options.addArguments("--disable-dev-shm-usage")
  options.addArguments("--allow-pre-commit-input")
  options.addArguments("--disable-features=MediaRouter")
  // options.addArguments("--window-size=1600,1080")
  options.addArguments("--enable-automation")
  options.addArguments("--disable-client-side-phishing-detection")
  options.addArguments("--disable-component-extensions-with-background-pages")
  options.addArguments("--disable-default-apps")
  // options.addArguments("--disable-extensions")
  options.addArguments("--disable-application-cache")
  options.addArguments("--ignore-certificate-errors")
  options.addArguments("--disable-web-security")
  options.addArguments("--allow-running-insecure-content")
  options.addArguments("--disable-features=InterestFeedContentSuggestions")
  options.addArguments("--disable-features=Translate")
  options.addArguments("--hide-scrollbars")
  options.addArguments("--mute-audio")
  options.addArguments("--no-default-browser-check")
  options.addArguments("--no-first-run")
  options.addArguments("--ash-no-nudges")
  options.addArguments("--disable-search-engine-choice-screen")
  options.addArguments("--propagate-iph-for-testing")
  // options.addArguments("--window-position=-2400,-2400")
  options.setAcceptInsecureCerts(true)

  options

}
