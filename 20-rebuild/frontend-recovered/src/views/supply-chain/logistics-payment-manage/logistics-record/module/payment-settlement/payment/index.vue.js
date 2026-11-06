import { reactive as c } from "vue";
import { ref as d } from "vue";
import { provide as I } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as p } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as t } from "vue";
import { createBlock as u } from "vue";
import { createCommentVNode as f } from "vue";
import { withCtx as o } from "vue";
import { createTextVNode as h } from "vue";
import { Fragment as V } from "vue";
import { renderList as E } from "vue";
import { toDisplayString as N } from "vue";
import { ElCol as C } from "element-plus";
import { ElButton as L } from "element-plus";
import { ElUpload as R } from "element-plus";
import { ElRow as D } from "element-plus";
import { ElInput as S } from "element-plus";
import j from "./header.vue.js";
import z from "./second-table.vue.js";
import A from "./payment-info.vue.js";
import { u as F } from "../../../../../../../modules/upload-file-download-812f558c.js";
import { _ as P, uG as T } from "../../../../../../../shared/runtime.js";
import "../../../../../../../modules/data-50c44b01.js";
import "../../../../../../../modules/useSelect-654af12a.js";
import "../../../../../../../modules/payment-settlement-a7865af1.js";
import "../../../../../../../modules/data-33e35578.js";
const U = { class: "payment-container" }, $ = { class: "box-container" }, G = { class: "box-container" }, q = { class: "box-container" }, H = { class: "attachment-container box-container" }, J = { class: "remark-container box-container" }, K = { __name: "index", setup(M, { expose: b }) {
  const a = c({ supplierId: null, orderIds: [], attachmentId: [], paymentBank: null, paymentBankAccount: null, tableList: [], supplierPayment: [] }), x = c({}), i = d(null);
  I("payment_data", c({ formData: a, projectInfo: x, tableRef: i }));
  const m = d([]), y = async (_) => {
    const { id: e, data: n } = await F(_, T);
    a.attachmentId.push(e), m.value.push(n[0].name);
  };
  return b({ formData: a, tableRef: i }), (_, e) => {
    const n = C, v = L, k = R, g = D, w = S;
    return s(), p("div", U, [l("div", $, [t(j)]), l("div", G, [a.tableList.length ? (s(), u(z, { key: 0, ref_key: "tableRef", ref: i }, null, 512)) : f("", true)]), l("div", q, [a.tableList.length ? (s(), u(A, { key: 0 })) : f("", true)]), l("div", H, [t(g, null, { default: o(() => [t(n, { span: 3, class: "col-container" }, { default: o(() => e[1] || (e[1] = [h(" 附件 ")])), _: 1, __: [1] }), t(n, { span: 18, class: "col-container" }, { default: o(() => [(s(true), p(V, null, E(m.value, (r, B) => (s(), p("span", { key: B, class: "fileName-container" }, N(r), 1))), 128))]), _: 1 }), t(n, { span: 3, class: "col-container upload-container" }, { default: o(() => [t(k, { "auto-upload": false, "on-change": y, "show-file-list": false, action: "#", multiple: "" }, { default: o(() => [t(v, { icon: "el-icon-upload", plain: "", size: "mini", type: "primary" }, { default: o(() => e[2] || (e[2] = [h("导入")])), _: 1, __: [2] })]), _: 1 })]), _: 1 })]), _: 1 })]), l("div", J, [t(w, { modelValue: a.remark, "onUpdate:modelValue": e[0] || (e[0] = (r) => a.remark = r), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])])]);
  };
} }, le = P(K, [["__scopeId", "data-v-5478bd2c"]]);
export {
  le as default
};
