import { B as f, cJ as _, ya as y, C, E as b } from "../../../../../../../shared/runtime.js";
import { watch as h } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as c } from "vue";
import { unref as e } from "vue";
import { createVNode as t } from "vue";
import { withCtx as V } from "vue";
import { createCommentVNode as q } from "vue";
const w = { class: "head-container" }, B = { key: 0 }, k = { __name: "header", props: { freezeData: { type: Object } }, setup(i) {
  const l = i, u = { basicClass: { value: void 0, resetAble: false } }, { crud: a, query: s } = f(u);
  async function d() {
    a.toQuery();
  }
  return h(() => l.freezeData, (o) => {
    o && (a.data = [], a.loading = true, s.idList = o.idList, a.toQuery());
  }, { deep: true, immediate: true }), (o, r) => {
    const m = g("common-radio-button");
    return n(), c("div", w, [e(a).searchToggle ? (n(), c("div", B, [t(y, { "basic-class": e(s).basicClass, query: e(s), "to-query": e(a).toQuery, multiple: "" }, { afterProjectWarehouseType: V(() => [t(m, { modelValue: e(s).basicClass, "onUpdate:modelValue": r[0] || (r[0] = (p) => e(s).basicClass = p), options: e(_).ENUM, class: "filter-item", "show-option-all": "", size: "default", type: "enum", onChange: d }, null, 8, ["modelValue", "options"])]), _: 1 }, 8, ["basic-class", "query", "to-query"]), t(e(C))])) : q("", true), t(e(b))]);
  };
} };
export {
  k as default
};
