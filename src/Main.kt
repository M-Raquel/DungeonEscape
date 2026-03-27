import functions.buildWorld
import classes.*
import functions.*

//Sets up the world, and runs the game. It's in a loop format
fun main() {

   // Made the world map val so it never gets reassigned
    val world: Map<String, Room> = buildWorld()
    val player = Player(startingRoom = "cell")

    println("=========================================")
    println("         DUNGEON ESCAPE")
    println("=========================================")
    println("You open your eyes. Your head is pounding.")
    println("You have no idea how you got here. You need to escape.")
    println("\nType 'help' to see available commands.\n")

    // Describe the starting Room. Everything after this will be in a loop
    describeRoom(world[player.currentRoom]!!)

    var gameRunning = true

    while (gameRunning) {
        print("\n>") // Visual to prompt the user

        val input = readLine()?.trim()?.lowercase() ?: continue

        // Split the input into a command and optional argument
        // something like "take torch" -> command = "take", argument = "torch"
        val parts = input.split(" ", limit = 2)
        val command = parts[0]
        val argument = if (parts.size > 1) parts[1] else ""

        // Get the current room object from the world map
        val currentRoom = world[player.currentRoom]!!

        when (command) {
            "look" -> describeRoom(currentRoom)

            "go" -> {
                if (argument.isEmpty()) {
                    println("Go where? Try: go north, go south, go east, go west")
                }
                else {
                    player.currentRoom = handleMove(argument, player, currentRoom)
                    // After moving, describe the new room
                    describeRoom(world[player.currentRoom]!!)
                }
            }

            "take" -> {
                if (argument.isEmpty()) {
                    println("Take what? Try: take torch")
                }
                else {
                    handleTake(argument, player, currentRoom)
                }
            }

            "drop" -> {
                if (argument.isEmpty()) {
                    println("Drop what? Try: drop torch")
                }
                else {
                    handleDrop(argument, player, currentRoom)
                }
            }

            "use" -> {
                if (argument.isEmpty()) {
                    println("Use what? Try: use key")
                }
                else {
                    val won = handleUse(argument, player, currentRoom)
                    if (won) gameRunning = false // end the loop on win
                }
            }

            "inventory", "i" -> showInventory(player)

            "help" -> printHelp()

            "quit" -> {
                println("You sit down on the cold stone floor and give up. You will rest here for years.")
                println("Thanks for playing!")
                gameRunning = false
            }

            else -> println("Unknown command: '$command'. Type 'help' to see available commands.")
        }
    }
}