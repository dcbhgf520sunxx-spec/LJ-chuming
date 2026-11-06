import { inject as v } from "vue";
import { reactive as a } from "vue";
import { ref as s } from "vue";
import { provide as b } from "vue";
import { watch as h } from "vue";
import { openBlock as w } from "vue";
import { createElementBlock as I } from "vue";
import { createVNode as o } from "vue";
import { createElementVNode as m } from "vue";
import { ElInput as k } from "element-plus";
import y from "./header.vue.js";
import R from "./second-table.vue.js";
import V from "./contract-info.vue.js";
import { _ as g, R as z } from "../../../../../../shared/runtime.js";
import "../../../../../../modules/data-33e35578.js";
import "../../../../../../modules/payment-settlement-a7865af1.js";
import "../../../../../../modules/hook-467b8301.js";
import "../../../../../../modules/useTableTotal-3d22365a.js";
const B = { class: "settlement-container" }, L = { class: "remark-container box-container" }, $ = { class: "box-container" }, j = { __name: "index", setup(D, { expose: d }) {
  const _ = v("size");
  _.value = "50%";
  const t = a({ createTime: (/* @__PURE__ */ new Date()).getTime(), supplierId: null, orderId: null, settlementAmount: null, userId: null, boolSettlement: true }), p = a({}), u = a({}), n = s(null), i = s(null), f = s([]);
  b("settlement_data", a({ formData: t, projectInfo: p, headerRef: n, secondRef: i, tableList: f, contractListInfo: u }));
  const l = s([]);
  return h(() => l.value, (c) => {
    t.attachmentId = c.map((e) => e.id);
  }, { deep: true }), d({ formData: t, headerRef: n }), (c, e) => {
    const x = k;
    return w(), I("div", B, [o(y, { ref_key: "headerRef", ref: n, class: "box-container" }, null, 512), o(R, { ref_key: "secondRef", ref: i, class: "box-container" }, null, 512), o(V, { class: "box-container" }), m("div", L, [o(x, { modelValue: t.remark, "onUpdate:modelValue": e[0] || (e[0] = (r) => t.remark = r), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), m("div", $, [o(z, { files: l.value, "onUpdate:files": e[1] || (e[1] = (r) => l.value = r), class: "el-form-item-15", "empty-text": "点击按钮上传附件", "show-download": "", showView: "" }, null, 8, ["files"])])]);
  };
} }, G = g(j, [["__scopeId", "data-v-34b9fa28"]]);
export {
  G as default
};
