import { ref as y } from "vue";
import { resolveComponent as i } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as p } from "vue";
import { withDirectives as N } from "vue";
import { vShow as S } from "vue";
import { unref as e } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as n } from "vue";
import { withCtx as m } from "vue";
import { Fragment as c } from "vue";
import { renderList as b } from "vue";
import { createBlock as f } from "vue";
import { createCommentVNode as B } from "vue";
import { ElDatePicker as L } from "element-plus";
import { ElOption as P } from "element-plus";
import { ElSelect as D } from "element-plus";
import { ElCascader as A } from "element-plus";
import { ElInput as M } from "element-plus";
import { u as O } from "../../../../modules/useSelect-654af12a.js";
import { _ as R, iR as v, B as q, iN as T, C as z, G as H, E as F } from "../../../../shared/runtime.js";
const G = { class: "box-container" }, K = { class: "radio-container" }, W = { class: "select-container" }, $ = { __name: "header", setup(J, { expose: g }) {
  const h = { auditStatusEnum: v.UNDER_REVIEW.V, time: (/* @__PURE__ */ new Date()).getTime(), projectAttribute: void 0, writtenById: void 0, oaNumber: void 0, projectManagerId: void 0, supplierId: void 0, paymentEnum: void 0 }, { crud: o, query: a } = q(h), { projectLeaderList: d, allProjectList: C, supplierList: E } = O(), w = y(false), I = y({ key: "id", value: "id", label: "projectNames" });
  return g({ query: a, loading: w }), (X, t) => {
    const x = L, k = i("common-radio-button"), _ = P, V = D, U = i("common-select-v2"), u = A, j = M, Q = i("print-table");
    return s(), p(c, null, [N(r("div", null, [r("div", G, [n(x, { modelValue: e(a).time, "onUpdate:modelValue": t[0] || (t[0] = (l) => e(a).time = l), placeholder: "请选择日期", style: { width: "140px" }, type: "month", "value-format": "x", onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"])]), r("div", K, [n(k, { modelValue: e(a).auditStatusEnum, "onUpdate:modelValue": t[1] || (t[1] = (l) => e(a).auditStatusEnum = l), options: e(v).V, class: "filter-item", showOptionAll: "", size: "default", type: "enum", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"])]), r("div", W, [n(V, { modelValue: e(a).paymentEnum, "onUpdate:modelValue": t[2] || (t[2] = (l) => e(a).paymentEnum = l), class: "filter-item", clearable: "", filterable: "", placeholder: "审批类型", style: { width: "200px" }, onChange: e(o).toQuery }, { default: m(() => [(s(true), p(c, null, b(e(T).V, (l) => (s(), f(_, { key: l.K, label: l.L, value: l.V }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "onChange"]), n(U, { modelValue: e(a).projectId, "onUpdate:modelValue": t[3] || (t[3] = (l) => e(a).projectId = l), "data-structure": I.value, options: e(C), class: "filter-item", clearable: "", filterable: "", placeholder: "项目", onChange: e(o).toQuery }, null, 8, ["modelValue", "data-structure", "options", "onChange"]), n(u, { modelValue: e(a).initiatorId, "onUpdate:modelValue": t[4] || (t[4] = (l) => e(a).initiatorId = l), options: e(d), props: { value: "id", emitPath: false }, "show-all-levels": false, class: "filter-item", clearable: "", filterable: "", placeholder: "发起人", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(j, { modelValue: e(a).oaNumber, "onUpdate:modelValue": t[5] || (t[5] = (l) => e(a).oaNumber = l), class: "filter-item", clearable: "", placeholder: "OA编号", style: { width: "200px" } }, null, 8, ["modelValue"]), n(u, { modelValue: e(a).projectManagerId, "onUpdate:modelValue": t[6] || (t[6] = (l) => e(a).projectManagerId = l), options: e(d), props: { value: "id", emitPath: false }, "show-all-levels": false, class: "filter-item", clearable: "", filterable: "", placeholder: "项目经理/销售负责人", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(V, { modelValue: e(a).supplierId, "onUpdate:modelValue": t[7] || (t[7] = (l) => e(a).supplierId = l), class: "filter-item", clearable: "", filterable: "", placeholder: "供应商", style: { width: "200px" }, onChange: e(o).toQuery }, { default: m(() => [(s(true), p(c, null, b(e(E), (l) => (s(), f(_, { key: l.id, label: l.name, value: l.id }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "onChange"]), n(u, { modelValue: e(a).writtenById, "onUpdate:modelValue": t[8] || (t[8] = (l) => e(a).writtenById = l), options: e(d), props: { value: "id", emitPath: false }, "show-all-levels": false, class: "filter-item", clearable: "", filterable: "", placeholder: "审批人", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(e(z))])], 512), [[S, e(o).searchToggle]]), n(e(F), null, { viewLeft: m(() => [e(H)(e(o).permission.print) ? (s(), f(Q, { key: 0, params: e(o).query, "api-key": "approvalManagement", class: "filter-item", size: "default", type: "warning" }, null, 8, ["params"])) : B("", true)]), _: 1 })], 64);
  };
} }, le = R($, [["__scopeId", "data-v-b5dde364"]]);
export {
  le as default
};
