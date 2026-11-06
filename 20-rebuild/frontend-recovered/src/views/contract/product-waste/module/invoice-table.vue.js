import { ref as w } from "vue";
import { watch as I } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as x } from "vue";
import { createVNode as i } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as y } from "vue";
import { unref as e } from "vue";
import { createBlock as m } from "vue";
import { createTextVNode as h } from "vue";
import { createCommentVNode as u } from "vue";
import { withDirectives as P } from "vue";
import { toDisplayString as g } from "vue";
import { Fragment as z } from "vue";
import { ElTableColumn as U } from "element-plus";
import { ElTag as $ } from "element-plus";
import { ElPopconfirm as B } from "element-plus";
import { vLoading as q } from "element-plus";
import { kc as G, G as f, ab as Q, c3 as c, E as j, p as H, ia as J, bD as F, ac as M, P as O } from "../../../../shared/runtime.js";
import Y from "./add/invoice.vue.js";
import { e as K, h as W } from "../../../../modules/product-waste-c86c76d6.js";
const X = { style: { display: "flex", gap: "6px" } }, Z = { key: 0 }, ee = { style: { display: "flex", gap: "6px", "justify-content": "center" } }, te = { key: 2, style: { display: "flex" } }, le = { __name: "invoice-table", props: ["maxHeight", "currentLine"], setup(k) {
  const b = k, v = w();
  I(() => b.currentLine, () => {
    v.value = { ...b.currentLine };
  }, { deep: true, immediate: true });
  const { crud: a } = G(), V = w(), _ = w(false);
  function E() {
    _.value = true, a.toAdd();
  }
  function T(p) {
    v.value = { ...b.currentLine, ...p }, _.value = true, a.toEdit(v.value);
  }
  async function C(p, l) {
    try {
      const s = { auditStatus: l, id: p.id, createInvoiceDate: p.receiveInvoiceDate, invoiceContent: p.invoiceContent, status: "invoice" };
      await K(s), a.notify("操作成功", "success"), a.toQuery();
    } catch (s) {
      console.log(s, "=========>");
    }
  }
  async function D(p) {
    try {
      await W(p.id), a.notify("删除成功", "success"), a.toQuery();
    } catch (l) {
      console.log(l, "=========>");
    }
  }
  return (p, l) => {
    const s = S("common-button"), R = S("print-table"), n = U, A = $, L = B, N = q;
    return r(), x(z, null, [i(e(j), { showGrid: false, showRefresh: false, showSearch: false, class: "invoice-operation" }, { optLeft: o(() => [y("div", X, [e(f)(e(a).permission.add) ? (r(), m(s, { key: 0, class: "filter-item", size: "default", type: "primary", onClick: E }, { default: o(() => l[2] || (l[2] = [h(" 添加 ")])), _: 1, __: [2] })) : u("", true), i(Q, { modelValue: e(a).query.auditStatus, "onUpdate:modelValue": l[0] || (l[0] = (t) => e(a).query.auditStatus = t), options: e(c).ENUM, "show-option-all": true, "unshow-val": [e(c).REJECT.V], size: "default", type: "enum", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "unshow-val", "onChange"])])]), viewLeft: o(() => [e(f)(e(a).permission.print) ? (r(), m(R, { key: 0, params: e(a).query, "api-key": "productInvoiceRecord", size: "default", type: "warning" }, null, 8, ["params"])) : u("", true)]), _: 1 }), P((r(), m(M, { ref_key: "tableRef", ref: V, data: e(a).data, "empty-text": e(a).emptyText, "max-height": k.maxHeight, "show-empty-symbol": false }, { default: o(() => [i(n, { align: "center", label: "序号", type: "index", width: "60" }), i(n, { align: "center", label: "开票日期", prop: "invoiceDate", width: "140" }, { default: o(({ row: t }) => [(t == null ? void 0 : t.invoiceDate) !== "-" ? (r(), x("span", Z, g(e(H)(t == null ? void 0 : t.invoiceDate, "{y}-{m}-{d}")), 1)) : u("", true)]), _: 1 }), i(n, { align: "center", label: "开票", "min-width": "240" }, { default: o(() => [i(n, { "min-width": 120, align: "center", label: "金额", prop: "invoiceAmount" }), i(n, { align: "center", label: "大写", "min-width": "120" }, { default: o(({ row: t }) => [y("span", null, g(e(J)(t.invoiceAmount)), 1)]), _: 1 })]), _: 1 }), i(n, { align: "center", label: "发票类型", prop: "invoiceType", width: "140" }, { default: o(({ row: t }) => [y("span", null, g(e(F).VL[t.invoiceType]), 1)]), _: 1 }), i(n, { align: "center", label: "税率", prop: "taxRate" }, { default: o(({ row: t }) => [y("span", null, g(t.taxRate) + "%", 1)]), _: 1 }), i(n, { align: "center", label: "税额", prop: "tax" }), i(n, { align: "center", label: "不含税金额", "min-width": "120", prop: "amountExcludingTax" }), i(n, { align: "center", label: "开票单位", "min-width": "240", prop: "invoiceUnit", "show-overflow-tooltip": "" }), i(n, { align: "center", label: "收票单位", "min-width": "240", prop: "collectionUnit", "show-overflow-tooltip": "" }), i(n, { align: "center", label: "发票号码", "min-width": "200", prop: "invoiceNo", "show-overflow-tooltip": "" }), i(n, { align: "center", label: "发票内容", prop: "invoiceContent", "show-overflow-tooltip": "" }), i(n, { align: "center", label: "备注", "min-width": "180", prop: "remark", "show-overflow-tooltip": "" }), i(n, { align: "center", label: "办理人", prop: "writtenByName", width: "100" }), i(n, { align: "center", label: "审核人", prop: "auditorName", width: "100" }), i(n, { align: "center", label: "审核状态", prop: "auditStatus" }, { default: o(({ row: t }) => {
      var d;
      return [i(A, { type: (d = e(c).V[t.auditStatus]) == null ? void 0 : d.TYPE }, { default: o(() => [h(g(e(c).VL[t.auditStatus]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 }), e(f)([...e(a).permission.edit, ...e(a).permission.del, ...e(a).permission.review]) ? (r(), m(n, { key: 0, align: "center", fixed: "right", label: "操作", prop: "auditStatus", width: "240" }, { default: o(({ row: t }) => [y("section", ee, [e(f)(e(a).permission.edit) && t.auditStatus !== e(c).PASS.V ? (r(), m(s, { key: 0, icon: "el-icon-edit", size: "default", type: "primary", onClick: (d) => T(t) }, null, 8, ["onClick"])) : u("", true), e(f)(e(a).permission.del) && t.auditStatus !== e(c).PASS.V ? (r(), m(L, { key: 1, style: { margin: "0" }, title: "是否确认删除？", onConfirm: (d) => D(t) }, { reference: o(() => [i(s, { icon: "el-icon-delete", size: "default", style: { margin: "0" }, type: "danger" })]), _: 2 }, 1032, ["onConfirm"])) : u("", true), t.auditStatus === e(c).AUDITING.V && e(f)(e(a).permission.review) ? (r(), x("section", te, [i(s, { size: "default", type: "success", onClick: (d) => C(t, e(c).PASS.V) }, { default: o(() => l[3] || (l[3] = [h("通过")])), _: 2, __: [3] }, 1032, ["onClick"]), i(s, { size: "default", type: "danger", onClick: (d) => C(t, e(c).REJECT.V) }, { default: o(() => l[4] || (l[4] = [h("拒绝")])), _: 2, __: [4] }, 1032, ["onClick"])])) : u("", true)])]), _: 1 })) : u("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[N, e(a).loading]]), i(O, { class: "invoice-pagination" }), i(Y, { visible: _.value, "onUpdate:visible": l[1] || (l[1] = (t) => _.value = t), "current-row": v.value, "detail-info": v.value }, null, 8, ["visible", "current-row", "detail-info"])], 64);
  };
} };
export {
  le as default
};
