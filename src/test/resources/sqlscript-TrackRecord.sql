-- -- Table: public.trackrecord

-- -- DROP TABLE public.trackrecord;

-- CREATE TABLE public.trackrecord
-- (
--     cardholder_name character varying(20) COLLATE pg_catalog."default",
--     control_no character varying(20) COLLATE pg_catalog."default",
--     expiry_date date,
--     id bigint NOT NULL,
--     lot_no character varying(20) COLLATE pg_catalog."default",
--     "CARD_DESIGN_ID" character varying(20) COLLATE pg_catalog."default",
--     card_design_id character varying(255) COLLATE pg_catalog."default",
--     ship_name character varying(255) COLLATE pg_catalog."default",
--     create_ts timestamp without time zone DEFAULT now(),
--     card_no character varying(255) COLLATE pg_catalog."default",
--     job_id bigint NOT NULL,
--     CONSTRAINT trackrecord_pkey PRIMARY KEY (id)
--     FOREIGN KEY (job_id) REFERENCES job (id)
-- )
-- WITH (
--     OIDS = FALSE
-- )
-- TABLESPACE pg_default;

-- ALTER TABLE public.trackrecord
--     OWNER to postgres;