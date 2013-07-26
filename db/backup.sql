
--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'LATIN1';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

--
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO account VALUES (1, 'AdminCat', 'admin@freewheelers.com', 'admin', '', true);
INSERT INTO account VALUES (2, 'UserCat', 'user@freewheelers.com', 'user', '', true);
INSERT INTO account VALUES (6, 'Michael Stipe', 'mstipe@freewheelers.com', 'REMisAwesome', '1234567890', true);
INSERT INTO account VALUES (8, 'Peter Buck', 'peter-buck@gmx.de', 'P3t3r', '1234567890', true);
INSERT INTO account VALUES (7, 'Scott McCaughey', 'smccaughey@gmail.com', 'ScottScottScott', '1234567890', true);
INSERT INTO account VALUES (9, 'Bill Rieflin', 'billrieflin@apple.com', 'YoudontKNOW!!!', '', true);


--
-- Name: account_account_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('account_account_id_seq', 9, true);


--
-- Data for Name: account_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO account_role VALUES (1, 'AdminCat', 'ROLE_ADMIN');
INSERT INTO account_role VALUES (2, 'UserCat', 'ROLE_USER');
INSERT INTO account_role VALUES (4, 'Michael Stipe', 'ROLE_USER');
INSERT INTO account_role VALUES (5, 'Scott McCaughey', 'ROLE_USER');
INSERT INTO account_role VALUES (6, 'Peter Buck', 'ROLE_USER');
INSERT INTO account_role VALUES (7, 'Bill Rieflin', 'ROLE_USER');


--
-- Name: account_role_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('account_role_role_id_seq', 7, true);


--
-- Data for Name: item; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO item VALUES (9, 'If you''re looking to develop your in-line skills or simply want to roll over any obstacle with ease, then this economically priced, 29er frame will keep you riding with speed and control.', '2011 Access XCL 9er', 179.99, 'FRAME', 521);
INSERT INTO item VALUES (7, 'Get ready to be impressed. With a fit and finish that''s nearly flawless, this 7005 butted aluminum frameset is in a class of its own when it comes to high-end performance at a great value.', 'Scattante XRL Comp Road Bike', 289.99, 'FRAME', 787);
INSERT INTO item VALUES (6, 'Fuji''s Altamira CX 1.0 cyclocross frameset is the perfect platform for building up the cross bike of your dreams.', 'Fuji Altamira CX 1.0 Cyclocross', 2599.99, 'FRAME', 432);
INSERT INTO item VALUES (12, 'Replacement alloy derailleur hanger for Access XCL frames. ', 'Derailleur Hanger for Access XCL and XCL 29er Frames', 10.00, 'ACCESSORIES', 1010);
INSERT INTO item VALUES (11, 'Shimano''s successful introduction of Di2 digital electronic shifting in its Dura-Ace group heralded a new era of shifting performance for the early adopters who jumped in with both feet.', 'Shimano Ultegra Di2 Upgrade Kit', 1299.99, 'ACCESSORIES', 599);
INSERT INTO item VALUES (13, 'Frame protection at its best! Small: Standard Large: Jumbo ', 'Lizard Skins Chainstay Guard', 7.99, 'ACCESSORIES', 319);
INSERT INTO item VALUES (8, 'If you crave simplicity in your cycling life -- but like to express your individuality -- building up your own, customized single-speed road bike could well be the answer. And the Ascent single-speed road bike frame is a great place to start.', 'Ascent Single-Speed Road Bike', 89.99, 'FRAME', 1210);
INSERT INTO item VALUES (10, 'If fast and furious is how you like to ride, then this winning cyclocross frameset is exactly what you need.', 'Scattante XRL Cyclocross Frame', 279.99, 'FRAME', 537);


--
-- Name: item_item_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('item_item_id_seq', 13, true);

--
-- Name: item_type_item_type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('item_type_item_type_id_seq', 2, true);


--
-- Data for Name: reserve_order; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO reserve_order VALUES (11, 8, 7, 'NEW', '', '2013-03-28 12:19:10.021');
INSERT INTO reserve_order VALUES (14, 6, 12, 'NEW', '', '2013-03-28 12:20:19.721');
INSERT INTO reserve_order VALUES (13, 6, 6, 'NEW', '', '2013-03-27 09:20:14.127');
INSERT INTO reserve_order VALUES (15, 6, 11, 'NEW', '', '2013-03-22 16:02:22.875');
INSERT INTO reserve_order VALUES (12, 8, 13, 'PAID', '', '2013-03-20 08:11:21.983');
INSERT INTO reserve_order VALUES (18, 7, 10, 'READY_FOR_SHIPMENT', '', '2013-03-19 22:21:28.171');
INSERT INTO reserve_order VALUES (17, 7, 8, 'IN_PROGRESS', '', '2013-03-28 12:21:24.155');
INSERT INTO reserve_order VALUES (16, 6, 13, 'NEW', '', '2013-03-26 20:14:25.336');


--
-- Name: reserve_order_order_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('reserve_order_order_id_seq', 18, true);


--
-- PostgreSQL database dump complete
--
