import { ref as m } from "vue";
import { inject as n } from "vue";
import { computed as i } from "vue";
import { watchEffect as p } from "vue";
import { watch as f } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as r } from "vue";
import { withCtx as v } from "vue";
import { unref as h } from "vue";
import { ElInput as I } from "element-plus";
import { e3 as j, jb as N, dp as k, bV as y, e5 as x } from "../../../../../../../shared/runtime.js";
import { s as L } from "../../../../../../../modules/subpackage-settle-bdb7b46f.js";
const g = { class: "head-container" }, M = { __name: "header", setup(w) {
  const l = m(L), o = n("tableItemData"), c = i(() => j(l.value, o)), t = n("approveInfo");
  return p(() => {
    var e;
    const a = (e = t.value) == null ? void 0 : e.subcontractClassId;
    a && (t.value.subcontractClassId = N.VL[a]), Object.assign(o, t.value);
  }), f(() => o.projectAttribute, (a) => {
    if (a && a === 1) {
      const e = l.value.find((s) => s.key === "projectManagerName");
      e && (e.label = "销售负责人", e.key = "salesLeaderName", e.value = t.salesLeaderName);
    } else {
      const e = l.value.find((s) => s.key === "salesLeaderName");
      e && (e.label = "项目经理", e.key = "projectManagerName", e.value = t.projectManagerName);
    }
  }, { immediate: true }), (a, e) => {
    const s = I;
    return _(), b("div", g, [r(k, { "header-title": "基本信息" }), r(x, { "table-list": c.value, column: "2", "label-width": "100px" }, { amount: v(({ val: d, label: u }) => [r(s, { "model-value": h(y)(d), placeholder: u, readonly: "" }, null, 8, ["model-value", "placeholder"])]), _: 1 }, 8, ["table-list"])]);
  };
} };
export {
  M as default
};
