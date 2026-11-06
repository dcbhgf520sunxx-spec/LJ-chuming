import { ref as d } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as p } from "vue";
import { createElementVNode as a } from "vue";
import { createVNode as o } from "vue";
import { withCtx as t } from "vue";
import { createTextVNode as s } from "vue";
import { ElCol as u } from "element-plus";
import { ElButton as f } from "element-plus";
import { ElRow as x } from "element-plus";
import { ElInput as v } from "element-plus";
import b from "./header.vue.js";
import w from "./second-table.vue.js";
import y from "../../../components/approval-status.vue.js";
import { _ as V } from "../../../../../../shared/runtime.js";
import "../../../../../../modules/logistiics-7d598f3c.js";
const E = { class: "logistics-payment-container" }, h = { class: "box-container" }, k = { class: "box-container" }, B = { class: "attachment-container box-container" }, g = { class: "remark-container box-container" }, N = { __name: "index", setup(z) {
  const l = d("");
  return (C, e) => {
    const n = u, _ = f, c = x, i = v;
    return m(), p("div", E, [a("div", h, [o(b)]), a("div", k, [o(w)]), a("div", B, [o(c, null, { default: t(() => [o(n, { class: "col-container", span: 2 }, { default: t(() => e[1] || (e[1] = [s(" 附件 ")])), _: 1, __: [1] }), o(n, { class: "col-container", span: 20 }, { default: t(() => e[2] || (e[2] = [s("清单.pdf")])), _: 1, __: [2] }), o(n, { class: "col-container", span: 2 }, { default: t(() => [o(_, { type: "primary", icon: "el-icon-download", size: "default" }, { default: t(() => e[3] || (e[3] = [s("下载")])), _: 1, __: [3] })]), _: 1 })]), _: 1 })]), a("div", g, [o(i, { class: "textarea-container", autosize: { minRows: 2 }, maxlength: "1000", "show-word-limit": "", modelValue: l.value, "onUpdate:modelValue": e[0] || (e[0] = (r) => l.value = r), type: "textarea", placeholder: "备注" }, null, 8, ["modelValue"])]), o(y)]);
  };
} }, U = V(N, [["__scopeId", "data-v-d7e1a0a9"]]);
export {
  U as default
};
