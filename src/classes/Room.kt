package classes
import Item

// Room uses a regular class (not data class) because rooms are unique locations
// in the world. We never need to compare two rooms for equality or copy them.
// 'exits' is an immutable Map because the layout of the dungeon doesn't change;
// you can't dig new tunnels at runtime. Items, however, are MutableList because
// the room's contents DO change; players pick things up and drop things off.
// Defaulting items to mutableListOf() means rooms with no items don't need
// to explicitly pass an empty list, which keeps buildWorld() cleaner.

class Room (
    val name: String,
    val description: String,
    val exits: Map<String, String>,
    val items: MutableList<Item> = mutableListOf()
)