#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE USER $DATABASE_USER PASSWORD '$DATABASE_PASSWORD';
    CREATE SCHEMA $SCHEMA_NAME AUTHORIZATION $DATABASE_USER;
EOSQL