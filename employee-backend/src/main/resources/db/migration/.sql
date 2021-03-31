--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-03-26 21:24:45

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 16412)
-- Name: employee; Type: TABLE; Schema: public; Owner: employees
--

CREATE TABLE public.employee (
    id bigint NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    email character varying(255),
    address character varying(255),
    mobile_phone_number character varying(255),
    organisation_id bigint
);


ALTER TABLE public.employee OWNER TO employees;

--
-- TOC entry 203 (class 1259 OID 16418)
-- Name: employee_sequence; Type: SEQUENCE; Schema: public; Owner: employees
--

CREATE SEQUENCE public.employee_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employee_sequence OWNER TO employees;

--
-- TOC entry 200 (class 1259 OID 16402)
-- Name: organisation; Type: TABLE; Schema: public; Owner: employees
--

CREATE TABLE public.organisation (
    id bigint NOT NULL,
    name character varying(255),
    business_registration_number character varying(255),
    address character varying(255)
);


ALTER TABLE public.organisation OWNER TO employees;

--
-- TOC entry 201 (class 1259 OID 16408)
-- Name: organisation_sequence; Type: SEQUENCE; Schema: public; Owner: employees
--

CREATE SEQUENCE public.organisation_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.organisation_sequence OWNER TO employees;

--
-- TOC entry 2995 (class 0 OID 16412)
-- Dependencies: 202
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: employees
--

COPY public.employee (id, first_name, last_name, email, address, mobile_phone_number, organisation_id) FROM stdin;
2	Petros	Papadopoulos	test@test.com	Sofokleous	6978457823	1
3	John	Bruce	test01@test.com	Sofokleous	6978457836	1
\.


--
-- TOC entry 2993 (class 0 OID 16402)
-- Dependencies: 200
-- Data for Name: organisation; Type: TABLE DATA; Schema: public; Owner: employees
--

COPY public.organisation (id, name, business_registration_number, address) FROM stdin;
1	Altair S.A	123456789	Sofokleous
\.


--
-- TOC entry 3002 (class 0 OID 0)
-- Dependencies: 203
-- Name: employee_sequence; Type: SEQUENCE SET; Schema: public; Owner: employees
--

SELECT pg_catalog.setval('public.employee_sequence', 1, false);


--
-- TOC entry 3003 (class 0 OID 0)
-- Dependencies: 201
-- Name: organisation_sequence; Type: SEQUENCE SET; Schema: public; Owner: employees
--

SELECT pg_catalog.setval('public.organisation_sequence', 3, true);


--
-- TOC entry 2861 (class 2606 OID 16421)
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: employees
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- TOC entry 2859 (class 2606 OID 16411)
-- Name: organisation organisation_pkey; Type: CONSTRAINT; Schema: public; Owner: employees
--

ALTER TABLE ONLY public.organisation
    ADD CONSTRAINT organisation_pkey PRIMARY KEY (id);


--
-- TOC entry 2862 (class 2606 OID 16422)
-- Name: employee employee_organisation_fk; Type: FK CONSTRAINT; Schema: public; Owner: employees
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_organisation_fk FOREIGN KEY (organisation_id) REFERENCES public.organisation(id);


-- Completed on 2021-03-26 21:24:45

--
-- PostgreSQL database dump complete
--

