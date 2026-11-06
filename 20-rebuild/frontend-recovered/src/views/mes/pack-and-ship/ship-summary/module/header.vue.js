import x from "moment";
import { ref as u } from "vue";
import { watch as k } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as N } from "vue";
import { withDirectives as h } from "vue";
import { vShow as P } from "vue";
import { unref as e } from "vue";
import { createElementVNode as D } from "vue";
import { createVNode as o } from "vue";
import { createBlock as O } from "vue";
import { withCtx as r } from "vue";
import { withKeys as Q } from "vue";
import { ElDatePicker as U } from "element-plus";
import { ElCol as B } from "element-plus";
import { ElRow as Y } from "element-plus";
import { ElInput as H } from "element-plus";
import { vLoading as L } from "element-plus";
import { s as j } from "../../../../../modules/ship-summary-06293e56.js";
import { _ as q, bo as i, B as K, bU as m, aV as G, D as R, C as $ } from "../../../../../shared/runtime.js";
import { P as y } from "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const z = { class: "head-container" }, A = { __name: "header", setup(M) {
  const g = { dateTime: x().valueOf(), productionLineTypeEnum: void 0, workshopId: void 0, sendStatus: void 0, status: void 0, settled: void 0, projectName: void 0, weightStatus: i.NET.V }, { crud: s, query: t } = K(g), d = u({}), c = u(false), v = u([m.SHIPPING, m.SHIPPED]), w = u([i.NET, i.GROSS]);
  function V(n) {
    n === m.SETTLED.V ? (t.sendStatus = void 0, t.settled = 1) : (t.sendStatus = n, t.settled = void 0), s.toQuery();
  }
  k(() => t, (n) => {
    n && S();
  }, { immediate: true, deep: true });
  async function S() {
    try {
      c.value = true;
      const n = await j(t);
      d.value = n || {};
    } catch (n) {
      console.log("获取累计发运", n);
    } finally {
      c.value = false;
    }
  }
  return (n, a) => {
    const C = U, p = I("common-radio-button"), f = B, E = Y, T = H, b = L;
    return _(), N("div", z, [h(D("div", null, [o(C, { modelValue: e(t).dateTime, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(t).dateTime = l), type: "year", format: "YYYY", "value-format": "x", placeholder: "请选择", style: { width: "100px" }, class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), o(p, { modelValue: e(t).status, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(t).status = l), options: v.value, showOptionAll: "", type: "enum", class: "filter-item", onChange: V }, null, 8, ["modelValue", "options"]), o(G, { modelValue: e(t).workshopId, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(t).workshopId = l), placeholder: "请选择车间", clearable: "", style: { width: "200px" }, class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), h((_(), O(E, { gutter: 20, class: "panel-group" }, { default: r(() => [o(f, { span: 12, class: "card-panel-col" }, { default: r(() => [o(e(y), { name: "累计发运量（t）", "text-color": "#626262", "num-color": "#1890ff", "end-val": d.value.mete / 1e3 || 0, precision: e(R).COM_WT__T }, null, 8, ["end-val", "precision"])]), _: 1 }), o(f, { span: 12, class: "card-panel-col" }, { default: r(() => [o(e(y), { name: "累计车次/船次", "text-color": "#626262", "num-color": "#1890ff", "end-val": d.value.quantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[b, e(s).loading]]), o(p, { type: "enum", modelValue: e(t).weightStatus, "onUpdate:modelValue": a[3] || (a[3] = (l) => e(t).weightStatus = l), options: w.value, class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(T, { modelValue: e(t).projectName, "onUpdate:modelValue": a[4] || (a[4] = (l) => e(t).projectName = l), placeholder: "项目搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: Q(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(e($))], 512), [[P, e(s).searchToggle]])]);
  };
} }, ee = q(A, [["__scopeId", "data-v-18c97d3b"]]);
export {
  ee as default
};
