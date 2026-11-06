import { inject as d } from "vue";
import { watch as y } from "vue";
import { computed as v } from "vue";
import { provide as g } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as r } from "vue";
import { unref as a } from "vue";
import { Fragment as b } from "vue";
import { createVNode as s } from "vue";
import { createBlock as u } from "vue";
import { createCommentVNode as l } from "vue";
import { ElInput as w } from "element-plus";
import F from "./header.vue.js";
import $ from "./header-v2.vue.js";
import B from "./second-table.vue.js";
import I from "./second-v2-table.vue.js";
import V from "./invoice-info.vue.js";
import E from "./invoice-v2-info.vue.js";
import C from "../../../../components/approval-status.vue.js";
import { _ as D, R as N } from "../../../../../../../shared/runtime.js";
import "../../../../../../../modules/invoice-income-831df2fb.js";
import "../../../../../../../modules/useTableTotal-3d22365a.js";
const R = { class: "income-container" }, U = { key: 2, class: "remark-container box-container" }, j = { __name: "index", setup(z) {
  const c = d("purchaseForm"), e = d("approveInfo"), i = d("tableItemData");
  y(() => i, (n) => {
    n.id && (c.auditId = n.id);
  }, { deep: true });
  const m = v(() => {
    var n, t;
    return (t = (n = e == null ? void 0 : e.value) == null ? void 0 : n.attachments) != null && t.length ? e.value.attachments : [];
  }), h = v(() => e.value.boolFinalApprover && e.value.passButton && i.approvalFlag);
  return g("isCanEdit", h), (n, t) => {
    var _, f, x;
    const k = w;
    return o(), r("div", R, [a(i).auditType === 3 ? (o(), r(b, { key: 0 }, [s(F, { class: "box-container head-container" }), s(B, { class: "box-container" }), a(e) ? (o(), u(V, { key: 0, class: "box-container invoice-info" })) : l("", true)], 64)) : (o(), r(b, { key: 1 }, [s($, { class: "box-container head-container" }), s(I, { class: "box-container" }), a(e) ? (o(), u(E, { key: 0, class: "box-container invoice-info" })) : l("", true)], 64)), (_ = a(e)) != null && _.passButton ? (o(), r("div", U, [s(k, { modelValue: a(c).remark, "onUpdate:modelValue": t[0] || (t[0] = (p) => a(c).remark = p), autosize: { minRows: 2 }, disabled: !((f = a(e)) != null && f.passButton && a(i).approvalFlag), class: "textarea-container", maxlength: "1000", placeholder: "请输入处理意见", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue", "disabled"])])) : l("", true), (x = m.value) != null && x.length ? (o(), u(N, { key: 3, files: m.value, "onUpdate:files": t[1] || (t[1] = (p) => m.value = p), limit: 1, uploadable: false, "empty-text": "暂未上传附件", "show-download": "", showView: "", style: { margin: "10px 0", padding: "0" } }, null, 8, ["files"])) : l("", true), s(C)]);
  };
} }, P = D(j, [["__scopeId", "data-v-0138b130"]]);
export {
  P as default
};
