import { reactive as t } from "vue";
import { ref as a } from "vue";
import { provide as d } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as o } from "vue";
import { createElementVNode as x } from "vue";
import { ElInput as b } from "element-plus";
import I from "./header.vue.js";
import h from "./second-table.vue.js";
import k from "./contract-info.vue.js";
import { _ as v } from "../../../../../../../shared/runtime.js";
import "../../../../../../../modules/data-39ef738e.js";
import "../../../../../../../modules/info-d30309fa.js";
import "../../../../../../../modules/index-69cea220.js";
import "../../../../../../../modules/useTableTotal-3d22365a.js";
const y = { class: "settlement-container" }, R = { class: "remark-container box-container" }, V = { __name: "index", setup(g, { expose: l }) {
  const e = t({ applyDate: (/* @__PURE__ */ new Date()).getTime(), orderId: null, projectManagerId: null, projectId: null, supplierId: null, settlementAmount: null, purchaseContractNumber: null }), c = t({}), i = t({}), n = a(null), r = a(null), m = a([]);
  return d("settlement_data", t({ formData: e, projectInfo: c, headerRef: n, secondRef: r, tableList: m, contractListInfo: i })), l({ formData: e, headerRef: n }), (w, s) => {
    const _ = b;
    return u(), f("div", y, [o(I, { ref_key: "headerRef", ref: n, class: "box-container" }, null, 512), o(h, { ref_key: "secondRef", ref: r, class: "box-container" }, null, 512), o(k, { class: "box-container" }), x("div", R, [o(_, { modelValue: e.remark, "onUpdate:modelValue": s[0] || (s[0] = (p) => e.remark = p), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])])]);
  };
} }, C = v(V, [["__scopeId", "data-v-b2626465"]]);
export {
  C as default
};
