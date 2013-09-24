package net.silve.disjointsets

import scala.collection.GenSet


/*
 * On definit une conversion implicite sur GenSet
 * afin de pouvoir directement calculer les ensemble disjoint sur l'ensemble
 *
 * On pourra utiliser GenSet(GenSet(0), GenSet(1)).disjointSets
 *
 * Il suffit de rajouter l'import
 * import net.silve.disjointsets.DisjointSetsImplicits._
 */

object DisjointSetsImplicits {

  // Conversion implicite
  implicit def Set2Set[T](value : GenSet[GenSet[T]]) = DisjointSets(value)



  }

  // L'object sous-jacent a la conversion.
  case class DisjointSets[T](value : GenSet[GenSet[T]]) {



    // valeur
    def disjointSets : GenSet[GenSet[T]]= {
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


}
