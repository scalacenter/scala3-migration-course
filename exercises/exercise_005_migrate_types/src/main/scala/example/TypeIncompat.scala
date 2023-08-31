package example

object TypeIncompat {
  class Context[M[_]]

  trait Foo[T]
  trait Bar[T]

  object Foo {
    implicit val ctx: Context[Foo] = new Context
  }

  object Fizz extends Foo[Int] with Bar[Int] 

  def toBar[A](foo: Foo[A]): Bar[A] = ???

  def fizz[A, B](foo: Foo[A]): Option[Foo[B]] = ???

  def buzz[A, B](foo: Foo[A]): Option[Bar[B]] = fizz(foo).map(toBar[B])

  def from[M[_], T](m: M[T])(implicit ctx: Context[M]): String = "success"
}
