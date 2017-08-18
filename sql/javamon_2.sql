--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.7
-- Dumped by pg_dump version 9.5.7

-- Started on 2017-08-14 14:30:53 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12395)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2157 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 182 (class 1259 OID 16780)
-- Name: phrase; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE phrase (
    id integer NOT NULL,
    name character varying(255),
    type character varying(255)
);


--
-- TOC entry 181 (class 1259 OID 16778)
-- Name: phrase_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE phrase_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2158 (class 0 OID 0)
-- Dependencies: 181
-- Name: phrase_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE phrase_id_seq OWNED BY phrase.id;


--
-- TOC entry 184 (class 1259 OID 16791)
-- Name: users; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE users (
    id integer NOT NULL,
    name character varying(255),
    password character varying(255),
    score integer
);


--
-- TOC entry 183 (class 1259 OID 16789)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2159 (class 0 OID 0)
-- Dependencies: 183
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- TOC entry 2027 (class 2604 OID 16783)
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY phrase ALTER COLUMN id SET DEFAULT nextval('phrase_id_seq'::regclass);


--
-- TOC entry 2028 (class 2604 OID 16794)
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- TOC entry 2148 (class 0 OID 16780)
-- Dependencies: 182
-- Data for Name: phrase; Type: TABLE DATA; Schema: public; Owner: -
--

COPY phrase (id, name, type) FROM stdin;
1	Bulbasaur	pokemon
2	Ivysaur	pokemon
3	Venusaur	pokemon
4	Charmander	pokemon
5	char	java
6	Charmeleon	pokemon
7	Charizard 	pokemon
8	Squirtle	pokemon
9	Wartortle	pokemon
10	Blastoise	pokemon
11	Caterpie	pokemon
12	Metapod	pokemon
13	Butterfree	pokemon
14	Weedle	pokemon
15	int	java
\.


--
-- TOC entry 2160 (class 0 OID 0)
-- Dependencies: 181
-- Name: phrase_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('phrase_id_seq', 15, true);


--
-- TOC entry 2150 (class 0 OID 16791)
-- Dependencies: 184
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: -
--

COPY users (id, name, password, score) FROM stdin;
\.


--
-- TOC entry 2161 (class 0 OID 0)
-- Dependencies: 183
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('users_id_seq', 1, false);


--
-- TOC entry 2030 (class 2606 OID 16788)
-- Name: phrase_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY phrase
    ADD CONSTRAINT phrase_pkey PRIMARY KEY (id);


--
-- TOC entry 2032 (class 2606 OID 16799)
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


-- Completed on 2017-08-14 14:30:53 CEST

--
-- PostgreSQL database dump complete
--

