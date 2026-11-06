import { g as f } from "../../../../modules/enterprise-cloud-disk-7c8bf938.js";
import { _ as v, p as h } from "../../../../shared/runtime.js";
import g from "../components/home-card-head.vue.js";
import k from "./add-dialog.vue.js";
import D from "./list-drawer.vue.js";
import { ref as i } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as r } from "vue";
import { createVNode as u } from "vue";
import { createElementVNode as t } from "vue";
import { Fragment as x } from "vue";
import { renderList as C } from "vue";
import { toDisplayString as p } from "vue";
import { unref as y } from "vue";
import { createCommentVNode as V } from "vue";
import "../../../../modules/home-page-66a3681d.js";
import "./detail-dialog.vue.js";
const S = { class: "home-card enterprise-cloud-disk-card" }, b = { class: "home-card-content" }, N = { class: "home-card-info-list" }, B = { class: "home-card-info-item-sn" }, $ = { class: "home-card-info-item-content" }, w = { class: "ellipsis-text" }, L = { class: "date" }, P = { key: 0, class: "home-card-info-no-data" }, T = { __name: "index", setup(E) {
  const o = i([]), d = i(false), c = i(false), _ = i(false);
  m();
  async function m() {
    o.value = [];
    try {
      const { content: a = [], hasNextPage: e } = await f({ page: 1, pageSize: 15 });
      o.value = a.map((s) => (s.nameStrings = s.attachmentDTOList.map((n) => n.name).join("、"), s)), _.value = e;
    } catch (a) {
      console.log(a, "获取企业网盘列表失败");
    }
  }
  return (a, e) => (l(), r("div", S, [u(g, { icon: "comp-home-disk", title: "企业网盘", showCreateBtn: "", showMoreBtn: "", editPermission: "editCloudDisk", onCreateClick: e[0] || (e[0] = (s) => d.value = true), onMoreClick: e[1] || (e[1] = (s) => c.value = true) }), t("div", b, [t("div", N, [(l(true), r(x, null, C(o.value, (s, n) => (l(), r("div", { key: n, class: "home-card-info-item" }, [t("div", B, [t("span", null, p(n + 1), 1)]), t("div", $, [t("span", w, p(s.nameStrings), 1), t("span", L, p(y(h)(s.informantDateTime, "{y}-{m}-{d}")), 1)])]))), 128))]), o.value.length ? V("", true) : (l(), r("div", P, e[4] || (e[4] = [t("span", null, "* 暂无数据", -1)])))]), u(k, { modelValue: d.value, "onUpdate:modelValue": e[2] || (e[2] = (s) => d.value = s), onAddSuccess: m }, null, 8, ["modelValue"]), u(D, { visible: c.value, "onUpdate:visible": e[3] || (e[3] = (s) => c.value = s), onDelSuccess: m }, null, 8, ["visible"])]));
} }, q = v(T, [["__scopeId", "data-v-0ee277ff"]]);
export {
  q as default
};
