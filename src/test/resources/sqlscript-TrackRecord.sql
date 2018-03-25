-- Table: public.trackrecord

DROP TABLE public.trackrecord;

CREATE TABLE public.trackrecord
(
    id bigint NOT NULL,
    CARD_NUMBER character varying(20) COLLATE pg_catalog."default",
    PAN_SEQ_NO character varying(20) COLLATE pg_catalog."default",
    SVC_CODE character varying(20) COLLATE pg_catalog."default",
    EXPIRY_DATE date,
    EFFECTIVE_DATE date,
    CARDHOLDER_NAME character varying(60) COLLATE pg_catalog."default",
    TRACK1_DATA character varying(255) COLLATE pg_catalog."default",
    TRACK2_DATA character varying(255) COLLATE pg_catalog."default",
    CVV_CODE1 character varying(255) COLLATE pg_catalog."default",
    CVV_CODE2 character varying(255) COLLATE pg_catalog."default",
    PING character varying(255) COLLATE pg_catalog."default",
    create_ts timestamp without time zone DEFAULT now(),
    job_id bigint,
    CONSTRAINT trackrecord_pkey PRIMARY KEY (id),
    CONSTRAINT trackrecord_to_job FOREIGN KEY (job_id)
        REFERENCES public.job (job_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.trackrecord
    OWNER to postgres;