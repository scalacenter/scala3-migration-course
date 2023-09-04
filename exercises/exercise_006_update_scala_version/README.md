# Migrating the Scala version

If you made it so far, it means you're code has already compiled to Scala 3! It
is time to switch permanently to Scala 3 and to clean up the build.

## Steps

1. Change the `scalaVersion` to `3.3.0`
2. Reload the build and check that the main and test code still compiles.
3. Check that the tests run successfully.
4. Remove all Scala 2.13-specific dependencies and `scalacOptions` from the
   build.
5. Remove `sbt-scala3-migrate` from the build.
6. One last time you can reload and run the tests.
7. Commit your changes:

```shell
> git commit -a -m 'Finalize migration to Scala 3'
```

## Conclusion

Congratulations! 🎉 You've completed the "Scala 3 Migration Course" tutorial.
You've navigated the journey of migrating a project to Scala 3 and overcame all
the obstacles.

We encourage you to apply what you've learned here to your own projects.

Your feedback is essential in making sbt-scala3-migrate even better. If you
encounter any issues, have suggestions, or want to share your success stories,
please reach out on
[scalacenter/scala3-migrate](https://github.com/scalacenter/scala3-migrate).
