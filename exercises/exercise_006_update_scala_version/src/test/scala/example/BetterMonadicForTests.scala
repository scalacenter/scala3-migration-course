package example

class BetterMonadicForTests extends munit.FunSuite {
  test("count twice") {
    var x = 0
    val expected = BetterMonadicFor.countTwice { x += 1; x }.run
    val obtained = "1 and 2"
    assertEquals(expected, obtained)
  }
}
