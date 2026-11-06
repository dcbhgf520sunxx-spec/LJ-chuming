import { inject as u } from "vue";
import { reactive as a } from "vue";
import { ref as r } from "vue";
import { provide as x } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as I } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as c } from "vue";
import { ElInput as v } from "element-plus";
import w from "./header.vue.js";
import b from "./second-table.vue.js";
import k from "./contract-info.vue.js";
import { _ as y, R } from "../../../../../../../shared/runtime.js";
import "../../../../../../../modules/data-e72242cc.js";
import "../../../../../../../modules/index-dfff0f60.js";
import "../../../../../../../modules/useTableTotal-3d22365a.js";
const V = { class: "settlement-container" }, g = { class: "remark-container box-container" }, z = { class: "box-container" }, B = { __name: "index", setup(L, { expose: i }) {
  const m = u("size");
  m.value = "50%";
  const e = a({ createTime: (/* @__PURE__ */ new Date()).getTime(), supplierId: null, orderId: null, settlementAmount: null, userId: null, attachmentId: [] }), d = a({}), _ = a({}), n = r(null), l = r(null), p = r([]);
  return x("settlement_data", a({ formData: e, projectInfo: d, headerRef: n, secondRef: l, tableList: p, contractListInfo: _ })), i({ formData: e, headerRef: n }), ($, o) => {
    const f = v;
    return h(), I("div", V, [t(w, { ref_key: "headerRef", ref: n, class: "box-container" }, null, 512), t(b, { ref_key: "secondRef", ref: l, class: "box-container" }, null, 512), t(k, { class: "box-container" }), c("div", g, [t(f, { modelValue: e.remark, "onUpdate:modelValue": o[0] || (o[0] = (s) => e.remark = s), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), c("div", z, [t(R, { files: e.attachmentId, "onUpdate:files": o[1] || (o[1] = (s) => e.attachmentId = s), class: "el-form-item-15", "empty-text": "暂未上传附件", "show-download": "", showView: "" }, null, 8, ["files"])])]);
  };
} }, C = y(B, [["__scopeId", "data-v-eaec3c90"]]);
export {
  C as default
};
