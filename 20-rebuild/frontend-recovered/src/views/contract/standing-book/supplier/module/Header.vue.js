import { ref as i } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as V } from "vue";
import { createElementBlock as f } from "vue";
import { withDirectives as N } from "vue";
import { vShow as C } from "vue";
import { unref as e } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as n } from "vue";
import { ElDatePicker as T } from "element-plus";
import { _ as A, bF as u, B as L, iF as j, E as I } from "../../../../../shared/runtime.js";
import { u as x } from "../../../../../modules/useSelect-654af12a.js";
import { g as U, a as w } from "../../../../../modules/supplier-e2667d36.js";
const E = { class: "head-container" }, P = { class: "date-container box-container" }, k = { __name: "Header", setup(Q) {
  const { supplierList: b } = x(), g = { projectId: void 0, serialNumber: void 0, supplierId: void 0, purchaseType: u.RAW_MATERIAL.V, settlementStatus: void 0, year: (/* @__PURE__ */ new Date()).getTime() }, { crud: r, query: o } = L(g), p = i([]), h = i([u.RAW_MATERIAL, u.MANUFACTURED, u.SUBCONTRACTING]), m = async () => {
    try {
      const l = await U({ purchaseType: o.purchaseType });
      if (!l) {
        p.value = [];
        return;
      }
      p.value = l.map((t, d) => ({ index: d, name: t }));
    } catch (l) {
      console.error("获取合同号失败:getPurchaseNumberList", l);
    }
  };
  m();
  const c = i([]);
  return (async () => {
    try {
      const l = await w();
      l.length && (c.value = l.map((t) => ({ ...t, projectNames: t.serialNumber + " - " + t.shortName })));
    } catch (l) {
      console.error("获取项目列表失败:getProjectList", l);
    }
  })(), (l, t) => {
    const d = T, v = y("common-radio-button"), s = y("common-select-v2");
    return V(), f("div", E, [N(_("div", P, [n(d, { modelValue: e(o).year, "onUpdate:modelValue": t[0] || (t[0] = (a) => e(o).year = a), clearable: "", editable: "", placeholder: "请选择年份", style: { width: "100px" }, type: "year", "value-format": "x", onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), n(v, { modelValue: e(o).settlementStatus, "onUpdate:modelValue": t[1] || (t[1] = (a) => e(o).settlementStatus = a), options: e(j).V, showOptionAll: "", type: "enum", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(s, { modelValue: e(o).purchaseType, "onUpdate:modelValue": t[2] || (t[2] = (a) => e(o).purchaseType = a), options: h.value, filterable: "", placeholder: "类型筛选", type: "enum", onChange: t[3] || (t[3] = () => {
      e(r).toQuery(), m();
    }) }, null, 8, ["modelValue", "options"]), n(s, { modelValue: e(o).projectId, "onUpdate:modelValue": t[4] || (t[4] = (a) => e(o).projectId = a), "data-structure": { key: "id", label: "projectNames", value: "id" }, options: c.value, clearable: "", filterable: "", placeholder: "项目筛选", style: { width: "340px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(s, { modelValue: e(o).supplierId, "onUpdate:modelValue": t[5] || (t[5] = (a) => e(o).supplierId = a), "data-structure": { key: "id", label: "name", value: "id" }, options: e(b), clearable: "", filterable: "", placeholder: "供应商筛选", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(s, { modelValue: e(o).serialNumber, "onUpdate:modelValue": t[6] || (t[6] = (a) => e(o).serialNumber = a), "data-structure": { key: "index", label: "name", value: "name" }, options: p.value, clearable: "", filterable: "", placeholder: "筛选合同号", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"])], 512), [[C, e(r).searchToggle]]), _("div", null, [n(e(I))])]);
  };
} }, O = A(k, [["__scopeId", "data-v-96593480"]]);
export {
  O as default
};
