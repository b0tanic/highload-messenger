-- liquibase formatted sql

-- changeset AAvalyan:add_index
CREATE EXTENSION IF NOT EXISTS pg_trgm;
CREATE EXTENSION IF NOT EXISTS btree_gin;
CREATE INDEX IF NOT EXISTS first_name_gin ON users USING gin(first_name gin_trgm_ops);
CREATE INDEX IF NOT EXISTS second_name_gin ON users USING gin(second_name gin_trgm_ops);
CREATE INDEX IF NOT EXISTS first_and_second_names_gin ON users USING gin(first_name gin_trgm_ops, second_name gin_trgm_ops);