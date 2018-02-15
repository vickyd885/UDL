#!/bin/bash

psql --command "create database ldd"
psql --command "create role ldd login nosuperuser inherit nocreatedb nocreaterole noreplication;"
psql --command "create schema app_ldd authorization ldd;"

pg_restore --clean -d ldd /docker-entrypoint-initdb.d/ldddata_1710006.sql.tar
