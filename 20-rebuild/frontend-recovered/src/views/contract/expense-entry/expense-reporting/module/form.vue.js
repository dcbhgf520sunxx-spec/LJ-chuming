import { inject as N } from "vue";
import { ref as x } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as D } from "vue";
import { createBlock as O } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as o } from "vue";
import { unref as t } from "vue";
import { createTextVNode as v } from "vue";
import { ElDatePicker as S } from "element-plus";
import { ElFormItem as E } from "element-plus";
import { ElInputNumber as z } from "element-plus";
import { ElInput as R } from "element-plus";
import { ElForm as A } from "element-plus";
import { t as q, fg as H, ao as K } from "../../../../../shared/runtime.js";
import { u as P } from "../../../../../modules/index-7da9f094.js";
import "../../../../../modules/use-users-4d979987.js";
const B = { style: { float: "right" } }, F = { class: "form" }, W = { __name: "form", setup(Y) {
  const { decimalPrecision: V } = q(), { projectTree: m } = H(), b = N("expenseList"), _ = x([]), p = x(), I = {}, { crud: d, form: l, CRUD: n } = K(I, p), w = { reimburseDate: [{ required: true, message: "请选择报销日期", trigger: "blur" }], reimburseUserId: [{ required: true, message: "请选择报销人", trigger: "blur" }], expenseTypeId: [{ required: true, message: "请选择费用类别", trigger: "blur" }], expenseSubjectId: [{ required: true, message: "请选择报销科目", trigger: "blur" }], reimburseAmount: [{ required: true, validator: (i, e, a) => {
    e || a(new Error("填写数据必须大于0")), a();
  }, trigger: "blur" }] };
  function y(i) {
    var e;
    _.value = (e = b.find((a) => a.id === l.expenseTypeId)) == null ? void 0 : e.links;
  }
  n.HOOK.beforeToQuery = async (i, e) => {
  }, n.HOOK.beforeToAdd = async (i, e) => {
    m.value = m.value.map((a) => (a.serialNumberName = a.serialNumber + " " + a.name, a));
  }, n.HOOK.afterToEdit = async (i, e) => {
  }, n.HOOK.beforeToEdit = async () => {
    var i;
    y(), m.value = m.value.map((e) => (e.serialNumberName = e.serialNumber + " " + e.name, e)), l.projectId = (i = l.project) == null ? void 0 : i.id;
  }, n.HOOK.beforeSubmit = async () => {
    if (!await p.value.validate()) return false;
  };
  function k(i) {
    return i > /* @__PURE__ */ new Date();
  }
  return (i, e) => {
    const a = f("common-button"), U = S, u = E, c = f("common-select-v2"), h = z, j = R, T = A, C = f("common-dialog");
    return D(), O(C, { "append-to-body": "", "close-on-click-modal": false, "before-close": t(d).cancelCU, visible: t(d).status.cu > 0, title: t(d).status.title, "show-close": false, width: "500px", top: "10vh" }, { titleRight: s(() => [g("span", B, [o(a, { loading: t(d).status.cu === t(n).STATUS.PROCESSING, size: "default", type: "primary", onClick: t(d).submitCU }, { default: s(() => e[7] || (e[7] = [v(" 提 交 ")])), _: 1, __: [7] }, 8, ["loading", "onClick"]), o(a, { size: "default", onClick: t(d).cancelCU }, { default: s(() => e[8] || (e[8] = [v("关 闭")])), _: 1, __: [8] }, 8, ["onClick"])])]), default: s(() => [g("div", F, [o(T, { ref_key: "formRef", ref: p, model: t(l), rules: w, size: "default", "label-width": "140px", class: "demo-form" }, { default: s(() => [o(u, { label: "报销日期：", prop: "reimburseDate" }, { default: s(() => [o(U, { modelValue: t(l).reimburseDate, "onUpdate:modelValue": e[0] || (e[0] = (r) => t(l).reimburseDate = r), type: "date", size: "default", class: "date-item filter-item", placeholder: "选择报销日期", format: "YYYY-MM-DD", "value-format": "x", style: { width: "270px" }, "disabled-date": k }, null, 8, ["modelValue"])]), _: 1 }), o(u, { label: "项目：", prop: "projectId" }, { default: s(() => [o(c, { modelValue: t(l).projectId, "onUpdate:modelValue": e[1] || (e[1] = (r) => t(l).projectId = r), options: t(m), type: "other", "data-structure": { key: "id", label: "serialNumberName", value: "id" }, class: "filter-item", clearable: "", filterable: "", style: { width: "270px" }, placeholder: "选择项目 非必选" }, null, 8, ["modelValue", "options"])]), _: 1 }), o(u, { label: "报销人：", prop: "reimburseUserId" }, { default: s(() => [o(t(P), { ref: "userRef", modelValue: t(l).reimburseUserId, "onUpdate:modelValue": e[2] || (e[2] = (r) => t(l).reimburseUserId = r), placeholder: "选择报销人", size: "default", clearable: "", class: "filter-item", style: { width: "270px" }, defaultValue: "" }, null, 8, ["modelValue"])]), _: 1 }), o(u, { label: "费用类别：", prop: "expenseTypeId" }, { default: s(() => [o(c, { modelValue: t(l).expenseTypeId, "onUpdate:modelValue": e[3] || (e[3] = (r) => t(l).expenseTypeId = r), options: t(b), type: "other", "data-structure": { key: "id", label: "name", value: "id" }, class: "filter-item", clearable: "", style: { width: "270px" }, placeholder: "选择费用类别", onChange: y }, null, 8, ["modelValue", "options"])]), _: 1 }), o(u, { label: "报销科目：", prop: "expenseSubjectId" }, { default: s(() => [o(c, { modelValue: t(l).expenseSubjectId, "onUpdate:modelValue": e[4] || (e[4] = (r) => t(l).expenseSubjectId = r), options: _.value, type: "other", "data-structure": { key: "id", label: "label", value: "id" }, size: "default", clearable: "", class: "filter-item", style: { width: "270px" }, placeholder: "选择报销科目" }, null, 8, ["modelValue", "options"])]), _: 1 }), o(u, { label: "报销费用（元）：", prop: "reimburseAmount" }, { default: s(() => [o(h, { modelValue: t(l).reimburseAmount, "onUpdate:modelValue": e[5] || (e[5] = (r) => t(l).reimburseAmount = r), style: { width: "270px" }, placeholder: "输入报销费用", "controls-position": "right", precision: t(V).contract, min: 0, max: 9999999999 }, null, 8, ["modelValue", "precision"])]), _: 1 }), o(u, { label: "备注：", prop: "remark" }, { default: s(() => [o(j, { modelValue: t(l).remark, "onUpdate:modelValue": e[6] || (e[6] = (r) => t(l).remark = r), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 2, maxRows: 8 }, placeholder: "输入备注", style: { width: "270px" }, maxlength: 300, "show-word-limit": "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  W as default
};
