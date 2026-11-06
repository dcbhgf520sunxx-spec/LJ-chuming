import { inject as k } from "vue";
import { watch as w } from "vue";
import { nextTick as b } from "vue";
import m from "moment";
import { resolveComponent as g } from "vue";
import { resolveDirective as f } from "vue";
import { openBlock as x } from "vue";
import { createElementBlock as I } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { withCtx as o } from "vue";
import { createTextVNode as _ } from "vue";
import { withDirectives as c } from "vue";
import { ElInput as j } from "element-plus";
import { ElTag as C } from "element-plus";
import { I as E, kM as O, B as z, C as N, E as P } from "../../../../../../shared/runtime.js";
const R = { class: "head-container" }, q = { __name: "header", setup(S) {
  var d;
  const y = k("commonParams");
  w(y, (n = {}) => {
    b(() => {
      for (const t in n) r.query[t] = n[t];
      r.toQuery();
    });
  }, { immediate: true, deep: true });
  const p = (d = E[1]) == null ? void 0 : d.value(), v = { startDate: m(p[0]).valueOf(), endDate: m(p[1]).valueOf(), serialNumber: void 0, specification: void 0, material: void 0, productType: O.ARTIFACT.V, projectId: { value: void 0, resetAble: false } }, { crud: r, query: s } = z(v);
  return (n, t) => {
    const i = j, h = C, T = g("print-table"), u = f("parse-time"), D = f("permission");
    return x(), I("div", R, [l("div", null, [a(i, { placeholder: "可输入编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "" }), a(i, { placeholder: "可输入规格搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "" }), a(i, { placeholder: "输入材质搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "" }), a(e(N))]), a(e(P), null, { optRight: o(() => [a(h, { size: "large", effect: "plain" }, { default: o(() => [t[0] || (t[0] = _(" 统计日期： ")), c(l("span", null, null, 512), [[u, { val: e(s).startDate, fmt: "{y}-{m}-{d}" }]]), t[1] || (t[1] = _(" ~ ")), c(l("span", null, null, 512), [[u, { val: e(s).endDate, fmt: "{y}-{m}-{d}" }]])]), _: 1, __: [0, 1] })]), viewLeft: o(() => [c(a(T, { "api-key": "StraighthairShipmentTracking", params: e(s), size: "default", type: "warning" }, null, 8, ["params"]), [[D, e(r).permission.print]])]), _: 1 })]);
  };
} };
export {
  q as default
};
