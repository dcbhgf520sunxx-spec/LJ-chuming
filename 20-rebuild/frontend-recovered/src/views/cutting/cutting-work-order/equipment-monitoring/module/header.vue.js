import { ref as u } from "vue";
import { computed as k } from "vue";
import { watch as B } from "vue";
import { onMounted as b } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as L } from "vue";
import { createElementBlock as x } from "vue";
import { createVNode as r } from "vue";
import { withCtx as p } from "vue";
import { withDirectives as C } from "vue";
import { createElementVNode as S } from "vue";
import { unref as o } from "vue";
import { createTextVNode as E } from "vue";
import { vShow as T } from "vue";
import { ElCascader as A } from "element-plus";
import { er as N, B as P, E as I } from "../../../../../shared/runtime.js";
const q = { class: "head-container" }, Q = { __name: "header", props: { modelValue: { type: [Array, Number] }, checkStrictly: { type: Boolean, default: false }, expandTrigger: { type: String, default: "hover" }, emitPath: { type: Boolean, default: false }, filterable: { type: Boolean, default: false }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, showAllLevels: { type: Boolean, default: false }, placeholder: { type: String, default: "请选择工厂、车间和生产线" } }, emits: ["update:modelValue", "change"], setup(f, { emit: m }) {
  const n = m, a = f, s = u(), c = u([]), h = k(() => ({ value: "id", label: "name", children: "children", checkStrictly: a.checkStrictly, expandTrigger: a.expandTrigger, emitPath: a.emitPath, multiple: a.multiple }));
  B(() => a.modelValue, (e) => {
    e instanceof Array ? s.value = [...e] : s.value = e, V(e);
  }, { immediate: true });
  const y = { factoryId: void 0, workshopInfId: void 0, copyValue: void 0 };
  b(() => g());
  async function g() {
    try {
      const { content: e } = await N({});
      e.forEach((t) => {
        t.children = t.workshopList, t.workshopList.forEach((l) => {
          l.children = l.productionLineList;
        });
      }), console.log(e), c.value = e;
    } catch {
      console.log("请求工厂-车间-生产线的层级接口失败");
    }
  }
  function V(e) {
    n("update:modelValue", e), n("change", e);
  }
  const { crud: i, query: d } = P(y);
  return (e, t) => {
    const l = A, _ = v("common-button");
    return L(), x("div", q, [r(o(I), null, { optLeft: p(() => [C(S("div", null, [r(l, { options: c.value, "check-strictly": "", modelValue: o(d).copyValue, "onUpdate:modelValue": t[0] || (t[0] = (w) => o(d).copyValue = w), props: h.value, separator: " > ", "show-all-levels": "", clearable: "", size: "default", class: "filter-item", style: { width: "300px" }, placeholder: "可选择工厂、车间、生产线", onChange: o(i).toQuery }, null, 8, ["options", "modelValue", "props", "onChange"]), r(_, { class: "filter-item", size: "default", type: "primary" }, { default: p(() => t[1] || (t[1] = [E("确定")])), _: 1, __: [1] })], 512), [[T, o(i).searchToggle]])]), _: 1 })]);
  };
} };
export {
  Q as default
};
