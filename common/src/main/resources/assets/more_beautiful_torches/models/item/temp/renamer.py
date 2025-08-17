import os
import json

def replace_phrase_in_file(filepath, old_phrase, new_phrase):
    """Replace a phrase in a file."""
    with open(filepath, 'r') as file:
        data = file.read()

    # Replace the old phrase with the new one
    new_data = data.replace(old_phrase, new_phrase)

    with open(filepath, 'w') as file:
        file.write(new_data)

def replace_phrase_in_folder(folder_path, old_phrase, new_phrase):
    """Replace a phrase in all JSON files in a folder."""
    for filename in os.listdir(folder_path):
        filepath = os.path.join(folder_path, filename)
        if os.path.isfile(filepath) and filepath.endswith('.json'):
            # Replace phrase in file
            replace_phrase_in_file(filepath, old_phrase, new_phrase)

            # Replace phrase in file name
            new_filename = filename.replace(old_phrase, new_phrase)
            os.rename(filepath, os.path.join(folder_path, new_filename))
            print(f"Modified file: {filename} -> {new_filename}")

# Define the folder path and phrases to replace
folder_path = "temp"
old_phrase = "acacia_log"
new_phrase = "bamboo_block"

replace_phrase_in_folder(folder_path, old_phrase, new_phrase)
