import re

def capital_to_snake(text: str) -> str:
    # Remove leading/trailing spaces
    text = text.strip()
    # Replace spaces and hyphens with underscores
    text = re.sub(r'[\s\-]+', '_', text)
    # Convert to lowercase
    return text.lower()

def convert_file(input_file: str, output_file: str):
    with open(input_file, "r", encoding="utf-8") as infile, \
            open(output_file, "w", encoding="utf-8") as outfile:

        for line in infile:
            snake = capital_to_snake(line)
            outfile.write(snake + "\n")

if __name__ == "__main__":
    # Example usage
    convert_file("NEW_TORCHES.txt", "output.txt")
