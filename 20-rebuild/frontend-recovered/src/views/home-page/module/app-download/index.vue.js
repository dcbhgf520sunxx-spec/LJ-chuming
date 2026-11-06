import { _ as t, a as _ } from "../../../../shared/runtime.js";
import p from "./show-dialog.vue.js";
import { ref as r } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as i } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as n } from "vue";
import { Fragment as u } from "vue";
const c = { __name: "index", setup(m) {
  const o = r(false);
  return (f, e) => {
    const l = _;
    return d(), i(u, null, [s("div", { class: "flex-rsc", onClick: e[0] || (e[0] = (a) => o.value = true) }, [n(l, { class: "icon", "icon-class": "appDownload" }), e[2] || (e[2] = s("span", null, "APP下载", -1))]), n(p, { modelValue: o.value, "onUpdate:modelValue": e[1] || (e[1] = (a) => o.value = a) }, null, 8, ["modelValue"])], 64);
  };
} }, V = t(c, [["__scopeId", "data-v-e1450a8d"]]);
export {
  V as default
};
