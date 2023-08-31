package example

class DiffUtilTests extends munit.FunSuite {
  test("diff") {
    val obtained = DiffUtil.diff("foo bar buzz", "foo fizz buzz")
    val expected = "foo -bar-+fizz+ buzz"
    assertEquals(obtained, expected)
  }
}
