import { reactive as n } from "vue";
import { ref as r } from "vue";
import { provide as x } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as l } from "vue";
import { createBlock as i } from "vue";
import { createCommentVNode as c } from "vue";
import { createElementVNode as p } from "vue";
import { ElInput as b } from "element-plus";
import k from "./header.vue.js";
import h from "./second-table.vue.js";
import I from "./payment-info.vue.js";
import { _ as v, R as L } from "../../../../../../../shared/runtime.js";
import "../../../../../../../modules/data-e72242cc.js";
import "../../../../../../../modules/index-dfff0f60.js";
import "../../../../../../../modules/subcontract-payment-attribute-37f9bab7.js";
import "../../../../../../../modules/useTableTotal-3d22365a.js";
import "../../../../../../../modules/data-33e35578.js";
const w = { class: "payment-container" }, V = { class: "remark-container box-container" }, g = { class: "box-container" }, j = { __name: "index", props: { projectList: { type: Array, default: () => [] } }, setup(m, { expose: d }) {
  const e = n({ applyDate: (/* @__PURE__ */ new Date()).getTime(), supplierId: null, orderIds: null, attachmentId: [], projectId: null, paymentBank: null, paymentBankAccount: null, tableList: [], supplierPayment: [] }), _ = n({}), a = r(null), u = r([]);
  return x("payment_data", n({ formData: e, projectInfo: _, tableRef: a, paymentTypelist: u })), d({ formData: e, tableRef: a }), (B, t) => {
    const f = b;
    return s(), y("div", w, [l(k, { class: "box-container", projectList: m.projectList }, null, 8, ["projectList"]), e.tableList.length ? (s(), i(h, { key: 0, ref_key: "tableRef", ref: a, class: "box-container" }, null, 512)) : c("", true), e.tableList.length ? (s(), i(I, { key: 1, class: "box-container" })) : c("", true), p("div", V, [l(f, { modelValue: e.remark, "onUpdate:modelValue": t[0] || (t[0] = (o) => e.remark = o), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), p("div", g, [l(L, { files: e.attachmentId, "onUpdate:files": t[1] || (t[1] = (o) => e.attachmentId = o), class: "el-form-item-15", "empty-text": "暂未上传文件", "show-download": "", showVie: "" }, null, 8, ["files"])])]);
  };
} }, P = v(j, [["__scopeId", "data-v-f88f2222"]]);
export {
  P as default
};
