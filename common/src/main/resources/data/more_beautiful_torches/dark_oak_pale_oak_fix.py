import os

# Define folder path
folder = "recipe/pale_oak"

# Ensure folder exists
if not os.path.isdir(folder):
    print(f"Folder '{folder}' not found.")
    exit()

# Iterate through all files in the folder
for filename in os.listdir(folder):
    file_path = os.path.join(folder, filename)

    # Skip directories
    if not os.path.isfile(file_path):
        continue

    # Read file contents and replace text
    with open(file_path, "r", encoding="utf-8") as f:
        content = f.read()

    new_content = content.replace("dark_oak", "pale_oak")

    # Write back if changes were made
    if new_content != content:
        with open(file_path, "w", encoding="utf-8") as f:
            f.write(new_content)

    # Rename file if "dark_oak" is in the filename
    if "dark_oak" in filename:
        new_filename = filename.replace("dark_oak", "pale_oak")
        new_file_path = os.path.join(folder, new_filename)
        os.rename(file_path, new_file_path)
        print(f"Renamed: {filename} -> {new_filename}")
    else:
        print(f"Updated content only: {filename}")
