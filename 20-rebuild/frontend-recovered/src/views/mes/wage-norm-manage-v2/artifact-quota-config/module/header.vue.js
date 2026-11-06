import { B as f, aV as y, a3 as h, C, E as b } from "../../../../../shared/runtime.js";
import { _ as I } from "../../../../../modules/process-select-b35dffc0.js";
import { inject as s } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as V } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as g } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
const U = { __name: "header", setup(w) {
  const r = { branchCompanyId: void 0, workshopId: void 0, productClassId: void 0, processId: void 0 }, p = s("branchList"), i = s("artifactTypeList"), u = s("boolConfig"), { crud: n, query: o } = f(r);
  return (x, t) => {
    const m = d("common-select-v2"), c = d("common-select");
    return V(), _(e(b), { addText: "创建", disabled: !e(u) }, { optRight: g(() => [l(m, { modelValue: e(o).branchCompanyIdList, "onUpdate:modelValue": t[0] || (t[0] = (a) => e(o).branchCompanyIdList = a), options: e(p), "data-structure": { key: "id", label: "name", value: "id" }, clearable: "", filterable: "", type: "other", size: "default", class: "filter-item", placeholder: "全部机构", style: { width: "280px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(e(y), { modelValue: e(o).workshopId, "onUpdate:modelValue": t[1] || (t[1] = (a) => e(o).workshopId = a), placeholder: "全部车间", class: "filter-item", clearable: "", style: { width: "200px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), l(c, { modelValue: e(o).productClassId, "onUpdate:modelValue": t[2] || (t[2] = (a) => e(o).productClassId = a), options: e(i), placeholder: "全部构件类型", type: "other", "data-structure": { key: "typeId", label: "typeName", value: "typeId" }, class: "filter-item", clearable: "", filterable: "", style: { width: "200px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(e(I), { modelValue: e(o).processId, "onUpdate:modelValue": t[3] || (t[3] = (a) => e(o).processId = a), productType: e(h).ARTIFACT.V, size: "default", placeholder: "全部工序", filterable: "", clearable: "", class: "filter-item", multiple: false, style: { width: "200px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "productType", "onChange"]), l(e(C))]), _: 1 }, 8, ["disabled"]);
  };
} };
export {
  U as default
};
