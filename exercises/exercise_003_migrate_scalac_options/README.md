# Migrating the compiler options

The Scala 3 compiler does not contain the exact same set of options as the Scala 2 compiler. You can check out the [the Compiler Options Table](https://docs.scala-lang.org/scala3/guides/migration/options-lookup.html) to get a full comparison of all the compilers options.

Hopefully sbt-scala3-migrate can help you update the `scalacOptions` in your build.

## Steps

1. Run `migrateScalacOptions main`. It should outputs:

```shell
sbt:main> migrateScalacOptions main
[info] 
[info] Starting migration of scalacOptions in main
[info] 
[info] Valid scalacOptions:
[info] -encoding UTF-8
[info] -Wunused:imports,privates,locals
[warn] 
[warn] Renamed scalacOptions:
[warn] -target:jvm-1.8 -> -Xunchecked-java-output-version:8
[warn] -explaintypes   -> -explain
[warn] 
[warn] Removed scalacOptions:
[warn] -Xsource:3
[warn] -Yrangepos
```

2. Update the `scalacOptions` in a cross compatible way, using the following pattern:

```scala
scalacOptions := {
  val sharedOptions = Seq(/* to fill in*/)
  val scala2Options = sharedOptions ++ Seq(/* to fill in */)
  val scala3Options = sharedOptions ++ Seq(/* to fill in */)
  if (scalaVersion.value.startsWith("3.")) scala3Options else scala2Options
}
```

3. Reload the build and check that you can still run the tests successfully.

4. Commit your changes:

```shell
> git commit -a -m 'Migrate scalacOptions to Scala 3'
```

Go to the next exercise by running `cmtc next-exercise`.
