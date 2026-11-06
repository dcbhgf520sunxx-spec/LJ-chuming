import B from "moment";
import { ref as p } from "vue";
import { watch as I } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as P } from "vue";
import { openBlock as T } from "vue";
import { createElementBlock as M } from "vue";
import { withDirectives as h } from "vue";
import { vShow as U } from "vue";
import { unref as e } from "vue";
import { createElementVNode as Q } from "vue";
import { createVNode as n } from "vue";
import { createBlock as R } from "vue";
import { withCtx as d } from "vue";
import { createCommentVNode as $ } from "vue";
import { ElDatePicker as j } from "element-plus";
import { ElCol as q } from "element-plus";
import { ElRow as Y } from "element-plus";
import { vLoading as z } from "element-plus";
import { s as K } from "../../../../../../modules/box-product-receive-send-storage-9ef20b12.js";
import { _ as L, ui as w, bo as u, B as H, fa as X, aV as A, G as F, D as f, E as J } from "../../../../../../shared/runtime.js";
import { P as g } from "../../../../../../modules/index-5b9e6004.js";
import Z from "./detail-drawer.vue.js";
import "../../../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../../../modules/ship-manage-3066b2ed.js";
const ee = { class: "head-container" }, oe = { __name: "header", setup(te) {
  const C = B().valueOf(), b = { productType: w.BOX.V, dateTime: C, projectId: void 0, weightStatus: u.NET.V }, { crud: s, query: a } = H(b), r = p({}), _ = p(false), v = p(false), V = p(), D = p([u.NET, u.GROSS]);
  I(a, (i) => {
    i && E();
  }, { immediate: true, deep: true });
  async function E() {
    _.value = true;
    try {
      const i = await K(a);
      r.value = i;
    } catch (i) {
      console.log("获取汇总数据", i);
    } finally {
      _.value = false;
    }
  }
  const c = (i) => {
    v.value = true, V.value = i, console.log(i);
  };
  return (i, t) => {
    const S = j, x = y("project-radio-button"), k = y("common-radio-button"), m = q, N = Y, W = y("print-table"), G = z, O = P("permission");
    return T(), M("div", ee, [h(Q("div", null, [n(S, { modelValue: e(a).dateTime, "onUpdate:modelValue": t[0] || (t[0] = (o) => e(a).dateTime = o), type: "month", size: "default", class: "date-item filter-item", placeholder: "选择月", format: "YYYY-MM", "value-format": "x", onChange: e(s).toQuery, style: { width: "120px" } }, null, 8, ["modelValue", "onChange"]), n(x, { size: "default", modelValue: e(a).projectId, "onUpdate:modelValue": t[1] || (t[1] = (o) => e(a).projectId = o), class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "onChange"]), n(k, { modelValue: e(a).productType, "onUpdate:modelValue": t[2] || (t[2] = (o) => e(a).productType = o), options: e(w).ENUM, type: "enum", class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(e(A), { modelValue: e(a).workshopId, "onUpdate:modelValue": t[3] || (t[3] = (o) => e(a).workshopId = o), "workshop-type": e(X).BRIDGE.V, placeholder: "请选择车间", clearable: "", size: "default", style: { width: "200px" }, class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "workshop-type", "onChange"]), n(k, { type: "enum", modelValue: e(a).weightStatus, "onUpdate:modelValue": t[4] || (t[4] = (o) => e(a).weightStatus = o), options: D.value, class: "filter-item", onChange: e(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]), e(F)(e(s).permission.get) ? h((T(), R(N, { key: 0, gutter: 24, class: "panel-group" }, { default: d(() => [n(m, { span: 6, class: "card-panel-col", style: { cursor: "pointer" }, onClick: t[5] || (t[5] = (o) => c(1)) }, { default: d(() => {
      var o, l;
      return [n(e(g), { name: "期初库存(kg)", "text-color": "#626262", "num-color": "#1890ff", "end-val": e(a).weightStatus === e(u).NET.V ? ((o = r.value) == null ? void 0 : o.beginningNetWeight) || 0 : ((l = r.value) == null ? void 0 : l.beginningGrossWeight) || 0, precision: e(f).COM_WT__KG }, null, 8, ["end-val", "precision"])];
    }), _: 1 }), n(m, { span: 6, class: "card-panel-col", style: { cursor: "pointer" }, onClick: t[6] || (t[6] = (o) => c(2)) }, { default: d(() => {
      var o, l;
      return [n(e(g), { name: "入库量(kg)", "text-color": "#626262", "num-color": "#1890ff", endVal: e(a).weightStatus === e(u).NET.V ? ((o = r.value) == null ? void 0 : o.inboundNetWeight) || 0 : ((l = r.value) == null ? void 0 : l.inboundGrossWeight) || 0, precision: e(f).COM_WT__KG }, null, 8, ["endVal", "precision"])];
    }), _: 1 }), n(m, { span: 6, class: "card-panel-col", style: { cursor: "pointer" }, onClick: t[7] || (t[7] = (o) => c(3)) }, { default: d(() => {
      var o, l;
      return [n(e(g), { name: "出库量(kg)", "text-color": "#626262", "num-color": "#1890ff", endVal: e(a).weightStatus === e(u).NET.V ? ((o = r.value) == null ? void 0 : o.outboundNetWeight) || 0 : ((l = r.value) == null ? void 0 : l.outboundGrossWeight) || 0, precision: e(f).COM_WT__KG }, null, 8, ["endVal", "precision"])];
    }), _: 1 }), n(m, { span: 6, class: "card-panel-col", style: { cursor: "pointer" }, onClick: t[8] || (t[8] = (o) => c(4)) }, { default: d(() => {
      var o, l;
      return [n(e(g), { name: "期末库存(kg)", "text-color": "#626262", "num-color": "#1890ff", "end-val": e(a).weightStatus === e(u).NET.V ? ((o = r.value) == null ? void 0 : o.stockNetWeight) || 0 : ((l = r.value) == null ? void 0 : l.stockGrossWeight) || 0, precision: e(f).COM_WT__KG }, null, 8, ["end-val", "precision"])];
    }), _: 1 })]), _: 1 })), [[G, _.value]]) : $("", true)], 512), [[U, e(s).searchToggle]]), n(e(J), null, { viewLeft: d(() => [h(n(W, { "api-key": e(a).productType === e(w).BOX.V ? "boxProductSendReceiveStorage" : "boxProductSendReceiveStorageDirect", params: { ...e(a) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"]), [[O, e(s).permission.print]])]), _: 1 }), n(e(Z), { showDetailDrawer: v.value, "onUpdate:showDetailDrawer": t[9] || (t[9] = (o) => v.value = o), query: e(s).query, inventoryType: V.value }, null, 8, ["showDetailDrawer", "query", "inventoryType"])]);
  };
} }, de = L(oe, [["__scopeId", "data-v-5a2f437d"]]);
export {
  de as default
};
