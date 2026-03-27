package classes
import Item

// Tracks the player's current location, inventory, health, and
// a flag for whether the guardian is defeated
// currentRoom is mutable/changes as the player moves

class Player (startingRoom: String) {
    var currentRoom = startingRoom
    val inventory: MutableList<Item> = mutableListOf()
    var health: Int = 100
    var guardianDefeated: Boolean = false // Changes after combat
}