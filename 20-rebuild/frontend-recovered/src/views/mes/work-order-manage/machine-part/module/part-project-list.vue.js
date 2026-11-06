import { inject as h } from "vue";
import { ref as r } from "vue";
import d from "moment";
import { watch as y } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as _ } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as i } from "vue";
import { mergeProps as x } from "vue";
import { unref as P } from "vue";
import { normalizeStyle as V } from "vue";
import { Fragment as T } from "vue";
import { ElDatePicker as k } from "element-plus";
import { ElInput as j } from "element-plus";
import { e as w } from "../../../../../modules/machine-part-85f162b2.js";
import { G as E, sh as O, cn as b } from "../../../../../shared/runtime.js";
import D from "../../components/project-to-area-tree.vue.js";
const I = { class: "head-container" }, S = { __name: "part-project-list", props: { maxHeight: { type: [Number, String], default: void 0 } }, setup(p) {
  const u = h("crud"), e = r(d().valueOf()), o = r([]), t = r(""), s = r(false);
  y([() => e.value], () => {
    u.data = [], u.query.projectId = void 0;
  }), c();
  async function c() {
    if (E(O.get)) try {
      t.value = "", s.value = true, o.value = [];
      const a = await w({ localDateTime: e.value ? e.value : d().valueOf(), processType: b.CUTTING_ORDER.V });
      o.value = a || [];
    } catch (a) {
      console.log("获取构件项目列表错误", a);
    } finally {
      s.value = false;
    }
  }
  return (a, l) => {
    const f = k, v = j;
    return g(), _(T, null, [m("div", I, [i(f, { modelValue: e.value, "onUpdate:modelValue": l[0] || (l[0] = (n) => e.value = n), type: "year", size: "default", "value-format": "x", clearable: false, placeholder: "选择年份", style: { width: "100px" }, class: "filter-item", onChange: c }, null, 8, ["modelValue"]), i(v, { modelValue: t.value, "onUpdate:modelValue": l[1] || (l[1] = (n) => t.value = n), modelModifiers: { trim: true }, size: "default", placeholder: "输入项目/单体/区域搜索", style: { width: "200px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"])]), m("div", { style: V({ height: `${p.maxHeight}px` }) }, [i(P(D), x({ "tree-data": o.value, "filter-text": t.value, loading: s.value }, a.$attrs), null, 16, ["tree-data", "filter-text", "loading"])], 4)], 64);
  };
} };
export {
  S as default
};
