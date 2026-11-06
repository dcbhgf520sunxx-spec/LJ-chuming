import { ref as k } from "vue";
import { watch as R } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as w } from "vue";
import { createVNode as a } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as g } from "vue";
import { unref as e } from "vue";
import { createBlock as c } from "vue";
import { createTextVNode as _ } from "vue";
import { createCommentVNode as u } from "vue";
import { withDirectives as U } from "vue";
import { toDisplayString as v } from "vue";
import { Fragment as z } from "vue";
import { ElTableColumn as D } from "element-plus";
import { ElTag as M } from "element-plus";
import { ElPopconfirm as $ } from "element-plus";
import { vLoading as q } from "element-plus";
import { kc as I, G as y, ab as G, c3 as d, E as Q, p as j, ia as F, iv as H, ac as J, P as O } from "../../../../shared/runtime.js";
import Y from "./add/payment.vue.js";
import { e as K, f as W } from "../../../../modules/product-recycling-d772694e.js";
import "../../../../modules/UploadBtn-b4cfb47a.js";
const X = { style: { display: "flex", gap: "6px" } }, Z = { key: 0 }, ee = { style: { display: "flex", gap: "6px", "justify-content": "center" } }, te = { key: 2, style: { display: "flex" } }, se = { __name: "payment-table", props: ["maxHeight", "currentLine"], setup(x) {
  const b = x, f = k();
  R(() => b.currentLine, () => {
    f.value = { ...b.currentLine };
  }, { deep: true, immediate: true });
  const { crud: n } = I(), V = k(), h = k(false);
  function E() {
    h.value = true, n.toAdd();
  }
  function A(s) {
    f.value = { ...b.currentLine, ...s, status: "payment" }, h.value = true, n.toEdit(f.value);
  }
  async function C(s, l) {
    try {
      const r = { auditStatus: l, id: s.id, paymentBank: s.paymentBank, paymentBankAccount: s.paymentBankAccount, paymentMethod: s.paymentMethod, status: "payment" };
      await K(r), n.notify("操作成功", "success"), n.toQuery();
    } catch (r) {
      console.log(r, "=========>");
    }
  }
  async function P(s) {
    try {
      await W(s.id), n.notify("删除成功", "success"), n.toQuery();
    } catch (l) {
      console.log(l, "=========>");
    }
  }
  return (s, l) => {
    const r = S("common-button"), B = S("print-table"), i = D, T = M, L = $, N = q;
    return p(), w(z, null, [a(e(Q), { showGrid: false, showRefresh: false, showSearch: false }, { optLeft: o(() => [g("div", X, [e(y)(e(n).permission.add) ? (p(), c(r, { key: 0, class: "filter-item", size: "default", type: "primary", onClick: E }, { default: o(() => l[2] || (l[2] = [_(" 添加 ")])), _: 1, __: [2] })) : u("", true), a(G, { modelValue: e(n).query.auditStatus, "onUpdate:modelValue": l[0] || (l[0] = (t) => e(n).query.auditStatus = t), options: e(d).ENUM, "show-option-all": true, "unshow-val": [e(d).REJECT.V], size: "default", type: "enum", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "unshow-val", "onChange"])])]), viewLeft: o(() => [e(y)(e(n).permission.print) ? (p(), c(B, { key: 0, params: e(n).query, "api-key": "recoveryPaymentRecord", size: "default", type: "warning" }, null, 8, ["params"])) : u("", true)]), _: 1 }), U((p(), c(J, { ref_key: "tableRef", ref: V, data: e(n).data, "empty-text": e(n).emptyText, "max-height": x.maxHeight, "show-empty-symbol": false }, { default: o(() => [a(i, { align: "center", label: "序号", type: "index", width: "60" }), a(i, { align: "center", label: "付款日期", prop: "paymentDate", width: "140" }, { default: o(({ row: t }) => [t.paymentDate !== "-" ? (p(), w("span", Z, v(e(j)(t == null ? void 0 : t.paymentDate, "{y}-{m}-{d}")), 1)) : u("", true)]), _: 1 }), a(i, { align: "center", label: "付款金额", "min-width": "240" }, { default: o(() => [a(i, { align: "center", label: "金额", "min-width": "120", prop: "applyAmount" }), a(i, { align: "center", label: "大写", "min-width": "120", "show-overflow-tooltip": "" }, { default: o(({ row: t }) => [g("span", null, v(e(F)(t == null ? void 0 : t.applyAmount)), 1)]), _: 1 })]), _: 1 }), a(i, { align: "center", label: "付款事由", prop: "paymentReasonName", width: "120" }), a(i, { align: "center", label: "付款方式", prop: "paymentMethod", width: "120" }, { default: o(({ row: t }) => [g("span", null, v(e(H).VL[t.paymentMethod]), 1)]), _: 1 }), a(i, { align: "center", label: "付款单位", "min-width": "240", prop: "paymentUnit", "show-overflow-tooltip": "" }), a(i, { align: "center", label: "付款银行", "min-width": "200", prop: "paymentBank", "show-overflow-tooltip": "" }), a(i, { align: "center", label: "银行卡号", "min-width": "200", prop: "paymentBankAccount", "show-overflow-tooltip": "" }), a(i, { align: "center", label: "收款单位", "min-width": "240", prop: "receivingUnit", "show-overflow-tooltip": "" }), a(i, { align: "center", label: "备注", "min-width": "180", prop: "remark", "show-overflow-tooltip": "" }), a(i, { align: "center", label: "办理人", prop: "applyUserName", width: "100" }), a(i, { align: "center", label: "审核人", prop: "auditUserName", width: "100" }), a(i, { align: "center", label: "审核状态", prop: "auditStatus", width: "100" }, { default: o(({ row: t }) => {
      var m;
      return [a(T, { type: (m = e(d).V[t.auditStatus]) == null ? void 0 : m.TYPE }, { default: o(() => [_(v(e(d).VL[t.auditStatus]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 }), e(y)([...e(n).permission.edit, ...e(n).permission.del, ...e(n).permission.review]) ? (p(), c(i, { key: 0, align: "center", fixed: "right", label: "操作", width: "240" }, { default: o(({ row: t }) => [g("section", ee, [e(y)(e(n).permission.edit) && t.auditStatus !== e(d).PASS.V ? (p(), c(r, { key: 0, icon: "el-icon-edit", size: "default", type: "primary", onClick: (m) => A(t) }, null, 8, ["onClick"])) : u("", true), e(y)(e(n).permission.del) && t.auditStatus !== e(d).PASS.V ? (p(), c(L, { key: 1, style: { margin: "0" }, title: "是否确认删除？", onConfirm: (m) => P(t) }, { reference: o(() => [a(r, { icon: "el-icon-delete", size: "default", style: { margin: "0" }, type: "danger" })]), _: 2 }, 1032, ["onConfirm"])) : u("", true), t.auditStatus === e(d).AUDITING.V && e(y)(e(n).permission.review) ? (p(), w("section", te, [a(r, { size: "default", type: "success", onClick: (m) => C(t, e(d).PASS.V) }, { default: o(() => l[3] || (l[3] = [_("通过")])), _: 2, __: [3] }, 1032, ["onClick"]), a(r, { size: "default", type: "danger", onClick: (m) => C(t, e(d).REJECT.V) }, { default: o(() => l[4] || (l[4] = [_("拒绝")])), _: 2, __: [4] }, 1032, ["onClick"])])) : u("", true)])]), _: 1 })) : u("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[N, e(n).loading]]), a(O), a(Y, { visible: h.value, "onUpdate:visible": l[1] || (l[1] = (t) => h.value = t), "detail-info": f.value }, null, 8, ["visible", "detail-info"])], 64);
  };
} };
export {
  se as default
};
