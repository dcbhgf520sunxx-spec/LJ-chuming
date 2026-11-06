import { B as f, aV as y, a3 as h, C as b, E as C } from "../../../../../shared/runtime.js";
import { _ as I } from "../../../../../modules/process-select-b35dffc0.js";
import { inject as n } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as V } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as g } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
const E = { __name: "header", setup(w) {
  const r = { branchCompanyId: void 0, workshopId: void 0, productClassId: void 0, processId: void 0 }, p = n("branchList"), i = n("assembleClassIdList"), m = n("boolConfig"), { crud: s, query: o } = f(r);
  return (x, a) => {
    const u = d("common-select-v2"), c = d("common-select");
    return V(), _(e(C), { addText: "创建", disabled: !e(m) }, { optRight: g(() => [t(u, { modelValue: e(o).branchCompanyIdList, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(o).branchCompanyIdList = l), options: e(p), "data-structure": { key: "id", label: "name", value: "id" }, clearable: "", filterable: "", type: "other", size: "default", class: "filter-item", placeholder: "全部机构", style: { width: "280px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(e(y), { modelValue: e(o).workshopId, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(o).workshopId = l), placeholder: "全部车间", class: "filter-item", clearable: "", style: { width: "200px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), t(c, { modelValue: e(o).productClassId, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(o).productClassId = l), options: e(i), placeholder: "全部部件类型", type: "other", "data-structure": { key: "typeId", label: "typeName", value: "typeId" }, class: "filter-item", clearable: "", filterable: "", style: { width: "200px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(e(I), { modelValue: e(o).processId, "onUpdate:modelValue": a[3] || (a[3] = (l) => e(o).processId = l), productType: e(h).ASSEMBLE.V, size: "default", placeholder: "全部工序", filterable: "", clearable: "", class: "filter-item", multiple: false, style: { width: "200px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "productType", "onChange"]), t(e(b))]), _: 1 }, 8, ["disabled"]);
  };
} };
export {
  E as default
};
