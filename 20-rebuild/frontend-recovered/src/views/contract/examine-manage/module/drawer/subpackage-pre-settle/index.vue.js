import { j9 as g, ja as p, j0 as i } from "../../../../../../shared/runtime.js";
import { inject as m } from "vue";
import { computed as E } from "vue";
import { reactive as B } from "vue";
import { watchEffect as b } from "vue";
import { ref as y } from "vue";
import { watch as j } from "vue";
import { provide as u } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as k } from "vue";
import { createBlock as C } from "vue";
import { resolveDynamicComponent as x } from "vue";
import { unref as F } from "vue";
import { defineAsyncComponent as n } from "vue";
const P = { class: "invoice-container" }, O = { __name: "index", emits: ["updateBtn"], setup(T, { expose: _, emit: d }) {
  const v = m("size");
  v.value = "50%";
  const { id: s, projectAttribute: f, approvalFlag: A } = m("tableItemData"), D = E(() => f), o = B({ settlementAmount: void 0 });
  b(() => {
    s && (o.auditId = s);
  });
  const a = y(), c = { 1: { api: g, com: n(() => i(() => import("./self/index.vue.js"), ["static/js/index-5b1ca29f.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-6f32e91f.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/subpackage-settle-bdb7b46f.js", "static/js/second-2e218398.js", "static/js/useTableTotal-3d22365a.js", "static/js/payment-info-bd75202c.js", "static/js/approval-status-71386381.js", "static/css/index-f3961572.css"])) }, 2: { api: p, com: n(() => i(() => import("./interior/index.vue.js"), ["static/js/index-6fcb8642.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-ee0831ef.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/subpackage-settle-bdb7b46f.js", "static/js/second-table-cbdbbcc3.js", "static/js/useTableTotal-3d22365a.js", "static/js/approval-status-71386381.js", "static/js/payment-table-523f8fe4.js", "static/js/pc-pasychia-data-6ecf5a97.js", "static/js/upload-file-download-812f558c.js", "static/css/payment-table-44509e9f.css", "static/css/index-705c53c0.css"])) }, 3: { api: p, com: n(() => i(() => import("./interior/index.vue.js"), ["static/js/index-6fcb8642.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-ee0831ef.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/subpackage-settle-bdb7b46f.js", "static/js/second-table-cbdbbcc3.js", "static/js/useTableTotal-3d22365a.js", "static/js/approval-status-71386381.js", "static/js/payment-table-523f8fe4.js", "static/js/pc-pasychia-data-6ecf5a97.js", "static/js/upload-file-download-812f558c.js", "static/css/payment-table-44509e9f.css", "static/css/index-705c53c0.css"])) } }, h = d, I = async (t) => {
    try {
      const e = await c[t].api({ auditId: s });
      e.passButton && h("updateBtn", e.passButton), a.value = e, a.value.isDisabled = a.value.boolFinalApprover && A, o.settlementAmount = a.value.settlementAmount;
    } catch (e) {
      console.error("获取审批详情失败：getIncomeDetail", e);
    }
  };
  let r;
  return j(() => D.value, async (t) => {
    var e;
    t && (r = (e = c[t]) == null ? void 0 : e.com, await I(t));
  }, { immediate: true }), u("approveInfo", a), u("purchaseForm", o), _({ purchaseForm: o }), (t, e) => (l(), k("div", P, [(l(), C(x(F(r))))]));
} };
export {
  O as default
};
