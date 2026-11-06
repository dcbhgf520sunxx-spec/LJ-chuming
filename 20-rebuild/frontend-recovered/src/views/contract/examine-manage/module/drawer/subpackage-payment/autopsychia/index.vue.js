import { ref as c } from "vue";
import { inject as r } from "vue";
import { computed as h } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as l } from "vue";
import { createVNode as e } from "vue";
import { createCommentVNode as p } from "vue";
import { unref as a } from "vue";
import { ElInput as b } from "element-plus";
import v from "../../../../components/approval-status.vue.js";
import k from "./header.vue.js";
import I from "./second-table.vue.js";
import w from "../../../../components/payment-table.vue.js";
import { _ as D, R } from "../../../../../../../shared/runtime.js";
import "../../../../../../../modules/sp-pasychia-data-d374d1e9.js";
import "../../../../../../../modules/index-dfff0f60.js";
import "../../../../../../../modules/pc-pasychia-data-6ecf5a97.js";
import "../../../../../../../modules/upload-file-download-812f558c.js";
const g = { class: "compound-operating-system" }, T = { key: 0, class: "box-container" }, V = { key: 1, class: "remark-container box-container" }, E = { __name: "index", setup(L) {
  const d = c(null), u = c(null), o = r("purchaseForm");
  o.paymentType = void 0;
  const { purchaseInfo: _ } = r("purchaseInfo"), n = h(() => _.supplierAuditSelfEmployedDto.attachmentDtoList), f = { currentPayment: "", paymentType: "", paymentTime: "" }, y = r("tableItemData");
  return (B, t) => {
    var i;
    const x = b;
    return m(), l("div", g, [e(k, { class: "box-container" }), e(I, { ref_key: "secondRef", ref: d, class: "box-container" }, null, 512), e(w, { ref_key: "paymentRef", ref: u, "hide-item-key": ["attachmentIds"], "is-amount": true, "is-negative": true, needItem: f, class: "box-container" }, null, 512), (i = n.value) != null && i.length ? (m(), l("div", T, [e(R, { files: n.value, "onUpdate:files": t[0] || (t[0] = (s) => n.value = s), uploadable: false, "empty-text": "暂未上传附件", "show-download": "", "show-view": "", class: "el-form-item-15" }, null, 8, ["files"])])) : p("", true), a(y).auditStatusEnum === 1 ? (m(), l("div", V, [e(x, { modelValue: a(o).remark, "onUpdate:modelValue": t[1] || (t[1] = (s) => a(o).remark = s), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入处理意见", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])])) : p("", true), e(a(v))]);
  };
} }, q = D(E, [["__scopeId", "data-v-ecda1e3a"]]);
export {
  q as default
};
