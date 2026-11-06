import {requireBooleanOperation} from '../../../../../runtime/settlement-result.js';
import { reactive as d } from "vue";
import { ref as a } from "vue";
import { onMounted as z } from "vue";
import { useStore as B } from "vuex";
import { watch as L } from "vue";
import { provide as h } from "vue";
import { computed as S } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as A } from "vue";
import { createVNode as s } from "vue";
import { withCtx as n } from "vue";
import { createBlock as M } from "vue";
import { createTextVNode as u } from "vue";
import { createCommentVNode as P } from "vue";
import { createElementVNode as g } from "vue";
import { ElTag as U } from "element-plus";
import { ElButton as $ } from "element-plus";
import { ElInput as D } from "element-plus";
import { ElDrawer as F } from "element-plus";
import H from "./header.vue.js";
import q from "./second-table.vue.js";
import G from "./invoice-info.vue.js";
import { p as J } from "../../../../../modules/invoice-entry-97d1bf05.js";
import { _ as K, dp as O, R as Q, e2 as W, e6 as w, G as hasPermission, vf as bgPermissions } from "../../../../../shared/runtime.js";
import "../../../../../modules/invoice-entry-bd0669f8.js";
import "../../../../../modules/hook-75706e02.js";
import "../../../../../modules/payment-settlement-e8e799d8.js";
import "../../../../../modules/useTableTotal-3d22365a.js";
const X = { class: "drawer-container" }, Y = { class: "remark-container box-container" }, Z = { class: "box-container" }, ee = { __name: "index", emits: ["component-mounted", "close"], setup(te, { expose: y, emit: k }) {
  const t = d({ projectManagerId: null, orderId: null, supplierPaymentId: null, projectId: null, supplierId: null, purchaseContractNumber: null, invoiceAmount: null, invoiceSerialNumber: null }), r = a(false), I = a([]), p = d({}), m = a(null), i = a([]), _ = a(null), f = a([]), v = k;
  z(() => {
    v("component-mounted", true);
  });
  const V = B(), submitLoading = a(false), N = async () => {
    if (submitLoading.value) return;
    try {
      if (!hasPermission(bgPermissions.invoice_entry)) throw new Error("没有发票登记权限");
      submitLoading.value = true;
      await Promise.all(f.value.map((o) => o()));
      requireBooleanOperation(await J(t));
      W("success", "发票登记已提交"), i.value.splice(0, i.value.length), r.value = false, await V.dispatch("approval_list/fetchApprovalNum");
    } catch (o) {
      W("error", o.message || "发票登记未成功，请重试");
    } finally { submitLoading.value = false; }
  }, c = a([]);
  L(() => c.value, (o) => {
    o.length === 1 && (t.attachmentId = o[0].id), o.length > 1 && c.value.splice(0, 1), o.length === 0 && (t.attachmentId = null);
  }, { deep: true });
  const C = () => {
    i.value.splice(0, i.value.length), w(t), w(p), c.value.splice(0), v("close");
  };
  h("saveList", f), h("invoice_data", d({ formData: t, attachmentsList: I, secondRef: m, tableList: i, headerRef: _, projectInfo: p }));
  const E = S(() => !(t != null && t.projectManagerId));
  return y({ visible: r }), (o, e) => {
    const R = U, x = $, T = D, j = F;
    return b(), A("div", X, [s(j, { modelValue: r.value, "onUpdate:modelValue": e[3] || (e[3] = (l) => r.value = l), "close-on-click-modal": false, "close-on-press-escape": false, "show-close": false, "destroy-on-close": "", size: "45%", onClosed: C }, { header: n(() => [s(O, { "type-one": false, "header-title": "发票入账 -【 内包&合营 】" }, { subTitle: n(() => [E.value ? (b(), M(R, { key: 0, size: "default", type: "danger" }, { default: n(() => e[4] || (e[4] = [u("请先选择项目经理!")])), _: 1, __: [4] })) : P("", true)]), _: 1 }), s(x, { size: "default", onClick: e[0] || (e[0] = (l) => r.value = false) }, { default: n(() => e[5] || (e[5] = [u("关闭")])), _: 1, __: [5] }), s(x, { size: "default", type: "success", loading: submitLoading.value, onClick: N }, { default: n(() => e[6] || (e[6] = [u("发起审批")])), _: 1, __: [6] })]), default: n(() => [s(H, { ref_key: "headerRef", ref: _, class: "box-container" }, null, 512), s(q, { ref_key: "secondRef", ref: m, class: "box-container" }, null, 512), s(G, { class: "box-container" }), g("div", Y, [s(T, { modelValue: t.remark, "onUpdate:modelValue": e[1] || (e[1] = (l) => t.remark = l), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), g("div", Z, [s(Q, { files: c.value, "onUpdate:files": e[2] || (e[2] = (l) => c.value = l), class: "el-form-item-15", "empty-text": "点击按钮上传附件", "show-download": "", showView: "" }, null, 8, ["files"])])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, pe = K(ee, [["__scopeId", "data-v-a4d70bd0"]]);
export {
  pe as default
};
