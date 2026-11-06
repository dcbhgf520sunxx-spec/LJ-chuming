import { inject as h } from "vue";
import { reactive as n } from "vue";
import { ref as l } from "vue";
import { provide as v } from "vue";
import { watch as I } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as k } from "vue";
import { createVNode as o } from "vue";
import { createElementVNode as m } from "vue";
import { ElInput as w } from "element-plus";
import g from "./header.vue.js";
import y from "./second-table.vue.js";
import R from "./contract-info.vue.js";
import { _ as z, R as B } from "../../../../../../../shared/runtime.js";
import "../../../../../../../modules/data-2d709dfa.js";
import "../../../../../../../modules/payment-settlement-a7865af1.js";
import "../../../../../../../modules/hook-467b8301.js";
import "../../../../../../../modules/useTableTotal-3d22365a.js";
const L = { class: "settlement-container" }, V = { class: "remark-container box-container" }, $ = { class: "box-container" }, j = { __name: "index", setup(D, { expose: d }) {
  const _ = h("size");
  _.value = "50%";
  const e = n({ createTime: (/* @__PURE__ */ new Date()).getTime(), supplierId: null, orderId: null, settlementAmount: null, userId: null }), p = n({}), u = n({}), r = l(null), i = l(null), f = l([]);
  v("settlement_data", n({ formData: e, projectInfo: p, headerRef: r, secondRef: i, tableList: f, contractListInfo: u }));
  const a = l([]);
  return I(() => a.value, (t) => {
    t.length === 1 && (e.attachmentId = t[0].id), t.length > 1 && a.value.splice(0, 1), t.length === 0 && (e.attachmentId = null);
  }, { deep: true }), d({ formData: e, headerRef: r }), (t, s) => {
    const x = w;
    return b(), k("div", L, [o(g, { ref_key: "headerRef", ref: r, class: "box-container" }, null, 512), o(y, { ref_key: "secondRef", ref: i, class: "box-container" }, null, 512), o(R, { class: "box-container" }), m("div", V, [o(x, { modelValue: e.remark, "onUpdate:modelValue": s[0] || (s[0] = (c) => e.remark = c), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), m("div", $, [o(B, { files: a.value, "onUpdate:files": s[1] || (s[1] = (c) => a.value = c), class: "el-form-item-15", "empty-text": "点击按钮上传附件", "show-download": "", showView: "" }, null, 8, ["files"])])]);
  };
} }, H = z(j, [["__scopeId", "data-v-0cfec768"]]);
export {
  H as default
};
