import { ref as _ } from "vue";
import { reactive as C } from "vue";
import { provide as S } from "vue";
import { watch as O } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as j } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as u } from "vue";
import { unref as a } from "vue";
import { withDirectives as L } from "vue";
import { createBlock as s } from "vue";
import { withCtx as y } from "vue";
import { createCommentVNode as l } from "vue";
import { toDisplayString as b } from "vue";
import { normalizeClass as P } from "vue";
import { ElTableColumn as V } from "element-plus";
import { vLoading as I } from "element-plus";
import { _ as B, x as H, q4 as D, c6 as q, o as A, i as g, c7 as F, G, c8 as U, K, mv as f, bN as M, c1 as Y, P as z } from "../../../shared/runtime.js";
import Q from "./module/header.vue.js";
import J from "./project-chart/index.vue.js";
import "../../../modules/index-5b9e6004.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
import "./project-chart/module/chart.vue.js";
import "../../../modules/index-18acf776.js";
const W = { class: "app-wrap" }, X = { class: "project-chart" }, Z = { class: "app-container" }, $ = { class: "head-container" }, ee = { __name: "index", setup(ae) {
  const v = { add: false, edit: false, del: false, download: false }, w = _([["createTime", "parse-time"], ["startDate", ["parse-time", "{y}-{m}-{d}"]], ["endDate", ["parse-time", "{y}-{m}-{d}"]], ["completeDate", ["parse-time", "{y}-{m}-{d}"]]]), p = C({ summary: {}, provinceList: [], loading: true }), h = _(), d = _();
  S("projectInfo", p);
  const { crud: n, columns: r, CRUD: T } = H({ title: "我的项目", permission: { ...D }, optShow: { ...v }, crudApi: { get: q }, invisibleColumns: ["name", "completeDate", "createTime"], hasPagination: true }, h);
  O(() => d, (o) => {
    N(), n.query.year !== o.value && (n.query.year = o.value, n.toQuery());
  }, { deep: true });
  const { maxHeight: x } = A({ paginate: true });
  T.HOOK.handleRefresh = (o, m) => {
    m.data.content = m.data.content.map((e) => (e.allDays = "", g(e.startDate) && g(e.endDate) && (e.allDays = F(e.startDate, e.endDate)), e));
  };
  async function N() {
    if (G(D.statistics)) {
      p.loading = true;
      try {
        const o = await U({ year: d.value, projectType: K.STEEL.V, lumpSumSystemType: f.NEED_FACTORY_PROCESSING_NO_CONTROL.V | f.NEED_FACTORY_PROCESSING_NEED_CONTROL.V | f.OTHER.V }) || {};
        p.provinceList = o.provinceList, delete o.provinceList, p.summary = o;
      } catch (o) {
        console.log("获取项目汇总图表数据", o);
      } finally {
        p.loading = false;
      }
    }
  }
  return (o, m) => {
    const e = V, k = R("common-table"), E = I;
    return t(), j("div", W, [c("div", X, [u(a(J), { year: d.value, "onUpdate:year": m[0] || (m[0] = (i) => d.value = i) }, null, 8, ["year"])]), c("div", Z, [c("div", $, [u(a(Q))]), L((t(), s(k, { ref_key: "tableRef", ref: h, data: a(n).data, "data-format": w.value, "empty-text": a(n).emptyText, "max-height": a(x), style: { width: "100%" } }, { default: y(() => [u(e, { prop: "index", label: "序号", align: "center", width: "60", type: "index", fixed: "left" }), a(r).visible("serialNumber") ? (t(), s(e, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, "min-width": "130", align: "center", label: "合同编号", fixed: "left" })) : l("", true), a(r).visible("name") ? (t(), s(e, { key: "name", prop: "name", "show-overflow-tooltip": true, "min-width": "150", align: "center", label: "项目名称" })) : l("", true), a(r).visible("shortName") ? (t(), s(e, { key: "shortName", prop: "shortName", "show-overflow-tooltip": true, "min-width": "140", align: "center", label: "项目简称" })) : l("", true), a(r).visible("businessType") ? (t(), s(e, { key: "businessType", prop: "businessType", label: "业务类型", align: "center", "min-width": "100" }, { default: y((i) => [c("span", null, b(i.row.businessType && a(M).VL[i.row.businessType]), 1)]), _: 1 })) : l("", true), a(r).visible("status") ? (t(), s(e, { key: "status", prop: "status", label: "状态", width: "90", align: "center" }, { default: y((i) => [c("span", null, b(a(Y).VL[i.row.status]), 1)]), _: 1 })) : l("", true), a(r).visible("startDate") ? (t(), s(e, { key: "startDate", prop: "startDate", label: "计划开工日期", align: "center", width: "110" })) : l("", true), a(r).visible("endDate") ? (t(), s(e, { key: "endDate", prop: "endDate", label: "计划完成日期", align: "center", width: "110" })) : l("", true), a(r).visible("completeDate") ? (t(), s(e, { key: "completeDate", prop: "completeDate", label: "完工日期", align: "center", width: "110" })) : l("", true), a(r).visible("allDays") ? (t(), s(e, { key: "allDays", prop: "allDays", label: "工期(天)", align: "center", width: "100" })) : l("", true), a(r).visible("alreadyDays") ? (t(), s(e, { key: "alreadyDays", prop: "alreadyDays", label: "已用时(天)", align: "center", width: "100" }, { default: y(({ row: i }) => [c("span", { class: P(i.alreadyDays > i.allDays ? "table-alreadyDays" : "") }, b(i.alreadyDays >= 0 ? i.alreadyDays : "-"), 3)]), _: 1 })) : l("", true), a(r).visible("createTime") ? (t(), s(e, { key: "createTime", prop: "createTime", label: "创建时间", align: "center", width: "130" })) : l("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[E, a(n).loading]]), u(a(z))])]);
  };
} }, pe = B(ee, [["__scopeId", "data-v-bba47c55"]]);
export {
  pe as default
};
