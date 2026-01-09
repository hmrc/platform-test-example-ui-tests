/*
 * Copyright 2025 HM Revenue & Customs
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

package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import uk.gov.hmrc.configuration.TestEnvironment
import org.openqa.selenium.support.ui.Select
import uk.gov.hmrc.selenium.webdriver.Driver

object CreateAnAccount extends BasePage {

  val continueButton: By = By.className("govuk-button")

  private val url: String = TestEnvironment.url("platform-test-example-frontend")

  def goTo(): Unit = {
    get(url)
    fluentWait.until(ExpectedConditions.urlContains(url))
  }

  def chooseCreateAnAccount(): Unit = {
    val createAnAccountButton: By = By.id("value_0")
    selectCheckbox(createAnAccountButton)
    click(continueButton)
  }

  def addAName(): Unit = {
    val accountNameInput: By = By.id("value")
    sendKeys(accountNameInput, "Persons Name")
    click(continueButton)
  }

  def addAnEmail(): Unit = {
    val accountEmailInput: By = By.id("value")
    sendKeys(accountEmailInput, "PersonsEmail")
    click(continueButton)
  }

  def selectALocation(): Unit = {
    val locationNameInput: By = By.id("value")
    sendKeys(locationNameInput, "Germany")
    click(continueButton)
  }

}
