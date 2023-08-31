package example

object SyntaxRewrites {
  val square: Int => Int = { (x: Int) => x * x }

  def message(): String = "Hello"
}
