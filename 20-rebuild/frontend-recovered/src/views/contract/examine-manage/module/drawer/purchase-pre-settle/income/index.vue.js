import { inject as c } from "vue";
import { watch as v } from "vue";
import { computed as b } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as d } from "vue";
import { createVNode as m } from "vue";
import { unref as s } from "vue";
import { createBlock as x } from "vue";
import { createCommentVNode as r } from "vue";
import { ElInput as k } from "element-plus";
import g from "./header.vue.js";
import y from "./invoice-info.vue.js";
import w from "../../../../components/approval-status.vue.js";
import { _ as I, R as V } from "../../../../../../../shared/runtime.js";
import "../../../../../../../modules/invoice-income-831df2fb.js";
import "../../../../../../../modules/pc-pasychia-data-6ecf5a97.js";
const B = { class: "income-container" }, F = { key: 1, class: "remark-container box-container" }, D = { key: 2, class: "box-container" }, $ = { __name: "index", setup(E) {
  const l = c("purchaseForm"), t = c("approveInfo"), p = c("tableItemData");
  v(() => p, (a) => {
    a.id && (l.auditId = a.id);
  }, { deep: true });
  const n = b(() => {
    var a, e;
    return (e = (a = t == null ? void 0 : t.value) == null ? void 0 : a.attachments) != null && e.length ? t.value.attachments : [];
  });
  return (a, e) => {
    var u, _, f;
    const h = k;
    return o(), d("div", B, [m(g, { class: "box-container head-container" }), s(t) ? (o(), x(y, { key: 0, class: "box-container" })) : r("", true), (u = s(t)) != null && u.passButton && s(p).approvalFlag ? (o(), d("div", F, [m(h, { modelValue: s(l).remark, "onUpdate:modelValue": e[0] || (e[0] = (i) => s(l).remark = i), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入处理意见", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])])) : r("", true), (_ = n.value) != null && _.length ? (o(), d("div", D, [(f = n.value) != null && f.length ? (o(), x(V, { key: 0, files: n.value, "onUpdate:files": e[1] || (e[1] = (i) => n.value = i), uploadable: false, "empty-text": "暂未上传申请附件", "show-download": "", showView: "", style: { margin: "10px 0", padding: "0" } }, null, 8, ["files"])) : r("", true)])) : r("", true), m(w)]);
  };
} }, q = I($, [["__scopeId", "data-v-bbd4343d"]]);
export {
  q as default
};
