import { inject as I } from "vue";
import { ref as p } from "vue";
import C from "moment";
import { computed as R } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as A } from "vue";
import { createElementVNode as j } from "vue";
import { createVNode as r } from "vue";
import { unref as u } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as v } from "vue";
import { withCtx as V } from "vue";
import { createCommentVNode as N } from "vue";
import { createTextVNode as J } from "vue";
import { toDisplayString as P } from "vue";
import { nextTick as z } from "vue";
import { ElDatePicker as G } from "element-plus";
import { ElTableColumn as H } from "element-plus";
import { ElTag as Q } from "element-plus";
import { vLoading as Y } from "element-plus";
import { jP as o, i as m, vd as _, ux as $, ve as w, b as q } from "../../../../../../../shared/runtime.js";
const F = { class: "head-container" }, ee = { __name: "requisition-order", setup(W, { expose: k }) {
  var g;
  const a = (g = I("cu")) == null ? void 0 : g.form, S = p(), y = p(false), c = p([]), d = p({ times: [C().startOf("month").valueOf(), C().valueOf()], purchaseCreationState: void 0 });
  function x(e) {
    return e.purchaseCreationState !== _.COMPLETED.V;
  }
  const b = p([]), O = R(() => {
    var t;
    let e = [];
    if (a.materialTypeTotal) for (const l in o.ENUM) m(a.materialTypeTotal) && !((t = a.materialTypeTotal) != null && t.includes(o.ENUM[l].V)) && e.push(o.ENUM[l].V);
    else a.materialType & o.STEEL.V ? (e.push(o.GAS.V), e.push(o.MATERIAL.V), e.push(o.OTHER.V)) : a.materialType ? e.push(o.STEEL.V) : e = [], a.id && m(b.value) && (e = [...e, ...b.value]);
    return e;
  });
  async function f() {
    c.value = [];
    try {
      y.value = true;
      const { content: e } = await w({ filterUseInventory: true, materialType: a.currentMaterial, level: a.level, projectAttribute: a.projectAttribute, branchCompanyId: a.branchCompanyId, ...d.value }), t = [];
      c.value = e.map((l, n) => {
        var s;
        return m((s = a.requisitionsKV) == null ? void 0 : s[l.id]) && t.push(n), l;
      }), z(() => {
        t.forEach((l) => {
          var n;
          (n = S.value) == null || n.toggleRowSelection(c.value[l], void 0);
        });
      });
    } catch (e) {
      console.log(e, "获取申购单列表失败");
    } finally {
      y.value = false;
    }
  }
  function B(e, t) {
    const l = e.findIndex((n) => n.id === t.id) !== -1;
    l && q(a.requisitionsKV[t.id]) && (a.requisitionsKV[t.id] = JSON.parse(JSON.stringify(t))), !l && m(a.requisitionsKV[t.id]) && delete a.requisitionsKV[t.id];
  }
  function M(e) {
    const t = !!(e != null && e.length);
    c.value.forEach((l) => {
      t && q(a.requisitionsKV[l.id]) && (a.requisitionsKV[l.id] = JSON.parse(JSON.stringify(l))), !t && m(a.requisitionsKV[l.id]) && delete a.requisitionsKV[l.id];
    });
  }
  return k({ fetchList: f }), (e, t) => {
    const l = G, n = T("common-radio-button"), s = H, U = Q, K = T("common-table"), L = Y;
    return h(), A("div", null, [j("div", F, [r(l, { modelValue: d.value.times, "onUpdate:modelValue": t[0] || (t[0] = (i) => d.value.times = i), class: "date-item filter-item", "end-placeholder": "结束日期", "range-separator": ":", size: "small", "start-placeholder": "开始日期", style: { width: "374px" }, type: "daterange", "value-format": "x", onChange: f }, null, 8, ["modelValue"]), r(n, { modelValue: u(a).currentMaterial, "onUpdate:modelValue": t[1] || (t[1] = (i) => u(a).currentMaterial = i), "disabled-val": O.value, options: u(o).ENUM, class: "filter-item", size: "small", type: "enum", onChange: f }, null, 8, ["modelValue", "disabled-val", "options"]), r(n, { modelValue: d.value.purchaseCreationState, "onUpdate:modelValue": t[2] || (t[2] = (i) => d.value.purchaseCreationState = i), options: u(_).ENUM, class: "filter-item", "show-option-all": "", size: "small", type: "enum", onChange: f }, null, 8, ["modelValue", "options"])]), D((h(), v(K, { ref_key: "tableRef", ref: S, data: c.value, style: { width: "100%" }, onSelect: B, onSelectAll: M }, { default: V(() => [r(s, { selectable: x, align: "center", class: "selection", type: "selection", width: "50" }), r(s, { align: "center", label: "序号", type: "index", width: "55" }), r(s, { align: "center", label: "申购单号", prop: "serialNumber" }, { default: V(({ row: { sourceRow: i } }) => [i != null && i.id ? (h(), v(u($), { key: 0, receipt: i, "receipt-types": ["REQUISITIONS"] }, null, 8, ["receipt"])) : N("", true)]), _: 1 }), r(s, { align: "center", label: "状态", prop: "purchaseCreationState", width: "90" }, { default: V(({ row: i }) => {
      var E;
      return [i.purchaseCreationState ? (h(), v(U, { key: 0, type: (E = u(_).V[i.purchaseCreationState]) == null ? void 0 : E.T, effect: "plain" }, { default: V(() => [J(P(u(_).VL[i.purchaseCreationState]), 1)]), _: 2 }, 1032, ["type"])) : N("", true)];
    }), _: 1 })]), _: 1 }, 8, ["data"])), [[L, y.value]])]);
  };
} };
export {
  ee as default
};
