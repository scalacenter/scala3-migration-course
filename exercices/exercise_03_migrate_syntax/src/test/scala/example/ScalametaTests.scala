package example

import scala.meta.Term

class ScalametaTests extends munit.FunSuite {
  test("parse Scala expression") {
    val expression = Scalameta.parseExpression("xs.map(_.size)")
    expression match {
      case Term.Apply(Term.Select(Term.Name("xs"), Term.Name("map")), _) => ()
      case _ => fail("wrong expression", clues(expression))
    }
  }
}