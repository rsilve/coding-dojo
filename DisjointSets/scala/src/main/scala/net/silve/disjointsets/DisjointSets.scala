package net.silve.disjointsets

import scala.collection.GenSet


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

object DisjointSetsImplicits {

  // Conversion implicite
  implicit def Set2Set[T](value : GenSet[GenSet[T]]) = DisjointSets(value)



  }

  // L'object sous-jacent a la conversion.
  case class DisjointSets[T](value : GenSet[GenSet[T]]) {

    val z : GenSet[GenSet[T]]= {
      value.headOption.map { head =>
        value.tail.foldLeft(GenSet(head)) { (disjoint, set) =>

          val s = disjoint.flatten

          val diff =  s.diff(set)
          val inter =  s.intersect(set)
          val r = set.diff(diff ++ inter)
          disjoint + r //GenSet(diff, inter, r).filterNot(_.isEmpty)


        }
      }.getOrElse(value)

    }

    val zz = z

    // valeur
    def disjointSets = z


}
