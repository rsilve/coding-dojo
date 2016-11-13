package net.silve.dojo

object Main {

  def main(args: Array[String]) = {
    val fizzbuzz = fizzes zip buzzes map words

    val fizzbuzzOrNumber = fizzbuzz zip numbers map wordsOrNumber

    print(fizzbuzzOrNumber take(150) mkString("\n"))
  }

  val fizzes = Stream.continually(Seq("", "", "Fizz")).flatten

  val buzzes = Stream.continually(Seq("", "", "", "", "Buzz")).flatten

  val numbers = Stream.from(1)

  def words = { v: (String, String) =>
    v match {
      case ("", "") => None
      case (fizz, buzz) => Some(s"$fizz$buzz")
    }
  }

  def wordsOrNumber = { v: (Option[String], Int) =>
    v match {
      case (Some(e), _) => e
      case (_, e: Int) => e.toString
    }
  }
}
