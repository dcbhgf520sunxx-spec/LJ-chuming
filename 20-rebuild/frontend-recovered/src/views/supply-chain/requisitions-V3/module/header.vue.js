import { useStore as D } from "vuex";
import { ref as g } from "vue";
import h from "moment";
import { computed as T } from "vue";
import { watch as P } from "vue";
import { resolveComponent as c } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as x } from "vue";
import { createElementVNode as b } from "vue";
import { withDirectives as f } from "vue";
import { vShow as z } from "vue";
import { unref as e } from "vue";
import { createVNode as o } from "vue";
import { createBlock as _ } from "vue";
import { createCommentVNode as B } from "vue";
import { withKeys as M } from "vue";
import { withCtx as m } from "vue";
import { withModifiers as q } from "vue";
import { createTextVNode as H } from "vue";
import { Fragment as K } from "vue";
import { ElDatePicker as L } from "element-plus";
import { ElInput as $ } from "element-plus";
import { ElBadge as F } from "element-plus";
import { B as Y, i as G, jP as N, t0 as i, w5 as J, fv as W, I as X, C as Z, w6 as I, t5 as ee, E as te } from "../../../../shared/runtime.js";
import { u as ae } from "../../../../modules/use-approval-cfg-0a67817c.js";
import le from "../../components/audit-records.vue.js";
import se from "../../requisitions-V2/module/application/components/temporary-storage.vue.js";
const oe = { class: "head-container" }, pe = { __name: "header", setup(ne) {
  const n = D(), w = g([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), C = { times: [h().subtract(31, "days").startOf("day").valueOf(), h().endOf("day").valueOf()], status: void 0, serialNumber: void 0, materialType: void 0, projectId: void 0 }, { crud: l, query: s } = Y(C), { loaded: E } = ae(), U = T(() => G(l.selections) ? l.selections[0].materialType !== N.MANUFACTURED.V : true), u = T(() => l.selections.map((r) => r.id) || []), p = g(false);
  function O() {
    p.value = true;
  }
  return P(() => E.value, (r) => {
    r && (l.toQuery(), n.dispatch("approval_list/fetchTSNum", i.REQUISITIONS_V2.V), n.dispatch("approval_list/fetchApprovalNum", i.REQUISITIONS_V2.V), n.dispatch("approval_list/fetchSubNum", i.REQUISITIONS_V2.V), n.dispatch("approval_list/fetchRejNum", i.REQUISITIONS_V2.V));
  }, { immediate: true }), (r, a) => {
    const v = c("common-radio-button"), R = L, k = $, A = c("common-button"), Q = F, y = c("print-table"), S = j("permission");
    return d(), x(K, null, [b("div", oe, [f(b("div", null, [o(v, { modelValue: e(s).materialType, "onUpdate:modelValue": a[0] || (a[0] = (t) => e(s).materialType = t), options: e(N).ENUM, class: "filter-item", showOptionAll: "", size: "default", type: "enum", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), e(s).boolInitiateApprove ? (d(), _(v, { key: 0, modelValue: e(s).status, "onUpdate:modelValue": a[1] || (a[1] = (t) => e(s).status = t), options: e(J).ENUM, class: "filter-item", showOptionAll: "", size: "default", type: "enum", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : B("", true), o(W, { modelValue: e(s).projectId, "onUpdate:modelValue": a[2] || (a[2] = (t) => e(s).projectId = t), class: "filter-item", clearable: "", filterable: "", placeholder: "可选择项目搜索" }, null, 8, ["modelValue"]), o(R, { modelValue: e(s).times, "onUpdate:modelValue": a[3] || (a[3] = (t) => e(s).times = t), "default-time": w.value, disabledDate: (t) => t.getTime() > (/* @__PURE__ */ new Date()).getTime(), shortcuts: e(X), class: "filter-item", "end-placeholder": "结束日期", "range-separator": ":", size: "default", "start-placeholder": "开始日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(l).toQuery }, null, 8, ["modelValue", "default-time", "disabledDate", "shortcuts", "onChange"]), o(k, { modelValue: e(s).serialNumber, "onUpdate:modelValue": a[4] || (a[4] = (t) => e(s).serialNumber = t), class: "filter-item", clearable: "", placeholder: "可输入申购编号搜索", size: "default", style: { width: "200px" }, onKeyup: M(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(e(Z))], 512), [[z, e(l).searchToggle]]), o(e(te), { addText: "申购创建" }, { optRight: m(() => {
      var t, V;
      return [o(Q, { hidden: !e(n).state.approval_list.TSScm_Num, value: e(n).state.approval_list.TSScm_Num, class: "item", style: { "z-index": "10" } }, { default: m(() => [o(A, { class: "filter-item", size: "default", type: "warning", onClick: q(O, ["stop"]) }, { default: m(() => a[7] || (a[7] = [H(" 暂存列表 ")])), _: 1, __: [7] })]), _: 1 }, 8, ["hidden", "value"]), U.value ? f((d(), _(y, { key: 0, disabled: u.value.length === 0, params: u.value, "api-key": "scmRequisitionsDetail", class: "filter-item", size: "default", type: "warning", onSuccess: e(l).selectAllChange }, null, 8, ["disabled", "params", "onSuccess"])), [[S, (t = e(I)) == null ? void 0 : t.print]]) : f((d(), _(y, { key: 1, disabled: u.value.length === 0, params: u.value, "api-key": "scmManufRequisitionsDetail", class: "filter-item", size: "default", type: "warning", onSuccess: e(l).selectAllChange }, null, 8, ["disabled", "params", "onSuccess"])), [[S, (V = e(I)) == null ? void 0 : V.print]])];
    }), viewLeft: m(() => [o(le, { APPtotal: e(n).state.approval_list.approvalScm_Num, "component-name-list": e(i).REQUISITIONS_V2.V, "module-type": e(ee).SUPPLY_CHAIN.V, "rej-total": e(n).state.approval_list.rejScm_Num, subTotal: e(n).state.approval_list.SubScm_Num, onHandleSuccess: a[5] || (a[5] = (t) => e(l).toQuery()) }, null, 8, ["APPtotal", "component-name-list", "module-type", "rej-total", "subTotal"])]), _: 1 })]), o(se, { modelValue: p.value, "onUpdate:modelValue": a[6] || (a[6] = (t) => p.value = t), onSuccess: e(l).toQuery }, null, 8, ["modelValue", "onSuccess"])], 64);
  };
} };
export {
  pe as default
};
