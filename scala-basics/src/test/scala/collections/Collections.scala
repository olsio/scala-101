package com.example

import org.scalatest._

class CollectionsSpec extends FlatSpec with Matchers {

  "Adding" should "have the correct message" in {
    val emptySet = Set[String]()
    emptySet + "1" + "2" should be(Set("1", "2"))

  }
}
