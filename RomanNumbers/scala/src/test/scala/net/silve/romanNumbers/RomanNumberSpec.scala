package net.silve.romanNumbers

import org.specs2.mutable._
import net.silve.romanNumbers.RomanNumberImplicits._

class RomanNumberSpec extends Specification {

  "The 'I' RM" should {

    "be valid" in {
      "I".romanValue must beSome
    }

    "equal 1" in {
      "I".romanValue must beSome(1)
    }

  }

  "The 'V' RM" should {

    "be valid" in {
      "V".romanValue must beSome
    }

    "equal 5" in {
      "V".romanValue must beSome(5)
    }

  }

  "The 'X' RM" should {

    "be valid" in {
      "X".romanValue must beSome
    }

    "equal 10" in {
      "X".romanValue must beSome(10)
    }

  }

  "The 'L' RM" should {

    "be valid" in {
      "L".romanValue must beSome
    }

    "equal 50" in {
      "L".romanValue must beSome(50)
    }

  }

  "The 'C' RM" should {

    "be valid" in {
      "C".romanValue must beSome
    }

    "equal 100" in {
      "C".romanValue must beSome(100)
    }

  }

  "The 'D' RM" should {

    "be valid" in {
      "D".romanValue must beSome
    }

    "equal 500" in {
      "D".romanValue must beSome(500)
    }

  }

  "The 'M' RM" should {

    "be valid" in {
      "M".romanValue must beSome
    }

    "equal 1000" in {
      "M".romanValue must beSome(1000)
    }

  }

  "The 'E' RM" should {

    "not be valid" in {
      "E".romanValue must beNone
    }
  }
  "The 'VEI' RM" should {

    "not be valid" in {
      "VEI".romanValue must beNone
    }
  }

  "The 'II' RM" should {

    "be valid" in {
      "II".romanValue must beSome
    }

    "equal 2" in {
      "II".romanValue must beSome(2)
    }
  }
  "The 'III' RM" should {

    "be valid" in {
      "III".romanValue must beSome
    }

    "equal 3" in {
      "III".romanValue must beSome(3)
    }
  }

  "The 'IV' RM" should {

    "be valid" in {
      "IV".romanValue must beSome
    }

    "equal 4" in {
      "IV".romanValue must beSome(4)
    }
  }
  "The 'VI' RM" should {

    "be valid" in {
      "VI".romanValue must beSome
    }

    "equal 6" in {
      "VI".romanValue must beSome(6)
    }
  }


}