import { ref as w } from "vue";
import { watch as L } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as x } from "vue";
import { createVNode as i } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as v } from "vue";
import { unref as e } from "vue";
import { createBlock as m } from "vue";
import { createTextVNode as h } from "vue";
import { createCommentVNode as u } from "vue";
import { withDirectives as P } from "vue";
import { toDisplayString as y } from "vue";
import { Fragment as z } from "vue";
import { ElTableColumn as U } from "element-plus";
import { ElTag as $ } from "element-plus";
import { ElPopconfirm as q } from "element-plus";
import { vLoading as B } from "element-plus";
import { kc as G, G as f, ab as Q, c3 as c, E as j, p as H, ia as J, bD as F, ac as M, P as O } from "../../../../shared/runtime.js";
import Y from "./add/invoice.vue.js";
import { e as K, h as W } from "../../../../modules/product-recycling-d772694e.js";
import "../../../../modules/UploadBtn-b4cfb47a.js";
const X = { style: { display: "flex", gap: "6px" } }, Z = { key: 0 }, ee = { style: { display: "flex", gap: "6px", "justify-content": "center" } }, te = { key: 2, style: { display: "flex" } }, se = { __name: "invoice-table", props: ["maxHeight", "currentLine"], setup(k) {
  const b = k, g = w();
  L(() => b.currentLine, () => {
    g.value = { ...b.currentLine };
  }, { deep: true, immediate: true });
  const { crud: a } = G(), V = w(), _ = w(false);
  function E() {
    _.value = true, a.toAdd();
  }
  function T(p) {
    g.value = { ...b.currentLine, ...p }, _.value = true, a.toEdit(g.value);
  }
  async function C(p, l) {
    try {
      const s = { auditStatus: l, id: p.id, createInvoiceDate: p.receiveInvoiceDate, invoiceContent: p.invoiceContent, status: "invoice" };
      await K(s), a.notify("操作成功", "success"), a.toQuery();
    } catch (s) {
      console.log(s, "=========>");
    }
  }
  async function I(p) {
    try {
      await W(p.id), a.notify("删除成功", "success"), a.toQuery();
    } catch (l) {
      console.log(l, "=========>");
    }
  }
  return (p, l) => {
    const s = S("common-button"), N = S("print-table"), n = U, D = $, R = q, A = B;
    return r(), x(z, null, [i(e(j), { showGrid: false, showRefresh: false, showSearch: false, class: "invoice-operation" }, { optLeft: o(() => [v("div", X, [e(f)(e(a).permission.add) ? (r(), m(s, { key: 0, class: "filter-item", size: "default", type: "primary", onClick: E }, { default: o(() => l[2] || (l[2] = [h(" 添加 ")])), _: 1, __: [2] })) : u("", true), i(Q, { modelValue: e(a).query.auditStatus, "onUpdate:modelValue": l[0] || (l[0] = (t) => e(a).query.auditStatus = t), options: e(c).ENUM, "show-option-all": true, "unshow-val": [e(c).REJECT.V], size: "default", type: "enum", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "unshow-val", "onChange"])])]), viewLeft: o(() => [e(f)(e(a).permission.print) ? (r(), m(N, { key: 0, params: e(a).query, "api-key": "recoveryInvoiceRecord", size: "default", type: "warning" }, null, 8, ["params"])) : u("", true)]), _: 1 }), P((r(), m(M, { ref_key: "tableRef", ref: V, data: e(a).data, "empty-text": e(a).emptyText, "max-height": k.maxHeight, "show-empty-symbol": false }, { default: o(() => [i(n, { align: "center", label: "序号", type: "index", width: "60" }), i(n, { align: "center", label: "收票日期", prop: "receiveInvoiceDate", width: "140" }, { default: o(({ row: t }) => [(t == null ? void 0 : t.receiveInvoiceDate) !== "-" ? (r(), x("span", Z, y(e(H)(t == null ? void 0 : t.receiveInvoiceDate, "{y}-{m}-{d}")), 1)) : u("", true)]), _: 1 }), i(n, { align: "center", label: "收票额", "min-width": "240" }, { default: o(() => [i(n, { align: "center", label: "金额", "min-width": "120", prop: "invoiceAmount" }), i(n, { align: "center", label: "大写", "min-width": "120" }, { default: o(({ row: t }) => [v("span", null, y(e(J)(t.invoiceAmount)), 1)]), _: 1 })]), _: 1 }), i(n, { align: "center", label: "发票类型", prop: "invoiceType", width: "160" }, { default: o(({ row: t }) => [v("span", null, y(e(F).VL[t.invoiceType]), 1)]), _: 1 }), i(n, { align: "center", label: "税率", prop: "taxRate" }, { default: o(({ row: t }) => [v("span", null, y(t.taxRate) + "%", 1)]), _: 1 }), i(n, { align: "center", label: "税额", "min-width": "120", prop: "tax" }), i(n, { align: "center", label: "不含税金额", "min-width": "120", prop: "amountExcludingTax" }), i(n, { align: "center", label: "开票单位", "min-width": "260", prop: "supplierName", "show-overflow-tooltip": "" }), i(n, { align: "center", label: "收票单位", "min-width": "260", prop: "branchCompanyName", "show-overflow-tooltip": "" }), i(n, { align: "center", label: "发票号码", "min-width": "220", prop: "invoiceSerialNumber", "show-overflow-tooltip": "" }), i(n, { align: "center", label: "发票内容", "min-width": "200", prop: "invoiceContent", "show-overflow-tooltip": "" }), i(n, { align: "center", label: "备注", "min-width": "180", prop: "remark", "show-overflow-tooltip": "" }), i(n, { align: "center", label: "办理人", prop: "applyUserName", width: "100" }), i(n, { align: "center", label: "审核人", prop: "auditUserName", width: "100" }), i(n, { align: "center", label: "审核状态", prop: "auditStatus", width: "100" }, { default: o(({ row: t }) => {
      var d;
      return [i(D, { type: (d = e(c).V[t.auditStatus]) == null ? void 0 : d.TYPE }, { default: o(() => [h(y(e(c).VL[t.auditStatus]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 }), e(f)([...e(a).permission.edit, ...e(a).permission.del, ...e(a).permission.review]) ? (r(), m(n, { key: 0, align: "center", fixed: "right", label: "操作", width: "240" }, { default: o(({ row: t }) => [v("section", ee, [e(f)(e(a).permission.edit) && t.auditStatus !== e(c).PASS.V ? (r(), m(s, { key: 0, icon: "el-icon-edit", size: "default", type: "primary", onClick: (d) => T(t) }, null, 8, ["onClick"])) : u("", true), e(f)(e(a).permission.del) && t.auditStatus !== e(c).PASS.V ? (r(), m(R, { key: 1, style: { margin: "0" }, title: "是否确认删除？", onConfirm: (d) => I(t) }, { reference: o(() => [i(s, { icon: "el-icon-delete", size: "default", style: { margin: "0" }, type: "danger" })]), _: 2 }, 1032, ["onConfirm"])) : u("", true), t.auditStatus === e(c).AUDITING.V && e(f)(e(a).permission.review) ? (r(), x("section", te, [i(s, { size: "default", type: "success", onClick: (d) => C(t, e(c).PASS.V) }, { default: o(() => l[3] || (l[3] = [h("通过")])), _: 2, __: [3] }, 1032, ["onClick"]), i(s, { size: "default", type: "danger", onClick: (d) => C(t, e(c).REJECT.V) }, { default: o(() => l[4] || (l[4] = [h("拒绝")])), _: 2, __: [4] }, 1032, ["onClick"])])) : u("", true)])]), _: 1 })) : u("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[A, e(a).loading]]), i(O, { class: "invoice-pagination" }), i(Y, { visible: _.value, "onUpdate:visible": l[1] || (l[1] = (t) => _.value = t), "detail-info": g.value }, null, 8, ["visible", "detail-info"])], 64);
  };
} };
export {
  se as default
};
