import { ref as g } from "vue";
import { useStore as O } from "vuex";
import { inject as M } from "vue";
import { computed as Q } from "vue";
import { onMounted as A } from "vue";
import { resolveComponent as L } from "vue";
import { resolveDirective as K } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as N } from "vue";
import { unref as e } from "vue";
import { createVNode as s } from "vue";
import { withKeys as w } from "vue";
import { createCommentVNode as B } from "vue";
import { withCtx as i } from "vue";
import { createBlock as d } from "vue";
import { withDirectives as C } from "vue";
import { createTextVNode as E } from "vue";
import { ElDatePicker as D } from "element-plus";
import { ElInput as F } from "element-plus";
import { ElTooltip as W } from "element-plus";
import { B as z, t0 as p, cJ as H, pB as Y, xL as $, tX as S, I as x, fv as q, C as J, L as I, xM as P, t5 as X, E as G } from "../../../../../shared/runtime.js";
import Z from "../../../../supply-chain/components/audit-records.vue.js";
import ee from "./components/inventory-surplus-list/index.vue.js";
import "./components/inventory-surplus-list/module/list.vue.js";
const te = { class: "head-container" }, ae = { key: 0 }, ue = { __name: "header", setup(le, { expose: R }) {
  const m = g(), n = O(), U = { basicClass: void 0, classifyId: void 0, projectWarehouseType: void 0, boolPartyA: void 0, reviewTime: [], createTime: [] }, c = g([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), { crud: o, query: l } = z(U), f = M("permission"), y = Q(() => o.selections.map((V) => V.id) || []);
  function k() {
    m.value.updateListNumber();
  }
  return A(() => {
    n.dispatch("approval_list/fetchApprovalNum", p.INVENTORY_PROFIT.V), n.dispatch("approval_list/fetchSubNum", p.INVENTORY_PROFIT.V), n.dispatch("approval_list/fetchRejNum", p.INVENTORY_PROFIT.V);
  }), R({ handleInventorySurplusList: k }), (V, t) => {
    const u = L("common-radio-button"), _ = D, h = F, j = W, v = K("permission");
    return r(), N("div", te, [e(o).searchToggle ? (r(), N("div", ae, [s(u, { modelValue: e(l).basicClass, "onUpdate:modelValue": t[0] || (t[0] = (a) => e(l).basicClass = a), options: e(H).ENUM, class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(u, { modelValue: e(l).projectWarehouseType, "onUpdate:modelValue": t[1] || (t[1] = (a) => e(l).projectWarehouseType = a), options: e(Y).ENUM, class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(u, { modelValue: e(l).boolPartyA, "onUpdate:modelValue": t[2] || (t[2] = (a) => e(l).boolPartyA = a), dataStructure: { key: "K", label: "SL", value: "V" }, options: e($).V, class: "filter-item", clearable: "", "show-option-all": "", type: "other", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), s(u, { modelValue: e(l).reviewStatus, "onUpdate:modelValue": t[3] || (t[3] = (a) => e(l).reviewStatus = a), options: e(S).ENUM, unshowVal: [e(S).REFUSE.V], class: "filter-item", clearable: "", "show-option-all": "", type: "enum", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "unshowVal", "onChange"]), s(_, { modelValue: e(l).createTime, "onUpdate:modelValue": t[4] || (t[4] = (a) => e(l).createTime = a), "default-time": c.value, shortcuts: e(x), class: "filter-item", "end-placeholder": "申请日期", "range-separator": ":", size: "default", "start-placeholder": "申请日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(o).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), s(_, { modelValue: e(l).reviewTime, "onUpdate:modelValue": t[5] || (t[5] = (a) => e(l).reviewTime = a), "default-time": c.value, shortcuts: e(x), class: "filter-item", "end-placeholder": "审核通过日期", "range-separator": ":", size: "default", "start-placeholder": "审核通过日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(o).toQuery }, null, 8, ["modelValue", "default-time", "shortcuts", "onChange"]), s(e(q), { modelValue: e(l).projectId, "onUpdate:modelValue": t[6] || (t[6] = (a) => e(l).projectId = a), class: "filter-item", clearable: "", isAll: "", placeholder: "关联项目", style: { width: "300px" }, onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"]), s(h, { modelValue: e(l).serialNumber, "onUpdate:modelValue": t[7] || (t[7] = (a) => e(l).serialNumber = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "盘盈单号", size: "default", style: { width: "200px" }, onKeyup: w(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(h, { modelValue: e(l).applicantName, "onUpdate:modelValue": t[8] || (t[8] = (a) => e(l).applicantName = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "申请人", size: "default", style: { width: "200px" }, onKeyup: w(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(e(J))])) : B("", true), s(e(G), null, { optRight: i(() => {
      var a, T;
      return [((a = e(o).selections) == null ? void 0 : a.length) <= 0 ? (r(), d(j, { key: 0, class: "box-item", content: "请先选择单据", effect: "dark", placement: "top" }, { default: i(() => {
        var b;
        return [C((r(), d(I, { disabled: ((b = e(o).selections) == null ? void 0 : b.length) <= 0, fn: e(P), params: { ids: y.value }, class: "filter-item" }, { default: i(() => t[9] || (t[9] = [E(" 盘盈单据下载 ")])), _: 1, __: [9] }, 8, ["disabled", "fn", "params"])), [[v, e(f).get]])];
      }), _: 1 })) : C((r(), d(I, { key: 1, disabled: ((T = e(o).selections) == null ? void 0 : T.length) <= 0, fn: e(P), params: { ids: y.value }, class: "filter-item" }, { default: i(() => t[10] || (t[10] = [E(" 盘盈单据下载 ")])), _: 1, __: [10] }, 8, ["disabled", "fn", "params"])), [[v, e(f).get]])];
    }), viewLeft: i(() => [s(ee, { ref_key: "inventorySurplusListRef", ref: m }, null, 512), s(Z, { APPtotal: e(n).state.approval_list.approvalProfit_Num, "component-name-list": e(p).INVENTORY_PROFIT.V, "module-type": e(X).WMS.V, "rej-total": e(n).state.approval_list.rejScm_Num_Profit, subTotal: e(n).state.approval_list.SubScm_Num_Profit, onHandleSuccess: e(o).toQuery }, null, 8, ["APPtotal", "component-name-list", "module-type", "rej-total", "subTotal", "onHandleSuccess"])]), _: 1 })]);
  };
} };
export {
  ue as default
};
