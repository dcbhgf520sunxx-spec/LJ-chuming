import { inject as z } from "vue";
import { ref as I } from "vue";
import { computed as V } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as f } from "vue";
import { createBlock as B } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as o } from "vue";
import { unref as t } from "vue";
import { createTextVNode as C } from "vue";
import { toDisplayString as k } from "vue";
import { createElementBlock as T } from "vue";
import { ElDatePicker as S } from "element-plus";
import { ElFormItem as F } from "element-plus";
import { ElInputNumber as H } from "element-plus";
import { ElForm as K } from "element-plus";
import { t as L, fg as P, m as R, ao as Y, b as A } from "../../../../../shared/runtime.js";
const G = { style: { float: "right" } }, M = { class: "form" }, J = { key: 0, class: "hint" }, X = { key: 1 }, te = { __name: "form", props: { branchList: { type: Array, default: () => [] } }, setup(N) {
  const { decimalPrecision: y } = L(), { projectTree: m } = P(), { user: w } = R("user"), b = z("expenseList"), D = I([]), c = I(), O = {}, E = V(() => i.status.edit >= 1), { crud: i, form: a, CRUD: d } = Y(O, c), U = { fillInDate: [{ required: true, message: "请选择日期", trigger: "change" }], branchCompanyId: [{ required: true, message: "请选择费用归属", trigger: "change" }], expenseTypeId: [{ required: true, message: "请选择费用类型：", trigger: "change" }], projectId: [{ required: true, message: "请选择项目：", trigger: "change" }], reimburserId: [{ required: true, message: "请选择报销人", trigger: "change" }], reimbursementVoucherNumber: [{ required: true, message: "请输入报销凭证号", trigger: "blur" }], totalWage: [{ required: true, validator: (s, e, l) => {
    e || l(new Error("填写数据必须大于0")), l();
  }, trigger: "change" }], employeeQuantity: [{ required: true, message: "请输入员工数量", trigger: "blur" }] };
  function _(s) {
    var e;
    D.value = (e = b.find((l) => l.id === a.expenseTypeId)) == null ? void 0 : e.links;
  }
  const h = V(() => a.totalWage && a.employeeQuantity ? (a.totalWage / a.employeeQuantity).toFixed(y.value.contract) : "");
  d.HOOK.beforeToQuery = async (s, e) => {
  }, d.HOOK.beforeToAdd = async (s, e) => {
    m.value = m.value.map((l) => (l.serialNumberName = l.serialNumber + " " + l.name, l));
  }, d.HOOK.afterToEdit = async (s, e) => {
  }, d.HOOK.beforeToEdit = async () => {
    var s;
    _(), m.value = m.value.map((e) => (e.serialNumberName = e.serialNumber + " " + e.name, e)), a.projectId = (s = a.project) == null ? void 0 : s.id;
  }, d.HOOK.beforeSubmit = async () => {
    if (!await c.value.validate()) return false;
  };
  function Q(s) {
    return s > /* @__PURE__ */ new Date();
  }
  return (s, e) => {
    const l = p("common-button"), j = S, u = F, v = p("common-select-v2"), x = H, q = K, W = p("common-dialog");
    return f(), B(W, { "append-to-body": "", "close-on-click-modal": false, "before-close": t(i).cancelCU, visible: t(i).status.cu > 0, title: t(i).status.title, "show-close": false, width: "500px", top: "10vh" }, { titleRight: n(() => [g("span", G, [o(l, { loading: t(i).status.cu === t(d).STATUS.PROCESSING, size: "default", type: "primary", onClick: t(i).submitCU }, { default: n(() => e[5] || (e[5] = [C(" 提 交 ")])), _: 1, __: [5] }, 8, ["loading", "onClick"]), o(l, { size: "default", onClick: t(i).cancelCU }, { default: n(() => e[6] || (e[6] = [C("关 闭")])), _: 1, __: [6] }, 8, ["onClick"])])]), default: n(() => [g("div", M, [o(q, { ref_key: "formRef", ref: c, model: t(a), rules: U, size: "default", "label-width": "140px", class: "demo-form" }, { default: n(() => [o(u, { label: "日期：", prop: "fillInDate" }, { default: n(() => [o(j, { modelValue: t(a).fillInDate, "onUpdate:modelValue": e[0] || (e[0] = (r) => t(a).fillInDate = r), type: "date", size: "default", class: "date-item filter-item", placeholder: "选择日期", format: "YYYY-MM-DD", "value-format": "x", style: { width: "270px" }, "disabled-date": Q }, null, 8, ["modelValue"])]), _: 1 }), o(u, { label: "费用归属：", prop: "branchCompanyId" }, { default: n(() => [o(v, { modelValue: t(a).branchCompanyId, "onUpdate:modelValue": e[1] || (e[1] = (r) => t(a).branchCompanyId = r), options: N.branchList, "data-structure": { key: "id", label: "name", value: "id" }, clearable: "", filterable: "", type: "other", size: "default", placeholder: "请选择分支机构", style: { width: "270px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), o(u, { label: "费用类型：", prop: "expenseTypeId" }, { default: n(() => [o(v, { modelValue: t(a).expenseTypeId, "onUpdate:modelValue": e[2] || (e[2] = (r) => t(a).expenseTypeId = r), options: t(b), type: "other", "data-structure": { key: "id", label: "name", value: "id" }, class: "filter-item", clearable: "", style: { width: "270px" }, placeholder: "选择费用类型", onChange: _ }, null, 8, ["modelValue", "options"])]), _: 1 }), o(u, { label: "创建人：", prop: "name" }, { default: n(() => {
      var r;
      return [g("span", null, k(E.value ? (r = t(a)) == null ? void 0 : r.founderName : t(w).name), 1)];
    }), _: 1 }), o(u, { label: "工资总额：", prop: "totalWage" }, { default: n(() => [o(x, { modelValue: t(a).totalWage, "onUpdate:modelValue": e[3] || (e[3] = (r) => t(a).totalWage = r), style: { width: "270px" }, placeholder: "输入金额， 单位：元", "controls-position": "right", precision: t(y).contract, min: 0, max: 9999999999 }, null, 8, ["modelValue", "precision"])]), _: 1 }), o(u, { label: "员工数量：", prop: "employeeQuantity" }, { default: n(() => [o(x, { modelValue: t(a).employeeQuantity, "onUpdate:modelValue": e[4] || (e[4] = (r) => t(a).employeeQuantity = r), style: { width: "270px" }, placeholder: "输入人数", "controls-position": "right", min: 1, max: 9999999999 }, null, 8, ["modelValue"])]), _: 1 }), o(u, { label: "平均工资：", prop: "averageWage" }, { default: n(() => [t(A)(h.value) ? (f(), T("span", J, "根据上方填写内容自动计算")) : (f(), T("span", X, k(h.value) + " 元", 1))]), _: 1 })]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  te as default
};
