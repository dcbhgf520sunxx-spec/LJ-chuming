import { h as m } from "../../../../../../../modules/sp-pasychia-data-d374d1e9.js";
import { i as p, bV as u, p as d, e3 as f, dp as _, e5 as h } from "../../../../../../../shared/runtime.js";
import { inject as b } from "vue";
import { cloneDeep as s } from "lodash";
import { watchEffect as D } from "vue";
import { computed as N } from "vue";
import { openBlock as j } from "vue";
import { createElementBlock as k } from "vue";
import { createVNode as o } from "vue";
const v = { class: "header-container" }, T = { __name: "header", setup(x) {
  const { purchaseInfo: { supplierAuditSelfEmployedDto: r } } = b("purchaseInfo"), e = s(r), c = s(m);
  D(() => {
    if (p(e)) {
      const { amount: a, createDate: t, projectName: i, serialNumber: l } = e;
      e.amount = u(a), e.createDate = d(t, "{y}-{m}-{d}"), e.projectName = i[0], e.serialNumber = l[0];
    }
  });
  const n = N(() => f(c, e));
  return (a, t) => (j(), k("div", v, [o(_, { "header-title": "基本信息" }), o(h, { column: 2, "table-list": n.value, size: "default" }, null, 8, ["table-list"])]));
} };
export {
  T as default
};
