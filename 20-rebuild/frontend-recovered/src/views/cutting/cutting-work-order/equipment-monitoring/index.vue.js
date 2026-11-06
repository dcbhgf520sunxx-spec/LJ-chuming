import { d } from "../../../../modules/machine-10301ee2.js";
import { _ as p, x as _, o as l } from "../../../../shared/runtime.js";
import m from "./module/header.vue.js";
import f from "./project-chart/index.vue.js";
import { openBlock as h } from "vue";
import { createElementBlock as u } from "vue";
import { createElementVNode as t } from "vue";
import { createVNode as a } from "vue";
import { unref as s } from "vue";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "./project-chart/module/lineChart.vue.js";
import "../../../../modules/index-18acf776.js";
import "./project-chart/module/columnChart.vue.js";
const x = { class: "app-container" }, g = { class: "head-container" }, v = { class: "app-content" }, y = { class: "right-content" }, b = { __name: "index", props: { detailData: { type: Object } }, setup(n) {
  const i = { add: false, edit: false, del: false, download: false }, c = n;
  _({ title: "设备监控", sort: [], optShow: { ...i }, hasPagination: true }), r();
  async function r() {
    try {
      const o = await d(c.detailData);
      console.log(o);
    } catch {
      console.log("请求设备监控的接口失败");
    }
  }
  return l({ paginate: true, extraHeight: 40 }), (o, e) => (h(), u("div", x, [t("div", g, [a(s(m))]), t("div", v, [e[0] || (e[0] = t("div", { class: "left-content" }, null, -1)), t("div", y, [a(s(f))])])]));
} }, S = p(b, [["__scopeId", "data-v-b9d52c64"]]);
export {
  S as default
};
