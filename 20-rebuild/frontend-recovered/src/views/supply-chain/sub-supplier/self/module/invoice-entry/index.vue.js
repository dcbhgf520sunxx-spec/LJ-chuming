import { reactive as d } from "vue";
import { ref as s } from "vue";
import { onMounted as L } from "vue";
import { useStore as S } from "vuex";
import { watch as A } from "vue";
import { provide as w } from "vue";
import { computed as P } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as U } from "vue";
import { createVNode as o } from "vue";
import { withCtx as n } from "vue";
import { createBlock as $ } from "vue";
import { createTextVNode as u } from "vue";
import { createCommentVNode as j } from "vue";
import { createElementVNode as b } from "vue";
import { ElTag as D } from "element-plus";
import { ElButton as F } from "element-plus";
import { ElInput as H } from "element-plus";
import { ElDrawer as M } from "element-plus";
import q from "./header.vue.js";
import G from "./second-table.vue.js";
import J from "./invoice-info.vue.js";
import { _ as K, dp as O, R as Q, e2 as W, e6 as h } from "../../../../../../shared/runtime.js";
import { P as X } from "../../../../../../modules/index-dfff0f60.js";
import "../../../../../../modules/invoice-entry-de8cd325.js";
import "../../../../../../modules/useTableTotal-3d22365a.js";
const Y = { class: "drawer-container" }, Z = { class: "remark-container box-container" }, ee = { class: "box-container" }, te = { __name: "index", emits: ["component-mounted", "closed"], setup(oe, { expose: k, emit: I }) {
  const t = d({ supplierId: null, orderId: null, attachmentId: null, invoiceAmount: null, invoiceSerialNumber: null, paymentId: null }), r = s(false), V = s([]), m = d({}), p = s(null), i = s([]), _ = s(null), f = s([]), v = I;
  L(() => {
    v("component-mounted", true);
  });
  const g = S(), E = async () => {
    try {
      await Promise.all(f.value.map((a) => a())), await X(t), W("success", "操作成功"), i.value.splice(0, i.value.length), r.value = false, await g.dispatch("approval_list/fetchApprovalNum");
    } catch (a) {
      console.log("发票入账审批失败" + a);
    }
  }, c = s([]);
  A(() => c.value, (a) => {
    t.attachmentId = a.map((e) => e.id);
  }, { deep: true });
  const C = () => {
    i.value.splice(0, i.value.length), h(t), h(m), c.value.splice(0);
  };
  w("saveList", f), w("invoice_data", d({ formData: t, attachmentsList: V, secondRef: p, tableList: i, headerRef: _, projectInfo: m }));
  const N = P(() => !(t != null && t.supplierId));
  function R() {
    v("closed");
  }
  return k({ visible: r }), (a, e) => {
    const T = D, x = F, z = H, B = M;
    return y(), U("div", Y, [o(B, { modelValue: r.value, "onUpdate:modelValue": e[3] || (e[3] = (l) => r.value = l), "close-on-click-modal": false, "close-on-press-escape": false, "show-close": false, "destroy-on-close": "", size: "45%", onClose: C, onClosed: R }, { header: n(() => [o(O, { "type-one": false, "header-title": "发票入账" }, { subTitle: n(() => [N.value ? (y(), $(T, { key: 0, size: "default", type: "danger" }, { default: n(() => e[4] || (e[4] = [u("请先选择分包商!")])), _: 1, __: [4] })) : j("", true)]), _: 1 }), o(x, { size: "default", type: "success", onClick: E }, { default: n(() => e[5] || (e[5] = [u("发起审批")])), _: 1, __: [5] }), o(x, { size: "default", onClick: e[0] || (e[0] = (l) => r.value = false) }, { default: n(() => e[6] || (e[6] = [u("关闭")])), _: 1, __: [6] })]), default: n(() => [o(q, { ref_key: "headerRef", ref: _, class: "box-container" }, null, 512), o(G, { ref_key: "secondRef", ref: p, class: "box-container" }, null, 512), o(J, { class: "box-container" }), b("div", Z, [o(z, { modelValue: t.remark, "onUpdate:modelValue": e[1] || (e[1] = (l) => t.remark = l), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), b("div", ee, [o(Q, { files: c.value, "onUpdate:files": e[2] || (e[2] = (l) => c.value = l), class: "el-form-item-15", "empty-text": "单文件上传", "show-download": "", showView: "" }, null, 8, ["files"])])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, ue = K(te, [["__scopeId", "data-v-74848f1a"]]);
export {
  ue as default
};
