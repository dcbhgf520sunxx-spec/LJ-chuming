import { iZ as D, i_ as h, i$ as g, j0 as r } from "../../../../../../shared/runtime.js";
import { inject as p } from "vue";
import { reactive as B } from "vue";
import { watchEffect as E } from "vue";
import { ref as y } from "vue";
import { computed as A } from "vue";
import { provide as m } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as C } from "vue";
import { createBlock as x } from "vue";
import { resolveDynamicComponent as P } from "vue";
import { defineAsyncComponent as l } from "vue";
const k = { class: "invoice-container" }, w = { __name: "index", emits: ["updateBtn"], setup(O, { expose: _, emit: d }) {
  const a = p("tableItemData"), { paymentEnum: o, id: n, auditType: s } = a, t = B({});
  E(() => {
    a.id && (t.auditId = n);
  });
  const v = p("size");
  v.value = s === 3 ? "50%" : "60%";
  const i = y(), c = { 3: { api: s === 3 ? D : h, com: l(() => r(() => import("./income/index.vue.js"), ["static/js/index-e2835951.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-e03684ca.js", "static/js/invoice-income-831df2fb.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/header-v2-4831fa5d.js", "static/js/second-table-a8f4bffe.js", "static/js/useTableTotal-3d22365a.js", "static/js/second-v2-table-432bebea.js", "static/js/invoice-info-594f3c3a.js", "static/js/invoice-v2-info-df90e568.js", "static/js/approval-status-71386381.js", "static/css/index-9c69be62.css"])) }, 4: { api: g, com: l(() => r(() => import("./output/index.vue.js"), ["static/js/index-d098aab7.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/header-b21bbd67.js", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/invoice-output-9861b945.js", "static/js/useSelect-654af12a.js", "static/js/approval-status-71386381.js", "static/css/index-e4a1f3d0.css"])) } }, f = A(() => c[o].com), I = d;
  return (async () => {
    try {
      const e = await c[o].api({ auditId: n });
      e.passButton && I("updateBtn", e.passButton), i.value = e;
    } catch (e) {
      console.log("发票审核获取信息失败" + e);
    }
  })(), m("approveInfo", i), m("purchaseForm", t), _({ purchaseForm: t }), (e, V) => (u(), C("div", k, [(u(), x(P(f.value)))]));
} };
export {
  w as default
};
