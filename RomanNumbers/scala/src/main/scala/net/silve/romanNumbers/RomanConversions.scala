package net.silve.romanNumbers

trait RomanConversions {

  def toInt(roman: String): Option[Int] = "^[IVXLCDM]+$".r.findFirstIn(roman).map {
    _.replaceAll("CM", "DCD")
      .replaceAll("M", "DD")
      .replaceAll("CD", "CCCC")
      .replaceAll("D", "CCCCC")
      .replaceAll("XC", "LXL")
      .replaceAll("C", "LL")
      .replaceAll("XL", "XXXX")
      .replaceAll("L", "XXXXX")
      .replaceAll("IX", "VIV")
      .replaceAll("X", "VV")
      .replaceAll("IV", "IIII")
      .replaceAll("V", "IIIII")
      .length
  }


  def toRoman(number: Int): String = ("I"*number)
    .replaceAll("IIIII", "V")
    .replaceAll("IIII", "IV")
    .replaceAll("VV", "X")
    .replaceAll("VIV", "IX")
    .replaceAll("XXXXX", "L")
    .replaceAll("XXXX", "XL")
    .replaceAll("LL", "C")
    .replaceAll("LXL", "XC")
    .replaceAll("CCCCC", "D")
    .replaceAll("CCCC", "CD")
    .replaceAll("DD", "M")
    .replaceAll("DCD", "CM")


}
