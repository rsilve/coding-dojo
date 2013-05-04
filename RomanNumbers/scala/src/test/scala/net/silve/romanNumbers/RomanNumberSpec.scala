package net.silve.romanNumbers

import org.specs2.mutable._
import net.silve.romanNumbers.RomanNumberImplicits._

class RomanNumberSpec extends Specification {

  "The 'I' RM" should {

    "be valid" in {
      "I".isValid must beTrue
    }

    "equal 1" in {
      "I" must beEqualTo(1)
    }

  }
}