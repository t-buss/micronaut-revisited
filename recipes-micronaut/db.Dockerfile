FROM library/postgres:12
RUN echo 'CREATE EXTENSION IF NOT EXISTS "uuid-ossp";' > /docker-entrypoint-initdb.d/init.sql