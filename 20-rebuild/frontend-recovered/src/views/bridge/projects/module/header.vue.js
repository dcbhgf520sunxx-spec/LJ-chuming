import { inject as b } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as w } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as B } from "vue";
import { withDirectives as r } from "vue";
import { unref as e } from "vue";
import { createBlock as E } from "vue";
import { withCtx as n } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as j } from "vue";
import { vShow as I } from "vue";
import { ElCol as V } from "element-plus";
import { ElRow as x } from "element-plus";
import { ElInput as T } from "element-plus";
import { vLoading as D } from "element-plus";
import { _ as N, p as Q, K as m, B as R, C as k, E as q } from "../../../../shared/runtime.js";
import { P as s } from "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const C = { __name: "header", setup(O) {
  const t = b("projectInfo"), d = { noOrName: void 0, year: Q(/* @__PURE__ */ new Date(), "{y}"), projectType: m.BRIDGE.V }, { crud: l, query: c } = R(d);
  return (P, i) => {
    const o = V, _ = x, f = T, y = h("print-table"), v = D, p = w("permission");
    return u(), B("div", null, [r((u(), E(_, { gutter: 20, class: "panel-group" }, { default: n(() => [a(o, { span: 6, class: "card-panel-col" }, { default: n(() => [a(e(s), { name: "全部项目", "num-color": "#1890ff", "end-val": e(t).summary.quantity || 0 }, null, 8, ["end-val"])]), _: 1 }), a(o, { span: 6, class: "card-panel-col" }, { default: n(() => [a(e(s), { name: "进行中", "num-color": "#1890ff", "end-val": e(t).summary.processingQuantity || 0 }, null, 8, ["end-val"])]), _: 1 }), a(o, { span: 6, class: "card-panel-col" }, { default: n(() => [a(e(s), { name: "完工", "num-color": "#1890ff", "end-val": e(t).summary.completedQuantity || 0 }, null, 8, ["end-val"])]), _: 1 }), a(o, { span: 6, class: "card-panel-col" }, { default: n(() => [a(e(s), { name: "本月新增", "num-color": "#1890ff", "end-val": e(t).summary.newItemsThisMonthQuantity || 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[v, e(t).loading], [p, e(l).permission.statistics]]), a(e(q), null, { optRight: n(() => [r(j("div", null, [a(f, { modelValue: e(c).noOrName, "onUpdate:modelValue": i[0] || (i[0] = (g) => e(c).noOrName = g), size: "default", placeholder: "输入合同编号或项目简称", style: { width: "200px" }, class: "filter-item", clearable: "", onBlur: e(l).toQuery }, null, 8, ["modelValue", "onBlur"]), a(e(k))], 512), [[I, e(l).searchToggle]])]), viewLeft: n(() => [r(a(y, { "api-key": "myProject", params: { year: e(l).query.year, status: e(l).query.status, noName: e(l).query.noOrName, projectType: e(m).BRIDGE.V }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[p, e(l).permission.print]])]), _: 1 })]);
  };
} }, K = N(C, [["__scopeId", "data-v-bf5a6b8b"]]);
export {
  K as default
};
