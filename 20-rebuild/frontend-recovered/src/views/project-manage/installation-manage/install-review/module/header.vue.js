import { m as f, K as s, tQ as j, F as p, B as I } from "../../../../../shared/runtime.js";
import { _ as b } from "../../../../../modules/subcontract-supplier-select-bab9e7f8.js";
import { watch as T } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as E } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as c } from "vue";
import { unref as e } from "vue";
import { renderSlot as v } from "vue";
const _ = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, A = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 }, globalProject: { type: Object, default: () => {
} } }, setup(d) {
  const n = d, { deliveryInstallEnumArr: m } = f("deliveryInstallEnumArr"), i = { projectId: { value: void 0, resetAble: false }, productType: n.globalProject.projectType === s.STEEL.V ? j.ARTIFACT.V : p.BOX.V, monomerId: void 0, areaId: void 0, name: void 0, serialNumber: void 0 }, { crud: o, query: t } = I(i);
  return T(() => n.projectId, (a) => {
    a && (o.query.projectId = n.projectId, o.toQuery());
  }, { immediate: true, deep: true }), (a, r) => {
    const y = V("common-radio-button");
    return g(), E("div", _, [u("div", null, [c(y, { modelValue: e(t).productType, "onUpdate:modelValue": r[0] || (r[0] = (l) => e(t).productType = l), options: d.globalProject.projectType === e(s).STEEL.V ? e(m) : [e(p).BOX], type: "enum", class: "filter-item", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), c(b, { modelValue: e(t).supplierId, "onUpdate:modelValue": r[1] || (r[1] = (l) => e(t).supplierId = l), projectId: e(t).projectId, clearable: "", class: "filter-item", placeholder: "请选择劳务单位", style: { width: "240px" }, onChange: e(o).toQuery }, null, 8, ["modelValue", "projectId", "onChange"])]), u("div", null, [v(a.$slots, "opeBtn")])]);
  };
} };
export {
  A as default
};
