import { reactive as l } from "vue";
import { ref as r } from "vue";
import { provide as k } from "vue";
import { watch as v } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as w } from "vue";
import { createVNode as i } from "vue";
import { createBlock as d } from "vue";
import { createCommentVNode as _ } from "vue";
import { createElementVNode as u } from "vue";
import { ElInput as I } from "element-plus";
import g from "./header.vue.js";
import B from "./second-table.vue.js";
import V from "./payment-info.vue.js";
import { _ as D, R as L } from "../../../../../../shared/runtime.js";
import "../../../../../../modules/data-33e35578.js";
import "../../../../../../modules/payment-settlement-a7865af1.js";
import "../../../../../../modules/hook-467b8301.js";
import "../../../../../../modules/useTableTotal-3d22365a.js";
import "../../storage-detail.vue.js";
const R = { class: "payment-container" }, N = { class: "remark-container box-container" }, T = { class: "box-container" }, E = { __name: "index", setup(U, { expose: f }) {
  const e = l({ applyDate: (/* @__PURE__ */ new Date()).getTime(), supplierId: null, orderIds: [], attachmentId: [], paymentBank: null, paymentBankAccount: null, tableList: [], supplierPayment: [] }), x = l({}), o = r(null), y = r([]);
  k("payment_data", l({ formData: e, projectInfo: x, tableRef: o, paymentTypelist: y }));
  const s = r([]);
  v(() => s.value, (a) => {
    a.length > 0 ? e.attachmentId = a.map((t) => t.id) : e.attachmentId = [];
  }, { deep: true });
  const b = (a) => {
  };
  return f({ formData: e, tableRef: o }), (a, t) => {
    var m, p;
    const h = I;
    return c(), w("div", R, [i(g, { class: "box-container" }), (m = e.tableList) != null && m.length ? (c(), d(B, { key: 0, ref_key: "tableRef", ref: o, class: "box-container" }, null, 512)) : _("", true), (p = e.tableList) != null && p.length ? (c(), d(V, { key: 1, class: "box-container" })) : _("", true), u("div", N, [i(h, { modelValue: e.remark, "onUpdate:modelValue": t[0] || (t[0] = (n) => e.remark = n), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), u("div", T, [i(L, { files: s.value, "onUpdate:files": [t[1] || (t[1] = (n) => s.value = n), b], "is-restrictt-character": false, class: "el-form-item-15", "empty-text": "点击按钮上传附件", "show-download": "", showView: "" }, null, 8, ["files"])])]);
  };
} }, H = D(E, [["__scopeId", "data-v-c892cdb7"]]);
export {
  H as default
};
