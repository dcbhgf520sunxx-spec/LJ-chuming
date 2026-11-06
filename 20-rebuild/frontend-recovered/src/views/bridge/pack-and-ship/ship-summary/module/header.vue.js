import C from "moment";
import { ref as c } from "vue";
import { watch as k } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as T } from "vue";
import { withDirectives as p } from "vue";
import { vShow as b } from "vue";
import { unref as e } from "vue";
import { createElementVNode as S } from "vue";
import { createVNode as o } from "vue";
import { createBlock as D } from "vue";
import { withCtx as r } from "vue";
import { ElDatePicker as B } from "element-plus";
import { ElCol as I } from "element-plus";
import { ElRow as U } from "element-plus";
import { vLoading as Y } from "element-plus";
import { s as L } from "../../../../../modules/ship-summary-9143cc4e.js";
import { _ as P, B as Q, bU as _, aV as q, D as N } from "../../../../../shared/runtime.js";
import { P as f } from "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const O = { class: "head-container" }, H = { __name: "header", setup(M) {
  const h = { dateTime: C().valueOf(), productionLineTypeEnum: void 0, workshopId: void 0, sendStatus: void 0, status: void 0, settled: void 0 }, { crud: s, query: a } = Q(h), d = c({}), u = c(false);
  function v(t) {
    t === _.SETTLED.V ? (a.sendStatus = void 0, a.settled = 1) : (a.sendStatus = t, a.settled = void 0), s.toQuery();
  }
  k(() => a, (t) => {
    t && y();
  }, { immediate: true, deep: true });
  async function y() {
    try {
      u.value = true;
      const t = await L(a);
      d.value = t || {};
    } catch (t) {
      console.log("获取累计发运", t);
    } finally {
      u.value = false;
    }
  }
  return (t, n) => {
    const g = B, w = E("common-radio-button"), i = I, V = U, x = Y;
    return m(), T("div", O, [p(S("div", null, [o(g, { modelValue: e(a).dateTime, "onUpdate:modelValue": n[0] || (n[0] = (l) => e(a).dateTime = l), type: "year", format: "YYYY", "value-format": "x", placeholder: "请选择", style: { width: "100px" }, class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), o(w, { modelValue: e(a).status, "onUpdate:modelValue": n[1] || (n[1] = (l) => e(a).status = l), options: e(_).ENUM, showOptionAll: "", type: "enum", class: "filter-item", onChange: v }, null, 8, ["modelValue", "options"]), o(e(q), { modelValue: e(a).workshopId, "onUpdate:modelValue": n[2] || (n[2] = (l) => e(a).workshopId = l), placeholder: "请选择车间", clearable: "", style: { width: "200px" }, class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), p((m(), D(V, { gutter: 20, class: "panel-group" }, { default: r(() => [o(i, { span: 12, class: "card-panel-col" }, { default: r(() => [o(e(f), { name: "累计发运量（t）", "text-color": "#626262", "num-color": "#1890ff", "end-val": d.value.mete / 1e3 || 0, precision: e(N).COM_WT__T }, null, 8, ["end-val", "precision"])]), _: 1 }), o(i, { span: 12, class: "card-panel-col" }, { default: r(() => [o(e(f), { name: "累计车次/船次", "text-color": "#626262", "num-color": "#1890ff", "end-val": d.value.quantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[x, e(s).loading]])], 512), [[b, e(s).searchToggle]])]);
  };
} }, z = P(H, [["__scopeId", "data-v-03044841"]]);
export {
  z as default
};
