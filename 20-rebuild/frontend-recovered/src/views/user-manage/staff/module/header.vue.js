import { resolveComponent as m } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as p } from "vue";
import { withDirectives as f } from "vue";
import { vShow as y } from "vue";
import { unref as e } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as n } from "vue";
import { withKeys as v } from "vue";
import { ElInput as V } from "element-plus";
import { _ as b, B as g, C, c1 as N } from "../../../../shared/runtime.js";
const x = { class: "head-container" }, j = { __name: "header", emits: ["clearTableSelection"], setup(k, { emit: l }) {
  const r = { noOrProjectName: void 0, status: void 0 }, { crud: a, query: t } = g(r), c = l;
  function d() {
    c("clearTableSelection");
  }
  return (w, o) => {
    const u = V, i = m("common-select");
    return _(), p("div", x, [f(h("div", null, [n(u, { modelValue: e(t).noOrProjectName, "onUpdate:modelValue": o[0] || (o[0] = (s) => e(t).noOrProjectName = s), modelModifiers: { trim: true }, size: "default", placeholder: "输入项目编号/名称搜索", style: { width: "240px" }, class: "filter-item", clearable: "", onKeyup: v(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(e(C), { onResetClick: d }), n(i, { modelValue: e(t).status, "onUpdate:modelValue": o[1] || (o[1] = (s) => e(t).status = s), options: e(N).ENUM, type: "enum", size: "default", class: "filter-item", clearable: "", placeholder: "选择项目状态", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "onChange"])], 512), [[y, e(a).searchToggle]])]);
  };
} }, S = b(j, [["__scopeId", "data-v-d632aabc"]]);
export {
  S as default
};
