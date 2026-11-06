import { reactive as r } from "vue";
import { ref as e } from "vue";
import { onMounted as k } from "vue";
import { watch as w } from "vue";
import { provide as m } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as n } from "vue";
import { createElementVNode as d } from "vue";
import { ElInput as R } from "element-plus";
import L from "./header.vue.js";
import N from "./second-table.vue.js";
import j from "./invoice-info.vue.js";
import { _ as B, R as V } from "../../../../../../shared/runtime.js";
import "../../../../../../modules/invoice-entry-494c5781.js";
import "../../../../../../modules/invoice-entry-97d1bf05.js";
import "../../../../../../modules/info-429dcef2.js";
import "../../../../../../modules/payment-settlement-e8e799d8.js";
import "../../../../../../modules/useTableTotal-3d22365a.js";
const E = { class: "drawer-container" }, M = { class: "remark-container box-container" }, S = { class: "box-container" }, U = { __name: "index", emits: ["component-mounted", "close"], setup($, { expose: p, emit: u }) {
  const t = r({ projectManagerId: null, orderId: null, supplierPaymentId: null, projectId: null, supplierId: null, purchaseContractNumber: null, invoiceAmount: null, invoiceSerialNumber: null }), _ = e(false), f = e([]), v = r({}), i = e(null), x = e([]), c = e(null), h = e([]), b = u;
  k(() => {
    b("component-mounted", true);
  });
  const a = e([]);
  return w(() => a.value, (o) => {
    o.length === 1 && (t.attachmentId = o[0].id), o.length > 1 && a.value.splice(0, 1), o.length === 0 && (t.attachmentId = null);
  }, { deep: true }), m("saveList", h), m("invoice_data", r({ formData: t, attachmentsList: f, secondRef: i, tableList: x, headerRef: c, projectInfo: v })), p({ visible: _, formData: t }), (o, s) => {
    const I = R;
    return y(), g("div", E, [n(L, { ref_key: "headerRef", ref: c, class: "box-container" }, null, 512), n(N, { ref_key: "secondRef", ref: i, class: "box-container" }, null, 512), n(j, { class: "box-container" }), d("div", M, [n(I, { modelValue: t.remark, "onUpdate:modelValue": s[0] || (s[0] = (l) => t.remark = l), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), d("div", S, [n(V, { files: a.value, "onUpdate:files": s[1] || (s[1] = (l) => a.value = l), class: "el-form-item-15", "empty-text": "点击按钮上传附件", "show-download": "", showView: "" }, null, 8, ["files"])])]);
  };
} }, J = B(U, [["__scopeId", "data-v-289cf57c"]]);
export {
  J as default
};
