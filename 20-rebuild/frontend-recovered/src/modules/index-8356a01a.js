import { _ as b, i as f } from "../shared/runtime.js";
import { ref as r } from "vue";
import { watch as _ } from "vue";
import { nextTick as y } from "vue";
import { openBlock as o } from "vue";
import { createBlock as c } from "vue";
import { withCtx as k } from "vue";
import { createElementBlock as v } from "vue";
import { Fragment as T } from "vue";
import { renderList as x } from "vue";
import { unref as p } from "vue";
import { ElTabPane as V } from "element-plus";
import { ElTabs as g } from "element-plus";
const w = { __name: "index", props: { modelValue: { type: [Number, String], default: void 0 }, tabPosition: { type: String, default: "top" }, areaInfo: { type: Array, default: () => [] }, default: { type: Boolean, default: false }, defaultTab: { type: Object, default: () => {
} }, showType: { type: Number, default: 1 } }, emits: ["update:modelValue", "tab-click"], setup(i, { emit: m }) {
  const l = r(), u = r(), n = m, t = i;
  _(() => t.defaultTab, (d) => {
    l.value = d.id, s("default");
  }, { deep: true, immediate: true });
  function s(d) {
    y(() => {
      let e = {};
      d === "default" ? e = t.defaultTab : e = t.areaInfo.find((a) => a.id === Number(l.value)), f(e) && u.value !== e.id && (u.value = e.id, n("update:modelValue", e.id), n("tab-click", { name: e.id, label: e.name })), f(e) || (u.value = void 0, n("update:modelValue", void 0), n("tab-click", { name: void 0, label: void 0 }));
    });
  }
  return (d, e) => (o(), c(p(g), { modelValue: l.value, "onUpdate:modelValue": e[0] || (e[0] = (a) => l.value = a), "tab-position": t.tabPosition, onTabClick: s }, { default: k(() => [(o(true), v(T, null, x(t.areaInfo, (a) => (o(), c(p(V), { key: a.id, label: `${i.showType == 1 ? a.name : a.name + "(" + (a.type === 1 ? "外包" : "自制") + ")"}`, name: `${a.id}` }, null, 8, ["label", "name"]))), 128))]), _: 1 }, 8, ["modelValue", "tab-position"]));
} }, I = b(w, [["__scopeId", "data-v-47251fa5"]]);
export {
  I as a
};
