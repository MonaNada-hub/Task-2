
fun main() {
    val config = """
        user: user-123; role: admin;
        authToken: token-xyz-789;
        environment: production; expiry:
        1672531199
    """.trimIndent()

    println("=== Testing extractValue() ===")
    println("role → ${extractValue(config, "role")}")
    println("authToken → ${extractValue(config, "authToken")}")
    println("environment → ${extractValue(config, "environment")}")
    println("hostname → ${extractValue(config, "hostname")}")
    println("expiry → ${extractValue(config, "expiry")}")
}

// Splits the full config string into separate entries

fun splitConfigToEntries(configText: String): List<String> {
    return configText.split(";")
}

//  Trims a single entry

fun trimEntry(entry: String): String {
    return entry.trim()
}

//Extracts the value for a specific key.

fun extractValue(input: String, key: String): String? {

    val entries = splitConfigToEntries(input)

    entries.forEach { entry ->
        val trimmed = trimEntry(entry)

        val keyAndValue = trimmed.split(":")

        if (keyAndValue.size == 2) {
            val (extravtKey, extractValue) = keyAndValue.map { it.trim() }

            if (extravtKey.equals(key, ignoreCase = true)) {
                return extractValue
            }
        }
    }

    return null  // if no key was matched
}
