import { ref as w } from "vue";
import { provide as k } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as c } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as i } from "vue";
import { unref as a } from "vue";
import { withDirectives as M } from "vue";
import { createBlock as q } from "vue";
import { withCtx as d } from "vue";
import { toDisplayString as h } from "vue";
import { withModifiers as E } from "vue";
import { createCommentVNode as O } from "vue";
import { ElTableColumn as U } from "element-plus";
import { vLoading as j } from "element-plus";
import { c as A } from "../../../../modules/team-payroll-summary-1754395b.js";
import { P as F } from "../../../../modules/base-6bc46ddf.js";
import { x as G, ql as T, o as K, i as v, bV as B, G as W, P as z } from "../../../../shared/runtime.js";
import Q from "./module/header.vue.js";
import Y from "./module/detail.vue.js";
import "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../modules/index-c07af747.js";
import "../../../../modules/process-select-b35dffc0.js";
import "../../../../modules/raf-ac2cc4f2.js";
import "../../../../modules/use-process-af1f8c99.js";
const $ = { class: "app-container" }, J = { class: "head-container" }, X = { key: 0 }, Z = { key: 1 }, ee = { key: 0 }, te = { key: 1 }, oe = { key: 0 }, ae = { key: 1 }, ye = { __name: "index", setup(ne) {
  const D = w(), { crud: l, CRUD: x } = G({ title: "班组工资汇总", permission: { ...T }, crudApi: { ...A }, sort: [], hasPagination: true }, D), g = w(false), C = w(), { maxHeight: H } = K({ paginate: true }), _ = w(), f = w(), y = w();
  k("query", l.query), x.HOOK.handleRefresh = async (o, { data: s }) => {
    s.content = s.content.map((e) => {
      var n, u, p, t, m, P, S, V;
      return e.workshopId = ((n = e.workshop) == null ? void 0 : n.id) || void 0, e.workshopName = ((u = e.workshop) == null ? void 0 : u.name) || void 0, e.projectId = ((p = e.project) == null ? void 0 : p.id) || void 0, e.teamId = ((t = e.team) == null ? void 0 : t.id) || void 0, e.teamName = ((m = e.team) == null ? void 0 : m.name) || void 0, e.productId = ((P = e.product) == null ? void 0 : P.id) || void 0, e.processId = ((S = e.process) == null ? void 0 : S.id) || void 0, e.processName = ((V = e.process) == null ? void 0 : V.name) || void 0, e;
    });
  };
  function I(o) {
    g.value = true, C.value = o;
  }
  async function L() {
    try {
      const o = await F();
      if (o != null && o.wageStatisticsDeadline) {
        const s = /* @__PURE__ */ new Date();
        let e = s.getFullYear(), n = s.getMonth();
        n === 0 ? (e -= 1, n = 11) : n -= 1, _.value = new Date(e, n, 1, 0, 0, 0).getTime();
        const u = new Date(e, n + 1, 0).getDate(), p = Math.min(o == null ? void 0 : o.wageStatisticsDeadline, u);
        f.value = new Date(e, n, p, 23, 59, 59).getTime();
      } else f.value = void 0;
      y.value = (o == null ? void 0 : o.wageDisplayPrecision) ?? void 0;
    } catch (o) {
      console.log(o);
    }
  }
  let N = false;
  return x.HOOK.beforeToQuery = async () => {
    N || (await L(), l.query.date = [_.value, f.value], l.query.startDate = _.value, l.query.endDate = f.value, N = true);
  }, k("deadline", f), k("wageDisplayPrecision", y), (o, s) => {
    const e = U, n = R("common-button"), u = R("common-table"), p = j;
    return r(), c("div", $, [b("div", J, [i(a(Q))]), M((r(), q(u, { ref_key: "tableRef", ref: D, data: a(l).data, "empty-text": a(l).emptyText, "max-height": a(H), "return-source-data": "", showEmptySymbol: false, style: { width: "100%" }, "row-key": "id" }, { default: d(() => [i(e, { label: "序号", type: "index", align: "center", width: "60" }), i(e, { key: "workshopName", prop: "workshopName", "show-overflow-tooltip": "", label: "车间", align: "center" }, { default: d((t) => [b("span", null, h(t.row.workshopName || "-"), 1)]), _: 1 }), i(e, { key: "teamName", prop: "teamName", "show-overflow-tooltip": "", label: "班组", align: "center", width: "100" }, { default: d((t) => [b("span", null, h(t.row.teamName || "-"), 1)]), _: 1 }), i(e, { key: "unit", prop: "unit", "show-overflow-tooltip": "", label: "单位", align: "center", width: "100" }), i(e, { key: "productionVolume", prop: "productionVolume", "show-overflow-tooltip": "", label: "产量", align: "center" }, { default: d((t) => {
      var m;
      return [a(v)(t.row.productionVolume) ? (r(), c("span", X, h((m = t.row.productionVolume) == null ? void 0 : m.toFixed(5)), 1)) : (r(), c("span", Z, "-"))];
    }), _: 1 }), i(e, { key: "totalSalary", prop: "totalSalary", "show-overflow-tooltip": "", label: "工价（元）", align: "center" }, { default: d((t) => [a(v)(t.row.totalSalary) ? (r(), c("span", ee, h(a(B)(t.row.totalSalary, y.value)), 1)) : (r(), c("span", te, "-"))]), _: 1 }), i(e, { key: "averageLaborCost", prop: "averageLaborCost", "show-overflow-tooltip": "", label: "平均工价（元/吨）", align: "center" }, { default: d((t) => [a(v)(t.row.averageLaborCost) ? (r(), c("span", oe, h(a(B)(t.row.averageLaborCost, y.value)), 1)) : (r(), c("span", ae, "-"))]), _: 1 }), i(e, { label: "操作", align: "center", fixed: "right", width: "100" }, { default: d((t) => [a(W)(a(T).details) ? (r(), q(n, { key: 0, icon: "el-icon-view", type: "primary", size: "default", onClick: E((m) => I(t.row), ["stop"]) }, null, 8, ["onClick"])) : O("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[p, a(l).loading]]), i(a(z)), i(a(Y), { visible: g.value, "onUpdate:visible": s[0] || (s[0] = (t) => g.value = t), currentRow: C.value }, null, 8, ["visible", "currentRow"])]);
  };
} };
export {
  ye as default
};
