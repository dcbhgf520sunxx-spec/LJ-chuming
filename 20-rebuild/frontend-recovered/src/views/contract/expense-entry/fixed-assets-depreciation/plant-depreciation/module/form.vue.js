import { ref as Q } from "vue";
import p from "moment";
import { computed as f } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as c } from "vue";
import { createBlock as j } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as l } from "vue";
import { unref as t } from "vue";
import { createTextVNode as A } from "vue";
import { createElementBlock as g } from "vue";
import { createCommentVNode as _ } from "vue";
import { toDisplayString as V } from "vue";
import { ElInput as H } from "element-plus";
import { ElFormItem as K } from "element-plus";
import { ElInputNumber as G } from "element-plus";
import { ElDatePicker as J } from "element-plus";
import { ElForm as W } from "element-plus";
import { _ as X, t as Z, jh as $, ao as ee, b as y, i as s, bs as ae } from "../../../../../../shared/runtime.js";
const te = { style: { float: "right" } }, le = { class: "form" }, oe = { key: 0, class: "hint" }, ne = { key: 0, class: "hint" }, re = { key: 0, class: "hint" }, ie = { key: 0, class: "hint" }, de = { __name: "form", props: { branchList: { type: Array, default: () => [] } }, setup(I) {
  const { decimalPrecision: b } = Z(), h = Q(), T = { id: void 0, name: void 0, originalValue: void 0, depreciationYear: void 0, startDate: p().startOf("day").valueOf(), residualValueRate: void 0, type: $.PLANT.V }, { crud: u, form: e, CRUD: D } = ee(T, h), R = (r, a, d) => {
    a || d(new Error("填写数据必须大于0")), d();
  }, q = { name: [{ required: true, message: "请输入名称", trigger: "blur" }], grossFloorArea: [{ required: true, message: "请输入建筑面积", trigger: "blur" }], branchCompanyId: [{ required: true, message: "请选择分支机构", trigger: "change" }], originalValue: [{ required: true, validator: R, trigger: "change" }], depreciationYear: [{ required: true, validator: R, trigger: "change" }], residualValueRate: [{ required: true, validator: (r, a, d) => {
    a || d(new Error("填写数据必须大于0")), a > 100 && d(new Error("填写数据必须小于100")), d();
  }, trigger: "change" }], startDate: [{ required: true, message: "请选择折旧开始日期", trigger: "change" }], endDate: [{ required: true, message: "请选择折旧结束日期", trigger: "change" }] }, C = f(() => e.residualValueRate && e.depreciationYear ? ((100 - e.residualValueRate) / 100 / e.depreciationYear * 100).toFixed(2) : ""), w = f(() => e.originalValue && e.residualValueRate && e.depreciationYear ? (e.originalValue * ((100 - e.residualValueRate) / 100 / e.depreciationYear)).toFixed(b.value.contract) : ""), k = f(() => e.residualValueRate && e.depreciationYear ? ((100 - e.residualValueRate) / 100 / e.depreciationYear / 12 * 100).toFixed(2) : ""), F = f(() => e.originalValue && e.residualValueRate && e.depreciationYear ? (e.originalValue * ((100 - e.residualValueRate) / 100 / e.depreciationYear / 12)).toFixed(b.value.contract) : "");
  function N() {
    if (e.depreciationYear !== void 0 && s(e.endDate)) {
      const r = p(+e.endDate).add(-e.depreciationYear, "years").valueOf(), a = p(r).startOf("day");
      e.startDate = a.valueOf();
    }
  }
  function v() {
    if (e.depreciationYear !== void 0 && s(e.startDate)) {
      const r = p(+e.startDate).add(e.depreciationYear, "years").valueOf(), a = p(r).endOf("day");
      e.endDate = a.valueOf();
    }
  }
  function O() {
    if (s(e.startDate) && s(e.endDate)) {
      const r = p.duration(e.endDate - e.startDate);
      e.depreciationYear = +ae(r.asYears(), 1);
    }
  }
  function z(r) {
    r !== void 0 && (s(e.startDate) ? v() : s(e.endDate) && N());
  }
  function B(r) {
    r !== null && (s(e.endDate) ? O() : e.depreciationYear !== void 0 && v());
  }
  function S(r) {
    r !== null && (s(e.startDate) ? O() : e.depreciationYear !== void 0 && v());
  }
  return D.HOOK.beforeToEdit = (r, a) => {
    a.residualValueRate = +(a.residualValueRate * 100).toFixed(2);
  }, D.HOOK.beforeSubmit = async () => {
    if (!await h.value.validate()) return false;
    e.residualValueRate = (e.residualValueRate / 100).toFixed(4);
  }, (r, a) => {
    const d = x("common-button"), E = H, i = K, P = x("common-select-v2"), Y = G, U = J, M = W, L = x("common-dialog");
    return c(), j(L, { "append-to-body": "", "close-on-click-modal": false, "before-close": t(u).cancelCU, visible: t(u).status.cu > 0, title: t(u).status.title, "show-close": false, width: "500px", top: "10vh" }, { titleRight: n(() => [m("span", te, [l(d, { loading: t(u).status.cu === t(D).STATUS.PROCESSING, size: "default", type: "primary", onClick: t(u).submitCU }, { default: n(() => a[8] || (a[8] = [A(" 提 交 ")])), _: 1, __: [8] }, 8, ["loading", "onClick"]), l(d, { size: "default", onClick: t(u).cancelCU }, { default: n(() => a[9] || (a[9] = [A("关 闭")])), _: 1, __: [9] }, 8, ["onClick"])])]), default: n(() => [m("div", le, [l(M, { ref_key: "formRef", ref: h, model: t(e), rules: q, size: "default", "label-width": "140px", class: "demo-form" }, { default: n(() => [l(i, { label: "名称：", prop: "name" }, { default: n(() => [l(E, { ref: "saveTagInput", modelValue: t(e).name, "onUpdate:modelValue": a[0] || (a[0] = (o) => t(e).name = o), placeholder: "输入名称", style: { width: "270px" }, maxlength: "50" }, null, 8, ["modelValue"])]), _: 1 }), l(i, { label: "建筑面积：", prop: "grossFloorArea" }, { default: n(() => [l(E, { ref: "saveTagInput", type: "number", modelValue: t(e).grossFloorArea, "onUpdate:modelValue": a[1] || (a[1] = (o) => t(e).grossFloorArea = o), placeholder: "输入建筑面积", style: { width: "270px" }, maxlength: "50" }, null, 8, ["modelValue"])]), _: 1 }), l(i, { label: "费用归属：", prop: "branchCompanyId" }, { default: n(() => [l(P, { modelValue: t(e).branchCompanyId, "onUpdate:modelValue": a[2] || (a[2] = (o) => t(e).branchCompanyId = o), options: I.branchList, "data-structure": { key: "id", label: "name", value: "id" }, clearable: "", filterable: "", type: "other", size: "default", placeholder: "请选择分支机构", style: { width: "270px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), l(i, { label: "原值（元）：", prop: "originalValue" }, { default: n(() => [l(Y, { modelValue: t(e).originalValue, "onUpdate:modelValue": a[3] || (a[3] = (o) => t(e).originalValue = o), style: { width: "270px" }, placeholder: "输入原值 单位元", "controls-position": "right", precision: t(b).contract, min: 0, max: 9999999999 }, null, 8, ["modelValue", "precision"])]), _: 1 }), l(i, { label: "折旧年限：", prop: "depreciationYear" }, { default: n(() => [l(Y, { modelValue: t(e).depreciationYear, "onUpdate:modelValue": a[4] || (a[4] = (o) => t(e).depreciationYear = o), style: { width: "270px" }, placeholder: "输入折旧年限", "controls-position": "right", precision: 1, step: 1, min: 0, max: 1e3, onChange: z }, null, 8, ["modelValue"])]), _: 1 }), l(i, { label: "净残值率（%）：", prop: "residualValueRate" }, { default: n(() => [l(Y, { modelValue: t(e).residualValueRate, "onUpdate:modelValue": a[5] || (a[5] = (o) => t(e).residualValueRate = o), style: { width: "270px" }, placeholder: "输入净残值率", "controls-position": "right", precision: 2, min: 0, max: 100 }, null, 8, ["modelValue"])]), _: 1 }), l(i, { label: "折旧开始日期：", prop: "startDate" }, { default: n(() => [l(U, { modelValue: t(e).startDate, "onUpdate:modelValue": a[6] || (a[6] = (o) => t(e).startDate = o), type: "date", size: "default", format: "YYYY-MM-DD", "value-format": "x", clearable: false, placeholder: "选择折旧开始日期", style: { width: "270px" }, onChange: B }, null, 8, ["modelValue"])]), _: 1 }), l(i, { label: "折旧结束日期：", prop: "endDate" }, { default: n(() => [l(U, { modelValue: t(e).endDate, "onUpdate:modelValue": a[7] || (a[7] = (o) => t(e).endDate = o), "default-time": [new Date(2e3, 2, 1, 23, 59, 59)], type: "date", size: "default", format: "YYYY-MM-DD", "value-format": "x", clearable: false, "disabled-date": (o) => t(e).startDate >= o, placeholder: "选择折旧结束日期", style: { width: "270px" }, onChange: S }, null, 8, ["modelValue", "default-time", "disabled-date"])]), _: 1 }), l(i, { label: "年折旧率(%)：", prop: "annualDepreciationRate" }, { default: n(() => [t(y)(C.value) ? (c(), g("span", oe, "根据上方填写内容自动计算")) : _("", true), m("span", null, V(C.value), 1)]), _: 1 }), l(i, { label: "年折旧额(元)：", prop: "annualDepreciationAmount" }, { default: n(() => [t(y)(w.value) ? (c(), g("span", ne, "根据上方填写内容自动计算")) : _("", true), m("span", null, V(w.value), 1)]), _: 1 }), l(i, { label: "月折旧率(%)：", prop: "monthValueDepreciationRate" }, { default: n(() => [t(y)(k.value) ? (c(), g("span", re, "根据上方填写内容自动计算")) : _("", true), m("span", null, V(k.value), 1)]), _: 1 }), l(i, { label: "月折旧额（元）：", prop: "monthValueDepreciationAmount" }, { default: n(() => [t(y)(F.value) ? (c(), g("span", ie, "根据上方填写内容自动计算")) : _("", true), m("span", null, V(F.value), 1)]), _: 1 })]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, me = X(de, [["__scopeId", "data-v-f365c1b5"]]);
export {
  me as default
};
