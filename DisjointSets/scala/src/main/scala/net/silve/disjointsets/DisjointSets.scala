package net.silve.disjointsets


/*
 * On definit une conversion implicit sur les String
 * afin de pouvoir manipuler les nombre romain comme des chaine de caracteres.
 *
 * On pourra utiliser "CXV".romanValue
 * Cette methode renvoi un Option[Int]
 * (None signifiant que ce n'est pas un nombre romain valide)
 *
 * Il suffit de rajouter l'import
 * import net.silve.disjointsets.RomanNumberImplicits._
 */

object RomanNumberImplicits {

  // Conversion implicite
  implicit def String2RomanNumber(value : String) = RomanNumber(value)

  // helper pour pouvoir comparer deux "unite romaine"
  // et calculer l'increment d'une unite sur l'autre
  case class RomanToken(c: Char, score: Option[Int]) {

    val v: Option[Int] = value(c);

    def value(c: Char) = c match {
      case 'I'  => Some(1)
      case 'V'  => Some(5)
      case 'X'  => Some(10)
      case 'L'  => Some(50)
      case 'C'  => Some(100)
      case 'D'  => Some(500)
      case 'M'  => Some(1000)
      case _    => None
    }

    // get the new value if the current char is ok and no error before
    // (ie score is not empty)
    def addTo(p: Option[Char]): Option[Int] = {
      (v, score) match {
        case (Some(k), Some(s)) => Some( incr(p, k, s) )
        case _                  => None
      }
    }

    // increment or decrement the current value of the roman number
    // Assume that p is allright (it must have been parse on previous step)
    def incr(p: Option[Char],k: Int, s: Int) = p map { c =>
      if (k < value(c).get) s - k else  s + k
    } getOrElse(s + k)


  }

  // L'object sous-jacent a la conversion.
  case class RomanNumber(desc: String) {

    // a la creation de l'instance on parse la chaine de caratere
    // pour obtenir : la valeur, et la validite
    val parse = {
      desc.reverseIterator.foldLeft[(Option[Int], Option[Char])](Some(0), None){ (prev, curr) =>
        ( RomanToken(curr, prev._1).addTo(prev._2), Some(curr))
      }
    }

    // valeur
    def romanValue = parse._1

  }


}
