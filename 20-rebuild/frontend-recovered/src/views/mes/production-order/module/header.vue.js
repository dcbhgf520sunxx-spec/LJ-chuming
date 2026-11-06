import { ref as W } from "vue";
import { watch as N } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as T } from "vue";
import { withDirectives as _ } from "vue";
import { vShow as w } from "vue";
import { unref as e } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as o } from "vue";
import { createBlock as Q } from "vue";
import { withCtx as c } from "vue";
import { createCommentVNode as b } from "vue";
import { ElDatePicker as j } from "element-plus";
import { ElCol as E } from "element-plus";
import { ElRow as S } from "element-plus";
import { vLoading as k } from "element-plus";
import { _ as D, B as O, c2 as P, bb as U, c4 as B, C as M, G as q, D as d, E as G } from "../../../../shared/runtime.js";
import { p as I } from "../../../../modules/production-order-028b54f6.js";
import { P as i } from "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const Y = { class: "head-container" }, A = { __name: "header", setup(K) {
  const g = { status: void 0, year: (/* @__PURE__ */ new Date()).getTime(), projectId: void 0, month: void 0 }, { crud: a, query: n } = O(g), r = W({});
  N(() => a.query, (t) => {
    h();
  }, { deep: true, immediate: true });
  async function h() {
    r.value = {};
    try {
      const t = await I(a.query);
      t.projectQuantityWeight = t.projectQuantityWeight ? t.projectQuantityWeight / 1e3 : 0, t.schedulingTotalNetWeight = t.schedulingTotalNetWeight ? t.schedulingTotalNetWeight / 1e3 : 0, t.unSchedulingTotalNetWeight = t.unSchedulingTotalNetWeight ? t.unSchedulingTotalNetWeight / 1e3 : 0, r.value = t || {};
    } catch (t) {
      console.log("获取生产订单汇总失败", t);
    }
  }
  return (t, l) => {
    const f = m("common-radio-button"), v = j, y = m("common-select"), u = E, C = S, V = k;
    return p(), T("div", Y, [_(x("div", null, [o(f, { modelValue: e(n).status, "onUpdate:modelValue": l[0] || (l[0] = (s) => e(n).status = s), optionAllValue: void 0, options: e(P).ENUM, class: "filter-item", showOptionAll: "", type: "enum", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(v, { modelValue: e(n).year, "onUpdate:modelValue": l[1] || (l[1] = (s) => e(n).year = s), class: "filter-item", format: "YYYY", placeholder: "请选择", type: "year", "value-format": "x", onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"]), o(e(U), { class: "filter-item", modelValue: e(n).projectId, "onUpdate:modelValue": l[2] || (l[2] = (s) => e(n).projectId = s), onChange: e(a).toQuery, clearable: "" }, null, 8, ["modelValue", "onChange"]), o(y, { modelValue: e(n).month, "onUpdate:modelValue": l[3] || (l[3] = (s) => e(n).month = s), options: e(B).ENUM, clearable: "", type: "enum", size: "default", placeholder: "请选择", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(e(M)), e(q)(e(a).permission.get) ? _((p(), Q(C, { key: 0, gutter: 20, class: "panel-group" }, { default: c(() => [o(u, { span: 6, class: "card-panel-col" }, { default: c(() => [o(e(i), { name: "项目总数（个）", "text-color": "#626262", "num-color": "#1890ff", "end-val": r.value.projectQuantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), o(u, { span: 6, class: "card-panel-col" }, { default: c(() => [o(e(i), { name: "项目总量（t）", "text-color": "#626262", "num-color": "#1890ff", "end-val": r.value.projectQuantityWeight || 0, precision: e(d).COM_WT__KG }, null, 8, ["end-val", "precision"])]), _: 1 }), o(u, { span: 6, class: "card-panel-col" }, { default: c(() => [o(e(i), { name: "已排期（t）", "text-color": "#626262", "num-color": "#1890ff", "end-val": r.value.schedulingTotalNetWeight || 0, precision: e(d).COM_WT__KG }, null, 8, ["end-val", "precision"])]), _: 1 }), o(u, { span: 6, class: "card-panel-col" }, { default: c(() => [o(e(i), { name: "未排期（t）", "text-color": "#626262", "num-color": "#f56c6c", "end-val": r.value.unSchedulingTotalNetWeight || 0, precision: e(d).COM_WT__KG }, null, 8, ["end-val", "precision"])]), _: 1 })]), _: 1 })), [[V, e(a).loading]]) : b("", true)], 512), [[w, e(a).searchToggle]]), o(e(G))]);
  };
} }, F = D(A, [["__scopeId", "data-v-01e1c6a4"]]);
export {
  F as default
};
