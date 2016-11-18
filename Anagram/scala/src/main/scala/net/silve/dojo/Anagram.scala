package net.silve.dojo

import java.text.Normalizer

object Anagram {

  def apply(list: Seq[String]): Boolean = list.map(prepare) match {
    case Nil => false
    case a :: Nil => false
    case a :: b :: Nil => a == b
    case a :: b :: tail => a == b && apply(tail :+ b)
  }

  private def prepare = { x: String =>
    Normalizer.normalize(x, Normalizer.Form.NFKD)
      .toLowerCase
      .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "")
      .replaceAll("\\W", "").toCharArray.sorted.mkString
  }

}
