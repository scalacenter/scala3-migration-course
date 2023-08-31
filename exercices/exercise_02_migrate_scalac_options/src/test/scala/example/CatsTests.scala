package example

import cats.implicits.*

class CatsTests extends munit.FunSuite {
  test("combine all strings") {
    val obtained = Cats.combineAll(List("a", "b"))
    val expected = "ab"
    assertEquals(obtained, expected)
  }

}
