-- -- Table: public.trackrecord

-- -- DROP TABLE public.trackrecord;

-- CREATE TABLE public.job
-- (
--     job_name character varying(20) COLLATE pg_catalog."default",
--     file_name character varying(20) COLLATE pg_catalog."default",
--     job_data date,
--     job_id bigint NOT NULL,
--     create_ts timestamp without time zone DEFAULT now(),
--     CONSTRAINT job_pkey PRIMARY KEY (job_id)
-- )
-- WITH (
--     OIDS = FALSE
-- )
-- TABLESPACE pg_default;
--
-- ALTER TABLE public.jobs
--     OWNER to postgres;