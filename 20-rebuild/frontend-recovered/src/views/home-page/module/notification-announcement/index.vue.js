import { g } from "../../../../modules/notification-announcement-a0e50fbd.js";
import { _ as V, p as D } from "../../../../shared/runtime.js";
import b from "../components/home-card-head.vue.js";
import x from "./add-dialog.vue.js";
import k from "./detail-dialog.vue.js";
import y from "./list-drawer.vue.js";
import { ref as a } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as l } from "vue";
import { createVNode as c } from "vue";
import { createElementVNode as o } from "vue";
import { Fragment as N } from "vue";
import { renderList as $ } from "vue";
import { toDisplayString as _ } from "vue";
import { unref as C } from "vue";
import { createCommentVNode as w } from "vue";
import "../../../../modules/home-page-66a3681d.js";
const B = { class: "home-card announcement-card" }, S = { class: "home-card-content" }, I = { class: "home-card-info-list" }, P = ["onDblclick"], A = { class: "home-card-info-item-sn" }, L = { class: "home-card-info-item-content" }, U = { class: "ellipsis-text" }, M = { class: "date" }, T = { key: 0, class: "home-card-info-no-data" }, z = { __name: "index", setup(E) {
  const n = a([]), r = a(false), d = a(false), v = a({}), m = a(false), f = a(false);
  u();
  async function u() {
    n.value = [];
    try {
      const { content: s = [], hasNextPage: e } = await g({ page: 1, pageSize: 15 });
      n.value = s, f.value = e;
    } catch (s) {
      console.log(s, "获取通知公告列表失败");
    }
  }
  function h(s) {
    d.value = true, v.value = s;
  }
  return (s, e) => (i(), l("div", B, [c(b, { icon: "comp-home-notice", title: "通知公告", showCreateBtn: "", showMoreBtn: "", editPermission: "editNotice", onCreateClick: e[0] || (e[0] = (t) => r.value = true), onMoreClick: e[1] || (e[1] = (t) => m.value = true) }), o("div", S, [o("div", I, [(i(true), l(N, null, $(n.value, (t, p) => (i(), l("div", { key: p, class: "home-card-info-item", onDblclick: (F) => h(t) }, [o("div", A, [o("span", null, _(p + 1), 1)]), o("div", L, [o("span", U, _(t.title), 1), o("span", M, _(C(D)(t.informantDateTime, "{y}-{m}-{d}")), 1)])], 40, P))), 128))]), n.value.length ? w("", true) : (i(), l("div", T, e[5] || (e[5] = [o("span", null, "* 暂无数据", -1)])))]), c(x, { modelValue: r.value, "onUpdate:modelValue": e[2] || (e[2] = (t) => r.value = t), onAddSuccess: u }, null, 8, ["modelValue"]), c(k, { modelValue: d.value, "onUpdate:modelValue": e[3] || (e[3] = (t) => d.value = t), detailId: v.value.id, onDelSuccess: u }, null, 8, ["modelValue", "detailId"]), c(y, { visible: m.value, "onUpdate:visible": e[4] || (e[4] = (t) => m.value = t) }, null, 8, ["visible"])]));
} }, R = V(z, [["__scopeId", "data-v-84015ecc"]]);
export {
  R as default
};
