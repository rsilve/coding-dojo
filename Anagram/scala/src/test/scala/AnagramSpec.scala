import net.silve.dojo.Anagram
import org.scalatest._


class AnagramSpec extends FlatSpec with Matchers {

  it should "validate" in {
    Anagram(Seq("Emmanuelle Béart", "belle amante mûre")) shouldBe true
    Anagram(Seq("RAME", "AMER", "ARME", "MARE")) shouldBe true
    Anagram(Seq("ANGLETERRE", "L'ÉTRANGÈRE")) shouldBe true
  }

  it should "not validate" in {
    Anagram(Seq("ab", "bc")) shouldBe false
    Anagram(Seq("ab")) shouldBe false
    Anagram(Seq()) shouldBe false
  }


}
