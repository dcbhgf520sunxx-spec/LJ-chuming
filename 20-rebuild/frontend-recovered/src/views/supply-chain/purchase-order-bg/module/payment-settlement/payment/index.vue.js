import { reactive as t } from "vue";
import { ref as c } from "vue";
import { provide as m } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as d } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as _ } from "vue";
import { ElInput as u } from "element-plus";
import f from "./header.vue.js";
import x from "./second-table.vue.js";
import { _ as y } from "../../../../../../shared/runtime.js";
import "../../../../../../modules/data-499610b6.js";
import "../../../../../../modules/payment-settlement-e8e799d8.js";
import "../../../../../../modules/hook-75706e02.js";
import "../../../../../../modules/grant-managment-2c540b60.js";
import "../../../../../../modules/upload-file-download-812f558c.js";
const b = { class: "payment-container" }, k = { class: "remark-container box-container" }, v = { __name: "index", setup(I, { expose: r }) {
  const e = t({ applyDate: (/* @__PURE__ */ new Date()).getTime(), projectManagerId: null, projectId: null, supplierId: null, purchaseContractNumber: null, paymentAmount: null, paymentBank: null, paymentBankAccount: null, paymentReasonId: null }), l = t({}), o = c(null);
  return m("payment_data", t({ formData: e, projectInfo: l, tableRef: o })), r({ formData: e }), (h, n) => {
    const s = u;
    return i(), d("div", b, [a(f, { class: "box-container" }), a(x, { ref_key: "tableRef", ref: o, class: "box-container" }, null, 512), _("div", k, [a(s, { modelValue: e.remark, "onUpdate:modelValue": n[0] || (n[0] = (p) => e.remark = p), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])])]);
  };
} }, z = y(v, [["__scopeId", "data-v-d9604b31"]]);
export {
  z as default
};
