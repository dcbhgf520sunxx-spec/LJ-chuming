import { inject as c } from "vue";
import { watch as f } from "vue";
import { nextTick as m } from "vue";
import o from "moment";
import { openBlock as p } from "vue";
import { createElementBlock as h } from "vue";
import { withDirectives as _ } from "vue";
import { vShow as v } from "vue";
import { unref as a } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as n } from "vue";
import { withCtx as y } from "vue";
import { ElInput as V } from "element-plus";
import { B as D, C as x, E as b } from "../../../../../../shared/runtime.js";
const g = { class: "head-container" }, I = { __name: "header", setup(j) {
  const d = c("searchQuery"), u = { startDate: void 0, endDate: void 0, name: void 0, specification: void 0, projectId: { value: void 0, resetAble: false } }, { crud: s, query: e } = D(u);
  return f(d, (i) => {
    m(() => {
      s.query.projectId = i.projectId, d.date && d.date.length > 1 ? (e.startDate = o(d.date[0]).valueOf(), e.endDate = o(d.date[1]).valueOf()) : (e.startDate = void 0, e.endDate = void 0), s.toQuery();
    });
  }, { immediate: true }), (i, t) => {
    const r = V;
    return p(), h("div", g, [_(w("div", null, [n(r, { modelValue: a(e).name, "onUpdate:modelValue": t[0] || (t[0] = (l) => a(e).name = l), modelModifiers: { trim: true }, size: "default", placeholder: "输入材质", style: { width: "200px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), n(r, { modelValue: a(e).specification, "onUpdate:modelValue": t[1] || (t[1] = (l) => a(e).specification = l), modelModifiers: { trim: true }, size: "default", placeholder: "输入规格", style: { width: "200px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), n(a(x))], 512), [[v, a(s).searchToggle]]), n(a(b), null, { viewLeft: y(() => t[2] || (t[2] = [])), _: 1 })]);
  };
} };
export {
  I as default
};
