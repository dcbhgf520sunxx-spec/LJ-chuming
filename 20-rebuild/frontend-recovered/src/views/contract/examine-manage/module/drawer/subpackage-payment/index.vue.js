import { j4 as B, j5 as _, j0 as r } from "../../../../../../shared/runtime.js";
import { reactive as f } from "vue";
import { ref as i } from "vue";
import { onBeforeMount as P } from "vue";
import { inject as C } from "vue";
import { computed as b } from "vue";
import { provide as I } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as L } from "vue";
import { createBlock as S } from "vue";
import { resolveDynamicComponent as k } from "vue";
import { createCommentVNode as x } from "vue";
import { defineAsyncComponent as u } from "vue";
const O = { class: "purchase-container" }, w = { __name: "index", emits: ["updateBtn"], setup(T, { expose: D, emit: y }) {
  const e = f({ attachmentId: void 0, supplierPayment: [], actuallyPayAmount: void 0, paymentDate: (/* @__PURE__ */ new Date()).getTime() }), p = i(false);
  let a, o, n;
  P(() => {
    a = C("tableItemData"), n = a.projectAttribute, o = a.id, e.auditId = o, j();
  });
  const l = f({}), m = i(), d = i(), A = y, v = { 1: u(() => r(() => import("./autopsychia/index.vue.js"), ["static/js/index-04d9bc55.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/approval-status-71386381.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/header-2660aaa0.js", "static/js/sp-pasychia-data-d374d1e9.js", "static/js/second-table-b6b2e1f3.js", "static/js/index-dfff0f60.js", "static/js/pc-pasychia-data-6ecf5a97.js", "static/css/second-table-091999a7.css", "static/js/payment-table-523f8fe4.js", "static/js/upload-file-download-812f558c.js", "static/css/payment-table-44509e9f.css", "static/css/index-1641c023.css"])), 2: u(() => r(() => import("./insourcing/index.vue.js"), ["static/js/index-2801ac08.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-f45ae3d1.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/sp-inscourc-data-0cdb98a1.js", "static/js/second-table-38b57d71.js", "static/js/payment-table-523f8fe4.js", "static/js/pc-pasychia-data-6ecf5a97.js", "static/js/upload-file-download-812f558c.js", "static/css/payment-table-44509e9f.css", "static/js/approval-status-71386381.js", "static/css/index-22e701bf.css"])), 3: u(() => r(() => import("./insourcing/index.vue.js"), ["static/js/index-2801ac08.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-f45ae3d1.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/sp-inscourc-data-0cdb98a1.js", "static/js/second-table-38b57d71.js", "static/js/payment-table-523f8fe4.js", "static/js/pc-pasychia-data-6ecf5a97.js", "static/js/upload-file-download-812f558c.js", "static/css/payment-table-44509e9f.css", "static/js/approval-status-71386381.js", "static/css/index-22e701bf.css"])) }, g = b(() => v[n]), E = { 1: B, 2: _, 3: _ }, j = async () => {
    var s, c;
    try {
      const t = await E[n]({ auditId: o });
      t.passButton && A("updateBtn", t.passButton), Object.assign(l, t), m.value = ((s = t.projectSupplierDto) == null ? void 0 : s.attachmentId) || null, d.value = ((c = t.supplierAuditSelfEmployedDto) == null ? void 0 : c.attachmentIds) | null, e.actuallyPayAmount = t.supplierAuditSelfEmployedDto.paymentAmount, p.value = true;
    } catch (t) {
      console.log(t);
    }
  };
  return I("purchaseInfo", { purchaseInfo: l, attachmentId: m, attachmentIds: d }), I("purchaseForm", e), D({ purchaseForm: e }), (s, c) => (h(), L("div", O, [p.value ? (h(), S(k(g.value), { key: 0 })) : x("", true)]));
} };
export {
  w as default
};
