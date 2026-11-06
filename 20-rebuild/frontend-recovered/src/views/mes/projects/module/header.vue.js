import { inject as T } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as N } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as S } from "vue";
import { withDirectives as r } from "vue";
import { unref as e } from "vue";
import { createBlock as b } from "vue";
import { withCtx as n } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as h } from "vue";
import { vShow as w } from "vue";
import { ElCol as C } from "element-plus";
import { ElRow as R } from "element-plus";
import { ElInput as V } from "element-plus";
import { vLoading as j } from "element-plus";
import { _ as B, p as I, K as d, mv as c, B as x, C as D, E as L } from "../../../../shared/runtime.js";
import { P as o } from "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const P = { __name: "header", setup(Q) {
  const t = T("projectInfo"), _ = { noOrName: void 0, year: I(/* @__PURE__ */ new Date(), "{y}"), projectType: d.STEEL.V, lumpSumSystemType: c.NEED_FACTORY_PROCESSING_NO_CONTROL.V | c.NEED_FACTORY_PROCESSING_NEED_CONTROL.V | c.OTHER.V }, { crud: l, query: p } = x(_);
  return (k, m) => {
    const s = C, f = R, y = V, v = g("print-table"), E = j, i = N("permission");
    return u(), S("div", null, [r((u(), b(f, { gutter: 20, class: "panel-group" }, { default: n(() => [a(s, { span: 6, class: "card-panel-col" }, { default: n(() => [a(e(o), { name: "全部项目", "num-color": "#1890ff", "end-val": e(t).summary.quantity || 0 }, null, 8, ["end-val"])]), _: 1 }), a(s, { span: 6, class: "card-panel-col" }, { default: n(() => [a(e(o), { name: "进行中", "num-color": "#1890ff", "end-val": e(t).summary.processingQuantity || 0 }, null, 8, ["end-val"])]), _: 1 }), a(s, { span: 6, class: "card-panel-col" }, { default: n(() => [a(e(o), { name: "完工", "num-color": "#1890ff", "end-val": e(t).summary.completedQuantity || 0 }, null, 8, ["end-val"])]), _: 1 }), a(s, { span: 6, class: "card-panel-col" }, { default: n(() => [a(e(o), { name: "本月新增", "num-color": "#1890ff", "end-val": e(t).summary.newItemsThisMonthQuantity || 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[E, e(t).loading], [i, e(l).permission.statistics]]), a(e(L), null, { optRight: n(() => [r(h("div", null, [a(y, { modelValue: e(p).noOrName, "onUpdate:modelValue": m[0] || (m[0] = (O) => e(p).noOrName = O), size: "default", placeholder: "输入合同编号或项目简称", style: { width: "200px" }, class: "filter-item", clearable: "", onBlur: e(l).toQuery }, null, 8, ["modelValue", "onBlur"]), a(e(D))], 512), [[w, e(l).searchToggle]])]), viewLeft: n(() => [r(a(v, { "api-key": "myProject", params: { year: e(l).query.year, status: e(l).query.status, noName: e(l).query.noOrName, projectType: e(d).STEEL.V, lumpSumSystemType: e(l).query.lumpSumSystemType }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[i, e(l).permission.print]])]), _: 1 })]);
  };
} }, F = B(P, [["__scopeId", "data-v-a87db97b"]]);
export {
  F as default
};
