import { ref as b } from "vue";
import { inject as g } from "vue";
import { watch as q } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as V } from "vue";
import { createBlock as P } from "vue";
import { withCtx as n } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as T } from "vue";
import { createElementVNode as Y } from "vue";
import { unref as i } from "vue";
import { createElementBlock as k } from "vue";
import { Fragment as M } from "vue";
import { renderList as H } from "vue";
import { toDisplayString as $ } from "vue";
import { createCommentVNode as G } from "vue";
import { isRef as J } from "vue";
import { ElNotification as K } from "element-plus";
import { ElDatePicker as Q } from "element-plus";
import { ElFormItem as W } from "element-plus";
import { ElInputNumber as X } from "element-plus";
import { ElInput as Z } from "element-plus";
import { ElForm as ee } from "element-plus";
import { l as p, _ as te, t as ae, u as le, S as oe, L as ne, V as se } from "../../../../../shared/runtime.js";
import { _ as ie } from "../../../../../modules/UploadBtn-b4cfb47a.js";
function _e(o) {
  return p({ module: "", url: "/api/contract/testing-fee", method: "get", params: o });
}
function re(o) {
  return p({ module: "", url: "/api/contract/testing-fee/summary", method: "get", params: o });
}
function x(o) {
  return p({ module: "", url: "/api/contract/testing-fee", method: "post", data: [o] });
}
function C(o) {
  return p({ module: "", url: "/api/contract/testing-fee", method: "put", data: [o] });
}
function de(o) {
  return p({ module: "", url: "/api/contract/testing-fee", method: "delete", data: o });
}
const ve = { get: re, add: x, edit: C, del: de };
const ue = { class: "form" }, me = { __name: "form", props: { visible: { type: Boolean, default: false }, showType: { type: String }, info: { type: Object, default: () => {
} } }, emits: ["update:visible", "refresh", "success"], setup(o, { emit: D }) {
  const { decimalPrecision: F } = ae(), c = D, r = o, { visible: f, handleClose: w } = le({ emit: c, props: r, field: "visible", showHook: N }), e = b({ payDate: void 0, testingFeeTypeId: void 0, feeAmount: void 0, attachmentIds: void 0, attachmentFiles: [], branchCompanyId: void 0 }), I = b(), y = b(false), j = g("dict"), B = g("projectList"), A = g("branchList"), E = { payDate: [{ required: true, message: "请选择支付时间", trigger: "blur" }], branchCompanyId: [{ required: true, message: "请选择费用归属", trigger: "change" }], testingFeeTypeId: [{ required: true, message: "请选择检测费类别", trigger: "blur" }], feeAmount: [{ required: true, message: "请输入费用", trigger: "blur" }] };
  function N() {
    r.showType === "addBtn" && (e.value = {});
  }
  q(() => r.visible, (u) => {
    r.showType !== "addBtn" && (e.value = Object.assign(e.value, r.info));
  }, { immediate: true });
  async function U() {
    var u;
    try {
      if (y.value = true, !await I.value.validate()) return false;
      const s = se(e.value);
      s.attachmentIds = s.attachmentIds ? [Number(s.attachmentIds)] : (u = s.attachmentFiles) == null ? void 0 : u.map((_) => _.id), s.attachments = s.attachmentFiles, r.showType === "addBtn" ? await x(s) : await C(s), K({ title: r.showType === "addBtn" ? "新增成功" : "编辑成功", type: "success" }), w(), c("success"), c("refresh");
    } catch (t) {
      console.log("新增失败", t);
    } finally {
      y.value = false;
    }
  }
  function L(u) {
    return u > /* @__PURE__ */ new Date();
  }
  return (u, t) => {
    const s = h("common-button"), _ = Q, d = W, v = h("common-select-v2"), R = X, S = Z, z = ee, O = h("common-dialog");
    return V(), P(O, { modelValue: i(f), "onUpdate:modelValue": t[7] || (t[7] = (l) => J(f) ? f.value = l : null), "before-close": i(w), title: o.showType === "addBtn" ? "新增检测费" : "编辑检测费", width: "500px" }, { titleRight: n(() => [a(s, { loading: y.value, type: "primary", size: "default", onClick: U }, { default: n(() => t[8] || (t[8] = [T(" 提 交 ")])), _: 1, __: [8] }, 8, ["loading"])]), default: n(() => [Y("div", ue, [a(z, { ref_key: "formRef", ref: I, model: e.value, rules: E, size: "default", "label-width": "140px", class: "demo-form" }, { default: n(() => [a(d, { label: "支付时间：", prop: "payDate" }, { default: n(() => [a(_, { modelValue: e.value.payDate, "onUpdate:modelValue": t[0] || (t[0] = (l) => e.value.payDate = l), type: "date", size: "default", class: "date-item filter-item", placeholder: "选择日期", format: "YYYY-MM-DD", "value-format": "x", "disabled-date": L, style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), a(d, { label: "费用归属：", prop: "branchCompanyId" }, { default: n(() => [a(v, { modelValue: e.value.branchCompanyId, "onUpdate:modelValue": t[1] || (t[1] = (l) => e.value.branchCompanyId = l), "data-structure": { key: "id", label: "name", value: "id" }, options: i(A), clearable: "", filterable: "", placeholder: "请选择分支机构", style: { width: "270px" }, type: "other" }, null, 8, ["modelValue", "options"])]), _: 1 }), a(d, { label: "项目：", prop: "projectId" }, { default: n(() => [a(v, { modelValue: e.value.projectId, "onUpdate:modelValue": t[2] || (t[2] = (l) => e.value.projectId = l), "data-structure": { key: "id", label: "name", value: "id" }, options: i(B), class: "filter-item", clearable: "", filterable: "", placeholder: "选择项目", style: { width: "270px" }, type: "other" }, null, 8, ["modelValue", "options"])]), _: 1 }), a(d, { label: "检测费类别：", prop: "testingFeeTypeId" }, { default: n(() => [a(v, { modelValue: e.value.testingFeeTypeId, "onUpdate:modelValue": t[3] || (t[3] = (l) => e.value.testingFeeTypeId = l), "data-structure": { key: "id", label: "label", value: "id" }, options: i(j).testing_fee_type, class: "filter-item", clearable: "", placeholder: "选择检测费类别", style: { width: "270px" }, type: "other" }, null, 8, ["modelValue", "options"])]), _: 1 }), a(d, { label: "费用：", prop: "feeAmount" }, { default: n(() => [a(R, { modelValue: e.value.feeAmount, "onUpdate:modelValue": t[4] || (t[4] = (l) => e.value.feeAmount = l), controls: false, max: 9999999999, min: 0, precision: i(F).contract, placeholder: "输入费用 单位（元）", style: { width: "270px" } }, null, 8, ["modelValue", "precision"])]), _: 1 }), a(d, { label: "附件：", prop: "attachments" }, { default: n(() => {
      var l;
      return [a(i(ie), { ref: "uploadRef", files: e.value.attachmentFiles, "onUpdate:files": t[5] || (t[5] = (m) => e.value.attachmentFiles = m), accept: ".pdf,.jpg,.jpeg,.png", "file-classify": i(oe).CONTRACT_ATT.V, limit: 1 }, null, 8, ["files", "file-classify"]), ((l = e.value.attachments) == null ? void 0 : l.length) > 0 ? (V(true), k(M, { key: 0 }, H(e.value.attachments, (m) => (V(), k("div", { key: m.id }, [T($(m.name) + " ", 1), a(ne, { params: { id: m.id } }, null, 8, ["params"])]))), 128)) : G("", true)];
    }), _: 1 }), a(d, { label: "备注：", prop: "remark" }, { default: n(() => [a(S, { ref: "saveTagInput", modelValue: e.value.remark, "onUpdate:modelValue": t[6] || (t[6] = (l) => e.value.remark = l), placeholder: "输入备注", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["modelValue", "before-close", "title"]);
  };
} }, pe = te(me, [["__scopeId", "data-v-a75e3145"]]), be = Object.freeze(Object.defineProperty({ __proto__: null, default: pe }, Symbol.toStringTag, { value: "Module" }));
export {
  ve as c,
  de as d,
  be as f,
  _e as g,
  pe as m
};
