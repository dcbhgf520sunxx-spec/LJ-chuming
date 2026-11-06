import { _ as x, m as w, M as u, N as l, a as C } from "../../../shared/runtime.js";
import { useRouter as L } from "vue-router";
import { computed as p } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as r } from "vue";
import { createVNode as d } from "vue";
import { createElementVNode as _ } from "vue";
import { Fragment as E } from "vue";
import { renderList as b } from "vue";
import { normalizeStyle as F } from "vue";
import { toDisplayString as S } from "vue";
import { ElMessage as c } from "element-plus";
import D from "./components/home-card-head.vue.js";
import "../../../modules/home-page-66a3681d.js";
const I = { class: "home-card system-main" }, M = { class: "module-container" }, B = ["onClick"], N = { __name: "system-app", setup(P) {
  const a = L(), { menus: s } = w("menus"), i = ["#B79DF9", "#F49CD4", "#C18E36", "#F79C85", "#F79C85"], m = p(() => {
    const e = [];
    return s.value.forEach((n) => {
      n.iframe && !n.isTripartite && e.push({ name: n.name, icon: n.icon, path: n.redirect, isExternalLink: true, background: i[e.length] ? i[e.length] : "#4d93d7" });
    }), e;
  }), f = p(() => [{ name: "数字化系统", icon: "appSystem", background: "#4D93D7", isExternalLink: false, isCurrentSystem: true }, ...m.value, { name: "柏楚云排样", icon: "system-third", background: "#4d93d7", isExternalLink: true, newWindow: true, path: "https://cloudnest.fscut.com/pc" }]);
  function h(e) {
    if (e.isCurrentSystem) {
      g();
      return;
    }
    if (!e.path) return c.warning("暂无跳转链接");
    if (e.isExternalLink) {
      let n = e.path;
      e.path.indexOf("/device") !== -1 && u() && (n = e.path + u()), e.newWindow ? window.open(n) : window.location.href = n;
    } else y(e.path) ? a.push({ path: e.path }) : c.warning("该菜单暂未开放，敬请期待");
  }
  function g() {
    if (l()) return a.push(l());
    const e = s.value.findIndex((n) => !n.iframe);
    if (e === -1) return c.warning("该菜单暂无模块，敬请期待");
    a.push(s.value[e].redirect);
  }
  function y(e) {
    return s.value.some((n) => n.redirect === e);
  }
  return (e, n) => {
    const k = C;
    return o(), r("div", I, [d(D, { icon: "comp-home-system", title: "系统应用" }), _("div", M, [(o(true), r(E, null, b(f.value, (t, v) => (o(), r("div", { key: v, class: "app-module", style: F({ background: t.background }), onClick: (j) => h(t) }, [d(k, { class: "icon", "icon-class": t.icon }, null, 8, ["icon-class"]), _("span", null, S(t.name), 1)], 12, B))), 128))])]);
  };
} }, $ = x(N, [["__scopeId", "data-v-e13e6b76"]]);
export {
  $ as default
};
