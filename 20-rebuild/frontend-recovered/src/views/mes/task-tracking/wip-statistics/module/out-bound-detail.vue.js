import { ref as u } from "vue";
import { inject as z } from "vue";
import { computed as D } from "vue";
import { resolveComponent as c } from "vue";
import { resolveDirective as I } from "vue";
import { openBlock as y } from "vue";
import { createBlock as x } from "vue";
import { withCtx as o } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as S } from "vue";
import { createElementVNode as a } from "vue";
import { toDisplayString as s } from "vue";
import { unref as r } from "vue";
import { withDirectives as V } from "vue";
import { isRef as A } from "vue";
import { ElTag as F } from "element-plus";
import { ElTableColumn as P } from "element-plus";
import { vLoading as G } from "element-plus";
import { g as J } from "../../../../../modules/wip-statistics-f9d24ea0.js";
import { nz as B, u as K, am as Q, o as W, cO as X, p as Y } from "../../../../../shared/runtime.js";
const Z = { class: "head-drawer", style: { display: "flex", "justify-content": "space-between", "margin-bottom": "8px" } }, $ = { style: { width: "300px" } }, ae = { __name: "out-bound-detail", props: { visible: { type: Boolean, default: false }, info: { type: Object } }, emits: ["update:visible"], setup(d, { emit: C }) {
  const b = u(), m = u(B.OUTBOUND.V), T = C, w = d, U = z("permission"), { visible: f, handleClose: j } = K({ emit: T, props: w, field: "visible", showHook: g }), k = u([["basicClass", ["parse-enum", Q, { bit: true }]]]), { maxHeight: O } = W({ extraBox: [".el-drawer__header", ".head-drawer"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, b), _ = u(false), p = u([]), v = D(() => {
    var i;
    return { projectId: (i = w.info.project) == null ? void 0 : i.id, type: m.value };
  });
  async function g() {
    try {
      p.value = [], _.value = true;
      const { content: i } = await J({ ...v.value });
      p.value = i.map((l) => l), await X(p.value);
    } catch (i) {
      console.log("获取出库记录详情失败", i);
    } finally {
      _.value = false;
    }
  }
  return (i, l) => {
    const M = F, N = c("common-radio-button"), R = c("print-table"), n = P, E = c("common-table"), H = c("common-drawer"), L = I("permission"), q = G;
    return y(), x(H, { ref_key: "drawerRef", ref: b, title: "钢材出库记录", modelValue: r(f), "onUpdate:modelValue": l[1] || (l[1] = (e) => A(f) ? f.value = e : null), direction: "rtl", "before-close": r(j), size: "70%" }, { titleAfter: o(() => [t(M, { size: "default", effect: "plain" }, { default: o(() => {
      var e, h;
      return [l[2] || (l[2] = S(" 项目：")), a("span", null, s((e = d.info.project) == null ? void 0 : e.serialNumber) + "-" + s((h = d.info.project) == null ? void 0 : h.name), 1)];
    }), _: 1, __: [2] })]), content: o(() => [a("div", Z, [t(N, { modelValue: m.value, "onUpdate:modelValue": l[0] || (l[0] = (e) => m.value = e), options: r(B).ENUM, class: "filter-item", type: "enum", onChange: g }, null, 8, ["modelValue", "options"]), a("div", $, [V(t(R, { "api-key": "mesOutBoundStatisticsList", params: { ...v.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[L, r(U).print]])])]), V((y(), x(E, { data: p.value, "data-format": k.value, "max-height": r(O), style: { width: "100%" } }, { default: o(() => [t(n, { label: "序号", type: "index", align: "center", width: "60" }), t(n, { prop: "basicClass", "show-overflow-tooltip": true, label: "物料种类", width: "150" }), t(n, { "show-overflow-tooltip": true, key: "specMerge", prop: "specMerge", label: "规格", align: "center" }, { default: o((e) => [a("span", null, s(e.row.specMerge), 1)]), _: 1 }), t(n, { "show-overflow-tooltip": true, align: "center", prop: "measureUnit", label: "计量单位" }, { default: o(({ row: e }) => [a("span", null, s(e.measureUnit), 1)]), _: 1 }), t(n, { "show-overflow-tooltip": true, align: "center", prop: "quantity", label: "数量" }, { default: o(({ row: e }) => [a("span", null, s(e.quantity), 1)]), _: 1 }), t(n, { "show-overflow-tooltip": true, align: "center", prop: "accountingUnit", label: "核算单位", width: "120" }, { default: o(({ row: e }) => [a("span", null, s(e.accountingUnit), 1)]), _: 1 }), t(n, { "show-overflow-tooltip": true, align: "center", prop: "mete", label: "核算量", width: "100" }, { default: o(({ row: e }) => [a("span", null, s(e.mete), 1)]), _: 1 }), t(n, { "show-overflow-tooltip": true, align: "center", prop: "outboundTime", label: "出库日期", width: "120" }, { default: o(({ row: e }) => [a("span", null, s(r(Y)(e.outboundTime, "{y}-{m}-{d}")), 1)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[q, _.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ae as default
};
