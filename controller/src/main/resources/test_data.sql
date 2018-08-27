-- Clients
INSERT INTO "BOOKING_SERVICE".public.client (id, email, name, phone, secret)
    VALUES (1,'1-client@mail.com','First Client','+375290000001','password');

INSERT INTO "BOOKING_SERVICE".public.client (id, email, name, phone, secret)
    VALUES (2,'2-client@mail.com','Second Client','+375290000002','password');

-- Companies
INSERT INTO "BOOKING_SERVICE".public.company (id, email, name, phone, secret, description)
    VALUES (1,'1-company@mail.com','First Company','+375330000001','password','This is a first company');

INSERT INTO "BOOKING_SERVICE".public.company (id, email, name, phone, secret, description)
    VALUES (2,'2-company@mail.com','Second Company','+375330000002','password','This is a second company');

-- Services
INSERT INTO "BOOKING_SERVICE".public.service (id, description, duration, max_client_quantity, name, company_id)
    VALUES (1, 'First service of the first company', 3600, 1, 'Service-1', 1);

INSERT INTO "BOOKING_SERVICE".public.service (id, description, duration, max_client_quantity, name, company_id)
    VALUES (2, 'Second service of the first company', 5400, 3, 'Service-2', 1);

-- Providers
INSERT INTO "BOOKING_SERVICE".public.provider (id, email, name, phone, secret, company_id)
    VALUES (1, '1-provider@mail.com', 'First Provider', '+375440000001', 'password', 1);

INSERT INTO "BOOKING_SERVICE".public.provider (id, email, name, phone, secret, company_id)
    VALUES (2, '2-provider@mail.com', 'Second Provider', '+375440000002', 'password', 1);

INSERT INTO "BOOKING_SERVICE".public.provider (id, email, name, phone, secret, company_id)
    VALUES (3, '3-provider@mail.com', 'Third Provider', '+375440000003', 'password', 1);

-- Service_Provider
INSERT INTO "BOOKING_SERVICE".public.svc_pvd (svc_id, pvd_id)
    VALUES (1,1);

INSERT INTO "BOOKING_SERVICE".public.svc_pvd (svc_id, pvd_id)
    VALUES (1,2);

INSERT INTO "BOOKING_SERVICE".public.svc_pvd (svc_id, pvd_id)
    VALUES (2,2);

INSERT INTO "BOOKING_SERVICE".public.svc_pvd (svc_id, pvd_id)
    VALUES (2,3);

-- Schedule for Provider-1
INSERT INTO "BOOKING_SERVICE".public.sch_for_day (id, day_of_week, provider_id)
    VALUES (1, 1, 1);
INSERT INTO "BOOKING_SERVICE".public.sch_for_day (id, day_of_week, provider_id)
    VALUES (2, 2, 1);
INSERT INTO "BOOKING_SERVICE".public.sch_for_day (id, day_of_week, provider_id)
    VALUES (3, 3, 1);
INSERT INTO "BOOKING_SERVICE".public.sch_for_day (id, day_of_week, provider_id)
    VALUES (4, 4, 1);
INSERT INTO "BOOKING_SERVICE".public.sch_for_day (id, day_of_week, provider_id)
    VALUES (5, 5, 1);
INSERT INTO "BOOKING_SERVICE".public.sch_for_day (id, day_of_week, provider_id)
    VALUES (6, 6, 1);
INSERT INTO "BOOKING_SERVICE".public.sch_for_day (id, day_of_week, provider_id)
    VALUES (7, 7, 1);

-- Schedule for Provider-2
INSERT INTO "BOOKING_SERVICE".public.sch_for_day (id, day_of_week, provider_id)
    VALUES (8, 1, 2);
INSERT INTO "BOOKING_SERVICE".public.sch_for_day (id, day_of_week, provider_id)
    VALUES (9, 2, 2);
INSERT INTO "BOOKING_SERVICE".public.sch_for_day (id, day_of_week, provider_id)
    VALUES (10, 3, 2);
INSERT INTO "BOOKING_SERVICE".public.sch_for_day (id, day_of_week, provider_id)
    VALUES (11, 4, 2);
INSERT INTO "BOOKING_SERVICE".public.sch_for_day (id, day_of_week, provider_id)
    VALUES (12, 5, 2);
