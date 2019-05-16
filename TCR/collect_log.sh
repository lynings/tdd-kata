#!/usr/bin/env bash
awk '/FAILED/,/Test.java/' > logs/testerr.log