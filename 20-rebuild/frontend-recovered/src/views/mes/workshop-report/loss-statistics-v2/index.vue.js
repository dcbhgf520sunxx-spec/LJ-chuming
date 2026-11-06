import { ref as h } from "vue";
import { computed as E } from "vue";
import { provide as C } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as o } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as n } from "vue";
import { unref as r } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as L } from "vue";
import { withCtx as l } from "vue";
import { toDisplayString as t } from "vue";
import { normalizeStyle as m } from "vue";
import { resolveDynamicComponent as O } from "vue";
import { nextTick as $ } from "vue";
import { ElTableColumn as q } from "element-plus";
import { vLoading as A } from "element-plus";
import { c as M } from "../../../../modules/loss-statistics-v2-49b9ac9b.js";
import { a as N } from "../../../../modules/common-f216149e.js";
import { _ as U, x as H, sp as j, o as I, qw as w, sq as D, P as z } from "../../../../shared/runtime.js";
import G from "./module/header.vue.js";
import J from "./module/production-scheduling-list.vue.js";
import K from "./module/work-report-details.vue.js";
import Q from "./module/feeding-details.vue.js";
import X from "./module/receive-detail.vue.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const Y = { class: "app-container" }, Z = { class: "head-container" }, ee = ["onClick"], te = { key: 1 }, ie = ["onClick"], oe = { key: 1 }, se = ["onClick"], ne = { key: 3 }, re = ["onClick"], le = { key: 1 }, ae = ["onClick"], pe = { key: 1 }, ge = ["onClick"], ce = { key: 3 }, de = ["onClick"], he = { key: 1 }, ue = { __name: "index", setup(_e) {
  const y = h(), W = h({}), { crud: _ } = H({ title: "损耗统计", sort: [], permission: { ...j }, crudApi: { ...M }, hasPagination: true }, y), v = h([]), u = h(), R = h(), k = h(false), { maxHeight: x } = I({ paginate: true });
  function d(a, g, s) {
    u.value = g, R.value = s, $(() => {
      k.value = true;
    }), W.value = a;
  }
  function f(a) {
    return a > 0 ? "#18b95e" : a < 0 ? "#f00a0a" : "";
  }
  const T = E(() => u.value === "productionSchedulingList" ? J : u.value === "workReportDetails" ? K : u.value === "feedingDetails" ? Q : u.value === "receiveDetail" ? X : null);
  async function P() {
    try {
      const { content: a } = await N();
      v.value = a;
    } catch (a) {
      console.log(a);
    }
  }
  return P(), C("branchList", v), C("query", _.query), (a, g) => {
    const s = q, F = B("common-table"), V = A;
    return i(), o("div", Y, [c("div", Z, [n(r(G))]), S((i(), L(F, { ref_key: "tableRef", ref: y, data: r(_).data, "empty-text": r(_).emptyText, "max-height": r(x), "show-empty-symbol": false, style: { width: "100%" } }, { default: l(() => [n(s, { type: "index", prop: "index", label: "序号", align: "center", width: "60px", fixed: "left" }), n(s, { label: "项目", prop: "createTime", key: "createTime", "show-overflow-tooltip": "", align: "center", "min-width": "140" }, { default: l((e) => {
      var p, b;
      return [c("span", null, t((p = e.row.project) == null ? void 0 : p.serialNumber) + " - " + t((b = e.row.project) == null ? void 0 : b.shortName), 1)];
    }), _: 1 }), n(s, { label: "排产量（kg）", prop: "schedulingWeight", key: "schedulingWeight", align: "center" }, { default: l((e) => [e.row.schedulingWeight ? (i(), o("span", { key: 0, class: "pointer", onClick: (p) => d(e.row, "productionSchedulingList") }, t(e.row.schedulingWeight), 9, ee)) : (i(), o("span", te, t(e.row.schedulingWeight ?? "-"), 1))]), _: 1 }), n(s, { label: "钢板投料量/领料量（kg）", prop: "steelFeedingWeight", key: "steelFeedingWeight", align: "center", "min-width": "120" }, { default: l((e) => [e.row.steelFeedingWeight ? (i(), o("span", { key: 0, class: "pointer", onClick: (p) => d(e.row, "feedingDetails", r(w).BOARD.V) }, t(e.row.steelFeedingWeight), 9, ie)) : (i(), o("span", oe, t(e.row.steelFeedingWeight ?? "-"), 1)), g[1] || (g[1] = c("span", null, " / ", -1)), e.row.steelPickingWeight ? (i(), o("span", { key: 2, class: "pointer", onClick: (p) => d(e.row, "receiveDetail", r(w).BOARD.V) }, t(e.row.steelPickingWeight), 9, se)) : (i(), o("span", ne, t(e.row.steelPickingWeight ?? "-"), 1))]), _: 1 }), n(s, { label: "板材零件报工量（kg）", prop: "steelReportWeight", key: "steelReportWeight", align: "center", "min-width": "120" }, { default: l((e) => [e.row.steelReportWeight ? (i(), o("span", { key: 0, class: "pointer", onClick: (p) => d(e.row, "workReportDetails", r(D).STEEL_PLATE_PRODUCT.V) }, t(e.row.steelReportWeight), 9, re)) : (i(), o("span", le, t(e.row.steelReportWeight ?? "-"), 1))]), _: 1 }), n(s, { label: "钢板损耗", prop: "steelLossWeight", key: "steelLossWeight", align: "center" }, { default: l((e) => [c("span", { style: m({ color: f(e.row.steelLossWeight) }) }, t(e.row.steelLossWeight ?? "-"), 5)]), _: 1 }), n(s, { label: "型材投料量/领料量（kg）", prop: "profilesFeedingWeight", key: "profilesFeedingWeight", align: "center", "min-width": "120" }, { default: l((e) => [e.row.profilesFeedingWeight ? (i(), o("span", { key: 0, class: "pointer", onClick: (p) => d(e.row, "feedingDetails", r(w).MODEL.V) }, t(e.row.profilesFeedingWeight), 9, ae)) : (i(), o("span", pe, t(e.row.profilesFeedingWeight ?? "-"), 1)), g[2] || (g[2] = c("span", null, " / ", -1)), e.row.profilesPickingWeight ? (i(), o("span", { key: 2, class: "pointer", onClick: (p) => d(e.row, "receiveDetail", r(w).MODEL.V) }, t(e.row.profilesPickingWeight), 9, ge)) : (i(), o("span", ce, t(e.row.profilesPickingWeight ?? "-"), 1))]), _: 1 }), n(s, { label: "型材零件报工量（kg）", prop: "profilesReportWeight", key: "profilesReportWeight", align: "center", "min-width": "120" }, { default: l((e) => [e.row.profilesReportWeight ? (i(), o("span", { key: 0, class: "pointer", onClick: (p) => d(e.row, "workReportDetails", r(D).SECTION_PRODUCT.V) }, t(e.row.profilesReportWeight), 9, de)) : (i(), o("span", he, t(e.row.profilesReportWeight ?? "-"), 1))]), _: 1 }), n(s, { label: "型材损耗", prop: "profilesLossWeight", key: "profilesLossWeight", align: "center" }, { default: l((e) => [c("span", { style: m({ color: f(e.row.profilesLossWeight) }) }, t(e.row.profilesLossWeight ?? "-"), 5)]), _: 1 }), n(s, { label: "综合损耗", prop: "totalLossWeight", key: "totalLossWeight", align: "center" }, { default: l((e) => [c("span", { style: m({ color: f(e.row.totalLossWeight) }) }, t(e.row.totalLossWeight ?? "-"), 5)]), _: 1 }), n(s, { label: "损耗率", prop: "lossRate", key: "lossRate", align: "center" }, { default: l((e) => [c("span", { style: m({ color: f(e.row.lossRate) }) }, t(e.row.lossRate ?? "-") + "%", 5)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[V, r(_).loading]]), n(z), (i(), L(O(T.value), { visible: k.value, "onUpdate:visible": g[0] || (g[0] = (e) => k.value = e), currentRow: W.value, partType: R.value }, null, 40, ["visible", "currentRow", "partType"]))]);
  };
} }, De = U(ue, [["__scopeId", "data-v-a095e591"]]);
export {
  De as default
};
