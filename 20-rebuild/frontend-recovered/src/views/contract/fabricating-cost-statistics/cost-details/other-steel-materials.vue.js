import { ref as s } from "vue";
import { inject as q } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as D } from "vue";
import { createBlock as j } from "vue";
import { withCtx as t } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as A } from "vue";
import { toDisplayString as a } from "vue";
import { createElementVNode as c } from "vue";
import { unref as m } from "vue";
import { withDirectives as O } from "vue";
import { isRef as E } from "vue";
import { ElTag as P } from "element-plus";
import { ElTableColumn as $ } from "element-plus";
import { vLoading as G } from "element-plus";
import { s as J } from "../../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { _ as K, u as Q, o as W, D as f, ba as X } from "../../../../shared/runtime.js";
import Z from "./material-amortization-cost-details.vue.js";
import "../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../modules/model-0ac957f7.js";
const ee = { class: "content-header" }, te = ["onClick"], oe = { __name: "other-steel-materials", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, currentData: { type: Object, default: () => {
} }, timeInterval: { type: String, default: "-" } }, emits: ["update:modelValue"], setup(u, { emit: I }) {
  const Y = I, v = u, y = s(), M = s(), g = s(), _ = s(false), b = s(false), x = s(), k = q("query"), { visible: w, handleClose: V } = Q({ emit: Y, props: v, showHook: N, closeHook: H }), { maxHeight: z } = W({ mainBox: ".amount-detail", extraBox: [".el-drawer__header", ".content-header"], wrapperBox: ".el-drawer__body", extraHeight: 50, paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, y), C = s([["amortizationAmount", ["to-thousand", f.YUAN]], ["totalFee", ["to-thousand", f.YUAN]]]);
  async function F() {
    var r;
    _.value = true;
    try {
      const l = { projectId: (r = v.currentData) == null ? void 0 : r.projectId, boolTaxIncluded: k.boolTaxIncluded }, p = await J(l);
      g.value = p;
    } catch (l) {
      console.log(l);
    } finally {
      _.value = false;
    }
  }
  function N() {
    F();
  }
  function H() {
  }
  function R(r) {
    return X(r, { props: ["totalYield", "projectYield", ["amortizationAmount", f.YUAN], ["totalFee", f.YUAN]], toThousandFields: ["amortizationAmount", "totalFee"] });
  }
  function S(r) {
    b.value = true, x.value = r;
  }
  return (r, l) => {
    const p = P, T = h("print-table"), n = $, B = h("common-table"), U = h("common-drawer"), L = G;
    return D(), j(U, { ref_key: "drawerRef", ref: y, title: "其它钢材摊销", "close-on-click-modal": false, modelValue: m(w), "onUpdate:modelValue": l[1] || (l[1] = (i) => E(w) ? w.value = i : null), direction: "rtl", "before-close": m(V), "wrapper-closable": false, "custom-class": "amount-detail", size: "50%" }, { titleAfter: t(() => [o(p, null, { default: t(() => {
      var i, d;
      return [A("项目：" + a(((i = u.currentData) == null ? void 0 : i.serialNumber) || "-") + " " + a(((d = u.currentData) == null ? void 0 : d.projectName) || "-"), 1)];
    }), _: 1 })]), content: t(() => {
      var i, d;
      return [c("div", ee, [o(p, null, { default: t(() => [A("统计日期：" + a(u.timeInterval || "-"), 1)]), _: 1 }), o(T, { "api-key": "otherSteelMaterials", params: { projectId: (i = u.currentData) == null ? void 0 : i.projectId, boolTaxIncluded: m(k).boolTaxIncluded }, size: "default", type: "warning", class: "filter-item", style: { "margin-bottom": "10px" } }, null, 8, ["params"])]), O((D(), j(B, { ref_key: "tableRef", ref: M, data: g.value, "max-height": m(z), "data-format": C.value, "summary-method": R, "show-summary": "" }, { default: t(() => [o(n, { "show-overflow-tooltip": "", type: "index", label: "序号", align: "center", fixed: "left" }), o(n, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "月份", align: "center" }, { default: t((e) => [c("span", null, a(e.row.yearMonth || "-"), 1)]), _: 1 }), o(n, { "show-overflow-tooltip": "", prop: "totalYield", key: "totalYield", label: "总产量（吨）", align: "center" }, { default: t((e) => [c("span", null, a(e.row.totalYield || "-"), 1)]), _: 1 }), o(n, { "show-overflow-tooltip": "", prop: "projectYield", key: "projectYield", label: "项目产量（吨）", align: "center" }, { default: t((e) => [c("span", null, a(e.row.projectYield || "-"), 1)]), _: 1 }), o(n, { "show-overflow-tooltip": "", prop: "proportion", key: "proportion", label: "占比", align: "center" }, { default: t((e) => [c("span", null, a(e.row.proportion || e.row.proportion === 0 ? (e.row.proportion * 100).toFixed(2) + "%" : "-"), 1)]), _: 1 }), o(n, { "show-overflow-tooltip": "", prop: "totalFee", key: "totalFee", label: "总金额（元）", align: "center" }, { default: t((e) => [c("span", { style: { color: "#409eff", cursor: "pointer" }, onClick: (ae) => S(e.row) }, a(e.row.totalFee || "-"), 9, te)]), _: 1 }), o(n, { "show-overflow-tooltip": "", prop: "amortizationAmount", key: "amortizationAmount", label: "摊销金额（元）", align: "center" }, { default: t((e) => [c("span", null, a(e.row.amortizationAmount || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[L, _.value]]), o(m(Z), { visible: b.value, "onUpdate:visible": l[0] || (l[0] = (e) => b.value = e), data: (d = x.value) == null ? void 0 : d.auxiliaryMaterialDetailList }, null, 8, ["visible", "data"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, de = K(oe, [["__scopeId", "data-v-ceb569f0"]]);
export {
  de as default
};
