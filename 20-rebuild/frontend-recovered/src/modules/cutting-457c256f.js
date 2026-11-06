const t = { get: ["machine_configuration:get"], del: ["machine_configuration:del"], edit: ["machine_configuration:edit"] }, i = { get: ["cutting_report:get"], detail: ["cutting_report:detail"] }, e = { get: ["nest_work_list:get"], detail: ["nest_work_list:detail"], download: ["nest_work_list:download"], Production: ["nest_work_list:Production"], taskLoading: ["nest_work_list:taskLoading"] }, n = { get: ["nesting_task:get"], detail: ["nesting_task:detail"], statistics: ["nesting_task:statistics"] }, s = { get: ["nesting_list:get"], edit: ["nesting_list:edit"], revoke: ["nesting_list:revoke"], Nesting: ["nesting_list:Nesting"], views: ["nesting_list:views"], delPart: ["nesting_list:delPart"], addPart: ["nesting_list:addPart"] }, a = { get: ["cutting_scheduling:get"], detailMachine: ["cutting_scheduling:detailMachine"], detailProject: ["cutting_scheduling:detailProject"] }, g = { get: ["cutting_working:get"], detail: ["cutting_working:detail"], download: ["cutting_working:download"], Production: ["cutting_working:Production"], taskLoading: ["cutting_working:taskLoading"], cleanLoading: ["cutting_working:cleanLoading"], resetLoading: ["cutting_working:resetLoading"], downloadDrawing: ["cutting_working:downloadDrawing"] }, o = { get: ["project_tasking:get"], detail: ["project_tasking:detail"], detailResult: ["project_tasking:detailResult"], detailDelete: ["project_tasking:detailDelete"], pauseCutting: ["project_tasking:pauseCutting"], statistics: ["project_tasking:statistics"] }, d = { get: ["device_tasking:get"], detail: ["device_tasking:detail"], detailResult: ["device_tasking:detailResult"] };
export {
  a,
  g as b,
  i as c,
  d,
  n as e,
  e as f,
  t as m,
  s as n,
  o as p
};
