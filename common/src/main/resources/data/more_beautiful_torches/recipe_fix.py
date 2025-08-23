import os
import re

folder = "recipe"  # your folder

# Regex for single item case:  "X": {"item": "minecraft:acacia_log"},
single_item_pattern = re.compile(
    r'(".*?"):\s*{\s*"item":\s*("(?:minecraft:[a-z0-9_/]+)")\s*},?'
)

# Regex for list case:  "#": [{"item": "minecraft:coal"}, {"item":"minecraft:charcoal"}]
list_item_pattern = re.compile(
    r'(".*?"):\s*\[\s*(?:\{\s*"item":\s*"(minecraft:[a-z0-9_/]+)"\s*}\s*,?\s*)+\]'
)

# Helper function to fix lists
def replace_list(match: re.Match) -> str:
    key = match.group(1)
    text = match.group(0)
    # Extract all minecraft:item values from inside
    items = re.findall(r'"item":\s*"(minecraft:[a-z0-9_/]+)"', text)
    # Format back into "key": ["minecraft:foo", "minecraft:bar"]
    items_str = ", ".join([f'"{i}"' for i in items])
    return f'{key}: [{items_str}]'


for filename in os.listdir(folder):
    filepath = os.path.join(folder, filename)

    if not os.path.isfile(filepath):
        continue

    with open(filepath, "r", encoding="utf-8") as f:
        content = f.read()

    new_content = content

    # Case 1: flatten single {"item": "..."}
    new_content = single_item_pattern.sub(r'\1: \2,', new_content)

    # Case 2: flatten list [{"item": ...}, {"item": ...}]
    new_content = list_item_pattern.sub(replace_list, new_content)

    if new_content != content:
        with open(filepath, "w", encoding="utf-8") as f:
            f.write(new_content)
        print(f"Updated {filename}")
