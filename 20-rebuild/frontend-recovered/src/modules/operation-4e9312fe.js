const a = { get: ["production_cost_analysis:get"], download: ["production_cost_analysis:download"] }, t = { get: ["painting_fee_analysis:get"], download: ["painting_fee_analysis:download"] }, o = { get: ["auxiliary_fee_analysis:get"], download: ["auxiliary_fee_analysis:download"] }, s = { get: ["operation_testing:get"], download: ["operation_testing:download"] }, i = { get: ["operation_water_electricity:get"], download: ["operation_water_electricity:download"] }, n = { get: ["operation_management:get"], download: ["operation_management:download"] }, e = { get: ["operation_yield_analysis:get"] }, d = { get: ["operation_difference_analysis:get"] }, l = { get: ["purchasing_analysis:get"] }, r = { get: ["QHSE_analysis:get"] }, _ = { get: ["production_type_analysis:get"] }, c = { get: ["contract_analysis:get"], quantity: { detail: ["contract_quantity_analysis:detail"], download: ["contract_quantity_analysis:download"] }, amount: { detail: ["contract_amount_analysis:detail"], download: ["contract_amount_analysis:download"] }, mete: { detail: ["contract_mete_analysis:detail"], download: ["contract_mete_analysis:download"] } }, y = { get: ["program_analysis:get"], projectDetail: ["program_analysis:projectDetail"], invoice: { detail: ["program_invoice_analysis:detail"], download: ["program_invoice_analysis:download"] }, product: { detail: ["program_product_analysis:detail"], download: ["program_product_analysis:download"] }, execution: { detail: ["program_execution_analysis:detail"], download: ["program_execution_analysis:download"] }, feeding: { detail: ["program_feeding_analysis:detail"], download: ["program_feeding_analysis:download"] }, cost: { detail: ["program_cost_analysis:detail"], download: ["program_cost_analysis:download"] } }, g = { get: ["production_performance_dashboard:get"], workshopMete: { detail: ["workshop_mete_dashboard:detail"], download: ["workshop_mete_dashboard:download"] }, workshopTask: { detail: ["workshop_task_dashboard:detail"], download: ["workshop_task_dashboard:download"] }, loss: { detail: ["loss_dashboard:detail"], download: ["loss_dashboard:download"] } }, w = { get: ["cost_analysis:get"], download: ["cost_analysis:download"] }, p = { get: ["stock_analysis:get"], amount: { detail: ["amount_statistics:detail"], download: ["amount_statistics:download"] }, stock: { detail: ["stock_statistics:detail"], download: ["stock_statistics:download"] }, steel: { detail: ["steel_statistics:detail"], download: ["steel_statistics:download"] }, auxiliary: { detail: ["auxiliary_statistics:detail"], download: ["stock_statistics:download"] }, turnover: { detail: ["turnover_statistics:detail"], download: ["turnover_statistics:download"] }, remain: { detail: ["remain_statistics:detail"], download: ["remain_statistics:download"] } }, u = { get: ["purchase_analysis:get"], allYear: { detail: ["all_year_statistics:detail"], download: ["all_year_statistics:download"] }, supplier: { detail: ["supplier_statistics:detail"], download: ["supplier_statistics:download"] }, order: { detail: ["order_statistics:detail"], download: ["order_statistics:download"] } };
export {
  r as Q,
  o as a,
  n as b,
  c,
  w as d,
  a as e,
  g as f,
  _ as g,
  y as h,
  u as i,
  l as j,
  i as k,
  e as l,
  d as o,
  t as p,
  p as s,
  s as t
};
