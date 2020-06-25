#!/bin/bash

cat ./company.json |
  curl -i \
    -H "Content-Type:application/json" \
    -X POST \
    -d @- 'http://localhost:8080/companies'
