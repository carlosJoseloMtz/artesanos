#!/bin/bash

curl -i \
  -X POST \
  -H "Content-Type:application/json" \
  -d @sample-prod.json \
  http://localhost:8080/craftsman/some/products
