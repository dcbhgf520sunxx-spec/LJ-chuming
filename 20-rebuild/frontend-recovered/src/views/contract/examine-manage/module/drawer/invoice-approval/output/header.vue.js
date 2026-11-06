import { ref as c } from "vue";
import { inject as i } from "vue";
import { watchEffect as u } from "vue";
import { watch as p } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as v } from "vue";
import { createVNode as s } from "vue";
import { withCtx as d } from "vue";
import { unref as _ } from "vue";
import { ElInput as h } from "element-plus";
import { ia as b, ec as y, e3 as N, dp as D, bD as I, e5 as g } from "../../../../../../../shared/runtime.js";
import { h as k } from "../../../../../../../modules/invoice-output-9861b945.js";
const x = { class: "header-container" }, M = { __name: "header", setup(j) {
  const o = c(k), t = i("approveInfo"), m = i("tableItemData"), r = c([]);
  return u(() => {
    if (t != null && t.value) {
      const a = JSON.parse(JSON.stringify(t.value.outputInvoice));
      a.capital = b(a.applyAmount);
      const e = y([a]);
      r.value = N(o.value, e[0]);
    }
  }), p(() => m.projectAttribute, (a) => {
    if (a && a === 1) {
      const e = o.value.find((l) => l.key === "projectManagerName");
      e && (e.label = "销售负责人", e.key = "salesLeaderName", e.value = t.salesLeaderName);
    } else {
      const e = o.value.find((l) => l.key === "salesLeaderName");
      e && (e.label = "项目经理", e.key = "projectManagerName", e.value = t.projectManagerName);
    }
  }, { immediate: true }), (a, e) => {
    const l = h;
    return f(), v("div", x, [s(D, { "header-title": "基本信息" }), s(g, { column: 2, "table-list": r.value, "label-width": "100px" }, { invoiceType: d(({ val: n }) => [s(l, { "model-value": _(I).VL[n], readonly: "" }, null, 8, ["model-value"])]), taxRate: d(({ val: n }) => [s(l, { "model-value": n + " %", readonly: "" }, null, 8, ["model-value"])]), _: 1 }, 8, ["table-list"])]);
  };
} };
export {
  M as default
};
