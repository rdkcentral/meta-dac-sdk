#!/bin/sh

# A scimple script for calculating an average of glmark2 score
# Author: Damian Wrobel <dwrobel@ertelnet.rybnik.pl>

LOGFILE=/tmp/glmark2-es2-wayland.log

for i in $(seq 1 5); do
    glmark2-es2-wayland --size 1920x1080 --show-all-options | tee -a "${LOGFILE}";
done

grep 'glmark2 Score:' "${LOGFILE}" | awk 'BEGIN {sum=0; elems=0} /^#/ {next} {sum+=$3;elems++} END {print "glmark2 Score (avg from " elems "): " sum/elems}'
