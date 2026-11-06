import { computed as T } from "vue";
import { ref as m } from "vue";
import { useStore as G } from "vuex";
import { resolveDirective as J } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as K } from "vue";
import { createVNode as e } from "vue";
import { withCtx as a } from "vue";
import { createBlock as E } from "vue";
import { createTextVNode as y } from "vue";
import { createCommentVNode as W } from "vue";
import { unref as p } from "vue";
import { createElementVNode as d } from "vue";
import { withDirectives as X } from "vue";
import { ElTag as Y } from "element-plus";
import { ElButton as Z } from "element-plus";
import { ElCol as ee } from "element-plus";
import { ElDatePicker as le } from "element-plus";
import { ElFormItem as ae } from "element-plus";
import { ElRow as te } from "element-plus";
import { ElInput as ne } from "element-plus";
import { ElForm as oe } from "element-plus";
import { ElDivider as se } from "element-plus";
import { ElDrawer as de } from "element-plus";
import { _ as ue, ao as re, ia as pe, dp as ie, fv as me, b as _e, j1 as ce, ec as fe, dq as ve, e2 as ge, e6 as _, R as ye } from "../../../../../../shared/runtime.js";
import { a as be } from "../../../../../../modules/self-healing-6f411a5c.js";
const je = { class: "collection-container" }, Ie = { __name: "settle", props: { visible: { type: Boolean } }, emits: ["update:visible"], setup(k, { expose: A, emit: D }) {
  const F = k, b = D, j = { attachmentId: [], settlementTime: (/* @__PURE__ */ new Date()).getTime() };
  function B() {
    j.settlementTime = (/* @__PURE__ */ new Date()).getTime();
  }
  const { crud: I, form: t } = re(j), w = T(() => t != null && t.settlementAmount ? pe(t.settlementAmount) : ""), C = T(() => !(t != null && t.projectId)), M = m(false), R = m(null), q = m([]), c = m(false), N = { settlementTime: [{ required: true, message: "请选择日期", trigger: "change" }], settlementAmount: [{ required: true, message: "请输入结算额", trigger: "change" }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }] }, u = m({}), P = async () => {
    if (!_e(t.projectId)) try {
      let o = await ce.get(`/api/contract/audit/projectLedger/projectDetail?projectId=${t.projectId}`);
      o.paymentRate % 1 === 0 ? o.paymentRate = o.paymentRate.toFixed(0) + "%" : o.paymentRate = o.paymentRate.toFixed(2) + "%", o.invoiceRate % 1 === 0 ? o.invoiceRate = o.invoiceRate.toFixed(0) + "%" : o.invoiceRate = o.invoiceRate.toFixed(2) + "%", o = fe([o]), u.value = o[0];
    } catch (o) {
      console.error("获取项目信息失败:getProjectInfo", o);
    }
  }, U = G(), z = async () => {
    R.value.validate().then(async () => {
      var o;
      try {
        c.value = true;
        const l = ve(t);
        (o = l == null ? void 0 : l.attachment) != null && o.length && (l.attachmentId = Number(l.attachment.map((f) => f.id)[0])), l.projectManagerId = u.value.projectManager.id, await be(l), ge("success", "填报成功"), b("update:visible", false), _(t, { sustainable: ["settlementTime"] }), _(u.value), q.value = [], await I.toQuery(), await U.dispatch("approval_list/fetchApprovalNum"), await V();
      } catch (l) {
        console.log(l);
      } finally {
        c.value = false;
      }
    });
  }, V = async () => {
    t != null && t.attachment && (t.attachment = []), _(t, { sustainable: ["settlementTime"] }), _(u.value), b("update:visible", false);
  }, S = (o) => {
    o.length > 1 && (t.attachment = [o[o.length - 1]]);
  };
  return A({ visible: M }), (o, l) => {
    const f = Y, x = Z, n = ee, h = le, v = ae, i = te, r = ne, L = oe, $ = se, H = ye, O = de, Q = J("ellipsis");
    return g(), K("div", je, [e(O, { "close-on-click-modal": false, "close-on-press-escape": false, "model-value": F.visible, "show-close": false, "destroy-on-close": "", size: "45%", onOpened: B }, { header: a(() => [e(ie, { "type-one": false, "header-title": "项目结算" }, { subTitle: a(() => [C.value ? (g(), E(f, { key: 0, size: "default", type: "danger" }, { default: a(() => l[5] || (l[5] = [y("请先进行项目选择!")])), _: 1, __: [5] })) : W("", true)]), _: 1 }), e(x, { plain: "", onClick: V }, { default: a(() => l[6] || (l[6] = [y("关闭")])), _: 1, __: [6] }), e(x, { loading: c.value, type: "success", onClick: z }, { default: a(() => l[7] || (l[7] = [y("发起审批")])), _: 1, __: [7] }, 8, ["loading"])]), default: a(() => [e(L, { ref_key: "formRef", ref: R, model: p(t), rules: N, class: "form-container", "label-position": "left" }, { default: a(() => [e(i, null, { default: a(() => [e(n, { span: 4 }, { default: a(() => l[8] || (l[8] = [d("span", { class: "prop-span label" }, "结算日期", -1)])), _: 1, __: [8] }), e(n, { span: 8 }, { default: a(() => [e(v, { prop: "settlementTime" }, { default: a(() => [e(h, { modelValue: p(t).settlementTime, "onUpdate:modelValue": l[0] || (l[0] = (s) => p(t).settlementTime = s), clearable: "", placeholder: "请选择日期", "prefix-icon": "", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), e(n, { span: 3 }, { default: a(() => l[9] || (l[9] = [d("span", { class: "prop-span label" }, "项目", -1)])), _: 1, __: [9] }), e(n, { span: 9 }, { default: a(() => [e(v, { prop: "projectId" }, { default: a(() => [e(me, { modelValue: p(t).projectId, "onUpdate:modelValue": l[1] || (l[1] = (s) => p(t).projectId = s), projectManagerId: p(I).query.projectManagerId, class: "filter-item", clearable: "", onChange: P }, null, 8, ["modelValue", "projectManagerId"])]), _: 1 })]), _: 1 })]), _: 1 }), e(i, null, { default: a(() => [e(n, { span: 4 }, { default: a(() => l[10] || (l[10] = [d("span", { class: "label" }, "项目经理", -1)])), _: 1, __: [10] }), e(n, { span: 20 }, { default: a(() => {
      var s;
      return [e(r, { "model-value": (s = u.value.projectManager) == null ? void 0 : s.name, placeholder: "项目经理", readonly: "" }, null, 8, ["model-value"])];
    }), _: 1 })]), _: 1 }), e(i, null, { default: a(() => [e(n, { span: 4 }, { default: a(() => l[11] || (l[11] = [d("span", { class: "label" }, "发包单位", -1)])), _: 1, __: [11] }), e(n, { span: 20 }, { default: a(() => {
      var s;
      return [e(r, { "model-value": (s = u.value.branchComment) == null ? void 0 : s.name, placeholder: "发包单位", readonly: "" }, null, 8, ["model-value"])];
    }), _: 1 })]), _: 1 }), e(i, null, { default: a(() => [e(n, { span: 4 }, { default: a(() => l[12] || (l[12] = [d("span", { class: "label" }, "合同额", -1)])), _: 1, __: [12] }), e(n, { span: 20 }, { default: a(() => [e(r, { "model-value": u.value.contractProjectAmount, placeholder: "合同额", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 }), e(i, null, { default: a(() => [e(n, { span: 4 }, { default: a(() => l[13] || (l[13] = [d("span", { class: "label" }, "累计收款", -1)])), _: 1, __: [13] }), e(n, { span: 8 }, { default: a(() => [e(r, { "model-value": u.value.paymentAmount, placeholder: "累计收款", readonly: "" }, null, 8, ["model-value"])]), _: 1 }), e(n, { span: 4 }, { default: a(() => l[14] || (l[14] = [d("span", { class: "label" }, "收款率", -1)])), _: 1, __: [14] }), e(n, { span: 8 }, { default: a(() => [e(r, { "model-value": u.value.paymentRate, placeholder: "收款率", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 }), e(i, null, { default: a(() => [e(n, { span: 4 }, { default: a(() => l[15] || (l[15] = [d("span", { class: "label" }, "累计开票", -1)])), _: 1, __: [15] }), e(n, { span: 8 }, { default: a(() => [e(r, { "model-value": u.value.invoiceAmount, placeholder: "累计开票", readonly: "" }, null, 8, ["model-value"])]), _: 1 }), e(n, { span: 4 }, { default: a(() => l[16] || (l[16] = [d("span", { class: "label" }, "开票率", -1)])), _: 1, __: [16] }), e(n, { span: 8 }, { default: a(() => [e(r, { "model-value": u.value.invoiceRate, placeholder: "开票率", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 }), e(i, null, { default: a(() => [e(n, { span: 4 }, { default: a(() => l[17] || (l[17] = [d("span", { class: "prop-span label" }, "结算额", -1)])), _: 1, __: [17] }), e(n, { span: 8 }, { default: a(() => [e(v, { prop: "settlementAmount" }, { default: a(() => [e(r, { modelValue: p(t).settlementAmount, "onUpdate:modelValue": l[2] || (l[2] = (s) => p(t).settlementAmount = s), modelModifiers: { number: true }, clearable: "", placeholder: "请输入金额", type: "number" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), e(n, { span: 4 }, { default: a(() => l[18] || (l[18] = [d("span", { class: "label" }, "大写", -1)])), _: 1, __: [18] }), X((g(), E(n, { span: 8 }, { default: a(() => [e(r, { modelValue: w.value, "onUpdate:modelValue": l[3] || (l[3] = (s) => w.value = s), placeholder: "输入结算额", readonly: "" }, null, 8, ["modelValue"])]), _: 1 })), [[Q]])]), _: 1 }), e(i, null, { default: a(() => [e(n, { span: 4 }, { default: a(() => l[19] || (l[19] = [d("span", { class: "label" }, "应收款", -1)])), _: 1, __: [19] }), e(n, { span: 8 }, { default: a(() => [e(r, { "model-value": u.value.remainderPayment, placeholder: "应收款", readonly: "" }, null, 8, ["model-value"])]), _: 1 }), e(n, { span: 4 }, { default: a(() => l[20] || (l[20] = [d("span", { class: "label" }, "应开票", -1)])), _: 1, __: [20] }), e(n, { span: 8 }, { default: a(() => [e(r, { "model-value": u.value.remainderInvoice, placeholder: "应开票", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model"]), e($, null, { default: a(() => l[21] || (l[21] = [d("span", { class: "title" }, "附件", -1)])), _: 1, __: [21] }), e(H, { files: p(t).attachment, "onUpdate:files": [l[4] || (l[4] = (s) => p(t).attachment = s), S], "empty-text": "暂未上传附件", "show-download": "", showView: "", style: { "margin-top": "10px", "": "10px", padding: "0" } }, null, 8, ["files"])]), _: 1 }, 8, ["model-value"])]);
  };
} }, xe = ue(Ie, [["__scopeId", "data-v-458d79f9"]]);
export {
  xe as default
};
