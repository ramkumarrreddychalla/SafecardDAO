-- Table: public.job

-- DROP TABLE public.job;

CREATE TABLE public.job
(
    job_name character varying(60) COLLATE pg_catalog."default",
    file_name character varying(60) COLLATE pg_catalog."default",
    job_data date,
    file_id bigint NOT NULL,
    create_ts timestamp without time zone DEFAULT now(),
    job_date date,
    records_count bigint,
    CONSTRAINT job_pkey PRIMARY KEY (file_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.job
    OWNER to postgres;