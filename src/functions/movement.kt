package functions

import classes.Player
import classes.Room

// Moves the player to a new room if the exit exists.
// I added a special check for this specific dungeon
// Can't go north in the guard room unless the soldier is defeated.

fun handleMove(direction: String, player: Player, room: Room): String {
    // Block room until soldier is defeated
    if (room.name == "Guard Room" && direction == "north" && !player.guardianDefeated) {
        println(" The soldier steps in your way. You need to find a way to deal with them first.")
        return player.currentRoom
    }

    val nextRoomId = room.exits[direction]

    return if(nextRoomId != null) {
        println("You move $direction...")
        nextRoomId
    }
    else {
        println("You can't go $direction from here.")
        player.currentRoom
    }
}