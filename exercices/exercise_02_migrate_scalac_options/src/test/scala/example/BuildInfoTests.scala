package example

import example.BuildInfo.scalacOptions

class BuildInfoTests extends munit.FunSuite {
  test("scalacOptions") {
    assert(scalacOptions.contains("-encoding") && scalacOptions.contains("UTF-8"))
    assert(scalacOptions.contains("-Wunused:imports,privates,locals"))
    assert(scalacOptions.contains("-target:jvm-1.8") || scalacOptions.contains("-Xunchecked-java-output-version:8"))
    assert(scalacOptions.contains("-explaintypes") || scalacOptions.contains("-explain"))
  }
}
