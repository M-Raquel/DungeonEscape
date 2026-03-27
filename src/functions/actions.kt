package functions

import classes.Player
import classes.Room

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

// handleUse() is where most of the game's design decisions live.
// The tradeoff here is between flexibility and simplicity: a more effective system
// might store item effects as lambdas inside the Item class, but that would make
// the items harder to read and the interactions harder to trace.
// Keeping the logic here means all "what does X do in Y room" decisions are
// in one place, which makes it much easier to debug or expand.
// Returns Boolean so the main loop can respond to a win condition without
// needing a global variable or exception; the function just signals "we're done."

fun handleUse(itemName: String, player: Player, room: Room): Boolean {
    val item = player.inventory.find { it.name.equals(itemName, ignoreCase = true) }

    // Conditional: does the player even have this item?
    if (item == null) {
        println("You don't have a '$itemName' in your inventory.")
        return false
    }

    // Using when() here instead of if/else chains because the behavior branches
    // on a specific value (item name), not a boolean condition. This makes it
    // easier to add new items later because you just add a new branch.
    // The edge cases that matter: using the sword somewhere other than the guard room
    // should do nothing useful (so the player doesn't get confused), and using the
    // key before defeating the guardian gives a hint rather than silently failing.
    when (item.name) {

        "torch" -> {
            println("You hold up the torch. The shadows pull back a little. You feel braver.")
        }

        "sword" -> {
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
    return false
}