import { ref as f } from "vue";
import { computed as y } from "vue";
import { onMounted as v } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as w } from "vue";
import { openBlock as k } from "vue";
import { createElementBlock as b } from "vue";
import { createElementVNode as V } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { withDirectives as Y } from "vue";
import { ElDatePicker as x } from "element-plus";
import { ElCascader as C } from "element-plus";
import { _ as D, p as I, B, er as E } from "../../../../../shared/runtime.js";
const L = { class: "header" }, z = { class: "header-right" }, P = { __name: "header", setup(Q) {
  const n = f([]), i = { year: I(/* @__PURE__ */ new Date(), "{y}"), factoryId: void 0, workshopId: void 0 }, { crud: t, query: s } = B(i);
  function d(a) {
    return a > /* @__PURE__ */ new Date();
  }
  const c = y(() => ({ value: "id", label: "name", children: "children", emitPath: false }));
  v(() => p());
  async function p() {
    try {
      const { content: a } = await E({});
      a.forEach((o) => {
        o.children = o.workshopList;
      }), console.log(a), n.value = a;
    } catch {
      console.log("请求工厂-车间-生产线的层级接口失败");
    }
  }
  return (a, o) => {
    const u = x, m = C, _ = g("print-table"), h = w("permission");
    return k(), b("div", L, [V("div", z, [l(u, { style: { "margin-right": "5px", width: "120px" }, modelValue: e(s).year, "onUpdate:modelValue": o[0] || (o[0] = (r) => e(s).year = r), clearable: false, type: "year", size: "default", class: "filter-item", format: "YYYY", "value-format": "YYYY", placeholder: "请选择年", "disabled-date": d, onChange: e(t).toQuery }, null, 8, ["modelValue", "onChange"]), l(m, { options: n.value, modelValue: e(s).workshopId, "onUpdate:modelValue": o[1] || (o[1] = (r) => e(s).workshopId = r), props: c.value, separator: " > ", "show-all-levels": "", clearable: "", size: "default", class: "filter-item", style: { width: "350px" }, placeholder: "全部车间", onChange: e(t).toQuery }, null, 8, ["options", "modelValue", "props", "onChange"])]), Y(l(_, { "api-key": "shareReport", params: { ...e(s) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[h, e(t).permission.print]])]);
  };
} }, F = D(P, [["__scopeId", "data-v-e10de86a"]]);
export {
  F as default
};
