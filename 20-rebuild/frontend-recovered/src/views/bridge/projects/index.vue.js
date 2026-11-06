import { ref as f } from "vue";
import { reactive as C } from "vue";
import { provide as P } from "vue";
import { watch as L } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as E } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as u } from "vue";
import { unref as t } from "vue";
import { withDirectives as I } from "vue";
import { createBlock as s } from "vue";
import { withCtx as b } from "vue";
import { createCommentVNode as i } from "vue";
import { toDisplayString as _ } from "vue";
import { ElTableColumn as R } from "element-plus";
import { vLoading as V } from "element-plus";
import { _ as H, x as S, c6 as q, o as M, i as g, c7 as h, G as U, c8 as A, K as G, bN as K, c1 as O, P as F } from "../../../shared/runtime.js";
import { A as w } from "../../../modules/bridge-86f96a4f.js";
import Q from "./module/header.vue.js";
import z from "./project-chart/index.vue.js";
import "../../../modules/index-5b9e6004.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
import "./project-chart/module/chart.vue.js";
import "../../../modules/index-18acf776.js";
const J = { class: "app-wrap" }, W = { class: "project-chart" }, X = { class: "app-container" }, Y = { class: "head-container" }, Z = { __name: "index", setup($) {
  const v = { add: false, edit: false, del: false, download: false }, x = f([["createTime", "parse-time"], ["startDate", ["parse-time", "{y}-{m}-{d}"]], ["endDate", ["parse-time", "{y}-{m}-{d}"]], ["completeDate", ["parse-time", "{y}-{m}-{d}"]]]), c = C({ summary: {}, provinceList: [], loading: true }), D = f(), m = f();
  P("projectInfo", c);
  const { crud: n, columns: r, CRUD: k } = S({ title: "我的项目", permission: { ...w }, optShow: { ...v }, crudApi: { get: q }, invisibleColumns: ["name", "completeDate", "createTime"], hasPagination: true }, D);
  L(() => m, (o) => {
    j(), n.query.year !== o.value && (n.query.year = o.value, n.toQuery());
  }, { deep: true });
  const { maxHeight: T } = M({ paginate: true });
  k.HOOK.handleRefresh = (o, p) => {
    p.data.content = p.data.content.map((e) => {
      if (e.allDays = "", e.alreadyDays = "", g(e.startDate)) {
        g(e.endDate) && (e.allDays = h(e.startDate, e.endDate));
        const y = e.completeDate || (/* @__PURE__ */ new Date()).getTime();
        e.alreadyDays = e.completeDate === e.endDate ? h(e.startDate, e.endDate) : h(e.startDate, y);
      }
      return e;
    });
  };
  async function j() {
    if (U(w.statistics)) {
      c.loading = true;
      try {
        const o = await A({ year: m.value, projectType: G.BRIDGE.V }) || {};
        c.provinceList = o.provinceList, delete o.provinceList, c.summary = o;
      } catch (o) {
        console.log("获取项目汇总图表数据", o);
      } finally {
        c.loading = false;
      }
    }
  }
  return (o, p) => {
    const e = R, y = B("common-table"), N = V;
    return a(), E("div", J, [d("div", W, [u(t(z), { year: m.value, "onUpdate:year": p[0] || (p[0] = (l) => m.value = l) }, null, 8, ["year"])]), d("div", X, [d("div", Y, [u(t(Q))]), I((a(), s(y, { ref_key: "tableRef", ref: D, data: t(n).data, "data-format": x.value, "empty-text": t(n).emptyText, "max-height": t(T), style: { width: "100%" } }, { default: b(() => [u(e, { prop: "index", label: "序号", align: "center", width: "60", type: "index", fixed: "left" }), t(r).visible("serialNumber") ? (a(), s(e, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, "min-width": "130", align: "center", label: "合同编号", fixed: "left" })) : i("", true), t(r).visible("name") ? (a(), s(e, { key: "name", prop: "name", "show-overflow-tooltip": true, "min-width": "150", align: "center", label: "项目名称" })) : i("", true), t(r).visible("shortName") ? (a(), s(e, { key: "shortName", prop: "shortName", "show-overflow-tooltip": true, "min-width": "140", align: "center", label: "项目简称" })) : i("", true), t(r).visible("businessType") ? (a(), s(e, { key: "businessType", prop: "businessType", label: "业务类型", align: "center", "min-width": "100" }, { default: b((l) => [d("span", null, _(l.row.businessType && t(K).VL[l.row.businessType]), 1)]), _: 1 })) : i("", true), t(r).visible("status") ? (a(), s(e, { key: "status", prop: "status", label: "状态", width: "90", align: "center" }, { default: b((l) => [d("span", null, _(t(O).VL[l.row.status]), 1)]), _: 1 })) : i("", true), t(r).visible("startDate") ? (a(), s(e, { key: "startDate", prop: "startDate", label: "计划开工日期", align: "center", width: "110" })) : i("", true), t(r).visible("endDate") ? (a(), s(e, { key: "endDate", prop: "endDate", label: "计划完成日期", align: "center", width: "110" })) : i("", true), t(r).visible("completeDate") ? (a(), s(e, { key: "completeDate", prop: "completeDate", label: "完工日期", align: "center", width: "110" })) : i("", true), t(r).visible("allDays") ? (a(), s(e, { key: "allDays", prop: "allDays", label: "工期(天)", align: "center", width: "100" })) : i("", true), t(r).visible("alreadyDays") ? (a(), s(e, { key: "alreadyDays", prop: "alreadyDays", label: "已用时(天)", align: "center", width: "100" })) : i("", true), t(r).visible("createTime") ? (a(), s(e, { key: "createTime", prop: "createTime", label: "创建时间", align: "center", width: "130" })) : i("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[N, t(n).loading]]), u(t(F))])]);
  };
} }, ce = H(Z, [["__scopeId", "data-v-91fe458e"]]);
export {
  ce as default
};
