package functions

import classes.Player
import classes.Room

// Handles inventory logic and item use

//Search the room's item list for the named item, and moves it from the
// room's collection to the player's inventory
fun handleTake(itemName: String, player: Player, room: Room) {
    // Searches the list and returns the first match or null
    val item = room.items.find { it.name.equals(itemName, ignoreCase = true) }

    if (item != null) {
        room.items.remove(item)
        player.inventory.add(item)
        println("You picked up the ${item.name}.")
    }
    else {
        println("There's no '$itemName' here.")
    }
}

// Moves an item from the player's inventory back to the room. Not really needed for
// this specific dungeon, but for future updates
fun handleDrop(itemName: String, player: Player, room: Room) {
    val item = player.inventory.find { it.name.equals(itemName, ignoreCase = true) }

    if (item != null) {
        player.inventory.remove(item)
        room.items.add(item)
        println("You drop the ${item.name}.")
    } else {
        println("You're not carrying a '$itemName'.")
    }
}

//Checks which item is being used and where. Returns true if the game should end
fun handleUse(itemName: String, player: Player, room: Room): Boolean {
    val item = player.inventory.find { it.name.equals(itemName, ignoreCase = true) }

    // Conditional: does the player even have this item?
    if (item == null) {
        println("You don't have a '$itemName' in your inventory.")
        return false
    }

    // Conditional: what happens depends on WHICH item AND WHERE you are
    when (item.name) {

        "torch" -> {
            println("You hold up the torch. The shadows pull back a little. You feel braver.")
        }

        "sword" -> {
            // Can only use the sword in the guard room
            if (room.name == "Guard Room") {
                if (!player.guardianDefeated) {
                    println("You brandish the sword at the guardian!")
                    println("After a tense struggle, the guardian stumbles back and lets you pass.")
                    player.guardianDefeated = true  // update state
                } else {
                    println("The guardian is already defeated. You lower your sword.")
                }
            } else {
                println("You swing the sword at the air. Nothing happens.")
            }
        }

        "key" -> {
            // Can only use the key at the exit gate
            if (room.name == "Exit Gate") {
                if (player.guardianDefeated) {
                    println("\nYou slide the iron key into the lock...")
                    println("*CLICK*")
                    println("The gate swings open. Cool night air floods in.")
                    println("\n*** YOU ESCAPED THE DUNGEON — YOU WIN! ***\n")
                    return true  // signal the game loop to end
                } else {
                    println("The gate is locked, but something feels wrong.")
                    println("You hear the guardian stirring in the room behind you.")
                    println("You should deal with the guardian first.")
                }
            } else {
                println("You hold up the key. It doesn't seem useful here.")
            }
        }

        else -> println("You fiddle with the ${item.name}. Nothing happens.")
    }
    return false  // game continues
}