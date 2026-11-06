import { computed as P } from "vue";
import { ref as k } from "vue";
import { resolveComponent as V } from "vue";
import { resolveDirective as I } from "vue";
import { openBlock as d } from "vue";
import { createBlock as c } from "vue";
import { withCtx as s } from "vue";
import { withDirectives as R } from "vue";
import { unref as e } from "vue";
import { createTextVNode as N } from "vue";
import { createElementBlock as E } from "vue";
import { createVNode as i } from "vue";
import { createCommentVNode as w } from "vue";
import { createElementVNode as o } from "vue";
import { toDisplayString as r } from "vue";
import { Fragment as L } from "vue";
import { renderList as W } from "vue";
import { ElPopconfirm as $ } from "element-plus";
import { ElFormItem as Y } from "element-plus";
import { ElInput as q } from "element-plus";
import { ElForm as G } from "element-plus";
import { vLoading as H } from "element-plus";
import { d as K } from "../../../../modules/visa-manage-fd5a2300.js";
import { f as M } from "../../../../modules/visa-settle-manage-6a11f3ac.js";
import { _ as J, kD as u, gt as Q, L as D, z as X, ia as Z, S as ee } from "../../../../shared/runtime.js";
import { _ as te } from "../../../../modules/UploadBtn-b4cfb47a.js";
const ae = { key: 0 }, se = { class: "rule-row" }, oe = { class: "project-name" }, le = { class: "rule-row" }, ie = { class: "rule-row" }, ne = { class: "rule-row" }, re = { class: "rule-row" }, de = { class: "rule-row" }, ue = { class: "rule-row" }, me = { class: "item-center" }, ce = { key: 1 }, pe = { __name: "detail", props: { status: { type: Number, default: void 0 }, showType: { type: String, default: void 0 } }, emits: ["success"], setup(_, { emit: T }) {
  const S = T, p = _, U = P(() => p.status === u.UNREVIEWED.V ? "签证单待确签" : "签证单详情"), C = k(), v = k(false), { crud: m, detail: t, CRUD: y } = Q();
  y.HOOK.beforeDetailLoaded = async (b) => {
    try {
      t.files = t.attachments || [];
    } catch {
      b.notify("获取签证单详情失败", y.NOTIFICATION_TYPE.ERROR);
    }
  };
  async function h(b) {
    v.value = true;
    try {
      const a = { id: t.id };
      if (b) {
        if (!t.files.length) {
          m.notify("请上传确签附件", y.NOTIFICATION_TYPE.WARNING);
          return;
        }
        a.status = u.PASS.V, a.attachmentRemark = t.attachmentRemark, a.attachmentIds = t.files.map((g) => g.id);
      } else a.status = u.REFUSE.V;
      await M(a), m.cancelDetail(), S("success");
    } catch {
      m.notify("提交签证单确签信息", y.NOTIFICATION_TYPE.ERROR);
    } finally {
      v.value = false;
    }
  }
  return (b, a) => {
    const g = V("common-button"), A = $, n = Y, O = q, x = G, j = V("common-drawer"), F = I("permission"), z = I("parse-time"), B = H;
    return d(), c(j, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(m).cancelDetail, visible: e(m).detailVisible, title: U.value, "show-close": true, size: "50%" }, { titleRight: s(() => [R((d(), c(D, { params: e(t).id, fn: e(K) }, { default: s(() => a[4] || (a[4] = [N("下载签证单")])), _: 1, __: [4] }, 8, ["params", "fn"])), [[F, e(m).permission.download]]), p.status === e(u).UNREVIEWED.V && _.showType === "audit" ? (d(), E("span", ae, [i(g, { loading: v.value, size: "default", type: "success", onClick: a[0] || (a[0] = (l) => h(true)) }, { default: s(() => a[5] || (a[5] = [N("确 签")])), _: 1, __: [5] }, 8, ["loading"]), i(A, { title: "确定要拒绝此条签证单吗？", onConfirm: a[1] || (a[1] = (l) => h(false)) }, { reference: s(() => [i(g, { loading: v.value, size: "default", type: "danger" }, { default: s(() => a[6] || (a[6] = [N("拒 绝")])), _: 1, __: [6] }, 8, ["loading"])]), _: 1 })])) : w("", true)]), content: s(() => [R((d(), c(x, { ref_key: "formRef", ref: C, size: "default", "label-width": "100px", class: "demo-form" }, { default: s(() => [o("div", se, [i(n, { label: "项目", prop: "project" }, { default: s(() => [o("span", oe, r(e(X)(e(t).project)), 1)]), _: 1 }), i(n, { label: "签证单号", prop: "serialNumber" }, { default: s(() => [o("div", null, r(e(t).serialNumber), 1)]), _: 1 })]), o("div", le, [i(n, { label: "签证日期", prop: "visaDate" }, { default: s(() => [R(o("div", null, null, 512), [[z, { val: e(t).visaDate, fmt: "{y}-{m}-{d}" }]])]), _: 1 }), i(n, { label: "申请人", prop: "userName" }, { default: s(() => [o("div", null, r(e(t).userName), 1)]), _: 1 })]), o("div", ie, [i(n, { label: "施工单位", prop: "contractSignBodyName" }, { default: s(() => {
      var l, f;
      return [o("div", null, r((f = (l = e(t)) == null ? void 0 : l.project) == null ? void 0 : f.contractSignBodyName), 1)];
    }), _: 1 }), i(n, { label: "发包单位", prop: "customerUnit" }, { default: s(() => {
      var l, f;
      return [o("div", null, r((f = (l = e(t)) == null ? void 0 : l.project) == null ? void 0 : f.customerUnit), 1)];
    }), _: 1 })]), o("div", ne, [i(n, { label: "签证原因", prop: "visaDate" }, { default: s(() => [o("div", null, r(e(t).reasonName), 1)]), _: 1 }), i(n, { label: "签证额", prop: "userName" }, { default: s(() => [o("div", null, r(e(t).visaAmount) + "（" + r(e(Z)(e(t).visaAmount)) + "）", 1)]), _: 1 })]), o("div", re, [i(n, { label: "签证备注", prop: "remark" }, { default: s(() => [o("div", null, r(e(t).remark), 1)]), _: 1 })]), o("div", de, [i(n, { label: "监理单位", prop: "supervisionUnit" }, { default: s(() => [o("div", null, r(e(t).supervisionUnit), 1)]), _: 1 })]), o("div", ue, [i(n, { label: "设计单位", prop: "designUnit" }, { default: s(() => [o("div", null, r(e(t).designUnit), 1)]), _: 1 })]), o("div", me, [_.showType === "audit" || p.status === e(u).PASS.V ? (d(), c(n, { key: 0, label: "确签附件" }, { default: s(() => [p.status === e(u).UNREVIEWED.V ? (d(), c(e(te), { key: 0, ref: "uploadRef", files: e(t).files, "onUpdate:files": a[2] || (a[2] = (l) => e(t).files = l), "file-classify": e(ee).CONTRACT_VISA.V, accept: ".pdf,.png,.jpg,.jpeg" }, null, 8, ["files", "file-classify"])) : (d(true), E(L, { key: 1 }, W(e(t).files, (l) => (d(), E("div", { key: l.id }, [N(r(l.name) + " ", 1), i(D, { params: { id: l.id }, size: "default" }, null, 8, ["params"])]))), 128))]), _: 1 })) : w("", true), _.showType === "audit" || p.status === e(u).PASS.V ? (d(), c(n, { key: 1, label: "确签备注" }, { default: s(() => [p.status === e(u).UNREVIEWED.V ? (d(), c(O, { key: 0, modelValue: e(t).attachmentRemark, "onUpdate:modelValue": a[3] || (a[3] = (l) => e(t).attachmentRemark = l), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 2, maxRows: 4 }, placeholder: "请填写确签备注", maxlength: "200", "show-word-limit": "" }, null, 8, ["modelValue"])) : (d(), E("span", ce, r(e(t).attachmentRemark), 1))]), _: 1 })) : w("", true)])]), _: 1 })), [[B, e(m).detailLoading]])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, ge = J(pe, [["__scopeId", "data-v-88e0e0b8"]]);
export {
  ge as default
};
