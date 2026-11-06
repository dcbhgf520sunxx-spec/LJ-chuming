import { inject as f } from "vue";
import { ref as a } from "vue";
import { onMounted as _ } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as o } from "vue";
import { withCtx as i } from "vue";
import { mergeProps as x } from "vue";
import { createTextVNode as N } from "vue";
import { Fragment as k } from "vue";
import { ElBadge as C } from "element-plus";
import L from "./module/list.vue.js";
import { G as y, xN as B } from "../../../../../../../shared/runtime.js";
const E = { __name: "index", setup(h, { expose: r }) {
  const u = f("permission"), e = a(0), t = a(false);
  function l() {
    t.value = true;
  }
  _(() => {
    n();
  });
  async function n() {
    return y(u.add) && (e.value = await B()), e.value;
  }
  return r({ updateListNumber: n }), (m, s) => {
    const c = b("common-button"), p = C;
    return v(), g(k, null, [o(p, { hidden: e.value <= 0, value: e.value, style: { "margin-right": "6px" } }, { default: i(() => [o(c, x({ icon: "el-icon-tickets", size: "default", type: "success" }, m.$attrs, { onClick: l }), { default: i(() => s[1] || (s[1] = [N(" 盘盈清单 ")])), _: 1, __: [1] }, 16)]), _: 1 }, 8, ["hidden", "value"]), o(L, { visible: t.value, "onUpdate:visible": s[0] || (s[0] = (d) => t.value = d), onRefresh: n }, null, 8, ["visible"])], 64);
  };
} };
export {
  E as default
};
