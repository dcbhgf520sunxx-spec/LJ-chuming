import { g as y } from "../../../../modules/company-dynamics-34941552.js";
import { _ as g, p as D } from "../../../../shared/runtime.js";
import V from "../components/home-card-head.vue.js";
import b from "./add-dialog.vue.js";
import x from "./detail-dialog.vue.js";
import k from "./list-drawer.vue.js";
import { ref as a } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as l } from "vue";
import { createVNode as d } from "vue";
import { createElementVNode as t } from "vue";
import { Fragment as C } from "vue";
import { renderList as $ } from "vue";
import { toDisplayString as _ } from "vue";
import { unref as N } from "vue";
import { createCommentVNode as w } from "vue";
import "../../../../modules/home-page-66a3681d.js";
const B = { class: "home-card dynamics-card" }, S = { class: "home-card-content" }, I = { class: "home-card-info-list" }, P = ["onDblclick"], L = { class: "home-card-info-item-sn" }, U = { class: "home-card-info-item-content" }, M = { class: "ellipsis-text" }, T = { class: "date" }, z = { key: 0, class: "home-card-info-no-data" }, A = { __name: "index", setup(E) {
  const n = a([]), r = a(false), c = a(false), p = a({}), m = a(false), f = a(false);
  u();
  async function u() {
    n.value = [];
    try {
      const { content: o = [], hasNextPage: e } = await y({ page: 1, pageSize: 15 });
      n.value = o, f.value = e;
    } catch (o) {
      console.log(o, "获取公司动态列表失败");
    }
  }
  function h(o) {
    c.value = true, p.value = o;
  }
  return (o, e) => (i(), l("div", B, [d(V, { icon: "comp-home-dynamics", title: "公司动态", showCreateBtn: "", showMoreBtn: "", editPermission: "editDynamics", onCreateClick: e[0] || (e[0] = (s) => r.value = true), onMoreClick: e[1] || (e[1] = (s) => m.value = true) }), t("div", S, [t("div", I, [(i(true), l(C, null, $(n.value, (s, v) => (i(), l("div", { key: v, class: "home-card-info-item", onDblclick: (F) => h(s) }, [t("div", L, [t("span", null, _(v + 1), 1)]), t("div", U, [t("span", M, _(s.title), 1), t("span", T, _(N(D)(s.informantDateTime, "{y}-{m}-{d}")), 1)])], 40, P))), 128))]), n.value.length ? w("", true) : (i(), l("div", z, e[5] || (e[5] = [t("span", null, "* 暂无数据", -1)])))]), d(b, { modelValue: r.value, "onUpdate:modelValue": e[2] || (e[2] = (s) => r.value = s), onAddSuccess: u }, null, 8, ["modelValue"]), d(x, { modelValue: c.value, "onUpdate:modelValue": e[3] || (e[3] = (s) => c.value = s), detailId: p.value.id, onDelSuccess: u }, null, 8, ["modelValue", "detailId"]), d(k, { visible: m.value, "onUpdate:visible": e[4] || (e[4] = (s) => m.value = s) }, null, 8, ["visible"])]));
} }, R = g(A, [["__scopeId", "data-v-6d451db2"]]);
export {
  R as default
};
