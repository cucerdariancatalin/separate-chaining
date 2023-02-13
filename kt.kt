import java.util.LinkedList

class HashTable(private val tableSize: Int) {
    private val table = Array(tableSize) { LinkedList<Pair<Int, String>>() }

    // Hash function to determine the index of an element in the hash table
    private fun hashFunction(key: Int) = key % tableSize

    // Function to add an element to the hash table
    fun add(key: Int, value: String) {
        val index = hashFunction(key)
        val pair = Pair(key, value)
        table[index].add(pair)
    }

    // Function to search for an element in the hash table
    fun search(key: Int): String? {
        val index = hashFunction(key)
        for (pair in table[index]) {
            if (pair.first == key) {
                return pair.second
            }
        }
        return null
    }
}

fun main() {
    // Initialize the hash table with a table size of 10
    val hashTable = HashTable(10)

    // Add some elements to the hash table
    hashTable.add(1, "One")
    hashTable.add(2, "Two")
    hashTable.add(11, "Eleven")
    hashTable.add(22, "Twenty Two")

    // Search for some elements in the hash table
    println(hashTable.search(1))  // Output: One
    println(hashTable.search(11))  // Output: Eleven
    println(hashTable.search(22))  // Output: Twenty Two
    println(hashTable.search(3))  // Output: null
}
