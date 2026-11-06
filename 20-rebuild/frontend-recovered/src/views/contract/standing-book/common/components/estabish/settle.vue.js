import { useStore as J } from "vuex";
import { inject as x } from "vue";
import { ref as m } from "vue";
import { reactive as Q } from "vue";
import { computed as V } from "vue";
import { onMounted as W } from "vue";
import { watchEffect as R } from "vue";
import { nextTick as Y } from "vue";
import { resolveComponent as Z } from "vue";
import { resolveDirective as ee } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as le } from "vue";
import { createVNode as e } from "vue";
import { withCtx as t } from "vue";
import { createBlock as k } from "vue";
import { createTextVNode as w } from "vue";
import { createCommentVNode as te } from "vue";
import { createElementVNode as r } from "vue";
import { unref as ae } from "vue";
import { withDirectives as ne } from "vue";
import { ElMessageBox as oe } from "element-plus";
import { ElTag as se } from "element-plus";
import { ElButton as ue } from "element-plus";
import { ElCol as re } from "element-plus";
import { ElDatePicker as de } from "element-plus";
import { ElFormItem as pe } from "element-plus";
import { ElRow as ie } from "element-plus";
import { ElInput as me } from "element-plus";
import { ElForm as ce } from "element-plus";
import { ElDivider as _e } from "element-plus";
import { ElDrawer as fe } from "element-plus";
import { _ as ve, ia as be, dp as ye, R as ge, j1 as we, ec as je, kX as Ie, dq as xe, e2 as Ve, e6 as f, iK as Re } from "../../../../../../shared/runtime.js";
import { s as ke, a as Te } from "../../../../../../modules/self-healing-6f411a5c.js";
const Ae = { class: "collection-container" }, Ee = { __name: "settle", props: { level: { type: [Number, String], required: true } }, emits: ["component-mounted"], setup(T, { expose: A, emit: E }) {
  const j = T, C = E, P = J(), { settleList: S } = x("selfHeaderData"), { tableRef: B } = x("selfParentData"), u = m({}), c = m(false), v = m(null), N = m([]), b = m(false), F = { settlementTime: [{ required: true, message: "请选择日期", trigger: "change" }], settlementAmount: [{ required: true, message: "请输入结算额", trigger: "change" }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }] }, a = Q({ attachmentId: [], settlementTime: (/* @__PURE__ */ new Date()).getTime() }), U = m({ key: "id", value: "id", label: "newSerialNumber" });
  function q() {
    a.settlementTime = (/* @__PURE__ */ new Date()).getTime();
  }
  const I = V(() => a != null && a.settlementAmount ? be(a.settlementAmount) : ""), D = V(() => !(a != null && a.projectId)), L = async () => {
    try {
      let o = await we.get(`/api/contract/audit/projectLedger/projectDetail?projectId=${a.projectId}&level=${j.level}`);
      o.paymentRate % 1 === 0 ? o.paymentRate = o.paymentRate.toFixed(0) + "%" : o.paymentRate = o.paymentRate.toFixed(2) + "%", o.invoiceRate % 1 === 0 ? o.invoiceRate = o.invoiceRate.toFixed(0) + "%" : o.invoiceRate = o.invoiceRate.toFixed(2) + "%", o = je([o]), u.value = o[0];
    } catch (o) {
      console.error("获取项目信息失败:getProjectInfo", o);
    }
  }, M = async () => {
    v.value.validate().then(async () => {
      var o;
      try {
        const l = await ke({ projectId: a == null ? void 0 : a.projectId });
        l.boolCheckPassed || await oe.confirm(`该项目下还存有${Ie.VL[l.type]}, 请确认是否结算？`, "再次确认提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), b.value = true;
        const p = xe(a);
        (o = p == null ? void 0 : p.attachment) != null && o.length && (p.attachmentId = p.attachment.map((_) => _.id)), p.projectManagerId = u.value.projectManager.id, await Te({ ...p, level: j.level }), Ve("success", "填报成功"), f(a, {}), f(u.value), N.value = [], c.value = false, await P.dispatch("approval_list/fetchApprovalNum"), await B.value.getSelfProjectList();
      } catch (l) {
        console.log(l);
      } finally {
        b.value = false;
      }
    });
  }, $ = async () => {
    a != null && a.attachment && (a.attachment = []), f(a, { sustainable: ["settlementTime"] }), f(u.value);
  }, z = () => {
    const o = a.settlementAmount;
    a.settlementAmount = Re(o, { allowNegative: false, decimalPlaces: 2 });
  };
  return W(() => {
    C("component-mounted", true);
  }), R(async () => {
    a != null && a.projectId ? await L() : u.value = {};
  }), R(() => {
    a.invoiceType === 4 && (a.taxRate = null, Y(() => {
      v.value.clearValidate("taxRate");
    }));
  }), A({ visible: c }), (o, l) => {
    const p = se, _ = ue, n = re, H = de, y = pe, h = Z("common-select-v2"), i = ie, d = me, K = ce, O = _e, X = fe, G = ee("ellipsis");
    return g(), le("div", Ae, [e(X, { modelValue: c.value, "onUpdate:modelValue": l[6] || (l[6] = (s) => c.value = s), "close-on-click-modal": false, "close-on-press-escape": false, "show-close": false, "destroy-on-close": "", size: "45%", onClosed: $, onOpened: q }, { header: t(() => [e(ye, { "type-one": false, "header-title": "项目结算" }, { subTitle: t(() => [D.value ? (g(), k(p, { key: 0, size: "default", type: "danger" }, { default: t(() => l[7] || (l[7] = [w("请先进行项目选择!")])), _: 1, __: [7] })) : te("", true)]), _: 1 }), e(_, { plain: "", onClick: l[0] || (l[0] = (s) => c.value = false) }, { default: t(() => l[8] || (l[8] = [w("关闭")])), _: 1, __: [8] }), e(_, { loading: b.value, type: "success", onClick: M }, { default: t(() => l[9] || (l[9] = [w("发起审批")])), _: 1, __: [9] }, 8, ["loading"])]), default: t(() => [e(K, { ref_key: "formRef", ref: v, model: a, rules: F, class: "form-container", "label-position": "left" }, { default: t(() => [e(i, null, { default: t(() => [e(n, { span: 4 }, { default: t(() => l[10] || (l[10] = [r("span", { class: "prop-span label" }, "结算日期", -1)])), _: 1, __: [10] }), e(n, { span: 8 }, { default: t(() => [e(y, { prop: "settlementTime" }, { default: t(() => [e(H, { modelValue: a.settlementTime, "onUpdate:modelValue": l[1] || (l[1] = (s) => a.settlementTime = s), class: "input-border-none", clearable: "", placeholder: "请选择日期", "prefix-icon": "", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), e(n, { span: 3 }, { default: t(() => l[11] || (l[11] = [r("span", { class: "prop-span label" }, "项目", -1)])), _: 1, __: [11] }), e(n, { span: 9 }, { default: t(() => [e(y, { prop: "projectId" }, { default: t(() => [e(h, { modelValue: a.projectId, "onUpdate:modelValue": l[2] || (l[2] = (s) => a.projectId = s), clearable: true, dataStructure: U.value, filterable: true, options: ae(S), class: "input-border-none", placeholder: "请选择或输入项目", type: "other" }, null, 8, ["modelValue", "dataStructure", "options"])]), _: 1 })]), _: 1 })]), _: 1 }), e(i, null, { default: t(() => [e(n, { span: 4 }, { default: t(() => l[12] || (l[12] = [r("span", { class: "label" }, "销售负责人", -1)])), _: 1, __: [12] }), e(n, { span: 20 }, { default: t(() => {
      var s;
      return [e(d, { "model-value": (s = u.value.projectManager) == null ? void 0 : s.name, class: "input-border-none", placeholder: "销售负责人", readonly: "" }, null, 8, ["model-value"])];
    }), _: 1 })]), _: 1 }), e(i, null, { default: t(() => [e(n, { span: 4 }, { default: t(() => l[13] || (l[13] = [r("span", { class: "label" }, "发包单位", -1)])), _: 1, __: [13] }), e(n, { span: 20 }, { default: t(() => [e(d, { "model-value": u.value.customerUnit, class: "input-border-none", placeholder: "发包单位", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 }), e(i, null, { default: t(() => [e(n, { span: 4 }, { default: t(() => l[14] || (l[14] = [r("span", { class: "label" }, "合同额", -1)])), _: 1, __: [14] }), e(n, { span: 20 }, { default: t(() => [e(d, { "model-value": u.value.contractProjectAmount, class: "input-border-none", placeholder: "合同额", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 }), e(i, null, { default: t(() => [e(n, { span: 4 }, { default: t(() => l[15] || (l[15] = [r("span", { class: "label" }, "累计收款", -1)])), _: 1, __: [15] }), e(n, { span: 8 }, { default: t(() => [e(d, { "model-value": u.value.paymentAmount, class: "input-border-none", placeholder: "累计收款", readonly: "" }, null, 8, ["model-value"])]), _: 1 }), e(n, { span: 4 }, { default: t(() => l[16] || (l[16] = [r("span", { class: "label" }, "收款率", -1)])), _: 1, __: [16] }), e(n, { span: 8 }, { default: t(() => [e(d, { "model-value": u.value.paymentRate, class: "input-border-none", placeholder: "收款率", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 }), e(i, null, { default: t(() => [e(n, { span: 4 }, { default: t(() => l[17] || (l[17] = [r("span", { class: "label" }, "累计开票", -1)])), _: 1, __: [17] }), e(n, { span: 8 }, { default: t(() => [e(d, { "model-value": u.value.invoiceAmount, class: "input-border-none", placeholder: "累计开票", readonly: "" }, null, 8, ["model-value"])]), _: 1 }), e(n, { span: 4 }, { default: t(() => l[18] || (l[18] = [r("span", { class: "label" }, "开票率", -1)])), _: 1, __: [18] }), e(n, { span: 8 }, { default: t(() => [e(d, { "model-value": u.value.invoiceRate, class: "input-border-none", placeholder: "开票率", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 }), e(i, null, { default: t(() => [e(n, { span: 4 }, { default: t(() => l[19] || (l[19] = [r("span", { class: "prop-span label" }, "结算额", -1)])), _: 1, __: [19] }), e(n, { span: 8 }, { default: t(() => [e(y, { prop: "settlementAmount" }, { default: t(() => [e(d, { modelValue: a.settlementAmount, "onUpdate:modelValue": l[3] || (l[3] = (s) => a.settlementAmount = s), class: "input-border-none", clearable: "", placeholder: "请输入金额", onInput: z }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), e(n, { span: 4 }, { default: t(() => l[20] || (l[20] = [r("span", { class: "label" }, "大写", -1)])), _: 1, __: [20] }), ne((g(), k(n, { span: 8 }, { default: t(() => [e(d, { modelValue: I.value, "onUpdate:modelValue": l[4] || (l[4] = (s) => I.value = s), class: "input-border-none", placeholder: "输入结算额", readonly: "" }, null, 8, ["modelValue"])]), _: 1 })), [[G]])]), _: 1 }), e(i, null, { default: t(() => [e(n, { span: 4 }, { default: t(() => l[21] || (l[21] = [r("span", { class: "label" }, "应收款", -1)])), _: 1, __: [21] }), e(n, { span: 8 }, { default: t(() => [e(d, { "model-value": u.value.remainderPayment, class: "input-border-none", placeholder: "应收款", readonly: "" }, null, 8, ["model-value"])]), _: 1 }), e(n, { span: 4 }, { default: t(() => l[22] || (l[22] = [r("span", { class: "label" }, "应开票", -1)])), _: 1, __: [22] }), e(n, { span: 8 }, { default: t(() => [e(d, { "model-value": u.value.remainderInvoice, class: "input-border-none", placeholder: "应开票", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model"]), e(O, null, { default: t(() => l[23] || (l[23] = [r("span", { class: "title" }, "附件", -1)])), _: 1, __: [23] }), e(ge, { files: a.attachment, "onUpdate:files": l[5] || (l[5] = (s) => a.attachment = s), "empty-text": "暂未上传附件", "show-download": "", showView: "", style: { "margin-top": "10px", "": "10px", padding: "0" } }, null, 8, ["files"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, Be = ve(Ee, [["__scopeId", "data-v-116572d6"]]);
export {
  Be as default
};
