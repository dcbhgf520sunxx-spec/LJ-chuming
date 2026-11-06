import { j4 as E, j5 as _, j0 as c } from "../../../../../../shared/runtime.js";
import { ref as i } from "vue";
import { onBeforeMount as C } from "vue";
import { inject as b } from "vue";
import { reactive as I } from "vue";
import { computed as L } from "vue";
import { provide as f } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as P } from "vue";
import { createBlock as k } from "vue";
import { resolveDynamicComponent as x } from "vue";
import { createCommentVNode as O } from "vue";
import { defineAsyncComponent as p } from "vue";
const S = { class: "purchase-container" }, w = { __name: "index", emits: ["updateBtn"], setup(T, { expose: D, emit: v }) {
  const u = i(false);
  let e, a, o;
  C(() => {
    e = b("tableItemData"), o = e.projectAttribute, a = e.id, n.auditId = a, B();
  });
  const l = I({}), m = i(), d = i(), n = I({ attachmentId: "", supplierPayment: [], paymentDate: (/* @__PURE__ */ new Date()).getTime() }), A = v, g = { 1: p(() => c(() => import("./autopsychia/index.vue.js"), ["static/js/index-51545253.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-130a6c6a.js", "static/js/pc-pasychia-data-6ecf5a97.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/second-table-8be32def.js", "static/js/useTableTotal-3d22365a.js", "static/css/second-table-c68aa56f.css", "static/js/payment-info-de6b880f.js", "static/js/payment-settlement-a7865af1.js", "static/js/payment-table-523f8fe4.js", "static/js/upload-file-download-812f558c.js", "static/css/payment-table-44509e9f.css", "static/js/UploadList-ad01af55.js", "static/css/UploadList-d7d36eff.css", "static/js/approval-status-71386381.js", "static/css/index-8724af0a.css"])), 2: p(() => c(() => import("./in-sourcing/index.vue.js"), ["static/js/index-bf40bc70.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-41ce5682.js", "static/js/pc-insourc-data-b34c8a60.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/second-table-06e377bc.js", "static/js/upload-file-download-812f558c.js", "static/css/second-table-c5c19871.css", "static/js/payment-table-523f8fe4.js", "static/js/pc-pasychia-data-6ecf5a97.js", "static/css/payment-table-44509e9f.css", "static/js/approval-status-71386381.js", "static/css/index-dfa4ab26.css"])), 3: p(() => c(() => import("./in-sourcing/index.vue.js"), ["static/js/index-bf40bc70.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-41ce5682.js", "static/js/pc-insourc-data-b34c8a60.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/second-table-06e377bc.js", "static/js/upload-file-download-812f558c.js", "static/css/second-table-c5c19871.css", "static/js/payment-table-523f8fe4.js", "static/js/pc-pasychia-data-6ecf5a97.js", "static/css/payment-table-44509e9f.css", "static/js/approval-status-71386381.js", "static/css/index-dfa4ab26.css"])) }, y = L(() => g[o]), j = { 1: E, 2: _, 3: _ }, B = async () => {
    var s, r;
    try {
      const t = await j[o]({ auditId: a });
      t.passButton && A("updateBtn", t.passButton), Object.assign(l, t), m.value = ((s = t.projectSupplierDto) == null ? void 0 : s.attachmentId) || null, d.value = ((r = t.supplierAuditSelfEmployedDto) == null ? void 0 : r.attachmentIds) | null, u.value = true;
    } catch (t) {
      console.log(t);
    }
  };
  return f("purchaseInfo", { purchaseInfo: l, attachmentId: m, attachmentIds: d }), f("purchaseForm", n), D({ purchaseForm: n }), (s, r) => (h(), P("div", S, [u.value ? (h(), k(x(y.value), { key: 0 })) : O("", true)]));
} };
export {
  w as default
};
