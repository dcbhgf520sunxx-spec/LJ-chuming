const e = { get: ["user:get"], add: ["user:add"], edit: ["user:edit"], del: ["user:del"], resetToDefaultPwd: ["user:resetToDefaultPassword"], async: ["user:async"], record: ["user:record"], export: ["user:export"], getPasswordPolicy: ["user:getPasswordPolicy"], editPasswordPolicy: ["user:editPasswordPolicy"] }, o = { get: ["dept:get"], add: ["dept:add"], edit: ["dept:edit"], del: ["dept:del"], async: ["dept:async"] }, t = { get: ["job:get"], add: ["job:add"], edit: ["job:edit"], del: ["job:del"], async: ["job:async"] }, d = { get: ["role:get"], add: ["role:add"], edit: ["role:edit"], del: ["role:del"] }, r = { get: ["project_add_staff:get"], addSubmit: ["project_add_staff:addSubmit"], coverSubmit: ["project_add_staff:coverSubmit"] }, s = { get: ["person_bound_project:get"], submit: ["person_bound_project:submit"], join: ["person_bound_project:join"], remove: ["person_bound_project:remove"] }, a = { get: ["roster_config:get"], detail: ["roster_config:detail"], add: ["roster_config:add"], edit: ["roster_config:edit"], del: ["roster_config:del"], editStatus: ["roster_config:editStatus"], download: ["roster_config:download"] };
export {
  a,
  r as b,
  o as d,
  t as j,
  s as p,
  d as r,
  e as u
};
