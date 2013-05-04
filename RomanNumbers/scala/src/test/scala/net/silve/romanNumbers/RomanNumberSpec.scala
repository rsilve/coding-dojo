package net.silve.romanNumbers

import org.specs2.mutable._
import net.silve.romanNumbers.RomanNumberImplicits._

class RomanNumberSpec extends Specification {

  "The 'I' RM" should {

    "be valid" in {
      "I".isValidRomanNumber must beTrue
    }

    "equal 1" in {
      "I".romanValue must beEqualTo(1)
    }

  }

  "The 'V' RM" should {

    "be valid" in {
      "V".isValidRomanNumber must beTrue
    }

    "equal 5" in {
      "V".romanValue must beEqualTo(5)
    }

  }

  "The 'X' RM" should {

    "be valid" in {
      "X".isValidRomanNumber must beTrue
    }

    "equal 10" in {
      "X".romanValue must beEqualTo(10)
    }

  }

  "The 'L' RM" should {

    "be valid" in {
      "L".isValidRomanNumber must beTrue
    }

    "equal 50" in {
      "L".romanValue must beEqualTo(50)
    }

  }

  "The 'C' RM" should {

    "be valid" in {
      "C".isValidRomanNumber must beTrue
    }

    "equal 100" in {
      "C".romanValue must beEqualTo(100)
    }

  }

  "The 'D' RM" should {

    "be valid" in {
      "D".isValidRomanNumber must beTrue
    }

    "equal 500" in {
      "D".romanValue must beEqualTo(500)
    }

  }

  "The 'M' RM" should {

    "be valid" in {
      "M".isValidRomanNumber must beTrue
    }

    "equal 1000" in {
      "M".romanValue must beEqualTo(1000)
    }

  }

  "The 'E' RM" should {

    "not be valid" in {
      "E".isValidRomanNumber must beFalse
    }
  }

  "The 'II' RM" should {

    "be valid" in {
      "II".isValidRomanNumber must beTrue
    }

    "equal 2" in {
      "II".romanValue must beEqualTo(2)
    }
  }
  "The 'III' RM" should {

    "be valid" in {
      "III".isValidRomanNumber must beTrue
    }

    "equal 3" in {
      "III".romanValue must beEqualTo(3)
    }
  }

  "The 'IV' RM" should {

    "be valid" in {
      "IV".isValidRomanNumber must beTrue
    }

    "equal 4" in {
      "IV".romanValue must beEqualTo(4)
    }
  }
  "The 'VI' RM" should {

    "be valid" in {
      "VI".isValidRomanNumber must beTrue
    }

    "equal 6" in {
      "VI".romanValue must beEqualTo(6)
    }
  }

}