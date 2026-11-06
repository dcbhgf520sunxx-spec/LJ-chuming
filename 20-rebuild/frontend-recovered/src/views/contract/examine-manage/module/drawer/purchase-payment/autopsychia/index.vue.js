import { inject as m } from "vue";
import { ref as E } from "vue";
import { watch as S } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as I } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { createCommentVNode as r } from "vue";
import { createBlock as d } from "vue";
import { Fragment as V } from "vue";
import { ElInput as F } from "element-plus";
import L from "./header.vue.js";
import { _ as N, dp as w } from "../../../../../../../shared/runtime.js";
import T from "./second-table.vue.js";
import U from "./payment-info.vue.js";
import z from "../../../../components/payment-table.vue.js";
import k from "../../../../../../crm/crm-office/components/UploadList.vue.js";
import A from "../../../../components/approval-status.vue.js";
import "../../../../../../../modules/pc-pasychia-data-6ecf5a97.js";
import "../../../../../../../modules/useTableTotal-3d22365a.js";
import "../../../../../../../modules/payment-settlement-a7865af1.js";
import "../../../../../../../modules/upload-file-download-812f558c.js";
const $ = { class: "header-descriptions-container box-container" }, j = { key: 0, class: "remark-container box-container" }, C = { class: "box-container" }, H = { class: "box-container" }, P = { __name: "index", setup(R) {
  const t = m("purchaseForm"), { purchaseInfo: o } = m("purchaseInfo"), p = E([]), v = m("size");
  v.value = "60%", t.paymentType = void 0, S(() => p.value, (a) => {
    a.length === 1 && (t.attachmentId = a[0].id), a.length > 1 && p.value.splice(0, 1), a.length === 0 && (t.attachmentId = null);
  }, { deep: true });
  const B = (a) => {
    a.length > 1 && (t.attachmentIds = [a[a.length - 1]]);
  };
  return (a, n) => {
    var u, f, h, _, x, b, y, g;
    const D = F;
    return l(), I(V, null, [c("div", $, [s(w, { "header-title": "基本信息" }), s(L, { class: "box-container" })]), s(T, { class: "box-container" }), s(U, { class: "box-container" }), s(z, { "hide-item-key": ["attachmentIds"], "is-write": (u = e(o)) == null ? void 0 : u.passButton, isNegative: true, class: "box-container" }, null, 8, ["is-write"]), (f = e(o)) != null && f.passButton ? (l(), I("div", j, [s(D, { modelValue: e(t).remark, "onUpdate:modelValue": n[0] || (n[0] = (i) => e(t).remark = i), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入处理意见", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])])) : r("", true), c("div", C, [(h = e(o).supplierAuditSelfEmployedDto.attachmentDtoList) != null && h.length ? (l(), d(k, { key: 0, files: e(o).supplierAuditSelfEmployedDto.attachmentDtoList, "onUpdate:files": n[1] || (n[1] = (i) => e(o).supplierAuditSelfEmployedDto.attachmentDtoList = i), uploadable: false, class: "el-form-item-15", "empty-text": "暂未上传审批附件", "show-download": "", showView: "" }, null, 8, ["files"])) : r("", true)]), (_ = e(o)) != null && _.passButton && ((x = e(t).attachmentIds) != null && x.length) ? (l(), d(w, { key: 1, "header-title": "审批附件" })) : r("", true), c("div", H, [(b = e(o)) != null && b.passButton && ((y = e(t).attachmentIds) != null && y.length) ? (l(), d(k, { key: 0, files: e(t).attachmentIds, "onUpdate:files": [n[2] || (n[2] = (i) => e(t).attachmentIds = i), B], uploadable: (g = e(o)) == null ? void 0 : g.passButton, class: "el-form-item-15", "empty-text": "暂未上传审批附件", "show-download": "", showView: "" }, null, 8, ["files", "uploadable"])) : r("", true)]), s(A)], 64);
  };
} }, te = N(P, [["__scopeId", "data-v-25b386f5"]]);
export {
  te as default
};
