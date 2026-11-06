import { inject as m } from "vue";
import { watch as v } from "vue";
import { computed as b } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as p } from "vue";
import { createVNode as r } from "vue";
import { unref as s } from "vue";
import { createBlock as x } from "vue";
import { createCommentVNode as i } from "vue";
import { ElInput as k } from "element-plus";
import g from "./header.vue.js";
import y from "./second-table.vue.js";
import w from "./invoice-info.vue.js";
import I from "../../../../components/approval-status.vue.js";
import { _ as V, R as B } from "../../../../../../../shared/runtime.js";
import "../../../../../../../modules/invoice-income-831df2fb.js";
import "../../../../../../../modules/useTableTotal-3d22365a.js";
import "../../../../../../../modules/pc-pasychia-data-6ecf5a97.js";
const F = { class: "income-container" }, $ = { key: 1, class: "remark-container box-container" }, D = { key: 2, class: "box-container" }, E = { __name: "index", setup(N) {
  const l = m("purchaseForm"), t = m("approveInfo"), d = m("tableItemData");
  v(() => d, (a) => {
    a.id && (l.auditId = a.id);
  }, { deep: true });
  const n = b(() => {
    var a, e;
    return (e = (a = t == null ? void 0 : t.value) == null ? void 0 : a.attachments) != null && e.length ? t.value.attachments : [];
  });
  return (a, e) => {
    var u, _, f;
    const h = k;
    return o(), p("div", F, [r(g, { class: "box-container head-container" }), r(y, { class: "box-container" }), s(t) ? (o(), x(w, { key: 0, class: "box-container" })) : i("", true), (u = s(t)) != null && u.passButton && s(d).approvalFlag ? (o(), p("div", $, [r(h, { modelValue: s(l).remark, "onUpdate:modelValue": e[0] || (e[0] = (c) => s(l).remark = c), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入处理意见", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])])) : i("", true), (_ = n.value) != null && _.length ? (o(), p("div", D, [(f = n.value) != null && f.length ? (o(), x(B, { key: 0, files: n.value, "onUpdate:files": e[1] || (e[1] = (c) => n.value = c), uploadable: false, "empty-text": "暂未上传申请附件", "show-download": "", showView: "", style: { margin: "10px 0", padding: "0" } }, null, 8, ["files"])) : i("", true)])) : i("", true), r(I)]);
  };
} }, H = V(E, [["__scopeId", "data-v-92bc8966"]]);
export {
  H as default
};
