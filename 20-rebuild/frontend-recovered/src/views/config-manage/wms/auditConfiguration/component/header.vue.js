import { resolveComponent as s } from "vue";
import { openBlock as V } from "vue";
import { createElementBlock as T } from "vue";
import { withDirectives as E } from "vue";
import { vShow as C } from "vue";
import { unref as e } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as a } from "vue";
import { withKeys as h } from "vue";
import { Fragment as N } from "vue";
import { ElInput as _ } from "element-plus";
import { gy as j, B as v, aS as L, C as S, E as w } from "../../../../../shared/runtime.js";
import { u as M } from "../../../../../modules/use-filter-item-enum-82000272.js";
const K = { __name: "header", setup(O) {
  const { filterItemsEnum: d } = M(), { BusinessModuleEnum: m } = j(), r = { name: void 0, status: void 0, objType: void 0, objIdsList: [], moduleType: void 0 }, i = { COMPANY: { L: "公司", K: "COMPANY", V: 4 }, DEPARTMENT: { L: "部门", K: "DEPARTMENT", V: 1 }, POST: { L: "岗位", K: "POST", V: 2 }, PERSONNEL: { L: "人员", K: "PERSONNEL", V: 3 } };
  function p(c) {
    o.objIdsList = [], n.toQuery();
  }
  const { crud: n, query: o } = v(r);
  return (c, t) => {
    const y = s("common-radio-button"), u = s("common-select"), f = _, b = s("common-select-v2");
    return V(), T(N, null, [E(g("div", null, [a(y, { modelValue: e(o).status, "onUpdate:modelValue": t[0] || (t[0] = (l) => e(o).status = l), options: e(L).ENUM, class: "filter-item", showOptionAll: "", type: "enum", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(u, { modelValue: e(o).moduleType, "onUpdate:modelValue": t[1] || (t[1] = (l) => e(o).moduleType = l), dataStructure: { key: "moduleType", label: "moduleTypeName", value: "moduleType" }, options: e(m), class: "filter-item", clearable: "", placeholder: "请选择业务模块", style: { width: "180px" }, type: "other", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(f, { modelValue: e(o).templateName, "onUpdate:modelValue": t[2] || (t[2] = (l) => e(o).templateName = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "输入功能审批流程搜索", size: "default", style: { width: "180px" }, onClear: e(n).toQuery, onKeyup: h(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onClear", "onKeyup"]), a(u, { modelValue: e(o).objType, "onUpdate:modelValue": t[3] || (t[3] = (l) => e(o).objType = l), options: i, class: "filter-item", clearable: "", placeholder: "请选择适用对象", style: { width: "180px" }, type: "enum", onChange: p }, null, 8, ["modelValue"]), a(b, { modelValue: e(o).objIdsList, "onUpdate:modelValue": t[4] || (t[4] = (l) => e(o).objIdsList = l), dataStructure: { key: "id", label: "name", value: "id" }, disabled: e(o).objType == null, options: e(d)[e(o).objType], class: "filter-item", clearable: "", multiple: "", placeholder: "请选择部门/岗位/人员", style: { width: "180px" }, type: "other", onChange: e(n).toQuery }, null, 8, ["modelValue", "disabled", "options", "onChange"]), a(e(S))], 512), [[C, e(n).searchToggle]]), a(e(w), { addText: "发起审批" })], 64);
  };
} };
export {
  K as default
};
