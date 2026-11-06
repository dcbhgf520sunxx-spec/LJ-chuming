import { inject as h } from "vue";
import { watch as k } from "vue";
import { nextTick as I } from "vue";
import f from "moment";
import { resolveComponent as x } from "vue";
import { resolveDirective as _ } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as j } from "vue";
import { withDirectives as o } from "vue";
import { vShow as E } from "vue";
import { unref as e } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as s } from "vue";
import { withKeys as y } from "vue";
import { withCtx as p } from "vue";
import { createTextVNode as v } from "vue";
import { ElInput as K } from "element-plus";
import { ElTag as O } from "element-plus";
import { I as C, kM as P, B as R, C as S, E as z } from "../../../../../../shared/runtime.js";
const A = { class: "head-container" }, U = { __name: "header", setup(B) {
  var d;
  const T = h("commonParams");
  k(T, (l = {}) => {
    I(() => {
      for (const t in l) n.query[t] = l[t];
      n.toQuery();
    });
  }, { immediate: true, deep: true });
  const u = (d = C[1]) == null ? void 0 : d.value(), w = { startDate: f(u[0]).valueOf(), endDate: f(u[1]).valueOf(), name: void 0, specification: void 0, productType: P.AUXILIARY.V, projectId: { value: void 0, resetAble: false } }, { crud: n, query: a } = R(w);
  return (l, t) => {
    const c = K, D = O, V = x("print-table"), m = _("parse-time"), g = _("permission");
    return b(), j("div", A, [o(i("div", null, [s(c, { modelValue: e(a).name, "onUpdate:modelValue": t[0] || (t[0] = (r) => e(a).name = r), placeholder: "可输入名称搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: y(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(c, { modelValue: e(a).specification, "onUpdate:modelValue": t[1] || (t[1] = (r) => e(a).specification = r), placeholder: "可输入规格搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: y(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(e(S))], 512), [[E, e(n).searchToggle]]), s(e(z), null, { optRight: p(() => [s(D, { size: "large", effect: "plain" }, { default: p(() => [t[2] || (t[2] = v(" 统计日期： ")), o(i("span", null, null, 512), [[m, { val: e(a).startDate, fmt: "{y}-{m}-{d}" }]]), t[3] || (t[3] = v(" ~ ")), o(i("span", null, null, 512), [[m, { val: e(a).endDate, fmt: "{y}-{m}-{d}" }]])]), _: 1, __: [2, 3] })]), viewLeft: p(() => [o(s(V, { "api-key": "contractAuxiliaryMaterialShipmentTracking", params: e(a), size: "default", type: "warning" }, null, 8, ["params"]), [[g, e(n).permission.print]])]), _: 1 })]);
  };
} };
export {
  U as default
};
