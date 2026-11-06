import { reactive as t } from "vue";
import { ref as n } from "vue";
import { inject as u } from "vue";
import { provide as f } from "vue";
import { openBlock as x } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as o } from "vue";
import { createElementVNode as v } from "vue";
import { ElInput as I } from "element-plus";
import h from "./header.vue.js";
import k from "./second-table.vue.js";
import y from "./contract-info.vue.js";
import { _ as R } from "../../../../../../shared/runtime.js";
import "../../../../../../modules/data-5413af16.js";
import "../../../../../../modules/payment-settlement-e8e799d8.js";
import "../../../../../../modules/info-429dcef2.js";
import "../../../../../../modules/useTableTotal-3d22365a.js";
const V = { class: "settlement-container" }, g = { class: "remark-container box-container" }, j = { __name: "index", setup(w, { expose: c }) {
  const e = t({ applyDate: (/* @__PURE__ */ new Date()).getTime(), orderId: null, projectManagerId: null, projectId: null, supplierId: null, settlementAmount: null, purchaseContractNumber: null }), l = t({}), i = t({}), a = n(null), s = n(null), m = n([]), { size: _ } = u("common");
  return _.value = "50%", f("settlement_data", t({ formData: e, projectInfo: l, headerRef: a, secondRef: s, tableList: m, contractListInfo: i })), c({ formData: e, headerRef: a }), (B, r) => {
    const d = I;
    return x(), b("div", V, [o(h, { ref_key: "headerRef", ref: a, class: "box-container" }, null, 512), o(k, { ref_key: "secondRef", ref: s, class: "box-container" }, null, 512), o(y, { class: "box-container" }), v("div", g, [o(d, { modelValue: e.remark, "onUpdate:modelValue": r[0] || (r[0] = (p) => e.remark = p), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])])]);
  };
} }, T = R(j, [["__scopeId", "data-v-4ddcca9b"]]);
export {
  T as default
};
