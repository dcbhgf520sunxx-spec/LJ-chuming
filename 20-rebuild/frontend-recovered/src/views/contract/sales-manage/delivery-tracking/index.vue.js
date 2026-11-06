import { computed as x } from "vue";
import { ref as r } from "vue";
import { provide as h } from "vue";
import { onMounted as V } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as m } from "vue";
import { createElementVNode as t } from "vue";
import { createVNode as o } from "vue";
import { unref as e } from "vue";
import { createCommentVNode as k } from "vue";
import { createBlock as I } from "vue";
import { resolveDynamicComponent as P } from "vue";
import { ElDatePicker as A } from "element-plus";
import { _ as Q, bi as c, m as b, G as w } from "../../../../shared/runtime.js";
import { N as E } from "../../../../modules/contract-9b18cc88.js";
import M from "./structure/index.vue.js";
import N from "./auxiliary-material/index.vue.js";
import { _ as R } from "../../../../modules/project-visa-select-e1b3658e.js";
import { P as d } from "../../../../modules/index-5b9e6004.js";
import "../../../../modules/order-tracking-9be524cd.js";
import "./structure/module/header.vue.js";
import "./auxiliary-material/module/header.vue.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const T = { class: "app-container" }, U = { class: "head-container" }, j = { key: 0, style: { display: "flex" } }, B = { style: { flex: "1", padding: "0 10px", "padding-left": "0" } }, C = { style: { flex: "1", padding: "0 10px" } }, D = { style: { flex: "1", padding: "0 10px" } }, L = { style: { flex: "1", padding: "0 10px" } }, z = { style: { flex: "1", padding: "0 10px", "padding-right": "0" } }, G = { __name: "index", setup(H) {
  const p = x(() => {
    switch (i.value) {
      case c.AUXILIARY_MATERIAL.V:
        return N;
      default:
        return M;
    }
  }), { globalProjectId: f } = b(["globalProjectId"]), _ = r(), l = r({}), i = r(), n = r({});
  return h("searchQuery", l), V(() => {
  }), (S, a) => {
    const v = g("common-radio-button"), y = A;
    return u(), m("div", T, [t("div", U, [t("div", null, [t("div", null, [o(e(R), { modelValue: l.value.projectId, "onUpdate:modelValue": a[0] || (a[0] = (s) => l.value.projectId = s), "default-id": e(f), class: "filter-item", style: { width: "300px" }, placeholder: "可选择项目搜索" }, null, 8, ["modelValue", "default-id"]), o(v, { modelValue: i.value, "onUpdate:modelValue": a[1] || (a[1] = (s) => i.value = s), options: e(c).ENUM, default: "", unshowVal: [e(c).MACHINE_PART.V], type: "enumSL", size: "default", class: "filter-item" }, null, 8, ["modelValue", "options", "unshowVal"]), o(y, { modelValue: l.value.date, "onUpdate:modelValue": a[2] || (a[2] = (s) => l.value.date = s), type: "daterange", "range-separator": ":", size: "default", class: "filter-item date-item", "start-placeholder": "开始时间", "end-placeholder": "结束时间", style: { width: "240px" } }, null, 8, ["modelValue"])]), e(w)(e(E).get) ? (u(), m("div", j, [t("div", B, [o(e(d), { name: "累计发运量（吨）", "text-color": "#626262", "num-color": "#1890ff", "end-val": n.value.sumQuantity || 0, precision: 0 }, null, 8, ["end-val"])]), t("div", C, [o(e(d), { name: "累计发运额（元）", "text-color": "#626262", "num-color": "#1890ff", "end-val": n.value.sumQuantity || 0, precision: 0 }, null, 8, ["end-val"])]), t("div", D, [o(e(d), { name: "累计车次/船次", "text-color": "#626262", "num-color": "#1890ff", "end-val": n.value.sumQuantity || 0, precision: 0 }, null, 8, ["end-val"])]), t("div", L, [o(e(d), { name: "筛选日期发运量（吨）", "text-color": "#626262", "num-color": "#1890ff", "end-val": n.value.sumQuantity || 0, precision: 0 }, null, 8, ["end-val"])]), t("div", z, [o(e(d), { name: "筛选日期发运额（元）", "text-color": "#626262", "num-color": "#1890ff", "end-val": n.value.sumQuantity || 0, precision: 0 }, null, 8, ["end-val"])])])) : k("", true)])]), (u(), I(P(p.value), { ref_key: "domRef", ref: _ }, null, 512))]);
  };
} }, oe = Q(G, [["__scopeId", "data-v-63cfcc9d"]]);
export {
  oe as default
};
