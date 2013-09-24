package net.silve.disjointsets

import org.specs2.mutable._
import net.silve.disjointsets.DisjointSetsImplicits._
import scala.collection.GenSet

class DisjointSetsSpec extends Specification {

  "Ø " should {
    "give Ø" in {
      GenSet[GenSet[Int]]().disjointSets.size must beEqualTo(0)
    }
  }

  "{{0}} " should {
    "give {{0}}" in {
      GenSet(GenSet(0)).disjointSets.size must beEqualTo(1)
    }
  }

  "{{0}, {0}} " should {
    "give {{0}}" in {
      GenSet(GenSet(0)).disjointSets.size must beEqualTo(1)
    }
  }

  "{{0}, {1}} " should {
    "give {{0}, {1}}" in {
      val set = GenSet(GenSet(0), GenSet(1)).disjointSets

      set.size must beEqualTo(2)
      set.contains(Set(0)) must beTrue
      set.contains(Set(1)) must beTrue
    }
  }

  "{{0}, {0, 1}} " should {
    "give {{0}, {1}}" in {
      val set = GenSet(GenSet(0), GenSet(0, 1)).disjointSets
      set.size must beEqualTo(2)
      set.contains(Set(0)) must beTrue
      set.contains(Set(1)) must beTrue
    }
  }

  "{{0}, {0, 1} {0,1,2}} " should {
    "give {{0}, {1}, {2}}" in {
      val set = GenSet(GenSet(0), GenSet(0, 1), GenSet(0, 1, 2)).disjointSets
      set.size must beEqualTo(3)
      set.contains(Set(0)) must beTrue
      set.contains(Set(1)) must beTrue
      set.contains(Set(2)) must beTrue
    }
  }

  "{{0, 1} {0,1,2}} " should {
    "give {{0,1}, {2}}" in {
      val set = GenSet(GenSet(0, 1), GenSet(0, 1, 2)).disjointSets
      set.size must beEqualTo(2)
      set.contains(Set(0,1)) must beTrue
      set.contains(Set(2)) must beTrue
    }
  }

  "{{0}, {1} {0,2}} " should {
    "give {{0}, {1}, {2}}" in {
      val set = GenSet(GenSet(0), GenSet(1), GenSet(0, 2)).disjointSets
      set.size must beEqualTo(3)
      set.contains(Set(0)) must beTrue
      set.contains(Set(1)) must beTrue
      set.contains(Set(2)) must beTrue
    }
  }

  "{{0,2,3}, {1,2,3} {4,5,6}} " should {
    "give {{0}, {1}, {2,3}, {4,5,6}" in {
      val set = GenSet(GenSet(0), GenSet(1), GenSet(2,3), GenSet(4,5,6)).disjointSets
      set.size must beEqualTo(4)
      set.contains(Set(0)) must beTrue
      set.contains(Set(1)) must beTrue
      set.contains(Set(2,3)) must beTrue
      set.contains(Set(4,5,6)) must beTrue
    }
  }

}