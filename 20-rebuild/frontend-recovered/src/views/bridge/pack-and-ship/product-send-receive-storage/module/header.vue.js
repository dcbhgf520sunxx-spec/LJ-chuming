import { ref as p } from "vue";
import { watch as O } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as M } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as I } from "vue";
import { withDirectives as _ } from "vue";
import { vShow as B } from "vue";
import { unref as e } from "vue";
import { createElementVNode as D } from "vue";
import { createVNode as o } from "vue";
import { createBlock as P } from "vue";
import { withCtx as d } from "vue";
import { createCommentVNode as S } from "vue";
import { ElDatePicker as E } from "element-plus";
import { ElCol as j } from "element-plus";
import { ElRow as Q } from "element-plus";
import { vLoading as z } from "element-plus";
import { s as G } from "../../../../../modules/product-receive-send-storage-07e30ee6.js";
import { _ as U, bw as g, B as Y, D as i, aV as F, G as K, E as L } from "../../../../../shared/runtime.js";
import { P as f } from "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const N = { class: "head-container" }, R = { __name: "header", setup(q) {
  const y = { dateTime: void 0, projectId: void 0, productType: g.BOX.V, workShopId: void 0 }, { crud: l, query: t } = Y(y), a = p({}), c = p(false), h = p([g.BOX]);
  O(t, (r) => {
    r && V();
  }, { immediate: true, deep: true });
  async function V() {
    c.value = true;
    try {
      const r = await G(t);
      a.value = r, a.value.intoWeight = (a.value.intoWeight / 1e3).toFixed(i.COM_WT__T), a.value.outWeight = (a.value.outWeight / 1e3).toFixed(i.COM_WT__T), a.value.stockWeight = (a.value.stockWeight / 1e3).toFixed(i.COM_WT__T);
    } catch (r) {
      console.log("获取汇总数据", r);
    } finally {
      c.value = false;
    }
  }
  return (r, n) => {
    const C = E, T = m("project-radio-button"), w = m("common-radio-button"), u = j, b = Q, k = m("print-table"), x = z, W = M("permission");
    return v(), I("div", N, [_(D("div", null, [o(C, { modelValue: e(t).dateTime, "onUpdate:modelValue": n[0] || (n[0] = (s) => e(t).dateTime = s), type: "year", size: "default", class: "date-item filter-item", placeholder: "选择年", format: "YYYY", "value-format": "x", onChange: e(l).toQuery, style: { width: "120px" } }, null, 8, ["modelValue", "onChange"]), o(T, { size: "default", type: "all", modelValue: e(t).projectId, "onUpdate:modelValue": n[1] || (n[1] = (s) => e(t).projectId = s), class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), o(w, { modelValue: e(t).productType, "onUpdate:modelValue": n[2] || (n[2] = (s) => e(t).productType = s), options: h.value, type: "enum", size: "default", class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(e(F), { modelValue: e(t).workShopId, "onUpdate:modelValue": n[3] || (n[3] = (s) => e(t).workShopId = s), placeholder: "请选择车间", clearable: "", style: { width: "200px" }, class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), e(K)(e(l).permission.get) ? _((v(), P(b, { key: 0, gutter: 20, class: "panel-group" }, { default: d(() => [o(u, { span: 8, class: "card-panel-col" }, { default: d(() => [o(e(f), { name: "累计入库(t)", "text-color": "#626262", "num-color": "#1890ff", endVal: a.value.inboundMete / 1e3 || 0, precision: e(i).COM_WT__KG }, null, 8, ["endVal", "precision"])]), _: 1 }), o(u, { span: 8, class: "card-panel-col" }, { default: d(() => [o(e(f), { name: "累计出库(t)", "text-color": "#626262", "num-color": "#1890ff", endVal: a.value.outboundMete / 1e3 || 0, precision: e(i).COM_WT__KG }, null, 8, ["endVal", "precision"])]), _: 1 }), o(u, { span: 8, class: "card-panel-col" }, { default: d(() => [o(e(f), { name: "实时库存(t)", "text-color": "#626262", "num-color": "#1890ff", "end-val": a.value.stockMete / 1e3 || 0, precision: e(i).COM_WT__KG }, null, 8, ["end-val", "precision"])]), _: 1 })]), _: 1 })), [[x, c.value]]) : S("", true)], 512), [[B, e(l).searchToggle]]), o(e(L), null, { viewLeft: d(() => [_(o(k, { "api-key": "bridgeProductSendReceiveStorage", params: { ...e(t) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[W, e(l).permission.print]])]), _: 1 })]);
  };
} }, Z = U(R, [["__scopeId", "data-v-0d43709e"]]);
export {
  Z as default
};
