import { ref as c } from "vue";
import { computed as u } from "vue";
import { resolveComponent as p } from "vue";
import { resolveDirective as f } from "vue";
import { openBlock as m } from "vue";
import { createBlock as w } from "vue";
import { withCtx as _ } from "vue";
import { withDirectives as y } from "vue";
import { createVNode as g } from "vue";
import { withModifiers as v } from "vue";
import { ElTooltip as b } from "element-plus";
import { kc as h, Y as x, i as k } from "../shared/runtime.js";
const D = { __name: "E.operation", props: { data: { type: null, default: void 0 }, permission: { type: Array, required: true }, disabled: { type: Boolean, default: false }, customFn: { type: Function, default: void 0 }, showText: { type: Boolean, default: false }, showTooltip: { type: Boolean, default: false } }, setup(s) {
  const e = s, t = c(false), { crud: a } = h(), n = u(() => {
    const o = e.data;
    return o && (o.sourceRow ? o.sourceRow : o);
  });
  async function i() {
    try {
      t.value = true, e.customFn ? await x(e.customFn, n.value) : (a.downloadLoading = true, await a.doExport(n.value));
    } catch (o) {
      console.log("通用导出", o);
    } finally {
      t.value = false, k(e.customFn) && (a.downloadLoading = false);
    }
  }
  return (o, B) => {
    const l = p("common-button"), r = b, d = f("permission");
    return m(), w(r, { class: "item", effect: "dark", content: e.tip, disabled: !e.showTooltip, placement: "top-start" }, { default: _(() => [y(g(l, { loading: t.value, disabled: e.disabled, type: "warning", icon: "el-icon-download", size: "default", onClick: v(i, ["stop"]) }, null, 8, ["loading", "disabled"]), [[d, e.permission]])]), _: 1 }, 8, ["content", "disabled"]);
  };
} };
export {
  D as _
};
