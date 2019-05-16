#!/usr/bin/env bash
read -p "commit working: " name && git add . && git commit -m "$name"