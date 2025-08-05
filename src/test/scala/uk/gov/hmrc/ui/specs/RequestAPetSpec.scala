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

package uk.gov.hmrc.ui.specs

import uk.gov.hmrc.ui.pages.RequestAPet
import uk.gov.hmrc.ui.pages.RequestAPet.successful
import uk.gov.hmrc.ui.specs.tags.ExampleTaggedTest

class RequestAPetSpec extends BaseSpec {

  Feature("Request a pet") {

    // This test is tagged with 'ExampleTaggedTest' to demonstrate how to use ScalaTest tags.
    // To run tagged tests only, use the sbt command shown in run-tests.sh.
    Scenario("User requests a dog", ExampleTaggedTest) {

      Given("I am on the request a pet service")
      RequestAPet.goTo()

      When("I submit a request for a dog")
      RequestAPet.chooseDog()
      RequestAPet.itWillBeAroundChildren()
      RequestAPet.itIsWantedFromTheStartOfTheYear()
      RequestAPet.itIsWantedUntilTheEndOfTheYear()
      RequestAPet.confirmAnswers()
      RequestAPet.makePayment()

      Then("I receive confirmation that my request was successful")
      RequestAPet.confirmation should be(successful)
    }

    Scenario("User requests a cat") {

      Given("I am on the request a pet service")
      RequestAPet.goTo()

      When("I submit a request for a cat")
      RequestAPet.chooseCat()
      RequestAPet.itWillBeAroundChildren()
      RequestAPet.itIsWantedFromTheStartOfTheYear()
      RequestAPet.itIsWantedUntilTheEndOfTheYear()
      RequestAPet.confirmAnswers()
      RequestAPet.makePayment()

      Then("I receive confirmation that my request was successful")
      RequestAPet.confirmation should be(successful)
    }
  }
}
