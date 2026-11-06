import { ref as P } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as c } from "vue";
import { unref as e } from "vue";
import { createVNode as s } from "vue";
import { createElementVNode as L } from "vue";
import { createCommentVNode as v } from "vue";
import { withCtx as f } from "vue";
import { createTextVNode as N } from "vue";
import { Fragment as U } from "vue";
import { renderList as I } from "vue";
import { ElMessage as S } from "element-plus";
import { ElDatePicker as w } from "element-plus";
import { ElOption as D } from "element-plus";
import { ElSelect as O } from "element-plus";
import { cO as z, jl as B, am as M, B as k, zb as x, vI as Q, cV as C, cm as W, I as F, E as R } from "../../../../../shared/runtime.js";
import { u as $ } from "../../../../../modules/use-print-d47bc68b.js";
import { d as q } from "../../../../../modules/receipt-mode-c54e9044.js";
import { _ as A } from "../../../../../modules/warehouse-project-cascader-17e2b952.js";
function H() {
  async function y(r) {
    Array.isArray(r) || (r = [r]);
    const u = [], n = [];
    for (const t of r) {
      const l = q(t).then((i) => {
        i && i.materialList && n.push.apply(n, i.materialList);
      });
      u.push(l);
    }
    return await Promise.all(u), await z(n), await B(n, { toSmallest: false, toNum: false }), n.forEach((t) => {
      t.basicClass === M.STEEL_COIL.V ? t.printNumber = 1 : t.printNumber = t.quantity;
    }), n;
  }
  return { getDetailMaterialList: y };
}
const G = { class: "head-container" }, K = { key: 0 }, J = { __name: "header", emits: ["printed-success"], setup(y, { emit: r }) {
  const u = P([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), n = { boolPrinted: false, materialLabelPrintType: void 0, projectWarehouseType: void 0, projectId: void 0, basicClass: C, createDate: [] }, { crud: t, query: l } = k(n), { print: i } = $(), { getDetailMaterialList: h } = H();
  async function _(p) {
    t.data = [], t.setColumns(), t.toQuery();
  }
  async function g() {
    if (!t.selections || t.selections.length === 0) {
      S.warning("请选择需要打印的单据");
      return;
    }
    const p = t.selections.map((o) => o.id);
    await i(() => h(p), t.props.copies), t.refresh();
  }
  return (p, o) => {
    const m = b("common-radio-button"), V = w, E = b("common-button"), T = D, j = O;
    return d(), c("div", G, [e(t).searchToggle ? (d(), c("div", K, [s(m, { modelValue: e(l).materialLabelPrintType, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(l).materialLabelPrintType = a), options: e(x).ENUM, "show-option-all": "", type: "enum", size: "default", class: "filter-item", onChange: _ }, null, 8, ["modelValue", "options"]), s(m, { modelValue: e(l).basicClass, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(l).basicClass = a), options: e(Q).ENUM, "show-option-all": "", "option-all-value": e(C), type: "enum", size: "default", class: "filter-item", onChange: _ }, null, 8, ["modelValue", "options", "option-all-value"]), s(m, { modelValue: e(l).boolPrinted, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(l).boolPrinted = a), options: e(W).ENUM, "show-option-all": "", type: "enum", size: "default", class: "filter-item", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(V, { modelValue: e(l).createDate, "onUpdate:modelValue": o[3] || (o[3] = (a) => e(l).createDate = a), type: "daterange", "range-separator": ":", size: "default", class: "filter-item", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "300px" }, clearable: "", shortcuts: e(F), "default-time": u.value, "value-format": "x", onChange: e(t).toQuery }, null, 8, ["modelValue", "shortcuts", "default-time", "onChange"]), o[7] || (o[7] = L("br", null, null, -1)), s(e(A), { projectId: e(l).projectId, "onUpdate:projectId": o[4] || (o[4] = (a) => e(l).projectId = a), projectWarehouseType: e(l).projectWarehouseType, "onUpdate:projectWarehouseType": o[5] || (o[5] = (a) => e(l).projectWarehouseType = a), class: "filter-item", onChange: e(t).toQuery }, null, 8, ["projectId", "projectWarehouseType", "onChange"])])) : v("", true), s(e(R), null, { optLeft: f(() => [s(E, { class: "filter-item", type: "success", size: "default", icon: "el-icon-printer", onClick: g }, { default: f(() => o[8] || (o[8] = [N("批量打印")])), _: 1, __: [8] }), s(j, { modelValue: e(t).props.copies, "onUpdate:modelValue": o[6] || (o[6] = (a) => e(t).props.copies = a), placeholder: "可选择打印份数", size: "default", style: { width: "100px" } }, { default: f(() => [(d(), c(U, null, I(3, (a) => s(T, { key: `copies_${a}`, label: `打印${a}份`, value: a }, null, 8, ["label", "value"])), 64))]), _: 1 }, 8, ["modelValue"])]), _: 1 })]);
  };
} }, oe = Object.freeze(Object.defineProperty({ __proto__: null, default: J }, Symbol.toStringTag, { value: "Module" }));
export {
  J as _,
  oe as h,
  H as u
};
