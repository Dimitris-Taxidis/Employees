--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-03-26 21:30:07

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

--
-- TOC entry 2993 (class 0 OID 16402)
-- Dependencies: 200
-- Data for Name: organisation; Type: TABLE DATA; Schema: public; Owner: employees
--

COPY public.organisation (id, name, business_registration_number, address) FROM stdin;
1	Altair S.A	123456789	Sofokleous
\.


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


-- Completed on 2021-03-26 21:30:07

--
-- PostgreSQL database dump complete
--

