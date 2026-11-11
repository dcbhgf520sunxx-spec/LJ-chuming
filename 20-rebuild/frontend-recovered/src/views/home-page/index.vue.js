import { _ as l, m as d, U as _, a as h } from "../../shared/runtime.js";
import f from "./module/app-download/index.vue.js";
import u from "./module/system-app.vue.js";
import v from "./module/third-app.vue.js";
import g from "./module/schedule-card/index.vue.js";
import y from "./module/notification-announcement/index.vue.js";
import w from "./module/personal-information.vue.js";
import x from "./module/information-exhibition/index.vue.js";
import k from "./module/company-dynamics/index.vue.js";
import z from "./module/enterprise-cloud-disk/index.vue.js";
import C from "./module/enterprise-information.vue.js";
import { ref as a } from "vue";
import { onMounted as E } from "vue";
import { onUnmounted as b } from "vue";
import { openBlock as D } from "vue";
import { createElementBlock as H } from "vue";
import { createElementVNode as o } from "vue";
import { toDisplayString as A } from "vue";
import { unref as B } from "vue";
import { createVNode as t } from "vue";
import { normalizeStyle as r } from "vue";
import { ElMessage as N } from "element-plus";
import "./module/app-download/show-dialog.vue.js";
import "./module/components/home-card-head.vue.js";
import "../../modules/home-page-66a3681d.js";
import "../../modules/common-09583abc.js";
import "./module/schedule-card/schedule-dialog.vue.js";
import "../../modules/notification-announcement-a0e50fbd.js";
import "./module/notification-announcement/add-dialog.vue.js";
import "./module/notification-announcement/detail-dialog.vue.js";
import "./module/notification-announcement/list-drawer.vue.js";
import "./module/information-exhibition/add-dialog.vue.js";
import "../../modules/PicUpload-8580ccfc.js";
import "../../modules/company-dynamics-34941552.js";
import "./module/company-dynamics/add-dialog.vue.js";
import "./module/company-dynamics/detail-dialog.vue.js";
import "./module/company-dynamics/list-drawer.vue.js";
import "../../modules/enterprise-cloud-disk-7c8bf938.js";
import "./module/enterprise-cloud-disk/add-dialog.vue.js";
import "./module/enterprise-cloud-disk/list-drawer.vue.js";
import "./module/enterprise-cloud-disk/detail-dialog.vue.js";
const U = "/static/png/logo-zhongnan-title-preview-3c65197f.png";
const W = { class: "home-head" }, I = { class: "left-logo" }, L = { class: "company-name" }, M = { class: "right-menu" }, S = { class: "right-menu-item hover-effect" }, V = { class: "right-menu-item hover-effect" }, $ = { class: "right-menu-item hover-effect avatar-container avatar" }, F = { class: "information" }, G = { __name: "index", setup(R) {
  const { user: m } = d("user"), s = a(window.innerWidth), i = a(window.innerHeight);
  function n() {
    s.value = window.innerWidth, i.value = window.innerHeight;
  }
  function p() {
    N.warning("暂无跳转链接");
  }
  return E(() => {
    window.addEventListener("resize", n);
  }), b(() => {
    window.removeEventListener("resize", n);
  }), (j, e) => {
    const c = h;
    return D(), H("div", { class: "home-page", style: r({ "min-width": i.value < 725 ? "860px" : "955px" }) }, [o("div", W, [o("div", I, [e[0] || (e[0] = o("img", { src: U, class: "logo-img" }, null, -1)), o("span", L, A(B(m).companyName || "初鸣数智") + " —— 赋能 | 赋智 | 赋值", 1), o("span", { class: "replica-edition" }, "复刻版")]), o("div", M, [o("div", S, [o("div", { class: "flex-rsc", onClick: p }, [t(c, { class: "icon", "icon-class": "system-operation-manual" }), e[1] || (e[1] = o("span", null, "操作手册", -1))])]), o("div", V, [t(f)]), o("div", $, [t(_, { placement: "bottom" })])])]), o("div", { class: "home-container", style: r(`height: calc(100vh - ${s.value < (i.value < 725 ? 860 : 955) ? "70px" : "60px"})`) }, [t(u, { class: "system-app" }), t(v, { class: "third-app" }), t(C, { class: "enterprise-information" }), t(z, { class: "cloud-disk" }), o("div", F, [t(w, { style: { "margin-bottom": "15px" } }), t(x, { style: { height: "calc(100% - 115px)" } })]), t(k, { class: "company-dynamics" }), t(g, { class: "schedule" }), t(y, { class: "notification" })], 4)], 4);
  };
} }, zo = l(G, [["__scopeId", "data-v-68a2d331"]]);
export {
  zo as default
};
