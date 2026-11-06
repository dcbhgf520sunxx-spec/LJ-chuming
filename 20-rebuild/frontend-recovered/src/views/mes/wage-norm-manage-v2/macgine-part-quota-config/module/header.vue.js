import { inject as d } from "vue";
import { computed as i } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as V } from "vue";
import { withCtx as v } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { ElCascader as I } from "element-plus";
import { e8 as p, B as w, aV as x, C as E, E as L } from "../../../../../shared/runtime.js";
const B = { __name: "header", setup(k) {
  const u = { branchCompanyId: void 0, workshopId: void 0, productClassificationEnum: void 0, processId: void 0 }, m = d("branchList"), r = d("processOptions"), f = d("boolConfig"), h = i(() => ({ value: "id", label: "name", children: "nameInfos", expandTrigger: "hover", emitPath: false })), C = i(() => {
    let t = [];
    return r.value.length && a.productClassificationEnum ? r.value.forEach((o) => {
      o.name === p.VL[a.productClassificationEnum] && (t = o.nameInfos);
    }) : t = r.value, t;
  }), { crud: s, query: a } = w(u);
  return (t, o) => {
    const b = c("common-select-v2"), y = c("common-select"), g = I;
    return _(), V(e(L), { addText: "创建", disabled: !e(f) }, { optRight: v(() => [n(b, { modelValue: e(a).branchCompanyIdList, "onUpdate:modelValue": o[0] || (o[0] = (l) => e(a).branchCompanyIdList = l), options: e(m), "data-structure": { key: "id", label: "name", value: "id" }, clearable: "", filterable: "", type: "other", size: "default", class: "filter-item", placeholder: "全部机构", style: { width: "280px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(e(x), { modelValue: e(a).workshopId, "onUpdate:modelValue": o[1] || (o[1] = (l) => e(a).workshopId = l), placeholder: "全部车间", class: "filter-item", clearable: "", style: { width: "200px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), n(y, { modelValue: e(a).productClassificationEnum, "onUpdate:modelValue": o[2] || (o[2] = (l) => e(a).productClassificationEnum = l), options: e(p).ENUM, type: "enum", filterable: "", clearable: "", placeholder: "请选择零件类型", class: "filter-item", style: { width: "200px" }, onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(g, { modelValue: e(a).processId, "onUpdate:modelValue": o[3] || (o[3] = (l) => e(a).processId = l), options: C.value, props: h.value, "show-all-levels": false, clearable: "", size: "default", style: { width: "200px" }, class: "filter-item", placeholder: "选择工序", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "props", "onChange"]), n(e(E))]), _: 1 }, 8, ["disabled"]);
  };
} };
export {
  B as default
};
