import { inject as s } from "vue";
import { ref as y } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as A } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as B } from "vue";
import { withDirectives as c } from "vue";
import { vShow as P } from "vue";
import { unref as e } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as r } from "vue";
import { renderSlot as h } from "vue";
import { withCtx as d } from "vue";
import { createBlock as v } from "vue";
import { createTextVNode as R } from "vue";
import { Fragment as $ } from "vue";
import { ElDatePicker as z } from "element-plus";
import { Loading as K } from "@element-plus/icons-vue";
import { ElIcon as M } from "element-plus";
import { ElTag as N } from "element-plus";
import { B as H, G as F, c as C, D, q as G, I as W, C as J, E as X } from "../../../../../shared/runtime.js";
import { _ as Y } from "../../../../../modules/index-b238c21c.js";
import { _ as Z } from "../../../../../modules/factory-select-b8d0a4ac.js";
const re = { __name: "report-header", props: { printKey: { type: String, default: "" } }, setup(I) {
  const V = I, S = s("defaultQuery"), T = { date: [], startDate: void 0, endDate: void 0, factoryId: void 0, monomerId: void 0 }, { crud: l, query: t, CRUD: b } = H(Object.assign(T, S)), i = s("permission"), j = s("productType");
  function k() {
    t.date && t.date.length > 1 ? (t.startDate = t.date[0], t.endDate = t.date[1]) : (t.startDate = void 0, t.endDate = void 0), l.toQuery();
  }
  b.HOOK.afterToQuery = () => {
    O();
  };
  const p = y({}), u = y(false), Q = s("getSummaryApi");
  async function O() {
    if (F(i.get)) try {
      u.value = true;
      const a = await Q(t);
      a.totalArea = C(a.totalArea, "mm²", "㎡", D.COM_AREA__M2), a.totalLength = C(a.totalLength, "mm", "m", D.COM_L__M), p.value = a;
    } catch (a) {
      console.log("获取汇总信息", a);
    } finally {
      u.value = false;
    }
  }
  return (a, o) => {
    const w = _("project-radio-button"), E = z, L = _("print-table"), U = K, q = M, x = N, f = A("permission");
    return m(), B($, null, [c(g("div", null, [r(w, { size: "default", modelValue: e(t).projectId, "onUpdate:modelValue": o[0] || (o[0] = (n) => e(t).projectId = n), type: "all", class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), r(e(G), { modelValue: e(t).monomerId, "onUpdate:modelValue": o[1] || (o[1] = (n) => e(t).monomerId = n), clearable: "", "project-id": e(t).projectId, disabled: !e(t).projectId, default: false, class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "project-id", "disabled", "onChange"]), r(e(Z), { modelValue: e(t).factoryId, "onUpdate:modelValue": o[2] || (o[2] = (n) => e(t).factoryId = n), clearable: "", class: "filter-item", style: { width: "200px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), r(E, { modelValue: e(t).date, "onUpdate:modelValue": o[3] || (o[3] = (n) => e(t).date = n), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, clearable: "", shortcuts: e(W), "value-format": "x", onChange: k }, null, 8, ["modelValue", "shortcuts"]), g("div", null, [h(a.$slots, "customSearch", { query: e(t) }), r(e(Y), { productType: e(j), category: e(t).category, toQuery: e(l).toQuery, query: e(t) }, null, 8, ["productType", "category", "toQuery", "query"]), r(e(J))])], 512), [[P, e(l).searchToggle]]), r(e(X), null, { optLeft: d(() => [c(r(L, { "api-key": V.printKey, params: { ...e(t) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"]), [[f, e(i).print]])]), viewLeft: d(() => [c((m(), v(x, { effect: "plain", class: "filter-item", size: "large" }, { default: d(() => [o[4] || (o[4] = R(" 累计生产量： ")), u.value ? (m(), v(q, { key: 1 }, { default: d(() => [r(U)]), _: 1 })) : h(a.$slots, "summaryText", { key: 0, summary: p.value })]), _: 3, __: [4] })), [[f, e(i).get]])]), _: 3 })], 64);
  };
} };
export {
  re as default
};
