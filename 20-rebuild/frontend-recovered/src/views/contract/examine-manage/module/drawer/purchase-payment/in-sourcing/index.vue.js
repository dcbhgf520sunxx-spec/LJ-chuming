import { inject as c } from "vue";
import { ref as h } from "vue";
import { watch as y } from "vue";
import { watchEffect as k } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as p } from "vue";
import { createVNode as s } from "vue";
import { unref as n } from "vue";
import { createCommentVNode as g } from "vue";
import { createElementVNode as B } from "vue";
import { ElInput as D } from "element-plus";
import j from "./header.vue.js";
import V from "./second-table.vue.js";
import E from "../../../../components/payment-table.vue.js";
import { _ as F, b as R, R as x } from "../../../../../../../shared/runtime.js";
import S from "../../../../components/approval-status.vue.js";
import "../../../../../../../modules/pc-insourc-data-b34c8a60.js";
import "../../../../../../../modules/upload-file-download-812f558c.js";
import "../../../../../../../modules/pc-pasychia-data-6ecf5a97.js";
const T = { class: "compound-operating-system" }, z = { key: 0, class: "remark-container" }, A = { class: "box-container" }, N = { key: 0 }, P = { key: 1 }, U = { __name: "index", setup(L) {
  const a = c("purchaseForm"), { purchaseInfo: o } = c("purchaseInfo");
  c("tableItemData");
  const v = c("size");
  v.value = "55%";
  const u = h([]);
  y(() => u.value, (e) => {
    e.length === 1 && (a.attachmentId = e[0].id), e.length > 1 && u.value.splice(0, 1), e.length === 0 && (a.attachmentId = null);
  }, { deep: true });
  const w = ["paymentAmount", "paymentReasonId"];
  function I(e, t) {
    return Object.keys(e).reduce((l, r) => (t.includes(r) && (l[r] = e[r]), l), {});
  }
  y(() => o, (e) => {
    if (R(e)) return;
    const t = I(o.projectSupplierDto, w);
    Object.keys(t).length && (a.actuallyPayAmount = t.paymentAmount, a.paymentType = parseFloat(t.paymentReasonId));
  }, { deep: true, immediate: true });
  const b = (e) => {
    e.length > 1 && (a.attachmentIds = [e[e.length - 1]]);
  }, d = h([]);
  return k(() => {
    o.projectSupplierDto.attachmentDto && (d.value = [o.projectSupplierDto.attachmentDto]);
  }), (e, t) => {
    var r, f, _;
    const l = D;
    return m(), p("div", T, [s(j, { class: "box-container" }), s(V, { class: "box-container" }), s(E, { "hidden-upload": true, "is-write": (r = n(o)) == null ? void 0 : r.passButton, "readonly-column": 3, class: "box-container" }, null, 8, ["is-write"]), (f = n(o)) != null && f.passButton ? (m(), p("div", z, [s(l, { modelValue: n(a).remark, "onUpdate:modelValue": t[0] || (t[0] = (i) => n(a).remark = i), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入处理意见", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])])) : g("", true), B("div", A, [(_ = n(o)) != null && _.passButton ? (m(), p("div", N, [s(x, { files: n(a).attachmentIds, "onUpdate:files": [t[1] || (t[1] = (i) => n(a).attachmentIds = i), b], class: "el-form-item-15", "empty-text": "暂未上传附件", "show-download": "", showView: "" }, null, 8, ["files"])])) : (m(), p("div", P, [s(x, { files: d.value, "onUpdate:files": t[2] || (t[2] = (i) => d.value = i), uploadable: false, class: "el-form-item-15", "empty-text": "暂未上传附件", "show-download": "", showView: "" }, null, 8, ["files"])]))]), s(S)]);
  };
} }, Q = F(U, [["__scopeId", "data-v-c05fed01"]]);
export {
  Q as default
};
