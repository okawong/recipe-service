-- Create Recipe Steps Table
CREATE TABLE IF NOT EXISTS public.recipe_steps
(
    id uuid NOT NULL,
    instructions text NOT NULL,
    image_url text,
    creation_time timestamptz NOT NULL,
    last_updated_time timestamptz NOT NULL,
    deletion_time timestamptz,
    PRIMARY KEY (id)
);

GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE public.recipe_steps TO recipe_service_admin;
