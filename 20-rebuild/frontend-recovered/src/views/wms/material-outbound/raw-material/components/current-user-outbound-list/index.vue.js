import { inject as g } from "vue";
import { ref as r } from "vue";
import { onMounted as h } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as k } from "vue";
import { createElementBlock as x } from "vue";
import { createVNode as a } from "vue";
import { withCtx as u } from "vue";
import { mergeProps as y } from "vue";
import { createTextVNode as C } from "vue";
import { Fragment as L } from "vue";
import { ElBadge as V } from "element-plus";
import { g as w } from "../../../../../../modules/review-a53b87d8.js";
import { G as B } from "../../../../../../shared/runtime.js";
import j from "./module/list.vue.js";
const z = { __name: "index", emits: ["refresh"], setup(E, { expose: l, emit: m }) {
  const i = m, c = g("permission"), t = r(0), s = r(false);
  h(async () => {
    n();
  });
  async function n() {
    return B(c.outbound) && (t.value = await w()), t.value;
  }
  async function d() {
    const o = t.value, e = await n();
    o !== e && i("refresh");
  }
  function f() {
    s.value = true, d();
  }
  function p() {
    n(), i("refresh");
  }
  return l({ updateListNumber: n }), (o, e) => {
    const b = N("common-button"), v = V;
    return k(), x(L, null, [a(v, { value: t.value, hidden: t.value <= 0, style: { "margin-right": "6px" } }, { default: u(() => [a(b, y(o.$attrs, { icon: "el-icon-tickets", size: "default", type: "success", onClick: f }), { default: u(() => e[1] || (e[1] = [C("出库清单")])), _: 1, __: [1] }, 16)]), _: 1 }, 8, ["value", "hidden"]), a(j, { visible: s.value, "onUpdate:visible": e[0] || (e[0] = (_) => s.value = _), onRefresh: p }, null, 8, ["visible"])], 64);
  };
} };
export {
  z as default
};
