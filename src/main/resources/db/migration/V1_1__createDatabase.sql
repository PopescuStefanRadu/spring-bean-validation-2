create table voucher_template
(
    id                        character varying(40)       NOT NULL
        CONSTRAINT voucher_template_pk PRIMARY KEY,
    name                      character varying(255)      NOT NULL,
    voucher_code              character varying(255)      NOT NULL,
    voucher_value             numeric(19, 2)              NOT NULL,
    applicability_from        timestamp without time zone NOT NULL,
    applicability_until       timestamp without time zone NOT NULL,
    usage_type                bigint                      NOT NULL,
    nominal                   boolean                     NOT NULL,
    applicability_type        character varying(255)      NOT NULL,
    status                    character varying(255)      NOT NULL,
    created_at                timestamp without time zone,
    updated_at                timestamp without time zone,
    vendor_type               character varying(64)       NOT NULL,
    threshold                 bigint                      NOT NULL,
    maximum_budget            bigint                      NOT NULL,
    returnable                boolean                     NOT NULL,
    return_condition          character varying(255),
    maximum_returns           bigint,
    issuing_campaign_id       character varying(255),
    redemption_campaign_id    character varying(255),
    conditional_applicability character varying(255)
);
