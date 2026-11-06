import { resolveComponent as f } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as m } from "vue";
import { createVNode as s } from "vue";
import { withCtx as e } from "vue";
import { createTextVNode as i } from "vue";
import { createElementVNode as o } from "vue";
import { withModifiers as c } from "vue";
import { ElButton as g } from "element-plus";
import { ElCol as k } from "element-plus";
import { ElRow as w } from "element-plus";
import { ElDialog as h } from "element-plus";
import { _ as v } from "../../shared/runtime.js";
const x = "/static/gif/401-a61ddb94.gif";
const C = { name: "Page401", data() {
  return { errGif: x + "?" + +/* @__PURE__ */ new Date(), ewizardClap: "https://wpimg.wallstcn.com/007ef517-bafd-4066-aae4-6883632d9646", dialogVisible: false };
}, methods: { back() {
  this.$route.query.noGoBack ? this.$router.push({ path: "/dashboard" }) : this.$router.go(-1);
} } }, V = { class: "errPage-container" }, y = { class: "list-unstyled" }, B = { class: "link-type" }, E = ["src"], G = ["src"];
function z(N, t, j, D, l, a) {
  const d = g, p = f("router-link"), n = k, _ = w, u = h;
  return b(), m("div", V, [s(d, { icon: "el-icon-arrow-left", class: "pan-back-btn", onClick: a.back }, { default: e(() => t[2] || (t[2] = [i(" 返回 ")])), _: 1, __: [2] }, 8, ["onClick"]), s(_, null, { default: e(() => [s(n, { span: 12 }, { default: e(() => [t[6] || (t[6] = o("h1", { class: "text-jumbo text-ginormous" }, " Oops! ", -1)), t[7] || (t[7] = i(" gif来源")), t[8] || (t[8] = o("a", { href: "https://zh.airbnb.com/", target: "_blank" }, "airbnb", -1)), t[9] || (t[9] = i(" 页面 ")), t[10] || (t[10] = o("h2", null, "你没有权限去该页面", -1)), t[11] || (t[11] = o("h6", null, "如有不满请联系你领导", -1)), o("ul", y, [t[4] || (t[4] = o("li", null, "或者你可以去:", -1)), o("li", B, [s(p, { to: "/dashboard" }, { default: e(() => t[3] || (t[3] = [i(" 回首页 ")])), _: 1, __: [3] })]), t[5] || (t[5] = o("li", { class: "link-type" }, [o("a", { href: "https://bim.hzchum.com/" }, "随便看看")], -1)), o("li", null, [o("a", { href: "#", onClick: t[0] || (t[0] = c((r) => l.dialogVisible = true, ["prevent"])) }, "点我看图")])])]), _: 1, __: [6, 7, 8, 9, 10, 11] }), s(n, { span: 12 }, { default: e(() => [o("img", { src: l.errGif, width: "313", height: "428", alt: "Girl has dropped her ice cream." }, null, 8, E)]), _: 1 })]), _: 1 }), s(u, { visible: l.dialogVisible, "onUpdate:visible": t[1] || (t[1] = (r) => l.dialogVisible = r), title: "随便看" }, { default: e(() => [o("img", { src: l.ewizardClap, class: "pan-img" }, null, 8, G)]), _: 1 }, 8, ["visible"])]);
}
const q = v(C, [["render", z], ["__scopeId", "data-v-d916acc6"]]);
export {
  q as default
};
