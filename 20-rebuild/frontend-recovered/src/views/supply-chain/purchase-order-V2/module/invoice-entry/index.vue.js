import { reactive as c } from "vue";
import { ref as l } from "vue";
import { onMounted as z } from "vue";
import { useStore as B } from "vuex";
import { watch as C } from "vue";
import { provide as v } from "vue";
import { computed as S } from "vue";
import { openBlock as w } from "vue";
import { createElementBlock as U } from "vue";
import { createVNode as s } from "vue";
import { withCtx as n } from "vue";
import { createBlock as $ } from "vue";
import { createTextVNode as d } from "vue";
import { createCommentVNode as j } from "vue";
import { createElementVNode as x } from "vue";
import { ElTag as A } from "element-plus";
import { ElButton as F } from "element-plus";
import { ElInput as D } from "element-plus";
import { ElDrawer as H } from "element-plus";
import M from "./header.vue.js";
import P from "./second-table.vue.js";
import q from "./invoice-info.vue.js";
import { p as G } from "../../../../../modules/invoice-entry-d5222a89.js";
import { _ as J, dp as K, R as O, e2 as Q, e6 as b } from "../../../../../shared/runtime.js";
import "../../../../../modules/invoice-entry-d59b5377.js";
import "../../../../../modules/payment-settlement-a7865af1.js";
import "../../../../../modules/hook-467b8301.js";
import "../../../../../modules/useTableTotal-3d22365a.js";
const W = { class: "drawer-container" }, X = { class: "remark-container box-container" }, Y = { class: "box-container" }, Z = { __name: "index", emits: ["component-mounted", "close"], setup(ee, { expose: k, emit: y }) {
  const o = c({ supplierId: null, orderIds: null, attachmentIds: null, invoiceSerialNumber: null, orderInvoiceList: [] }), r = l(false), I = l([]), p = c({}), m = l(null), u = l(null), _ = l([]), h = y;
  z(() => {
    h("component-mounted", true);
  });
  const V = B(), g = async () => {
    try {
      await Promise.all(_.value.map((t) => t())), await G(o), Q("success", "操作成功"), o.orderInvoiceList.splice(0, o.orderInvoiceList.length), r.value = false, await V.dispatch("approval_list/fetchApprovalNum");
    } catch (t) {
      console.log("发票入账审批失败" + t);
    }
  }, i = l([]);
  C(() => i.value, (t) => {
    o.attachmentIds = t.map((e) => e.id);
  }, { deep: true });
  const L = () => {
    b(o), b(p), i.value.splice(0);
  };
  v("saveList", _), v("invoice_data", c({ formData: o, attachmentsList: I, secondRef: m, headerRef: u, projectInfo: p }));
  const R = S(() => !(o != null && o.supplierId));
  return k({ visible: r }), (t, e) => {
    const E = A, f = F, N = D, T = H;
    return w(), U("div", W, [s(T, { modelValue: r.value, "onUpdate:modelValue": e[3] || (e[3] = (a) => r.value = a), "close-on-click-modal": false, "close-on-press-escape": false, "show-close": false, "destroy-on-close": "", size: "60%", onClose: L }, { header: n(() => [s(K, { "type-one": false, "header-title": "发票入账" }, { subTitle: n(() => [R.value ? (w(), $(E, { key: 0, size: "default", type: "danger" }, { default: n(() => e[4] || (e[4] = [d("请先选择供应商!")])), _: 1, __: [4] })) : j("", true)]), _: 1 }), s(f, { size: "default", onClick: e[0] || (e[0] = (a) => r.value = false) }, { default: n(() => e[5] || (e[5] = [d("关闭")])), _: 1, __: [5] }), s(f, { size: "default", type: "success", onClick: g }, { default: n(() => e[6] || (e[6] = [d("发起审批")])), _: 1, __: [6] })]), default: n(() => [s(M, { ref_key: "headerRef", ref: u, class: "box-container" }, null, 512), s(P, { ref_key: "secondRef", ref: m, class: "box-container" }, null, 512), s(q, { class: "box-container" }), x("div", X, [s(N, { modelValue: o.remark, "onUpdate:modelValue": e[1] || (e[1] = (a) => o.remark = a), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), x("div", Y, [s(O, { files: i.value, "onUpdate:files": [e[2] || (e[2] = (a) => i.value = a), t.updateFiles], class: "el-form-item-15", "empty-text": "点击按钮上传附件", "show-download": "", showView: "" }, null, 8, ["files", "onUpdate:files"])])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, pe = J(Z, [["__scopeId", "data-v-43c37148"]]);
export {
  pe as default
};
