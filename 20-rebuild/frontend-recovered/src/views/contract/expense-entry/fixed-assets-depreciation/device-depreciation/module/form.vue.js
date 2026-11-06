import { ref as L } from "vue";
import u from "moment";
import { computed as g } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as m } from "vue";
import { createBlock as j } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as l } from "vue";
import { unref as t } from "vue";
import { createTextVNode as F } from "vue";
import { createElementBlock as V } from "vue";
import { createCommentVNode as D } from "vue";
import { toDisplayString as b } from "vue";
import { ElFormItem as G } from "element-plus";
import { ElInput as Q } from "element-plus";
import { ElInputNumber as J } from "element-plus";
import { ElDatePicker as W } from "element-plus";
import { ElForm as X } from "element-plus";
import { _ as Z, t as $, g8 as ee, ao as ae, b as f, i as d, bs as te } from "../../../../../../shared/runtime.js";
const le = { style: { float: "right" } }, oe = { class: "form" }, ie = { key: 0, class: "hint" }, ne = { key: 0, class: "hint" }, re = { key: 0, class: "hint" }, de = { key: 0, class: "hint" }, se = { __name: "form", props: { branchList: { type: Array, default: () => [] } }, setup(E) {
  const { decimalPrecision: h } = $(), y = L(), I = ee(["equipment_depreciation_classification"]), z = { id: void 0, equipmentName: void 0, num: void 0, originalValue: void 0, depreciationYear: void 0, startDate: u().startOf("day").valueOf(), residualValueRate: void 0 }, { crud: s, form: e, CRUD: v } = ae(z, y), _ = (n, a, c) => {
    a || c(new Error("填写数据必须大于0")), c();
  }, A = { classificationName: [{ required: true, message: "请选择分类", trigger: "change" }], branchCompanyId: [{ required: true, message: "请选择费用归属", trigger: "change" }], equipmentName: [{ required: true, message: "请输入设备名称", trigger: "blur" }], num: [{ required: true, validator: _, trigger: "change" }], originalValue: [{ required: true, validator: _, trigger: "change" }], depreciationYear: [{ required: true, validator: _, trigger: "change" }], residualValueRate: [{ required: true, validator: _, trigger: "change" }], startDate: [{ required: true, message: "请选择折旧开始日期", trigger: "change" }], endDate: [{ required: true, message: "请选择折旧结束日期", trigger: "change" }] }, C = g(() => e.residualValueRate && e.depreciationYear ? ((100 - e.residualValueRate) / 100 / e.depreciationYear * 100).toFixed(2) : ""), k = g(() => e.originalValue && e.residualValueRate && e.depreciationYear ? (e.originalValue * ((100 - e.residualValueRate) / 100 / e.depreciationYear)).toFixed(h.value.contract) : ""), q = g(() => e.residualValueRate && e.depreciationYear ? ((100 - e.residualValueRate) / 100 / e.depreciationYear / 12 * 100).toFixed(2) : ""), N = g(() => e.originalValue && e.residualValueRate && e.depreciationYear ? (e.originalValue * ((100 - e.residualValueRate) / 100 / e.depreciationYear / 12)).toFixed(h.value.contract) : "");
  function B() {
    if (e.depreciationYear !== void 0 && d(e.endDate)) {
      const n = u(+e.endDate).add(-e.depreciationYear, "years").valueOf(), a = u(n).startOf("day");
      e.startDate = a.valueOf();
    }
  }
  function Y() {
    if (e.depreciationYear !== void 0 && d(e.startDate)) {
      const n = u(+e.startDate).add(e.depreciationYear, "years").valueOf(), a = u(n).endOf("day");
      e.endDate = a.valueOf();
    }
  }
  function w() {
    if (d(e.startDate) && d(e.endDate)) {
      const n = u.duration(e.endDate - e.startDate);
      e.depreciationYear = +te(n.asYears(), 1);
    }
  }
  function S(n) {
    n !== void 0 && (d(e.startDate) ? Y() : d(e.endDate) && B());
  }
  function T(n) {
    n !== null && (d(e.endDate) ? w() : e.depreciationYear !== void 0 && Y());
  }
  function M(n) {
    n !== null && (d(e.startDate) ? w() : e.depreciationYear !== void 0 && Y());
  }
  return v.HOOK.beforeToEdit = (n, a) => {
    a.residualValueRate = +(a.residualValueRate * 100).toFixed(2), f(a.totalDepreciationAmount) && (a.totalDepreciationAmount = void 0);
  }, v.HOOK.beforeSubmit = async () => {
    if (!await y.value.validate()) return false;
    e.residualValueRate = (e.residualValueRate / 100).toFixed(4);
  }, (n, a) => {
    const c = R("common-button"), O = R("common-select-v2"), r = G, P = Q, x = J, U = W, H = X, K = R("common-dialog");
    return m(), j(K, { "append-to-body": "", "close-on-click-modal": false, "before-close": t(s).cancelCU, visible: t(s).status.cu > 0, title: t(s).status.title, "show-close": false, width: "500px", top: "10vh" }, { titleRight: i(() => [p("span", le, [l(c, { loading: t(s).status.cu === t(v).STATUS.PROCESSING, size: "default", type: "primary", onClick: t(s).submitCU }, { default: i(() => a[8] || (a[8] = [F(" 提 交 ")])), _: 1, __: [8] }, 8, ["loading", "onClick"]), l(c, { size: "default", onClick: t(s).cancelCU }, { default: i(() => a[9] || (a[9] = [F("关 闭")])), _: 1, __: [9] }, 8, ["onClick"])])]), default: i(() => [p("div", oe, [l(H, { ref_key: "formRef", ref: y, model: t(e), rules: A, size: "default", "label-width": "160px", class: "demo-form" }, { default: i(() => [l(r, { label: "分类：", prop: "classificationName" }, { default: i(() => [l(O, { modelValue: t(e).classificationName, "onUpdate:modelValue": a[0] || (a[0] = (o) => t(e).classificationName = o), options: t(I).equipment_depreciation_classification, type: "dict", size: "default", clearable: "", placeholder: "选择设备类型", style: { width: "270px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), l(r, { label: "费用归属：", prop: "branchCompanyId" }, { default: i(() => [l(O, { modelValue: t(e).branchCompanyId, "onUpdate:modelValue": a[1] || (a[1] = (o) => t(e).branchCompanyId = o), options: E.branchList, "data-structure": { key: "id", label: "name", value: "id" }, clearable: "", filterable: "", type: "other", size: "default", placeholder: "请选择分支机构", style: { width: "270px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), l(r, { label: "设备名称：", prop: "equipmentName" }, { default: i(() => [l(P, { modelValue: t(e).equipmentName, "onUpdate:modelValue": a[2] || (a[2] = (o) => t(e).equipmentName = o), placeholder: "输入设备名称", style: { width: "270px" }, maxlength: "50" }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "原值（元）：", prop: "originalValue" }, { default: i(() => [l(x, { modelValue: t(e).originalValue, "onUpdate:modelValue": a[3] || (a[3] = (o) => t(e).originalValue = o), style: { width: "270px" }, placeholder: "输入原值 单位元", "controls-position": "right", precision: t(h).contract, min: 0, max: 9999999999 }, null, 8, ["modelValue", "precision"])]), _: 1 }), l(r, { label: "净残值率（%）：", prop: "residualValueRate" }, { default: i(() => [l(x, { modelValue: t(e).residualValueRate, "onUpdate:modelValue": a[4] || (a[4] = (o) => t(e).residualValueRate = o), style: { width: "270px" }, placeholder: "输入净残值率", "controls-position": "right", precision: 2, min: 0, max: 100 }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "折旧年限：", prop: "depreciationYear" }, { default: i(() => [l(x, { modelValue: t(e).depreciationYear, "onUpdate:modelValue": a[5] || (a[5] = (o) => t(e).depreciationYear = o), style: { width: "270px" }, placeholder: "输入折旧年限", "controls-position": "right", precision: 1, step: 1, min: 0, max: 1e3, onChange: S }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "折旧开始日期：", prop: "startDate" }, { default: i(() => [l(U, { modelValue: t(e).startDate, "onUpdate:modelValue": a[6] || (a[6] = (o) => t(e).startDate = o), type: "date", size: "default", format: "YYYY-MM-DD", "value-format": "x", clearable: false, placeholder: "选择日期", style: { width: "270px" }, onChange: T }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "折旧结束日期：", prop: "endDate" }, { default: i(() => [l(U, { modelValue: t(e).endDate, "onUpdate:modelValue": a[7] || (a[7] = (o) => t(e).endDate = o), "default-time": [new Date(2e3, 2, 1, 23, 59, 59)], type: "date", size: "default", format: "YYYY-MM-DD", "value-format": "x", clearable: false, "disabled-date": (o) => t(e).startDate >= o, placeholder: "选择折旧结束日期", style: { width: "270px" }, onChange: M }, null, 8, ["modelValue", "default-time", "disabled-date"])]), _: 1 }), l(r, { label: "年折旧率(%)：", prop: "annualDepreciationRate" }, { default: i(() => [t(f)(C.value) ? (m(), V("span", ie, "根据上方填写内容自动计算")) : D("", true), p("span", null, b(C.value), 1)]), _: 1 }), l(r, { label: "年折旧额(元)：", prop: "annualDepreciationAmount" }, { default: i(() => [t(f)(k.value) ? (m(), V("span", ne, "根据上方填写内容自动计算")) : D("", true), p("span", null, b(k.value), 1)]), _: 1 }), l(r, { label: "月折旧率(%)：", prop: "monthValueDepreciationRate" }, { default: i(() => [t(f)(q.value) ? (m(), V("span", re, "根据上方填写内容自动计算")) : D("", true), p("span", null, b(q.value), 1)]), _: 1 }), l(r, { label: "月折旧额（元）：", prop: "monthValueDepreciationAmount" }, { default: i(() => [t(f)(N.value) ? (m(), V("span", de, "根据上方填写内容自动计算")) : D("", true), p("span", null, b(N.value), 1)]), _: 1 })]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, ce = Z(se, [["__scopeId", "data-v-225b78c1"]]);
export {
  ce as default
};
