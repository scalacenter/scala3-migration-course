package example

class SyntaxRewritesTests extends munit.FunSuite {
  test("parentheses around lambda parameter") {
    assertEquals(SyntaxRewrites.square(2), 4)
  }

  test("auto-application") {
    assertEquals(SyntaxRewrites.message(), "Hello")
  }
}
