import { reactive as l } from "vue";
import { ref as r } from "vue";
import { provide as y } from "vue";
import { watch as h } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as c } from "vue";
import { createBlock as m } from "vue";
import { createCommentVNode as p } from "vue";
import { createElementVNode as d } from "vue";
import { ElInput as k } from "element-plus";
import v from "./header.vue.js";
import w from "./second-table.vue.js";
import I from "./payment-info.vue.js";
import { _ as g, R as B } from "../../../../../../../shared/runtime.js";
import "../../../../../../../modules/data-2d709dfa.js";
import "../../../../../../../modules/payment-settlement-a7865af1.js";
import "../../../../../../../modules/hook-467b8301.js";
import "../../../../../../../modules/useTableTotal-3d22365a.js";
import "../../../../../../../modules/data-33e35578.js";
const V = { class: "payment-container" }, D = { class: "remark-container box-container" }, L = { class: "box-container" }, R = { __name: "index", setup(N, { expose: _ }) {
  const e = l({ applyDate: (/* @__PURE__ */ new Date()).getTime(), supplierId: null, orderIds: [], attachmentId: [], paymentBank: null, paymentBankAccount: null, tableList: [], supplierPayment: [] }), u = l({}), a = r(null), f = r([]);
  y("payment_data", l({ formData: e, projectInfo: u, tableRef: a, paymentTypelist: f }));
  const o = r([]);
  return h(() => o.value, (n) => {
    n.length > 0 ? e.attachmentId = n.map((t) => t.id) : e.attachmentId = [];
  }, { deep: true }), _({ formData: e, tableRef: a }), (n, t) => {
    const x = k;
    return i(), b("div", V, [c(v, { class: "box-container" }), e.tableList.length ? (i(), m(w, { key: 0, ref_key: "tableRef", ref: a, class: "box-container" }, null, 512)) : p("", true), e.tableList.length ? (i(), m(I, { key: 1, class: "box-container" })) : p("", true), d("div", D, [c(x, { modelValue: e.remark, "onUpdate:modelValue": t[0] || (t[0] = (s) => e.remark = s), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), d("div", L, [c(B, { files: o.value, "onUpdate:files": t[1] || (t[1] = (s) => o.value = s), class: "el-form-item-15", "empty-text": "点击按钮上传附件", "show-download": "", showView: "" }, null, 8, ["files"])])]);
  };
} }, q = g(R, [["__scopeId", "data-v-8e901e02"]]);
export {
  q as default
};
