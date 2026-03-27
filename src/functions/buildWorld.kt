package functions
import classes.Room
import Item

// buildWorld() is separated from main() so the world setup is isolated from
// the game loop logic. If we wanted to add multiple levels or reset the world,
// we could call this again without touching the loop.
// The returned Map is immutable; the room structure is fixed at game start.
// Only the contents of each room (items) are mutable, and that's handled
// inside the Room objects themselves, not here.

fun buildWorld(): Map<String, Room> {

    // Each room's construction
    val cell = Room(
        name = "Damp Cell",
        description = "You wake up on a damp cold stone floor. The air smells of mold and " +
                "you can hear water dripping somewhere in the room.\nThere are no people in sight." +
                "\nA rusted door leads north into darkness.",
        exits = mapOf("north" to "hallway"),
        items = mutableListOf(
            Item("torch", "A wooden torch. It's unlit, but still useful for light.")
        )
    )

    val hallway = Room(
        name = "Narrow Hallway",
        description = "A long hallway with flickering shadows. Doors branch east and west.\n" +
                "You came from the south.",
        exits = mapOf("south" to "cell", "east" to "storage", "west" to "guardroom")
    )

    val storage = Room(
        name = "Storage Room",
        description = "Dusty shelves line the walls. Most are empty, but something glints" +
                "in the corner.",
        exits = mapOf("west" to "hallway"),
        items = mutableListOf(
            Item("key", "An tarnished iron key. There's a tag that reads: `EXIT`.")
        )
    )

    val guardroom = Room(
        name = "Guard Room",
        description = "A towering soldier blocks the far door. They eye you suspiciously.\n" +
                "A door to the north leads to the exit; if you can get past.",
        exits = mapOf("east" to "hallway", "north" to "exit"),
        items = mutableListOf(
            Item("sword", "A short sword left on a bench. Sharp when used with willing hands")
        )
    )

    val exit = Room(
        name = "Exit Gate",
        description = "A massive iron gate. Freedom is just on the other side. \n" +
                "There's a keyhold located in the center of the gate.",
        exits = mapOf("south" to "guardroom")
    )

    return mapOf(
        "cell"      to cell,
        "hallway"   to hallway,
        "storage"   to storage,
        "guardroom" to guardroom,
        "exit"      to exit
    )

}