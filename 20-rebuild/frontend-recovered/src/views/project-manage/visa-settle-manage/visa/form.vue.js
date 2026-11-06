import { computed as T } from "vue";
import { ref as C } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as c } from "vue";
import { createBlock as g } from "vue";
import { withCtx as s } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as D } from "vue";
import { createElementVNode as n } from "vue";
import { withDirectives as E } from "vue";
import { createElementBlock as R } from "vue";
import { toDisplayString as u } from "vue";
import { ElFormItem as A } from "element-plus";
import { ElDatePicker as B } from "element-plus";
import { ElInputNumber as O } from "element-plus";
import { ElInput as F } from "element-plus";
import { ElForm as P } from "element-plus";
import { vLoading as q } from "element-plus";
import { g as z } from "../../../../modules/visa-manage-fd5a2300.js";
import { _ as L, t as M, g8 as G, ao as H, z as K, bN as $, cy as Y } from "../../../../shared/runtime.js";
import { _ as J } from "../../../../modules/project-visa-select-e1b3658e.js";
const Q = { class: "form" }, W = { class: "rule-row" }, X = { key: 0, class: "project-name" }, Z = { class: "rule-row" }, ee = { class: "rule-row" }, oe = { class: "rule-row" }, te = { class: "rule-row" }, le = { class: "rule-row" }, ae = { class: "rule-row" }, se = { class: "rule-row" }, re = { class: "rule-row" }, ne = { __name: "form", setup(de) {
  const { decimalPrecision: I } = M(), b = T(() => d.status.edit > 0), v = C(), V = { projectId: void 0, visaAmount: void 0, visaDate: void 0, reasonId: void 0, governmentRegulation: "", supervisionUnit: "", designUnit: "", remark: "", userId: "" }, U = G(["visa_reason"]), { crud: d, form: o, CRUD: i } = H(V, v), w = { projectId: [{ required: true, message: "请选择项目", trigger: "change" }], visaDate: [{ required: true, message: "请选择签证日期", trigger: "change" }], userId: [{ required: true, message: "请选择签证人", trigger: "change" }], reasonId: [{ required: true, message: "请选择签证原因", trigger: "change" }], visaAmount: [{ required: true, message: "请输入签证额", trigger: "blur" }] };
  i.HOOK.afterToAdd = () => {
    setTimeout(() => {
      o.projectId = d.query.projectId, p(o.projectId);
    }, 300);
  }, i.HOOK.beforeEditDetailLoaded = async (m) => {
    o.projectId = o.project.id, p(o.projectId);
  };
  async function p(m) {
    let l = {};
    try {
      m && (l = await z(m));
    } catch {
      d.notify("获取项目详情失败", i.NOTIFICATION_TYPE.ERROR);
    } finally {
      o.customerUnit = l.customerUnit, o.contractSignBodyName = l.contractSignBodyName;
    }
  }
  return (m, l) => {
    const y = f("common-button"), a = A, h = B, j = f("common-select"), N = O, _ = F, S = P, k = f("common-drawer"), x = q;
    return c(), g(k, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(d).cancelCU, visible: e(d).status.cu > 0, title: `${b.value ? "编辑" : "新增"}签证单`, "show-close": true, size: "50%" }, { titleRight: s(() => [t(y, { loading: e(d).status.cu === e(i).STATUS.PROCESSING, size: "default", type: "primary", onClick: e(d).submitCU }, { default: s(() => l[8] || (l[8] = [D("提 交")])), _: 1, __: [8] }, 8, ["loading", "onClick"])]), content: s(() => [n("div", Q, [E((c(), g(S, { disabled: e(d).status.cu === e(i).STATUS.PROCESSING, ref_key: "formRef", ref: v, model: e(o), rules: w, size: "default", "label-width": "100px", class: "demo-form" }, { default: s(() => [n("div", W, [t(a, { label: "项目", prop: "projectId" }, { default: s(() => [b.value ? (c(), R("span", X, u(e(K)(e(o).project)), 1)) : (c(), g(J, { key: 1, modelValue: e(o).projectId, "onUpdate:modelValue": l[0] || (l[0] = (r) => e(o).projectId = r), clearable: "", style: { width: "100%" }, businessType: e($).INSTALLATION.V, onChange: p }, null, 8, ["modelValue", "businessType"]))]), _: 1 }), t(a, { label: "" })]), n("div", Z, [t(a, { label: "申请日期", prop: "visaDate" }, { default: s(() => [t(h, { modelValue: e(o).visaDate, "onUpdate:modelValue": l[1] || (l[1] = (r) => e(o).visaDate = r), type: "date", "value-format": "x", style: { width: "100%" }, placeholder: "申请日期" }, null, 8, ["modelValue"])]), _: 1 }), t(a, { label: "签证人", prop: "userId" }, { default: s(() => [t(Y, { modelValue: e(o).userId, "onUpdate:modelValue": l[2] || (l[2] = (r) => e(o).userId = r), filterable: "", "collapse-tags": false, clearable: "", "show-all-levels": "", placeholder: "签证人" }, null, 8, ["modelValue"])]), _: 1 })]), n("div", ee, [t(a, { label: "施工单位", prop: "contractSignBodyName" }, { default: s(() => [n("span", null, u(e(o).contractSignBodyName), 1)]), _: 1 }), t(a, { label: "发包单位", prop: "customerUnit" }, { default: s(() => [n("span", null, u(e(o).customerUnit), 1)]), _: 1 })]), n("div", oe, [t(a, { label: "签证原因", prop: "reasonId" }, { default: s(() => [t(j, { modelValue: e(o).reasonId, "onUpdate:modelValue": l[3] || (l[3] = (r) => e(o).reasonId = r), options: e(U).visa_reason, type: "dict", clearable: "", placeholder: "请选择签证原因", style: { width: "100%" }, size: "large" }, null, 8, ["modelValue", "options"])]), _: 1 }), t(a, { label: "签证额", prop: "visaAmount" }, { default: s(() => [t(N, { modelValue: e(o).visaAmount, "onUpdate:modelValue": l[4] || (l[4] = (r) => e(o).visaAmount = r), modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1e3, precision: e(I).project, placeholder: "请输入签证额", controls: false, style: { width: "100%", "text-align": "left" } }, null, 8, ["modelValue", "precision"])]), _: 1 })]), n("div", te, [t(a, { label: "说明", prop: "remark" }, { default: s(() => [t(_, { modelValue: e(o).remark, "onUpdate:modelValue": l[5] || (l[5] = (r) => e(o).remark = r), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 2, maxRows: 4 }, placeholder: "请填写备注", maxlength: "200", "show-word-limit": "" }, null, 8, ["modelValue"])]), _: 1 })]), n("div", le, [t(a, { label: "施工单位", prop: "contractSignBodyName" }, { default: s(() => [n("span", null, u(e(o).contractSignBodyName), 1)]), _: 1 }), t(a, { label: "" })]), n("div", ae, [t(a, { label: "设计单位", prop: "designUnit" }, { default: s(() => [t(_, { modelValue: e(o).designUnit, "onUpdate:modelValue": l[6] || (l[6] = (r) => e(o).designUnit = r), modelModifiers: { trim: true }, placeholder: "请输入设计单位", maxlength: "32" }, null, 8, ["modelValue"])]), _: 1 }), t(a, { label: "" })]), n("div", se, [t(a, { label: "监理单位", prop: "supervisionUnit" }, { default: s(() => [t(_, { modelValue: e(o).supervisionUnit, "onUpdate:modelValue": l[7] || (l[7] = (r) => e(o).supervisionUnit = r), modelModifiers: { trim: true }, placeholder: "请输入监理单位", maxlength: "32" }, null, 8, ["modelValue"])]), _: 1 }), t(a, { label: "" })]), n("div", re, [t(a, { label: "发包单位", prop: "customerUnit" }, { default: s(() => [n("span", null, u(e(o).customerUnit), 1)]), _: 1 }), t(a, { label: "" })])]), _: 1 }, 8, ["disabled", "model"])), [[x, e(d).editDetailLoading]])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, pe = L(ne, [["__scopeId", "data-v-f4cd11fb"]]);
export {
  pe as default
};
