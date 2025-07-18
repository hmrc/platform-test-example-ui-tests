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
import java.time.Year

object RequestAPet extends BasePage {

  private val url: String = TestEnvironment.url("platform-test-example-frontend")

  def goTo(): Unit = {
    get(url)
    fluentWait.until(ExpectedConditions.urlContains(url))
  }

  protected val continueButton: By = By.className("govuk-button")

  def chooseDog(): Unit = {
    val dogRadioButton: By = By.id("value_1")
    selectCheckbox(dogRadioButton)
    click(continueButton)
  }

  def chooseCat(): Unit = {
    val catRadioButton: By = By.id("value_0")
    selectCheckbox(catRadioButton)
    click(continueButton)
  }

  def itWillBeAroundChildren(): Unit = {
    val yesRadioButton: By = By.id("value")
    selectCheckbox(yesRadioButton)
    click(continueButton)
  }

  def submitDate(day: String, month: String, year: String): Unit = {
    val dayInput: By   = By.id("value.day")
    val monthInput: By = By.id("value.month")
    val yearInput: By  = By.id("value.year")

    sendKeys(dayInput, day)
    sendKeys(monthInput, month)
    sendKeys(yearInput, year)

    click(continueButton)
  }

  private val currentYear = Year.now().toString

  def itIsWantedFromTheStartOfTheYear(): Unit =
    submitDate("01", "01", currentYear)

  def itIsWantedUntilTheEndOfTheYear(): Unit =
    submitDate("01", "01", currentYear)

  def confirmAnswers(): Unit =
    click(continueButton)

  def makePayment(): Unit = {
    val accountNameInput: By   = By.id("AccountName")
    val sortCodeInput: By      = By.id("SortCode")
    val accountNumberInput: By = By.id("AccountNumber")
    val makePaymentButton: By  = By.className("govuk-button")

    sendKeys(accountNameInput, "Persons Name")
    sendKeys(sortCodeInput, "123456")
    sendKeys(accountNumberInput, "112233")

    click(makePaymentButton)
  }

  def confirmation: String =
    getText(By.tagName("h1"))

  val successful: String = "Pet requested"
}
