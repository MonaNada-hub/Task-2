# Config Value Extractor (Kotlin)

This small Kotlin program demonstrates how to extract values from a
configuration text using key–value pairs separated by semicolons.

## 📌 Features
- Reads a multi-line configuration string
- Splits entries by `;`
- Splits each entry into `key : value`
- Trims spaces automatically
- Searches for a specific key (case-insensitive)
- Returns the value if found, or `null` if the key doesn’t exist

---

## 🧩 How It Works

### `extractValue(input, searchKey)`
This function:
1. Splits the text into entries
2. Cleans each entry
3. Separates `key` and `value`
4. Compares the key with the user’s search key
5. Returns the value or `null`
