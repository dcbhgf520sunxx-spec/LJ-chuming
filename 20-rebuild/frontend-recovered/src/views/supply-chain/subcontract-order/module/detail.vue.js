import { ref as b } from "vue";
import { resolveComponent as N } from "vue";
import { resolveDirective as d } from "vue";
import { openBlock as i } from "vue";
import { createBlock as v } from "vue";
import { withCtx as a } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as n } from "vue";
import { unref as e } from "vue";
import { withDirectives as y } from "vue";
import { createElementBlock as c } from "vue";
import { Fragment as g } from "vue";
import { renderList as h } from "vue";
import { createCommentVNode as E } from "vue";
import { ElFormItem as T } from "element-plus";
import { ElForm as B } from "element-plus";
import { _ as L, gt as R, z as $, bD as x, L as j, iy as F } from "../../../../shared/runtime.js";
const z = { class: "project-name" }, S = ["onClick"], q = { __name: "detail", setup(P) {
  const { crud: u, detail: l } = R(), p = b(false), _ = b();
  function k(m) {
    _.value = m.id, p.value = true;
  }
  return (m, f) => {
    const o = T, C = B, D = N("common-dialog"), V = d("parse-time"), w = d("thousand"), I = d("empty-text");
    return i(), v(D, { "append-to-body": "", visible: e(u).detailVisible, "content-loading": e(u).detailLoading, "before-close": e(u).cancelDetail, title: "分包订单详情", "show-close": true, width: "600px" }, { default: a(() => [t(C, { ref: "formRef", size: "default", "label-width": "120px", "label-position": "right" }, { default: a(() => [t(o, { label: "订单编号", prop: "serialNumber" }, { default: a(() => [s("span", null, n(e(l).serialNumber), 1)]), _: 1 }), t(o, { label: "签订日期", prop: "signDate" }, { default: a(() => [y(s("span", null, null, 512), [[V, { val: e(l).signDate, fmt: "{y}-{m}-{d}" }]])]), _: 1 }), t(o, { label: "项目", prop: "projectId" }, { default: a(() => [s("span", z, n(e($)(e(l).project)), 1)]), _: 1 }), t(o, { label: "包含单体", prop: "monomerIds" }, { default: a(() => [(i(true), c(g, null, h(e(l).monomerList, (r) => (i(), c("span", { key: r.id }, n(`【${r.name}】`), 1))), 128))]), _: 1 }), t(o, { label: "分包单位", prop: "supplierId" }, { default: a(() => [s("span", null, n(e(l).supplierName), 1)]), _: 1 }), t(o, { label: "分包类别", prop: "subcontractClassId" }, { default: a(() => [s("span", null, n(e(l).subcontractClassName), 1)]), _: 1 }), t(o, { label: "合同额", prop: "amount" }, { default: a(() => [y(s("span", null, null, 512), [[w, e(l).amount], [I]])]), _: 1 }), t(o, { label: "发票类型", prop: "invoiceType" }, { default: a(() => [s("span", null, n(e(x).VL[e(l).invoiceType]), 1)]), _: 1 }), t(o, { label: "税率", prop: "taxRate" }, { default: a(() => [s("span", null, n(e(l).invoiceType !== e(x).RECEIPT.V ? e(l).taxRate : "-") + "%", 1)]), _: 1 }), t(o, { label: "备注", prop: "remark" }, { default: a(() => [s("span", null, n(e(l).remark), 1)]), _: 1 }), t(o, { label: "附件" }, { default: a(() => [(i(true), c(g, null, h(e(l).attachments, (r) => (i(), c("div", { key: r.id }, [s("span", { style: { cursor: "pointer", color: "#409eff", "margin-left": "3px" }, onClick: (A) => k(r) }, n(r.name), 9, S), t(j, { params: { id: r.id } }, null, 8, ["params"])]))), 128))]), _: 1 })]), _: 1 }, 512), p.value ? (i(), v(F, { key: 0, isVisible: p.value, showType: "attachment", id: _.value, onClose: f[0] || (f[0] = (r) => p.value = false) }, null, 8, ["isVisible", "id"])) : E("", true)]), _: 1 }, 8, ["visible", "content-loading", "before-close"]);
  };
} }, J = L(q, [["__scopeId", "data-v-a2341c2e"]]);
export {
  J as default
};
