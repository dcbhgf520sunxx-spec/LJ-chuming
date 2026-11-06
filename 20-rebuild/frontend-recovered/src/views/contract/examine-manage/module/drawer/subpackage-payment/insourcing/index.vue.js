import { inject as n } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as r } from "vue";
import { createVNode as e } from "vue";
import { unref as t } from "vue";
import { createCommentVNode as _ } from "vue";
import { ElInput as l } from "element-plus";
import d from "./header.vue.js";
import u from "./second-table.vue.js";
import x from "../../../../components/payment-table.vue.js";
import y from "../../../../components/approval-status.vue.js";
import { _ as f } from "../../../../../../../shared/runtime.js";
import "../../../../../../../modules/sp-inscourc-data-0cdb98a1.js";
import "../../../../../../../modules/pc-pasychia-data-6ecf5a97.js";
import "../../../../../../../modules/upload-file-download-812f558c.js";
const b = { class: "compound-operating-system" }, h = { key: 0, class: "remark-container box-container" }, k = { __name: "index", setup(I) {
  const a = n("purchaseForm"), s = { currentPayment: "", paymentType: "", paymentTime: "" }, c = n("tableItemData");
  return (v, o) => {
    const i = l;
    return m(), r("div", b, [e(d, { class: "box-container" }), e(u, { class: "box-container" }), t(c).auditStatusEnum === 1 ? (m(), r("div", h, [e(i, { modelValue: t(a).remark, "onUpdate:modelValue": o[0] || (o[0] = (p) => t(a).remark = p), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入处理意见", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])])) : _("", true), e(x, { column: 3, "hide-item-key": ["paymentType", "voucherNumber", "attachmentIds"], needItem: s, readonlyColumn: 3, class: "box-container" }), e(y)]);
  };
} }, C = f(k, [["__scopeId", "data-v-a09a6d69"]]);
export {
  C as default
};
