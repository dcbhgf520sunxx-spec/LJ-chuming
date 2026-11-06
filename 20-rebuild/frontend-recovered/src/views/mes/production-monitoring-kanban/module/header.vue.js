import { inject as c } from "vue";
import { resolveDirective as h } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { createElementVNode as g } from "vue";
import { withDirectives as w } from "vue";
import { createBlock as k } from "vue";
import { withCtx as o } from "vue";
import { ElCol as I } from "element-plus";
import { ElRow as V } from "element-plus";
import { vLoading as N } from "element-plus";
import { B, aV as b } from "../../../../shared/runtime.js";
import { P as s } from "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const x = { class: "head-container" }, q = { __name: "header", setup(C) {
  const l = c("projectInfo"), i = c("permission"), m = { workshopId: void 0 }, { crud: u, query: t } = B(m);
  return (W, r) => {
    const n = I, p = V, f = h("permission"), _ = N;
    return d(), y("div", x, [a(e(b), { ref: "workshopInfRef", modelValue: e(t).workshopId, "onUpdate:modelValue": r[0] || (r[0] = (v) => e(t).workshopId = v), placeholder: "请选择车间", "factory-id": e(t).factoryId, style: { width: "200px" }, class: "filter-item", clearable: "", default: "", defaultValue: "", onChange: e(u).toQuery }, null, 8, ["modelValue", "factory-id", "onChange"]), g("div", null, [w((d(), k(p, { gutter: 24, class: "panel-group" }, { default: o(() => [a(n, { span: 5, class: "card-panel-col" }, { default: o(() => [a(e(s), { name: "设计产能（吨）:", decimals: 2, "num-color": "#1890ff", "end-val": e(l).summary.capacityNetWeight / 1e3 || 0 }, null, 8, ["end-val"])]), _: 1 }), a(n, { span: 5, class: "card-panel-col" }, { default: o(() => [a(e(s), { name: "平均产量（吨/年）:", decimals: 2, "num-color": "#1890ff", "end-val": e(l).summary.yearNetWeight / 1e3 || 0 }, null, 8, ["end-val"])]), _: 1 }), a(n, { span: 4, class: "card-panel-col" }, { default: o(() => [a(e(s), { name: "上月产量（吨）:", decimals: 2, "num-color": "#1890ff", "end-val": e(l).summary.lastMonthNetWeight / 1e3 || 0 }, null, 8, ["end-val"])]), _: 1 }), a(n, { span: 5, class: "card-panel-col" }, { default: o(() => [a(e(s), { name: "在手订单数（个）:", decimals: 2, "num-color": "#1890ff", "end-val": e(l).summary.orderQuantity || 0 }, null, 8, ["end-val"])]), _: 1 }), a(n, { span: 5, class: "card-panel-col" }, { default: o(() => [a(e(s), { name: "未完成量（吨）:", decimals: 2, "num-color": "#1890ff", "end-val": e(l).summary.unNetWeight / 1e3 || 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[f, e(i).statistics], [_, e(l).loading]])])]);
  };
} };
export {
  q as default
};
