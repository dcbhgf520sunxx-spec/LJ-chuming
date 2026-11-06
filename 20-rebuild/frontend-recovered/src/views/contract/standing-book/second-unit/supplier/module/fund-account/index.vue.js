import { _ as P, e3 as U, dp as u, j0 as b } from "../../../../../../../shared/runtime.js";
import { ref as p } from "vue";
import { inject as O } from "vue";
import { computed as c } from "vue";
import { onMounted as S } from "vue";
import { resolveComponent as q } from "vue";
import { resolveDirective as F } from "vue";
import { openBlock as t } from "vue";
import { createBlock as i } from "vue";
import { withCtx as a } from "vue";
import { createVNode as n } from "vue";
import { createTextVNode as d } from "vue";
import { createElementVNode as s } from "vue";
import { unref as y } from "vue";
import { createCommentVNode as x } from "vue";
import { createElementBlock as m } from "vue";
import { Fragment as G } from "vue";
import { renderList as H } from "vue";
import { toDisplayString as k } from "vue";
import { withDirectives as K } from "vue";
import { resolveDynamicComponent as M } from "vue";
import { defineAsyncComponent as D } from "vue";
import { ElButton as $ } from "element-plus";
import { ElRadioButton as J } from "element-plus";
import { ElRadioGroup as Q } from "element-plus";
import { ElCol as W } from "element-plus";
import { ElRow as X } from "element-plus";
import { ElDrawer as Y } from "element-plus";
const Z = { class: "record-container" }, ee = { class: "header-container" }, oe = { class: "print-container" }, te = { class: "item" }, ae = { class: "truncate" }, ne = { class: "collection-info" }, se = { __name: "index", emits: ["component-mounted"], setup(le, { expose: V, emit: w }) {
  const C = w, r = p(false), E = p(0), { projectInfo: _ } = O("tableItem"), l = p("collection"), I = { collection: D(() => b(() => import("./CollectionInvoicing.vue.js"), ["static/js/CollectionInvoicing-d007f4ef.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/self-healing-6f411a5c.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/useTableTotal-3d22365a.js"])), expend: D(() => b(() => import("./AccumulatedExpenses.vue.js"), ["static/js/AccumulatedExpenses-f52b5823.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/self-healing-6f411a5c.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/useTableTotal-3d22365a.js"])) }, A = c(() => I[l.value]), T = c(() => U(basicinfoArray, _.value)), g = c(() => l.value === "collection"), j = c(() => l.value === "expend");
  return S(() => {
    C("component-mounted", true);
  }), V({ visible: r }), (ie, e) => {
    const B = $, v = J, R = Q, f = q("print-table"), h = W, z = X, N = Y, L = F("ellipsis");
    return t(), i(N, { modelValue: r.value, "onUpdate:modelValue": e[2] || (e[2] = (o) => r.value = o), "close-on-click-modal": false, "close-on-press-escape": false, "show-close": false, "destroy-on-close": "", size: "50%" }, { header: a(() => [n(u, { "type-one": false, "header-title": "资金项目台账" }), n(B, { plain: "", onClick: e[0] || (e[0] = (o) => r.value = false) }, { default: a(() => e[3] || (e[3] = [d("关闭")])), _: 1, __: [3] })]), default: a(() => [s("div", Z, [s("div", ee, [n(R, { modelValue: l.value, "onUpdate:modelValue": e[1] || (e[1] = (o) => l.value = o), class: "box-container", size: "default" }, { default: a(() => [n(v, { value: "collection" }, { default: a(() => e[4] || (e[4] = [d("收款及开票")])), _: 1, __: [4] }), n(v, { value: "expend" }, { default: a(() => e[5] || (e[5] = [d("累计支出")])), _: 1, __: [5] })]), _: 1 }, 8, ["modelValue"]), s("div", oe, [g.value ? (t(), i(f, { key: 0, params: y(_).project.id, "api-key": "selfCollectionAndInvoiceInfo", size: "default", type: "warning" }, null, 8, ["params"])) : x("", true), j.value ? (t(), i(f, { key: 1, params: y(_).project.id, "api-key": "selfTotalDisburse", size: "default", type: "warning" }, null, 8, ["params"])) : x("", true)])]), n(u, { "header-title": "基本信息" }), (t(), m("div", { key: E.value, class: "basic-info" }, [n(z, null, { default: a(() => [(t(true), m(G, null, H(T.value, (o) => (t(), i(h, { key: o.key, span: 12 }, { default: a(() => [s("div", te, [s("span", null, k(o.label), 1), K((t(), m("span", ae, [d(k(o.value), 1)])), [[L]])])]), _: 2 }, 1024))), 128))]), _: 1 })])), s("div", ne, [n(u, { "header-title": "收款及开票信息" })]), (t(), i(M(A.value), { class: "animate__animated animate__fadeIn animate__faster" }))])]), _: 1 }, 8, ["modelValue"]);
  };
} }, _e = P(se, [["__scopeId", "data-v-9cd6b652"]]);
export {
  _e as default
};
