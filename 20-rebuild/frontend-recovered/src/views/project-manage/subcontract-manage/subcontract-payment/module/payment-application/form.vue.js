import { ref as w } from "vue";
import ee from "moment";
import { computed as te } from "vue";
import { resolveComponent as R } from "vue";
import { resolveDirective as F } from "vue";
import { openBlock as f } from "vue";
import { createBlock as A } from "vue";
import { withCtx as a } from "vue";
import { createVNode as o } from "vue";
import { unref as l } from "vue";
import { createTextVNode as I } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as b } from "vue";
import { withDirectives as y } from "vue";
import { createCommentVNode as g } from "vue";
import { createElementBlock as D } from "vue";
import { Fragment as le } from "vue";
import { renderList as ne } from "vue";
import { ElDatePicker as oe } from "element-plus";
import { ElFormItem as ae } from "element-plus";
import { ElTag as ie } from "element-plus";
import { ElCheckbox as ue } from "element-plus";
import { ElInputNumber as de } from "element-plus";
import { InfoFilled as se } from "@element-plus/icons-vue";
import { ElIcon as me } from "element-plus";
import { ElTooltip as re } from "element-plus";
import { ElForm as fe } from "element-plus";
import { _ as ce, t as pe, g8 as be, ao as ye, i as V, p as _e, ia as Ie, S as ge, iy as Ae } from "../../../../../../shared/runtime.js";
import { _ as De } from "../../../../../../modules/UploadBtn-b4cfb47a.js";
const ve = { key: 0 }, he = { key: 1 }, ke = { key: 2, style: { color: "red", "margin-left": "10px" } }, Ve = { style: { color: "#82848a" } }, xe = ["onDblclick"], Be = { __name: "form", props: { detailInfo: { type: Object, default: () => {
} } }, setup(i) {
  const { decimalPrecision: j } = pe(), T = w(), P = be(["payment_reason"]), _ = i, S = { paymentDate: ee().startOf("day").valueOf(), breachAmount: void 0, notBoolDeduct: false, boolUpdateBreachAmount: void 0, boolDeduct: void 0, inputAmount: void 0, attachmentIds: void 0, files: [], orderId: void 0, paymentReasonId: void 0 }, { CRUD: U, crud: m, form: e } = ye(S, T), v = w(false), C = w(), q = te(() => {
    var c;
    return e.id ? e.notBoolDeduct ? e.inputAmount : V(e.inputAmount) ? e.inputAmount - (e.boolUpdateBreachAmount ? _.detailInfo.penalty ? _.detailInfo.penalty : 0 : e.breachAmount ? e.breachAmount : 0) : 0 : e.notBoolDeduct ? e.inputAmount : V(e.inputAmount) ? e.inputAmount - ((c = _.detailInfo) != null && c.penalty ? _.detailInfo.penalty : 0) : 0;
  }), M = { paymentDate: [{ required: true, message: "请选择申请日期", trigger: "change" }], paymentReasonId: [{ required: true, message: "请选择付款事由", trigger: "change" }], inputAmount: [{ required: true, validator: (c, n, h) => {
    V(n) || h(new Error("请填写本次金额")), h();
  }, trigger: "blur" }] };
  function $(c) {
    C.value = c.id, v.value = true;
  }
  return U.HOOK.afterToEdit = () => {
    setTimeout(() => {
      e.notBoolDeduct = !e.boolDeduct, e.inputAmount = e.applyAmount + e.breachAmount, e.boolUpdateBreachAmount = false;
    }, 300);
  }, U.HOOK.beforeSubmit = () => {
    var c;
    m.form.attachmentIds = m.form.files ? m.form.files.map((n) => n.id) : m.form.attachments ? m.form.attachments.map((n) => n.id) : void 0, m.form.boolDeduct = V(m.form.notBoolDeduct) ? !m.form.notBoolDeduct : (c = _.detailInfo) != null && c.penalty ? void 0 : false, m.form.orderId = _.detailInfo.id;
  }, (c, n) => {
    const h = R("common-button"), H = oe, d = ae, K = ie, E = ue, L = de, Y = R("common-select"), G = se, J = me, Q = re, W = fe, X = R("common-drawer"), p = F("thousand"), k = F("empty-text");
    return f(), A(X, { "append-to-body": "", "close-on-click-modal": false, "before-close": l(m).cancelCU, visible: l(m).status.cu > 0, title: "付款申请", "wrapper-closable": false, size: "40%" }, { titleRight: a(() => [o(h, { loading: l(m).status.cu === 2, type: "primary", size: "default", onClick: l(m).submitCU }, { default: a(() => n[7] || (n[7] = [I("提交审核")])), _: 1, __: [7] }, 8, ["loading", "onClick"])]), content: a(() => [o(W, { ref_key: "formRef", ref: T, model: l(e), rules: M, size: "default", "label-width": "130px" }, { default: a(() => {
      var x, N;
      return [o(d, { label: "申请日期", prop: "paymentDate" }, { default: a(() => [o(H, { modelValue: l(e).paymentDate, "onUpdate:modelValue": n[0] || (n[0] = (t) => l(e).paymentDate = t), type: "date", "value-format": "x", placeholder: "选择申请日期", disabledDate: (t) => t.getTime() > (/* @__PURE__ */ new Date()).getTime(), style: { width: "220px" } }, null, 8, ["modelValue", "disabledDate"])]), _: 1 }), o(d, { label: "所属项目" }, { default: a(() => {
        var t;
        return [r("span", null, b((t = _.detailInfo) == null ? void 0 : t.project), 1)];
      }), _: 1 }), o(d, { label: "分包公司" }, { default: a(() => {
        var t;
        return [r("span", null, b((t = i.detailInfo) == null ? void 0 : t.supplierName), 1)];
      }), _: 1 }), o(d, { label: "合同额" }, { default: a(() => {
        var t;
        return [y(r("span", null, null, 512), [[p, (t = i.detailInfo) == null ? void 0 : t.amount]])];
      }), _: 1 }), o(d, { label: "已付款" }, { default: a(() => {
        var t, u;
        return [y(r("span", null, null, 512), [[p, (t = i.detailInfo) == null ? void 0 : t.paymentAmount]]), r("span", null, "（" + b((u = i.detailInfo) == null ? void 0 : u.paymentRate) + "%）", 1)];
      }), _: 1 }), o(d, { label: "最近一次付款" }, { default: a(() => {
        var t, u;
        return [y(r("span", null, null, 512), [[p, (t = i.detailInfo) == null ? void 0 : t.lastPaymentAmount], [k]]), (u = i.detailInfo) != null && u.lastPaymentTime ? (f(), A(K, { key: 0, style: { "margin-left": "5px" } }, { default: a(() => {
          var s;
          return [I(b(l(_e)((s = i.detailInfo) == null ? void 0 : s.lastPaymentTime, "{y}-{m}-{d}")), 1)];
        }), _: 1 })) : g("", true)];
      }), _: 1 }), (N = (x = i.detailInfo) == null ? void 0 : x.sourceRow) != null && N.settlementAmount ? (f(), A(d, { key: 0, label: "结算额" }, { default: a(() => {
        var t;
        return [y(r("span", null, null, 512), [[p, (t = i.detailInfo) == null ? void 0 : t.settlementAmount]])];
      }), _: 1 })) : g("", true), o(d, { label: l(e).id ? "本次项目违法处罚" : "项目违法处罚", prop: "notBoolDeduct" }, { default: a(() => {
        var t, u;
        return [l(e).id ? y((f(), D("span", ve, null, 512)), [[p, l(e).breachAmount], [k]]) : y((f(), D("span", he, null, 512)), [[p, (t = i.detailInfo) == null ? void 0 : t.penalty], [k]]), o(E, { modelValue: l(e).notBoolDeduct, "onUpdate:modelValue": n[1] || (n[1] = (s) => l(e).notBoolDeduct = s), label: "本次不扣除", size: "default", style: { "margin-left": "20px", "vertical-align": "middle" }, disabled: !i.detailInfo.penalty }, null, 8, ["modelValue", "disabled"]), l(e).id && i.detailInfo.penalty !== l(e).breachAmount && !l(e).notBoolDeduct ? (f(), D("span", ke, [n[8] || (n[8] = I("(*最新罚款:")), y(r("span", null, null, 512), [[p, (u = i.detailInfo) == null ? void 0 : u.penalty], [k]]), n[9] || (n[9] = I()), o(E, { modelValue: l(e).boolUpdateBreachAmount, "onUpdate:modelValue": n[2] || (n[2] = (s) => l(e).boolUpdateBreachAmount = s), label: "是否扣除最新", size: "default", style: { "margin-left": "10px", "vertical-align": "middle" } }, null, 8, ["modelValue"]), n[10] || (n[10] = I(")"))])) : g("", true)];
      }), _: 1 }, 8, ["label"]), o(d, { label: "本次付款", prop: "inputAmount" }, { default: a(() => {
        var t, u, s, B, O, z;
        return [o(L, { modelValue: l(e).inputAmount, "onUpdate:modelValue": n[3] || (n[3] = (Z) => l(e).inputAmount = Z), step: 1e4, min: -9999999999, max: (u = (t = i.detailInfo) == null ? void 0 : t.sourceRow) != null && u.settlementAmount ? ((B = (s = i.detailInfo) == null ? void 0 : s.sourceRow) == null ? void 0 : B.settlementAmount) - ((z = (O = i.detailInfo) == null ? void 0 : O.sourceRow) == null ? void 0 : z.paymentAmount) : 9999999999, precision: l(j).project, placeholder: "本次付款", "controls-position": "right", style: { width: "220px" } }, null, 8, ["modelValue", "max", "precision"])];
      }), _: 1 }), o(d, { label: "大写" }, { default: a(() => [r("span", Ve, b(l(e).inputAmount ? l(Ie)(l(e).inputAmount) : ""), 1)]), _: 1 }), o(d, { label: "收款银行" }, { default: a(() => {
        var t;
        return [r("span", null, b((t = i.detailInfo) == null ? void 0 : t.supplier.bankName), 1)];
      }), _: 1 }), o(d, { label: "账号" }, { default: a(() => {
        var t;
        return [r("span", null, b((t = i.detailInfo) == null ? void 0 : t.supplier.bankAccount), 1)];
      }), _: 1 }), o(d, { label: "申请金额" }, { default: a(() => [y(r("span", null, null, 512), [[p, q.value]])]), _: 1 }), o(d, { label: "付款事由", prop: "paymentReasonId" }, { default: a(() => [o(Y, { modelValue: l(e).paymentReasonId, "onUpdate:modelValue": n[4] || (n[4] = (t) => l(e).paymentReasonId = t), options: l(P).payment_reason, type: "dict", size: "default", clearable: "", placeholder: "付款事由", style: { width: "220px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), o(d, { label: "附件" }, { label: a(() => {
        var t, u;
        return [n[11] || (n[11] = I(" 附件 ")), l(e).id && ((t = l(e).attachments) != null && t.length) && !((u = l(e).files) != null && u.length) ? (f(), A(Q, { key: 0, effect: "light", content: "双击可预览附件", placement: "top" }, { default: a(() => [o(J, null, { default: a(() => [o(G)]), _: 1 })]), _: 1 })) : g("", true)];
      }), default: a(() => {
        var t, u;
        return [l(e).id && ((t = l(e).attachments) != null && t.length) && !((u = l(e).files) != null && u.length) ? (f(true), D(le, { key: 0 }, ne(l(e).attachments, (s) => (f(), D("div", { key: s.id }, [r("div", { style: { cursor: "pointer" }, onDblclick: (B) => $(s) }, b(s.name), 41, xe)]))), 128)) : g("", true), o(l(De), { ref: "uploadRef", files: l(e).files, "onUpdate:files": n[5] || (n[5] = (s) => l(e).files = s), "file-classify": l(ge).CONTRACT_ATT.V, limit: 1, accept: ".jpg,.png,.pdf,.jpeg" }, null, 8, ["files", "file-classify"])];
      }), _: 1 })];
    }), _: 1 }, 8, ["model"]), v.value ? (f(), A(Ae, { key: 0, isVisible: v.value, showType: "attachment", id: C.value, onClose: n[6] || (n[6] = (x) => v.value = false) }, null, 8, ["isVisible", "id"])) : g("", true)]), _: 1 }, 8, ["before-close", "visible"]);
  };
} }, Ce = ce(Be, [["__scopeId", "data-v-b3abb763"]]);
export {
  Ce as default
};
