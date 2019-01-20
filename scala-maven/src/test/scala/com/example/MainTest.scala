package com.example

import org.scalatest._

class MainSpec extends FlatSpec with Matchers {

  "Main" should "have the correct message" in {
    Main.msg should be("Hello World")
  }
}
