import { _ as r, a as d } from "../../../shared/runtime.js";
import { a as f } from "../../../modules/common-09583abc.js";
import { ref as l } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as p } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as e } from "vue";
import { toDisplayString as c } from "vue";
const u = { class: "information-box" }, v = { class: "my-information", style: { background: "#7395fa" } }, h = { class: "icon-right" }, g = { class: "label-left" }, y = { class: "data" }, b = { class: "my-information", style: { background: "#48aaef" } }, k = { class: "icon-right" }, I = { class: "label-left" }, x = { class: "data" }, B = { class: "my-information", style: { background: "#33c986" } }, C = { class: "icon-right" }, j = { class: "label-left" }, N = { class: "data" }, V = { __name: "personal-information", setup(w) {
  const i = l(false), a = l({});
  _();
  async function _() {
    try {
      i.value = true;
      const t = await f();
      a.value = t;
    } catch (t) {
      console.log(t, "获取门户基础信息失败");
    } finally {
      i.value = false;
    }
  }
  return (t, o) => {
    const n = d;
    return m(), p("div", u, [s("div", v, [s("div", h, [e(n, { "icon-class": "computer", class: "icon" })]), s("div", g, [s("span", y, c(a.value.registerTime), 1), o[0] || (o[0] = s("span", null, "使用时长", -1))])]), s("div", b, [s("div", k, [e(n, { "icon-class": "myProject", class: "icon" })]), s("div", I, [s("span", x, c(a.value.projectCount), 1), o[1] || (o[1] = s("span", null, "项目数量", -1))])]), s("div", B, [s("div", C, [e(n, { "icon-class": "myCheck", class: "icon" })]), s("div", j, [s("span", N, c(a.value.canCheckCount), 1), o[2] || (o[2] = s("span", null, "我的审批", -1))])])]);
  };
} }, P = r(V, [["__scopeId", "data-v-6816ae72"]]);
export {
  P as default
};
