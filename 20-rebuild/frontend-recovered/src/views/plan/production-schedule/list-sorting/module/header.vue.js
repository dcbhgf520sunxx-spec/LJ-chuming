import { ref as m } from "vue";
import { openBlock as I } from "vue";
import { createElementBlock as g } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { normalizeStyle as V } from "vue";
import { ElInput as h } from "element-plus";
import { _ as y, B as b, q as N, C as x } from "../../../../../shared/runtime.js";
import { a as C } from "../../../../../modules/index-8356a01a.js";
const w = { __name: "header", props: { projectId: { type: Number, default: null } }, emits: ["add", "collect"], setup(i, { emit: j }) {
  const t = m([]), d = m({}), c = m(), f = { areaId: void 0, artifactClassId: void 0, artifactNoOrName: void 0, monomerId: void 0 }, { crud: p, query: l } = b(f);
  function _(o) {
    const { name: a, label: u } = o;
    c.value = { id: a, name: u }, p.toQuery();
  }
  function v(o) {
    t.value = o || [], t.value.length > 0 ? d.value = { id: t.value[0].id + "", name: t.value[0].name } : d.value = {};
  }
  return (o, a) => {
    const u = h;
    return I(), g("div", null, [s("div", null, [r(e(N), { ref: "monomerSelectRef", modelValue: e(l).monomerId, "onUpdate:modelValue": a[0] || (a[0] = (n) => e(l).monomerId = n), "project-id": i.projectId, "show-tips": t.value.length <= 0, class: "filter-item", onChange: o.monomerChange, onGetAreaInfo: v }, null, 8, ["modelValue", "project-id", "show-tips", "onChange"]), r(e(C), { modelValue: e(l).areaId, "onUpdate:modelValue": a[1] || (a[1] = (n) => e(l).areaId = n), "area-info": t.value, "default-tab": d.value, style: V(t.value.length > 0 ? "width:calc(100% - 230px)" : "width:calc(100% - 380px)"), class: "filter-item", onTabClick: _ }, null, 8, ["modelValue", "area-info", "default-tab", "style"])]), s("div", null, [r(u, { modelValue: e(l).artifactNoOrName, "onUpdate:modelValue": a[2] || (a[2] = (n) => e(l).artifactNoOrName = n), modelModifiers: { trim: true }, placeholder: "编号搜索", style: { width: "270px", "margin-right": "10px" } }, null, 8, ["modelValue"]), r(e(x))])]);
  };
} }, O = y(w, [["__scopeId", "data-v-8161c19c"]]);
export {
  O as default
};
