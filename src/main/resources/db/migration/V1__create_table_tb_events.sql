-- V1__create_table_tb_events

CREATE TYPE event_category AS ENUM (
    'MUSIC',
    'SPORTS',
    'THEATER',
    'CONFERENCE',
    'WORKSHOP',
    'MEETUP',
    'FESTIVAL',
    'EXHIBITION',
    'PARTY',
    'OTHER'
    );

CREATE TABLE tb_events (
    id              BIGSERIAL PRIMARY KEY,
    name            VARCHAR(255)   NOT NULL,
    description     TEXT,
    ticket_code     VARCHAR(255)   NOT NULL UNIQUE,
    start_date_time TIMESTAMP      NOT NULL,
    end_date_time   TIMESTAMP      NOT NULL,
    location        VARCHAR(255)   NOT NULL,
    capacity        INT,
    organizer       VARCHAR(255),
    category        event_category NOT NULL

);