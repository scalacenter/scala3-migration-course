package example

class TypeIncompatTests extends munit.FunSuite {
  test("type incompat") {
    val obtained = TypeIncompat.from(TypeIncompat.Fizz)
    assertEquals(obtained, "success")
  }
}
