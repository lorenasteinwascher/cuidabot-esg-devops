#!/usr/bin/env bash
set -euo pipefail
./mvnw clean verify
docker compose build staging
docker compose up -d oracle-db staging
printf '\nStaging disponível em http://localhost:${STAGING_PORT:-8081}\n'
