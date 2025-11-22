// Testing the extractValue function with different keys.
fun main() {
    val config = """
          user: user-123; role: admin;
             authToken: token-xyz-789;
         environment: production ; expiry:
                     1672531199
                                     """

    println(extractValue(config, "role"))
    println(extractValue(config, "authToken"))
    println(extractValue(config, "environment"))
    println(extractValue(config, "hostname"))
    println(extractValue(config, "expiry"))
}

// This function searches the config text for a specific key
// and returns its value if the key exists, otherwise returns null.
fun extractValue(input: String, key: String): String? {

    val entries = input.split(";")

    for (entry in entries) {

        val trimmedEntry = entry.trim()

        val keyValue = trimmedEntry.split(":")

        if (keyValue.size == 2) {

            val (entryKey, entryValue) = keyValue.map { it.trim() }

            if (entryKey.equals(key, ignoreCase = true)) {
                return entryValue
            }
        }
    }

    return null
}