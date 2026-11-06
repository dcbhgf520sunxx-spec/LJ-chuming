import { computed as j } from "vue";
import { ref as w } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as V } from "vue";
import { openBlock as m } from "vue";
import { createBlock as y } from "vue";
import { withCtx as l } from "vue";
import { withDirectives as R } from "vue";
import { unref as e } from "vue";
import { createTextVNode as g } from "vue";
import { createElementBlock as k } from "vue";
import { createVNode as o } from "vue";
import { createCommentVNode as N } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as n } from "vue";
import { ElPopconfirm as L } from "element-plus";
import { ElFormItem as P } from "element-plus";
import { ElInput as W } from "element-plus";
import { ElForm as Y } from "element-plus";
import { vLoading as $ } from "element-plus";
import { d as q, a as G } from "../../../../../modules/visa-manage-fd5a2300.js";
import { _ as H, kD as u, gt as K, L as J, z as M, ia as Q, R as X, S as Z } from "../../../../../shared/runtime.js";
const ee = { key: 0 }, te = { class: "rule-row" }, ae = { class: "rule-row" }, se = { class: "rule-row" }, le = { class: "rule-row" }, oe = { class: "rule-row" }, ie = { class: "rule-row" }, ne = { class: "rule-row" }, re = { class: "rule-row" }, de = { key: 0, class: "rule-row" }, ue = { class: "item-center" }, me = { __name: "detail", props: { status: { type: Number, default: void 0 } }, emits: ["success"], setup(D, { emit: I }) {
  const U = I, c = D, C = j(() => c.status === u.UNREVIEWED.V ? "签证单待确签" : "签证单详情"), T = w(), _ = w(false), { crud: d, detail: t, CRUD: f } = K();
  f.HOOK.beforeDetailLoaded = async (v) => {
    try {
      t.files = t.attachments || [];
    } catch {
      v.notify("获取签证单详情失败", f.NOTIFICATION_TYPE.ERROR);
    }
  };
  async function E(v) {
    _.value = true;
    try {
      const a = { id: t.id };
      if (v) {
        if (!t.files.length) {
          d.notify("请上传确签附件", f.NOTIFICATION_TYPE.WARNING);
          return;
        }
        a.status = u.PASS.V, a.attachmentRemark = t.attachmentRemark, a.attachmentIds = t.files.map((b) => b.id);
      } else a.status = u.REFUSE.V;
      await G(a), d.cancelDetail(), U("success");
    } catch {
      d.notify("提交签证单确签信息", f.NOTIFICATION_TYPE.ERROR);
    } finally {
      _.value = false;
    }
  }
  return (v, a) => {
    const b = h("common-button"), S = L, i = P, x = W, O = Y, A = h("common-drawer"), F = V("permission"), z = V("parse-time"), B = $;
    return m(), y(A, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(d).cancelDetail, visible: e(d).detailVisible, title: C.value, "show-close": true, size: "50%" }, { titleRight: l(() => [R((m(), y(J, { params: e(t).id, fn: e(q) }, { default: l(() => a[4] || (a[4] = [g(" 下载签证单 ")])), _: 1, __: [4] }, 8, ["params", "fn"])), [[F, e(d).permission.download]]), c.status === e(u).UNREVIEWED.V ? (m(), k("span", ee, [o(b, { loading: _.value, size: "default", type: "success", onClick: a[0] || (a[0] = (r) => E(true)) }, { default: l(() => a[5] || (a[5] = [g("确 签")])), _: 1, __: [5] }, 8, ["loading"]), o(S, { title: "确定要拒绝此条签证单吗？", onConfirm: a[1] || (a[1] = (r) => E(false)) }, { reference: l(() => [o(b, { loading: _.value, size: "default", type: "danger" }, { default: l(() => a[6] || (a[6] = [g("拒 绝")])), _: 1, __: [6] }, 8, ["loading"])]), _: 1 })])) : N("", true)]), content: l(() => [R((m(), y(O, { ref_key: "formRef", ref: T, size: "default", "label-width": "100px", class: "demo-form" }, { default: l(() => [s("div", te, [o(i, { label: "项目", prop: "project" }, { default: l(() => [s("span", null, n(e(M)(e(t).project)), 1)]), _: 1 }), o(i, { label: "签证单号", prop: "serialNumber" }, { default: l(() => [s("div", null, n(e(t).serialNumber), 1)]), _: 1 })]), s("div", ae, [o(i, { label: "签证日期", prop: "visaDate" }, { default: l(() => [R(s("div", null, null, 512), [[z, { val: e(t).visaDate, fmt: "{y}-{m}-{d}" }]])]), _: 1 }), o(i, { label: "申请人", prop: "userName" }, { default: l(() => [s("div", null, n(e(t).userName), 1)]), _: 1 })]), s("div", se, [o(i, { label: "施工单位", prop: "contractSignBodyName" }, { default: l(() => {
      var r, p;
      return [s("div", null, n((p = (r = e(t)) == null ? void 0 : r.project) == null ? void 0 : p.contractSignBodyName), 1)];
    }), _: 1 }), o(i, { label: "发包单位", prop: "customerUnit" }, { default: l(() => {
      var r, p;
      return [s("div", null, n((p = (r = e(t)) == null ? void 0 : r.project) == null ? void 0 : p.customerUnit), 1)];
    }), _: 1 })]), s("div", le, [o(i, { label: "签证原因", prop: "visaDate" }, { default: l(() => [s("div", null, n(e(t).reasonName), 1)]), _: 1 }), o(i, { label: "签证额", prop: "userName" }, { default: l(() => [s("div", null, n(e(t).visaAmount) + "（" + n(e(Q)(e(t).visaAmount)) + "）", 1)]), _: 1 })]), s("div", oe, [o(i, { label: "签证备注", prop: "remark" }, { default: l(() => [s("div", null, n(e(t).remark), 1)]), _: 1 })]), s("div", ie, [o(i, { label: "监理单位", prop: "supervisionUnit" }, { default: l(() => [s("div", null, n(e(t).supervisionUnit), 1)]), _: 1 })]), s("div", ne, [o(i, { label: "设计单位", prop: "designUnit" }, { default: l(() => [s("div", null, n(e(t).designUnit), 1)]), _: 1 })]), s("div", re, [o(i, { label: "政府监管", prop: "governmentRegulation" }, { default: l(() => [s("div", null, n(e(t).governmentRegulation), 1)]), _: 1 })]), c.status === e(u).PASS.V ? (m(), k("div", de, [o(i, { label: "确签备注", prop: "attachmentRemark" }, { default: l(() => [s("div", null, n(e(t).attachmentRemark), 1)]), _: 1 })])) : N("", true), s("div", ue, [o(X, { uploadable: c.status === e(u).UNREVIEWED.V, "file-classify": e(Z).CONTRACT_VISA.V, showDownload: "", files: e(t).files, "onUpdate:files": a[2] || (a[2] = (r) => e(t).files = r), style: { "padding-bottom": "20px" } }, null, 8, ["uploadable", "file-classify", "files"]), c.status === e(u).UNREVIEWED.V ? (m(), y(x, { key: 0, modelValue: e(t).attachmentRemark, "onUpdate:modelValue": a[3] || (a[3] = (r) => e(t).attachmentRemark = r), type: "textarea", autosize: { minRows: 2, maxRows: 4 }, placeholder: "请填写确签备注", maxlength: "200", "show-word-limit": "" }, null, 8, ["modelValue"])) : N("", true)])]), _: 1 })), [[B, e(d).detailLoading]])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, fe = H(me, [["__scopeId", "data-v-f46b5030"]]);
export {
  fe as default
};
