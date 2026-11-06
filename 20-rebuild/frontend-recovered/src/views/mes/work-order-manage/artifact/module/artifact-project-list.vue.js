import { inject as V } from "vue";
import { ref as r } from "vue";
import f from "moment";
import { watch as k } from "vue";
import { openBlock as x } from "vue";
import { createElementBlock as y } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as n } from "vue";
import { unref as p } from "vue";
import { mergeProps as w } from "vue";
import { normalizeStyle as _ } from "vue";
import { Fragment as I } from "vue";
import { ElDatePicker as P } from "element-plus";
import { ElInput as j } from "element-plus";
import { h as b } from "../../../../../modules/artifact-da890fbc.js";
import { G as Y, se as M, aV as T } from "../../../../../shared/runtime.js";
import z from "../component/project-to-area-tree.vue.js";
const B = { class: "head-container" }, S = { __name: "artifact-project-list", props: { maxHeight: { type: [Number, String], default: void 0 } }, setup(v) {
  const m = V("crud"), u = r(false), t = r(), c = r([]), e = r(f().valueOf()), s = r("");
  k([() => e.value, () => t.value], () => {
    m.data = [], m.query.projectIds = [];
  }, { immediate: true }), i();
  async function i() {
    if (Y(M.get)) try {
      s.value = "", u.value = true;
      const l = await b({ localDateTime: e.value ? e.value : f().valueOf(), workshopId: t.value });
      c.value = l;
    } catch (l) {
      console.log("获取构件项目列表树木失败", l);
    } finally {
      u.value = false;
    }
  }
  return (l, a) => {
    const h = P, g = j;
    return x(), y(I, null, [d("div", B, [n(h, { modelValue: e.value, "onUpdate:modelValue": a[0] || (a[0] = (o) => e.value = o), type: "month", size: "default", "value-format": "x", format: "YYYY-MM", clearable: false, placeholder: "选择月份", style: { width: "120px" }, class: "filter-item", onChange: i }, null, 8, ["modelValue"]), n(p(T), { modelValue: t.value, "onUpdate:modelValue": a[1] || (a[1] = (o) => t.value = o), placeholder: "请选择车间", style: { width: "200px" }, class: "filter-item", clearable: "", onChange: i }, null, 8, ["modelValue"]), d("div", null, [n(g, { modelValue: s.value, "onUpdate:modelValue": a[2] || (a[2] = (o) => s.value = o), modelModifiers: { trim: true }, size: "default", placeholder: "输入项目搜索", style: { width: "200px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"])])]), d("div", { style: _({ height: `${v.maxHeight}px` }) }, [n(p(z), w({ "tree-data": c.value, "filter-text": s.value, month: e.value, workshopId: t.value, loading: u.value }, l.$attrs), null, 16, ["tree-data", "filter-text", "month", "workshopId", "loading"])], 4)], 64);
  };
} };
export {
  S as default
};
