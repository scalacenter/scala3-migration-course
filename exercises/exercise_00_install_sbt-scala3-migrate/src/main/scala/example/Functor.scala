package example

trait Functor[M[_]] {
  def fmap[A, B](fa: M[A])(f: A => B): M[B]
}

object Functor {
  def apply[M[_]: Functor]: Functor[M] = implicitly[Functor[M]]

  implicit def eitherLeftFunctor[R]: Functor[Either[*, R]] =  new EitherLeftFunctor[R]

  class EitherLeftFunctor[R] extends Functor[λ[A => Either[A, R]]] {
    def fmap[A, B](fa: Either[A, R])(f: A => B): Either[B, R] =
      fa match {
        case Right(r) => Right(r)
        case Left(a) => Left(f(a))
      }
  }
}

