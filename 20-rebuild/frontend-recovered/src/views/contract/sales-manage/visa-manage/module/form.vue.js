import { computed as N } from "vue";
import { ref as E } from "vue";
import O from "moment";
import { resolveComponent as f } from "vue";
import { openBlock as c } from "vue";
import { createBlock as g } from "vue";
import { withCtx as s } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as T } from "vue";
import { createElementVNode as r } from "vue";
import { withDirectives as B } from "vue";
import { createElementBlock as A } from "vue";
import { toDisplayString as v } from "vue";
import { ElFormItem as F } from "element-plus";
import { ElDatePicker as P } from "element-plus";
import { ElInputNumber as q } from "element-plus";
import { ElInput as z } from "element-plus";
import { ElForm as G } from "element-plus";
import { vLoading as L } from "element-plus";
import { g as H } from "../../../../../modules/visa-manage-fd5a2300.js";
import { _ as K, t as Y, m as $, g8 as M, ao as J, z as Q, cy as W } from "../../../../../shared/runtime.js";
import { _ as X } from "../../../../../modules/project-visa-select-e1b3658e.js";
const Z = { class: "form" }, ee = { class: "rule-row" }, oe = { key: 0 }, te = { class: "rule-row" }, le = { class: "rule-row" }, ae = { class: "rule-row" }, se = { class: "rule-row" }, ne = { class: "rule-row" }, re = { class: "rule-row" }, ie = { class: "rule-row" }, de = { __name: "form", setup(ue) {
  var y;
  const { decimalPrecision: U } = Y(), { user: p } = $("user"), b = N(() => i.status.edit > 0), I = E(), h = { projectId: void 0, visaAmount: void 0, visaDate: O().startOf("day").valueOf(), reasonId: void 0, governmentRegulation: "", supervisionUnit: "", designUnit: "", remark: "", userId: (y = p == null ? void 0 : p.value) == null ? void 0 : y.id }, w = M(["visa_reason"]), { crud: i, form: o, CRUD: d } = J(h, I), j = { projectId: [{ required: true, message: "请选择项目", trigger: "change" }], visaDate: [{ required: true, message: "请选择签证日期", trigger: "change" }], userId: [{ required: true, message: "请选择申请人", trigger: "change" }], reasonId: [{ required: true, message: "请选择签证原因", trigger: "change" }], visaAmount: [{ required: true, message: "请输入签证额", trigger: "blur" }] };
  d.HOOK.afterToAdd = () => {
    setTimeout(() => {
      o.projectId = i.query.projectId, _(o.projectId);
    }, 300);
  }, d.HOOK.beforeEditDetailLoaded = async (u) => {
    o.projectId = o.project.id, _(o.projectId);
  };
  async function _(u) {
    let t = {};
    try {
      u && (t = await H(u));
    } catch {
      i.notify("获取项目详情失败", d.NOTIFICATION_TYPE.ERROR);
    } finally {
      o.customerUnit = t.customerUnit, o.contractSignBodyName = t.contractSignBodyName;
    }
  }
  return (u, t) => {
    const V = f("common-button"), n = F, k = P, x = f("common-select"), R = q, m = z, C = G, D = f("common-drawer"), S = L;
    return c(), g(D, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(i).cancelCU, visible: e(i).status.cu > 0, title: `${b.value ? "编辑" : "新增"}签证单`, "show-close": true, size: "50%" }, { titleRight: s(() => [l(V, { loading: e(i).status.cu === e(d).STATUS.PROCESSING, size: "default", type: "primary", onClick: e(i).submitCU }, { default: s(() => t[9] || (t[9] = [T("提 交")])), _: 1, __: [9] }, 8, ["loading", "onClick"])]), content: s(() => [r("div", Z, [B((c(), g(C, { disabled: e(i).status.cu === e(d).STATUS.PROCESSING, ref_key: "formRef", ref: I, model: e(o), rules: j, size: "default", "label-width": "100px", class: "demo-form" }, { default: s(() => [r("div", ee, [l(n, { label: "项目", prop: "projectId" }, { default: s(() => [b.value ? (c(), A("span", oe, v(e(Q)(e(o).project)), 1)) : (c(), g(e(X), { key: 1, modelValue: e(o).projectId, "onUpdate:modelValue": t[0] || (t[0] = (a) => e(o).projectId = a), clearable: "", class: "input-underline", style: { width: "100%" }, filterSettlement: "", isFilterBusinessType: false, onChange: _ }, null, 8, ["modelValue"]))]), _: 1 })]), r("div", te, [l(n, { label: "施工单位", prop: "contractSignBodyName" }, { default: s(() => [r("span", null, v(e(o).contractSignBodyName), 1)]), _: 1 }), l(n, { label: "发包单位", prop: "customerUnit" }, { default: s(() => [r("span", null, v(e(o).customerUnit), 1)]), _: 1 })]), r("div", le, [l(n, { label: "签证日期", prop: "visaDate" }, { default: s(() => [l(k, { modelValue: e(o).visaDate, "onUpdate:modelValue": t[1] || (t[1] = (a) => e(o).visaDate = a), type: "date", class: "input-underline", "value-format": "x", style: { width: "100%" }, placeholder: "请选择签证日期" }, null, 8, ["modelValue"])]), _: 1 }), l(n, { label: "申请人", prop: "userId" }, { default: s(() => [l(W, { modelValue: e(o).userId, "onUpdate:modelValue": t[2] || (t[2] = (a) => e(o).userId = a), filterable: "", "collapse-tags": false, clearable: "", "show-all-levels": "", class: "input-underline", placeholder: "请选择申请人" }, null, 8, ["modelValue"])]), _: 1 })]), r("div", ae, [l(n, { label: "签证原因", prop: "reasonId" }, { default: s(() => [l(x, { modelValue: e(o).reasonId, "onUpdate:modelValue": t[3] || (t[3] = (a) => e(o).reasonId = a), options: e(w).visa_reason, type: "dict", clearable: "", placeholder: "请选择签证原因", class: "input-underline", style: { width: "100%" }, size: "large" }, null, 8, ["modelValue", "options"])]), _: 1 }), l(n, { label: "签证额", prop: "visaAmount" }, { default: s(() => [l(R, { modelValue: e(o).visaAmount, "onUpdate:modelValue": t[4] || (t[4] = (a) => e(o).visaAmount = a), modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1e3, precision: e(U).contract, class: "input-underline", placeholder: "请输入签证额", controls: false, style: { width: "100%", "text-align": "left" } }, null, 8, ["modelValue", "precision"])]), _: 1 })]), r("div", se, [l(n, { label: "备注", prop: "remark" }, { default: s(() => [l(m, { modelValue: e(o).remark, "onUpdate:modelValue": t[5] || (t[5] = (a) => e(o).remark = a), type: "textarea", autosize: { minRows: 2, maxRows: 4 }, placeholder: "请填写备注", maxlength: "200", "show-word-limit": "" }, null, 8, ["modelValue"])]), _: 1 })]), r("div", ne, [l(n, { label: "监理单位", prop: "supervisionUnit" }, { default: s(() => [l(m, { modelValue: e(o).supervisionUnit, "onUpdate:modelValue": t[6] || (t[6] = (a) => e(o).supervisionUnit = a), placeholder: "请输入监理单位", class: "input-underline", maxlength: "32" }, null, 8, ["modelValue"])]), _: 1 }), l(n, { label: "" })]), r("div", re, [l(n, { label: "设计单位", prop: "designUnit" }, { default: s(() => [l(m, { modelValue: e(o).designUnit, "onUpdate:modelValue": t[7] || (t[7] = (a) => e(o).designUnit = a), placeholder: "请输入设计单位", class: "input-underline", maxlength: "32" }, null, 8, ["modelValue"])]), _: 1 }), l(n, { label: "" })]), r("div", ie, [l(n, { label: "政府监管", prop: "governmentRegulation" }, { default: s(() => [l(m, { modelValue: e(o).governmentRegulation, "onUpdate:modelValue": t[8] || (t[8] = (a) => e(o).governmentRegulation = a), placeholder: "请输入政府监管", class: "input-underline", maxlength: "32" }, null, 8, ["modelValue"])]), _: 1 }), l(n, { label: "" })])]), _: 1 }, 8, ["disabled", "model"])), [[S, e(i).editDetailLoading]])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, fe = K(de, [["__scopeId", "data-v-1c914048"]]);
export {
  fe as default
};
