import { _ as n } from "../../../../shared/runtime.js";
import { computed as a } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as _ } from "vue";
import { createElementVNode as t } from "vue";
import { toDisplayString as c } from "vue";
const l = { class: "filter-item inventory" }, d = { class: "right-box" }, p = { __name: "index", props: { RealtimeWeight: { type: [Number, String], default: void 0 } }, setup(s) {
  const o = s, i = a(() => o.RealtimeWeight);
  return (m, e) => (r(), _("div", l, [e[0] || (e[0] = t("div", { class: "left-box" }, " 实时库存 ", -1)), t("div", d, c(i.value || 0) + " 吨 ", 1)]));
} }, v = n(p, [["__scopeId", "data-v-668699f7"]]);
export {
  v as default
};
