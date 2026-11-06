import { inject as w } from "vue";
import { useStore as I } from "vuex";
import { computed as b } from "vue";
import { reactive as s } from "vue";
import { ref as a } from "vue";
import { provide as k } from "vue";
import { watch as y } from "vue";
import { openBlock as R } from "vue";
import { createElementBlock as V } from "vue";
import { createVNode as o } from "vue";
import { createElementVNode as m } from "vue";
import { ElInput as g } from "element-plus";
import B from "./header.vue.js";
import L from "./second-table.vue.js";
import $ from "./contract-info.vue.js";
import { _ as j, R as z } from "../../../../../../shared/runtime.js";
import "../../../../../../modules/data-e85015ff.js";
import "../../../../../../modules/payment-settlement-a7865af1.js";
import "../../../../../../modules/info-bbbe1651.js";
import "../../../../../../modules/payment-settlement-e8e799d8.js";
import "../../../../../../modules/useTableTotal-3d22365a.js";
const D = { class: "settlement-container" }, E = { class: "remark-container box-container" }, N = { class: "box-container" }, T = { __name: "index", setup(U, { expose: d }) {
  const { size: p } = w("common");
  p.value = "50%";
  const u = I(), _ = b(() => u.getters.user.id), t = s({ createTime: (/* @__PURE__ */ new Date()).getTime(), supplierId: null, orderId: null, settlementAmount: null, userId: _.value }), f = s({}), x = s({}), n = a(null), c = a(null), v = a([]);
  k("settlement_data", s({ formData: t, projectInfo: f, headerRef: n, secondRef: c, tableList: v, contractListInfo: x }));
  const r = a([]);
  return y(() => r.value, (i) => {
    t.attachmentId = i.map((e) => e.id);
  }, { deep: true }), d({ formData: t, headerRef: n }), (i, e) => {
    const h = g;
    return R(), V("div", D, [o(B, { ref_key: "headerRef", ref: n, class: "box-container" }, null, 512), o(L, { ref_key: "secondRef", ref: c, class: "box-container" }, null, 512), o($, { class: "box-container" }), m("div", E, [o(h, { modelValue: t.remark, "onUpdate:modelValue": e[0] || (e[0] = (l) => t.remark = l), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), m("div", N, [o(z, { files: r.value, "onUpdate:files": e[1] || (e[1] = (l) => r.value = l), class: "el-form-item-15", "empty-text": "点击按钮上传附件", "show-download": "", showView: "" }, null, 8, ["files"])])]);
  };
} }, O = j(T, [["__scopeId", "data-v-2da0fc41"]]);
export {
  O as default
};
