import { a as m } from "../../../../modules/process-381d77e4.js";
import { p1 as r } from "../../../../shared/runtime.js";
import n from "./module/index.vue.js";
import { ref as c } from "vue";
import { onMounted as u } from "vue";
import { resolveDirective as d } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as f } from "vue";
import { withDirectives as l } from "vue";
import { unref as e } from "vue";
import { createVNode as p } from "vue";
const v = { class: "app-container" }, k = { __name: "index", setup(x) {
  const s = c([]), t = c([]);
  return u(() => {
    m().then(({ fixedList: a, unFixedList: o }) => {
      t.value = a, s.value = o;
    });
  }), (a, o) => {
    const i = d("permission");
    return _(), f("div", v, [l(p(e(n), { data: t.value, isFixed: true }, null, 8, ["data"]), [[i, e(r).get]]), l(p(e(n), { style: { "margin-top": "20px" }, data: s.value, isFixed: false }, null, 8, ["data"]), [[i, e(r).get]])]);
  };
} };
export {
  k as default
};
