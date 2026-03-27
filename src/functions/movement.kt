package functions

import classes.Player
import classes.Room

// handleMove() returns the new room ID rather than modifying player.currentRoom directly.
// This keeps the function clean because it decides WHERE to go, and main() decides
// whether to actually move. The guardian check lives here rather than in main()
// because it's specific to this exit, not a general movement rule.
// Returning player.currentRoom unchanged on a failed move means the caller
// can always do player.currentRoom = handleGo(...) without extra null checks.

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