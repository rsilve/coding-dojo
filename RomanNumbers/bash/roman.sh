#!/usr/bin/env bash


printf "%$1s" ' ' | tr ' ' 'I' | sed \
 -e "s/IIIII/V/g" \
 -e "s/IIII/IV/g" \
 -e "s/VV/X/g" \
 -e "s/VIV/IX/g" \
 -e "s/XXXXX/L/g" \
 -e "s/XXXX/XL/g" \
 -e "s/LL/C/g" \
 -e "s/LXL/XC/g" \
 -e "s/CCCCC/D/g" \
 -e "s/CCCC/CD/g" \
 -e "s/DD/M/g" \
 -e "s/DCD/CM/g"
