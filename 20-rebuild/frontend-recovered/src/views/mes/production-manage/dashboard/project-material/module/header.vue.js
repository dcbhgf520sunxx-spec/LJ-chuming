import { ref as i } from "vue";
import { inject as l } from "vue";
import { watch as g } from "vue";
import { unref as o } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as w } from "vue";
import { createElementBlock as I } from "vue";
import { createVNode as s } from "vue";
import { withCtx as h } from "vue";
import { createTextVNode as V } from "vue";
import { toDisplayString as k } from "vue";
import { ElTag as y } from "element-plus";
import { aV as C, pF as j } from "../../../../../../shared/runtime.js";
import { a as E } from "../../../../../../modules/project-material-c2039d20.js";
const N = { __name: "header", setup(b, { expose: m }) {
  const e = i({ workShopId: "", productClassificationEnum: "", projectId: "" }), u = l("projectId"), d = l("tableInfo"), p = l("currentRow"), c = i(0), r = async () => {
    if (e.value.projectId) {
      p.value = {}, d.renderTable({ ...o(e) });
      try {
        const t = await E({ ...o(e) });
        c.value = t;
      } catch (t) {
        console.log(t, "err");
      }
    }
  };
  return g(u, async () => {
    e.value.projectId = o(u), r();
  }, { immediate: true }), m({ query: e }), (t, a) => {
    const f = v("common-radio-button"), _ = y;
    return w(), I("div", null, [s(o(C), { modelValue: e.value.workShopId, "onUpdate:modelValue": a[0] || (a[0] = (n) => e.value.workShopId = n), placeholder: "请先选择车间", size: "default", class: "filter-item", onChange: r, style: { "margin-right": "6px" } }, null, 8, ["modelValue"]), s(f, { modelValue: e.value.productClassificationEnum, "onUpdate:modelValue": a[1] || (a[1] = (n) => e.value.productClassificationEnum = n), options: o(j).ENUM, "show-option-all": true, type: "enumSL", size: "default", class: "filter-item", onChange: r }, null, 8, ["modelValue", "options"]), s(_, { size: "large", class: "filter-item" }, { default: h(() => [V(k(`构件累计生产(kg)：${c.value}`), 1)]), _: 1 })]);
  };
} };
export {
  N as default
};
