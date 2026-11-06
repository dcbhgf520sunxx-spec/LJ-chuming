import { inject as $ } from "vue";
import { reactive as H } from "vue";
import { computed as V } from "vue";
import { ref as i } from "vue";
import { watchEffect as G } from "vue";
import { watch as J } from "vue";
import { resolveDirective as K } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as O } from "vue";
import { createVNode as e } from "vue";
import { withCtx as a } from "vue";
import { createBlock as E } from "vue";
import { createTextVNode as b } from "vue";
import { createCommentVNode as Q } from "vue";
import { createElementVNode as u } from "vue";
import { withDirectives as W } from "vue";
import { ElTag as X } from "element-plus";
import { ElButton as Y } from "element-plus";
import { ElCol as Z } from "element-plus";
import { ElDatePicker as ee } from "element-plus";
import { ElFormItem as le } from "element-plus";
import { ElInput as ae } from "element-plus";
import { ElRow as te } from "element-plus";
import { ElForm as se } from "element-plus";
import { ElDivider as ne } from "element-plus";
import { ElDrawer as oe } from "element-plus";
import { _ as de, ia as ue, dp as re, fv as pe, j1 as ie, ec as me, dq as _e, e2 as ce, e6 as m, R as fe } from "../../../../../../../../shared/runtime.js";
import { a as ve } from "../../../../../../../../modules/self-healing-6f411a5c.js";
const be = { class: "collection-container" }, ye = { __name: "settle", props: { visible: { type: Boolean } }, emits: ["update:visible"], setup(T, { expose: x, emit: k }) {
  const y = T, g = k, { projectInfo: A } = $("info_parent_data"), t = H({ attachmentId: [], settlementTime: (/* @__PURE__ */ new Date()).getTime() }), j = V(() => t != null && t.settlementAmount ? ue(t.settlementAmount) : ""), R = V(() => !(t != null && t.projectId)), B = i(false), w = i(null), C = i([]), _ = i(false), P = { settlementTime: [{ required: true, message: "请选择日期", trigger: "change" }], settlementAmount: [{ required: true, message: "请输入结算额", trigger: "change" }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }] }, d = i({}), U = async () => {
    try {
      let n = await ie.get(`/api/contract/audit/projectLedger/projectDetail?projectId=${t.projectId}`);
      n.paymentRate += "%", n.invoiceRate += "%", n = me([n]), d.value = n[0];
    } catch (n) {
      console.error("获取项目信息失败:getProjectInfo", n);
    }
  }, q = async () => {
    w.value.validate().then(async () => {
      var n;
      try {
        _.value = true;
        const l = _e(t);
        (n = l == null ? void 0 : l.attachment) != null && n.length && (l.attachmentId = Number(l.attachment.map((c) => c.id)[0])), l.projectManagerId = d.value.projectManager.id, await ve(l), ce("success", "填报成功"), g("update:visible", false), m(t, { sustainable: ["settlementTime"] }), m(d.value), C.value = [];
      } catch (l) {
        console.log(l);
      } finally {
        _.value = false;
      }
    });
  }, F = async () => {
    t != null && t.attachment && (t.attachment = []), m(t, { sustainable: ["settlementTime"] }), m(d.value), g("update:visible", false);
  };
  G(async () => {
    t != null && t.projectId ? await U() : d.value = {};
  });
  const N = (n) => {
    n.length > 1 && (t.attachment = [n[n.length - 1]]);
  };
  return J(() => y.visible, async (n) => {
    n && (t.projectId = A.project.id);
  }, { immediate: true }), x({ visible: B }), (n, l) => {
    const c = X, I = Y, s = Z, M = ee, f = le, r = ae, p = te, z = se, D = ne, h = fe, L = oe, S = K("ellipsis");
    return v(), O("div", be, [e(L, { "close-on-click-modal": false, "close-on-press-escape": false, "model-value": y.visible, "show-close": false, "destroy-on-close": "", size: "40%" }, { header: a(() => [e(re, { "type-one": false, "header-title": "项目结算" }, { subTitle: a(() => [R.value ? (v(), E(c, { key: 0, size: "default", type: "danger" }, { default: a(() => l[5] || (l[5] = [b("请先进行项目选择!")])), _: 1, __: [5] })) : Q("", true)]), _: 1 }), e(I, { plain: "", onClick: F }, { default: a(() => l[6] || (l[6] = [b("关闭")])), _: 1, __: [6] }), e(I, { loading: _.value, type: "success", onClick: q }, { default: a(() => l[7] || (l[7] = [b("发起审批")])), _: 1, __: [7] }, 8, ["loading"])]), default: a(() => [e(z, { ref_key: "formRef", ref: w, model: t, rules: P, class: "form-container", "label-position": "left" }, { default: a(() => [e(p, null, { default: a(() => [e(s, { span: 4 }, { default: a(() => l[8] || (l[8] = [u("span", { class: "prop-span label" }, "结算日期", -1)])), _: 1, __: [8] }), e(s, { span: 8 }, { default: a(() => [e(f, { prop: "settlementTime" }, { default: a(() => [e(M, { modelValue: t.settlementTime, "onUpdate:modelValue": l[0] || (l[0] = (o) => t.settlementTime = o), clearable: "", placeholder: "请选择日期", "prefix-icon": "", style: { width: "100%" }, type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), e(s, { span: 4 }, { default: a(() => l[9] || (l[9] = [u("span", { class: "label" }, "项目经理", -1)])), _: 1, __: [9] }), e(s, { span: 8 }, { default: a(() => {
      var o;
      return [e(r, { "model-value": (o = d.value.projectManager) == null ? void 0 : o.name, placeholder: "项目经理", readonly: "" }, null, 8, ["model-value"])];
    }), _: 1 })]), _: 1 }), e(p, null, { default: a(() => [e(s, { span: 4 }, { default: a(() => l[10] || (l[10] = [u("span", { class: "prop-span label" }, "项目", -1)])), _: 1, __: [10] }), e(s, { span: 20 }, { default: a(() => [e(f, { prop: "projectId" }, { default: a(() => [e(pe, { modelValue: t.projectId, "onUpdate:modelValue": l[1] || (l[1] = (o) => t.projectId = o), clearable: "", disabled: "", filterable: "", placeholder: "请选择或输入项目" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 })]), _: 1 }), e(p, null, { default: a(() => [e(s, { span: 4 }, { default: a(() => l[11] || (l[11] = [u("span", { class: "label" }, "发包单位", -1)])), _: 1, __: [11] }), e(s, { span: 20 }, { default: a(() => {
      var o;
      return [e(r, { "model-value": (o = d.value.branchComment) == null ? void 0 : o.name, placeholder: "发包单位", readonly: "" }, null, 8, ["model-value"])];
    }), _: 1 })]), _: 1 }), e(p, null, { default: a(() => [e(s, { span: 4 }, { default: a(() => l[12] || (l[12] = [u("span", { class: "label" }, "合同额", -1)])), _: 1, __: [12] }), e(s, { span: 20 }, { default: a(() => [e(r, { "model-value": d.value.contractProjectAmount, placeholder: "合同额", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 }), e(p, null, { default: a(() => [e(s, { span: 4 }, { default: a(() => l[13] || (l[13] = [u("span", { class: "label" }, "累计收款", -1)])), _: 1, __: [13] }), e(s, { span: 8 }, { default: a(() => [e(r, { "model-value": d.value.paymentAmount, placeholder: "累计收款", readonly: "" }, null, 8, ["model-value"])]), _: 1 }), e(s, { span: 4 }, { default: a(() => l[14] || (l[14] = [u("span", { class: "label" }, "收款率", -1)])), _: 1, __: [14] }), e(s, { span: 8 }, { default: a(() => [e(r, { "model-value": d.value.paymentRate, placeholder: "收款率", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 }), e(p, null, { default: a(() => [e(s, { span: 4 }, { default: a(() => l[15] || (l[15] = [u("span", { class: "label" }, "累计开票", -1)])), _: 1, __: [15] }), e(s, { span: 8 }, { default: a(() => [e(r, { "model-value": d.value.invoiceAmount, placeholder: "累计开票", readonly: "" }, null, 8, ["model-value"])]), _: 1 }), e(s, { span: 4 }, { default: a(() => l[16] || (l[16] = [u("span", { class: "label" }, "开票率", -1)])), _: 1, __: [16] }), e(s, { span: 8 }, { default: a(() => [e(r, { "model-value": d.value.invoiceRate, placeholder: "开票率", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 }), e(p, null, { default: a(() => [e(s, { span: 4 }, { default: a(() => l[17] || (l[17] = [u("span", { class: "prop-span label" }, "结算额", -1)])), _: 1, __: [17] }), e(s, { span: 8 }, { default: a(() => [e(f, { prop: "settlementAmount" }, { default: a(() => [e(r, { modelValue: t.settlementAmount, "onUpdate:modelValue": l[2] || (l[2] = (o) => t.settlementAmount = o), modelModifiers: { number: true }, clearable: "", placeholder: "请输入金额", type: "number" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }), e(s, { span: 4 }, { default: a(() => l[18] || (l[18] = [u("span", { class: "label" }, "大写", -1)])), _: 1, __: [18] }), W((v(), E(s, { span: 8 }, { default: a(() => [e(r, { modelValue: j.value, "onUpdate:modelValue": l[3] || (l[3] = (o) => j.value = o), placeholder: "输入结算额", readonly: "" }, null, 8, ["modelValue"])]), _: 1 })), [[S]])]), _: 1 }), e(p, null, { default: a(() => [e(s, { span: 4 }, { default: a(() => l[19] || (l[19] = [u("span", { class: "label" }, "应收款", -1)])), _: 1, __: [19] }), e(s, { span: 8 }, { default: a(() => [e(r, { "model-value": d.value.remainderPayment, placeholder: "应收款", readonly: "" }, null, 8, ["model-value"])]), _: 1 }), e(s, { span: 4 }, { default: a(() => l[20] || (l[20] = [u("span", { class: "label" }, "应开票", -1)])), _: 1, __: [20] }), e(s, { span: 8 }, { default: a(() => [e(r, { "model-value": d.value.remainderInvoice, placeholder: "应开票", readonly: "" }, null, 8, ["model-value"])]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model"]), e(D, null, { default: a(() => l[21] || (l[21] = [u("span", { class: "title" }, "附件", -1)])), _: 1, __: [21] }), e(h, { files: t.attachment, "onUpdate:files": [l[4] || (l[4] = (o) => t.attachment = o), N], "empty-text": "暂未上传附件", "show-download": "", showView: "", style: { "margin-top": "10px", "": "10px", padding: "0" } }, null, 8, ["files"])]), _: 1 }, 8, ["model-value"])]);
  };
} }, Ie = de(ye, [["__scopeId", "data-v-3ecf805c"]]);
export {
  Ie as default
};
