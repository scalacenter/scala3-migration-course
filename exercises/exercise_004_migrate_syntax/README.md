# Migrating the syntax

As you may know, Scala 3 introduces new syntax for control structure as well as the brace-less syntax. In this exercise we are **not** going to migrate to this new syntax. Instead we are going to fix some old Scala 2 syntax that is not valid anymore in Scala 3.

The goal is to shape the code in a way that is valid in both versions of the language (Scala 2.13 and Scala 3). This is all done automatically by the `migrateSyntax` command.

## Steps

1. Run `migrateSyntax main`

2. Check out the changes using the diff tool in your IDE, or using `git diff`. Can you identify which patterns of code are not valid anymore and needed to be patched?

3. Run the tests to check that they are still successful in Scala 2.13.

4. Commit your changes:

```shell
> git commit -a -m 'Migrate syntax to Scala 3'
```

Go to the next exercise by running `cmtc next-exercise`.
