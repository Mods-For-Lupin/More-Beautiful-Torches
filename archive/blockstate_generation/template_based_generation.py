import os

# Configuration
input_file = "blocks_COPY.txt"
template_files = [
    "templates/_redstone_torch.json",
    "templates/_redstone_wall_torch.json",
    "templates/_soul_torch.json",
    "templates/_soul_wall_torch.json",
    "templates/_torch.json",
    "templates/_wall_torch.json"
]
output_dir = "generated"

# Ensure output directory exists
os.makedirs(output_dir, exist_ok=True)

# Read templates once into memory
templates = {}
for template_path in template_files:
    with open(template_path, "r", encoding="utf-8") as f:
        templates[template_path] = f.read()

created = 0

with open(input_file, "r", encoding="utf-8") as f:
    for line in f:
        value = line.strip()
        if not value:
            continue

        for template_path, template_content in templates.items():
            base_name = os.path.basename(template_path)  # e.g. "_torch.json"

            # Remove leading underscore for cleaner output
            if base_name.startswith("_"):
                base_name = base_name[1:]

            # Construct filename: <value>_<basename>
            output_filename = f"{value}_{base_name}"
            output_path = os.path.join(output_dir, output_filename)

            # Replace placeholder inside template
            filled_content = template_content.replace("{{VALUE}}", value)

            with open(output_path, "w", encoding="utf-8") as out:
                out.write(filled_content)
                created += 1

print("Generated " + str(created) + " files")
