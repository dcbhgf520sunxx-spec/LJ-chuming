import { useRoute as ae } from "vue-router";
import { ref as v } from "vue";
import { inject as x } from "vue";
import { useStore as ne } from "vuex";
import { reactive as se } from "vue";
import { computed as N } from "vue";
import { onMounted as ue } from "vue";
import { watch as de } from "vue";
import { watchEffect as pe } from "vue";
import { resolveComponent as re } from "vue";
import { resolveDirective as ie } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as d } from "vue";
import { createVNode as l } from "vue";
import { withCtx as t } from "vue";
import { createBlock as A } from "vue";
import { createTextVNode as p } from "vue";
import { createCommentVNode as ce } from "vue";
import { unref as k } from "vue";
import { withDirectives as m } from "vue";
import { Fragment as P } from "vue";
import { renderList as R } from "vue";
import { createElementVNode as me } from "vue";
import { ElTag as fe } from "element-plus";
import { ElButton as _e } from "element-plus";
import { ElCol as be } from "element-plus";
import { ElDatePicker as ve } from "element-plus";
import { ElFormItem as ye } from "element-plus";
import { ElRow as Ve } from "element-plus";
import { ElInput as we } from "element-plus";
import { ElOption as ge } from "element-plus";
import { ElSelect as ke } from "element-plus";
import { ElCascader as Ie } from "element-plus";
import { ElForm as Ue } from "element-plus";
import { ElDivider as Be } from "element-plus";
import { ElDrawer as Ae } from "element-plus";
import { _ as Ee, kU as je, ia as Se, dp as De, iv as Ce, R as xe, kV as Ne, bV as Pe, dq as Re, kW as Te, e2 as Le, e6 as T, iK as Fe } from "../../../../../../shared/runtime.js";
import { c as Me } from "../../../../../../modules/rules-3ea35934.js";
const Oe = { class: "collection-container" }, he = { class: "prop-span label" }, qe = { class: "prop-span label" }, ze = { class: "label" }, He = { class: "prop-span label" }, Je = { class: "label" }, Ke = { class: "prop-span label" }, Qe = { class: "prop-span label" }, We = { class: "label" }, $e = { class: "prop-span label" }, Ge = { class: "label" }, Xe = { class: "prop-span label" }, Ye = { __name: "collection", props: { level: { type: [Number, String], required: true } }, emits: ["component-mounted"], setup(L, { expose: F, emit: M }) {
  const y = ae(), V = new je(), E = L, O = M, j = v([]), { projectTypeList: h, projectLeaderList: q } = x("selfHeaderData"), { tableRef: z } = x("selfParentData"), b = v(false), S = v(null), I = v(false), H = v([]), J = ne(), o = se({ collectionDepositBank: null, accessoryId: [], collectionDate: (/* @__PURE__ */ new Date()).getTime() }), K = v({ key: "id", value: "id", label: "newSerialNumber" });
  function Q() {
    o.collectionDate = (/* @__PURE__ */ new Date()).getTime();
  }
  const D = N(() => o != null && o.collectionAmount ? Se(o.collectionAmount) : ""), W = N(() => !(o != null && o.projectId)), $ = async () => {
    try {
      const u = await Ne({ projectId: o == null ? void 0 : o.projectId, level: E.level }), { projectName: e, projectAttribute: _, collectionUnit: w, projectManagerName: n, collectionBankAccount: U, userId: i, paymentDepositBank: r, paymentUnit: B, collectionUnitId: f, collectionAmountSum: g } = u;
      Object.assign(o, { projectName: e, projectAttribute: _, collectionUnit: w, projectManagerName: n, collectionBankAccount: U, writtenById: i, paymentDepositBank: r, paymentUnit: B, collectionUnitId: f, collectionAmountSum: Pe(g) });
    } catch (u) {
      console.error("获取收款列表失败" + u);
    }
  }, G = async () => {
    S.value.validate().then(async () => {
      var u;
      try {
        I.value = true;
        const e = Re(o);
        (u = e == null ? void 0 : e.attachment) != null && u.length && (e.accessoryId = e.attachment.map((_) => _.id)), await Te({ ...e, level: E.level }), Le("success", "填报成功"), T(o, { sustainable: ["collectionDate"] }), H.value = [], b.value = false, await J.dispatch("approval_list/fetchApprovalNum"), await z.value.getSelfProjectList();
      } catch (e) {
        console.error("发起填报失败" + e);
      } finally {
        I.value = false;
      }
    });
  }, X = async () => {
    o != null && o.attachment && (o.attachment = []), T(o, { sustainable: ["collectionDate"] });
  }, Y = () => {
    const u = o.collectionAmount;
    o.collectionAmount = Fe(u, { allowNegative: true, decimalPlaces: 2 });
  }, Z = (u) => {
    let e = [];
    V.get("bk_" + y.fullPath) && (e = JSON.parse(JSON.stringify(V.get("bk_" + y.fullPath)))), e.findIndex((_) => _.label === u) < 0 && e.push({ label: u, value: u }), V.remove("bk_" + y.fullPath), V.set("bk_" + y.fullPath, e);
  };
  return ue(() => {
    O("component-mounted", true);
  }), de(b, (u) => {
    u && (j.value = V.get("bk_" + y.fullPath) || []);
  }), pe(async () => {
    o != null && o.projectId && await $();
  }), F({ visible: b }), (u, e) => {
    const _ = fe, w = _e, n = be, U = ve, i = ye, r = Ve, B = re("common-select-v2"), f = we, g = ge, C = ke, ee = Ie, le = Ue, te = Be, oe = Ae, c = ie("ellipsis");
    return s(), d("div", Oe, [l(oe, { modelValue: b.value, "onUpdate:modelValue": e[12] || (e[12] = (a) => b.value = a), "close-on-click-modal": false, "close-on-press-escape": false, "show-close": false, "destroy-on-close": "", size: "40%", onClosed: X, onOpened: Q }, { header: t(() => [l(De, { "type-one": false, "header-title": "收款填报" }, { subTitle: t(() => [W.value ? (s(), A(_, { key: 0, size: "default", type: "danger" }, { default: t(() => e[13] || (e[13] = [p("请先进行项目选择!")])), _: 1, __: [13] })) : ce("", true)]), _: 1 }), l(w, { plain: "", onClick: e[0] || (e[0] = (a) => b.value = false) }, { default: t(() => e[14] || (e[14] = [p("关闭")])), _: 1, __: [14] }), l(w, { loading: I.value, type: "success", onClick: G }, { default: t(() => e[15] || (e[15] = [p("创建")])), _: 1, __: [15] }, 8, ["loading"])]), default: t(() => [l(le, { ref_key: "formRef", ref: S, model: o, rules: k(Me), class: "form-container", "label-position": "left" }, { default: t(() => [l(r, null, { default: t(() => [l(n, { span: 5 }, { default: t(() => [m((s(), d("span", he, e[16] || (e[16] = [p("收款日期：")]))), [[c]])]), _: 1 }), l(n, { span: 19 }, { default: t(() => [l(i, { prop: "collectionDate" }, { default: t(() => [l(U, { modelValue: o.collectionDate, "onUpdate:modelValue": e[1] || (e[1] = (a) => o.collectionDate = a), class: "input-border-none", clearable: "", placeholder: "请选择日期", "prefix-icon": "", type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(r, null, { default: t(() => [l(n, { span: 5 }, { default: t(() => [m((s(), d("span", qe, e[17] || (e[17] = [p("项目：")]))), [[c]])]), _: 1 }), l(n, { span: 19 }, { default: t(() => [l(i, { prop: "projectId" }, { default: t(() => [l(B, { modelValue: o.projectId, "onUpdate:modelValue": e[2] || (e[2] = (a) => o.projectId = a), dataStructure: K.value, filterable: true, options: k(h), class: "input-border-none", clearable: "", placeholder: "请选择或输入项目", type: "other" }, null, 8, ["modelValue", "dataStructure", "options"])]), _: 1 })]), _: 1 })]), _: 1 }), l(r, null, { default: t(() => [l(n, { span: 5 }, { default: t(() => [m((s(), d("span", ze, e[18] || (e[18] = [p("累计已收款：")]))), [[c]])]), _: 1 }), l(n, { span: 19 }, { default: t(() => [l(f, { modelValue: o.collectionAmountSum, "onUpdate:modelValue": e[3] || (e[3] = (a) => o.collectionAmountSum = a), class: "input-border-none", placeholder: "请先选择项目", readonly: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), l(r, null, { default: t(() => [l(n, { span: 5 }, { default: t(() => [m((s(), d("span", He, e[19] || (e[19] = [p("本次收款：")]))), [[c]])]), _: 1 }), l(n, { span: 19 }, { default: t(() => [l(i, { prop: "collectionAmount" }, { default: t(() => [l(f, { modelValue: o.collectionAmount, "onUpdate:modelValue": e[4] || (e[4] = (a) => o.collectionAmount = a), class: "input-border-none", clearable: "", placeholder: "请输入金额", onInput: Y }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(r, null, { default: t(() => [l(n, { span: 5 }, { default: t(() => [m((s(), d("span", Je, e[20] || (e[20] = [p("大写：")]))), [[c]])]), _: 1 }), l(n, { span: 19 }, { default: t(() => [l(f, { modelValue: D.value, "onUpdate:modelValue": e[5] || (e[5] = (a) => D.value = a), class: "input-border-none", placeholder: "输入本次收款", readonly: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), l(r, null, { default: t(() => [l(n, { span: 5 }, { default: t(() => [m((s(), d("span", Ke, e[21] || (e[21] = [p("收款类型：")]))), [[c]])]), _: 1 }), l(n, { span: 19 }, { default: t(() => [l(i, { prop: "collectionMode" }, { default: t(() => [l(C, { modelValue: o.collectionMode, "onUpdate:modelValue": e[6] || (e[6] = (a) => o.collectionMode = a), class: "input-border-none", clearable: "", placeholder: "请选择收款类型" }, { default: t(() => [(s(true), d(P, null, R(k(Ce).V, (a) => (s(), A(g, { key: a.K, label: a.L, value: a.V }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(r, null, { default: t(() => [l(n, { span: 5 }, { default: t(() => [m((s(), d("span", Qe, e[22] || (e[22] = [p("付款单位：")]))), [[c]])]), _: 1 }), l(n, { span: 19 }, { default: t(() => [l(i, { prop: "paymentUnit" }, { default: t(() => [l(f, { modelValue: o.paymentUnit, "onUpdate:modelValue": e[7] || (e[7] = (a) => o.paymentUnit = a), class: "input-border-none", clearable: "", placeholder: "请输入付款单位" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(r, null, { default: t(() => [l(n, { span: 5 }, { default: t(() => [m((s(), d("span", We, e[23] || (e[23] = [p("付款银行：")]))), [[c]])]), _: 1 }), l(n, { span: 19 }, { default: t(() => [l(i, null, { default: t(() => [l(f, { modelValue: o.paymentDepositBank, "onUpdate:modelValue": e[8] || (e[8] = (a) => o.paymentDepositBank = a), class: "input-border-none", clearable: "", placeholder: "请输入付款银行" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(r, null, { default: t(() => [l(n, { span: 5 }, { default: t(() => [m((s(), d("span", $e, e[24] || (e[24] = [p("收款银行：")]))), [[c]])]), _: 1 }), l(n, { span: 19 }, { default: t(() => [l(i, { prop: "collectionDepositBank" }, { default: t(() => [l(C, { modelValue: o.collectionDepositBank, "onUpdate:modelValue": e[9] || (e[9] = (a) => o.collectionDepositBank = a), filterable: "", class: "input-border-none", "allow-create": "", placeholder: "收款银行", style: { width: "100%" }, onChange: Z }, { default: t(() => [(s(true), d(P, null, R(j.value, (a) => (s(), A(g, { key: a.value, label: a.label, value: a.value }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), l(r, null, { default: t(() => [l(n, { span: 5 }, { default: t(() => [m((s(), d("span", Ge, e[25] || (e[25] = [p("收款单位：")]))), [[c]])]), _: 1 }), l(n, { span: 19 }, { default: t(() => [l(i, null, { default: t(() => [l(f, { "model-value": o.collectionUnit, class: "input-border-none", placeholder: "请先选择项目", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 })]), _: 1 }), l(r, null, { default: t(() => [l(n, { span: 5 }, { default: t(() => [m((s(), d("span", Xe, e[26] || (e[26] = [p("创建人：")]))), [[c]])]), _: 1 }), l(n, { span: 19 }, { default: t(() => [l(i, { prop: "writtenById" }, { default: t(() => [l(ee, { modelValue: o.writtenById, "onUpdate:modelValue": e[10] || (e[10] = (a) => o.writtenById = a), options: k(q), props: { value: "id", emitPath: false }, "show-all-levels": false, class: "input-border-none", clearable: "", filterable: "", placeholder: "请选择或输入创建人" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model", "rules"]), l(te, null, { default: t(() => e[27] || (e[27] = [me("span", { class: "title" }, "附件", -1)])), _: 1, __: [27] }), l(xe, { files: o.attachment, "onUpdate:files": e[11] || (e[11] = (a) => o.attachment = a), "empty-text": "暂未上传附件", "show-download": "", showView: "", style: { "margin-top": "10px", "": "10px", padding: "0" } }, null, 8, ["files"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, tl = Ee(Ye, [["__scopeId", "data-v-3aef77ef"]]);
export {
  tl as default
};
