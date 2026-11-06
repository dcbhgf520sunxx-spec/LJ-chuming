import x from "moment";
import { ref as _ } from "vue";
import { watch as W } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as O } from "vue";
import { withDirectives as f } from "vue";
import { vShow as D } from "vue";
import { unref as e } from "vue";
import { createElementVNode as I } from "vue";
import { createVNode as a } from "vue";
import { createBlock as M } from "vue";
import { withCtx as u } from "vue";
import { createCommentVNode as P } from "vue";
import { ElDatePicker as R } from "element-plus";
import { ElCol as U } from "element-plus";
import { ElRow as j } from "element-plus";
import { vLoading as B } from "element-plus";
import { s as Q } from "../../../../../modules/product-receive-send-storage-ba88d0e7.js";
import { _ as Y, bi as K, bo as r, B as z, aV as L, G as q, D as d, E as H } from "../../../../../shared/runtime.js";
import { P as m } from "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const A = { class: "head-container" }, $ = { __name: "header", setup(F) {
  const v = x().valueOf(), V = { productType: K.STRUCTURE.V, dateTime: v, projectId: void 0, weightStatus: r.NET.V }, { crud: l, query: t } = z(V), o = _({}), p = _(false), y = _([r.NET, r.GROSS]);
  W(t, (i) => {
    i && w();
  }, { immediate: true, deep: true });
  async function w() {
    p.value = true;
    try {
      const i = await Q(t);
      o.value = i;
    } catch (i) {
      console.log("获取汇总数据", i);
    } finally {
      p.value = false;
    }
  }
  return (i, n) => {
    const T = R, b = g("project-radio-button"), k = g("common-radio-button"), c = U, C = j, E = g("print-table"), S = B, N = G("permission");
    return h(), O("div", A, [f(I("div", null, [a(T, { modelValue: e(t).dateTime, "onUpdate:modelValue": n[0] || (n[0] = (s) => e(t).dateTime = s), type: "month", size: "default", class: "date-item filter-item", placeholder: "选择月", format: "YYYY-MM", "value-format": "x", onChange: e(l).toQuery, style: { width: "120px" } }, null, 8, ["modelValue", "onChange"]), a(b, { size: "default", type: "all", modelValue: e(t).projectId, "onUpdate:modelValue": n[1] || (n[1] = (s) => e(t).projectId = s), class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), a(L, { modelValue: e(t).workshopId, "onUpdate:modelValue": n[2] || (n[2] = (s) => e(t).workshopId = s), placeholder: "请选择车间", clearable: "", style: { width: "200px" }, class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), a(k, { type: "enum", modelValue: e(t).weightStatus, "onUpdate:modelValue": n[3] || (n[3] = (s) => e(t).weightStatus = s), options: y.value, class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), e(q)(e(l).permission.get) ? f((h(), M(C, { key: 0, gutter: 24, class: "panel-group" }, { default: u(() => [a(c, { span: 6, class: "card-panel-col" }, { default: u(() => [a(e(m), { name: "期初库存(kg)", "text-color": "#626262", "num-color": "#1890ff", "end-val": e(t).weightStatus === e(r).NET.V ? o.value.beginningNetWeight || 0 : o.value.beginningGrossWeight || 0, precision: e(d).COM_WT__KG }, null, 8, ["end-val", "precision"])]), _: 1 }), a(c, { span: 6, class: "card-panel-col" }, { default: u(() => [a(e(m), { name: "入库量(kg)", "text-color": "#626262", "num-color": "#1890ff", endVal: e(t).weightStatus === e(r).NET.V ? o.value.inboundNetWeight || 0 : o.value.inboundGrossWeight || 0, precision: e(d).COM_WT__KG }, null, 8, ["endVal", "precision"])]), _: 1 }), a(c, { span: 6, class: "card-panel-col" }, { default: u(() => [a(e(m), { name: "出库量(kg)", "text-color": "#626262", "num-color": "#1890ff", endVal: e(t).weightStatus === e(r).NET.V ? o.value.outboundNetWeight || 0 : o.value.outboundGrossWeight || 0, precision: e(d).COM_WT__KG }, null, 8, ["endVal", "precision"])]), _: 1 }), a(c, { span: 6, class: "card-panel-col" }, { default: u(() => [a(e(m), { name: "期末库存(kg)", "text-color": "#626262", "num-color": "#1890ff", "end-val": e(t).weightStatus === e(r).NET.V ? o.value.stockNetWeight || 0 : o.value.stockGrossWeight || 0, precision: e(d).COM_WT__KG }, null, 8, ["end-val", "precision"])]), _: 1 })]), _: 1 })), [[S, p.value]]) : P("", true)], 512), [[D, e(l).searchToggle]]), a(e(H), null, { viewLeft: u(() => [f(a(E, { "api-key": "mesProductSendReceiveStorage", params: { ...e(t) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[N, e(l).permission.print]])]), _: 1 })]);
  };
} }, ae = Y($, [["__scopeId", "data-v-91aa1a20"]]);
export {
  ae as default
};
