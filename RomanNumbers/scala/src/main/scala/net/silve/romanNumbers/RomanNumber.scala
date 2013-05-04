package net.silve.romanNumbers



object RomanNumberImplicits {

  implicit def String2RomanNumber(value : String) = RomanNumber(value)

  val tokens = Seq(
    ("I",1),
    ("V",5),
    ("X",10),
    ("L",50),
    ("C",100),
    ("D",500),
    ("M",1000)
  )

  class RomanNumber(desc: String) {




    def isValid = {
      false
    }


  }


}