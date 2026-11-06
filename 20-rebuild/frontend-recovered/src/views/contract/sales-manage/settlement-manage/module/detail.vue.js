import { computed as U } from "vue";
import { ref as $ } from "vue";
import { resolveComponent as q } from "vue";
import { resolveDirective as O } from "vue";
import { openBlock as u } from "vue";
import { createBlock as x } from "vue";
import { withCtx as n } from "vue";
import { withDirectives as _ } from "vue";
import { unref as e } from "vue";
import { createTextVNode as v } from "vue";
import { createElementBlock as m } from "vue";
import { createVNode as s } from "vue";
import { createCommentVNode as D } from "vue";
import { createElementVNode as l } from "vue";
import { toDisplayString as i } from "vue";
import { ElPopconfirm as ne } from "element-plus";
import { ElFormItem as se } from "element-plus";
import { ElTableColumn as ie } from "element-plus";
import { ElInput as re } from "element-plus";
import { ElForm as ce } from "element-plus";
import { vLoading as ue } from "element-plus";
import { d as de, a as pe } from "../../../../../modules/settlement-manage-aa83dffa.js";
import { _ as me, t as _e, kD as w, g8 as ve, gt as fe, L as be, z as he, iD as B, bD as ye, ia as b, b as C, bV as G, R as Ae, S as ge } from "../../../../../shared/runtime.js";
const je = { key: 0 }, we = { class: "rule-row" }, ke = { class: "project-name" }, Ee = { class: "rule-row" }, Ne = { class: "rule-row" }, Re = { class: "rule-row" }, Ve = { class: "rule-row" }, De = { key: 0 }, Te = { class: "rule-row" }, Ie = { class: "rule-row" }, Se = { key: 0 }, xe = { key: 1 }, Ce = { key: 0 }, Ue = { key: 0 }, Oe = { key: 1 }, Be = { class: "rule-row" }, Fe = { key: 0 }, Le = { key: 1 }, Pe = { key: 0 }, ze = { key: 1 }, We = { class: "rule-row" }, Ye = { class: "rule-row" }, $e = { class: "rule-row" }, qe = { key: 0 }, Ge = { key: 1 }, He = { class: "rule-row" }, Ke = { key: 0, class: "rule-row" }, Je = { class: "item-center" }, Me = { __name: "detail", props: { status: { type: Number, default: void 0 } }, emits: ["success"], setup(H, { emit: K }) {
  const { decimalPrecision: f } = _e(), J = K, k = H, M = U(() => k.status === w.UNREVIEWED.V ? "结算单待确签" : "结算单详情"), F = U(() => {
    var h;
    return (t.settlementAmount || 0) - (((h = t == null ? void 0 : t.project) == null ? void 0 : h.collectionAmount) || 0);
  }), L = U(() => {
    var h;
    return (t.settlementAmount || 0) - (((h = t == null ? void 0 : t.project) == null ? void 0 : h.invoiceAmount) || 0);
  }), Q = $(), T = $(false), P = ve(["margin_type"]), { crud: j, detail: t, CRUD: I } = fe();
  I.HOOK.beforeDetailLoaded = async (h) => {
    try {
      t.files = t.attachments || [];
    } catch {
      h.notify("获取结算单详情失败", I.NOTIFICATION_TYPE.ERROR);
    }
  };
  async function z(h) {
    T.value = true;
    try {
      const r = { id: t.id };
      if (h) {
        if (!t.files.length) {
          j.notify("请上传确签附件", I.NOTIFICATION_TYPE.WARNING);
          return;
        }
        r.status = w.PASS.V, r.attachmentRemark = t.attachmentRemark, r.attachmentIds = t.files.map((S) => S.id);
      } else r.status = w.REFUSE.V;
      await pe(r), j.cancelDetail(), J("success");
    } catch {
      j.notify("提交结算单确签信息", I.NOTIFICATION_TYPE.ERROR);
    } finally {
      T.value = false;
    }
  }
  return (h, r) => {
    const S = q("common-button"), X = ne, c = se, Z = ie, ee = re, te = ce, oe = q("common-drawer"), le = O("permission"), W = O("parse-time"), y = O("thousand"), ae = ue;
    return u(), x(oe, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(j).cancelDetail, visible: e(j).detailVisible, title: M.value, "show-close": true, size: "50%" }, { titleRight: n(() => [_((u(), x(be, { params: e(t).id, fn: e(de) }, { default: n(() => r[4] || (r[4] = [v(" 下载结算单 ")])), _: 1, __: [4] }, 8, ["params", "fn"])), [[le, e(j).permission.download]]), k.status === e(w).UNREVIEWED.V ? (u(), m("span", je, [s(S, { loading: T.value, size: "default", type: "success", onClick: r[0] || (r[0] = (o) => z(true)) }, { default: n(() => r[5] || (r[5] = [v("确 签")])), _: 1, __: [5] }, 8, ["loading"]), s(X, { title: "确定要拒绝此条结算单吗？", onConfirm: r[1] || (r[1] = (o) => z(false)) }, { reference: n(() => [s(S, { loading: T.value, size: "default", type: "danger" }, { default: n(() => r[6] || (r[6] = [v("拒 绝")])), _: 1, __: [6] }, 8, ["loading"])]), _: 1 })])) : D("", true)]), content: n(() => [_((u(), x(te, { ref_key: "formRef", ref: Q, size: "default", "label-width": "100px", class: "demo-form" }, { default: n(() => [l("div", we, [s(c, { label: "项目", prop: "project" }, { default: n(() => [l("span", ke, i(e(he)(e(t).project)), 1)]), _: 1 })]), l("div", Ee, [s(c, { label: "合同内容", prop: "projectContentName" }, { default: n(() => {
      var o, a;
      return [l("div", null, i((a = (o = e(t)) == null ? void 0 : o.project) == null ? void 0 : a.projectContentName), 1)];
    }), _: 1 })]), l("div", Ne, [s(c, { label: "结算日期", prop: "settlementDate" }, { default: n(() => [_(l("div", null, null, 512), [[W, { val: e(t).settlementDate, fmt: "{y}-{m}-{d}" }]])]), _: 1 }), s(c, { label: "申请人", prop: "userName" }, { default: n(() => [l("div", null, i(e(t).userName), 1)]), _: 1 })]), l("div", Re, [s(c, { label: "签约单位", prop: "contractSignBodyName" }, { default: n(() => {
      var o, a;
      return [l("div", null, i((a = (o = e(t)) == null ? void 0 : o.project) == null ? void 0 : a.contractSignBodyName), 1)];
    }), _: 1 }), s(c, { label: "发包单位", prop: "customerUnit" }, { default: n(() => {
      var o, a;
      return [l("div", null, i((a = (o = e(t)) == null ? void 0 : o.project) == null ? void 0 : a.customerUnit), 1)];
    }), _: 1 })]), l("div", Ve, [s(c, { label: "签约人", prop: "signerName" }, { default: n(() => {
      var o, a;
      return [l("div", null, i((a = (o = e(t)) == null ? void 0 : o.project) == null ? void 0 : a.signerName), 1)];
    }), _: 1 }), s(c, { label: "合同含税", prop: "isTax" }, { default: n(() => {
      var o, a, d, p, A, g, E, N, R, V, Y;
      return [l("div", null, [l("span", null, i((p = (d = e(B).V) == null ? void 0 : d[(a = (o = e(t)) == null ? void 0 : o.project) == null ? void 0 : a.isTax]) == null ? void 0 : p.SL), 1), ((g = (A = e(t)) == null ? void 0 : A.project) == null ? void 0 : g.isTax) === e(B).YES.V ? (u(), m("span", De, "【" + i((R = e(ye).VL) == null ? void 0 : R[(N = (E = e(t)) == null ? void 0 : E.project) == null ? void 0 : N.invoiceType]) + " " + i(((Y = (V = e(t)) == null ? void 0 : V.project) == null ? void 0 : Y.taxRate) || 0) + "%】", 1)) : D("", true)])];
    }), _: 1 })]), l("div", Te, [s(c, { label: "签订日期", prop: "signingDate" }, { default: n(() => {
      var o, a;
      return [_(l("div", null, null, 512), [[W, { val: (a = (o = e(t)) == null ? void 0 : o.project) == null ? void 0 : a.signingDate, fmt: "{y}-{m}-{d}" }]])];
    }), _: 1 }), s(c, { label: "合同额", prop: "contractAmount" }, { default: n(() => {
      var o, a, d, p;
      return [l("div", null, [_(l("span", null, null, 512), [[y, { val: ((a = (o = e(t)) == null ? void 0 : o.project) == null ? void 0 : a.contractAmount) || 0, dp: e(f).contract }]]), v("（" + i(e(b)(((p = (d = e(t)) == null ? void 0 : d.project) == null ? void 0 : p.contractAmount) || 0)) + "）", 1)])];
    }), _: 1 })]), l("div", Ie, [s(c, { label: "保证金额", prop: "marginAmount" }, { default: n(() => {
      var o, a, d, p, A, g, E, N, R, V;
      return [e(C)((a = (o = e(t)) == null ? void 0 : o.project) == null ? void 0 : a.marginAmount) ? (u(), m("div", Se, "无")) : (u(), m("div", xe, [l("div", null, [_(l("span", null, null, 512), [[y, { val: ((p = (d = e(t)) == null ? void 0 : d.project) == null ? void 0 : p.marginAmount) || 0, dp: e(f).contract }]]), v("（" + i(e(b)(((g = (A = e(t)) == null ? void 0 : A.project) == null ? void 0 : g.marginAmount) || 0)) + "）", 1)]), e(P).label.margin_type && ((N = (E = e(t)) == null ? void 0 : E.project) != null && N.marginType) ? (u(), m("span", Ce, "（" + i(e(P).label.margin_type[(V = (R = e(t)) == null ? void 0 : R.project) == null ? void 0 : V.marginType]) + "）", 1)) : D("", true)]))];
    }), _: 1 }), s(c, { label: "累计发运额", prop: "happenedAmount" }, { default: n(() => {
      var o, a, d, p, A, g;
      return [e(C)((a = (o = e(t)) == null ? void 0 : o.project) == null ? void 0 : a.happenedAmount) ? (u(), m("div", Ue, "无")) : (u(), m("div", Oe, [_(l("span", null, null, 512), [[y, { val: ((p = (d = e(t)) == null ? void 0 : d.project) == null ? void 0 : p.happenedAmount) || 0, dp: e(f).contract }]]), v("（" + i(e(b)(((g = (A = e(t)) == null ? void 0 : A.project) == null ? void 0 : g.happenedAmount) || 0)) + "）", 1)]))];
    }), _: 1 })]), l("div", Be, [s(c, { label: "违约金额", prop: "breachAmount" }, { default: n(() => [e(C)(e(t).breachAmount) ? (u(), m("div", Fe, "无")) : (u(), m("div", Le, i(e(G)(e(t).breachAmount, e(f).contract)) + "（" + i(e(b)(e(t).breachAmount)) + "）", 1))]), _: 1 }), s(c, { label: "签证额", prop: "visaAmount" }, { default: n(() => [e(C)(e(t).visaAmount) ? (u(), m("div", Pe, "无")) : (u(), m("div", ze, i(e(G)(e(t).visaAmount, e(f).contract)) + "（" + i(e(b)(e(t).visaAmount)) + "）", 1))]), _: 1 })]), l("div", We, [s(c, { label: "加工结算额", prop: "processingSettlementAmount" }, { default: n(() => [l("div", null, [_(l("span", null, null, 512), [[y, { val: e(t).processingSettlementAmount || 0, dp: e(f).contract }]]), v("（" + i(e(b)(e(t).processingSettlementAmount)) + "）", 1)])]), _: 1 }), s(c, { label: "最终结算额", prop: "settlementAmount" }, { default: n(() => [l("div", null, [_(l("span", null, null, 512), [[y, { val: e(t).settlementAmount || 0, dp: e(f).contract }]]), v("（" + i(e(b)(e(t).settlementAmount)) + "）", 1)])]), _: 1 })]), l("div", Ye, [s(c, { label: "累计收款", prop: "collectionAmount" }, { default: n(() => {
      var o, a, d, p;
      return [l("div", null, [_(l("span", null, null, 512), [[y, { val: ((a = (o = e(t)) == null ? void 0 : o.project) == null ? void 0 : a.collectionAmount) || 0, dp: e(f).contract }]]), v(" （" + i(e(b)(((p = (d = e(t)) == null ? void 0 : d.project) == null ? void 0 : p.collectionAmount) || 0)) + "） ", 1)])];
    }), _: 1 }), s(c, { label: "结算应收", prop: "debitAmount" }, { default: n(() => [l("div", null, [_(l("span", null, null, 512), [[y, { val: F.value || 0, dp: e(f).contract }]]), v("（" + i(e(b)(F.value || 0)) + "）", 1)])]), _: 1 })]), l("div", $e, [s(c, { label: "累计开票", prop: "invoiceAmount" }, { default: n(() => {
      var o, a, d, p;
      return [l("div", null, [_(l("span", null, null, 512), [[y, { val: ((a = (o = e(t)) == null ? void 0 : o.project) == null ? void 0 : a.invoiceAmount) || 0, dp: e(f).contract }]]), v("（" + i(e(b)(((p = (d = e(t)) == null ? void 0 : d.project) == null ? void 0 : p.invoiceAmount) || 0)) + "）", 1)])];
    }), _: 1 }), s(c, { label: "应补发票", prop: "debitInvoice" }, { default: n(() => {
      var o, a;
      return [((a = (o = e(t)) == null ? void 0 : o.project) == null ? void 0 : a.isTax) === e(B).YES.V ? (u(), m("div", qe, [_(l("span", null, null, 512), [[y, { val: L.value || 0, dp: e(f).contract }]]), v("（" + i(e(b)(L.value || 0)) + "）", 1)])) : (u(), m("div", Ge, "无"))];
    }), _: 1 })]), l("div", He, [s(c, { label: "结算备注", prop: "remark" }, { default: n(() => [l("div", null, i(e(t).remark), 1)]), _: 1 })]), k.status === e(w).PASS.V ? (u(), m("div", Ke, [s(c, { label: "确签备注", prop: "attachmentRemark" }, { default: n(() => [l("div", null, i(e(t).attachmentRemark), 1)]), _: 1 })])) : D("", true), l("div", Je, [s(Ae, { uploadable: k.status === e(w).UNREVIEWED.V, "file-classify": e(ge).CONTRACT_VISA.V, accept: ".jpg,.png,.pdf,.jpeg", showView: "", showDownload: "", files: e(t).files, "onUpdate:files": r[2] || (r[2] = (o) => e(t).files = o), style: { "padding-bottom": "20px" } }, { applicant: n(() => [s(Z, { label: "上传人", align: "center", "min-width": "60", "show-overflow-tooltip": true, prop: "createUserName" })]), _: 1 }, 8, ["uploadable", "file-classify", "files"]), k.status === e(w).UNREVIEWED.V ? (u(), x(ee, { key: 0, modelValue: e(t).attachmentRemark, "onUpdate:modelValue": r[3] || (r[3] = (o) => e(t).attachmentRemark = o), type: "textarea", autosize: { minRows: 2, maxRows: 4 }, placeholder: "请填写确签备注", maxlength: "200", "show-word-limit": "" }, null, 8, ["modelValue"])) : D("", true)])]), _: 1 })), [[ae, e(j).detailLoading]])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, et = me(Me, [["__scopeId", "data-v-9610e777"]]);
export {
  et as default
};
