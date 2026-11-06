import { reactive as l } from "vue";
import { ref as r } from "vue";
import { provide as b } from "vue";
import { watch as h } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as k } from "vue";
import { createVNode as c } from "vue";
import { createBlock as m } from "vue";
import { createCommentVNode as p } from "vue";
import { createElementVNode as d } from "vue";
import { ElInput as v } from "element-plus";
import w from "./header.vue.js";
import I from "./second-table.vue.js";
import V from "./payment-info.vue.js";
import { _ as g, R as B } from "../../../../../../shared/runtime.js";
import "../../../../../../modules/data-e85015ff.js";
import "../../../../../../modules/payment-settlement-a7865af1.js";
import "../../../../../../modules/info-bbbe1651.js";
import "../../../../../../modules/payment-settlement-e8e799d8.js";
import "../../../../../../modules/useTableTotal-3d22365a.js";
import "../../../../../../modules/data-33e35578.js";
const D = { class: "payment-container" }, L = { class: "remark-container box-container" }, R = { class: "box-container" }, N = { __name: "index", setup(T, { expose: _ }) {
  const e = l({ applyDate: (/* @__PURE__ */ new Date()).getTime(), supplierId: null, orderIds: [], attachmentId: [], paymentBank: null, paymentBankAccount: null, tableList: [], supplierPayment: [] }), u = l({}), a = r(null), f = r([]);
  b("payment_data", l({ formData: e, projectInfo: u, tableRef: a, paymentTypelist: f }));
  const o = r([]);
  h(o, (s) => {
    e.attachmentId = s.map((t) => t.id);
  });
  const x = (s) => {
  };
  return _({ formData: e, tableRef: a }), (s, t) => {
    const y = v;
    return i(), k("div", D, [c(w, { class: "box-container" }), e.tableList.length ? (i(), m(I, { key: 0, ref_key: "tableRef", ref: a, class: "box-container" }, null, 512)) : p("", true), e.tableList.length ? (i(), m(V, { key: 1, class: "box-container" })) : p("", true), d("div", L, [c(y, { modelValue: e.remark, "onUpdate:modelValue": t[0] || (t[0] = (n) => e.remark = n), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), d("div", R, [c(B, { files: o.value, "onUpdate:files": [t[1] || (t[1] = (n) => o.value = n), x], "is-restrictt-character": false, class: "el-form-item-15", "empty-text": "点击按钮上传附件", "show-download": "", showView: "" }, null, 8, ["files"])])]);
  };
} }, G = g(N, [["__scopeId", "data-v-2b22e08c"]]);
export {
  G as default
};
