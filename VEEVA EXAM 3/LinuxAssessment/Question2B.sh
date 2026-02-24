echo "Enter HTML file name:"
read file

echo "Enter tag name (example: title, h1, p):"
read tag

sed -n "s:.*<$tag>\(.*\)</$tag>.*:\1:p" "$file"
