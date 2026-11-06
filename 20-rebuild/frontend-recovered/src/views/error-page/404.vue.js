import { _ as l, j as o } from "../../shared/runtime.js";
import { mapGetters as _ } from "vuex";
import { openBlock as n } from "vue";
import { createElementBlock as d } from "vue";
import { createElementVNode as e } from "vue";
import { createStaticVNode as r } from "vue";
import { toDisplayString as p } from "vue";
const u = "/static/png/404-538aa4d7.png", i = "/static/png/404_cloud-98e7ac66.png";
const m = { name: "Page404", computed: { ..._(["menus"]), message() {
  var t;
  return (t = this.menus) != null && t.length ? "网站管理员说您无法进入此页面..." : "您没有权限，请联系管理员为您分配权限后再次登录!";
} }, methods: { goMenus() {
  var t;
  (t = this.menus) != null && t.length || o.dispatch("user/logout"), this.$router.replace({ path: "/login" });
} } }, g = { class: "wscn-http404-container" }, h = { class: "wscn-http404" }, v = { class: "bullshit" }, b = { class: "bullshit__headline" };
function f(t, s, x, k, y, a) {
  return n(), d("div", g, [e("div", h, [s[3] || (s[3] = r('<div class="pic-404" data-v-575e26eb><img class="pic-404__parent" src="' + u + '" alt="404" data-v-575e26eb><img class="pic-404__child left" src="' + i + '" alt="404" data-v-575e26eb><img class="pic-404__child mid" src="' + i + '" alt="404" data-v-575e26eb><img class="pic-404__child right" src="' + i + '" alt="404" data-v-575e26eb></div>', 1)), e("div", v, [s[1] || (s[1] = e("div", { class: "bullshit__oops" }, "中南绿建", -1)), e("div", b, p(a.message), 1), s[2] || (s[2] = e("div", { class: "bullshit__info" }, "单击下面的按钮返回首页。", -1)), e("a", { class: "bullshit__return-home", onClick: s[0] || (s[0] = (...c) => a.goMenus && a.goMenus(...c)) }, "回到首页")])])]);
}
const w = l(m, [["render", f], ["__scopeId", "data-v-575e26eb"]]);
export {
  w as default
};
