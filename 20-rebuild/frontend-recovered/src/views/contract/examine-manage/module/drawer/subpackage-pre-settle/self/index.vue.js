import { inject as n } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as i } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createCommentVNode as _ } from "vue";
import { ElInput as f } from "element-plus";
import x from "./header.vue.js";
import h from "./second.vue.js";
import b from "./payment-info.vue.js";
import v from "../../../../components/approval-status.vue.js";
import { _ as w, R as k } from "../../../../../../../shared/runtime.js";
import "../../../../../../../modules/subpackage-settle-bdb7b46f.js";
import "../../../../../../../modules/useTableTotal-3d22365a.js";
const y = { class: "main-container" }, I = { key: 0, class: "box-container" }, V = { key: 1, class: "box-container" }, g = { __name: "index", setup(L) {
  const l = n("purchaseForm"), a = n("approveInfo"), d = n("tableItemData");
  return ($, o) => {
    var c, m, p;
    const u = f;
    return r(), i("div", y, [t(x, { class: "box-container header-container" }), t(h, { class: "box-container" }), t(b, { class: "box-container" }), (c = e(a)) != null && c.passButton && e(d).approvalFlag ? (r(), i("div", I, [t(u, { modelValue: e(l).remark, "onUpdate:modelValue": o[0] || (o[0] = (s) => e(l).remark = s), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入处理意见", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])])) : _("", true), (p = (m = e(a)) == null ? void 0 : m.attachmentList) != null && p.length ? (r(), i("div", V, [t(k, { files: e(a).attachmentList, "onUpdate:files": o[1] || (o[1] = (s) => e(a).attachmentList = s), uploadable: false, class: "el-form-item-15", "empty-text": "暂未上传附件", "show-download": "", showView: "" }, null, 8, ["files"])])) : _("", true), t(v)]);
  };
} }, z = w(g, [["__scopeId", "data-v-de092d89"]]);
export {
  z as default
};
