#!/usr/bin/env bash
./build.sh && (./testing.sh && (./commit.sh)) || (./collect_log.sh && ./revert.sh)