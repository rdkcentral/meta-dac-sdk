#!/bin/bash

if [ "$#" -lt 1 ]; then
    echo "Usage:"
    echo "./test.sh <IP_ADDRESS>"
    echo ""
    echo " IP_ADDRESS - hostname or IP address of the target device"
    exit
fi

SCRIPT_DIR="$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
$SCRIPT_DIR/../testapp.sh $1 $SCRIPT_DIR/BUNDLE-TGZ-NAME

