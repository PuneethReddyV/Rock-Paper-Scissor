# Rock Paper Scissor Game

This project allows a user play rock-paper-scissor game through command line inputs. 
There are two type of games:
- player vs computer
- computer vs computer

Player can pick 
- Rock
- Paper
- Scissor

Based on the player-1 and player-2 choices a winner is declared. User can type `quit` to exit game or press any key to continue...

# Set up environment
Set up guide creating run time environment for this project. This document assume user has some prior experience on installing softwares.

- Download and install JDK 1.8 or greater suitable for your computer from [here](https://www.oracle.com/in/java/technologies/javase-downloads.html).
- Download `2.13` Scala binaries from [here](https://www.scala-lang.org/download/2.13.5.html)
- Install SBT from [here](https://www.scala-sbt.org/download.html) or use following `brew` command
  
```
brew install sbt@0.13
```
Note:- make sure add `Java`, `Scala`, `SBT` binary file locations to your system PATH variable as shown in this <b>example</b> below:
```
export SCALA_HOME="/Users/puneeth/Documents/scala-2.12.8/bin"
export SBT_HOME="/usr/local/opt/sbt@0.13/bin"
export JAVA_HOME="/Library/Java/JavaVirtualMachines/jdk1.8.0_291.jdk/Contents/Home"
export PATH="$SBT_HOME:$JAVA_HOME:$SCALA_HOME:$PATH"
```

#Start the game
Be in the home location of this project(location of this file), then execute the following command
```
sbt run
```

# Execute test
Go to the home location of this project(location of this file) and, type the following command
```
sbt test
```

![Alt text](img/SnapshotOfTestCases.png?raw=true "Test exectuion")