import { ref as V } from "vue";
import { computed as c } from "vue";
import { onMounted as b } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as i } from "vue";
import { createVNode as l } from "vue";
import { unref as o } from "vue";
import { createElementVNode as n } from "vue";
import { withCtx as x } from "vue";
import { createTextVNode as C } from "vue";
import { createCommentVNode as N } from "vue";
import { ElCascader as j } from "element-plus";
import { ElDatePicker as I } from "element-plus";
import { ElTag as Y } from "element-plus";
import { _ as E, p as L, fg as T, B, er as P } from "../../../../../shared/runtime.js";
const Q = { class: "head-container" }, U = { key: 0 }, z = { class: "head-container flex" }, D = { __name: "header", setup(F) {
  const p = { year: L(/* @__PURE__ */ new Date(), "{y}"), workshopId: void 0, projectId: void 0 }, d = V([]), { projectTree: m } = T(), { crud: r, query: a } = B(p), _ = c(() => m.value.map((e) => (e.serialNumberName = e.serialNumber + " " + e.name, e))), f = c(() => ({ value: "id", label: "name", children: "children", emitPath: false }));
  b(() => h());
  async function h() {
    try {
      const { content: t } = await P({});
      t.forEach((e) => {
        e.children = e.workshopList;
      }), console.log(t), d.value = t;
    } catch {
      console.log("请求工厂-车间-生产线的层级接口失败");
    }
  }
  return (t, e) => {
    const y = w("common-select"), v = j, g = I, k = Y;
    return u(), i("div", Q, [l(y, { modelValue: o(a).projectId, "onUpdate:modelValue": e[0] || (e[0] = (s) => o(a).projectId = s), options: _.value, type: "other", "data-structure": { key: "id", label: "serialNumberName", value: "id" }, class: "filter-item", clearable: "", filterable: "", style: { width: "350px" }, placeholder: "选择项目", onChange: o(r).toQuery }, null, 8, ["modelValue", "options", "onChange"]), o(a).projectId ? (u(), i("div", U, [l(v, { options: d.value, modelValue: o(a).workshopId, "onUpdate:modelValue": e[1] || (e[1] = (s) => o(a).workshopId = s), props: f.value, separator: " > ", "show-all-levels": "", clearable: "", size: "default", class: "filter-item", style: { width: "350px" }, placeholder: "全部车间", onChange: o(r).toQuery }, null, 8, ["options", "modelValue", "props", "onChange"]), n("div", z, [n("div", null, [l(g, { style: { width: "140px" }, modelValue: o(a).year, "onUpdate:modelValue": e[2] || (e[2] = (s) => o(a).year = s), type: "year", size: "default", class: "filter-item", format: "YYYY", "value-format": "YYYY", clearable: false, placeholder: "请选择日期", onChange: o(r).toQuery }, null, 8, ["modelValue", "onChange"])]), n("div", null, [l(k, { type: "success", size: "large" }, { default: x(() => e[3] || (e[3] = [C(" 统计模式：入库反推模式 ")])), _: 1, __: [3] })])])])) : N("", true)]);
  };
} }, q = E(D, [["__scopeId", "data-v-157ef441"]]);
export {
  q as default
};
