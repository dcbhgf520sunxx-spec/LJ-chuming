import { reactive as n } from "vue";
import { ref as m } from "vue";
import { inject as i } from "vue";
import { provide as u } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as d } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as f } from "vue";
import { ElInput as x } from "element-plus";
import y from "./header.vue.js";
import b from "./second-table.vue.js";
import { _ as k } from "../../../../../../shared/runtime.js";
import "../../../../../../modules/data-5413af16.js";
import "../../../../../../modules/payment-settlement-e8e799d8.js";
import "../../../../../../modules/info-429dcef2.js";
import "../../../../../../modules/data-499610b6.js";
import "../../../../../../modules/grant-managment-2c540b60.js";
import "../../../../../../modules/upload-file-download-812f558c.js";
const v = { class: "payment-container" }, I = { class: "remark-container box-container" }, h = { __name: "index", setup(B, { expose: r }) {
  const e = n({ applyDate: (/* @__PURE__ */ new Date()).getTime(), projectManagerId: null, projectId: null, supplierId: null, purchaseContractNumber: null, paymentAmount: null, paymentBank: null, paymentBankAccount: null, paymentReasonId: null }), l = n({}), t = m(null), { size: s } = i("common");
  return s.value = "60%", u("payment_data", { formData: e, projectInfo: l, tableRef: t }), r({ formData: e }), (V, o) => {
    const c = x;
    return _(), d("div", v, [a(y, { class: "box-container" }), a(b, { ref_key: "tableRef", ref: t, class: "box-container" }, null, 512), f("div", I, [a(c, { modelValue: e.remark, "onUpdate:modelValue": o[0] || (o[0] = (p) => e.remark = p), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])])]);
  };
} }, M = k(h, [["__scopeId", "data-v-71aba3e0"]]);
export {
  M as default
};
