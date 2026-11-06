import { computed as y } from "vue";
import { ref as T } from "vue";
import { useStore as M } from "vuex";
import { resolveComponent as S } from "vue";
import { resolveDirective as k } from "vue";
import { openBlock as b } from "vue";
import { createBlock as w } from "vue";
import { withCtx as n } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { createTextVNode as f } from "vue";
import { withDirectives as m } from "vue";
import { createElementVNode as t } from "vue";
import { createElementBlock as C } from "vue";
import { toDisplayString as u } from "vue";
import { createCommentVNode as L } from "vue";
import { ElFormItem as G } from "element-plus";
import { ElInputNumber as H } from "element-plus";
import { ElInput as K } from "element-plus";
import { ElForm as $ } from "element-plus";
import { vLoading as Y } from "element-plus";
import { g as J } from "../../../../modules/visa-manage-fd5a2300.js";
import { _ as Q, t as W, m as X, g8 as Z, ao as ee, z as te, bN as oe, ia as v } from "../../../../shared/runtime.js";
import { _ as le } from "../../../../modules/project-visa-select-e1b3658e.js";
const ne = { class: "rule-row" }, ae = { key: 0, class: "project-name" }, se = { class: "rule-row" }, re = { class: "rule-row" }, ue = { class: "rule-row" }, ie = { key: 0 }, de = { class: "rule-row" }, me = { class: "rule-row" }, ce = { class: "rule-row" }, pe = { class: "rule-row" }, _e = { class: "rule-row" }, fe = { __name: "form", setup(ve) {
  const { decimalPrecision: g } = W(), { user: U } = X("user"), A = y(() => d.status.edit > 0), I = y(() => (l.settlementAmount || 0) - (a.value.collectionAmount || 0)), j = y(() => (l.settlementAmount || 0) - (a.value.invoiceAmount || 0)), V = T(), a = T({}), x = M(), D = { projectId: void 0, visaAmount: void 0, settlementDate: void 0, settlementAmount: void 0, breachAmount: void 0, remark: "" }, E = Z(["margin_type"]), { crud: d, form: l, CRUD: p } = ee(D, V), O = { projectId: [{ required: true, message: "请选择项目", trigger: "change" }], settlementDate: [{ required: true, message: "请选择结算日期", trigger: "change" }], breachAmount: [{ required: true, message: "请输入违约金", trigger: "blur" }], settlementAmount: [{ required: true, message: "请输入最终结算额", trigger: "blur" }], visaAmount: [{ required: true, message: "请输入签证额", trigger: "blur" }] };
  p.HOOK.beforeEditDetailLoaded = async (c) => {
    l.projectId = l.project.id, N(l.projectId);
  }, p.HOOK.afterToAdd = () => {
    setTimeout(() => {
      var c;
      l.userId = (c = U.value) == null ? void 0 : c.id;
    }, 300);
  }, p.HOOK.afterAddSuccess = async () => {
    x.dispatch("project/fetchUserVisaProjects");
  };
  async function N(c) {
    a.value = {};
    try {
      c && (a.value = await J(c), A.value || (l.visaAmount = a.value.visaAmount));
    } catch {
      d.notify("获取项目详情失败", p.NOTIFICATION_TYPE.ERROR);
    }
  }
  return (c, r) => {
    const R = S("common-button"), s = G, h = H, F = K, P = $, B = S("common-drawer"), q = k("parse-time"), _ = k("thousand"), z = Y;
    return b(), w(B, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(d).cancelCU, visible: e(d).status.cu > 0, title: `${A.value ? "编辑" : "新增"}结算单`, "show-close": true, size: "50%" }, { titleRight: n(() => [o(R, { loading: e(d).status.cu === e(p).STATUS.PROCESSING, size: "default", type: "primary", onClick: e(d).submitCU }, { default: n(() => r[5] || (r[5] = [f("提 交")])), _: 1, __: [5] }, 8, ["loading", "onClick"])]), content: n(() => [m((b(), w(P, { disabled: e(d).status.cu === e(p).STATUS.PROCESSING, ref_key: "formRef", ref: V, model: e(l), rules: O, size: "default", "label-width": "100px", class: "demo-form" }, { default: n(() => [t("div", ne, [o(s, { label: "项目", prop: "projectId" }, { default: n(() => [A.value ? (b(), C("span", ae, u(e(te)(e(l).project)), 1)) : (b(), w(le, { key: 1, modelValue: e(l).projectId, "onUpdate:modelValue": r[0] || (r[0] = (i) => e(l).projectId = i), clearable: "", filterSettlement: "", style: { width: "100%" }, businessType: e(oe).INSTALLATION.V, onChange: N }, null, 8, ["modelValue", "businessType"]))]), _: 1 }), o(s, { label: "" })]), t("div", se, [o(s, { label: "签约单位", prop: "contractSignBodyName" }, { default: n(() => [t("span", null, u(a.value.contractSignBodyName), 1)]), _: 1 }), o(s, { label: "发包单位", prop: "customerUnit" }, { default: n(() => [t("span", null, u(a.value.customerUnit), 1)]), _: 1 })]), t("div", re, [o(s, { label: "签订日期", prop: "signingDate" }, { default: n(() => [m(t("div", null, null, 512), [[q, { val: a.value.signingDate, fmt: "{y}-{m}-{d}" }]])]), _: 1 }), o(s, { label: "项目经理", prop: "projectManagerName" }, { default: n(() => [t("div", null, u(a.value.projectManagerName), 1)]), _: 1 })]), t("div", ue, [o(s, { label: "保证金额", prop: "marginAmount" }, { default: n(() => [t("div", null, [m(t("span", null, null, 512), [[_, a.value.marginAmount || 0]]), a.value.marginType ? (b(), C("span", ie, "（" + u(e(E).label.margin_type[a.value.marginType]) + "）", 1)) : L("", true)])]), _: 1 }), o(s, { label: "合同额", prop: "contractAmount" }, { default: n(() => [t("div", null, [m(t("span", null, null, 512), [[_, a.value.contractAmount || 0]]), f("（" + u(e(v)(a.value.contractAmount || 0)) + "）", 1)])]), _: 1 })]), t("div", de, [o(s, { label: "签证额", prop: "visaAmount" }, { default: n(() => [o(h, { modelValue: e(l).visaAmount, "onUpdate:modelValue": r[1] || (r[1] = (i) => e(l).visaAmount = i), modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1e3, precision: e(g).project, placeholder: "请输入签证额", controls: false, style: { width: "100%" } }, null, 8, ["modelValue", "precision"])]), _: 1 }), o(s, { label: "违约金额", prop: "breachAmount" }, { default: n(() => [o(h, { modelValue: e(l).breachAmount, "onUpdate:modelValue": r[2] || (r[2] = (i) => e(l).breachAmount = i), modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1e3, precision: e(g).project, placeholder: "请输入违约金额", controls: false, style: { width: "100%" } }, null, 8, ["modelValue", "precision"])]), _: 1 })]), t("div", me, [o(s, { label: "最终结算额", prop: "settlementAmount" }, { default: n(() => [o(h, { modelValue: e(l).settlementAmount, "onUpdate:modelValue": r[3] || (r[3] = (i) => e(l).settlementAmount = i), modelModifiers: { number: true }, min: 0, max: 99999999999, step: 1e3, precision: e(g).project, placeholder: "请输入最终结算额", controls: false, style: { width: "100%" } }, null, 8, ["modelValue", "precision"])]), _: 1 }), o(s, { label: "大写" }, { default: n(() => [t("span", null, u(e(l).settlementAmount ? e(v)(e(l).settlementAmount) : ""), 1)]), _: 1 })]), t("div", ce, [o(s, { label: "已付款", prop: "collectionAmount" }, { default: n(() => [t("div", null, [m(t("span", null, null, 512), [[_, a.value.collectionAmount || 0]]), f("（" + u(e(v)(a.value.collectionAmount || 0)) + "）", 1)])]), _: 1 }), o(s, { label: "欠款额", prop: "debitAmount" }, { default: n(() => [t("div", null, [m(t("span", null, null, 512), [[_, I.value]]), f("（" + u(e(v)(I.value || 0)) + "）", 1)])]), _: 1 })]), t("div", pe, [o(s, { label: "已开票", prop: "invoiceAmount" }, { default: n(() => [t("div", null, [m(t("span", null, null, 512), [[_, a.value.invoiceAmount || 0]]), f("（" + u(e(v)(a.value.invoiceAmount || 0)) + "）", 1)])]), _: 1 }), o(s, { label: "应补发票", prop: "debitInvoice" }, { default: n(() => [t("div", null, [m(t("span", null, null, 512), [[_, j.value]]), f("（" + u(e(v)(j.value || 0)) + "）", 1)])]), _: 1 })]), t("div", _e, [o(s, { label: "备注", prop: "remark" }, { default: n(() => [o(F, { modelValue: e(l).remark, "onUpdate:modelValue": r[4] || (r[4] = (i) => e(l).remark = i), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 2, maxRows: 4 }, placeholder: "请填写备注", maxlength: "200", "show-word-limit": "" }, null, 8, ["modelValue"])]), _: 1 })])]), _: 1 }, 8, ["disabled", "model"])), [[z, e(d).editDetailLoading]])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, ye = Q(fe, [["__scopeId", "data-v-d2320344"]]);
export {
  ye as default
};
