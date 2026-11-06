import { a as m, s as f } from "../../../../../../../modules/invoice-income-831df2fb.js";
import { e3 as _, bv as v, iW as b, ec as h, dp as y, p as N, e5 as g } from "../../../../../../../shared/runtime.js";
import { inject as c } from "vue";
import { cloneDeep as i } from "lodash";
import { computed as l } from "vue";
import { watchEffect as j } from "vue";
import { watch as k } from "vue";
import { openBlock as M } from "vue";
import { createElementBlock as C } from "vue";
import { createVNode as n } from "vue";
import { withCtx as x } from "vue";
import { createElementVNode as E } from "vue";
import { toDisplayString as L } from "vue";
import { unref as T } from "vue";
const w = { class: "head-container" }, B = { class: "notSlotValue" }, S = { __name: "header", setup(D) {
  const a = c("tableItemData"), d = i(m), u = i(f), o = l(() => (a == null ? void 0 : a.auditType) === 3 ? u : d), p = l(() => _(o.value, a)), s = c("approveInfo");
  return j(() => {
    if (s.value) {
      typeof s.value.basicClass == "number" && (s.value.basicClass = v.getBits(b.ENUM, s.value.basicClass, "L").join(" | "));
      const t = h([s.value]);
      Object.assign(a, ...t);
    }
  }), k(() => a.projectAttribute, (t) => {
    if ((a == null ? void 0 : a.auditType) !== 3) if (t && t === 1) {
      const e = o.value.find((r) => r.key === "projectManagerName");
      e && (e.label = "销售负责人", e.key = "salesLeaderName", e.value = s.salesLeaderName);
    } else {
      const e = o.value.find((r) => r.key === "salesLeaderName");
      e && (e.label = "项目经理", e.key = "projectManagerName", e.value = s.projectManagerName);
    }
  }, { immediate: true }), (t, e) => (M(), C("div", w, [n(y, { "header-title": "基本信息" }), n(g, { column: 2, "table-list": p.value, "label-width": "100px" }, { createTime: x(({ val: r }) => [E("span", B, L(T(N)(r, "{y}-{m}-{d}")), 1)]), _: 1 }, 8, ["table-list"])]));
} };
export {
  S as default
};
