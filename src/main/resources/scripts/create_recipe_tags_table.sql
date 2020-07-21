CREATE TABLE IF NOT EXISTS public.recipe_tags
(
    recipe_id uuid NOT NULL,
    tag_id uuid NOT NULL,
    creation_time timestamptz NOT NULL,
    last_updated_time timestamptz NOT NULL,
    deletion_time timestamptz,
    CONSTRAINT "recipe_tags_recipe_id_fk" FOREIGN KEY ("recipe_id")
        REFERENCES public.recipes (id)
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT "recipe_tags_tag_id_fk" FOREIGN KEY ("tag_id")
        REFERENCES public.tags (id)
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE public.recipe_tags TO recipe_service_admin;