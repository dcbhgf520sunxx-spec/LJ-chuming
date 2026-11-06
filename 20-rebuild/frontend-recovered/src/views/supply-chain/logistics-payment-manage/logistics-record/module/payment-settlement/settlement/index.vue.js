import { reactive as t } from "vue";
import { ref as n } from "vue";
import { provide as h } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as v } from "vue";
import { createElementVNode as o } from "vue";
import { createVNode as _ } from "vue";
import { createBlock as m } from "vue";
import { createCommentVNode as d } from "vue";
import { ElInput as k } from "element-plus";
import b from "./header.vue.js";
import y from "./second-table.vue.js";
import I from "./contract-info.vue.js";
import { _ as V } from "../../../../../../../shared/runtime.js";
import "../../../../../../../modules/data-499610b6.js";
import "../../../../../../../modules/useSelect-654af12a.js";
import "../../../../../../../modules/payment-settlement-e8e799d8.js";
import "../../../../../../../modules/data-50c44b01.js";
const R = { class: "settlement-container" }, g = { class: "box-container" }, B = { class: "box-container" }, N = { class: "box-container" }, w = { class: "remark-container box-container" }, C = { __name: "index", setup($, { expose: p }) {
  const e = t({ projectId: null, supplierId: null, purchaseContractNumber: null }), u = t({}), s = t({}), r = n(null), c = n(null), l = n([]);
  return h("settlement_data", t({ formData: e, projectInfo: u, headerRef: r, secondRef: c, tableList: l, contractListInfo: s })), p({ formData: e }), (j, i) => {
    const f = k;
    return a(), v("div", R, [o("div", g, [_(b, { ref_key: "headerRef", ref: r }, null, 512)]), o("div", B, [l.value.length ? (a(), m(y, { key: 0, ref_key: "secondRef", ref: c }, null, 512)) : d("", true)]), o("div", N, [s.paymentContractAmount ? (a(), m(I, { key: 0 })) : d("", true)]), o("div", w, [_(f, { class: "textarea-container", autosize: { minRows: 2 }, maxlength: "1000", "show-word-limit": "", modelValue: e.remark, "onUpdate:modelValue": i[0] || (i[0] = (x) => e.remark = x), type: "textarea", placeholder: "备注" }, null, 8, ["modelValue"])])]);
  };
} }, H = V(C, [["__scopeId", "data-v-69cc5ebe"]]);
export {
  H as default
};
