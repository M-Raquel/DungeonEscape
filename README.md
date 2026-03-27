# Overview

As a software engineer, I wanted to deepen my understanding of object-oriented programming by building something interactive from scratch in a new language. I chose to explore Kotlin — a modern, concise language that runs on the JVM and is widely used in Android development.

To make the learning stick, I built a text-based dungeon escape game called **Dungeon Escape**. The player wakes up in a cell and must explore five connected rooms, collect items, defeat a guardian, and unlock the exit gate to win. The game runs entirely in the console and responds to typed commands like `go north`, `take torch`, `use key`, and `inventory`.

My goal was to use this project to understand how Kotlin handles classes, collections, functions, and control flow — and to see how it compares to languages I already know.

[Software Demo Video](http://youtube.link.goes.here)

# Development Environment

- **IDE:** IntelliJ IDEA (Community Edition)
- **JDK:** OpenJDK 17
- **Language:** Kotlin (JVM target)
- **Libraries:** Kotlin standard library only (no external dependencies)

The project is a single file (`Main.kt`) run as a JVM console application.

# Useful Websites

- [Kotlin Official Documentation](https://kotlinlang.org/docs/home.html)
- [Kotlin Tutorial – Programiz](https://www.programiz.com/kotlin-programming)
- [Kotlin vs Java Comparison – Official](https://kotlinlang.org/docs/comparison-to-java.html)
- [When Expression in Kotlin – Baeldung](https://www.baeldung.com/kotlin/when)

# Future Work

- Add a health system where the guardian fight has a chance to damage the player
- Add more rooms and branching paths for replayability
- Add a `examine [item]` command that shows item descriptions in more detail
