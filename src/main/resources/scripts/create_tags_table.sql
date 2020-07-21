-- Create Tags Table
CREATE TABLE IF NOT EXISTS public.tags
(
    id uuid NOT NULL,
    name text NOT NULL,
    creation_time timestamptz NOT NULL,
    last_updated_time timestamptz NOT NULL,
    deletion_time timestamptz,
    PRIMARY KEY (id)
);

ALTER TABLE public.tags
    OWNER TO recipe_service_admin;
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE public.tags TO recipe_service_admin;