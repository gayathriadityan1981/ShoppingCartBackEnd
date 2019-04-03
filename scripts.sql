/*https://github.com/mrin9/Angular-SpringBoot-REST-JWT/blob/master/src/main/resources/data.sql
 User */
insert into user (user_id, password, first_name, last_name, email, company, phone, address1, address2, country, postal, role, is_active,  security_provider_id, default_customer_id, secret_question, secret_answer, enable_beta_testing, enable_renewal) values
('demo'      , 'demo'     , 'Mrinmoy'  , 'Majumdar', 'arivera2@joomla.org'    , 'Abshire Inc', '7-(740)701-4547', '80429 Garrison Crossing', '4967'               , 'USA'        , '64890', 'USER' , 1,  10001, 20000, 'Diverse'       , 'Yellow' , 0, 0),
('admin'     , 'admin'    , 'Theresa'  , 'Russell' , 'trussell1@about.me'     , 'Glover, Adams and Bins', '383-(779)851-3208', '30874 Graceland Terrace', '99152' , 'USA'        , '51065', 'ADMIN', 1,  10001, 20000, 'knowledge base', 'Mauv'   , 1, 0),
('user'      , 'user'     , 'Virginia' , 'Reynolds', 'vreynolds0@slashdot.org', 'Rippin, Osinski and Beatty', '84-(228)809-9998', '0118 Burrows Plaza', '496'     , 'USA'        , '94086', 'USER' , 1,  10001, 20000, 'Innovative'    , 'Turquoise', 1, 1),
('jowens3'   , 'jowens3'  , 'Judy'     , 'Owens'   , 'jowens3@hp.com'         , 'Altenwerth, Fisher and Heidenreich', '30-(772)268-8227', '98 Loeprich Way', '447', 'Greece'     , null   , 'USER' , 0,  10001, 20001, 'capacity'      , 'Fuscia' , 1, 1),
('kburns4'   , 'kburns4'  , 'Kelly'    , 'Burns'   , 'kburns4@icio.us'        , 'McCullough-Morar', '86-(857)185-5740', '1638 Basil Alley', '56297'               , 'China'      , null   , 'ADMIN', 1,  10000, 20002, 'user-facing'   , 'Crimson', 1, 1),
('jshaw5'    , 'jshaw5'   , 'Julie'    , 'Shaw'    , 'jshaw5@opera.com'       , 'Steuber-Okuneva', '1-(871)375-6188', '389 Myrtle Pass', '41444'                  , 'Canada'     , null   , 'ADMIN', 1,  10000, 20000, 'software'      , 'Green'  , 0, 1),
('pgilbert6' , 'pgilbert6', 'Peter'    , 'Gilbert' , 'pgilbert6@eepurl.com'   , 'Robel Inc', '52-(372)555-4687', '11522 Fuller Avenue', '5'                       , 'Mexico'     , '39230', 'ADMIN', 1,  10000, 20000, 'multi-state'   , 'Puce'   , 1, 1),
('jjacobs7'  , 'jjacobs7' , 'Justin'   , 'Jacobs'  , 'jjacobs7@google.co.uk'  , 'Harris-Bashirian', '963-(199)359-2552', '95012 Hanover Street', '2377'           , 'India'      , null   , 'USER' , 1,  10000, 20002, 'motivating'    , 'Crimson', 1, 0),
('kbennett8' , 'kbennett8', 'Kevin'    , 'Bennett' , 'kbennett8@hostgator.com', 'Leannon Inc', '62-(892)710-5713', '459 Coleman Drive', '397'                     , 'Indonesia'  , null   , 'ADMIN', 0,  10001, 20000, 'Exclusive'     , 'Purple' , 1, 1),
('cmurphy9'  , 'cmurphy9' , 'Chris'    , 'Murphy'  , 'cmurphy9@over-blog.com' , 'Mosciski LLC', '64-(272)961-0086', '2 Ludington Point', '7'                      , 'New Zealand', null   , 'ADMIN', 0,  10000, 20000, 'empowering'    , 'Maroon' , 0, 1);

/* Products */
insert into products (id, product_code, product_name, description, standard_cost, list_price, target_level, reorder_level, minimum_reorder_quantity, quantity_per_unit, discontinued, category) values
 (601, 'P1' , 'Nikon D810'            , null, 1167.09, 1123.39, 75 , 10, 10, 50, 1, 'Camera')
,(602, 'P2' , 'Canon EOS 5D Mark IV'  , null, 1382.83, 1293.84, 90 , 15, 15, 56, 0, 'Camera')
,(603, 'P3' , 'Dell XPS 13'           , null, 1482.83, 1393.84, 95 , 20, 30, 56, 0, 'Laptop')
,(604, 'P4' , 'iPad Air'              , null, 382.83 , 293.84 , 180, 75, 50, 56, 0, 'Tablet')
,(605, 'P5' , 'Acer Aspire S 13'      , null, 882.83 , 793.84 , 40 , 15, 15, 56, 0, 'Laptop')
,(606, 'P6' , 'Nexus 6'               , null, 633.88 , 511.7  , 75 , 10, 20, 79, 1, 'Phone' )
,(607, 'P7' , 'ThinkPad T365'         , null, 1441.02, 1308.98, 100, 30, 10, 92, 1, 'Laptop')
,(608, 'P8' , 'Moto Z'                , null, 538.44 , 462.34 , 75 , 20, 20, 54,  1, 'Phone' )
,(609, 'P9' , 'HTC 10'                , null, 547.58 , 481.83 , 50 , 5 , 15, 58, 1, 'Tablet')
,(610, 'P10', 'MacBook Pro 13.3'      , null, 1625.81, 1576.61, 120, 40, 30, 11, 1, 'Laptop')
,(611, 'P11', 'Nikon D500'            , null, 867.09 , 723.39 , 75 , 25, 15, 50, 1, 'Camera')
,(612, 'P12', 'Pentax K-1'            , null, 882.83 , 793.84 , 50 , 10, 5 , 56, 0, 'Camera')
,(613, 'P13', 'Asus Zenbook Ux305'    , null, 1182.83, 1093.84, 55 , 10, 5 , 56, 0, 'Laptop')
,(614, 'P14', 'HP Envy m7-n109dx 17.3', null, 1382.83, 1293.84, 50 , 10, 10, 56, 0, 'Laptop')
,(615, 'P15', 'Microsft Surface Book' , null, 1682.83, 1593.84, 200, 80, 50, 56, 0, 'Tablet')
,(616, 'P16', 'Apple iPhone 7'        , null, 833.88 , 711.76 , 250, 100,50, 79, 1, 'Phone' )
,(617, 'P17', 'Google Pixel'          , null, 641.02 , 608.98 , 100, 30 ,20, 92, 1, 'Phone' )
,(618, 'P18', 'Samsung Galaxy S7'     , null, 538.44 , 562.34 , 75 , 15, 10, 54,  1, 'Phone' )
,(619, 'P19', 'Samasung Note'         , null, 547.58 , 481.83 , 75 , 15, 15, 58, 1, 'Tablet')
,(620, 'P20', 'Chromebook 11.6'       , null, 1078.81, 1008.61, 80 , 14, 10, 11, 1, 'Laptop');