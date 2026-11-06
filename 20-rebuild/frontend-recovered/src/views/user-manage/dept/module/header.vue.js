import { ref as f } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as g } from "vue";
import { withDirectives as V } from "vue";
import { vShow as b } from "vue";
import { unref as e } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as l } from "vue";
import { withKeys as m } from "vue";
import { createBlock as v } from "vue";
import { withCtx as C } from "vue";
import { createTextVNode as E } from "vue";
import { createCommentVNode as w } from "vue";
import { ElMessage as x } from "element-plus";
import { ElInput as B } from "element-plus";
import { ElButton as k } from "element-plus";
import { _ as z, B as N, cB as Q, x9 as T, C as U, G as K, E as M } from "../../../../shared/runtime.js";
import { b as O } from "../../../../modules/dept-398bb184.js";
const q = { __name: "header", setup(A) {
  const p = { name: void 0, deptType: void 0 }, { crud: t, query: o } = N(p), s = f(false);
  async function c() {
    try {
      s.value = true, await O(), x({ message: "部门同步成功", type: "success" }), t.toQuery();
    } catch (d) {
      console.log("同步失败", d);
    } finally {
      s.value = false;
    }
  }
  return (d, a) => {
    const r = B, u = _("common-radio-button"), y = k;
    return i(), g("div", null, [V(h("div", null, [l(r, { modelValue: e(o).name, "onUpdate:modelValue": a[0] || (a[0] = (n) => e(o).name = n), class: "filter-item", clearable: "", placeholder: "按部门名称搜索", size: "default", style: { width: "200px" }, onKeyup: m(e(t).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(r, { modelValue: e(o).deptCode, "onUpdate:modelValue": a[1] || (a[1] = (n) => e(o).deptCode = n), class: "filter-item", clearable: "", placeholder: "部门编号", size: "default", style: { width: "200px" }, onKeyup: m(e(t).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), l(u, { modelValue: e(o).enabled, "onUpdate:modelValue": a[2] || (a[2] = (n) => e(o).enabled = n), options: e(Q).ENUM, class: "filter-item", showOptionAll: "", size: "default", type: "enum", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(u, { modelValue: e(o).deptType, "onUpdate:modelValue": a[3] || (a[3] = (n) => e(o).deptType = n), options: e(T).ENUM, class: "filter-item", showOptionAll: "", size: "default", type: "enum", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"]), l(e(U)), e(K)(e(t).permission.async) ? (i(), v(y, { key: 0, loading: s.value, class: "filter-item", size: "mini", style: { "margin-left": "0" }, type: "primary", onClick: c }, { default: C(() => a[4] || (a[4] = [E(" 部门同步 ")])), _: 1, __: [4] }, 8, ["loading"])) : w("", true)], 512), [[b, e(t).searchToggle]]), l(e(M))]);
  };
} }, S = z(q, [["__scopeId", "data-v-abaa6f4a"]]);
export {
  S as default
};
