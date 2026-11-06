import { useStore as D } from "vuex";
import { ref as h } from "vue";
import b from "moment";
import { computed as g } from "vue";
import { watch as P } from "vue";
import { resolveComponent as c } from "vue";
import { resolveDirective as x } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as j } from "vue";
import { createElementVNode as T } from "vue";
import { withDirectives as f } from "vue";
import { vShow as z } from "vue";
import { unref as e } from "vue";
import { createVNode as o } from "vue";
import { createBlock as _ } from "vue";
import { createCommentVNode as B } from "vue";
import { withKeys as M } from "vue";
import { withCtx as m } from "vue";
import { withModifiers as H } from "vue";
import { createTextVNode as q } from "vue";
import { Fragment as K } from "vue";
import { ElDatePicker as $ } from "element-plus";
import { ElInput as L } from "element-plus";
import { ElBadge as F } from "element-plus";
import { B as Y, i as G, jP as I, t0 as i, w5 as J, iH as W, fv as X, I as Z, C as ee, w6 as N, t5 as te, E as ae } from "../../../../shared/runtime.js";
import { u as le } from "../../../../modules/use-approval-cfg-0a67817c.js";
import se from "../../components/audit-records.vue.js";
import oe from "./application/components/temporary-storage.vue.js";
const ne = { class: "head-container" }, ce = { __name: "header", setup(ie) {
  const n = D(), w = h([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), C = { times: [b().subtract(31, "days").startOf("day").valueOf(), b().endOf("day").valueOf()], status: void 0, serialNumber: void 0, materialType: void 0, projectId: void 0, branchCompanyId: void 0 }, { crud: l, query: s } = Y(C), { loaded: E } = le(), U = g(() => G(l.selections) ? l.selections[0].materialType !== I.MANUFACTURED.V : true), u = g(() => l.selections.map((r) => r.id) || []), p = h(false);
  function O() {
    p.value = true;
  }
  return P(() => E.value, (r) => {
    r && (l.toQuery(), n.dispatch("approval_list/fetchTSNum", i.REQUISITIONS_V2.V), n.dispatch("approval_list/fetchApprovalNum", i.REQUISITIONS_V2.V), n.dispatch("approval_list/fetchSubNum", i.REQUISITIONS_V2.V), n.dispatch("approval_list/fetchRejNum", i.REQUISITIONS_V2.V));
  }, { immediate: true }), (r, a) => {
    const y = c("common-radio-button"), R = $, k = L, A = c("common-button"), Q = F, v = c("print-table"), V = x("permission");
    return d(), j(K, null, [T("div", ne, [f(T("div", null, [o(y, { modelValue: e(s).materialType, "onUpdate:modelValue": a[0] || (a[0] = (t) => e(s).materialType = t), options: e(I).ENUM, class: "filter-item", showOptionAll: "", size: "default", type: "enum", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), e(s).boolInitiateApprove ? (d(), _(y, { key: 0, modelValue: e(s).status, "onUpdate:modelValue": a[1] || (a[1] = (t) => e(s).status = t), options: e(J).ENUM, class: "filter-item", showOptionAll: "", size: "default", type: "enum", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : B("", true), o(W, { modelValue: e(s).branchCompanyId, "onUpdate:modelValue": a[2] || (a[2] = (t) => e(s).branchCompanyId = t), class: "filter-item", placeholder: "申购单位", clearable: "", style: { width: "250px" }, onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), o(X, { modelValue: e(s).projectId, "onUpdate:modelValue": a[3] || (a[3] = (t) => e(s).projectId = t), class: "filter-item", clearable: "", isAll: "", filterable: "", style: { width: "280px" }, placeholder: "可选择项目搜索" }, null, 8, ["modelValue"]), o(R, { modelValue: e(s).times, "onUpdate:modelValue": a[4] || (a[4] = (t) => e(s).times = t), "default-time": w.value, disabledDate: (t) => t.getTime() > (/* @__PURE__ */ new Date()).getTime(), shortcuts: e(Z), class: "filter-item", "end-placeholder": "结束日期", "range-separator": ":", size: "default", "start-placeholder": "开始日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(l).toQuery }, null, 8, ["modelValue", "default-time", "disabledDate", "shortcuts", "onChange"]), o(k, { modelValue: e(s).serialNumber, "onUpdate:modelValue": a[5] || (a[5] = (t) => e(s).serialNumber = t), class: "filter-item", clearable: "", placeholder: "可输入申购编号搜索", size: "default", style: { width: "200px" }, onKeyup: M(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), o(e(ee))], 512), [[z, e(l).searchToggle]]), o(e(ae), { addText: "申购创建" }, { optRight: m(() => {
      var t, S;
      return [o(Q, { hidden: !e(n).state.approval_list.TSScm_Num, value: e(n).state.approval_list.TSScm_Num, class: "item", style: { "z-index": "10" } }, { default: m(() => [o(A, { class: "filter-item", size: "default", type: "warning", onClick: H(O, ["stop"]) }, { default: m(() => a[8] || (a[8] = [q(" 暂存列表 ")])), _: 1, __: [8] })]), _: 1 }, 8, ["hidden", "value"]), U.value ? f((d(), _(v, { key: 0, disabled: u.value.length === 0, params: u.value, "api-key": "scmRequisitionsDetail", class: "filter-item", size: "default", type: "warning", onSuccess: e(l).selectAllChange }, null, 8, ["disabled", "params", "onSuccess"])), [[V, (t = e(N)) == null ? void 0 : t.print]]) : f((d(), _(v, { key: 1, disabled: u.value.length === 0, params: u.value, "api-key": "scmManufRequisitionsDetail", class: "filter-item", size: "default", type: "warning", onSuccess: e(l).selectAllChange }, null, 8, ["disabled", "params", "onSuccess"])), [[V, (S = e(N)) == null ? void 0 : S.print]])];
    }), viewLeft: m(() => [o(se, { APPtotal: e(n).state.approval_list.approvalScm_Num, "component-name-list": e(i).REQUISITIONS_V2.V, "module-type": e(te).SUPPLY_CHAIN.V, "rej-total": e(n).state.approval_list.rejScm_Num, subTotal: e(n).state.approval_list.SubScm_Num, onHandleSuccess: a[6] || (a[6] = (t) => e(l).toQuery()) }, null, 8, ["APPtotal", "component-name-list", "module-type", "rej-total", "subTotal"])]), _: 1 })]), o(oe, { modelValue: p.value, "onUpdate:modelValue": a[7] || (a[7] = (t) => p.value = t), onSuccess: e(l).toQuery }, null, 8, ["modelValue", "onSuccess"])], 64);
  };
} };
export {
  ce as default
};
