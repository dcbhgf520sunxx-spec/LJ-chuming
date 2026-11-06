import { ref as m } from "vue";
import c from "moment";
import { resolveComponent as f } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as y } from "vue";
import { withCtx as V } from "vue";
import { withDirectives as v } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { withKeys as g } from "vue";
import { vShow as C } from "vue";
import { ElDatePicker as E } from "element-plus";
import { ElInput as b } from "element-plus";
import { B as j, a3 as k, C as w, E as B } from "../../../../../shared/runtime.js";
const O = { __name: "header", setup(Q) {
  const s = { name: "", projectId: void 0 }, l = m(), { crud: n, query: o, CRUD: u } = j(s);
  return u.HOOK.beforeToQuery = () => {
    l.value ? o.date = c(l.value).valueOf() : o.date = void 0, o.productType = k.ASSEMBLE.V;
  }, (x, a) => {
    const d = f("project-radio-button"), p = E, i = b;
    return _(), y(e(B), null, { optLeft: V(() => [v(h("div", null, [r(d, { size: "default", modelValue: e(o).projectId, "onUpdate:modelValue": a[0] || (a[0] = (t) => e(o).projectId = t), class: "filter-item", onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), r(p, { modelValue: l.value, "onUpdate:modelValue": a[1] || (a[1] = (t) => l.value = t), type: "date", size: "default", class: "filter-item", placeholder: "请选择变更日期", onChange: e(n).toQuery }, null, 8, ["modelValue", "onChange"]), r(i, { modelValue: e(o).name, "onUpdate:modelValue": a[2] || (a[2] = (t) => e(o).name = t), modelModifiers: { trim: true }, placeholder: "输入部件编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: g(e(n).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(e(w))], 512), [[C, e(n).searchToggle]])]), _: 1 });
  };
} };
export {
  O as default
};
