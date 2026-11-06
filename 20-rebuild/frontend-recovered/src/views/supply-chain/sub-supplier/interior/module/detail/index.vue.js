import { ref as D } from "vue";
import { resolveComponent as x } from "vue";
import { resolveDirective as d } from "vue";
import { openBlock as a } from "vue";
import { createBlock as m } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as p } from "vue";
import { unref as e } from "vue";
import { createVNode as o } from "vue";
import { withDirectives as u } from "vue";
import { createElementBlock as n } from "vue";
import { createCommentVNode as r } from "vue";
import { toDisplayString as i } from "vue";
import { ElFormItem as C } from "element-plus";
import { ElDivider as T } from "element-plus";
import { ElForm as j } from "element-plus";
import { _ as E, gt as B, i as R, z as V, bV as z, bD as f, R as F } from "../../../../../../shared/runtime.js";
const I = { class: "main-content" }, M = { class: "form-content" }, L = { class: "form-left" }, q = { key: 0 }, A = { key: 0 }, P = { key: 0 }, S = { key: 1 }, U = { key: 0 }, G = { key: 0 }, H = { key: 0 }, J = { key: 0 }, K = { key: 0 }, O = { key: 0 }, Q = { key: 0 }, W = { key: 0 }, X = { key: 1 }, Y = { key: 0, style: { "word-break": "break-all" } }, Z = { __name: "index", setup($) {
  const b = D(), { crud: c, detail: t } = B();
  return (ee, _) => {
    const l = C, y = T, h = F, k = j, v = x("common-drawer"), N = d("parse-time"), g = d("parse-enum");
    return a(), m(v, { ref_key: "drawerRef", ref: b, "before-close": e(c).cancelDetail, "content-loading": e(c).detailLoading, "show-close": true, visible: e(c).detailVisible, size: "720px", title: "分供合同详情" }, { content: s(() => [p("div", I, [e(R)(e(t)) ? (a(), m(k, { key: 0, model: e(t), "label-position": "left", "label-width": "110px", size: "default" }, { default: s(() => [p("div", M, [p("div", L, [o(l, { label: "日期", prop: "signDate" }, { default: s(() => [e(t).signDate ? u((a(), n("span", q, null, 512)), [[N, { val: e(t).signDate, fmt: "{y}-{m}-{d}" }]]) : r("", true)]), _: 1 }), o(l, { label: "创建人", prop: "userName" }, { default: s(() => [e(t).userName ? (a(), n("span", A, i(e(t).userName), 1)) : r("", true)]), _: 1 }), o(l, { label: "项目经理", prop: "projectManagerName" }, { default: s(() => [e(t).projectManagerName ? (a(), n("span", P, i(e(t).projectManagerName), 1)) : (a(), n("span", S, "-"))]), _: 1 }), o(l, { label: "项目", prop: "project" }, { default: s(() => [e(t).project ? (a(), n("span", U, i(e(V)(e(t).project)), 1)) : r("", true)]), _: 1 }), o(l, { label: "分供类型", prop: "subcontractClassName" }, { default: s(() => [e(t).subcontractClassName ? (a(), n("span", G, i(e(t).subcontractClassName), 1)) : r("", true)]), _: 1 }), o(l, { label: "供应商", prop: "supplierName" }, { default: s(() => [e(t).supplierName ? (a(), n("span", H, i(e(t).supplierName), 1)) : r("", true)]), _: 1 }), o(l, { label: "签约主体", prop: "branchCompany" }, { default: s(() => [e(t).branchCompany.name ? (a(), n("span", J, i(e(t).branchCompany.name), 1)) : r("", true)]), _: 1 }), o(l, { label: "合同编号", prop: "serialNumber" }, { default: s(() => [e(t).serialNumber ? (a(), n("span", K, i(e(t).serialNumber), 1)) : r("", true)]), _: 1 }), o(l, { label: "合同额", prop: "amount" }, { default: s(() => [e(t).amount ? (a(), n("span", O, i(e(z)(e(t).amount)), 1)) : r("", true)]), _: 1 }), o(l, { label: "发票类型", prop: "invoiceType", style: { width: "100%" } }, { default: s(() => [e(t).invoiceType ? u((a(), n("span", Q, null, 512)), [[g, { e: e(f), v: e(t).invoiceType }]]) : r("", true)]), _: 1 }), o(l, { label: "发票税率", prop: "invoiceType", style: { width: "100%" } }, { default: s(() => [e(t).invoiceType !== e(f).RECEIPT.V ? (a(), n("span", W, "（" + i(e(t).taxRate) + "%）", 1)) : (a(), n("span", X, "-"))]), _: 1 }), o(l, { label: "备注信息", prop: "remark", style: { width: "100%" } }, { default: s(() => [e(t).remark ? (a(), n("span", Y, i(e(t).remark), 1)) : r("", true)]), _: 1 }), o(y, null, { default: s(() => _[1] || (_[1] = [p("span", { class: "title" }, "附件", -1)])), _: 1, __: [1] }), o(h, { files: e(t).attachments, "onUpdate:files": _[0] || (_[0] = (w) => e(t).attachments = w), uploadable: false, "empty-text": "暂未上传附件", "show-download": "" }, null, 8, ["files"])])])]), _: 1 }, 8, ["model"])) : r("", true)])]), _: 1 }, 8, ["before-close", "content-loading", "visible"]);
  };
} }, se = E(Z, [["__scopeId", "data-v-85552b3d"]]);
export {
  se as default
};
