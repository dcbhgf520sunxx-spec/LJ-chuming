import { resolveComponent as r } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as i } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { ElInput as f } from "element-plus";
import { B as c, xe as s, xg as y, C as V } from "../../../../../shared/runtime.js";
const N = { class: "head-container" }, h = { __name: "header", setup(_) {
  const m = { deptName: void 0, jobName: void 0, name: void 0, phone: void 0, userType: void 0, crudType: void 0 }, { crud: d, query: l } = c(m);
  return (b, o) => {
    const t = f, u = r("common-radio-button");
    return p(), i("div", N, [a(t, { style: { width: "160px" }, modelValue: e(l).deptName, "onUpdate:modelValue": o[0] || (o[0] = (n) => e(l).deptName = n), class: "filter-item", placeholder: "部门名称", clearable: "" }, null, 8, ["modelValue"]), a(t, { style: { width: "160px" }, modelValue: e(l).jobName, "onUpdate:modelValue": o[1] || (o[1] = (n) => e(l).jobName = n), class: "filter-item", placeholder: "岗位名称", clearable: "" }, null, 8, ["modelValue"]), a(t, { style: { width: "160px" }, modelValue: e(l).name, "onUpdate:modelValue": o[2] || (o[2] = (n) => e(l).name = n), class: "filter-item", placeholder: "姓名", clearable: "" }, null, 8, ["modelValue"]), a(u, { modelValue: e(l).userType, "onUpdate:modelValue": o[3] || (o[3] = (n) => e(l).userType = n), options: [e(s).ORDINARY_PERSONNEL, e(s).LABOR_PERSONNEL], type: "enum", class: "filter-item", showOptionAll: "", size: "default", onChange: e(d).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(u, { modelValue: e(l).crudType, "onUpdate:modelValue": o[4] || (o[4] = (n) => e(l).crudType = n), options: e(y).ENUM, type: "enum", class: "filter-item", showOptionAll: "", size: "default", onChange: e(d).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(e(V))]);
  };
} };
export {
  h as default
};
