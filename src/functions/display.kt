package functions
import classes.Player
import classes.Room

//Handles displaying commands to the player, printing room descriptions, and inventory

// To avoid cluttering main. Side note: drop won't really be used for this current
// dungeon, but for future updates

fun printHelp() {
    println("""
        Commands you can use:
        look                 - Describe the current room again
        go [direction]       - Move in a direction (north, south, east, west)
        take [item]          - Pick up an item from the room
        drop [item]          - Drop an item from your inventory
        use [item]           - Use an item (context-sensitive)
        inventory            - List what you're carrying
        help                 - Shows this list 
        quit                 - Exit the game
    """.trimIndent())
}

fun describeRoom(room: Room) {
    println("\n=== ${room.name} ===")
    println(room.description)

    // Only prints items if any are present
    if (room.items.isNotEmpty()) {
        // Loops through the collection
        print("You see: ")
        println(room.items.joinToString(", ") { it.name})
    }

    print("Exists: ")
    println(room.exits.keys.joinToString(", "))
}

fun showInventory(player: Player) {
    if (player.inventory.isEmpty()) {
        println("You're inventory is empty")
    }
    else {
        println("You are carrying:")
        // Loops through the collection again
        for (item in player.inventory) {
            println("  - ${item.name}: ${item.description}")
        }
    }
}