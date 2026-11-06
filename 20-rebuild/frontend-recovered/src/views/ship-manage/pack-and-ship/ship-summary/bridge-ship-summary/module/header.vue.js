import x from "moment";
import { ref as u } from "vue";
import { watch as I } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as D } from "vue";
import { withDirectives as h } from "vue";
import { vShow as N } from "vue";
import { unref as e } from "vue";
import { createElementVNode as P } from "vue";
import { createVNode as o } from "vue";
import { createBlock as B } from "vue";
import { withCtx as r } from "vue";
import { withKeys as O } from "vue";
import { ElDatePicker as Q } from "element-plus";
import { ElCol as U } from "element-plus";
import { ElRow as Y } from "element-plus";
import { ElInput as H } from "element-plus";
import { vLoading as L } from "element-plus";
import { s as j } from "../../../../../../modules/bridge-ship-summary-aa634ae7.js";
import { _ as q, bo as i, B as G, bU as m, fa as K, aV as R, D as $, C as z } from "../../../../../../shared/runtime.js";
import { P as y } from "../../../../../../modules/index-5b9e6004.js";
import "../../../../../../modules/vue3-count-to.esm-8987f38d.js";
const A = { class: "head-container" }, M = { __name: "header", setup(W) {
  const g = { dateTime: x().valueOf(), productionLineTypeEnum: void 0, workshopId: void 0, sendStatus: void 0, status: void 0, settled: void 0, projectName: void 0, weightStatus: i.NET.V }, { crud: l, query: t } = G(g), d = u({}), p = u(false), w = u([i.NET, i.GROSS]), v = u([m.SHIPPING, m.SHIPPED]);
  function V(n) {
    n === m.SETTLED.V ? (t.sendStatus = void 0, t.settled = 1) : (t.sendStatus = n, t.settled = void 0), l.toQuery();
  }
  I(() => t, (n) => {
    n && S();
  }, { immediate: true, deep: true });
  async function S() {
    try {
      p.value = true;
      const n = await j(t);
      d.value = n || {};
    } catch (n) {
      console.log("获取累计发运", n);
    } finally {
      p.value = false;
    }
  }
  return (n, a) => {
    const E = Q, c = b("common-radio-button"), f = U, T = Y, C = H, k = L;
    return _(), D("div", A, [h(P("div", null, [o(E, { modelValue: e(t).dateTime, "onUpdate:modelValue": a[0] || (a[0] = (s) => e(t).dateTime = s), type: "year", format: "YYYY", "value-format": "x", placeholder: "请选择", style: { width: "100px" }, class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), o(c, { modelValue: e(t).status, "onUpdate:modelValue": a[1] || (a[1] = (s) => e(t).status = s), options: v.value, showOptionAll: "", type: "enum", class: "filter-item", onChange: V }, null, 8, ["modelValue", "options"]), o(e(R), { modelValue: e(t).workshopId, "onUpdate:modelValue": a[2] || (a[2] = (s) => e(t).workshopId = s), placeholder: "请选择车间", "workshop-type": e(K).BRIDGE.V, clearable: "", style: { width: "200px" }, class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "workshop-type", "onChange"]), h((_(), B(T, { gutter: 20, class: "panel-group" }, { default: r(() => [o(f, { span: 12, class: "card-panel-col" }, { default: r(() => [o(e(y), { name: "累计发运量（t）", "text-color": "#626262", "num-color": "#1890ff", "end-val": d.value.mete / 1e3 || 0, precision: e($).COM_WT__T }, null, 8, ["end-val", "precision"])]), _: 1 }), o(f, { span: 12, class: "card-panel-col" }, { default: r(() => [o(e(y), { name: "累计车次/船次", "text-color": "#626262", "num-color": "#1890ff", "end-val": d.value.quantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[k, e(l).loading]]), o(c, { type: "enum", modelValue: e(t).weightStatus, "onUpdate:modelValue": a[3] || (a[3] = (s) => e(t).weightStatus = s), options: w.value, class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(C, { modelValue: e(t).projectName, "onUpdate:modelValue": a[4] || (a[4] = (s) => e(t).projectName = s), placeholder: "项目搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: O(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(e(z))], 512), [[N, e(l).searchToggle]])]);
  };
} }, te = q(M, [["__scopeId", "data-v-73d3e235"]]);
export {
  te as default
};
