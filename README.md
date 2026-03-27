# Overview

As a software engineer, I wanted to deepen my understanding of object-oriented programming 
by building something interactive from scratch in a new language. I chose to explore Kotlin as
I had previous experience and wanted to refine my understanding.
To make the learning stick, I built a text-based dungeon escape game called **Dungeon Escape**. 
The player wakes up in a cell and must explore five connected rooms, collect items, get past an enemy, 
and unlock the exit gate to win. The game runs entirely in the console and responds 
to typed commands like `go north`, `take torch`, `use key`, and `inventory`.

My goal was to use this project to understand how Kotlin handles classes, collections, 
functions, and control flow. Also to see how it compares to languages I already know.

[DungeonEscape Demo Video](https://www.youtube.com/watch?v=jzjiiPVHles)

## Features
* 5 rooms to travel through and explore. `Map` for connection logic

* Typed command system, supports `go`, `take`, `drop`, `use`, `look`, `inventory`, 
`help`, `quit`

* Inventory system using a `MutableList<Item>`. Pick up, carry, and drop items

* Item interactions: Each item has context-sensitive behavior depending on where 
it is used 

* Win condition: find the key, defeat the soldier, and use the key on the exit gate to excape

# Development Environment

- **IDE:** IntelliJ IDEA (Community Edition)
- **JDK:** OpenJDK 26
- **Language:** Kotlin (JVM target)
- **Libraries:** Kotlin standard library only (no external dependencies)

## How to Run ( Clean Clone Instructions)
Follow these instructions to run the game from scratch on any Windows machine
### 1. Install the JDK
- Go to [https://www.oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/)
- Download the **x64 MSI Installer** for Windows
- Run the installer and follow the default prompts

### 2. Install IntelliJ IDEA (Community Edition — free)
- Go to [https://www.jetbrains.com/idea/download/](https://www.jetbrains.com/idea/download/)
- Scroll down to **Community Edition** and download the Windows installer
- Run the installer and follow the default prompts
- Kotlin support is built in. No extra plugins needed

### 3. Clone the Repository
Open a terminal (Command Prompt or PowerShell on Windows) and run:
```bash
git clone https://github.com/M-Raquel/DungeonEscape.git
cd DungeonEscape
```
 
### 4. Open the Project in IntelliJ IDEA
1. Open IntelliJ IDEA
2. Click **Open** (not "New Project")
3. Navigate to the `DungeonEscape` folder you just cloned and click **OK**
4. IntelliJ will detect the Kotlin project automatically — click **OK** or **Trust Project** if prompted
 
### 5. Run the Game
- Click the green **Run** button in the top toolbar, or press **Shift + F10**
- The game will launch in the console panel at the bottom of the screen
- Type commands and press Enter to play
- Feel free to add or change rooms/items for personal customization.

### Commands Reference
| Command | What it does |
|---|---|
| `look` | Redescribes the current room |
| `go [direction]` | Move north, south, east, or west |
| `take [item]` | Pick up an item in the room |
| `drop [item]` | Drop an item from your inventory |
| `use [item]` | Use an item (effects depend on location) |
| `inventory` or `i` | List what you're carrying |
| `help` | Show all commands |
| `quit` | Exit the game |


# Useful Websites

- [Kotlin Official Documentation](https://kotlinlang.org/docs/home.html)
- [Kotlin Tutorial – Programiz](https://www.programiz.com/kotlin-programming)
- [Kotlin vs Java Comparison – Official](https://kotlinlang.org/docs/comparison-to-java.html)
- [When Expression in Kotlin – Baeldung](https://www.baeldung.com/kotlin/when)

# AI Disclosure
I used Claude (Anthropic) as an AI assistant during this project in the following ways:

* CodeReview: In the actions.kt file, AI was used to help with when logic in the handleUse function. All 
final decisions/text were made by me.

* Kotlin review: I used AI to explain Kotlin-specific syntax 
I was unfamiliar with, such as data class, the when expression, Map, MutableList, 
and the !! non-null operator.

* Bug fixing: When the game crashed with a NullPointerException, 
I used AI to help identify the cause (a mismatched room ID string) and understand 
why the !! operator caused the crash.

* README writing: AI helped draft the Clean Clone Instructions found in this README file.
All final written code and ideas about what to include, how the game works, 
and what I wanted to learn were my own.

# Future Work

- Add a health system where the guardian fight has a chance to damage the player
- Add more rooms and branching paths for replayability
- Add a `examine [item]` command that shows item descriptions in more detail
- Add a save feature to save player progress and location
