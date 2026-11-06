import { inject as _ } from "vue";
import { ref as E } from "vue";
import { watch as U } from "vue";
import N from "lodash";
import { computed as f } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as p } from "vue";
import { createVNode as u } from "vue";
import { unref as t } from "vue";
import { createCommentVNode as I } from "vue";
import { withCtx as d } from "vue";
import { Fragment as B } from "vue";
import { renderList as A } from "vue";
import { createBlock as F } from "vue";
import { ElInput as P } from "element-plus";
import { ElOption as Z } from "element-plus";
import { ElSelect as z } from "element-plus";
import C from "./header.vue.js";
import { _ as O, b as S, bD as $, dZ as j, R as Q, e5 as q } from "../../../../../../../shared/runtime.js";
import { i as G } from "../../../../../../../modules/invoice-output-9861b945.js";
import { u as H } from "../../../../../../../modules/useSelect-654af12a.js";
import J from "../../../../components/approval-status.vue.js";
const K = { class: "output-container" }, M = { key: 0, style: { "margin-bottom": "10px" } }, W = { key: 1, class: "remark-container box-container" }, X = { __name: "index", setup(Y) {
  const a = _("purchaseForm"), b = E([]), s = _("approveInfo"), h = _("tableItemData"), { getTaxRateList: R } = H();
  async function g() {
    b.value = await R();
  }
  g();
  const T = ["applyAmount", "taxRateTypeValue", "invoiceNumber"];
  function k(l, e) {
    return Object.keys(l).reduce((r, i) => (e.includes(i) && (r[i] = l[i]), r), {});
  }
  U(() => s.value, (l) => {
    if (S(l)) return;
    const e = k(s.value.outputInvoice, T);
    Object.keys(e).length && (a.practicalInvoice = e.applyAmount, e.taxRateTypeValue && e.taxRateTypeValue !== "0" && (a.taxRateTypeValue = e.taxRateTypeValue + ""), a.invoiceNumber = e.invoiceNumber);
  }, { deep: true, immediate: true });
  const m = N.cloneDeep(G), x = f(() => {
    var l;
    return Number((l = s.value) == null ? void 0 : l.outputInvoice.invoiceType) === $.RECEIPT.V || (m[1].verify = true), m;
  }), w = f(() => j(x.value)), D = (l, e) => {
    /^[A-Za-z0-9-#_]*$/.test(l) ? a[e] = l : a[e] = a[e].replace(/[^A-Za-z0-9-#_]/g, "");
  }, v = f(() => s.value.boolFinalApprover && s.value.passButton && h.approvalFlag);
  return (l, e) => {
    var V, y;
    const r = P, i = Z, L = z;
    return c(), p("div", K, [u(C, { class: "box-container" }), (V = t(s).outputInvoice.attachmentList) != null && V.length ? (c(), p("div", M, [u(Q, { files: t(s).outputInvoice.attachmentList, "onUpdate:files": e[0] || (e[0] = (o) => t(s).outputInvoice.attachmentList = o), uploadable: false, "empty-text": "暂未上传附件", "show-download": "", showView: "", style: { "margin-top": "10px", "": "10px", padding: "0" } }, null, 8, ["files"])])) : I("", true), (y = t(s)) != null && y.passButton ? (c(), p("div", W, [u(r, { modelValue: t(a).remark, "onUpdate:modelValue": e[1] || (e[1] = (o) => t(a).remark = o), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入处理意见", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])])) : I("", true), u(q, { column: 3, "form-data": t(a), "form-rules": w.value, "table-list": x.value, class: "box-container" }, { practicalInvoice: d(({ item: o }) => [u(r, { modelValue: t(a)[o], "onUpdate:modelValue": (n) => t(a)[o] = n, disabled: !v.value, clearable: "", placeholder: "入录实开金额", type: "number" }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), taxRateTypeValue: d(({ item: o }) => [u(L, { modelValue: t(a)[o], "onUpdate:modelValue": (n) => t(a)[o] = n, disabled: !v.value || t(s).outputInvoice.invoiceType === 4, clearable: "" }, { default: d(() => [(c(true), p(B, null, A(b.value, (n) => (c(), F(i, { key: n.id, label: n.label + "%", value: n.value }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])]), invoiceNumber: d(({ item: o }) => [u(r, { modelValue: t(a)[o], "onUpdate:modelValue": (n) => t(a)[o] = n, disabled: !v.value, clearable: "", placeholder: "发票编号不能为空", onInput: (n) => D(n, o) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "onInput"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"]), u(J)]);
  };
} }, se = O(X, [["__scopeId", "data-v-63be7d27"]]);
export {
  se as default
};
