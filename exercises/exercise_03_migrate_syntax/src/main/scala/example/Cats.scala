package example

import cats.Monoid

object Cats {
  def combineAll[A: Monoid](list: List[A]): A = {
    list.foldRight(Monoid[A].empty)(Monoid[A].combine)
  }
}
