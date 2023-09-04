# Migrating the types

The Scala 3 compiler uses a slightly different type inference algorithm. It can
sometimes fail at infering the same types as the Scala 2 compiler, which can
lead to compilation errors. This final step will add the needed type ascriptions
to make the code compile to Scala 3.

## Steps

1. Run `migrateTypes main`

2. Check out the changes using the diff tool in your IDE, or using `git diff`.
   You should see that some type arguments were added in a few places to help
   the Scala 3 type checker.

3. Run the tests to check that they are still successful in Scala 2.13.

4. Commit your changes:

```shell
> git commit -a -m 'Migrate types to Scala 3'
```

Go to the next exercise by running `cmtc next-exercise`.
