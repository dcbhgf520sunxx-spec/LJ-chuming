import { reactive as L } from "vue";
import { ref as R } from "vue";
import { provide as V } from "vue";
import { watch as B } from "vue";
import { resolveComponent as E } from "vue";
import { resolveDirective as D } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as f } from "vue";
import { createElementVNode as o } from "vue";
import { createVNode as b } from "vue";
import { unref as t } from "vue";
import { withDirectives as d } from "vue";
import { createBlock as l } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as i } from "vue";
import { createTextVNode as v } from "vue";
import { normalizeClass as I } from "vue";
import { ElTableColumn as S } from "element-plus";
import { vLoading as H } from "element-plus";
import { _ as q, x as M, c6 as O, o as U, i as g, c7 as z, G as A, c8 as G, bN as K, c1 as Q, P as F } from "../../../shared/runtime.js";
import { l as x } from "../../../modules/plan-d12d7ccf.js";
import J from "./module/header.vue.js";
import "../../../modules/index-5b9e6004.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
const W = { class: "app-wrap" }, X = { class: "app-container" }, Y = { class: "head-container" }, Z = { __name: "index", setup($) {
  const k = { add: false, edit: false, del: false, download: false }, u = L({ summary: {}, provinceList: [], loading: true }), h = R();
  V("projectInfo", u);
  const { crud: p, columns: r, CRUD: T } = M({ title: "我的项目", permission: { ...x }, optShow: { ...k }, crudApi: { get: O }, invisibleColumns: ["name", "completeDate", "createTime"], hasPagination: true }, h);
  B(() => p.query.year, (c) => {
    C(), p.toQuery();
  }, { deep: true });
  const { maxHeight: N } = U({ paginate: true });
  T.HOOK.handleRefresh = (c, _) => {
    _.data.content = _.data.content.map((a) => (a.allDays = "", g(a.startDate) && g(a.endDate) && (a.allDays = z(a.startDate, a.endDate)), a));
  };
  async function C() {
    if (A(x.statistics)) {
      u.loading = true;
      try {
        const c = await G({ year: p.query.year }) || {};
        u.provinceList = c.provinceList, delete c.provinceList, u.summary = c;
      } catch (c) {
        console.log("获取项目汇总图表数据", c);
      } finally {
        u.loading = false;
      }
    }
  }
  return (c, _) => {
    const a = S, P = E("common-table"), w = D("empty-text"), y = D("parse-time"), j = H;
    return s(), f("div", W, [o("div", X, [o("div", Y, [b(t(J))]), d((s(), l(P, { ref_key: "tableRef", ref: h, data: t(p).data, "empty-text": t(p).emptyText, "max-height": t(N), style: { width: "100%" }, "return-source-data": "", showEmptySymbol: false }, { default: n(() => [b(a, { prop: "index", label: "序号", align: "center", width: "60", type: "index", fixed: "left" }), t(r).visible("serialNumber") ? (s(), l(a, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, "min-width": "130", align: "center", label: "合同编号", fixed: "left" }, { default: n(({ row: e }) => [o("span", null, m(e.serialNumber), 1)]), _: 1 })) : i("", true), t(r).visible("name") ? (s(), l(a, { key: "name", prop: "name", "show-overflow-tooltip": true, "min-width": "150", align: "center", label: "项目名称" })) : i("", true), t(r).visible("shortName") ? (s(), l(a, { key: "shortName", prop: "shortName", "show-overflow-tooltip": true, "min-width": "140", align: "center", label: "项目简称" })) : i("", true), t(r).visible("businessType") ? (s(), l(a, { key: "businessType", prop: "businessType", label: "业务类型", align: "center", "min-width": "100" }, { default: n((e) => [d((s(), f("span", null, [v(m(e.row.businessType && t(K).VL[e.row.businessType]), 1)])), [[w]])]), _: 1 })) : i("", true), t(r).visible("status") ? (s(), l(a, { key: "status", prop: "status", label: "状态", width: "90", align: "center" }, { default: n((e) => [d((s(), f("span", null, [v(m(t(Q).VL[e.row.status]), 1)])), [[w]])]), _: 1 })) : i("", true), t(r).visible("startDate") ? (s(), l(a, { key: "startDate", prop: "startDate", label: "计划开工日期", align: "center", width: "110" }, { default: n((e) => [d(o("span", null, null, 512), [[y, { val: e.row.startDate, fmt: "{y}-{m}-{d}" }]])]), _: 1 })) : i("", true), t(r).visible("endDate") ? (s(), l(a, { key: "endDate", prop: "endDate", label: "计划完成日期", align: "center", width: "110" }, { default: n((e) => [d(o("span", null, null, 512), [[y, { val: e.row.endDate, fmt: "{y}-{m}-{d}" }]])]), _: 1 })) : i("", true), t(r).visible("completeDate") ? (s(), l(a, { key: "completeDate", prop: "completeDate", label: "完成日期", align: "center", width: "110" }, { default: n((e) => [d(o("span", null, null, 512), [[y, { val: e.row.completeDate, fmt: "{y}-{m}-{d}" }]])]), _: 1 })) : i("", true), t(r).visible("allDays") ? (s(), l(a, { key: "allDays", prop: "allDays", label: "工期(天)", align: "center", width: "100" }, { default: n((e) => [o("div", null, m(e.row.allDays), 1)]), _: 1 })) : i("", true), t(r).visible("alreadyDays") ? (s(), l(a, { key: "alreadyDays", prop: "alreadyDays", label: "已用时(天)", align: "center", width: "100" }, { default: n((e) => [o("div", { class: I(e.row.alreadyDays > e.row.allDays ? "table-alreadyDays" : "") }, m(e.row.alreadyDays >= 0 ? e.row.alreadyDays : "-"), 3)]), _: 1 })) : i("", true), t(r).visible("createTime") ? (s(), l(a, { key: "createTime", prop: "createTime", label: "创建时间", align: "center", width: "100" }, { default: n((e) => [d(o("span", null, null, 512), [[y, { val: e.row.createTime, fmt: "{y}-{m}-{d}" }]])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[j, t(p).loading]]), b(t(F))])]);
  };
} }, ie = q(Z, [["__scopeId", "data-v-027a1a5a"]]);
export {
  ie as default
};
