-- Additive local compatibility for the current V2 plan editor. Historical values stay NULL.
ALTER TABLE plan_area
  ADD COLUMN delivery_start_date date NULL DEFAULT NULL COMMENT 'V2交货开始日期',
  ADD COLUMN delivery_end_date date NULL DEFAULT NULL COMMENT 'V2交货结束日期';
