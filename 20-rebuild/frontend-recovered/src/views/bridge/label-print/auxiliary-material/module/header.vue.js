import { ref as g } from "vue";
import { reactive as q } from "vue";
import { inject as y } from "vue";
import { resolveComponent as A } from "vue";
import { resolveDirective as B } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as O } from "vue";
import { withDirectives as C } from "vue";
import { vShow as S } from "vue";
import { unref as t } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as a } from "vue";
import { withCtx as n } from "vue";
import { createTextVNode as f } from "vue";
import { toDisplayString as D } from "vue";
import { createBlock as H } from "vue";
import { Fragment as $ } from "vue";
import { ElInputNumber as M } from "element-plus";
import { ElFormItem as G } from "element-plus";
import { ElForm as K } from "element-plus";
import { ElPopover as J } from "element-plus";
import { ElTag as W } from "element-plus";
import { m as X } from "../../../../../modules/print-record-c36add77.js";
import { B as Y, m as Z, V as _, q as ee, bl as te, ap as ae, C as ne, E as le } from "../../../../../shared/runtime.js";
import { s as oe, Q as se } from "../../../../../modules/bridge-label-a62ef559.js";
import { u as ie } from "../../../../../modules/use-label-print-47f6f6b0.js";
import { u as re } from "../../../../../modules/use-global-project-id-change-to-query-ff2f0762.js";
const ue = { style: { "text-align": "right" } }, ye = { __name: "header", setup(de, { expose: v }) {
  const Q = { classifyId: void 0, monomerId: void 0 }, { crud: i, query: d, CRUD: V } = Y(Q), I = re(i), { requestUrl: h } = Z(["requestUrl"]);
  V.HOOK.handleRefresh = (o, e) => {
    e.data.content = e.data.content.map((r) => (r.printedQuantity = r.printQuantity, r.printQuantity = 1, r));
  };
  const m = g(false);
  let l = q({ copiesQuantity: 1 });
  const u = g(_(l)), x = y("permission"), { getLabelInfo: P, printLabelFunc: k } = y("headerObj"), { batchPrint: w, print: E } = ie({ getPrintTotalNumber: (o) => (o.printQuantity || 0) * u.value.copiesQuantity, getLabelInfo: P, printFinallyHook: i.toQuery, getLoadingTextFunc: (o) => `${o.classifyName}-${o.serialNumber}`, printLabelFunc: k, needAddPrintRecord: true, addPrintIdField: "id", addPrintRecordReq: X });
  function R(o) {
    o || (l.copiesQuantity = 1);
  }
  function j() {
    m.value = false, l = Object.assign(l, _(u.value));
  }
  async function z() {
    u.value = _(l), m.value = false;
  }
  return v({ printConfig: u, spliceQrCodeUrl: oe, QR_SCAN_PATH: se, requestUrl: h, print: E }), (o, e) => {
    const r = M, F = G, L = K, p = A("common-button"), N = J, T = W, U = B("permission");
    return b(), O($, null, [C(c("div", null, [a(t(ee), { modelValue: t(d).monomerId, "onUpdate:modelValue": e[0] || (e[0] = (s) => t(d).monomerId = s), "project-id": t(I), default: false, clearable: "", class: "filter-item", onChange: t(i).toQuery }, null, 8, ["modelValue", "project-id", "onChange"]), a(ae, { modelValue: t(d).classifyId, "onUpdate:modelValue": e[1] || (e[1] = (s) => t(d).classifyId = s), "basic-class": t(te).MATERIAL.V, separator: " > ", "check-strictly": "", "show-all-levels": "", clearable: "", size: "default", class: "filter-item", style: { width: "300px" }, placeholder: "可选择/输入科目、编号搜索", onChange: t(i).toQuery }, null, 8, ["modelValue", "basic-class", "onChange"]), a(t(ne))], 512), [[S, t(i).searchToggle]]), a(t(le), null, { optRight: n(() => [a(N, { visible: m.value, "onUpdate:visible": e[3] || (e[3] = (s) => m.value = s), placement: "bottom-start", width: "400" }, { reference: n(() => [a(p, { type: "primary", size: "default" }, { default: n(() => e[5] || (e[5] = [f("打印设置")])), _: 1, __: [5] })]), default: n(() => [a(L, { ref: "form", model: t(l), "label-width": "90px", size: "default" }, { default: n(() => [a(F, { label: "份数" }, { default: n(() => [a(r, { modelValue: t(l).copiesQuantity, "onUpdate:modelValue": e[2] || (e[2] = (s) => t(l).copiesQuantity = s), step: 1, min: 1, max: 999, style: { width: "250px" }, onChange: R }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"]), c("div", ue, [a(p, { size: "default", type: "success", onClick: j }, { default: n(() => e[6] || (e[6] = [f("取 消")])), _: 1, __: [6] }), a(p, { size: "default", type: "primary", onClick: z }, { default: n(() => e[7] || (e[7] = [f("保 存")])), _: 1, __: [7] })])]), _: 1 }, 8, ["visible"]), a(T, { hit: "", size: "large", style: { "margin-left": "5px" }, effect: "plain" }, { default: n(() => [c("span", null, [c("span", null, "份数：" + D(u.value.copiesQuantity), 1)])]), _: 1 })]), viewLeft: n(() => [C((b(), H(p, { type: "success", size: "default", disabled: t(i).selections.length === 0, onClick: e[4] || (e[4] = (s) => t(w)(t(i).selections)) }, { default: n(() => e[8] || (e[8] = [f("批量打印标签 ")])), _: 1, __: [8] }, 8, ["disabled"])), [[U, t(x).print]])]), _: 1 })], 64);
  };
} };
export {
  ye as default
};
