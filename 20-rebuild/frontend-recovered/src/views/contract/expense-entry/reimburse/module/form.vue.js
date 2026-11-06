import { inject as x } from "vue";
import { ref as C } from "vue";
import { computed as I } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as h } from "vue";
import { createBlock as $ } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as v } from "vue";
import { toDisplayString as w } from "vue";
import { createElementBlock as k } from "vue";
import { Fragment as Q } from "vue";
import { renderList as G } from "vue";
import { createCommentVNode as W } from "vue";
import { ElMessageBox as L } from "element-plus";
import { ElDatePicker as H } from "element-plus";
import { ElFormItem as K } from "element-plus";
import { ElInputNumber as J } from "element-plus";
import { ElInput as X } from "element-plus";
import { ElTooltip as Z } from "element-plus";
import { ElForm as ee } from "element-plus";
import { _ as te, t as ae, m as le, ao as oe, z as ne, S as re, L as se } from "../../../../../shared/runtime.js";
import { u as ie } from "../../../../../modules/index-7da9f094.js";
import { _ as me } from "../../../../../modules/dept-cascader-6af417b9.js";
import { _ as de } from "../../../../../modules/UploadBtn-b4cfb47a.js";
import "../../../../../modules/use-users-4d979987.js";
import "../../../../../modules/use-dept-b8e95315.js";
const ue = { style: { float: "right" } }, pe = { class: "form" }, ce = { class: "attachment-name" }, fe = { class: "attachment-operation" }, be = { __name: "form", props: { branchList: { type: Array, default: () => [] } }, setup(U) {
  const { decimalPrecision: D } = ae(), { user: N } = le("user"), y = x("expenseList"), c = x("projectList"), T = C([]), f = C(), E = {}, B = I(() => m.status.edit >= 1), { crud: m, form: a, CRUD: g } = oe(E, f), z = (i, t, s) => {
    t || s(new Error("填写数据必须大于0")), s();
  }, S = I(() => {
    var t, s, p;
    const i = ((p = (s = (t = c == null ? void 0 : c.value) == null ? void 0 : t.filter((r) => r.id === a.branchCompanyId)) == null ? void 0 : s[0]) == null ? void 0 : p.projectList) || [];
    return i == null || i.forEach((r) => {
      r.fullName = ne(r, null, false);
    }), i;
  }), A = { reimbursementDate: [{ required: true, message: "请选择报销日期", trigger: "change" }], branchCompanyId: [{ required: true, message: "请选择费用归属", trigger: "change" }], expenseTypeId: [{ required: true, message: "请选择费用类型：", trigger: "change" }], reimburserId: [{ required: true, message: "请选择报销人", trigger: "change" }], deptId: [{ required: true, message: "请选择部门", trigger: "change" }], reimbursementAmount: [{ required: true, validator: z, trigger: "change" }] };
  function R(i) {
    var t;
    T.value = (t = y.find((s) => s.id === a.expenseTypeId)) == null ? void 0 : t.links;
  }
  g.HOOK.beforeSubmit = async () => {
    var t;
    if (a.attachmentIds = (t = a.attachmentList) == null ? void 0 : t.map((s) => s.id), !await f.value.validate()) return false;
  };
  function j(i) {
    return i > /* @__PURE__ */ new Date();
  }
  function F(i) {
    L.confirm("确定要删除吗？", "Warning", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }).then(() => {
      a.attachmentList = a.attachmentList.filter((t) => t.id !== i);
    });
  }
  function M() {
    m.form.reimbursementAmount < 0 ? L.confirm("费用为负数，请再次确认！", "Warning", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }).then(() => {
      m.submitCU();
    }) : m.submitCU();
  }
  return (i, t) => {
    const s = _("common-button"), p = H, r = K, b = _("common-select-v2"), q = J, V = X, O = Z, P = ee, Y = _("common-dialog");
    return h(), $(Y, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(m).cancelCU, visible: e(m).status.cu > 0, title: e(m).status.title, "show-close": false, width: "500px", top: "10vh" }, { titleRight: n(() => [u("span", ue, [l(s, { loading: e(m).status.cu === e(g).STATUS.PROCESSING, size: "default", type: "primary", onClick: M }, { default: n(() => t[10] || (t[10] = [v(" 提 交 ")])), _: 1, __: [10] }, 8, ["loading"]), l(s, { size: "default", onClick: e(m).cancelCU }, { default: n(() => t[11] || (t[11] = [v("关 闭")])), _: 1, __: [11] }, 8, ["onClick"])])]), default: n(() => [u("div", pe, [l(P, { ref_key: "formRef", ref: f, model: e(a), rules: A, size: "default", "label-width": "140px", class: "demo-form" }, { default: n(() => [l(r, { label: "报销日期：", prop: "reimbursementDate" }, { default: n(() => [l(p, { modelValue: e(a).reimbursementDate, "onUpdate:modelValue": t[0] || (t[0] = (o) => e(a).reimbursementDate = o), type: "date", size: "default", class: "date-item filter-item", placeholder: "选择报销日期", format: "YYYY-MM-DD", "value-format": "x", style: { width: "270px" }, "disabled-date": j }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "费用归属：", prop: "branchCompanyId" }, { default: n(() => [l(b, { modelValue: e(a).branchCompanyId, "onUpdate:modelValue": t[1] || (t[1] = (o) => e(a).branchCompanyId = o), options: U.branchList, "data-structure": { key: "id", label: "name", value: "id" }, clearable: "", filterable: "", type: "other", size: "default", placeholder: "请选择分支机构", style: { width: "270px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), l(r, { label: "费用类型：", prop: "expenseTypeId" }, { default: n(() => [l(b, { modelValue: e(a).expenseTypeId, "onUpdate:modelValue": t[2] || (t[2] = (o) => e(a).expenseTypeId = o), options: e(y), type: "other", "data-structure": { key: "id", label: "name", value: "id" }, class: "filter-item", clearable: "", style: { width: "270px" }, placeholder: "选择费用类型", onChange: R }, null, 8, ["modelValue", "options"])]), _: 1 }), l(r, { label: "项目：", prop: "projectId" }, { default: n(() => [l(b, { modelValue: e(a).projectId, "onUpdate:modelValue": t[3] || (t[3] = (o) => e(a).projectId = o), options: S.value, type: "other", "data-structure": { key: "id", label: "fullName", value: "id" }, class: "filter-item", clearable: "", filterable: "", style: { width: "270px" }, placeholder: "选择项目", disabled: !e(a).branchCompanyId, onChange: e(m).toQuery }, null, 8, ["modelValue", "options", "disabled", "onChange"])]), _: 1 }), l(r, { label: "部门：", prop: "deptId" }, { default: n(() => [l(me, { clearable: "", checkStrictly: "", class: "filter-item", modelValue: e(a).deptId, "onUpdate:modelValue": t[4] || (t[4] = (o) => e(a).deptId = o), placeholder: "选择部门", style: { width: "270px" }, onChange: e(m).toQuery }, null, 8, ["modelValue", "onChange"])]), _: 1 }), l(r, { label: "报销金额：", prop: "reimbursementAmount" }, { default: n(() => [l(q, { modelValue: e(a).reimbursementAmount, "onUpdate:modelValue": t[5] || (t[5] = (o) => e(a).reimbursementAmount = o), style: { width: "270px" }, placeholder: "输入金额， 单位：元", "controls-position": "right", precision: e(D).contract, max: 9999999999 }, null, 8, ["modelValue", "precision"])]), _: 1 }), l(r, { label: "报销人：", prop: "reimburserId" }, { default: n(() => [l(e(ie), { ref: "userRef", modelValue: e(a).reimburserId, "onUpdate:modelValue": t[6] || (t[6] = (o) => e(a).reimburserId = o), placeholder: "选择报销人", size: "default", clearable: "", class: "filter-item", style: { width: "270px" }, defaultValue: "" }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "报销凭证号：", prop: "reimbursementVoucherNumber" }, { default: n(() => [l(V, { modelValue: e(a).reimbursementVoucherNumber, "onUpdate:modelValue": t[7] || (t[7] = (o) => e(a).reimbursementVoucherNumber = o), modelModifiers: { trim: true }, placeholder: "OA产生的凭证或手工编号", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "填报人：", prop: "name" }, { default: n(() => {
      var o;
      return [u("span", null, w(B.value ? (o = e(a)) == null ? void 0 : o.writtenByName : e(N).name), 1)];
    }), _: 1 }), l(r, { label: "备注：", prop: "remark" }, { default: n(() => [l(V, { modelValue: e(a).remark, "onUpdate:modelValue": t[8] || (t[8] = (o) => e(a).remark = o), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 2, maxRows: 8 }, placeholder: "输入备注", style: { width: "270px" }, maxlength: 300, "show-word-limit": "" }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "附件：", prop: "attachmentList" }, { default: n(() => {
      var o;
      return [l(e(de), { style: { width: "270px" }, files: e(a).attachmentList, "onUpdate:files": t[9] || (t[9] = (d) => e(a).attachmentList = d), showFileList: false, "file-classify": e(re).NORMAL.V, limit: 10 }, null, 8, ["files", "file-classify"]), ((o = e(a).attachmentList) == null ? void 0 : o.length) > 0 ? (h(true), k(Q, { key: 0 }, G(e(a).attachmentList, (d) => (h(), k("div", { class: "attachment-item", key: d.id }, [l(O, { effect: "dark", content: d.name, placement: "top" }, { default: n(() => [u("span", ce, w(d.name), 1)]), _: 2 }, 1032, ["content"]), u("span", fe, [l(se, { size: "small", params: { id: d.id } }, null, 8, ["params"]), l(s, { size: "small", type: "danger", icon: "el-icon-delete", onClick: (_e) => F(d.id) }, null, 8, ["onClick"])])]))), 128)) : W("", true)];
    }), _: 1 })]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, ve = te(be, [["__scopeId", "data-v-7d8a4e8f"]]);
export {
  ve as default
};
