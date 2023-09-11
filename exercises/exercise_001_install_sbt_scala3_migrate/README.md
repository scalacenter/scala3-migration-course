# Installing sbt-scala3-migrate

[sbt-scala3-migrate](https://github.com/scalacenter/scala3-migrate) is an sbt
plugin developed by the Scala Center, to assist you during the migration of
your sbt build to Scala 3.

sbt-scala3-migrate can read your sbt configuration and report about what you
need to change to migrate to Scala 3. It does not change your build
automatically. It can however fixes some incompatibilities in the source files
automatically.

sbt-scala3-migrate brings four sbt commands:

- `migrateDependencies` to help you update the list of `libraryDependencies`
- `migrateScalacOptions` to help you update the list of `scalacOptions`
- `migrateSyntax` to fix a number of syntax incompatibilities between Scala 2.13
  and Scala 3
- `migrateTypes` to compile your code to Scala 3 by infering types and resolving
  implicits where needed

Each command is covered by one the following exercise. In this exercise we will
focus on installing the latest version of sbt-scala3-migrate.

## The steps

1. Add the following line to `project/plugins.sbt`, to install
   sbt-scala3-migrate:

```scala
addSbtPlugin("ch.epfl.scala" % "sbt-scala3-migrate" % "0.6.1")
```

2. You can go to the
   [scalacenter/scala3-migrate](https://index.scala-lang.org/scalacenter/scala3-migrate)
   page on Scaladex to check out the latest version of the plugin. If it is not
   `O.6.0`, you should update the installed version.

3. Reload sbt by running the `reload` command in the sbt shell.

It should output:

```shell
sbt:main> reload
[info] welcome to sbt 1.9.3 (Temurin Java 1.8.0_345)
[info] loading global plugins from /home/piquerez/.sbt/1.0/plugins
[info] loading settings for project scala3-migration-example-build-build from metals.sbt ...
[info] loading project definition from /home/piquerez/github/scalacenter/scala3-migration-example/project/project
[info] loading settings for project scala3-migration-example-build from metals.sbt,plugins.sbt ...
[info] loading project definition from /home/piquerez/github/scalacenter/scala3-migration-example/project
[info] loading settings for project main from build.sbt ...
[info] set current project to main (in build file:/home/piquerez/github/scalacenter/scala3-migration-example/)
[info] 
[info] sbt-scala3-migrate 0.6.1 detected!
[info] It can assist you during the migration to Scala 3.
[info] Run the following commands, to start migrating to Scala 3:
[info]   - migrateDependencies <project>
[info]   - migrateScalacOptions <project>
[info]   - migrateSyntax <project>
[info]   - migrateTypes <project>
[info] Learn more about them on https://docs.scala-lang.org/scala3/guides/migration/scala3-migrate.html
[info] Remove sbt-scala3-migrate from your project/plugins.sbt to clear this message out.
[info]
```

4. Commit your changes:

```shell
> git commit -a -m 'Install sbt-scala3-migrate'
```

In the next exercise you will run `migrateDependencies` to learn how to update
the library dependencies and compiler plugins. Go to the next exercise by
running `cmtc next-exercise` in a terminal.
