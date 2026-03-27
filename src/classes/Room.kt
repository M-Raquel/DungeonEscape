package classes
import Item

// Each room has a name, description, a list of exits and a mutable list
// of items sitting in it.

class Room (
    val name: String,
    val description: String,
    val exits: Map<String, String>,
    val items: MutableList<Item> = mutableListOf()
)