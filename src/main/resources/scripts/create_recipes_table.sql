-- Create Recipes Table
CREATE TABLE IF NOT EXISTS public.recipes
(
    id uuid NOT NULL,
    name text NOT NULL,
    author_id uuid NOT NULL,
    prep_time bigint NOT NULL,
    cook_time bigint NOT NULL,
    description text NOT NULL,
    creation_time timestamptz NOT NULL,
    last_updated_time timestamptz NOT NULL,
    deletion_time timestamptz,
    PRIMARY KEY (id)
);

GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE public.recipes TO recipe_service_admin;