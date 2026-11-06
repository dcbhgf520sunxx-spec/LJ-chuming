import { ref as v } from "vue";
import { resolveComponent as V } from "vue";
import { resolveDirective as h } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as E } from "vue";
import { withDirectives as m } from "vue";
import { vShow as w } from "vue";
import { unref as e } from "vue";
import { createElementVNode as B } from "vue";
import { createVNode as t } from "vue";
import { createBlock as p } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as c } from "vue";
import { createCommentVNode as C } from "vue";
import { ElMessage as x } from "element-plus";
import { ElInput as k } from "element-plus";
import { ElButton as N } from "element-plus";
import { d as T, a as U } from "../../../../modules/job-fc547e81.js";
import { _ as j, B as z, cB as Q, x9 as D, C as L, G as M, L as O, E as q } from "../../../../shared/runtime.js";
const A = { __name: "header", setup(H) {
  const _ = { name: void 0, enabled: 1, jobType: void 0 }, { crud: o, query: n } = z(_), l = v(false);
  async function f() {
    try {
      l.value = true, await U(), x({ message: "岗位同步成功", type: "success" }), o.toQuery();
    } catch (d) {
      console.log("岗位同步失败", d);
    } finally {
      l.value = false;
    }
  }
  return (d, a) => {
    const y = k, u = V("common-radio-button"), b = N, g = h("permission");
    return r(), E("div", null, [m(B("div", null, [t(y, { modelValue: e(n).name, "onUpdate:modelValue": a[0] || (a[0] = (s) => e(n).name = s), class: "filter-item", clearable: "", placeholder: "按岗位名称搜索", size: "default", style: { width: "200px" }, onBlur: e(o).toQuery }, null, 8, ["modelValue", "onBlur"]), t(u, { modelValue: e(n).enabled, "onUpdate:modelValue": a[1] || (a[1] = (s) => e(n).enabled = s), options: e(Q).ENUM, class: "filter-item", showOptionAll: "", size: "default", type: "enum", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(u, { modelValue: e(n).jobType, "onUpdate:modelValue": a[2] || (a[2] = (s) => e(n).jobType = s), options: e(D).ENUM, class: "filter-item", showOptionAll: "", size: "default", type: "enum", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), t(e(L)), e(M)(e(o).permission.async) ? (r(), p(b, { key: 0, loading: l.value, class: "filter-item", size: "default", style: { "margin-left": "0" }, type: "primary", onClick: f }, { default: i(() => a[3] || (a[3] = [c(" 岗位同步 ")])), _: 1, __: [3] }, 8, ["loading"])) : C("", true)], 512), [[w, e(o).searchToggle]]), t(e(q), null, { viewLeft: i(() => [m((r(), p(O, { disabled: e(o).data.length === 0, fn: e(T), params: { enabled: e(n).enabled }, class: "filter-item" }, { default: i(() => a[4] || (a[4] = [c(" 人员设置清单 ")])), _: 1, __: [4] }, 8, ["disabled", "fn", "params"])), [[g, e(o).permission.get]])]), _: 1 })]);
  };
} }, F = j(A, [["__scopeId", "data-v-a94f5092"]]);
export {
  F as default
};
