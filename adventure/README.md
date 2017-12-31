# Simple adventure game

## phase1b - Pull Project and Initial Java Class Templates

Note, this README and all subsequent ones will be written using [Markdown](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)

### Register SSH Keys

First you'll have to register your SSH keys with my GitHub account so that you can work freely with this repo.

### Clone the project and check out the branch phase1b

```shell
anduril$ git clone git@github.com:randyzingle/courses.git
anduril$ cd courses
anduril$ git checkout phase1b
anduril$ cd adventure
```

Now create a personal copy of the branch that you can work with and push changes to.

```shell
anduril$ git checkout -b phase1b-randy
Switched to a new branch 'phase1b-randy'
```

In the above replace **randy** with your name or unique identifier.

### Create the Eclipse Artifacts and Import the Project into Eclipse

```shell
anduril$ gradlew eclipse
```
Import the project into Eclipse.

### Write Some Adventure Java

Use the template classes to:
1) Create Dice that we can roll
2) A PlayerCharacter class that will have a **name** and **ability scores**

Once you are done, create a PlayerCharacter and have it print out to the console.
