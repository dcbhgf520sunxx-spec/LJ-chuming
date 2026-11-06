import { inject as N } from "vue";
import { useStore as ne } from "vuex";
import { ref as _ } from "vue";
import { reactive as se } from "vue";
import { computed as S } from "vue";
import { onMounted as ie } from "vue";
import { watchEffect as B } from "vue";
import { nextTick as ue } from "vue";
import { resolveComponent as pe } from "vue";
import { resolveDirective as re } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as i } from "vue";
import { createVNode as l } from "vue";
import { withCtx as a } from "vue";
import { createBlock as x } from "vue";
import { createTextVNode as u } from "vue";
import { createCommentVNode as de } from "vue";
import { withDirectives as m } from "vue";
import { unref as U } from "vue";
import { Fragment as D } from "vue";
import { renderList as L } from "vue";
import { normalizeClass as ce } from "vue";
import { createElementVNode as me } from "vue";
import { ElTag as fe } from "element-plus";
import { ElButton as _e } from "element-plus";
import { ElCol as ve } from "element-plus";
import { ElDatePicker as be } from "element-plus";
import { ElFormItem as ye } from "element-plus";
import { ElRow as Ve } from "element-plus";
import { ElInput as ge } from "element-plus";
import { ElOption as we } from "element-plus";
import { ElSelect as Te } from "element-plus";
import { ElCascader as Ie } from "element-plus";
import { ElForm as xe } from "element-plus";
import { ElDivider as Ue } from "element-plus";
import { ElDrawer as Re } from "element-plus";
import { _ as je, bD as Ee, ia as ke, dp as Ae, R as Ne, kS as Se, ec as Be, iV as De, dq as Le, kT as Ce, e2 as Pe, e6 as C, iK as Fe } from "../../../../../../shared/runtime.js";
import { b as qe } from "../../../../../../modules/rules-3ea35934.js";
const ze = { class: "collection-container" }, Oe = { class: "prop-span label" }, He = { class: "prop-span label" }, Ke = { class: "prop-span label" }, Me = { class: "label" }, Qe = { class: "prop-span label" }, $e = { class: "prop-span label" }, Ge = { class: "prop-span label" }, Je = { class: "prop-span label" }, We = { class: "prop-span label" }, Xe = { __name: "billing", props: { level: { type: [Number, String], required: true } }, emits: ["component-mounted"], setup(P, { expose: F, emit: q }) {
  const R = P, z = q, { projectTypeList: O, projectLeaderList: H } = N("selfHeaderData"), { tableRef: K } = N("selfParentData"), M = ne(), v = _(false), V = _(null), Q = Object.values(Ee.V), j = _([]), $ = _([]), g = _(false), t = se({ attachmentId: [], invoiceDate: (/* @__PURE__ */ new Date()).getTime() }), w = _(qe), G = _({ key: "id", value: "id", label: "newSerialNumber" }), E = S(() => t != null && t.invoiceAmount ? ke(t.invoiceAmount) : ""), J = S(() => !(t != null && t.projectId));
  function W() {
    t.invoiceDate = (/* @__PURE__ */ new Date()).getTime();
  }
  const X = async () => {
    try {
      const p = await Se({ projectId: t.projectId, level: R.level }), e = Be([p])[0], { projectAttribute: b, projectManagerName: y, collectionAmountSum: n, userId: T, invoiceUnit: d, projectName: r, collectionUnit: I, invoiceUnitId: f } = e;
      Object.assign(t, { projectAttribute: b, projectManagerName: y, collectionAmountSum: n, writtenById: T, invoiceUnit: d, projectName: r, collectionUnit: I, invoiceUnitId: f }), await Y();
    } catch {
    }
  }, Y = async () => {
    try {
      const { content: p } = await De();
      j.value = p;
    } catch (p) {
      console.log(p);
    }
  }, Z = async () => {
    t.invoiceType === 4 ? (t.taxRateTypeValue = null, w.value.taxRateTypeValue = []) : w.value.taxRateTypeValue = [{ required: true, message: "发票税率不能为空", trigger: ["blur", "change"] }], V.value.validate().then(async () => {
      var p;
      try {
        g.value = true;
        const e = Le(t);
        (p = e == null ? void 0 : e.attachment) != null && p.length && (e.attachmentId = e.attachment.map((b) => b.id)), await Ce({ ...e, level: R.level }), Pe("success", "填报成功"), C(t, {}), $.value = [], v.value = false, await M.dispatch("approval_list/fetchApprovalNum"), await K.value.getSelfProjectList();
      } catch (e) {
        console.log(e);
      } finally {
        g.value = false;
      }
    });
  }, h = async () => {
    t != null && t.attachment && (t.attachment = []), C(t, { sustainable: ["invoiceDate"] });
  }, ee = () => {
    const p = t.invoiceAmount;
    t.invoiceAmount = Fe(p, { allowNegative: true, decimalPlaces: 2 });
  };
  return ie(() => {
    z("component-mounted", true);
  }), B(async () => {
    t != null && t.projectId && await X();
  }), B(() => {
    t.invoiceType === 4 && (t.taxRateTypeValue = null, ue(() => {
      V.value.clearValidate("taxRateTypeValue");
    }));
  }), F({ visible: v }), (p, e) => {
    const b = fe, y = _e, n = ve, T = be, d = ye, r = Ve, I = pe("common-select-v2"), f = ge, k = we, A = Te, le = Ie, te = xe, ae = Ue, oe = Re, c = re("ellipsis");
    return s(), i("div", ze, [l(oe, { modelValue: v.value, "onUpdate:modelValue": e[11] || (e[11] = (o) => v.value = o), "close-on-click-modal": false, "close-on-press-escape": false, "show-close": false, "destroy-on-close": "", size: "40%", onClosed: h, onOpened: W }, { header: a(() => [l(Ae, { "type-one": false, "header-title": "开票填报" }, { subTitle: a(() => [J.value ? (s(), x(b, { key: 0, size: "default", type: "danger" }, { default: a(() => e[12] || (e[12] = [u("请先进行项目选择!")])), _: 1, __: [12] })) : de("", true)]), _: 1 }), l(y, { plain: "", onClick: e[0] || (e[0] = (o) => v.value = false) }, { default: a(() => e[13] || (e[13] = [u("关闭")])), _: 1, __: [13] }), l(y, { loading: g.value, type: "success", onClick: Z }, { default: a(() => e[14] || (e[14] = [u("创建")])), _: 1, __: [14] }, 8, ["loading"])]), default: a(() => [l(te, { ref_key: "formRef", ref: V, model: t, rules: w.value, class: "form-container", "label-position": "left" }, { default: a(() => [l(r, null, { default: a(() => [l(n, { span: 5 }, { default: a(() => [m((s(), i("span", Oe, e[15] || (e[15] = [u("开票日期：")]))), [[c]])]), _: 1 }), l(n, { span: 19 }, { default: a(() => [l(d, { prop: "invoiceDate" }, { default: a(() => [l(T, { modelValue: t.invoiceDate, "onUpdate:modelValue": e[1] || (e[1] = (o) => t.invoiceDate = o), class: "input-border-none", clearable: "", placeholder: "请选择日期", "prefix-icon": "", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(r, null, { default: a(() => [l(n, { span: 5 }, { default: a(() => [m((s(), i("span", He, e[16] || (e[16] = [u("项目：")]))), [[c]])]), _: 1 }), l(n, { span: 19 }, { default: a(() => [l(d, { prop: "projectId" }, { default: a(() => [l(I, { modelValue: t.projectId, "onUpdate:modelValue": e[2] || (e[2] = (o) => t.projectId = o), clearable: true, dataStructure: G.value, filterable: true, options: U(O), class: "input-border-none", placeholder: "请选择或输入项目", type: "other" }, null, 8, ["modelValue", "dataStructure", "options"])]), _: 1 })]), _: 1 })]), _: 1 }), l(r, null, { default: a(() => [l(n, { span: 5 }, { default: a(() => [m((s(), i("span", Ke, e[17] || (e[17] = [u("本次开票：")]))), [[c]])]), _: 1 }), l(n, { span: 19 }, { default: a(() => [l(d, { prop: "invoiceAmount" }, { default: a(() => [l(f, { modelValue: t.invoiceAmount, "onUpdate:modelValue": e[3] || (e[3] = (o) => t.invoiceAmount = o), class: "input-border-none", clearable: "", placeholder: "请输入金额", onInput: ee }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(r, null, { default: a(() => [l(n, { span: 5 }, { default: a(() => [m((s(), i("span", Me, e[18] || (e[18] = [u("大写：")]))), [[c]])]), _: 1 }), l(n, { span: 19 }, { default: a(() => [l(f, { modelValue: E.value, "onUpdate:modelValue": e[4] || (e[4] = (o) => E.value = o), class: "input-border-none", placeholder: "输入本次开票", readonly: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), l(r, null, { default: a(() => [l(n, { span: 5 }, { default: a(() => [m((s(), i("span", Qe, e[19] || (e[19] = [u("发票类型：")]))), [[c]])]), _: 1 }), l(n, { span: 19 }, { default: a(() => [l(d, { prop: "invoiceType" }, { default: a(() => [l(A, { modelValue: t.invoiceType, "onUpdate:modelValue": e[5] || (e[5] = (o) => t.invoiceType = o), class: "input-border-none", clearable: "", placeholder: "请选择发票类型" }, { default: a(() => [(s(true), i(D, null, L(U(Q), (o) => (s(), x(k, { key: o.K, label: o.L, value: o.V }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(r, null, { default: a(() => [l(n, { span: 5 }, { default: a(() => [m((s(), i("span", $e, e[20] || (e[20] = [u("税率：")]))), [[c]])]), _: 1 }), l(n, { span: 19 }, { default: a(() => [l(d, { prop: "taxRateTypeValue" }, { default: a(() => [l(A, { modelValue: t.taxRateTypeValue, "onUpdate:modelValue": e[6] || (e[6] = (o) => t.taxRateTypeValue = o), disabled: t.invoiceType === 4, class: "input-border-none" }, { default: a(() => [(s(true), i(D, null, L(j.value, (o) => (s(), x(k, { key: o.id, label: o.label + "%", value: o.value }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 })]), _: 1 }), l(r, null, { default: a(() => [l(n, { span: 5 }, { default: a(() => [m((s(), i("span", Ge, e[21] || (e[21] = [u("开票单位：")]))), [[c]])]), _: 1 }), l(n, { span: 19 }, { default: a(() => [l(d, { prop: "invoiceUnit" }, { default: a(() => [l(f, { "model-value": t.invoiceUnit, class: "input-border-none", placeholder: "请输入开票单位", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 })]), _: 1 }), l(r, null, { default: a(() => [l(n, { span: 5 }, { default: a(() => [m((s(), i("span", Je, e[22] || (e[22] = [u("收票单位：")]))), [[c]])]), _: 1 }), l(n, { span: 19 }, { default: a(() => [l(d, { prop: "collectionUnit" }, { default: a(() => [l(f, { modelValue: t.collectionUnit, "onUpdate:modelValue": e[7] || (e[7] = (o) => t.collectionUnit = o), class: "input-border-none", clearable: "", placeholder: "请输入收票单位" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(r, null, { default: a(() => [l(n, { span: 5 }, { default: a(() => [m((s(), i("span", { class: ce([{ "prop-span": t.invoiceType !== 4 }, "label"]) }, e[23] || (e[23] = [u("发票号码：")]), 2)), [[c]])]), _: 1 }), l(n, { span: 19 }, { default: a(() => [l(d, { prop: t.invoiceType === 4 ? "" : "invoiceNo" }, { default: a(() => [l(f, { modelValue: t.invoiceNo, "onUpdate:modelValue": e[8] || (e[8] = (o) => t.invoiceNo = o), class: "input-border-none", clearable: "", placeholder: "请输入发票号码" }, null, 8, ["modelValue"])]), _: 1 }, 8, ["prop"])]), _: 1 })]), _: 1 }), l(r, null, { default: a(() => [l(n, { span: 5 }, { default: a(() => [m((s(), i("span", We, e[24] || (e[24] = [u("创建人：")]))), [[c]])]), _: 1 }), l(n, { span: 19 }, { default: a(() => [l(d, { prop: "writtenById" }, { default: a(() => [l(le, { modelValue: t.writtenById, "onUpdate:modelValue": e[9] || (e[9] = (o) => t.writtenById = o), options: U(H), props: { value: "id", emitPath: false }, "show-all-levels": false, class: "input-border-none", clearable: "", filterable: "", placeholder: "请选择或输入创建人" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model", "rules"]), l(ae, null, { default: a(() => e[25] || (e[25] = [me("span", { class: "title" }, "附件", -1)])), _: 1, __: [25] }), l(Ne, { files: t.attachment, "onUpdate:files": e[10] || (e[10] = (o) => t.attachment = o), "empty-text": "暂未上传附件", "show-download": "", showView: "", style: { "margin-top": "10px", padding: "0" } }, null, 8, ["files"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, el = je(Xe, [["__scopeId", "data-v-61c38457"]]);
export {
  el as default
};
