# 2022-06-17-introduction-to-project-loom

Source code for the blog post "[Introduction to Project Loom](https://www.reactivesystems.eu/2022/06/17/introduction-to-project-loom.html)".

The source code uses experimental features and access to internal JDK classes.

It can be build with the Project Loom Early Access JDK. You can either check out the source code from [Loom Github](href="https://github.com/openjdk/loom) and build the JDK yourself, or download an [early access build](http://jdk.java.net/loom/).

The Java version should look something like this:

```
openjdk version "19-loom" 2022-09-20
OpenJDK Runtime Environment (build 19-loom+6-625)
```

To compile the two threads demos, enter

```
javac --enable-preview --source 19 PlatformThreads.java VirtualThreads.java```
```

and then run them with 
```
java --enable-preview VirtualThreads
```
respectively

```
java --enable-preview PlatformThreads
```

To compile the continuations demo, enter

```
javac --add-exports java.base/jdk.internal.vm=ALL-UNNAMED Continuations.java
```

and then run it with

```
java --add-opens=java.base/jdk.internal.vm=ALL-UNNAMED Continuations
```



June 17, 2022
