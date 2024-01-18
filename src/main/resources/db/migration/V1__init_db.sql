CREATE SCHEMA IF NOT EXISTS public;
create sequence actor_seq start with 1 increment by 50
create sequence category_seq start with 1 increment by 50
create sequence film_seq start with 1 increment by 50
CREATE TABLE IF NOT EXISTS public.actor
(
    actor_id integer NOT NULL,
    first_name character varying(45) NOT NULL,
    last_name character varying(45)  NOT NULL,
    PRIMARY KEY (actor_id)

);

CREATE TABLE IF NOT EXISTS public.category
(
    category_id integer NOT NULL  ,
    name character varying(25) NOT NULL,
    CONSTRAINT category_pkey PRIMARY KEY (category_id)
);
CREATE TABLE IF NOT EXISTS public.film
(
    film_id integer NOT NULL   ,
    title character varying(255) NOT NULL,
    description text,
    release_year integer,
    rating character varying(45),
    category_id integer REFERENCES category(category_id) NOT NULL,
    CONSTRAINT film_pkey PRIMARY KEY (film_id)
);
CREATE TABLE IF NOT EXISTS public.film_actor
(
    actor_id integer REFERENCES actor(actor_id) NOT NULL,
    film_id integer REFERENCES film(film_id)NOT NULL,
    PRIMARY KEY (actor_id, film_id)

);