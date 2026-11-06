import { inject as g } from "vue";
import { watch as h } from "vue";
import { nextTick as k } from "vue";
import y from "moment";
import { resolveComponent as x } from "vue";
import { resolveDirective as _ } from "vue";
import { openBlock as I } from "vue";
import { createElementBlock as K } from "vue";
import { withDirectives as r } from "vue";
import { vShow as N } from "vue";
import { unref as e } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as n } from "vue";
import { withKeys as d } from "vue";
import { withCtx as p } from "vue";
import { createTextVNode as v } from "vue";
import { ElInput as j } from "element-plus";
import { ElTag as C } from "element-plus";
import { I as E, kM as O, B as z, C as B, E as P } from "../../../../../../shared/runtime.js";
const Q = { class: "head-container" }, q = { __name: "header", setup(R) {
  var c;
  const T = g("commonParams");
  h(T, (o = {}) => {
    k(() => {
      for (const t in o) l.query[t] = o[t];
      l.toQuery();
    });
  }, { immediate: true, deep: true });
  const m = (c = E[1]) == null ? void 0 : c.value(), V = { startDate: y(m[0]).valueOf(), endDate: y(m[1]).valueOf(), serialNumber: void 0, specification: void 0, material: void 0, productType: O.ARTIFACT.V, projectId: { value: void 0, resetAble: false } }, { crud: l, query: a } = z(V);
  return (o, t) => {
    const i = j, w = C, b = x("print-table"), f = _("parse-time"), D = _("permission");
    return I(), K("div", Q, [r(u("div", null, [n(i, { modelValue: e(a).serialNumber, "onUpdate:modelValue": t[0] || (t[0] = (s) => e(a).serialNumber = s), placeholder: "可输入编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: d(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(i, { modelValue: e(a).specification, "onUpdate:modelValue": t[1] || (t[1] = (s) => e(a).specification = s), placeholder: "可输入规格搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: d(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(i, { modelValue: e(a).material, "onUpdate:modelValue": t[2] || (t[2] = (s) => e(a).material = s), placeholder: "输入材质搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: d(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(B))], 512), [[N, e(l).searchToggle]]), n(e(P), null, { optRight: p(() => [n(w, { size: "large", effect: "plain" }, { default: p(() => [t[3] || (t[3] = v(" 统计日期： ")), r(u("span", null, null, 512), [[f, { val: e(a).startDate, fmt: "{y}-{m}-{d}" }]]), t[4] || (t[4] = v(" ~ ")), r(u("span", null, null, 512), [[f, { val: e(a).endDate, fmt: "{y}-{m}-{d}" }]])]), _: 1, __: [3, 4] })]), viewLeft: p(() => [r(n(b, { "api-key": "contractBoxShipmentTracking", params: e(a), size: "default", type: "warning" }, null, 8, ["params"]), [[D, e(l).permission.print]])]), _: 1 })]);
  };
} };
export {
  q as default
};