INSERT INTO "BOOKING_SERVICE".public.sch_for_day (id, day_of_week, provider_id)
    VALUES (13, 6, 2);
INSERT INTO "BOOKING_SERVICE".public.sch_for_day (id, day_of_week, provider_id)
    VALUES (14, 7, 2);

-- Schedule for Provider-3
INSERT INTO "BOOKING_SERVICE".public.sch_for_day (id, day_of_week, provider_id)
    VALUES (15, 1, 3);
INSERT INTO "BOOKING_SERVICE".public.sch_for_day (id, day_of_week, provider_id)
    VALUES (16, 2, 3);
INSERT INTO "BOOKING_SERVICE".public.sch_for_day (id, day_of_week, provider_id)
    VALUES (17, 3, 3);
INSERT INTO "BOOKING_SERVICE".public.sch_for_day (id, day_of_week, provider_id)
    VALUES (18, 4, 3);
INSERT INTO "BOOKING_SERVICE".public.sch_for_day (id, day_of_week, provider_id)
    VALUES (19, 5, 3);
INSERT INTO "BOOKING_SERVICE".public.sch_for_day (id, day_of_week, provider_id)
    VALUES (20, 6, 3);
INSERT INTO "BOOKING_SERVICE".public.sch_for_day (id, day_of_week, provider_id)
    VALUES (21, 7, 3);

-- Time Periods for Provider-1
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (1, '09:00:00', '13:00:00', 1);
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (2, '14:00:00', '18:00:00', 1);

INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (3, '09:00:00', '13:00:00', 2);
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (4, '14:00:00', '18:00:00', 2);

INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (5, '09:00:00', '13:00:00', 3);
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (6, '14:00:00', '18:00:00', 3);

INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (7, '09:00:00', '13:00:00', 4);
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (8, '14:00:00', '18:00:00', 4);

INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (9, '09:00:00', '13:00:00', 5);
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (10, '14:00:00', '18:00:00', 5);

INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (11, '09:00:00', '13:00:00', 6);
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (12, '14:00:00', '18:00:00', 6);

INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (13, '09:00:00', '13:00:00', 7);
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (14, '14:00:00', '18:00:00', 7);

-- Time Periods for Provider-2
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (15, '09:00:00', '13:00:00', 8);
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (16, '14:00:00', '18:00:00', 8);

INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (17, '09:00:00', '13:00:00', 9);
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (18, '14:00:00', '18:00:00', 9);

INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (19, '09:00:00', '13:00:00', 10);
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (20, '14:00:00', '18:00:00', 10);

INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (21, '09:00:00', '13:00:00', 11);
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (22, '14:00:00', '18:00:00', 11);

INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (23, '09:00:00', '13:00:00', 12);
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (24, '14:00:00', '18:00:00', 12);

INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (25, '09:00:00', '13:00:00', 13);
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (26, '14:00:00', '18:00:00', 13);

INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (27, '09:00:00', '13:00:00', 14);
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (28, '14:00:00', '18:00:00', 14);

-- Time Periods for Provider-3
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (29, '09:00:00', '13:00:00', 15);
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (30, '14:00:00', '18:00:00', 15);

INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (31, '09:00:00', '13:00:00', 16);
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (32, '14:00:00', '18:00:00', 16);

INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (33, '09:00:00', '13:00:00', 17);
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (34, '14:00:00', '18:00:00', 17);

INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (35, '09:00:00', '13:00:00', 18);
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (36, '14:00:00', '18:00:00', 18);

INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (37, '09:00:00', '13:00:00', 19);
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (38, '14:00:00', '18:00:00', 19);

INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (39, '09:00:00', '13:00:00', 20);
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (40, '14:00:00', '18:00:00', 20);

INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (41, '09:00:00', '13:00:00', 21);
INSERT INTO "BOOKING_SERVICE".public.per_for_day (id, start_time, end_time, schedule_for_day_id)
VALUES (42, '14:00:00', '18:00:00', 21);

-- Reservations
INSERT INTO "BOOKING_SERVICE".public.reservation (id, comment, local_date, local_time, client_id, provider_id, service_id)
    VALUES (1, 'First reservation for Client-1', '2018-08-02', '09:00:00', 1, 1, 1);