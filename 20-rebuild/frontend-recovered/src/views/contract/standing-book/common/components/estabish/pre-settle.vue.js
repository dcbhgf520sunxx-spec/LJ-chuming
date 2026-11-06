import { useStore as W } from "vuex";
import { inject as I } from "vue";
import { ref as m } from "vue";
import { reactive as X } from "vue";
import { computed as R } from "vue";
import { onMounted as Y } from "vue";
import { watchEffect as j } from "vue";
import { nextTick as Z } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as ee } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as le } from "vue";
import { createVNode as l } from "vue";
import { withCtx as t } from "vue";
import { createBlock as T } from "vue";
import { createTextVNode as g } from "vue";
import { createCommentVNode as te } from "vue";
import { createElementVNode as r } from "vue";
import { unref as ae } from "vue";
import { withDirectives as ne } from "vue";
import { ElTag as oe } from "element-plus";
import { ElButton as se } from "element-plus";
import { ElCol as re } from "element-plus";
import { ElDatePicker as ue } from "element-plus";
import { ElFormItem as de } from "element-plus";
import { ElRow as pe } from "element-plus";
import { ElInput as ie } from "element-plus";
import { ElForm as me } from "element-plus";
import { ElDivider as ce } from "element-plus";
import { ElDrawer as fe } from "element-plus";
import { _ as _e, ia as ve, dp as be, R as ye, j1 as ge, ec as we, dq as Ve, e2 as xe, e6 as f, iK as Ie } from "../../../../../../shared/runtime.js";
import { p as Re } from "../../../../../../modules/self-healing-6f411a5c.js";
const je = { class: "collection-container" }, Te = { class: "remark-container box-container" }, ke = { __name: "pre-settle", props: { level: { type: [Number, String], required: true } }, emits: ["component-mounted"], setup(k, { expose: A, emit: E }) {
  const w = k, S = E, N = W(), { settleList: P } = I("selfHeaderData"), { tableRef: U } = I("selfParentData"), u = m({}), c = m(false), _ = m(null), C = m([]), v = m(false), F = { settlementTime: [{ required: true, message: "请选择日期", trigger: "change" }], settlementAmount: [{ required: true, message: "请输入预结算额", trigger: "change" }, { validator: (o, e, i) => {
    if (Number(e) === 0) return i(new Error("不能为0"));
    i();
  }, trigger: "blur" }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }] }, a = X({ attachmentId: [], settlementTime: (/* @__PURE__ */ new Date()).getTime() }), q = m({ key: "id", value: "id", label: "newSerialNumber" });
  function B() {
    a.settlementTime = (/* @__PURE__ */ new Date()).getTime();
  }
  const V = R(() => a != null && a.settlementAmount ? ve(a.settlementAmount) : ""), D = R(() => !(a != null && a.projectId)), z = async () => {
    try {
      let o = await ge.get(`/api/contract/audit/projectLedger/projectDetail?projectId=${a.projectId}&level=${w.level}`);
      o.paymentRate % 1 === 0 ? o.paymentRate = o.paymentRate.toFixed(0) + "%" : o.paymentRate = o.paymentRate.toFixed(2) + "%", o.invoiceRate % 1 === 0 ? o.invoiceRate = o.invoiceRate.toFixed(0) + "%" : o.invoiceRate = o.invoiceRate.toFixed(2) + "%", o = we([o]), u.value = o[0];
    } catch (o) {
      console.error("获取项目信息失败:getProjectInfo", o);
    }
  }, L = async () => {
    _.value.validate().then(async () => {
      var o;
      try {
        v.value = true;
        const e = Ve(a);
        (o = e == null ? void 0 : e.attachment) != null && o.length && (e.attachmentId = e.attachment.map((i) => i.id)), e.projectManagerId = u.value.projectManager.id, await Re({ ...e, level: w.level }), xe("success", "填报成功"), f(a, {}), f(u.value), C.value = [], c.value = false, await N.dispatch("approval_list/fetchApprovalNum"), await U.value.getSelfProjectList();
      } catch (e) {
        console.log(e);
      } finally {
        v.value = false;
      }
    });
  }, M = async () => {
    a != null && a.attachment && (a.attachment = []), f(a, { sustainable: ["settlementTime"] }), f(u.value);
  }, $ = () => {
    const o = a.settlementAmount;
    a.settlementAmount = Ie(o, { allowNegative: true, decimalPlaces: 2 });
  };
  return Y(() => {
    S("component-mounted", true);
  }), j(async () => {
    a != null && a.projectId ? await z() : u.value = {};
  }), j(() => {
    a.invoiceType === 4 && (a.taxRate = null, Z(() => {
      _.value.clearValidate("taxRate");
    }));
  }), A({ visible: c }), (o, e) => {
    const i = oe, x = se, n = re, H = ue, b = de, K = h("common-select-v2"), p = pe, d = ie, O = me, G = ce, J = fe, Q = ee("ellipsis");
    return y(), le("div", je, [l(J, { modelValue: c.value, "onUpdate:modelValue": e[7] || (e[7] = (s) => c.value = s), "close-on-click-modal": false, "close-on-press-escape": false, "show-close": false, "destroy-on-close": "", size: "45%", onClosed: M, onOpened: B }, { header: t(() => [l(be, { "type-one": false, "header-title": "项目预结算" }, { subTitle: t(() => [D.value ? (y(), T(i, { key: 0, size: "default", type: "danger" }, { default: t(() => e[8] || (e[8] = [g("请先进行项目选择!")])), _: 1, __: [8] })) : te("", true)]), _: 1 }), l(x, { plain: "", onClick: e[0] || (e[0] = (s) => c.value = false) }, { default: t(() => e[9] || (e[9] = [g("关闭")])), _: 1, __: [9] }), l(x, { loading: v.value, type: "success", onClick: L }, { default: t(() => e[10] || (e[10] = [g("发起审批")])), _: 1, __: [10] }, 8, ["loading"])]), default: t(() => [l(O, { ref_key: "formRef", ref: _, model: a, rules: F, class: "form-container", "label-position": "left" }, { default: t(() => [l(p, null, { default: t(() => [l(n, { span: 4 }, { default: t(() => e[11] || (e[11] = [r("span", { class: "prop-span label" }, "结算日期", -1)])), _: 1, __: [11] }), l(n, { span: 8 }, { default: t(() => [l(b, { prop: "settlementTime" }, { default: t(() => [l(H, { modelValue: a.settlementTime, "onUpdate:modelValue": e[1] || (e[1] = (s) => a.settlementTime = s), class: "input-border-none", clearable: "", placeholder: "请选择日期", "prefix-icon": "", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), l(n, { span: 3 }, { default: t(() => e[12] || (e[12] = [r("span", { class: "prop-span label" }, "项目", -1)])), _: 1, __: [12] }), l(n, { span: 9 }, { default: t(() => [l(b, { prop: "projectId" }, { default: t(() => [l(K, { modelValue: a.projectId, "onUpdate:modelValue": e[2] || (e[2] = (s) => a.projectId = s), clearable: true, dataStructure: q.value, filterable: true, options: ae(P), class: "input-border-none", placeholder: "请选择或输入项目", type: "other" }, null, 8, ["modelValue", "dataStructure", "options"])]), _: 1 })]), _: 1 })]), _: 1 }), l(p, null, { default: t(() => [l(n, { span: 4 }, { default: t(() => e[13] || (e[13] = [r("span", { class: "label" }, "销售负责人", -1)])), _: 1, __: [13] }), l(n, { span: 20 }, { default: t(() => {
      var s;
      return [l(d, { "model-value": (s = u.value.projectManager) == null ? void 0 : s.name, class: "input-border-none", placeholder: "销售负责人", readonly: "" }, null, 8, ["model-value"])];
    }), _: 1 })]), _: 1 }), l(p, null, { default: t(() => [l(n, { span: 4 }, { default: t(() => e[14] || (e[14] = [r("span", { class: "label" }, "发包单位", -1)])), _: 1, __: [14] }), l(n, { span: 20 }, { default: t(() => [l(d, { "model-value": u.value.customerUnit, class: "input-border-none", placeholder: "发包单位", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 }), l(p, null, { default: t(() => [l(n, { span: 4 }, { default: t(() => e[15] || (e[15] = [r("span", { class: "label" }, "合同额", -1)])), _: 1, __: [15] }), l(n, { span: 20 }, { default: t(() => [l(d, { "model-value": u.value.contractProjectAmount, class: "input-border-none", placeholder: "合同额", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 }), l(p, null, { default: t(() => [l(n, { span: 4 }, { default: t(() => e[16] || (e[16] = [r("span", { class: "label" }, "累计收款", -1)])), _: 1, __: [16] }), l(n, { span: 8 }, { default: t(() => [l(d, { "model-value": u.value.paymentAmount, class: "input-border-none", placeholder: "累计收款", readonly: "" }, null, 8, ["model-value"])]), _: 1 }), l(n, { span: 4 }, { default: t(() => e[17] || (e[17] = [r("span", { class: "label" }, "收款率", -1)])), _: 1, __: [17] }), l(n, { span: 8 }, { default: t(() => [l(d, { "model-value": u.value.paymentRate, class: "input-border-none", placeholder: "收款率", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 }), l(p, null, { default: t(() => [l(n, { span: 4 }, { default: t(() => e[18] || (e[18] = [r("span", { class: "label" }, "累计开票", -1)])), _: 1, __: [18] }), l(n, { span: 8 }, { default: t(() => [l(d, { "model-value": u.value.invoiceAmount, class: "input-border-none", placeholder: "累计开票", readonly: "" }, null, 8, ["model-value"])]), _: 1 }), l(n, { span: 4 }, { default: t(() => e[19] || (e[19] = [r("span", { class: "label" }, "开票率", -1)])), _: 1, __: [19] }), l(n, { span: 8 }, { default: t(() => [l(d, { "model-value": u.value.invoiceRate, class: "input-border-none", placeholder: "开票率", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 }), l(p, null, { default: t(() => [l(n, { span: 4 }, { default: t(() => e[20] || (e[20] = [r("span", { class: "prop-span label" }, "预结算额", -1)])), _: 1, __: [20] }), l(n, { span: 8 }, { default: t(() => [l(b, { prop: "settlementAmount" }, { default: t(() => [l(d, { modelValue: a.settlementAmount, "onUpdate:modelValue": e[3] || (e[3] = (s) => a.settlementAmount = s), class: "input-border-none", clearable: "", placeholder: "请输入金额", onInput: $ }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), l(n, { span: 4 }, { default: t(() => e[21] || (e[21] = [r("span", { class: "label" }, "大写", -1)])), _: 1, __: [21] }), ne((y(), T(n, { span: 8 }, { default: t(() => [l(d, { modelValue: V.value, "onUpdate:modelValue": e[4] || (e[4] = (s) => V.value = s), class: "input-border-none", placeholder: "输入结算额", readonly: "" }, null, 8, ["modelValue"])]), _: 1 })), [[Q]])]), _: 1 }), l(p, null, { default: t(() => [l(n, { span: 4 }, { default: t(() => e[22] || (e[22] = [r("span", { class: "label" }, "应收款", -1)])), _: 1, __: [22] }), l(n, { span: 8 }, { default: t(() => [l(d, { "model-value": u.value.remainderPayment, class: "input-border-none", placeholder: "应收款", readonly: "" }, null, 8, ["model-value"])]), _: 1 }), l(n, { span: 4 }, { default: t(() => e[23] || (e[23] = [r("span", { class: "label" }, "应开票", -1)])), _: 1, __: [23] }), l(n, { span: 8 }, { default: t(() => [l(d, { "model-value": u.value.remainderInvoice, class: "input-border-none", placeholder: "应开票", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model"]), r("div", Te, [l(d, { modelValue: a.remark, "onUpdate:modelValue": e[5] || (e[5] = (s) => a.remark = s), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), l(G, null, { default: t(() => e[24] || (e[24] = [r("span", { class: "title" }, "附件", -1)])), _: 1, __: [24] }), l(ye, { files: a.attachment, "onUpdate:files": e[6] || (e[6] = (s) => a.attachment = s), "empty-text": "暂未上传附件", "show-download": "", showView: "", style: { "margin-top": "10px", padding: "0" } }, null, 8, ["files"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, Ne = _e(ke, [["__scopeId", "data-v-c2fc4f17"]]);
export {
  Ne as default
};
