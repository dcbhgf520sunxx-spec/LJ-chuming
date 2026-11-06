import { ref as N } from "vue";
import { watch as T } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as V } from "vue";
import { withDirectives as _ } from "vue";
import { vShow as w } from "vue";
import { unref as e } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as o } from "vue";
import { createBlock as E } from "vue";
import { withCtx as r } from "vue";
import { createCommentVNode as Q } from "vue";
import { ElDatePicker as b } from "element-plus";
import { ElCol as S } from "element-plus";
import { ElRow as k } from "element-plus";
import { vLoading as D } from "element-plus";
import { _ as O, B as j, c2 as B, c4 as M, C as P, G as U, D as d, E as q } from "../../../../shared/runtime.js";
import { p as G } from "../../../../modules/production-order-334bd558.js";
import { P as i } from "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const Y = { class: "head-container" }, A = { __name: "header", setup(K) {
  const g = { status: void 0, year: (/* @__PURE__ */ new Date()).getTime(), month: void 0 }, { crud: a, query: n } = j(g), l = N({});
  T(() => a.query, (t) => {
    h();
  }, { deep: true, immediate: true });
  async function h() {
    l.value = {};
    try {
      const t = await G(a.query);
      t.projectQuantityWeight = t.projectQuantityWeight ? t.projectQuantityWeight / 1e3 : 0, t.schedulingTotalNetWeight = t.schedulingTotalNetWeight ? t.schedulingTotalNetWeight / 1e3 : 0, t.unSchedulingTotalNetWeight = t.unSchedulingTotalNetWeight ? t.unSchedulingTotalNetWeight / 1e3 : 0, l.value = t || {};
    } catch (t) {
      console.log("获取生产订单汇总失败", t);
    }
  }
  return (t, s) => {
    const f = m("common-radio-button"), v = b, y = m("common-select"), u = S, W = k, C = D;
    return p(), V("div", Y, [_(x("div", null, [o(f, { modelValue: e(n).status, "onUpdate:modelValue": s[0] || (s[0] = (c) => e(n).status = c), options: e(B).ENUM, showOptionAll: "", optionAllValue: void 0, type: "enum", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(v, { modelValue: e(n).year, "onUpdate:modelValue": s[1] || (s[1] = (c) => e(n).year = c), type: "year", format: "YYYY", class: "filter-item", "value-format": "x", placeholder: "请选择", onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"]), o(y, { modelValue: e(n).month, "onUpdate:modelValue": s[2] || (s[2] = (c) => e(n).month = c), options: e(M).ENUM, clearable: "", type: "enum", size: "default", placeholder: "请选择", class: "filter-item", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(e(P)), e(U)(e(a).permission.get) ? _((p(), E(W, { key: 0, gutter: 20, class: "panel-group" }, { default: r(() => [o(u, { span: 6, class: "card-panel-col" }, { default: r(() => [o(e(i), { name: "项目总数（个）", "text-color": "#626262", "num-color": "#1890ff", "end-val": l.value.projectQuantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), o(u, { span: 6, class: "card-panel-col" }, { default: r(() => [o(e(i), { name: "项目总量（t）", "text-color": "#626262", "num-color": "#1890ff", "end-val": l.value.projectQuantityWeight || 0, precision: e(d).COM_WT__KG }, null, 8, ["end-val", "precision"])]), _: 1 }), o(u, { span: 6, class: "card-panel-col" }, { default: r(() => [o(e(i), { name: "已排期（t）", "text-color": "#626262", "num-color": "#1890ff", "end-val": l.value.schedulingTotalNetWeight || 0, precision: e(d).COM_WT__KG }, null, 8, ["end-val", "precision"])]), _: 1 }), o(u, { span: 6, class: "card-panel-col" }, { default: r(() => [o(e(i), { name: "未排期（t）", "text-color": "#626262", "num-color": "#f56c6c", "end-val": l.value.unSchedulingTotalNetWeight || 0, precision: e(d).COM_WT__KG }, null, 8, ["end-val", "precision"])]), _: 1 })]), _: 1 })), [[C, e(a).loading]]) : Q("", true)], 512), [[w, e(a).searchToggle]]), o(e(q))]);
  };
} }, $ = O(A, [["__scopeId", "data-v-35b0fa5c"]]);
export {
  $ as default
};
