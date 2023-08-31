package example

import scala.meta.parsers.*
import scala.meta.Stat
import scala.meta.Tree

object Scalameta {
  def parseExpression(scalaCode: String): Tree =
    scalaCode.parse[Stat] match {
      case err: Parsed.Error => throw err.details
      case success: Parsed.Success[Stat] => success.tree
    }
}
