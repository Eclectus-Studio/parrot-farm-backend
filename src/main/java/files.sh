#!/bin/bash

# Function to recursively print the directory structure in tree format
print_tree() {
  local dir=$1
  local indent=$2

  # List all files and directories
  for item in "$dir"/*; do
    # If it's a directory, print it and call the function recursively
    if [ -d "$item" ]; then
      echo "$indent+-- $(basename "$item")/"
      print_tree "$item" "$indent    "
    # If it's a file, print it
    elif [ -f "$item" ]; then
      echo "$indent+-- $(basename "$item")"
    fi
  done
}

# Main function to start from the current directory
main() {
  local current_dir=$(pwd)

  # Print the root directory
  echo "$current_dir/"
  print_tree "$current_dir" "    "
}

# Run the main function
main
