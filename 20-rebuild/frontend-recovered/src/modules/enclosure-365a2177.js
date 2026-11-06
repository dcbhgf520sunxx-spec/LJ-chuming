const e = { get: ["enclosure_area_manage:get"], plan: { get: ["enclosure_area_plan_manage:get"], add: ["enclosure_area_plan_manage:add"], edit: ["enclosure_area_plan_manage:edit"], del: ["enclosure_area_plan_manage:del"] } }, r = { get: ["enclosure_standard_part:get"], add: ["enclosure_standard_part:add"], edit: ["enclosure_standard_part:edit"], del: ["enclosure_standard_part:del"], import: ["enclosure_standard_part:import"], templateDownload: ["enclosure_standard_part:templateDownload"] }, t = { get: ["enclosure_scheduling_manage:get"], add: ["enclosure_scheduling_manage:add"] }, n = { get: ["enclosure_scheduling_work_order:get"], del: ["enclosure_scheduling_work_order:del"], detail: ["enclosure_scheduling_work_order:detail"], print: ["enclosure_scheduling_work_order:print"] }, a = { get: ["enclosure_task_tracking:get"], detail: ["enclosure_task_tracking:detail"], print: ["enclosure_task_tracking:print"] }, s = { get: ["enclosure_project_overview:get"] }, o = { get: ["enclosure_production_statistics:get"], print: ["enclosure_production_statistics:print"] }, l = { get: ["enclosure_team_production:get"], detail: ["enclosure_team_production:detail"], print: ["enclosure_team_production:print"], printDetail: ["enclosure_team_production:printDetail"] }, c = { get: ["enclosure_type_analysis:get"] }, _ = { get: ["enclosure_label:get"], printSetting: ["enclosure_label:printSetting"], batchPrint: ["enclosure_label:batchPrint"], print: ["enclosure_label:print"], preview: ["enclosure_label:preview"], record: ["enclosure_label:record"] };
export {
  e as a,
  _ as b,
  s as c,
  t as d,
  r as e,
  a as f,
  n as g,
  o as h,
  l as i,
  c as j
};
