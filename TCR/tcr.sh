#!/usr/bin/env bash
./TCR/build.sh && (./TCR/testing.sh && (./TCR/commit.sh)) || (./TCR/logging.sh && ./TCR/revert.sh)