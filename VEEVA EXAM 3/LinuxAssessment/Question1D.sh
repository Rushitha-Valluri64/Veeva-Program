echo "Enter file extension to search in current directory (pdf,txt,doc,zip...):"
read str

echo "Files with .$str extension in the current directory are:"
find . -maxdepth 1 -type f -name "*.$str"
