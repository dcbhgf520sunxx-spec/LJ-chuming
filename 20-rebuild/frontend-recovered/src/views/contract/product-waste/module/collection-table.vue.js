import { ref as k } from "vue";
import { watch as z } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as h } from "vue";
import { createVNode as a } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as v } from "vue";
import { unref as e } from "vue";
import { createBlock as f } from "vue";
import { createTextVNode as b } from "vue";
import { createCommentVNode as p } from "vue";
import { withDirectives as B } from "vue";
import { toDisplayString as _ } from "vue";
import { Fragment as U } from "vue";
import { ElTableColumn as $ } from "element-plus";
import { ElTag as q } from "element-plus";
import { ElPopconfirm as M } from "element-plus";
import { vLoading as G } from "element-plus";
import { kc as I, g8 as Q, G as y, ab as j, c3 as c, E as F, p as H, ia as J, iv as O, ac as Y, P as K } from "../../../../shared/runtime.js";
import W from "./add/collection.vue.js";
import { e as X, f as Z } from "../../../../modules/product-waste-c86c76d6.js";
import "../../../../modules/scrap-sell-e306ced6.js";
const ee = { style: { display: "flex", gap: "6px" } }, te = { key: 0 }, ae = { key: 0 }, ne = { style: { display: "flex", gap: "6px", "justify-content": "center" } }, ie = { key: 2, style: { display: "flex" } }, ue = { __name: "collection-table", props: ["maxHeight", "currentLine"], setup(C) {
  const w = C, d = k();
  z(() => w.currentLine, (u) => {
    d.value = u;
  }, { deep: true, immediate: true });
  const { crud: n } = I(), V = k(), g = k(false), E = Q(["payment_reason"]);
  function R() {
    d.value = { ...w.currentLine }, g.value = true, n.toAdd();
  }
  function A(u) {
    d.value = { ...w.currentLine, ...u, status: "collection" }, g.value = true, n.toEdit(d.value);
  }
  async function x(u, l) {
    try {
      const r = { auditStatus: l, id: u.id, status: "collection" };
      await X(r), n.notify("操作成功", "success"), n.toQuery();
    } catch (r) {
      console.log(r, "=========>");
    }
  }
  async function T(u) {
    try {
      await Z(u.id), n.notify("删除成功", "success"), n.toQuery();
    } catch (l) {
      console.log(l, "=========>");
    }
  }
  return (u, l) => {
    const r = S("common-button"), D = S("print-table"), i = $, L = q, P = M, N = G;
    return s(), h(U, null, [a(e(F), { showGrid: false, showRefresh: false, showSearch: false }, { optLeft: o(() => [v("div", ee, [e(y)(e(n).permission.add) ? (s(), f(r, { key: 0, class: "filter-item", size: "default", type: "primary", onClick: R }, { default: o(() => l[2] || (l[2] = [b(" 添加 ")])), _: 1, __: [2] })) : p("", true), a(j, { modelValue: e(n).query.auditStatus, "onUpdate:modelValue": l[0] || (l[0] = (t) => e(n).query.auditStatus = t), options: e(c).ENUM, "show-option-all": true, "unshow-val": [e(c).REJECT.V], size: "default", type: "enum", onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "unshow-val", "onChange"])])]), viewLeft: o(() => [e(y)(e(n).permission.print) ? (s(), f(D, { key: 0, params: e(n).query, "api-key": "productCollectionRecord", size: "default", type: "warning" }, null, 8, ["params"])) : p("", true)]), _: 1 }), B((s(), f(Y, { ref_key: "tableRef", ref: V, data: e(n).data, "empty-text": e(n).emptyText, "max-height": C.maxHeight, "show-empty-symbol": false }, { default: o(() => [a(i, { align: "center", label: "序号", type: "index", width: "60" }), a(i, { align: "center", label: "收款日期", prop: "collectionDate", width: "140" }, { default: o(({ row: t }) => [t.collectionDate !== "-" ? (s(), h("span", te, _(e(H)(t == null ? void 0 : t.collectionDate, "{y}-{m}-{d}")), 1)) : p("", true)]), _: 1 }), a(i, { align: "center", label: "收款金额", "min-width": "240" }, { default: o(() => [a(i, { align: "center", label: "金额", "min-width": "120", prop: "collectionAmount" }), a(i, { align: "center", label: "大写", "min-width": "120", "show-overflow-tooltip": "" }, { default: o(({ row: t }) => [v("span", null, _(e(J)(t == null ? void 0 : t.collectionAmount)), 1)]), _: 1 })]), _: 1 }), a(i, { align: "center", label: "收款事由", prop: "collectionReason", width: "140" }, { default: o(({ row: t }) => [t.collectionReason !== "-" ? (s(), h("span", ae, _(e(E).label.payment_reason[t.collectionReason]), 1)) : p("", true)]), _: 1 }), a(i, { align: "center", label: "收款方式", prop: "collectionMode", width: "140" }, { default: o(({ row: t }) => [v("span", null, _(e(O).VL[t.collectionMode]), 1)]), _: 1 }), a(i, { align: "center", label: "收款单位", "min-width": "240", prop: "collectionUnit", "show-overflow-tooltip": "" }), a(i, { align: "center", label: "收款银行", "min-width": "200", prop: "collectionDepositBank", "show-overflow-tooltip": "" }), a(i, { align: "center", label: "银行卡号", "min-width": "180", prop: "collectionBankAccount", "show-overflow-tooltip": "" }), a(i, { align: "center", label: "付款单位", "min-width": "180", prop: "paymentUnit", "show-overflow-tooltip": "" }), a(i, { align: "center", label: "备注", "min-width": "180", prop: "remark", "show-overflow-tooltip": "" }), a(i, { align: "center", label: "办理人", prop: "writtenByName", width: "100" }), a(i, { align: "center", label: "审核人", prop: "auditorName", width: "100" }), a(i, { align: "center", label: "审核状态", prop: "auditStatus" }, { default: o(({ row: t }) => {
      var m;
      return [a(L, { type: (m = e(c).V[t.auditStatus]) == null ? void 0 : m.TYPE }, { default: o(() => [b(_(e(c).VL[t.auditStatus]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 }), e(y)([...e(n).permission.edit, ...e(n).permission.del, ...e(n).permission.review]) ? (s(), f(i, { key: 0, align: "center", fixed: "right", label: "操作", prop: "auditStatus", width: "240" }, { default: o(({ row: t }) => [v("section", ne, [e(y)(e(n).permission.edit) && t.auditStatus !== e(c).PASS.V ? (s(), f(r, { key: 0, icon: "el-icon-edit", size: "default", type: "primary", onClick: (m) => A(t) }, null, 8, ["onClick"])) : p("", true), e(y)(e(n).permission.del) && t.auditStatus !== e(c).PASS.V ? (s(), f(P, { key: 1, style: { margin: "0" }, title: "是否确认删除？", onConfirm: (m) => T(t) }, { reference: o(() => [a(r, { icon: "el-icon-delete", size: "default", style: { margin: "0" }, type: "danger" })]), _: 2 }, 1032, ["onConfirm"])) : p("", true), t.auditStatus === e(c).AUDITING.V && e(y)(e(n).permission.review) ? (s(), h("section", ie, [a(r, { size: "default", type: "success", onClick: (m) => x(t, e(c).PASS.V) }, { default: o(() => l[3] || (l[3] = [b("通过")])), _: 2, __: [3] }, 1032, ["onClick"]), a(r, { size: "default", type: "danger", onClick: (m) => x(t, e(c).REJECT.V) }, { default: o(() => l[4] || (l[4] = [b("拒绝")])), _: 2, __: [4] }, 1032, ["onClick"])])) : p("", true)])]), _: 1 })) : p("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[N, e(n).loading]]), a(K), a(W, { visible: g.value, "onUpdate:visible": l[1] || (l[1] = (t) => g.value = t), "current-row": d.value, "detail-info": d.value }, null, 8, ["visible", "current-row", "detail-info"])], 64);
  };
} };
export {
  ue as default
};
