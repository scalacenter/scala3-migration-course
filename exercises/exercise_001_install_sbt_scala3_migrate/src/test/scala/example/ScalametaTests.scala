package example

import scala.meta.Term

class ScalametaTests extends munit.FunSuite {
  test("parse Scala expression") {
    val expression = Scalameta.parseExpression("xs.map(_.size)")
    expression match {
      case Term.Apply.After_4_6_0(Term.Select(Term.Name("xs"), Term.Name("map")), _) => ()
      case _ => fail("wrong expression", clues(expression))
    }
  }
}
