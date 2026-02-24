echo Enter file name to search for a string
read file
echo Enter a string to search
read str
if [ -f $file ]
then
	echo File exists and searching for pattern
	grep "$str" "$file"
else
	echo File doesnot exists
fi
