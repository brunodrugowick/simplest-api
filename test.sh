#!/bin/bash

if [ $# -eq 0 ]; then
    a=`date +"%M"`
    b=`date +"%S"`
else
    a=$1
    b=$2
fi

echo operator a: $a
echo operator b: $b

http --json --pretty format POST http://localhost:8080/calc a==$a b==$b

http --json --pretty format POST http://localhost:8080/calc a==$a b==$b operation==subtract

http --json --pretty format POST http://localhost:8080/calc a==$a b==$b operation==divide

http --json --pretty format POST http://localhost:8080/calc a==$a b==$b operation==multiply

