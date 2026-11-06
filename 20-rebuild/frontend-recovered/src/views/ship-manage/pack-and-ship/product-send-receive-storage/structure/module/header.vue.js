import { ref as u } from "vue";
import T from "moment";
import { watch as O } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as R } from "vue";
import { openBlock as C } from "vue";
import { createElementBlock as P } from "vue";
import { withDirectives as y } from "vue";
import { vShow as I } from "vue";
import { unref as e } from "vue";
import { createElementVNode as L } from "vue";
import { createVNode as a } from "vue";
import { createBlock as Q } from "vue";
import { withCtx as d } from "vue";
import { createCommentVNode as $ } from "vue";
import { ElDatePicker as j } from "element-plus";
import { ElCol as q } from "element-plus";
import { ElRow as B } from "element-plus";
import { vLoading as M } from "element-plus";
import { s as K } from "../../../../../../modules/product-receive-send-storage-7de51d86.js";
import { _ as z, uk as h, bo as i, B as H, aV as A, G as Y, D as m, E as F } from "../../../../../../shared/runtime.js";
import { P as f } from "../../../../../../modules/index-5b9e6004.js";
import J from "./detail-drawer.vue.js";
import "../../../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../../../modules/ship-manage-3066b2ed.js";
const X = { class: "head-container" }, Z = { __name: "header", setup(ee) {
  const g = u(false), k = u([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), D = { productType: h.STRUCTURE.V, dateTimeList: [T().startOf("month").valueOf(), T().valueOf()], projectId: void 0, weightStatus: i.NET.V }, { crud: l, query: o } = H(D), s = u({}), v = u(false), w = u(), b = u([i.NET, i.GROSS]);
  O(o, (r) => {
    r && S();
  }, { immediate: true, deep: true });
  async function S() {
    v.value = true;
    try {
      const r = await K(o);
      s.value = r || {};
    } catch (r) {
      console.log("获取汇总数据", r);
    } finally {
      v.value = false;
    }
  }
  const p = (r) => {
    g.value = true, w.value = r;
  };
  return (r, t) => {
    const E = _("project-radio-button"), V = _("common-radio-button"), N = j, c = q, x = B, W = _("print-table"), U = M, G = R("permission");
    return C(), P("div", X, [y(L("div", null, [a(E, { size: "default", type: "all", modelValue: e(o).projectId, "onUpdate:modelValue": t[0] || (t[0] = (n) => e(o).projectId = n), class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), a(V, { modelValue: e(o).productType, "onUpdate:modelValue": t[1] || (t[1] = (n) => e(o).productType = n), options: e(h).ENUM, type: "enum", class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(V, { type: "enum", modelValue: e(o).weightStatus, "onUpdate:modelValue": t[2] || (t[2] = (n) => e(o).weightStatus = n), options: b.value, class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), a(N, { modelValue: e(o).dateTimeList, "onUpdate:modelValue": t[3] || (t[3] = (n) => e(o).dateTimeList = n), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始时间", "end-placeholder": "结束时间", "default-time": k.value, "value-format": "x", style: { width: "240px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "default-time", "onChange"]), a(A, { modelValue: e(o).workshopId, "onUpdate:modelValue": t[4] || (t[4] = (n) => e(o).workshopId = n), placeholder: "请选择车间", clearable: "", style: { width: "200px" }, class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), e(Y)(e(l).permission.get) ? y((C(), Q(x, { key: 0, gutter: 10, class: "panel-group" }, { default: d(() => [a(c, { span: 6, class: "card-panel-col", style: { cursor: "pointer" }, onClick: t[5] || (t[5] = (n) => p(1)) }, { default: d(() => [a(e(f), { name: "期初库存(kg)", "text-color": "#626262", "num-color": "#1890ff", "end-val": e(o).weightStatus === e(i).NET.V ? s.value.beginningNetWeight || 0 : s.value.beginningGrossWeight || 0, precision: e(m).COM_WT__KG }, null, 8, ["end-val", "precision"])]), _: 1 }), a(c, { span: 6, class: "card-panel-col", style: { cursor: "pointer" }, onClick: t[6] || (t[6] = (n) => p(2)) }, { default: d(() => [a(e(f), { name: "入库量(kg)", "text-color": "#626262", "num-color": "#1890ff", endVal: e(o).weightStatus === e(i).NET.V ? s.value.inboundNetWeight || 0 : s.value.inboundGrossWeight || 0, precision: e(m).COM_WT__KG }, null, 8, ["endVal", "precision"])]), _: 1 }), a(c, { span: 6, class: "card-panel-col", style: { cursor: "pointer" }, onClick: t[7] || (t[7] = (n) => p(3)) }, { default: d(() => [a(e(f), { name: "出库量(kg)", "text-color": "#626262", "num-color": "#1890ff", endVal: e(o).weightStatus === e(i).NET.V ? s.value.outboundNetWeight || 0 : s.value.outboundGrossWeight || 0, precision: e(m).COM_WT__KG }, null, 8, ["endVal", "precision"])]), _: 1 }), a(c, { span: 6, class: "card-panel-col", style: { cursor: "pointer" }, onClick: t[8] || (t[8] = (n) => p(4)) }, { default: d(() => [a(e(f), { name: "期末库存(kg)", "text-color": "#626262", "num-color": "#1890ff", "end-val": e(o).weightStatus === e(i).NET.V ? s.value.stockNetWeight || 0 : s.value.stockGrossWeight || 0, precision: e(m).COM_WT__KG }, null, 8, ["end-val", "precision"])]), _: 1 })]), _: 1 })), [[U, v.value]]) : $("", true)], 512), [[I, e(l).searchToggle]]), a(e(F), null, { viewLeft: d(() => [y(a(W, { "api-key": e(o).productType === e(h).STRUCTURE.V ? "mesProductSendReceiveStorage" : "mesDirectProductSendReceiveStorage", params: { ...e(o) }, size: "default", type: "warning" }, null, 8, ["api-key", "params"]), [[G, e(l).permission.print]])]), _: 1 }), a(e(J), { showDetailDrawer: g.value, "onUpdate:showDetailDrawer": t[9] || (t[9] = (n) => g.value = n), query: e(l).query, inventoryType: w.value }, null, 8, ["showDetailDrawer", "query", "inventoryType"])]);
  };
} }, ie = z(Z, [["__scopeId", "data-v-d11a8ca9"]]);
export {
  ie as default
};
