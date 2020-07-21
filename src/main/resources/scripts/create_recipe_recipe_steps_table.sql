-- Table: public.recipe_recipe_steps

CREATE TABLE IF NOT EXISTS public.recipe_recipe_steps
(
    recipe_id uuid NOT NULL,
    recipe_step_id uuid NOT NULL,
    index integer NOT NULL,
    CONSTRAINT recipe_recipe_steps_pkey PRIMARY KEY (recipe_id, index),
    CONSTRAINT unique_recipe_step_constraint UNIQUE (recipe_step_id),
    CONSTRAINT recipe_id_fkey FOREIGN KEY (recipe_id)
        REFERENCES public.recipes (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT recipe_step_fkey FOREIGN KEY (recipe_step_id)
        REFERENCES public.recipe_steps (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE public.recipe_recipe_steps TO recipe_service_admin;