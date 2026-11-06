import { a as c } from "../../../../../../../modules/pc-pasychia-data-6ecf5a97.js";
import { ec as i, e3 as l, e5 as m } from "../../../../../../../shared/runtime.js";
import { inject as n } from "vue";
import { ref as p } from "vue";
import { watchEffect as u } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as d } from "vue";
import { createVNode as h } from "vue";
const _ = { class: "header-container" }, v = { __name: "header", setup(j) {
  const { purchaseInfo: a } = n("purchaseInfo"), s = p([]);
  return u(() => {
    var t, o;
    if (a && a.supplierAuditSelfEmployedDto) {
      const e = i([a.supplierAuditSelfEmployedDto]);
      e[0].projectName && (e[0].projectName = e[0].projectName.map((r) => `【 ${r} 】`).join(" ")), (t = e[0]) != null && t.serialNumber && (e[0].serialNumber = (o = e[0]) == null ? void 0 : o.serialNumber.map((r) => `【 ${r} 】`).join(" ")), s.value = l(c, ...e);
    }
  }), (t, o) => (f(), d("div", _, [h(m, { column: 2, "table-list": s.value, "item-width": "18vw", size: "default" }, null, 8, ["table-list"])]));
} };
export {
  v as default
};
