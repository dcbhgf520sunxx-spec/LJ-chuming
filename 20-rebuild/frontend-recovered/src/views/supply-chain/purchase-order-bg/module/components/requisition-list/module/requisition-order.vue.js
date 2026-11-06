import { inject as U } from "vue";
import { ref as m } from "vue";
import b from "moment";
import { resolveComponent as C } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as R } from "vue";
import { createElementVNode as I } from "vue";
import { createVNode as l } from "vue";
import { unref as s } from "vue";
import { withDirectives as L } from "vue";
import { createBlock as h } from "vue";
import { withCtx as f } from "vue";
import { createCommentVNode as q } from "vue";
import { createTextVNode as D } from "vue";
import { toDisplayString as O } from "vue";
import { nextTick as j } from "vue";
import { ElDatePicker as z } from "element-plus";
import { ElTableColumn as A } from "element-plus";
import { ElTag as M } from "element-plus";
import { vLoading as P } from "element-plus";
import { j_ as Q, vd as V, ux as Y, vK as $, i as y, b as k } from "../../../../../../../shared/runtime.js";
const w = { class: "head-container" }, J = { __name: "requisition-order", setup(F, { expose: x }) {
  var v;
  const o = (v = U("cu")) == null ? void 0 : v.form, g = m(), _ = m(false), r = m([]), u = m({ times: [b().startOf("month").valueOf(), b().valueOf()], purchaseCreationState: void 0 });
  async function c() {
    r.value = [];
    try {
      _.value = true;
      const { content: i } = await $({ filterUseInventory: true, materialType: o.materialType, ...u.value }), e = [];
      r.value = i.map((t, n) => (y(o.requisitionsKV[t.id]) && e.push(n), t)), j(() => {
        e.forEach((t) => {
          var n;
          (n = g.value) == null || n.toggleRowSelection(r.value[t], void 0);
        });
      });
    } catch (i) {
      console.log(i, "获取申购单列表失败");
    } finally {
      _.value = false;
    }
  }
  function E(i, e) {
    const t = i.findIndex((n) => n.id === e.id) !== -1;
    t && k(o.requisitionsKV[e.id]) && (o.requisitionsKV[e.id] = e), !t && y(o.requisitionsKV[e.id]) && delete o.requisitionsKV[e.id];
  }
  function K(i) {
    const e = !!(i != null && i.length);
    r.value.forEach((t) => {
      e && k(o.requisitionsKV[t.id]) && (o.requisitionsKV[t.id] = t), !e && y(o.requisitionsKV[t.id]) && delete o.requisitionsKV[t.id];
    });
  }
  return x({ fetchList: c }), (i, e) => {
    const t = z, n = C("common-radio-button"), d = A, T = M, B = C("common-table"), N = P;
    return p(), R("div", null, [I("div", w, [l(t, { modelValue: u.value.times, "onUpdate:modelValue": e[0] || (e[0] = (a) => u.value.times = a), type: "daterange", "range-separator": ":", size: "default", class: "date-item filter-item", "value-format": "x", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "374px" }, onChange: c }, null, 8, ["modelValue"]), l(n, { class: "filter-item", modelValue: s(o).materialType, "onUpdate:modelValue": e[1] || (e[1] = (a) => s(o).materialType = a), options: s(Q).ENUM, type: "enum", size: "default", onChange: c }, null, 8, ["modelValue", "options"]), l(n, { class: "filter-item", modelValue: u.value.purchaseCreationState, "onUpdate:modelValue": e[2] || (e[2] = (a) => u.value.purchaseCreationState = a), options: s(V).ENUM, "show-option-all": "", type: "enum", size: "default", onChange: c }, null, 8, ["modelValue", "options"])]), L((p(), h(B, { ref_key: "tableRef", ref: g, data: r.value, style: { width: "100%" }, onSelect: E, onSelectAll: K }, { default: f(() => [l(d, { type: "selection", width: "55", align: "center", class: "selection" }), l(d, { label: "序号", type: "index", align: "center", width: "55" }), l(d, { label: "申购单号", prop: "serialNumber", align: "center" }, { default: f(({ row: { sourceRow: a } }) => [a != null && a.id ? (p(), h(s(Y), { key: 0, "receipt-types": ["REQUISITIONS"], receipt: a }, null, 8, ["receipt"])) : q("", true)]), _: 1 }), l(d, { label: "状态", prop: "purchaseCreationState", align: "center", width: "90" }, { default: f(({ row: a }) => {
      var S;
      return [a.purchaseCreationState ? (p(), h(T, { key: 0, effect: "plain", type: (S = s(V).V[a.purchaseCreationState]) == null ? void 0 : S.T }, { default: f(() => [D(O(s(V).VL[a.purchaseCreationState]), 1)]), _: 2 }, 1032, ["type"])) : q("", true)];
    }), _: 1 })]), _: 1 }, 8, ["data"])), [[N, _.value]])]);
  };
} };
export {
  J as default
};
