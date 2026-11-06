import { inject as d } from "vue";
import { resolveComponent as f } from "vue";
import { resolveDirective as v } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as g } from "vue";
import { unref as e } from "vue";
import { withDirectives as _ } from "vue";
import { vShow as y } from "vue";
import { createBlock as o } from "vue";
import { withCtx as n } from "vue";
import { createTextVNode as r } from "vue";
import { toDisplayString as k } from "vue";
import { withModifiers as h } from "vue";
import { ElTag as x } from "element-plus";
import { _ as C, B as w } from "../../../../../shared/runtime.js";
const B = { class: "head-container" }, N = { __name: "header", setup(b) {
  const l = { id: void 0 }, a = d("currentNode"), m = d("permission"), { crud: i } = w(l);
  return (z, t) => {
    const c = x, p = f("common-button"), u = v("permission");
    return s(), g("div", B, [e(i).data.length ? _((s(), o(c, { key: 0, class: "filter-item", effect: "plain", size: "large" }, { default: n(() => [r(k(`${e(a).serialNumber} ${e(a).name}`), 1)]), _: 1 }, 512)), [[y, e(a).name]]) : (s(), o(c, { key: 1, class: "filter-item", type: "info", size: "large" }, { default: n(() => t[0] || (t[0] = [r("当前科目尚未配置规格")])), _: 1, __: [0] })), _((s(), o(p, { class: "filter-item", size: "default", type: "primary", onClick: h(e(i).toAdd, ["stop"]) }, { default: n(() => t[1] || (t[1] = [r(" 新增规格 ")])), _: 1, __: [1] }, 8, ["onClick"])), [[u, e(m).add]])]);
  };
} }, E = C(N, [["__scopeId", "data-v-95dc3da6"]]);
export {
  E as default
};
