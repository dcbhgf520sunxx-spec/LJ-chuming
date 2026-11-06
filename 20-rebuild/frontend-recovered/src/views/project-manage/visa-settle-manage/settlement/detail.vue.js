import { computed as I } from "vue";
import { ref as U } from "vue";
import { resolveComponent as x } from "vue";
import { resolveDirective as V } from "vue";
import { openBlock as m } from "vue";
import { createBlock as A } from "vue";
import { withCtx as a } from "vue";
import { withDirectives as _ } from "vue";
import { unref as e } from "vue";
import { createTextVNode as f } from "vue";
import { createElementBlock as k } from "vue";
import { createVNode as i } from "vue";
import { createCommentVNode as w } from "vue";
import { createElementVNode as o } from "vue";
import { toDisplayString as u } from "vue";
import { Fragment as J } from "vue";
import { renderList as Q } from "vue";
import { ElPopconfirm as X } from "element-plus";
import { ElFormItem as Z } from "element-plus";
import { ElInput as ee } from "element-plus";
import { ElForm as te } from "element-plus";
import { vLoading as le } from "element-plus";
import { g as oe } from "../../../../modules/visa-settle-manage-6a11f3ac.js";
import { a as ae } from "../../../../modules/visa-manage-fd5a2300.js";
import { _ as ne, kD as y, g8 as se, gt as ie, L as F, z as re, ia as v, S as ue } from "../../../../shared/runtime.js";
import { _ as ce } from "../../../../modules/UploadBtn-b4cfb47a.js";
const de = { key: 0 }, me = { class: "rule-row" }, pe = { class: "project-name" }, _e = { class: "rule-row" }, fe = { class: "rule-row" }, ve = { class: "rule-row" }, ye = { key: 0 }, be = { class: "rule-row" }, ge = { class: "rule-row" }, Ae = { class: "rule-row" }, he = { class: "rule-row" }, we = { class: "rule-row" }, Ee = { class: "item-center" }, Re = { __name: "detail", props: { status: { type: Number, default: void 0 }, showType: { type: String, default: void 0 } }, emits: ["success"], setup(E, { emit: z }) {
  const B = z, h = E, P = I(() => h.status === y.UNREVIEWED.V ? "结算单待确签" : "结算单详情"), T = I(() => {
    var p;
    return (t.settlementAmount || 0) - (((p = t == null ? void 0 : t.project) == null ? void 0 : p.collectionAmount) || 0);
  }), D = I(() => {
    var p;
    return (t.settlementAmount || 0) - (((p = t == null ? void 0 : t.project) == null ? void 0 : p.invoiceAmount) || 0);
  }), L = U(), R = U(false), W = se(["margin_type"]), { crud: b, detail: t, CRUD: j } = ie();
  j.HOOK.beforeDetailLoaded = async (p) => {
    try {
      t.files = t.attachments || [];
    } catch {
      p.notify("获取结算单详情失败", j.NOTIFICATION_TYPE.ERROR);
    }
  };
  async function S(p) {
    R.value = true;
    try {
      const s = { id: t.id };
      if (p) {
        if (!t.files.length) {
          b.notify("请上传确签附件", j.NOTIFICATION_TYPE.WARNING);
          return;
        }
        s.status = y.PASS.V, s.attachmentRemark = t.attachmentRemark, s.attachmentIds = t.files.map((N) => N.id);
      } else s.status = y.REFUSE.V;
      await ae(s), b.cancelDetail(), B("success");
    } catch {
      b.notify("提交结算单确签信息", j.NOTIFICATION_TYPE.ERROR);
    } finally {
      R.value = false;
    }
  }
  return (p, s) => {
    const N = x("common-button"), $ = X, r = Z, M = ee, Y = te, q = x("common-drawer"), G = V("permission"), H = V("parse-time"), g = V("thousand"), K = le;
    return m(), A(q, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(b).cancelDetail, visible: e(b).detailVisible, title: P.value, "show-close": true, size: "50%" }, { titleRight: a(() => [_((m(), A(F, { params: e(t).id, fn: e(oe) }, { default: a(() => s[4] || (s[4] = [f("下载结算单")])), _: 1, __: [4] }, 8, ["params", "fn"])), [[G, e(b).permission.download]]), h.status === e(y).UNREVIEWED.V && E.showType === "audit" ? (m(), k("span", de, [i(N, { loading: R.value, size: "default", type: "success", onClick: s[0] || (s[0] = (l) => S(true)) }, { default: a(() => s[5] || (s[5] = [f("确 签")])), _: 1, __: [5] }, 8, ["loading"]), i($, { title: "确定要拒绝此条结算单吗？", onConfirm: s[1] || (s[1] = (l) => S(false)) }, { reference: a(() => [i(N, { loading: R.value, size: "default", type: "danger" }, { default: a(() => s[6] || (s[6] = [f("拒 绝")])), _: 1, __: [6] }, 8, ["loading"])]), _: 1 })])) : w("", true)]), content: a(() => [_((m(), A(Y, { ref_key: "formRef", ref: L, size: "default", "label-width": "100px", class: "demo-form" }, { default: a(() => [o("div", me, [i(r, { label: "项目", prop: "projectId" }, { default: a(() => [o("span", pe, u(e(re)(e(t).project)), 1)]), _: 1 }), i(r, { label: "" })]), o("div", _e, [i(r, { label: "签约单位", prop: "contractSignBodyName" }, { default: a(() => {
      var l, n;
      return [o("div", null, u((n = (l = e(t)) == null ? void 0 : l.project) == null ? void 0 : n.contractSignBodyName), 1)];
    }), _: 1 }), i(r, { label: "发包单位", prop: "customerUnit" }, { default: a(() => {
      var l, n;
      return [o("div", null, u((n = (l = e(t)) == null ? void 0 : l.project) == null ? void 0 : n.customerUnit), 1)];
    }), _: 1 })]), o("div", fe, [i(r, { label: "签订日期", prop: "signingDate" }, { default: a(() => {
      var l, n;
      return [_(o("div", null, null, 512), [[H, { val: (n = (l = e(t)) == null ? void 0 : l.project) == null ? void 0 : n.signingDate, fmt: "{y}-{m}-{d}" }]])];
    }), _: 1 }), i(r, { label: "项目经理", prop: "projectManagerName" }, { default: a(() => {
      var l, n;
      return [o("div", null, u((n = (l = e(t)) == null ? void 0 : l.project) == null ? void 0 : n.projectManagerName), 1)];
    }), _: 1 })]), o("div", ve, [i(r, { label: "保证金额", prop: "marginAmount" }, { default: a(() => {
      var l, n, c, d, C, O;
      return [o("div", null, [_(o("span", null, null, 512), [[g, ((n = (l = e(t)) == null ? void 0 : l.project) == null ? void 0 : n.marginAmount) || 0]]), (d = (c = e(t)) == null ? void 0 : c.project) != null && d.marginType ? (m(), k("span", ye, "（" + u(e(W).label.margin_type[(O = (C = e(t)) == null ? void 0 : C.project) == null ? void 0 : O.marginType]) + "）", 1)) : w("", true)])];
    }), _: 1 }), i(r, { label: "合同额", prop: "contractAmount" }, { default: a(() => {
      var l, n, c, d;
      return [o("div", null, [_(o("span", null, null, 512), [[g, ((n = (l = e(t)) == null ? void 0 : l.project) == null ? void 0 : n.contractAmount) || 0]]), f("（" + u(e(v)(((d = (c = e(t)) == null ? void 0 : c.project) == null ? void 0 : d.contractAmount) || 0)) + "）", 1)])];
    }), _: 1 })]), o("div", be, [i(r, { label: "签证额", prop: "visaAmount" }, { default: a(() => [o("div", null, u(e(t).visaAmount) + "（" + u(e(v)(e(t).visaAmount)) + "）", 1)]), _: 1 }), i(r, { label: "违约金额", prop: "breachAmount" }, { default: a(() => [o("div", null, u(e(t).breachAmount) + "（" + u(e(v)(e(t).breachAmount)) + "）", 1)]), _: 1 })]), o("div", ge, [i(r, { label: "最终结算额", prop: "settlementAmount" }, { default: a(() => [o("div", null, [_(o("span", null, null, 512), [[g, e(t).settlementAmount]]), f("（" + u(e(v)(e(t).settlementAmount)) + "）", 1)])]), _: 1 }), i(r, { label: "大写" }, { default: a(() => [o("span", null, u(e(t).settlementAmount ? e(v)(e(t).settlementAmount) : ""), 1)]), _: 1 })]), o("div", Ae, [i(r, { label: "已付款", prop: "collectionAmount" }, { default: a(() => {
      var l, n, c, d;
      return [o("div", null, [_(o("span", null, null, 512), [[g, (n = (l = e(t)) == null ? void 0 : l.project) == null ? void 0 : n.collectionAmount]]), f("（" + u(e(v)(((d = (c = e(t)) == null ? void 0 : c.project) == null ? void 0 : d.collectionAmount) || 0)) + "）", 1)])];
    }), _: 1 }), i(r, { label: "欠款额", prop: "debitAmount" }, { default: a(() => [o("div", null, [_(o("span", null, null, 512), [[g, T.value]]), f("（" + u(e(v)(T.value || 0)) + "）", 1)])]), _: 1 })]), o("div", he, [i(r, { label: "已开票", prop: "invoiceAmount" }, { default: a(() => {
      var l, n, c, d;
      return [o("div", null, [_(o("span", null, null, 512), [[g, (n = (l = e(t)) == null ? void 0 : l.project) == null ? void 0 : n.invoiceAmount]]), f("（" + u(e(v)(((d = (c = e(t)) == null ? void 0 : c.project) == null ? void 0 : d.invoiceAmount) || 0)) + "）", 1)])];
    }), _: 1 }), i(r, { label: "应补发票", prop: "debitInvoice" }, { default: a(() => [o("div", null, [_(o("span", null, null, 512), [[g, D.value]]), f("（" + u(e(v)(D.value || 0)) + "）", 1)])]), _: 1 })]), o("div", we, [i(r, { label: "备注", prop: "remark" }, { default: a(() => [o("div", null, u(e(t).remark), 1)]), _: 1 })]), o("div", Ee, [E.showType === "audit" || h.status === e(y).PASS.V ? (m(), A(r, { key: 0, label: "确签附件" }, { default: a(() => [h.status === e(y).UNREVIEWED.V ? (m(), A(e(ce), { key: 0, ref: "uploadRef", files: e(t).files, "onUpdate:files": s[2] || (s[2] = (l) => e(t).files = l), "file-classify": e(ue).CONTRACT_VISA.V, accept: ".pdf,.png,.jpg,.jpeg" }, null, 8, ["files", "file-classify"])) : (m(true), k(J, { key: 1 }, Q(e(t).files, (l) => (m(), k("div", { key: l.id }, [f(u(l.name) + " ", 1), i(F, { params: { id: l.id }, size: "default" }, null, 8, ["params"])]))), 128))]), _: 1 })) : w("", true), E.showType === "audit" || h.status === e(y).PASS.V ? (m(), A(r, { key: 1, label: "确签备注" }, { default: a(() => [h.status === e(y).UNREVIEWED.V ? (m(), A(M, { key: 0, modelValue: e(t).attachmentRemark, "onUpdate:modelValue": s[3] || (s[3] = (l) => e(t).attachmentRemark = l), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 2, maxRows: 4 }, placeholder: "请填写确签备注", maxlength: "200", "show-word-limit": "" }, null, 8, ["modelValue"])) : w("", true)]), _: 1 })) : w("", true)])]), _: 1 })), [[K, e(b).detailLoading]])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, Te = ne(Re, [["__scopeId", "data-v-6a5efd10"]]);
export {
  Te as default
};
