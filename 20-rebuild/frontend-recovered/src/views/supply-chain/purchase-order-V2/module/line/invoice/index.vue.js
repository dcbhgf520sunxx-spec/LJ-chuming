import { reactive as l } from "vue";
import { ref as e } from "vue";
import { onMounted as I } from "vue";
import { watch as k } from "vue";
import { provide as m } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as L } from "vue";
import { createVNode as n } from "vue";
import { createElementVNode as d } from "vue";
import { ElInput as R } from "element-plus";
import V from "./header.vue.js";
import B from "./second-table.vue.js";
import N from "./invoice-info.vue.js";
import { _ as g, R as E } from "../../../../../../shared/runtime.js";
import "../../../../../../modules/invoice-entry-fec44303.js";
import "../../../../../../modules/payment-settlement-a7865af1.js";
import "../../../../../../modules/info-bbbe1651.js";
import "../../../../../../modules/payment-settlement-e8e799d8.js";
import "../../../../../../modules/useTableTotal-3d22365a.js";
const S = { class: "drawer-container" }, U = { class: "remark-container box-container" }, $ = { class: "box-container" }, j = { __name: "index", emits: ["component-mounted", "close"], setup(z, { expose: p, emit: u }) {
  const o = l({ supplierId: null, orderId: null, attachmentIds: null, invoiceAmount: null, invoiceSerialNumber: null, paymentId: null, orderInvoiceList: [] }), _ = e(false), f = e([]), v = l({}), r = e(null), x = e([]), i = e(null), h = e([]), b = u;
  I(() => {
    b("component-mounted", true);
  });
  const a = e([]);
  return k(() => a.value, (c) => {
    o.attachmentIds = c.map((t) => t.id);
  }, { deep: true }), m("saveList", h), m("invoice_data", l({ formData: o, attachmentsList: f, secondRef: r, tableList: x, headerRef: i, projectInfo: v })), p({ visible: _, formData: o }), (c, t) => {
    const w = R;
    return y(), L("div", S, [n(V, { ref_key: "headerRef", ref: i, class: "box-container" }, null, 512), n(B, { ref_key: "secondRef", ref: r, class: "box-container" }, null, 512), n(N, { class: "box-container" }), d("div", U, [n(w, { modelValue: o.remark, "onUpdate:modelValue": t[0] || (t[0] = (s) => o.remark = s), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), d("div", $, [n(E, { files: a.value, "onUpdate:files": t[1] || (t[1] = (s) => a.value = s), class: "el-form-item-15", "empty-text": "点击按钮上传附件", "show-download": "", showView: "" }, null, 8, ["files"])])]);
  };
} }, K = g(j, [["__scopeId", "data-v-25d7a0f9"]]);
export {
  K as default
};
