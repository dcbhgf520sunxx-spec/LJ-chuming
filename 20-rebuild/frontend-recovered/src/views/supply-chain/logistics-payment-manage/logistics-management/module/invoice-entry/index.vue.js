import { reactive as d } from "vue";
import { ref as a } from "vue";
import { onMounted as C } from "vue";
import { watch as L } from "vue";
import { provide as x } from "vue";
import { computed as N } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as S } from "vue";
import { createVNode as s } from "vue";
import { withCtx as n } from "vue";
import { createBlock as U } from "vue";
import { createTextVNode as u } from "vue";
import { createCommentVNode as $ } from "vue";
import { createElementVNode as b } from "vue";
import { ElTag as j } from "element-plus";
import { ElButton as A } from "element-plus";
import { ElInput as D } from "element-plus";
import { ElDrawer as F } from "element-plus";
import H from "./header.vue.js";
import M from "./second-table.vue.js";
import P from "./invoice-info.vue.js";
import { p as q } from "../../../../../../modules/invoice-entry-d5222a89.js";
import { _ as G, dp as J, R as K, e2 as O, e6 as w } from "../../../../../../shared/runtime.js";
import "../../../../../../modules/invoice-entry-a9ceb692.js";
import "../../../../../../modules/hook-467b8301.js";
import "../../../../../../modules/payment-settlement-a7865af1.js";
import "../../../../../../modules/useTableTotal-3d22365a.js";
const Q = { class: "drawer-container" }, W = { class: "remark-container box-container" }, X = { class: "box-container" }, Y = { __name: "index", emits: ["component-mounted", "close"], setup(Z, { expose: y, emit: g }) {
  const t = d({ supplierId: null, orderId: null, attachmentId: null, invoiceAmount: null, invoiceSerialNumber: null, paymentId: null }), i = a(false), k = a([]), m = d({}), p = a(null), r = a([]), _ = a(null), f = a([]), I = g;
  C(() => {
    I("component-mounted", true);
  });
  const V = async () => {
    try {
      await Promise.all(f.value.map((o) => o())), await q(t), O("success", "操作成功"), r.value.splice(0, r.value.length), i.value = false;
    } catch (o) {
      console.log("发票入账审批失败" + o);
    }
  }, c = a([]);
  L(() => c.value, (o) => {
    o.length === 1 && (t.attachmentId = o[0].id), o.length > 1 && c.value.splice(0, 1), o.length === 0 && (t.attachmentId = null);
  }, { deep: true });
  const R = () => {
    r.value.splice(0, r.value.length), w(t), w(m), c.value.splice(0);
  };
  x("saveList", f), x("invoice_data", d({ formData: t, attachmentsList: k, secondRef: p, tableList: r, headerRef: _, projectInfo: m }));
  const E = N(() => !(t != null && t.supplierId));
  return y({ visible: i }), (o, e) => {
    const T = j, v = A, z = D, B = F;
    return h(), S("div", Q, [s(B, { modelValue: i.value, "onUpdate:modelValue": e[3] || (e[3] = (l) => i.value = l), "close-on-click-modal": false, "close-on-press-escape": false, "show-close": false, "destroy-on-close": "", size: "45%", onClose: R }, { header: n(() => [s(J, { "type-one": false, "header-title": "发票入账" }, { subTitle: n(() => [E.value ? (h(), U(T, { key: 0, size: "default", type: "danger" }, { default: n(() => e[4] || (e[4] = [u("请先选择供应商!")])), _: 1, __: [4] })) : $("", true)]), _: 1 }), s(v, { size: "default", onClick: e[0] || (e[0] = (l) => i.value = false) }, { default: n(() => e[5] || (e[5] = [u("关闭")])), _: 1, __: [5] }), s(v, { size: "default", type: "success", onClick: V }, { default: n(() => e[6] || (e[6] = [u("发起审批")])), _: 1, __: [6] })]), default: n(() => [s(H, { ref_key: "headerRef", ref: _, class: "box-container" }, null, 512), s(M, { ref_key: "secondRef", ref: p, class: "box-container" }, null, 512), s(P, { class: "box-container" }), b("div", W, [s(z, { modelValue: t.remark, "onUpdate:modelValue": e[1] || (e[1] = (l) => t.remark = l), autosize: { minRows: 2 }, class: "textarea-container", maxlength: "1000", placeholder: "请输入备注", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])]), b("div", X, [s(K, { files: c.value, "onUpdate:files": e[2] || (e[2] = (l) => c.value = l), class: "el-form-item-15", "empty-text": "点击按钮上传附件", "show-download": "", showView: "" }, null, 8, ["files"])])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, de = G(Y, [["__scopeId", "data-v-8991a6c5"]]);
export {
  de as default
};
