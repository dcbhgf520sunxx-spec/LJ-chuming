import { inject as h } from "vue";
import { ref as l } from "vue";
import m from "moment";
import { watch as g } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as _ } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as u } from "vue";
import { mergeProps as x } from "vue";
import { unref as P } from "vue";
import { normalizeStyle as V } from "vue";
import { Fragment as k } from "vue";
import { ElDatePicker as j } from "element-plus";
import { ElInput as T } from "element-plus";
import { l as w, G as D, sg as E, cn as O } from "../../../../../shared/runtime.js";
import b from "../../components/project-to-area-tree.vue.js";
function I(r) {
  return w({ module: "mes", url: "task/order/machinePart/project/list", method: "get", params: r });
}
const z = { class: "head-container" }, R = { __name: "drill-project-list", props: { maxHeight: { type: [Number, String], default: void 0 } }, setup(r) {
  const c = h("crud"), e = l(m().valueOf()), o = l(""), s = l([]), n = l(false);
  g([() => e.value], () => {
    c.data = [], c.query.projectId = void 0;
  }), d();
  async function d() {
    if (D(E.get)) try {
      n.value = true, s.value = [];
      const a = await I({ localDateTime: e.value ? e.value : m().valueOf(), processType: O.DRILL_ORDER.V });
      s.value = a || [];
    } catch (a) {
      console.log("获取构件项目列表错误", a);
    } finally {
      n.value = false;
    }
  }
  return (a, t) => {
    const p = j, v = T;
    return y(), _(k, null, [f("div", z, [u(p, { modelValue: e.value, "onUpdate:modelValue": t[0] || (t[0] = (i) => e.value = i), type: "year", size: "default", "value-format": "x", clearable: false, placeholder: "选择年份", style: { width: "100px" }, class: "filter-item", onChange: d }, null, 8, ["modelValue"]), u(v, { modelValue: o.value, "onUpdate:modelValue": t[1] || (t[1] = (i) => o.value = i), modelModifiers: { trim: true }, size: "default", placeholder: "输入项目/单体/区域搜索", style: { width: "200px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"])]), f("div", { style: V({ height: `${r.maxHeight}px` }) }, [u(P(b), x({ "tree-data": s.value, "filter-text": o.value, loading: n.value }, a.$attrs), null, 16, ["tree-data", "filter-text", "loading"])], 4)], 64);
  };
} };
export {
  R as default
};
