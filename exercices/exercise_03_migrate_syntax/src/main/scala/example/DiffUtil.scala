package example

import com.github.difflib.text.DiffRowGenerator
import scala.jdk.CollectionConverters.*

object DiffUtil {
  private val generator = DiffRowGenerator
    .create
    .showInlineDiffs(true)
    .mergeOriginalRevised(true)
    .inlineDiffByWord(true)
    .oldTag(_ => "-")
    .newTag(_ => "+")
    .build

  def diff(original: String, revised: String): String =
    generator
      .generateDiffRows(List(original).asJava, List(revised).asJava)
      .asScala
      .head
      .getOldLine
}
