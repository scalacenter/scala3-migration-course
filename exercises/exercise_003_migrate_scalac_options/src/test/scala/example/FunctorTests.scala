package example

class FunctorTests extends munit.FunSuite {
  test("either left functor") {
    val obtained = Functor[Either[*, String]].fmap(Left("foo"))(_.size)
    val expected = Left(3)
    assertEquals(obtained, expected)
  }
}
