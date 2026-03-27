package classes
import Item

// Player holds all mutable game state. In other words, everything that changes as you play.
// 'currentRoom' is a String ID rather than a Room reference so we can look it
// up from the world Map each turn; this avoids holding stale room references
// if we ever wanted to reset or reload rooms.
// guardianDefeated is a Boolean flag rather than checking inventory for a
// "guardian defeated" item; it's cleaner to track intent directly than to
// guess the state from what the player is carrying.
// Health is not currently used, for future updates.

class Player (startingRoom: String) {
    var currentRoom = startingRoom
    val inventory: MutableList<Item> = mutableListOf()
    var health: Int = 100
    var guardianDefeated: Boolean = false // Changes after combat
}