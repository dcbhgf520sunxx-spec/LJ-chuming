import { h as m, s as f } from "../../../../../../../modules/invoice-income-831df2fb.js";
import { e3 as v, bv as _, iW as b, ec as h, dp as N, e5 as j } from "../../../../../../../shared/runtime.js";
import { inject as c } from "vue";
import { cloneDeep as l } from "lodash";
import { computed as n } from "vue";
import { watchEffect as k } from "vue";
import { watch as y } from "vue";
import { openBlock as M } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as i } from "vue";
const E = { class: "head-container" }, B = { __name: "header-v2", setup(L) {
  const a = c("tableItemData"), u = l(m), d = l(f), r = n(() => (a == null ? void 0 : a.auditType) === 3 ? d : u), p = n(() => v(r.value, a)), s = c("approveInfo");
  return k(() => {
    if (s.value) {
      typeof s.value.basicClass == "number" && (s.value.basicClass = _.getBits(b.ENUM, s.value.basicClass, "L").join(" | "));
      const t = h([s.value]);
      Object.assign(a, ...t);
    }
  }), y(() => a.projectAttribute, (t) => {
    if ((a == null ? void 0 : a.auditType) !== 3) if (t && t === 1) {
      const e = r.value.find((o) => o.key === "projectManagerName");
      e && (e.label = "销售负责人", e.key = "salesLeaderName", e.value = s.salesLeaderName);
    } else {
      const e = r.value.find((o) => o.key === "salesLeaderName");
      e && (e.label = "项目经理", e.key = "projectManagerName", e.value = s.projectManagerName);
    }
  }, { immediate: true }), (t, e) => (M(), g("div", E, [i(N, { "header-title": "基本信息" }), i(j, { column: 2, "table-list": p.value, "label-width": "100px" }, null, 8, ["table-list"])]));
} };
export {
  B as default
};
