package example

class TypeIncompatTests extends munit.FunSuite {
  test("type incompat") {
    val obtained = TypeIncompat.from[TypeIncompat.Foo, Int](TypeIncompat.Fizz)
    assertEquals(obtained, "success")
  }
}
