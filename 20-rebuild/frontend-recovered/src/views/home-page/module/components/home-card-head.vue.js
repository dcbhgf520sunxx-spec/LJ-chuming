import { G as u, a as _ } from "../../../../shared/runtime.js";
import { c as f } from "../../../../modules/home-page-66a3681d.js";
import { openBlock as t } from "vue";
import { createElementBlock as o } from "vue";
import { createElementVNode as s } from "vue";
import { createBlock as h } from "vue";
import { createCommentVNode as c } from "vue";
import { toDisplayString as k } from "vue";
import { unref as i } from "vue";
const y = { class: "home-card-head" }, B = { class: "title" }, g = { class: "btn-right" }, P = { __name: "home-card-head", props: { icon: { type: String, default: "" }, title: { type: String, default: "" }, editPermission: { type: String, default: "" }, showCreateBtn: { type: Boolean, default: false }, showMoreBtn: { type: Boolean, default: false } }, emits: ["create-click", "more-click"], setup(r, { emit: l }) {
  const e = r, n = l;
  function m(a) {
    n("create-click");
  }
  function p(a) {
    n("more-click");
  }
  return (a, C) => {
    const d = _;
    return t(), o("div", y, [s("div", B, [e.icon ? (t(), h(d, { key: 0, class: "icon", "icon-class": e.icon }, null, 8, ["icon-class"])) : c("", true), s("span", null, k(e.title), 1)]), s("div", g, [e.showCreateBtn && i(u)(i(f)[e.editPermission]) ? (t(), o("span", { key: 0, onClick: m, style: { color: "#3591b9" } }, "创建")) : c("", true), e.showMoreBtn ? (t(), o("span", { key: 1, onClick: p, style: { color: "#80817d" } }, "查看全部")) : c("", true)])]);
  };
} };
export {
  P as default
};
