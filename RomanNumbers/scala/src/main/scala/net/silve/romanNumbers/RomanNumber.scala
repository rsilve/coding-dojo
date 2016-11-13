package net.silve.romanNumbers


/*
 * On definit une conversion implicit sur les String
 * afin de pouvoir manipuler les nombre romain comme des chaine de caracteres.
 *
 * On pourra utiliser "CXV".romanValue
 * Cette methode renvoi un Option[Int]
 * (None signifiant que ce n'est pas un nombre romain valide)
 *
 * Il suffit de rajouter l'import
 * import net.silve.romanNumbers.RomanNumberImplicits._
 */

object RomanNumberImplicits {

  // Conversion implicite
  implicit def String2RomanNumber(value : String) = String2RomanNumberClass(value)
  // Conversion implicite
  implicit def Int2RomanString(value : Int) = Int2RomanStringClass(value)

  // L'object sous-jacent a la conversion.
  case class String2RomanNumberClass(desc: String) extends RomanConversions {
    // valeur
    def romanValue = toInt(desc)
  }

  // L'object sous-jacent a la conversion.
  case class Int2RomanStringClass(value: Int) extends RomanConversions {
    // valeur
    def romanString = toRoman(value)
  }


}
