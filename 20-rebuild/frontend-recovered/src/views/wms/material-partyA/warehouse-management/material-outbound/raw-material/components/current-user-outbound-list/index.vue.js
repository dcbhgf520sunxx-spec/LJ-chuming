import { inject as h } from "vue";
import { ref as r } from "vue";
import { onMounted as g } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as N } from "vue";
import { createElementBlock as k } from "vue";
import { createVNode as a } from "vue";
import { withCtx as u } from "vue";
import { mergeProps as x } from "vue";
import { createTextVNode as C } from "vue";
import { Fragment as L } from "vue";
import { ElBadge as V } from "element-plus";
import { zJ as w, G as B, zK as z } from "../../../../../../../../shared/runtime.js";
import P from "./module/list.vue.js";
const R = { __name: "index", emits: ["refresh"], setup(j, { expose: l, emit: c }) {
  w();
  const i = c, m = h("permission"), t = r(0), o = r(false);
  g(async () => {
    n();
  });
  async function n() {
    const s = { boolPartyA: true };
    return B(m.outbound) && (t.value = await z(s)), t.value;
  }
  async function d() {
    const s = t.value, e = await n();
    s !== e && i("refresh");
  }
  function f() {
    o.value = true, d();
  }
  function p() {
    n(), i("refresh");
  }
  return l({ updateListNumber: n }), (s, e) => {
    const b = y("common-button"), v = V;
    return N(), k(L, null, [a(v, { hidden: t.value <= 0, value: t.value, style: { "margin-right": "6px" } }, { default: u(() => [a(b, x({ icon: "el-icon-tickets", size: "default", type: "success" }, s.$attrs, { onClick: f }), { default: u(() => e[1] || (e[1] = [C(" 出库清单 ")])), _: 1, __: [1] }, 16)]), _: 1 }, 8, ["hidden", "value"]), a(P, { visible: o.value, "onUpdate:visible": e[0] || (e[0] = (_) => o.value = _), onRefresh: p }, null, 8, ["visible"])], 64);
  };
} };
export {
  R as default
};
