import { inject as D } from "vue";
import { watch as K } from "vue";
import { nextTick as g } from "vue";
import y from "moment";
import { resolveComponent as h } from "vue";
import { resolveDirective as _ } from "vue";
import { openBlock as k } from "vue";
import { createElementBlock as x } from "vue";
import { withDirectives as r } from "vue";
import { vShow as E } from "vue";
import { unref as e } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as n } from "vue";
import { withKeys as u } from "vue";
import { withCtx as p } from "vue";
import { createTextVNode as v } from "vue";
import { ElInput as I } from "element-plus";
import { ElTag as O } from "element-plus";
import { I as j, kM as z, B as C, C as Q, E as S } from "../../../../../../shared/runtime.js";
const U = { class: "head-container" }, q = { __name: "header", setup(P) {
  var c;
  const V = D("commonParams");
  K(V, (i = {}) => {
    g(() => {
      for (const t in i) l.query[t] = i[t];
      l.toQuery();
    });
  }, { immediate: true, deep: true });
  const m = (c = j[1]) == null ? void 0 : c.value(), w = { startDate: y(m[0]).valueOf(), endDate: y(m[1]).valueOf(), planName: void 0, name: void 0, plate: void 0, serialNumber: void 0, productType: z.ENCLOSURE.V, projectId: { value: void 0, resetAble: false } }, { crud: l, query: a } = C(w);
  return (i, t) => {
    const o = I, T = O, b = h("print-table"), f = _("parse-time"), N = _("permission");
    return k(), x("div", U, [r(d("div", null, [n(o, { modelValue: e(a).planName, "onUpdate:modelValue": t[0] || (t[0] = (s) => e(a).planName = s), placeholder: "可输入批次搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: u(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(o, { modelValue: e(a).name, "onUpdate:modelValue": t[1] || (t[1] = (s) => e(a).name = s), placeholder: "可输入名称搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: u(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(o, { modelValue: e(a).serialNumber, "onUpdate:modelValue": t[2] || (t[2] = (s) => e(a).serialNumber = s), placeholder: "可输入编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: u(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(o, { modelValue: e(a).plate, "onUpdate:modelValue": t[3] || (t[3] = (s) => e(a).plate = s), placeholder: "可输入板型搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: u(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(Q))], 512), [[E, e(l).searchToggle]]), n(e(S), null, { optRight: p(() => [n(T, { size: "large", effect: "plain" }, { default: p(() => [t[4] || (t[4] = v(" 统计日期： ")), r(d("span", null, null, 512), [[f, { val: e(a).startDate, fmt: "{y}-{m}-{d}" }]]), t[5] || (t[5] = v(" ~ ")), r(d("span", null, null, 512), [[f, { val: e(a).endDate, fmt: "{y}-{m}-{d}" }]])]), _: 1, __: [4, 5] })]), viewLeft: p(() => [r(n(b, { "api-key": "contractEnclosureShipmentTracking", params: e(a), size: "default", type: "warning" }, null, 8, ["params"]), [[N, e(l).permission.print]])]), _: 1 })]);
  };
} };
export {
  q as default
};
