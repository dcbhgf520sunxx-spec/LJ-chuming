import { _ as B, dp as R, j0 as p } from "../../../../../../shared/runtime.js";
import { ref as u } from "vue";
import { inject as z } from "vue";
import { computed as f } from "vue";
import { onMounted as L } from "vue";
import { watch as N } from "vue";
import { resolveComponent as P } from "vue";
import { openBlock as y } from "vue";
import { createBlock as b } from "vue";
import { withCtx as t } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as s } from "vue";
import { createElementVNode as n } from "vue";
import { toDisplayString as O } from "vue";
import { unref as x } from "vue";
import { resolveDynamicComponent as U } from "vue";
import { defineAsyncComponent as c } from "vue";
import { ElButton as q } from "element-plus";
import { ElRadioButton as h } from "element-plus";
import { ElRadioGroup as G } from "element-plus";
import { ElTag as H } from "element-plus";
import { ElDrawer as K } from "element-plus";
const M = { class: "record-container" }, $ = { class: "header-container" }, F = { class: "left-elements" }, J = { class: "radio-container" }, Q = { class: "sub-title" }, W = { class: "print-container" }, X = { __name: "index", props: { level: { type: [Number, String], required: true }, apikey: { type: Array, required: true } }, emits: ["component-mounted"], setup(k, { expose: V, emit: E }) {
  const r = k, g = E, l = u(false), { projectInfo: m } = z("tableItem"), a = u(""), w = { collection: c(() => p(() => import("./collection-table.vue.js"), ["static/js/collection-table-51cf2f98.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/useTableTotal-3d22365a.js", "static/js/self-healing-6f411a5c.js", "static/js/file-download-82b299aa.js", "static/css/collection-table-65bed5d1.css"])), preSettle: c(() => p(() => import("./pre-settle.vue.js"), ["static/js/pre-settle-e3289269.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/useTableTotal-3d22365a.js", "static/js/self-healing-6f411a5c.js", "static/js/file-download-82b299aa.js", "static/css/pre-settle-bab4476f.css"])), expend: c(() => p(() => import("./invoice-table.vue.js"), ["static/js/invoice-table-cc8eef1c.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/useTableTotal-3d22365a.js", "static/js/self-healing-6f411a5c.js", "static/js/file-download-82b299aa.js", "static/css/invoice-table-857a01c4.css"])) }, I = f(() => w[a.value]), T = f(() => a.value === "collection" ? r.apikey.collection : a.value === "preSettle" ? r.apikey.preSettle : r.apikey.expend), i = u(null);
  return L(() => {
    g("component-mounted", true);
  }), N(() => l.value, async (v) => {
    var e;
    v && await ((e = i == null ? void 0 : i.value) == null ? void 0 : e.getList());
  }), V({ visible: l, radioType: a }), (v, e) => {
    const C = q, d = h, D = G, j = H, S = P("print-table"), A = K;
    return y(), b(A, { modelValue: l.value, "onUpdate:modelValue": e[2] || (e[2] = (_) => l.value = _), "close-on-click-modal": false, "close-on-press-escape": false, "show-close": false, size: "100%" }, { header: t(() => [o(R, { "type-one": false, "header-title": "收款与开票记录" }), o(C, { plain: "", onClick: e[0] || (e[0] = (_) => l.value = false) }, { default: t(() => e[3] || (e[3] = [s("关闭")])), _: 1, __: [3] })]), default: t(() => [n("div", M, [n("div", $, [n("div", F, [n("div", J, [o(D, { modelValue: a.value, "onUpdate:modelValue": e[1] || (e[1] = (_) => a.value = _), class: "box-container", size: "default" }, { default: t(() => [o(d, { value: "preSettle" }, { default: t(() => e[4] || (e[4] = [s("预结算明细")])), _: 1, __: [4] }), o(d, { value: "collection" }, { default: t(() => e[5] || (e[5] = [s("收款明细")])), _: 1, __: [5] }), o(d, { value: "expend" }, { default: t(() => e[6] || (e[6] = [s("开票明细")])), _: 1, __: [6] })]), _: 1 }, 8, ["modelValue"])]), n("div", Q, [o(j, { size: "large", type: "primary" }, { default: t(() => [s("项目名称 : " + O(x(m).project.name), 1)]), _: 1 })])]), n("div", W, [o(S, { "api-key": T.value, params: x(m).project.id, class: "animate__fadeIn", size: "default", type: "warning" }, null, 8, ["api-key", "params"])])]), (y(), b(U(I.value), { ref_key: "tableRef", ref: i, level: r.level, class: "animate__fadeIn" }, null, 8, ["level"]))])]), _: 1 }, 8, ["modelValue"]);
  };
} }, te = B(X, [["__scopeId", "data-v-72794b9c"]]);
export {
  te as default
};
