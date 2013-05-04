package net.silve.romanNumbers


/*
 * On definit une conversion implicit sur les String
 * afin de pouvoir manipuler les nombre romain comme des chaine de caracteres.
 *
 * On pourra utilise "CXV".romanValue ou "CXV".isValidRomanNumber
 *
 * Il suffit de rajouter l'import
 * import net.silve.romanNumbers.RomanNumberImplicits._
 */

object RomanNumberImplicits {

  // Conversion implicite
  implicit def String2RomanNumber(value : String) = RomanNumber(value)

  // helper pour incrementer la valeur lors du parsing
  // en se basant sur le caractere courant et le precedant (de gauche a droite)
  def compute(score: Int, prev: Option[Char] ,value: RomanToken,  curr: Char) = {
    prev match {
      case Some(p) => {
        if (RomanToken(curr) < RomanToken(p)) {
          (score - value.v, Some(curr), true)
        } else {
          (score + value.v, Some(curr), true)
        }
      }
      case _       => (score + value.v, Some(curr), true)
    }
  }

  // helper pour pouvoir comparer deux "unite romaine"
  case class RomanToken(c: Char) {
    val v = c match {
      case 'I' => 1
      case 'V' => 5
      case 'X' => 10
      case 'L' => 50
      case 'C' => 100
      case 'D' => 500
      case 'M' => 1000
      case _ => -1
    }
    def <(r: RomanToken) = v < r.v
  }

  // L'object sous-jacent a la conversion.
  case class RomanNumber(desc: String) {

    // a la creation de l'instance on parse la chaine de caratere
    // pour obtenir : la valeur, et la validite
    val parse = {
      desc.reverseIterator.foldLeft[(Int, Option[Char], Boolean)](0, None, true){(prev, curr) =>
          if (! prev._3) {
            (-1, None, false)
          }  else {
            curr match {
              case 'I'|'V'|'X'|'L'|'C'|'D'|'M' => compute(prev._1, prev._2, RomanToken(curr), curr)
              case _ => {
                (-1, None, false)
              }
            }
          }
      }
    }

    // validite
    def isValidRomanNumber = parse._3

    // valeur
    def romanValue = parse._1

  }


}
