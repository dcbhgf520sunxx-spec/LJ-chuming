import { ref as C } from "vue";
import { computed as _ } from "vue";
import { watch as w } from "vue";
import { resolveComponent as d } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as A } from "vue";
import { withDirectives as p } from "vue";
import { vShow as T } from "vue";
import { unref as e } from "vue";
import { createElementVNode as U } from "vue";
import { createVNode as n } from "vue";
import { createBlock as S } from "vue";
import { createCommentVNode as D } from "vue";
import { withKeys as I } from "vue";
import { withCtx as N } from "vue";
import { ElDatePicker as k } from "element-plus";
import { ElInput as Q } from "element-plus";
import { B as R, j_ as x, w5 as z, aS as K, I as O, C as B, w6 as L, E as q } from "../../../../shared/runtime.js";
import { u as P } from "../../../../modules/use-approval-cfg-0a67817c.js";
const F = { class: "head-container" }, G = { __name: "header", setup(M) {
  const c = C([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]), r = { FALSE: { L: "无审批", K: "FALSE", V: false }, TRUE: { L: "有审批", K: "TRUE", V: true } }, f = { times: [], boolInitiateApprove: { value: r.FALSE.V, resetAble: false }, status: void 0, serialNumber: void 0, materialType: void 0 }, { crud: l, query: a } = R(f), { approvalCfg: v, loaded: y } = P(), u = _(() => l.selections.map((s) => s.id) || []);
  return w(() => y.value, (s) => {
    s && (a.boolInitiateApprove = v.value.requisition, l.toQuery());
  }, { immediate: true }), (s, o) => {
    const i = d("common-radio-button"), g = k, V = Q, b = d("print-table"), h = E("permission");
    return m(), A("div", F, [p(U("div", null, [n(i, { modelValue: e(a).boolInitiateApprove, "onUpdate:modelValue": o[0] || (o[0] = (t) => e(a).boolInitiateApprove = t), options: r, type: "enum", size: "default", class: "filter-item", onChange: e(l).toQuery }, null, 8, ["modelValue", "onChange"]), n(i, { modelValue: e(a).materialType, "onUpdate:modelValue": o[1] || (o[1] = (t) => e(a).materialType = t), options: e(x).ENUM, class: "filter-item", showOptionAll: "", type: "enum", size: "default", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), e(a).boolInitiateApprove ? (m(), S(i, { key: 0, modelValue: e(a).status, "onUpdate:modelValue": o[2] || (o[2] = (t) => e(a).status = t), options: e(z).ENUM, class: "filter-item", showOptionAll: "", type: "enum", size: "default", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"])) : D("", true), n(i, { modelValue: e(a).enabled, "onUpdate:modelValue": o[3] || (o[3] = (t) => e(a).enabled = t), options: e(K).ENUM, class: "filter-item", "show-option-all": "", type: "enum", size: "default", onChange: e(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(g, { modelValue: e(a).times, "onUpdate:modelValue": o[4] || (o[4] = (t) => e(a).times = t), "default-time": c.value, disabledDate: (t) => t.getTime() > (/* @__PURE__ */ new Date()).getTime(), shortcuts: e(O), class: "filter-item", "end-placeholder": "结束日期", "range-separator": ":", size: "default", "start-placeholder": "开始日期", style: { width: "240px" }, type: "daterange", "unlink-panels": "", "value-format": "x", onChange: e(l).toQuery }, null, 8, ["modelValue", "default-time", "disabledDate", "shortcuts", "onChange"]), n(V, { modelValue: e(a).serialNumber, "onUpdate:modelValue": o[5] || (o[5] = (t) => e(a).serialNumber = t), class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", placeholder: "可输入申购编号搜索", onKeyup: I(e(l).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(B))], 512), [[T, e(l).searchToggle]]), n(e(q), { addText: "申购创建" }, { optRight: N(() => {
      var t;
      return [p(n(b, { disabled: u.value.length === 0, params: u.value, "api-key": "scmRequisitionsDetail", class: "filter-item", size: "default", type: "warning", onSuccess: e(l).selectAllChange }, null, 8, ["disabled", "params", "onSuccess"]), [[h, (t = e(L)) == null ? void 0 : t.print]])];
    }), _: 1 })]);
  };
} };
export {
  G as default
};
