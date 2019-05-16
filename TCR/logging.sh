#!/usr/bin/env bash
awk '/FAILED/,/Test.java/' logs/test.log > logs/testerr.log && cat logs/testerr.log