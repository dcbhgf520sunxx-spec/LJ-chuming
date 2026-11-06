import { ref as s } from "vue";
import { inject as q } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as A } from "vue";
import { createBlock as z } from "vue";
import { withCtx as t } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as D } from "vue";
import { toDisplayString as a } from "vue";
import { createElementVNode as c } from "vue";
import { unref as m } from "vue";
import { withDirectives as E } from "vue";
import { isRef as O } from "vue";
import { ElTag as P } from "element-plus";
import { ElTableColumn as $ } from "element-plus";
import { vLoading as G } from "element-plus";
import { l as J } from "../../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { _ as K, u as Q, o as W, D as f, ba as X } from "../../../../shared/runtime.js";
import Z from "./material-amortization-cost-details.vue.js";
import "../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../modules/model-0ac957f7.js";
const ee = { class: "content-header" }, te = ["onClick"], oe = { __name: "material-amortization-cost", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, currentData: { type: Object, default: () => {
} }, timeInterval: { type: String, default: "-" } }, emits: ["update:modelValue"], setup(u, { emit: j }) {
  const C = j, y = u, h = s(), I = s(), g = s(), _ = s(false), x = q("query"), b = s(false), k = s(), { visible: w, handleClose: Y } = Q({ emit: C, props: y, showHook: H, closeHook: M }), { maxHeight: V } = W({ mainBox: ".amount-detail", extraBox: [".el-drawer__header", ".content-header"], wrapperBox: ".el-drawer__body", extraHeight: 50, paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, h), F = s([["amortizationAmount", ["to-thousand", f.YUAN]], ["totalFee", ["to-thousand", f.YUAN]]]);
  async function N() {
    var r;
    _.value = true;
    try {
      const l = { projectId: (r = y.currentData) == null ? void 0 : r.projectId, boolTaxIncluded: x.boolTaxIncluded }, p = await J(l);
      g.value = p;
    } catch (l) {
      console.log(l);
    } finally {
      _.value = false;
    }
  }
  function H() {
    N();
  }
  function M() {
  }
  function R(r) {
    return X(r, { props: ["totalYield", "projectYield", ["amortizationAmount", f.YUAN], ["totalFee", f.YUAN]], toThousandFields: ["amortizationAmount", "totalFee"] });
  }
  function T(r) {
    b.value = true, k.value = r;
  }
  return (r, l) => {
    const p = P, B = v("print-table"), n = $, U = v("common-table"), L = v("common-drawer"), S = G;
    return A(), z(L, { ref_key: "drawerRef", ref: h, title: "辅材摊销成本", "close-on-click-modal": false, modelValue: m(w), "onUpdate:modelValue": l[1] || (l[1] = (i) => O(w) ? w.value = i : null), direction: "rtl", "before-close": m(Y), "wrapper-closable": false, "custom-class": "amount-detail", size: "50%" }, { titleAfter: t(() => [o(p, null, { default: t(() => {
      var i, d;
      return [D("项目：" + a(((i = u.currentData) == null ? void 0 : i.serialNumber) || "-") + " " + a(((d = u.currentData) == null ? void 0 : d.projectName) || "-"), 1)];
    }), _: 1 })]), content: t(() => {
      var i, d;
      return [c("div", ee, [o(p, null, { default: t(() => [D("统计日期：" + a(u.timeInterval || "-"), 1)]), _: 1 }), o(B, { "api-key": "auxiliaryMaterialsAmortizationCost", params: { projectId: (i = u.currentData) == null ? void 0 : i.projectId, boolTaxIncluded: m(x).boolTaxIncluded }, size: "default", type: "warning", class: "filter-item", style: { "margin-bottom": "10px" } }, null, 8, ["params"])]), E((A(), z(U, { ref_key: "tableRef", ref: I, data: g.value, "max-height": m(V), "data-format": F.value, "summary-method": R, "show-summary": "" }, { default: t(() => [o(n, { "show-overflow-tooltip": "", type: "index", label: "序号", align: "center", fixed: "left" }), o(n, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "月份", align: "center" }, { default: t((e) => [c("span", null, a(e.row.yearMonth || "-"), 1)]), _: 1 }), o(n, { "show-overflow-tooltip": "", prop: "totalYield", key: "totalYield", label: "总产量（吨）", align: "center" }, { default: t((e) => [c("span", null, a(e.row.totalYield || "-"), 1)]), _: 1 }), o(n, { "show-overflow-tooltip": "", prop: "projectYield", key: "projectYield", label: "项目产量（吨）", align: "center" }, { default: t((e) => [c("span", null, a(e.row.projectYield || "-"), 1)]), _: 1 }), o(n, { "show-overflow-tooltip": "", prop: "proportion", key: "proportion", label: "占比", align: "center" }, { default: t((e) => [c("span", null, a(e.row.proportion || e.row.proportion === 0 ? (e.row.proportion * 100).toFixed(2) + "%" : "-"), 1)]), _: 1 }), o(n, { "show-overflow-tooltip": "", prop: "totalFee", key: "totalFee", label: "总金额（元）", align: "center" }, { default: t((e) => [c("span", { style: { color: "#409eff", cursor: "pointer" }, onClick: (ae) => T(e.row) }, a(e.row.totalFee || "-"), 9, te)]), _: 1 }), o(n, { "show-overflow-tooltip": "", prop: "amortizationAmount", key: "amortizationAmount", label: "摊销金额（元）", align: "center" }, { default: t((e) => [c("span", null, a(e.row.amortizationAmount || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[S, _.value]]), o(m(Z), { visible: b.value, "onUpdate:visible": l[0] || (l[0] = (e) => b.value = e), data: (d = k.value) == null ? void 0 : d.auxiliaryMaterialDetailList }, null, 8, ["visible", "data"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, de = K(oe, [["__scopeId", "data-v-40b9041f"]]);
export {
  de as default
};
