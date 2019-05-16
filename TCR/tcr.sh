#!/usr/bin/env bash
./build.sh && (./TCR/testing.sh && (./TCR/commit.sh)) || (./TCR/collect_log.sh && ./TCR/revert.sh)