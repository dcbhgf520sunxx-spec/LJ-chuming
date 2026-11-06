import { inject as r } from "vue";
import { ref as m } from "vue";
import { watchEffect as i } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as u } from "vue";
import { createVNode as e } from "vue";
import { createElementVNode as _ } from "vue";
import { withCtx as f } from "vue";
import { unref as h } from "vue";
import { ElTableColumn as b } from "element-plus";
import { ec as v, dp as w } from "../../../../../../../shared/runtime.js";
import { u as y } from "../../../../../../../modules/useTableTotal-3d22365a.js";
const g = { class: "second-table-container" }, x = { class: "table" }, k = { __name: "second-table", setup(D) {
  const l = r("approveInfo"), o = m([]);
  i(() => {
    l.value && (o.value = v(l.value.dto), o.value.forEach((t) => {
      Object.keys(t).forEach((n) => {
        t[n] || (t[n] = "-");
      });
    }));
  });
  const { getSummaries: c } = y(true, { defineData: ["paymentAmount", "invoiceAmount"] });
  return (t, n) => {
    const a = b, s = p("common-table");
    return d(), u("div", g, [e(w, { "header-title": "付款及发票记录" }), _("div", x, [e(s, { data: o.value, "summary-method": h(c), "max-height": "240", "show-summary": "" }, { default: f(() => [e(a, { align: "center", label: "序号", type: "index", width: "80" }), e(a, { align: "center", label: "付款", "min-width": "140", prop: "paymentAmount" }), e(a, { align: "center", label: "日期", "min-width": "140", prop: "paymentDate" }), e(a, { align: "center", label: "发票", "min-width": "140", prop: "invoiceAmount" }), e(a, { align: "center", label: "日期", "min-width": "140", prop: "invoiceDate" })]), _: 1 }, 8, ["data", "summary-method"])])]);
  };
} };
export {
  k as default
};
