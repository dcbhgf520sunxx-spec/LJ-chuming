import N from "moment";
import { ref as d } from "vue";
import { watch as P } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as U } from "vue";
import { withDirectives as h } from "vue";
import { vShow as D } from "vue";
import { unref as e } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as n } from "vue";
import { createBlock as O } from "vue";
import { withCtx as r } from "vue";
import { withKeys as Q } from "vue";
import { ElDatePicker as B } from "element-plus";
import { ElCol as j } from "element-plus";
import { ElRow as Y } from "element-plus";
import { ElInput as q } from "element-plus";
import { vLoading as H } from "element-plus";
import { d as L } from "../../../../../../modules/ship-summary-d5d4a58f.js";
import { _ as K, bo as i, B as z, bU as m, aV as G, uq as M, D as R, C as $ } from "../../../../../../shared/runtime.js";
import { P as v } from "../../../../../../modules/index-5b9e6004.js";
import "../../../../../../modules/vue3-count-to.esm-8987f38d.js";
const A = { class: "head-container" }, W = { __name: "header", setup(F) {
  const w = { dateTime: N().valueOf(), sendStatus: void 0, productionLineTypeEnum: void 0, workshopId: void 0, status: void 0, settled: void 0, projectName: void 0, weightStatus: i.NET.V }, { crud: s, query: t } = z(w), V = d([m.SHIPPING, m.SHIPPED]), S = d([i.NET, i.GROSS]), u = d({}), p = d(false);
  function C(l) {
    l === m.SETTLED.V ? (t.sendStatus = void 0, t.settled = 1) : (t.sendStatus = l, t.settled = void 0), s.toQuery();
  }
  P(() => t, (l) => {
    l && E();
  }, { immediate: true, deep: true });
  async function E() {
    try {
      p.value = true;
      const l = await L(t);
      u.value = l || {};
    } catch (l) {
      console.log("获取累计发运", l);
    } finally {
      p.value = false;
    }
  }
  return (l, o) => {
    const b = B, c = _("common-radio-button"), x = _("common-select"), f = j, T = Y, k = q, I = H;
    return y(), U("div", A, [h(g("div", null, [n(b, { modelValue: e(t).dateTime, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(t).dateTime = a), type: "year", format: "YYYY", "value-format": "x", placeholder: "请选择", style: { width: "100px" }, class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), n(c, { modelValue: e(t).status, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(t).status = a), options: V.value, showOptionAll: "", type: "enum", class: "filter-item", onChange: C }, null, 8, ["modelValue", "options"]), n(G, { modelValue: e(t).workshopId, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(t).workshopId = a), placeholder: "请选择车间", clearable: "", style: { width: "47%" }, class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), n(x, { modelValue: e(t).projectStatus, "onUpdate:modelValue": o[3] || (o[3] = (a) => e(t).projectStatus = a), options: e(M).ENUM, type: "enum", size: "default", class: "filter-item", style: { width: "49%" }, clearable: "", placeholder: "选择项目状态", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), h((y(), O(T, { gutter: 20, class: "panel-group" }, { default: r(() => [n(f, { span: 12, class: "card-panel-col" }, { default: r(() => [n(e(v), { name: "累计发运量（t）", "text-color": "#626262", "num-color": "#1890ff", "end-val": u.value.mete / 1e3 || 0, precision: e(R).COM_WT__T }, null, 8, ["end-val", "precision"])]), _: 1 }), n(f, { span: 12, class: "card-panel-col" }, { default: r(() => [n(e(v), { name: "累计车次/船次", "text-color": "#626262", "num-color": "#1890ff", "end-val": u.value.quantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[I, e(s).loading]]), o[6] || (o[6] = g("div", { style: { "border-bottom": "1px solid #ededed", width: "100%", margin: "15px 0px" } }, null, -1)), n(c, { type: "enum", modelValue: e(t).weightStatus, "onUpdate:modelValue": o[4] || (o[4] = (a) => e(t).weightStatus = a), options: S.value, class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(k, { modelValue: e(t).projectName, "onUpdate:modelValue": o[5] || (o[5] = (a) => e(t).projectName = a), placeholder: "项目搜索", class: "filter-item", style: { width: "calc(100% - 202px)" }, size: "default", clearable: "", onKeyup: Q(e(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e($), { resetBtn: false })], 512), [[D, e(s).searchToggle]])]);
  };
} }, oe = K(W, [["__scopeId", "data-v-2066d6ea"]]);
export {
  oe as default
};
