#!/bin/bash
set -e
  ./gradlew clean build test --tests "*Test" -Pversion=${IMAGE_VERSION}