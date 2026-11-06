import { inject as n } from "vue";
import { watch as d } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as i } from "vue";
import { createVNode as e } from "vue";
import { unref as t } from "vue";
import { createCommentVNode as u } from "vue";
import { ElInput as f } from "element-plus";
import x from "./header.vue.js";
import h from "./second-table.vue.js";
import b from "../../../../components/approval-status.vue.js";
import v from "../../../../components/payment-table.vue.js";
import { _ as y } from "../../../../../../../shared/runtime.js";
import "../../../../../../../modules/subpackage-settle-bdb7b46f.js";
import "../../../../../../../modules/useTableTotal-3d22365a.js";
import "../../../../../../../modules/pc-pasychia-data-6ecf5a97.js";
import "../../../../../../../modules/upload-file-download-812f558c.js";
const I = { class: "income-container" }, k = { key: 0, class: "remark-container box-container" }, w = { __name: "index", setup(V) {
  const a = n("purchaseForm"), p = n("approveInfo"), r = n("tableItemData");
  return d(() => r, (o) => {
    o.id && (a.auditId = o.id);
  }, { deep: true }), (o, s) => {
    var c;
    const _ = f;
    return m(), i("div", I, [e(x, { class: "box-container head-container" }), e(h, { class: "box-container" }), (c = t(p)) != null && c.passButton && t(r).approvalFlag ? (m(), i("div", k, [e(_, { modelValue: t(a).remark, "onUpdate:modelValue": s[0] || (s[0] = (l) => t(a).remark = l), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])])) : u("", true), e(v, { column: 3, "hide-item-key": ["paymentType", "voucherNumber", "attachmentIds"], class: "box-container" }), e(b)]);
  };
} }, C = y(w, [["__scopeId", "data-v-c41df103"]]);
export {
  C as default
};
