import { ref as P } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as d } from "vue";
import { unref as e } from "vue";
import { createVNode as l } from "vue";
import { createElementVNode as L } from "vue";
import { createCommentVNode as N } from "vue";
import { withCtx as f } from "vue";
import { createTextVNode as v } from "vue";
import { Fragment as S } from "vue";
import { renderList as U } from "vue";
import { ElMessage as I } from "element-plus";
import { ElDatePicker as w } from "element-plus";
import { ElOption as D } from "element-plus";
import { ElSelect as O } from "element-plus";
import { cO as z, jl as B, cP as M, B as k, zb as x, cV as h, vI as W, cm as Q, I as F, E as A } from "../../../../../../../shared/runtime.js";
import { u as R } from "../../../../../../../modules/use-print-4d7e67fe.js";
import { d as $ } from "../../../../../../../modules/receipt-mode-c54e9044.js";
import { _ as q } from "../../../../../../../modules/warehouse-project-cascader-17e2b952.js";
function H() {
  async function y(r) {
    Array.isArray(r) || (r = [r]);
    const u = [], n = [];
    for (const t of r) {
      const a = $(t).then((i) => {
        i && i.materialList && n.push.apply(n, i.materialList);
      });
      u.push(a);
    }
    return await Promise.all(u), await z(n), await B(n, { toSmallest: false, toNum: false }), n.forEach((t) => {
      var a;
      t.projectShortName = (a = t.project) == null ? void 0 : a.shortName, t.basicClass === M.STEEL_COIL.V ? t.printNumber = 1 : t.printNumber = t.quantity;
    }), n;
  }
  return { getDetailMaterialList: y };
}
const G = { class: "head-container" }, K = { key: 0 }, J = { __name: "header", emits: ["printed-success"], setup(y, { emit: r }) {
  const u = P([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), n = { boolPrinted: false, materialLabelPrintType: void 0, projectWarehouseType: void 0, projectId: void 0, basicClass: h, createDate: [], boolPartyA: true }, { crud: t, query: a } = k(n), { print: i } = R(), { getDetailMaterialList: C } = H();
  async function _(p) {
    t.data = [], t.setColumns(), t.toQuery();
  }
  async function g() {
    if (!t.selections || t.selections.length === 0) {
      I.warning("请选择需要打印的单据");
      return;
    }
    const p = t.selections.map((o) => o.id);
    await i(() => C(p), t.props.copies), t.refresh();
  }
  return (p, o) => {
    const m = b("common-radio-button"), V = w, T = b("common-button"), E = D, j = O;
    return c(), d("div", G, [e(t).searchToggle ? (c(), d("div", K, [l(m, { modelValue: e(a).materialLabelPrintType, "onUpdate:modelValue": o[0] || (o[0] = (s) => e(a).materialLabelPrintType = s), options: e(x).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: _ }, null, 8, ["modelValue", "options"]), l(m, { modelValue: e(a).basicClass, "onUpdate:modelValue": o[1] || (o[1] = (s) => e(a).basicClass = s), "option-all-value": e(h), options: e(W).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: _ }, null, 8, ["modelValue", "option-all-value", "options"]), l(m, { modelValue: e(a).boolPrinted, "onUpdate:modelValue": o[2] || (o[2] = (s) => e(a).boolPrinted = s), options: e(Q).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(V, { modelValue: e(a).createDate, "onUpdate:modelValue": o[3] || (o[3] = (s) => e(a).createDate = s), "default-time": u.value, shortcuts: e(F), class: "filter-item", clearable: "", "end-placeholder": "结束日期", "range-separator": ":", size: "default", "start-placeholder": "开始日期", style: { width: "300px" }, type: "daterange", "value-format": "x", onChange: e(t).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), o[7] || (o[7] = L("br", null, null, -1)), l(e(q), { projectId: e(a).projectId, "onUpdate:projectId": o[4] || (o[4] = (s) => e(a).projectId = s), projectWarehouseType: e(a).projectWarehouseType, "onUpdate:projectWarehouseType": o[5] || (o[5] = (s) => e(a).projectWarehouseType = s), showProjectWarehouseType: false, class: "filter-item", onChange: e(t).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"])])) : N("", true), l(e(A), null, { optLeft: f(() => [l(T, { class: "filter-item", icon: "el-icon-printer", size: "default", type: "success", onClick: g }, { default: f(() => o[8] || (o[8] = [v(" 批量打印 ")])), _: 1, __: [8] }), l(j, { modelValue: e(t).props.copies, "onUpdate:modelValue": o[6] || (o[6] = (s) => e(t).props.copies = s), placeholder: "可选择打印份数", size: "default", style: { width: "100px" } }, { default: f(() => [(c(), d(S, null, U(3, (s) => l(E, { key: `copies_${s}`, label: `打印${s}份`, value: s }, null, 8, ["label", "value"])), 64))]), _: 1 }, 8, ["modelValue"])]), _: 1 })]);
  };
} }, oe = Object.freeze(Object.defineProperty({ __proto__: null, default: J }, Symbol.toStringTag, { value: "Module" }));
export {
  J as _,
  oe as h,
  H as u
};
