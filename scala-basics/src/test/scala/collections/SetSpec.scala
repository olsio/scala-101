package com.example

import org.scalatest._

class SetSpec extends FlatSpec with Matchers {

  "(+) operator" should "create new Set with added elements" in {
    val emptySet = Set[String]()
    val oneElementSet = emptySet + "1"
    val twoElementSet = oneElementSet + "2"

    emptySet shouldEqual Set()
    oneElementSet shouldEqual Set("1")
    twoElementSet shouldEqual Set("1", "2")
  }

  "Adding duplicates" should "not change the Set" in {
    val uniqueSet = Set("1", "2", "3")
    val duplicateSet = uniqueSet + "1" + "2" + "3"

    uniqueSet shouldEqual uniqueSet
  }

  "(-) operator" should "create a new Set with the elements removed" in {
    val mainSet = Set("1", "2", "3")
    val smallerSet = mainSet - "2"

    smallerSet shouldEqual Set("1", "3")
  }

  "(++) operator" should "merges Sets into new Set" in {
    val setA = Set("1", "2", "3")
    val setB = Set("4", "5")

    val union = setA ++ setB
    union shouldEqual Set("1", "2", "3", "4", "5")
  }

  "(++) operator" should "allow to merge other collections" in {
    val setA = Set("1", "2", "3")
    val listB = List("4", "5")

    val union = setA ++ listB
    union shouldEqual Set("1", "2", "3", "4", "5")
  }
}
