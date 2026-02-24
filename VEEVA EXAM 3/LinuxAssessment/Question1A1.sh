echo Your current directory is: $(pwd) 
echo Enter file name to check in current directory:
read file
if test -f $file 
then
	echo File is presented in current directory
else
	echo File is not presented in current directory
fi

