import { ref as p } from "vue";
import { onMounted as j } from "vue";
import { watch as x } from "vue";
import { openBlock as y } from "vue";
import { createBlock as C } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as e } from "vue";
import { withDirectives as k } from "vue";
import { createElementBlock as q } from "vue";
import { withModifiers as g } from "vue";
import { toDisplayString as l } from "vue";
import { createVNode as v } from "vue";
import { unref as h } from "vue";
import { ElProgress as B } from "element-plus";
import { ElCard as S } from "element-plus";
import { vLoading as D } from "element-plus";
import { g as E } from "../../../../modules/program-analysis-f1c6c876.js";
import { _ as O, bs as I } from "../../../../shared/runtime.js";
import V from "./collect-and-invoice-detail.vue.js";
const z = { style: { height: "200px", display: "flex", "align-items": "center", "justify-content": "space-evenly" } }, A = { style: { "font-size": "14px" } }, L = { class: "progress-content" }, M = { style: { "font-size": "14px" } }, N = { __name: "collect-and-invoice", props: { query: { type: Object, default: () => ({}) }, projectInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(r) {
  const n = r, s = p({}), b = p(false), u = p(false);
  j(() => {
    f();
  }), x([() => n.query, () => {
    var t;
    return (t = n.projectInfo) == null ? void 0 : t.id;
  }], (t) => {
    f();
  });
  async function f() {
    var t, o, a;
    try {
      const i = await E({ projectId: (t = n.projectInfo) == null ? void 0 : t.id, branchCompanyId: (o = n.query) == null ? void 0 : o.branchCompanyId, settlementStatus: (a = n.query) == null ? void 0 : a.settlementStatus });
      s.value = i || {};
    } catch (i) {
      console.log(i, "e");
    }
  }
  function _() {
    u.value = true;
  }
  return (t, o) => {
    const a = B, i = S, w = D;
    return y(), C(i, null, { header: d(() => o[1] || (o[1] = [e("div", null, [e("div", null, "收票及开票")], -1)])), default: d(() => {
      var m;
      return [k((y(), q("div", z, [e("div", { class: "progress-content", onClick: g(_, ["stop"]) }, [e("div", null, "累计收款：" + l(s.value.accumulatedCollection || 0), 1), v(a, { type: "circle", status: "warning", percentage: s.value.collectionRatio * 100, "stroke-width": 16, width: 150 }, { default: d(({ percentage: c }) => [e("span", A, l(h(I)(c, 2)) + "%", 1)]), _: 1 }, 8, ["percentage"])]), e("div", L, [e("div", null, "合同（结算）额：" + l(s.value.amount || 0), 1)]), e("div", { class: "progress-content", onClick: g(_, ["stop"]) }, [e("div", null, "累计开票：" + l(s.value.accumulatedInvoice || 0), 1), v(a, { type: "circle", status: "primary", percentage: s.value.invoiceRatio * 100, "stroke-width": 16, width: 150 }, { default: d(({ percentage: c }) => [e("span", M, l(h(I)(c, 2)) + "%", 1)]), _: 1 }, 8, ["percentage"])])])), [[w, b.value]]), v(V, { visible: u.value, "onUpdate:visible": o[0] || (o[0] = (c) => u.value = c), "project-info": r.projectInfo, query: r.query, permission: (m = r.permission) == null ? void 0 : m.invoice }, null, 8, ["visible", "project-info", "query", "permission"])];
    }), _: 1 });
  };
} }, G = O(N, [["__scopeId", "data-v-e7a78142"]]);
export {
  G as default
};
