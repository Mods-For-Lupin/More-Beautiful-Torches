import sys
from collections import Counter

def find_duplicate_lines(filename):
    with open(filename, "r", encoding="utf-8") as f:
        lines = [line.rstrip("\n") for line in f]  # strip newlines but keep content
    counter = Counter(lines)

    duplicates = {line: count for line, count in counter.items() if count > 1}
    return duplicates

def main():
    if len(sys.argv) != 2:
        print("Usage: python find_duplicates.py <input.txt>")
        sys.exit(1)

    filename = sys.argv[1]
    duplicates = find_duplicate_lines(filename)

    if not duplicates:
        print("No duplicate lines found.")
    else:
        print("Duplicate lines:")
        for line, count in duplicates.items():
            print(f"{count}× : {line}")

if __name__ == "__main__":
    main()
