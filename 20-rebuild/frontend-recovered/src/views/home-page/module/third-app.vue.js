import { _ as y, m as v, a as g } from "../../../shared/runtime.js";
import { g as k } from "../../../modules/common-09583abc.js";
import C from "./components/home-card-head.vue.js";
import { ref as w } from "vue";
import { computed as l } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as o } from "vue";
import { createVNode as p } from "vue";
import { Fragment as F } from "vue";
import { renderList as A } from "vue";
import { normalizeStyle as B } from "vue";
import { createElementVNode as E } from "vue";
import { toDisplayString as b } from "vue";
import { createCommentVNode as _ } from "vue";
import "../../../modules/home-page-66a3681d.js";
const x = { class: "home-card system-main" }, D = { key: 0, class: "module-container" }, L = ["onClick"], S = { key: 1, class: "no-data" }, I = { __name: "third-app", setup(N) {
  const i = w(""), { menus: m } = v("menus"), a = ["#4d93d7", "#48AAEF", "#2cc1ae", "#FAB973", "#B79DF9", "#F49CD4", "#C18E36", "#F79C85", "#F79C85"], u = l(() => {
    const e = [];
    return m.value.forEach((t) => {
      t.iframe && t.isTripartite && e.push({ name: t.name, icon: t.icon, path: t.redirect, isExternalLink: true, background: a[e.length] ? a[e.length] : "#4d93d7" });
    }), e;
  }), s = l(() => [{ name: "科创在线", path: "", icon: "system-intellectual-property" }, { name: "OA协同", path: "http://oa.znjs.com:800/wui/", icon: "system-oa-approval" }, ...u.value]);
  async function d() {
    try {
      const e = await k();
      i.value = e || "";
    } catch (e) {
      console.log(e, "调用知识产权接口失败");
    }
  }
  async function h(e) {
    e.path ? window.open(e.path, "_blank", "noopener,noreferrer") : (await d(), window.open(i.value));
  }
  return (e, t) => {
    const f = g;
    return n(), o("div", x, [p(C, { icon: "comp-home-third", title: "第三方应用" }), s.value.length ? (n(), o("div", D, [(n(true), o(F, null, A(s.value, (c, r) => (n(), o("div", { key: r, class: "app-module", style: B({ background: a[r] ? a[r] : a[0] }), onClick: (V) => h(c) }, [p(f, { class: "icon", "icon-class": c.icon || "system-third" }, null, 8, ["icon-class"]), E("span", null, b(c.name), 1)], 12, L))), 128))])) : _("", true), s.value.length ? _("", true) : (n(), o("div", S, "暂无其他第三方应用"))]);
  };
} }, T = y(I, [["__scopeId", "data-v-96868a33"]]);
export {
  T as default
};
