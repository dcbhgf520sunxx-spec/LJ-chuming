import { mapGetters as h } from "vuex";
import { openBlock as t } from "vue";
import { createElementBlock as o } from "vue";
import { createVNode as c } from "vue";
import { withCtx as a } from "vue";
import { Fragment as i } from "vue";
import { renderList as d } from "vue";
import { createBlock as u } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as m } from "vue";
import { ElCol as x } from "element-plus";
import { ElRow as C } from "element-plus";
import { _ as k, a as v } from "../../../shared/runtime.js";
const w = { name: "LoginMenuComponent", data() {
  return { fixedMenus: [] };
}, computed: { ...h(["menus", "currentMenu"]) }, methods: { async goView(n) {
  n.iframe ? window.open(n.redirect) : (this.$emit("replace", n.redirect), this.$router.push({ path: n.redirect }));
} } }, y = { class: "menus-container" }, M = ["onClick"], V = { class: "menu-img" }, $ = ["textContent"], B = ["onClick"], b = { class: "menu-img" }, E = ["textContent"];
function F(n, L, N, S, p, l) {
  const _ = v, r = x, f = C;
  return t(), o("div", y, [c(f, { gutter: 20, class: "el-row-content" }, { default: a(() => [(t(true), o(i, null, d(n.menus, (e) => (t(), u(r, { key: e.id, xs: 8, sm: 8, md: 8, lg: 6, xl: 6 }, { default: a(() => [s("div", { class: "menu-drawer", onClick: (g) => l.goView(e) }, [s("div", V, [c(_, { "icon-class": e.icon, class: "icon" }, null, 8, ["icon-class"])]), s("span", { class: "menu-name", textContent: m(e.name) }, null, 8, $)], 8, M)]), _: 2 }, 1024))), 128)), (t(true), o(i, null, d(p.fixedMenus, (e) => (t(), u(r, { key: e.id, xs: 8, sm: 8, md: 8, lg: 6, xl: 6 }, { default: a(() => [s("div", { class: "menu-drawer", onClick: (g) => l.goView(e) }, [s("div", b, [c(_, { "icon-class": e.icon, class: "icon" }, null, 8, ["icon-class"])]), s("span", { class: "menu-name", textContent: m(e.name) }, null, 8, E)], 8, B)]), _: 2 }, 1024))), 128))]), _: 1 })]);
}
const G = k(w, [["render", F], ["__scopeId", "data-v-2525f05a"]]);
export {
  G as default
};
