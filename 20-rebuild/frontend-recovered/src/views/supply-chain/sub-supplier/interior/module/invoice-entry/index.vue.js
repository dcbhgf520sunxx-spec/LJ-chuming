import { reactive as d } from "vue";
import { ref as a } from "vue";
import { onMounted as j } from "vue";
import { watch as z } from "vue";
import { provide as b } from "vue";
import { computed as B } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as L } from "vue";
import { createVNode as s } from "vue";
import { withCtx as n } from "vue";
import { createBlock as P } from "vue";
import { createTextVNode as u } from "vue";
import { createCommentVNode as M } from "vue";
import { createElementVNode as h } from "vue";
import { ElTag as S } from "element-plus";
import { ElButton as U } from "element-plus";
import { ElInput as $ } from "element-plus";
import { ElDrawer as A } from "element-plus";
import D from "./header.vue.js";
import F from "./second-table.vue.js";
import H from "./invoice-info.vue.js";
import { _ as q, dp as G, R as J, e2 as K, e6 as y } from "../../../../../../shared/runtime.js";
import { P as O } from "../../../../../../modules/index-69cea220.js";
import "../../../../../../modules/invoice-entry-8680260e.js";
import "../../../../../../modules/info-d30309fa.js";
import "../../../../../../modules/useTableTotal-3d22365a.js";
const Q = { class: "drawer-container" }, W = { class: "remark-container box-container" }, X = { class: "box-container" }, Y = { __name: "index", emits: ["component-mounted", "close"], setup(Z, { expose: w, emit: I }) {
  const t = d({ projectManagerId: null, orderId: null, supplierPaymentId: null, projectId: null, supplierId: null, purchaseContractNumber: null, invoiceAmount: null, invoiceSerialNumber: null }), r = a(false), k = a([]), m = d({}), p = a(null), i = a([]), f = a(null), _ = a([]), v = I;
  j(() => {
    v("component-mounted", true);
  });
  const V = async () => {
    try {
      await Promise.all(_.value.map((o) => o())), await O(t), K("success", "操作成功"), i.value.splice(0, i.value.length), r.value = false;
    } catch (o) {
      console.log(o);
    }
  }, c = a([]);
  z(() => c.value, (o) => {
    o.length === 1 && (t.attachmentId = o[0].id), o.length > 1 && c.value.splice(0, 1), o.length === 0 && (t.attachmentId = null);
  }, { deep: true });
  const E = () => {
    i.value.splice(0, i.value.length), y(t), y(m), c.value.splice(0), v("close");
  };
  b("saveList", _), b("invoice_data", d({ formData: t, attachmentsList: k, secondRef: p, tableList: i, headerRef: f, projectInfo: m }));
  const C = B(() => !(t != null && t.projectManagerId));
  return w({ visible: r }), (o, e) => {
    const N = S, x = U, R = $, T = A;
    return g(), L("div", Q, [s(T, { modelValue: r.value, "onUpdate:modelValue": e[3] || (e[3] = (l) => r.value = l), "close-on-click-modal": false, "close-on-press-escape": false, "show-close": false, "destroy-on-close": "", size: "45%", onClosed: E }, { header: n(() => [s(G, { "type-one": false, "header-title": "发票入账 -【 内包&合营 】" }, { subTitle: n(() => [C.value ? (g(), P(N, { key: 0, size: "default", type: "danger" }, { default: n(() => e[4] || (e[4] = [u("请先选择项目经理!")])), _: 1, __: [4] })) : M("", true)]), _: 1 }), s(x, { size: "default", onClick: e[0] || (e[0] = (l) => r.value = false) }, { default: n(() => e[5] || (e[5] = [u("关闭")])), _: 1, __: [5] }), s(x, { size: "default", type: "success", onClick: V }, { default: n(() => e[6] || (e[6] = [u("发起审批")])), _: 1, __: [6] })]), default: n(() => [s(D, { ref_key: "headerRef", ref: f, class: "box-container" }, null, 512), s(F, { ref_key: "secondRef", ref: p, class: "box-container" }, null, 512), s(H, { class: "box-container" }), h("div", W, [s(R, { modelValue: t.remark, "onUpdate:modelValue": e[1] || (e[1] = (l) => t.remark = l), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), h("div", X, [s(J, { files: c.value, "onUpdate:files": e[2] || (e[2] = (l) => c.value = l), class: "el-form-item-15", "empty-text": "点击按钮上传附件", "show-download": "", showView: "" }, null, 8, ["files"])])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, ce = q(Y, [["__scopeId", "data-v-4ad1f609"]]);
export {
  ce as default
};
