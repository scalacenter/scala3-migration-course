# Welcome

Welcome to the Scala 3 migration course! In this course, we'll guide you through
the process of transitioning a Scala 2.13 project to Scala 3 using the powerful
[sbt-scala3-migrate](https://github.com/scalacenter/scala3-migrate) tool.

## Description of the exercise

This folder contains an sbt project described in the `build.sbt` file. The goal
of this initial exercise is to familiarize yourself with its configuration and
source files.

## The steps

1. Take a look at the `build.sbt` file:

- What is the current Scala version? Is it the latest Scala 2.13 version?
- Can you find the library dependencies? Which are the main dependencies and
  which are the test dependencies?
- Can you find the compiler plugins?
- Can you find the compiler options?

2. Take a look at the main code in `src/main` and the test code in `src/test`.
As you can see the code does not do anything really usefull, it is just a
collection of patterns that serve the purpose of this course: learning about the
migration to Scala 3.

3. Start an sbt shell by running `sbt`, in a terminal, at the root of the
   project.

- Check that the main code compiles with `compile`
- Check that the test code compiles with `Test/compile`
- Check that the tests run successfully with `test`

The output of running the tests should look like this:

```shell
sbt:main> test
[info] example.SyntaxRewritesTests:
[info]   + parentheses around lambda parameter 0.005s
[info]   + auto-application 0.0s
[info] example.FunctorTests:
[info]   + either left functor 0.001s
[info] example.DiffUtilTests:
[info]   + diff 0.009s
[info] example.CatsTests:
[info]   + combine all strings 0.248s
[info] example.TypeIncompatTests:
[info]   + type incompat 0.001s
[info] example.BetterMonadicForTests:
[info]   + count twice 0.001s
[info] example.ScalametaTests:
[info]   + parse Scala expression 0.101s
[info] example.BuildInfoTests:
[info]   + scalacOptions 0.002s
[info] Passed: Total 9, Failed 0, Errors 0, Passed 9
[success] Total time: 0 s, completed Sep 4, 2023 10:19:01 AM
```

As you can see the project contains 9 tests which are all successful. After each
exercise of this course it is important to check that those tests still pass,
that we did not break any piece of the code. Only at the end of the course, when
we will be sure that everything is ready, and the tests will still run
successfully, we will switch the Scala version to Scala 3.

Are you ready to start migrating this project? Go to the next exercise by
running `cmtc next-exercise` in a terminal.
