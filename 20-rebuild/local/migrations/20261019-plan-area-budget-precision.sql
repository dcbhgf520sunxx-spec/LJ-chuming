-- Preserve the original 19 integer digits and current editor's two fractional digits.
-- Execute only through migrate-plan-budget-precision.py with its exact schema guard.
ALTER TABLE plan_area MODIFY COLUMN mete DECIMAL(21,2) NULL DEFAULT NULL COMMENT '工程量';
