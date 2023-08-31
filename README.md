# Scala 3 Migration Course

## Acknowledgement

This course uses Lunatech's [Course Management Tools](https://github.com/lunatech-labs/course-management-tools).

## Description

This course targets the Scala developpers who maintain Scala 2.13 projects using sbt, and wish to migrate to Scala 3.

The course is based on [sbt-scala3-migrate](https://github.com/scalacenter/scala3-migrate), a tool that can assist you during the migration of your sbt project.

At the end of the course, you should know the 4 major migration steps: updating the dependencies, updating the compiler options, fixing the syntax and fixing the types inference mismatches.

## Approach

We start from an existing Scala 2.13 dummy project.
It depends on a few library dependencies and compiler plugins taken from the Scala ecosystem, and consists of a few source files and a few tests.

Each exercise focuses on one of the migration step: updating the dependencies, updating the compiler options, fixing the syntax, and fixing the type errors.
After each exercise the project should still compile to Scala 2.13 and the tests should still run successfully.
At the end of the course, it should compile to Scala 3 and the tests should run successfully in Scala 3.

## Course installation

The following components need to be installed:

* Coursier
* A Java JDK (JDK 11 or 17). Note that Coursier allows you to install a JDK
* The `cmtc` Course Management Tools Client CLI
* An IDE (VSCode with Metals or IntelliJ with the Scala Plugin)

The following sections detail how to install these components.

### Install Coursier and run setup

[Coursier](https://github.com/coursier/coursier/) is the Scala installer and artifact manager.

Coursier setup will install the following major tools of the Scala ecosystem:

* `sbt` - the Scala Build Tool
* `scala-cli` - the Scala interactive toolkit
* `scala` - the Scala REPL
* `scalac` - the Scala compiler
* `java` - JDK 8 by default (we will need to install a more recent version of the JDK)

**If you haven't installed Coursier, install it first by following the [Install Scala on your computer](https://docs.scala-lang.org/getting-started/index.html#install-scala-on-your-computer) instructions.**

### Install JDK 11 (or greater)

To install the JDK 11 you can use Coursier:

```bash
$ cs java --jvm temurin:1.11 --setup
Checking if ~/.profile, ~/.zprofile, ~/.bash_profile need(s) updating.
Some shell configuration files were updated. It is recommended to close this terminal once the setup command is done, and open a new one for the changes to be taken into account
```

Restart your terminal and check that the JDK is installed correctly:

```bash
$ java -version
openjdk version "11.0.20" 2023-07-18
OpenJDK Runtime Environment Temurin-11.0.20+8 (build 11.0.20+8)
OpenJDK 64-Bit Server VM Temurin-11.0.20+8 (build 11.0.20+8, mixed mode)
```

The JDK version should be 11.

### Install `cmtc`

`cmtc` is the **C**ourse **M**anagement **T**ools **C**lient.

Coursier can install it with:

```
$ cs install --contrib cmtc
Wrote cmtc
```

Verify that the installation was successful by running the `cmtc` command. You should see the following output:

```bash
$ cmtc
Usage: cmtc <COMMAND>

Commands:
  goto-exercise        Move to a given exercise. Pull in tests and readme files for that exercise
  goto-first-exercise  Move to the first exercise. Pull in tests and readme files for that exercise
  install              Install a course - from either a local directory, a zip file on the local file system or a Github project
  list-exercises       List all exercises and their IDs in the repo. Mark the active exercise with a star
  list-saved-states    List all saved exercise states, if any.
  next-exercise        Move to the next exercise. Pull in tests and readme files for that exercise
  previous-exercise    Move to the previous exercise. Pull in tests and readme files for that exercise
  pull-solution        Pull in all code for the active exercise. All local changes are discarded
  pull-template        Selectively pull in a given file or folder for the active exercise
  restore-state        Restore a previously saved exercise state
  save-state           Save the state of the active exercise
  set-current-course   Sets the current course to point to a directory
  version              Print version info
```
  
### Install the course

Installing this course can be done via the `cmtc install` command as follows:

```bash
$ cmtc install -f -s scalacenter/scala3-migration-course
Downloading studentified course from 'https://github.com/scalacenter/scala3-migration-course/releases/download/0.1.0/scala3-migrate-course-student.zip' to courses directory

Project scalacenter/scala3-migration-course (0.1.0) successfully installed to:
  /user/Library/Caches/com.lunatech.cmt/Courses/scala3-migration-course

Current course set to '/user/Library/Caches/com.lunatech.cmt/Courses/scala3-migration-course'

Exercises in repository:
  1.  *   exercise_00_install_sbt-scala3-migrate
  2.      exercise_01_migrate_dependencies
  3.      exercise_02_migrate_scalac_options
  4.      exercise_03_migrate_syntax
  5.      exercise_04_migrate_types
  6.      exercise_05_udpate_scala_version
```

As you can see in the above output, `cmtc` installed the course in the `/user/Library/Caches/com.lunatech.cmt/Courses/scala3-migration-course` folder.
Note that this location is OS specific, so, take a note of the location.

#### Verifying the course installation

Verify that the the course was installed correctly by launching `sbt test` in the root folder of the
course exercises.

```bash
sbt:main> test
[info] example.SyntaxRewritesTests:
[info]   + parentheses around lambda parameter 0.006s
[info]   + auto-application 0.001s
[info] example.FunctorTests:
[info]   + either left functor 0.001s
[info] example.DiffUtilTests:
[info]   + diff 0.01s
[info] example.CatsTests:
[info]   + combine all strings 0.268s
[info] example.TypeIncompatTests:
[info]   + type incompat 0.001s
[info] example.BetterMonadicForTests:
[info]   + count twice 0.001s
[info] example.ScalametaTests:
[info]   + parse Scala expression 0.111s
|D| example.BuildInfo.scalacOptions = List(-encoding, UTF-8, -target:jvm-1.8, -Xsource:3, -Wunused:imports,privates,locals, -explaintypes)
[info] example.BuildInfoTests:
[info]   + scalacOptions 0.002s
[info] Passed: Total 9, Failed 0, Errors 0, Passed 9
[success] Total time: 1 s, completed Aug 31, 2023 1:50:09 PM
```

Observe that all 9 tests passed successfully.

### Installing an IDE

Instructions are provided in the `IDE-Setup.md` file in the root folder of the installed
course.

## A note to course authors & contributors

For starters, install the `cmta` command as follows:

```bash
$ cs install --contrib cmta
Wrote cmta
```

Using the `cmta` command, two artifacts can be generated from this repo:

- a so-called `studentified` repo. This artefact is distributed to course students.
- a `linearized` repo. This is git repository in which every exercise in the
main repository is turned into a commit. It can be used to:
  - edit the main repository: interactive rebasing on the linearized repo is used to transform the code across a range of exercises.
    Once this rebasing is finished, all applied changes can be applied on the main repo by a process of `delinearization`
  - to inspect the differences between consecutive exercises (using a tools such as `SourceTree`)

### How to _"studentify"_ a master repository

#### Clone the main repo

Clone this repo (aka the main repo for this course) to your computer:

```bash
$ mkdir ~/courses

$ cd ~/courses

$ git clone git@github.com:scalacenter/scala3-migration-course.git

```

#### Create a folder that will hold the studentified repo

Create a folder in which the _studentified_ version will be created. For example:

```bash
$ mkdir ~/tmp/stu
```

#### Generate the studentified repo using `cmta`

Run the `cmta` command to _studentify_ the main repo:

```bash
$ cmta studentify -f -g -m ~/courses/scala3-migration-course -d ~/tmp/stu
Studentifying scala3-migration-course to /user/tmp/stu/scala3-migration-course
..............
Processed exercises:
  exercise_00_install_sbt-scala3-migrate
  exercise_01_migrate_dependencies
  exercise_02_migrate_scalac_options
  exercise_03_migrate_syntax
  exercise_04_migrate_types
  exercise_05_udpate_scala_version

```

