#!/usr/bin/env bash
./TCR/build.sh && (./TCR/testing.sh && (./TCR/commit.sh)) || (./TCR/collect_log.sh && ./TCR/revert.sh)