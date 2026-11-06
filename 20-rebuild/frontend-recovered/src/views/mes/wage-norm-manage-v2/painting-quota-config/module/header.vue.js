import { B as m, aV as f, C as y, E as h } from "../../../../../shared/runtime.js";
import { inject as n } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as C } from "vue";
import { createBlock as I } from "vue";
import { withCtx as V } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
const x = { __name: "header", setup(g) {
  const d = { branchCompanyId: void 0, workshopId: void 0, artifactClassId: void 0, processId: void 0 }, i = n("branchList"), p = n("artifactTypeList"), u = n("boolConfig"), c = n("filterProcess"), { crud: s, query: a } = m(d);
  return (_, t) => {
    const r = b("common-select-v2");
    return C(), I(e(h), { addText: "创建", disabled: !e(u) }, { optRight: V(() => [l(r, { modelValue: e(a).branchCompanyIdList, "onUpdate:modelValue": t[0] || (t[0] = (o) => e(a).branchCompanyIdList = o), options: e(i), "data-structure": { key: "id", label: "name", value: "id" }, clearable: "", filterable: "", type: "other", size: "default", class: "filter-item", placeholder: "全部机构", style: { width: "280px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(e(f), { modelValue: e(a).workshopId, "onUpdate:modelValue": t[1] || (t[1] = (o) => e(a).workshopId = o), placeholder: "全部车间", class: "filter-item", clearable: "", style: { width: "200px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), l(r, { modelValue: e(a).artifactClassId, "onUpdate:modelValue": t[2] || (t[2] = (o) => e(a).artifactClassId = o), options: e(p), placeholder: "全部构件类型", type: "other", "data-structure": { key: "typeId", label: "typeName", value: "typeId" }, class: "filter-item", clearable: "", filterable: "", style: { width: "200px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(r, { modelValue: e(a).processId, "onUpdate:modelValue": t[3] || (t[3] = (o) => e(a).processId = o), options: e(c), placeholder: "选择生产方式", type: "other", "data-structure": { key: "id", label: "name", value: "id" }, class: "filter-item", clearable: "", filterable: "", style: { width: "200px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(e(y))]), _: 1 }, 8, ["disabled"]);
  };
} };
export {
  x as default
};
