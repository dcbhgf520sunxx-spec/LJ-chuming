import { ref as c } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as j } from "vue";
import { createElementBlock as N } from "vue";
import { withDirectives as C } from "vue";
import { vShow as L } from "vue";
import { unref as e } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as n } from "vue";
import { ElDatePicker as A } from "element-plus";
import { l as m, _ as T, bF as p, B as I, iF as x, E as P } from "../../../../../../shared/runtime.js";
import { u as S } from "../../../../../../modules/useSelect-654af12a.js";
function U(s) {
  return m({ url: "/api/project/v2/projectLedger/supplierLedger", method: "get", params: { ...s, level: 2 } });
}
function w(s) {
  return m({ url: "/api/project/v2/projectLedger/getOrderNumber/2", method: "get", params: s });
}
function E() {
  return m({ url: "/api/project/v2/projectLedger/projectFilter", method: "get", params: { projectAttribute: "1", level: "2" } });
}
const M = { get: U };
const k = { class: "head-container" }, O = { class: "date-container box-container" }, Q = { __name: "Header", setup(s) {
  const { supplierList: v } = S(), h = { projectId: void 0, serialNumber: void 0, supplierId: void 0, purchaseType: p.RAW_MATERIAL.V, settlementStatus: void 0, year: (/* @__PURE__ */ new Date()).getTime() }, { crud: l, query: o } = I(h), d = c([]), f = c([p.RAW_MATERIAL, p.MANUFACTURED, p.SUBCONTRACTING]), g = async () => {
    try {
      const a = await w({ purchaseType: o.purchaseType });
      if (!a) {
        d.value = [];
        return;
      }
      d.value = a.map((t, i) => ({ index: i, name: t }));
    } catch (a) {
      console.error("获取采购合同号失败:getPurchaseNumberList", a);
    }
  };
  g();
  const y = c([]);
  return (async () => {
    try {
      const a = await E();
      a.length && (y.value = a.map((t) => ({ ...t, projectNames: t.serialNumber + " - " + t.shortName })));
    } catch (a) {
      console.error("获取项目列表失败:getProjectList", a);
    }
  })(), (a, t) => {
    const i = A, V = b("common-radio-button"), u = b("common-select-v2");
    return j(), N("div", k, [C(_("div", O, [n(i, { modelValue: e(o).year, "onUpdate:modelValue": t[0] || (t[0] = (r) => e(o).year = r), clearable: "", editable: "", placeholder: "请选择年份", style: { width: "100px" }, type: "year", "value-format": "x", onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), n(V, { modelValue: e(o).settlementStatus, "onUpdate:modelValue": t[1] || (t[1] = (r) => e(o).settlementStatus = r), options: e(x).V, showOptionAll: "", type: "enum", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(u, { modelValue: e(o).purchaseType, "onUpdate:modelValue": t[2] || (t[2] = (r) => e(o).purchaseType = r), options: f.value, filterable: "", placeholder: "类型筛选", type: "enum", onChange: t[3] || (t[3] = () => {
      e(l).toQuery(), g();
    }) }, null, 8, ["modelValue", "options"]), n(u, { modelValue: e(o).projectId, "onUpdate:modelValue": t[4] || (t[4] = (r) => e(o).projectId = r), "data-structure": { key: "id", label: "projectNames", value: "id" }, options: y.value, clearable: "", filterable: "", placeholder: "项目筛选", style: { width: "340px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(u, { modelValue: e(o).supplierId, "onUpdate:modelValue": t[5] || (t[5] = (r) => e(o).supplierId = r), "data-structure": { key: "id", label: "name", value: "id" }, options: e(v), clearable: "", filterable: "", placeholder: "供应商筛选", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(u, { modelValue: e(o).serialNumber, "onUpdate:modelValue": t[6] || (t[6] = (r) => e(o).serialNumber = r), "data-structure": { key: "index", label: "name", value: "name" }, options: d.value, clearable: "", filterable: "", placeholder: "筛选合同号", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"])], 512), [[L, e(l).searchToggle]]), _("div", null, [n(e(P))])]);
  };
} }, H = T(Q, [["__scopeId", "data-v-b10a005f"]]), q = Object.freeze(Object.defineProperty({ __proto__: null, default: H }, Symbol.toStringTag, { value: "Module" }));
export {
  q as H,
  M as c,
  H as m
};
