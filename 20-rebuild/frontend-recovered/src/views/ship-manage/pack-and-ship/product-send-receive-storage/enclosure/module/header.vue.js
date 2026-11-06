import Y from "moment";
import { ref as i } from "vue";
import { watch as V } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as G } from "vue";
import { withDirectives as w } from "vue";
import { vShow as H } from "vue";
import { unref as e } from "vue";
import { createElementVNode as F } from "vue";
import { createVNode as l } from "vue";
import { createBlock as S } from "vue";
import { createCommentVNode as k } from "vue";
import { withCtx as u } from "vue";
import { ElDatePicker as W } from "element-plus";
import { ElCol as J } from "element-plus";
import { ElRow as K } from "element-plus";
import { vLoading as X } from "element-plus";
import { s as Z } from "../../../../../../modules/enclosure-product-receive-send-storage-2e87d697.js";
import { _ as ee, m as oe, mx as te, T as d, B as ae, mt as ne, uc as le, fa as re, aV as se, G as ie, D as v, E as ue } from "../../../../../../shared/runtime.js";
import { P as E } from "../../../../../../modules/index-5b9e6004.js";
import ce from "./detail-drawer.vue.js";
import "../../../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../../../modules/ship-manage-3066b2ed.js";
const de = { class: "head-container" }, pe = { __name: "header", props: { permission: { type: Object, default: () => {
} } }, setup(T) {
  const I = T, U = Y().valueOf(), p = i([]), g = i(false), D = i(), { globalProjectId: b } = oe(["globalProjectId"]), { projects: O } = te(), N = [{ name: "压型彩板", no: d.PROFILED_PLATE.V, alias: "ENCLOSURE" }, { name: "压型楼承板", no: d.PRESSURE_BEARING_PLATE.V, alias: "ENCLOSURE" }, { name: "桁架楼承板", no: d.TRUSS_FLOOR_PLATE.V, alias: "ENCLOSURE" }, { name: "夹芯板", no: d.SANDWICH_BOARD.V, alias: "ENCLOSURE" }, { name: "折边件", no: d.BENDING.V, alias: "ENCLOSURE" }], j = { dateTime: U, projectId: void 0, category: void 0, dictionaryId: void 0 }, { crud: r, query: a } = ae(j), c = i({}), C = i(false), x = i({ key: "id", value: "id", label: "label" }), { enclosureDictList: P } = ne();
  V(() => b.value, (n) => {
    n && R(n);
  }, { immediate: true }), V(a, (n) => {
    n && M();
  }, { immediate: true, deep: true }), V(() => a.projectId, (n) => {
    n && R(n);
  }, { immediate: true });
  async function M() {
    var n;
    if (C.value = true, !!((n = I.permission) != null && n.get)) try {
      const o = await Z({ ...a, productType: le.ENCLOSURE.V });
      c.value = o;
    } catch (o) {
      console.log("获取汇总数据", o);
    } finally {
      C.value = false;
    }
  }
  function R(n) {
    var f;
    p.value = [];
    const o = (f = O.value.find((s) => s.id === n)) == null ? void 0 : f.categorys;
    N.forEach((s) => {
      (o == null ? void 0 : o.findIndex((L) => L === s.no)) > -1 && p.value.push(s);
    });
  }
  function A(n) {
    var o;
    a.category = (o = p.value[0]) == null ? void 0 : o.no, r.toQuery();
  }
  const m = (n) => {
    g.value = true, D.value = n, console.log(n);
  };
  return (n, o) => {
    const f = h("project-radio-button"), s = h("common-radio-button"), L = W, y = J, B = K, Q = h("print-table"), $ = X, q = z("permission");
    return _(), G("div", de, [w(F("div", null, [l(f, { modelValue: e(a).projectId, "onUpdate:modelValue": o[0] || (o[0] = (t) => e(a).projectId = t), type: "all", class: "filter-item", size: "default", onChange: A }, null, 8, ["modelValue"]), e(a).projectId ? (_(), S(s, { key: 0, modelValue: e(a).category, "onUpdate:modelValue": o[1] || (o[1] = (t) => e(a).category = t), "data-structure": { key: "no", label: "name", value: "no" }, options: p.value, class: "filter-item", default: "", placeholder: "请选择围护类型", type: "other", onChange: e(r).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : k("", true), e(a).projectId ? k("", true) : (_(), S(s, { key: 1, modelValue: e(a).dictionaryId, "onUpdate:modelValue": o[2] || (o[2] = (t) => e(a).dictionaryId = t), "data-structure": x.value, options: e(P), class: "filter-item", size: "default", type: "other", onChange: e(r).toQuery }, null, 8, ["modelValue", "data-structure", "options", "onChange"])), l(L, { modelValue: e(a).dateTime, "onUpdate:modelValue": o[3] || (o[3] = (t) => e(a).dateTime = t), class: "date-item filter-item", format: "YYYY-MM", placeholder: "选择月", size: "default", style: { width: "120px" }, type: "month", "value-format": "x", onChange: e(r).toQuery }, null, 8, ["modelValue", "onChange"]), l(se, { modelValue: e(a).workshopId, "onUpdate:modelValue": o[4] || (o[4] = (t) => e(a).workshopId = t), "workshop-type": e(re).ENCLOSURE.V, class: "filter-item", clearable: "", placeholder: "请选择车间", style: { width: "200px" }, onChange: e(r).toQuery }, null, 8, ["modelValue", "workshop-type", "onChange"]), e(ie)(e(r).permission.get) ? w((_(), S(B, { key: 2, gutter: 10, class: "panel-group" }, { default: u(() => [l(y, { span: 6, class: "card-panel-col", style: { cursor: "pointer" }, onClick: o[5] || (o[5] = (t) => m(1)) }, { default: u(() => {
      var t;
      return [l(e(E), { "end-val": ((t = c.value) == null ? void 0 : t.beginningTotalLength) || 0, precision: e(v).MES_ENCLOSURE_L__M, name: "期初库存(米)", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val", "precision"])];
    }), _: 1 }), l(y, { span: 6, class: "card-panel-col", style: { cursor: "pointer" }, onClick: o[6] || (o[6] = (t) => m(2)) }, { default: u(() => {
      var t;
      return [l(e(E), { endVal: ((t = c.value) == null ? void 0 : t.inboundTotalLength) || 0, precision: e(v).MES_ENCLOSURE_L__M, name: "入库量(米)", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["endVal", "precision"])];
    }), _: 1 }), l(y, { span: 6, class: "card-panel-col", style: { cursor: "pointer" }, onClick: o[7] || (o[7] = (t) => m(3)) }, { default: u(() => {
      var t;
      return [l(e(E), { endVal: ((t = c.value) == null ? void 0 : t.outboundTotalLength) || 0, precision: e(v).MES_ENCLOSURE_L__M, name: "出库量(米)", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["endVal", "precision"])];
    }), _: 1 }), l(y, { span: 6, class: "card-panel-col", style: { cursor: "pointer" }, onClick: o[8] || (o[8] = (t) => m(4)) }, { default: u(() => {
      var t;
      return [l(e(E), { "end-val": ((t = c.value) == null ? void 0 : t.stockTotalLength) || 0, precision: e(v).MES_ENCLOSURE_L__M, name: "期末库存(米)", "num-color": "#1890ff", "text-color": "#626262" }, null, 8, ["end-val", "precision"])];
    }), _: 1 })]), _: 1 })), [[$, C.value]]) : k("", true)], 512), [[H, e(r).searchToggle]]), l(e(ue), null, { viewLeft: u(() => [w(l(Q, { params: { ...e(a) }, "api-key": "enclosureProductSendReceiveStorage", size: "default", type: "warning" }, null, 8, ["params"]), [[q, T.permission.print]])]), _: 1 }), l(e(ce), { showDetailDrawer: g.value, "onUpdate:showDetailDrawer": o[9] || (o[9] = (t) => g.value = t), inventoryType: D.value, query: e(r).query }, null, 8, ["showDetailDrawer", "inventoryType", "query"])]);
  };
} }, Ce = ee(pe, [["__scopeId", "data-v-84e2fe82"]]);
export {
  Ce as default
};
