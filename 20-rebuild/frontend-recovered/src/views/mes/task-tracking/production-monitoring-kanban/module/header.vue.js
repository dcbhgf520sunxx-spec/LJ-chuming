import { inject as d } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as I } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as E } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { withDirectives as x } from "vue";
import { createBlock as N } from "vue";
import { withCtx as t } from "vue";
import { withKeys as R } from "vue";
import { withModifiers as f } from "vue";
import { createTextVNode as _ } from "vue";
import { renderSlot as j } from "vue";
import { ElCol as B } from "element-plus";
import { ElRow as U } from "element-plus";
import { ElInput as z } from "element-plus";
import { vLoading as K } from "element-plus";
import { B as L, aV as M, rR as O, E as W } from "../../../../../shared/runtime.js";
import u from "./panel.vue.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const q = { class: "head-container" }, P = { __name: "header", setup(D) {
  const s = d("projectInfo"), y = d("permission"), h = { workshopId: void 0 }, { crud: r, query: l } = L(h);
  function v() {
    r.toQuery();
  }
  function g() {
    l.status = void 0, l.name = void 0, r.toQuery();
  }
  return (w, n) => {
    const i = B, V = U, b = m("common-radio-button"), k = z, c = m("common-button"), C = I("permission"), Q = K;
    return p(), E("div", q, [o(M, { ref: "workshopInfRef", modelValue: e(l).workshopId, "onUpdate:modelValue": n[0] || (n[0] = (a) => e(l).workshopId = a), placeholder: "请选择车间", "factory-id": e(l).factoryId, style: { width: "200px" }, class: "filter-item", clearable: "", default: "", defaultValue: "", onChange: e(r).toQuery }, null, 8, ["modelValue", "factory-id", "onChange"]), x((p(), N(V, { gutter: 24, class: "panel-group" }, { default: t(() => [o(i, { span: 5, class: "card-panel-col" }, { default: t(() => [o(u, { name: "设计产能（吨）:", precision: 2, "num-color": "#1890ff", "end-val": e(s).summary.capacityNetWeight / 1e3 || 0 }, null, 8, ["end-val"])]), _: 1 }), o(i, { span: 6, class: "card-panel-col" }, { default: t(() => {
      var a;
      return [o(u, { name: "年度累计和平均（吨）:", "num-color": "#1890ff", "num-arr": (a = e(s).summary) == null ? void 0 : a.totalWeight, "is-array": "" }, null, 8, ["num-arr"])];
    }), _: 1 }), o(i, { span: 4, class: "card-panel-col" }, { default: t(() => {
      var a;
      return [o(u, { name: "当前在手订单（个）:", "num-color": "#1890ff", "end-val": ((a = e(s).summary) == null ? void 0 : a.orderQuantity) || 0 }, null, 8, ["end-val"])];
    }), _: 1 }), o(i, { span: 5, class: "card-panel-col" }, { default: t(() => [o(u, { name: "在手未完成量（吨）:", precision: 2, "num-color": "#1890ff", "end-val": e(s).summary.unNetWeight / 1e3 || 0 }, null, 8, ["end-val"])]), _: 1 }), o(i, { span: 4, class: "card-panel-col" }, { default: t(() => [o(u, { name: "产能空余率（%）:", precision: 2, "num-color": "#1890ff", "end-val": e(s).summary.capacityRatio || 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[C, e(y).statistics], [Q, e(s).loading]]), o(e(W), null, { optLeft: t(() => [o(b, { modelValue: e(l).status, "onUpdate:modelValue": n[1] || (n[1] = (a) => e(l).status = a), options: e(O).ENUM, class: "filter-item", showOptionAll: "", type: "enum", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(k, { modelValue: e(l).name, "onUpdate:modelValue": n[2] || (n[2] = (a) => e(l).name = a), modelModifiers: { trim: true }, placeholder: "输入项目搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: R(e(r).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(c, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: f(v, ["stop"]) }, { default: t(() => n[3] || (n[3] = [_("搜索")])), _: 1, __: [3] }), o(c, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: f(g, ["stop"]) }, { default: t(() => n[4] || (n[4] = [_(" 重置 ")])), _: 1, __: [4] })]), viewLeft: t(() => [j(w.$slots, "btn")]), _: 3 })]);
  };
} };
export {
  P as default
};
