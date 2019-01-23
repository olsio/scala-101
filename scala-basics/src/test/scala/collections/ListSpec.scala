package collections

import org.scalatest._

class ListSpec extends FlatSpec with Matchers {

  "(+:) operator" should "create new List with an element prepended" in {
    val emptyList = List[String]()
    val oneElementList = "1" +: emptyList
    val twoElementList = "2" +: oneElementList

    emptyList shouldEqual List()
    oneElementList shouldEqual List("1")
    twoElementList shouldEqual List("2", "1")
  }
}
