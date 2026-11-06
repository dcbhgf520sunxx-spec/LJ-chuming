import { ref as f } from "vue";
import { watch as y } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as g } from "vue";
import { withDirectives as I } from "vue";
import { vShow as _ } from "vue";
import { unref as o } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as s } from "vue";
import { withCtx as j } from "vue";
import { B as V, nP as b, E as x } from "../../../../../shared/runtime.js";
const k = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 } }, setup(c) {
  const n = c, d = { monomerIds: void 0 }, { crud: t, query: l } = V(d), u = { key: "id", label: "name", value: "id" }, a = f([]);
  y(() => n.projectId, (r) => {
    r ? (t.query.projectId = n.projectId, m(n.projectId), t.toQuery()) : a.value = [];
  }, { immediate: true, deep: true });
  async function m(r) {
    try {
      const { content: e } = await b(r);
      a.value = e;
    } catch (e) {
      console.log("获取单体信息", e);
    }
  }
  return (r, e) => {
    const p = h("common-select");
    return v(), g("div", null, [I(w("div", null, [s(o(x), null, { optLeft: j(() => [s(p, { modelValue: o(l).monomerIds, "onUpdate:modelValue": e[0] || (e[0] = (i) => o(l).monomerIds = i), options: a.value, type: "other", size: "default", dataStructure: u, clearable: "", multiple: "", class: "filter-item", placeholder: "单体,可多选", style: { width: "250px" }, onChange: o(t).toQuery }, null, 8, ["modelValue", "options", "onChange"])]), _: 1 })], 512), [[_, o(t).searchToggle]])]);
  };
} };
export {
  k as default
};
