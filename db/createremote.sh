#!/bin/bash

function createdb() {
  DATABASE=$1
  PGPASSWORD=postgres psql -p 2200 -U postgres -h localhost -c "drop database ${DATABASE}"
  PGPASSWORD=postgres psql -p 2200 -U postgres -h localhost -c "create database ${DATABASE}"
  PGPASSWORD=postgres psql -p 2200 -U postgres -h localhost -d ${DATABASE} < db/baseline.sql
}

createdb "trailblazers"

