import { j6 as h, j0 as I } from "../../../../../../shared/runtime.js";
import { inject as r } from "vue";
import { computed as D } from "vue";
import { reactive as B } from "vue";
import { watchEffect as y } from "vue";
import { ref as A } from "vue";
import { watch as b } from "vue";
import { provide as p } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as g } from "vue";
import { createBlock as w } from "vue";
import { resolveDynamicComponent as C } from "vue";
import { unref as j } from "vue";
import { defineAsyncComponent as x } from "vue";
const E = { class: "invoice-container" }, z = { __name: "index", emits: ["updateBtn"], setup(F, { expose: l, emit: u }) {
  const d = r("size");
  d.value = "50%";
  const t = r("tableItemData"), v = D(() => t.projectAttribute), { id: n } = t, s = B({});
  y(() => {
    t.id && (s.auditId = n);
  });
  const a = A(), c = { 1: { api: h, com: x(() => I(() => import("./income/index.vue.js"), ["static/js/index-2bbe2598.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-36975658.js", "static/js/invoice-income-831df2fb.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/invoice-info-b2ad6541.js", "static/js/pc-pasychia-data-6ecf5a97.js", "static/js/approval-status-71386381.js", "static/css/index-d74bc927.css"])) } }, _ = u, f = async (o) => {
    try {
      const e = await c[o].api({ auditId: n });
      e.passButton && _("updateBtn", e.passButton), a.value = e, a.value.isDisabled = a.value.boolFinalApprover && t.approvalFlag;
    } catch (e) {
      console.error("获取审批详情失败：getIncomeDetail", e);
    }
  };
  let i;
  return b(() => v.value, async (o) => {
    o && (i = c[1].com, await f(1));
  }, { immediate: true }), p("approveInfo", a), p("purchaseForm", s), l({ purchaseForm: s }), (o, e) => (m(), g("div", E, [(m(), w(C(j(i))))]));
} };
export {
  z as default
};
