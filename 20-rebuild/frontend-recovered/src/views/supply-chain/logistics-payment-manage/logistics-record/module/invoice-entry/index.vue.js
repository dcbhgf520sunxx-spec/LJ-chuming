import { reactive as u } from "vue";
import { ref as a } from "vue";
import { provide as _ } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as j } from "vue";
import { createVNode as o } from "vue";
import { withCtx as t } from "vue";
import { createTextVNode as c } from "vue";
import { createElementVNode as d } from "vue";
import { createBlock as w } from "vue";
import { createCommentVNode as k } from "vue";
import { toDisplayString as A } from "vue";
import { ElButton as P } from "element-plus";
import { ElCol as S } from "element-plus";
import { ElUpload as T } from "element-plus";
import { ElRow as U } from "element-plus";
import { ElInput as $ } from "element-plus";
import { ElDrawer as F } from "element-plus";
import H from "./header.vue.js";
import q from "./second-table.vue.js";
import G from "./invoice-info.vue.js";
import { u as J } from "../../../../../../modules/upload-file-download-812f558c.js";
import { i as K } from "../../../../../../modules/grant-managment-2c540b60.js";
import { p as M } from "../../../../../../modules/invoice-entry-97d1bf05.js";
import { _ as O, dp as Q, e2 as W, e6 as g } from "../../../../../../shared/runtime.js";
import "../../../../../../modules/invoice-entry-81d589e9.js";
import "../../../../../../modules/useSelect-654af12a.js";
import "../../../../../../modules/payment-settlement-e8e799d8.js";
const X = { class: "drawer-container" }, Y = { class: "box-container" }, Z = { class: "box-container" }, ee = { class: "box-container" }, oe = { class: "attachment-container box-container" }, te = { class: "remark-container box-container" }, ae = { __name: "index", setup(se, { expose: V }) {
  const s = u({ projectId: null, supplierId: null, purchaseContractNumber: null, invoiceAmount: null, invoiceSerialNumber: null }), i = a(false), C = a([]), E = a([]), v = u({}), b = a(null), l = a([]), x = a(null), h = a([]);
  _("formRefList", h), _("validateList", C), _("invoice_data", u({ formData: s, attachmentsList: E, secondRef: b, tableList: l, headerRef: x, projectInfo: v }));
  const R = () => {
    Promise.all(h.value.map((n) => n.validate())).then(async () => {
      try {
        await M(s), W("success", "操作成功"), l.value.splice(0, l.value.length), i.value = false;
      } catch (n) {
        console.log(n);
      }
    });
  }, y = a(""), I = async (n) => {
    const { id: e, data: r } = await J(n, K);
    s.attachmentId = e, y.value = r[0].name;
  }, N = () => {
    l.value.splice(0, l.value.length), g(s), g(v);
  };
  return V({ visible: i }), (n, e) => {
    const r = P, p = S, L = T, z = U, B = $, D = F;
    return f(), j("div", X, [o(D, { size: "50%", modelValue: i.value, "onUpdate:modelValue": e[2] || (e[2] = (m) => i.value = m), "show-close": false, "close-on-press-escape": false, "close-on-click-modal": false, "destroy-on-close": "", onClose: N }, { title: t(() => [o(Q, { "type-one": false, "header-title": "发票入账" }), o(r, { size: "mini", onClick: e[0] || (e[0] = (m) => i.value = false) }, { default: t(() => e[3] || (e[3] = [c("关闭")])), _: 1, __: [3] }), o(r, { size: "mini", type: "success", onClick: R }, { default: t(() => e[4] || (e[4] = [c("发起审批")])), _: 1, __: [4] })]), default: t(() => [d("div", Y, [o(H, { ref_key: "headerRef", ref: x }, null, 512)]), d("div", Z, [l.value.length ? (f(), w(q, { key: 0, ref_key: "secondRef", ref: b }, null, 512)) : k("", true)]), d("div", ee, [s.supplierPaymentId ? (f(), w(G, { key: 0 })) : k("", true)]), d("div", oe, [o(z, null, { default: t(() => [o(p, { class: "col-container", span: 3 }, { default: t(() => e[5] || (e[5] = [c(" 附件 ")])), _: 1, __: [5] }), o(p, { class: "col-container", span: 18 }, { default: t(() => [c(A(y.value), 1)]), _: 1 }), o(p, { class: "col-container upload-container", span: 3 }, { default: t(() => [o(L, { multiple: "", action: "#", "auto-upload": false, "on-change": I, "show-file-list": false }, { default: t(() => [o(r, { icon: "el-icon-upload", type: "primary", plain: "", size: "mini" }, { default: t(() => e[6] || (e[6] = [c("导入")])), _: 1, __: [6] })]), _: 1 })]), _: 1 })]), _: 1 })]), d("div", te, [o(B, { class: "textarea-container", autosize: { minRows: 2 }, maxlength: "1000", "show-word-limit": "", modelValue: s.remark, "onUpdate:modelValue": e[1] || (e[1] = (m) => s.remark = m), type: "textarea", placeholder: "备注" }, null, 8, ["modelValue"])])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, xe = O(ae, [["__scopeId", "data-v-8b964b86"]]);
export {
  xe as default
};
