import { a as l } from "../../../../../../../modules/invoice-income-831df2fb.js";
import { e3 as n, bv as p, iW as d, ec as m, dp as u, p as f, e5 as _ } from "../../../../../../../shared/runtime.js";
import { ref as b } from "vue";
import { inject as s } from "vue";
import { computed as v } from "vue";
import { watchEffect as h } from "vue";
import { openBlock as C } from "vue";
import { createElementBlock as D } from "vue";
import { createVNode as o } from "vue";
import { withCtx as x } from "vue";
import { createElementVNode as E } from "vue";
import { toDisplayString as B } from "vue";
import { unref as I } from "vue";
const V = { class: "head-container" }, g = { class: "notSlotValue" }, k = { __name: "header", setup(j) {
  const r = b(l), e = s("tableItemData"), c = v(() => n(r.value, e)), a = s("approveInfo");
  return h(() => {
    if (a.value) {
      typeof a.value.basicClass == "number" && (a.value.basicClass = p.getBits(d.ENUM, a.value.basicClass, "L").join(" | "));
      const t = m([a.value]);
      Object.assign(e, ...t);
    }
  }), (t, w) => (C(), D("div", V, [o(u, { "header-title": "基本信息" }), o(_, { column: 2, "table-list": c.value, "label-width": "100px" }, { createTime: x(({ val: i }) => [E("span", g, B(I(f)(i, "{y}-{m}-{d}")), 1)]), _: 1 }, 8, ["table-list"])]));
} };
export {
  k as default
};
