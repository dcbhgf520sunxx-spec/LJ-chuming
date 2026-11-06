import { computed as v } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as t } from "vue";
import { unref as h } from "vue";
import { Fragment as n } from "vue";
import { renderList as _ } from "vue";
import { normalizeClass as p } from "vue";
import { createElementVNode as F } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as c } from "vue";
import { createBlock as W } from "vue";
import { ElEmpty as x } from "element-plus";
import { _ as B, i as f } from "../../../../shared/runtime.js";
const C = { key: 0 }, E = ["onClick"], S = { class: "workshop-name" }, $ = { key: 0, class: "workshop-weight" }, N = { key: 2, class: "pd-warehouse-list" }, m = ["onClick"], A = { __name: "index", props: { datailList: { type: Array, default: () => [] }, warehouseList: { type: Array, default: () => [] }, query: { type: Object, default: () => ({}) }, showWarehouseList: { type: Boolean, default: false }, showWarehouseWeight: { type: Boolean, default: false } }, emits: ["success", "auditSuccess"], setup(i, { emit: w }) {
  const o = w, l = i, r = v(() => l.datailList);
  function k(e) {
    e.listFlag ? (o("success"), e.listFlag = false) : (r.value.forEach((u) => {
      u.listFlag = false;
    }), o("success", e), e.listFlag = true);
  }
  function y(e) {
    e.warehouseListFlag ? (o("auditSuccess"), e.warehouseListFlag = false) : (l.warehouseList.forEach((u) => {
      u.warehouseListFlag = false;
    }), o("auditSuccess", e), e.warehouseListFlag = true);
  }
  return (e, u) => {
    const g = x;
    return a(), t(n, null, [h(f)(r.value) ? (a(), t("div", C, [(a(true), t(n, null, _(r.value, (s) => (a(), t("div", { key: s.id, class: p(`workshop ${s.listFlag ? "is-workshop" : ""} ${l.showWarehouseList ? "workshop-2 " : ""}`), onClick: (L) => k(s) }, [F("div", S, d(s == null ? void 0 : s.name), 1), i.showWarehouseWeight ? (a(), t("div", $, d(s == null ? void 0 : s.sumWeight), 1)) : c("", true)], 10, E))), 128))])) : c("", true), h(f)(r.value) ? c("", true) : (a(), W(g, { key: 1, description: "暂无数据" })), l.showWarehouseList ? (a(), t("div", N, [(a(true), t(n, null, _(i.warehouseList, (s) => (a(), t("div", { key: s.id, class: p(s.warehouseListFlag ? "warehouse-list is-warehouse-list" : "warehouse-list "), onClick: (L) => y(s) }, d(s.name), 11, m))), 128))])) : c("", true)], 64);
  };
} }, j = B(A, [["__scopeId", "data-v-40d340a9"]]);
export {
  j as default
};
