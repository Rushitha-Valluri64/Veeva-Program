echo Enter file name to check in the entire system path
read file
res=$(find /c /d -type f -name $file 2>/dev/null)
if [ -n "$res" ]
then
	echo File is presented in the system $res
else
	echo File is not presented in the system
fi

