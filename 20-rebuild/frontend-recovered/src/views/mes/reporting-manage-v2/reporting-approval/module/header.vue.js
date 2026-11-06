import { ref as h } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as M } from "vue";
import { createElementVNode as u } from "vue";
import { withDirectives as c } from "vue";
import { vShow as p } from "vue";
import { createVNode as r } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as s } from "vue";
import { toDisplayString as E } from "vue";
import { unref as t } from "vue";
import { createBlock as w } from "vue";
import { createCommentVNode as v } from "vue";
import { withKeys as q } from "vue";
import { ElTag as L } from "element-plus";
import { ElInput as D } from "element-plus";
import { B as O, G as y, qd as b, C as P, qc as U } from "../../../../../shared/runtime.js";
import G from "../white-list-config/index.vue.js";
import Q from "../batch-review/index.vue.js";
import "../white-list-config/module/form.vue.js";
import "../../../../../modules/stud-set-1d850c87.js";
import "../../../../../modules/process-select-b35dffc0.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
import "../../../../../modules/use-production-team-d8043fd6.js";
import "../../../../../modules/reporting-approval-2b65eecd.js";
import "../../../../../modules/use-drawing-8a7ba23b.js";
import "../../../../../modules/bim-preview-drawer-7ca7893b.js";
import "../../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../../modules/model-0ac957f7.js";
import "../../../../../modules/index-d6a37d29.js";
import "../../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../../modules/use-chart-59e4b63c.js";
import "../../../../../modules/index-18acf776.js";
const W = { class: "flex-rbc" }, $ = { class: "flex-rbc" }, we = { __name: "header", props: { currentRow: { type: Object, default: () => {
} }, viewType: { type: [Number, String], default: null } }, emits: ["wageAdjust"], setup(o, { emit: S }) {
  const x = S, K = { productSerialNumber: void 0, date: { value: void 0, resetAble: false }, yearMonth: { value: void 0, resetAble: false }, processId: { value: void 0, resetAble: false }, productTypeEnum: { value: void 0, resetAble: false }, teamId: { value: void 0, resetAble: false }, workshopId: { value: void 0, resetAble: false } }, d = h(false), m = h(false), { crud: a, query: g } = O(K);
  function z() {
    d.value = true;
  }
  function B() {
    m.value = true;
  }
  return (H, e) => {
    var V, k, C, A;
    const R = L, f = j("common-button"), I = D;
    return n(), M("div", null, [u("div", W, [c(r(R, { effect: "plain", size: "large", class: "filter-item" }, { default: i(() => {
      var l, N, T, _;
      return [s(E((N = (l = o.currentRow) == null ? void 0 : l.workshop) == null ? void 0 : N.name) + " / " + E((_ = (T = o.currentRow) == null ? void 0 : T.team) == null ? void 0 : _.name), 1)];
    }), _: 1 }, 512), [[p, (V = o.currentRow) == null ? void 0 : V.rowKey]]), c(r(R, { type: "info", size: "large" }, { default: i(() => e[4] || (e[4] = [s(" * 请先选择左侧未审核列表")])), _: 1, __: [4] }, 512), [[p, !((k = o.currentRow) != null && k.rowKey)]]), u("div", null, [t(y)(t(b).whiteListConfig) ? (n(), w(f, { key: 0, type: "primary", size: "default", class: "filter-item", onClick: z }, { default: i(() => e[5] || (e[5] = [s(" 审核设置 ")])), _: 1, __: [5] })) : v("", true), t(y)(t(b).wageAdjustment) ? (n(), w(f, { key: 1, type: "warning", size: "default", class: "filter-item", onClick: e[0] || (e[0] = (l) => x("wageAdjust")) }, { default: i(() => e[6] || (e[6] = [s(" 工价调整 ")])), _: 1, __: [6] })) : v("", true)])]), c(u("div", $, [u("div", null, [r(I, { modelValue: t(g).productSerialNumber, "onUpdate:modelValue": e[1] || (e[1] = (l) => t(g).productSerialNumber = l), modelModifiers: { trim: true }, clearable: "", size: "default", placeholder: "编号搜索", class: "filter-item", onKeyup: q(t(a).toQuery, ["enter"]), style: { width: "200px" } }, null, 8, ["modelValue", "onKeyup"]), r(t(P))]), o.viewType === t(U).REAL_TIME_WORK_REPORTING.V && t(y)(t(b).passTheAudit) ? (n(), w(f, { key: 0, type: "success", size: "default", class: "filter-item", disabled: !((C = t(a).selections) != null && C.length), onClick: B }, { default: i(() => e[7] || (e[7] = [s(" 批量审核 ")])), _: 1, __: [7] }, 8, ["disabled"])) : v("", true)], 512), [[p, (A = o.currentRow) == null ? void 0 : A.rowKey]]), r(t(G), { modelValue: d.value, "onUpdate:modelValue": e[2] || (e[2] = (l) => d.value = l) }, null, 8, ["modelValue"]), r(t(Q), { modelValue: m.value, "onUpdate:modelValue": e[3] || (e[3] = (l) => m.value = l), selections: t(a).selections, currentRow: o.currentRow, onSuccess: t(a).refresh }, null, 8, ["modelValue", "selections", "currentRow", "onSuccess"])]);
  };
} };
export {
  we as default
};
