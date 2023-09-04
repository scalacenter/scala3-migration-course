# Scala 3 Migration Course

## Acknowledgement

This course uses Lunatech's [Course Management Tools](https://github.com/lunatech-labs/course-management-tools).

## Description

Welcome to the Scala 3 migration course! In this course, we'll guide you through the process of transitioning a Scala 2.13 project to Scala 3 using the powerful [sbt-scala3-migrate](https://github.com/scalacenter/scala3-migrate) tool.

Scala 3 is the shiny new Scala compiler, built upon a complete redesign of the core foundations of the language.
It simplifies many of the language complexities, and brings new features that you can use to make your code more expressive and to enhance its performance.

However, migrating a project can be challenging, especially if it's complex.
That's where sbt-scala3-migrate comes in, automating much of the migration process.

This course targets the Scala developpers who maintain Scala 2.13 projects using sbt, and wish to migrate to Scala 3.
At the end of the course, you should master the 4 major migration steps: updating the dependencies, updating the compiler options, fixing the syntax and fixing the types inference errors.

## Approach

In the course, you will be guided step-by-step through the migration of a tailored Scala 2.13 project.
The project depends on a few library dependencies and compiler plugins taken from the Scala ecosystem.
The code of the project does not do anything really useful.
It is a collection of patterns that serve the purpose of the course: learning about the migration issues and how to solve them.

Each exercise focuses on one migration step:
1. Installing sbt-scala3-migrate
2. Updating the dependencies: Understand how to upgrade your project's dependencies to their Scala 3-compatible versions.
3. Updating the scalac options: Adjust your build configuration to align with Scala 3's compiler options.
4. Fixing syntax: Address and resolve syntax differences between Scala 2.13 and Scala 3.
5. Fixing Type Inference Errors: Tackle type inference issues that may arise during migration.
6. Updating the Scala Version!

After each exercise, the project should still compile to Scala 2.13 and the tests should still run successfully.
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
  /home/user/Library/Caches/com.lunatech.cmt/Courses/scala3-migration-course

Current course set to '/home/user/Library/Caches/com.lunatech.cmt/Courses/scala3-migration-course'

Exercises in repository:
  1.  *   exercise_000_initial_state
  2.      exercise_001_install_sbt_scala3_migrate
  3.      exercise_002_migrate_dependencies
  4.      exercise_003_migrate_scalac_options
  5.      exercise_004_migrate_syntax
  6.      exercise_005_migrate_types
  7.      exercise_006_update_scala_version
```

As you can see in the above output, `cmtc` installed the course in the `/home/user/Library/Caches/com.lunatech.cmt/Courses/scala3-migration-course` folder.
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

We recommend to use either IntelliJ with the Scala language plugin, or Visual Code Studio with Metals.

If you haven't installed an IDE that support Scala, install either IntelliJ or VSCode by following the instructions linked in the following sections.

> Note: in our experience, VSCode with Metals definitely has an edge on the IntelliJ IDE for Scala Worksheet support.

#### Installing IntelliJ with the Scala Language Plugin

* [Install the IntelliJ IDE](https://www.jetbrains.com/help/idea/installation-guide.html#standalone) (Community or Ultimate edition)
* [Install the Scala Plugin](https://www.jetbrains.com/help/idea/discover-intellij-idea-for-scala.html)

#### Installing Visual Code Studio with Metals

* [Install Visual Studio Code](https://code.visualstudio.com/docs/setup/setup-overview)
* [Install the Scala extension: Metals](https://scalameta.org/metals/docs/editors/vscode/)

#### Other Scala source editors

There are plenty of other options for editing Scala code.
For example, Metals supports Vim, Sublime Text and Emacs.
For more information, have a look at the [Text Editors section](https://scalameta.org/metals/docs) in the Metals Documentation.

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
Studentifying scala3-migration-course to /home/user/tmp/stu/scala3-migration-course
..............
Processed exercises:
  exercise_000_initial_state
  exercise_001_install_sbt_scala3_migrate
  exercise_002_migrate_dependencies
  exercise_003_migrate_scalac_options
  exercise_004_migrate_syntax
  exercise_005_migrate_types
  exercise_006_update_scala_version

```

