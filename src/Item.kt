// Item is a data class rather than a regular class because items are essentially
// just labeled records; they don't have behavior, just identity.
// Using data class gives us structural stability for free, so two torches with the
// same name/description are treated as the same item. This matters if we ever
// want to check "does the player have a torch" without caring which specific torch object it is.
// Both fields are val because an item's identity should never change mid-game;
// a torch doesn't become a key just because you picked it up.

data class Item(
    val name: String,
    val description: String
)
