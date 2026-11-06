import { ref as _ } from "vue";
import { provide as B } from "vue";
import { resolveComponent as M } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as T } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as s } from "vue";
import { unref as l } from "vue";
import { withDirectives as K } from "vue";
import { createBlock as m } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as o } from "vue";
import { createCommentVNode as b } from "vue";
import { createTextVNode as d } from "vue";
import { Fragment as D } from "vue";
import { renderList as v } from "vue";
import { ElTableColumn as U } from "element-plus";
import { vLoading as F } from "element-plus";
import { c as J, g as $ } from "../../../../modules/loss-and-work-in-progress-statistics-3ddf318f.js";
import { x as Q, so as z, o as G, si as C, P as X, a3 as A } from "../../../../shared/runtime.js";
import Y from "./module/header.vue.js";
import Z from "./module/detail.vue.js";
import "./details/production-scheduling-details/index.vue.js";
import "./details/production-scheduling-details/module/header.vue.js";
import "../../../../modules/process-select-b35dffc0.js";
import "../../../../modules/raf-ac2cc4f2.js";
import "../../../../modules/use-process-af1f8c99.js";
import "../../../../modules/use-scheduling-groups-e49a6ba2.js";
import "../../../../modules/artifact-f1b0ca44.js";
import "./details/material-requisition-statistics/index.vue.js";
import "./details/material-requisition-statistics/module/header.vue.js";
import "./details/feeding-statistics/index.vue.js";
import "./details/feeding-statistics/module/header.vue.js";
const tt = { class: "app-container" }, et = { class: "head-container" }, at = ["onClick"], it = ["onClick"], yt = { __name: "index", setup(lt, { expose: L }) {
  const S = _(), R = _(), q = { batchAdd: false, add: false, edit: false, del: false, download: false }, { crud: f, columns: h, CRUD: V } = Q({ title: "损耗及在制品统计", optShow: { ...q }, permission: { ...z }, sort: [], crudApi: { ...J }, queryOnPresenterCreated: false, hasPagination: true }, S), { maxHeight: j } = G({ paginate: true }), k = _([]), N = _([]), W = _([]), P = _([]), O = _(false);
  async function H() {
    try {
      const { content: c = [] } = await $(), p = (e, x) => {
        e.value = c.filter((w) => w.productType === x).sort((w, t) => w.sort - t.sort);
      };
      p(k, A.MACHINE_PART.V), p(N, A.ASSEMBLE.V), p(W, A.ARTIFACT.V);
    } catch (c) {
      console.log("获取零件部件构件工序列表", c);
    }
  }
  function E(c) {
    R.value = c, O.value = true;
  }
  V.HOOK.beforeToQuery = () => {
    H();
  }, V.HOOK.handleRefresh = async (c, { data: p }) => {
    var e;
    (e = p.content) != null && e.length || (k.value = [], N.value = [], W.value = []);
  };
  const g = (c, p, e) => {
    var x, w;
    return ((w = (x = c == null ? void 0 : c[e]) == null ? void 0 : x.statisticsDetailDTOS) == null ? void 0 : w.find((t) => t.processId === p.id)) || {};
  };
  function I(c) {
    if (c.length > 1) {
      const p = c[c.length - 1];
      P.value = [p], S.value && (S.value.clearSelection(), S.value.toggleRowSelection(p, true));
    } else P.value = c;
  }
  return B("selectedRows", P), L({ query: f.query }), (c, p) => {
    const e = U, x = M("common-table"), w = F;
    return u(), T("div", tt, [y("div", et, [s(l(Y), { selectedRows: P.value }, null, 8, ["selectedRows"])]), K((u(), m(x, { ref_key: "tableRef", ref: S, data: l(f).data, "empty-text": l(f).emptyText, "max-height": l(j), "row-key": "id", style: { width: "100%", cursor: "pointer" }, onSelectionChange: I }, { default: i(() => [s(e, { type: "selection", width: "55", align: "center" }), s(e, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), l(h).visible("project") && l(f).query.projectOrWorkShopEnum === l(C).PROJECT.V ? (u(), m(e, { label: "项目", prop: "project", key: "project", "show-overflow-tooltip": "", align: "center", "min-width": "240px", fixed: "left" }, { default: i((t) => [y("span", { style: { color: "#409eff", cursor: "pointer" }, onClick: (n) => E(t.row) }, o(t.row.serialNumber) + " - " + o(t.row.shortName), 9, at)]), _: 1 })) : b("", true), l(h).visible("name") && l(f).query.projectOrWorkShopEnum === l(C).WORKSHOP.V ? (u(), m(e, { label: "生产车间", prop: "name", key: "name", "show-overflow-tooltip": "", align: "center", "min-width": "240px", fixed: "left" }, { default: i((t) => [y("span", { style: { color: "#409eff", cursor: "pointer" }, onClick: (n) => E(t.row) }, o(t.row.name || "-"), 9, it)]), _: 1 })) : b("", true), l(h).visible("totalArtifactNetWeight") && l(f).query.projectOrWorkShopEnum === l(C).PROJECT.V ? (u(), m(e, { label: "清单量", prop: "totalArtifactNetWeight", key: "totalArtifactNetWeight", align: "center", fixed: "left", "min-width": "100px" }, { default: i((t) => [y("span", null, o(t.row.totalArtifactNetWeight ?? "-"), 1)]), _: 1 })) : b("", true), l(h).visible("totalArtifactTaskNetWeight") ? (u(), m(e, { label: "累计排产量", prop: "totalArtifactTaskNetWeight", key: "totalArtifactTaskNetWeight", align: "center", "min-width": "100px", fixed: "left" }, { default: i((t) => [y("span", null, o(t.row.totalArtifactTaskNetWeight || "-"), 1)]), _: 1 })) : b("", true), l(h).visible("machinePart") ? (u(), m(e, { label: "零件", prop: "machinePart", key: "machinePart", align: "center" }, { default: i(() => [s(e, { label: "累计领料量", align: "center", "min-width": "100px" }, { default: i((t) => {
      var n;
      return [d(o(((n = t.row.partProgressStatisticsDTO) == null ? void 0 : n.totalPickingWeight) ?? "-"), 1)];
    }), _: 1 }), s(e, { label: "排产量", align: "center", "min-width": "100px" }, { default: i((t) => {
      var n;
      return [d(o(((n = t.row.partProgressStatisticsDTO) == null ? void 0 : n.totalSchedulingNetWeight) ?? "-"), 1)];
    }), _: 1 }), (u(true), T(D, null, v(k.value, (t, n) => (u(), m(e, { key: n, label: t.name, align: "center" }, { default: i(() => [s(e, { label: "任务量", align: "center", "min-width": "100px" }, { default: i((r) => {
      var a;
      return [d(o(((a = g(r.row, t, "partProgressStatisticsDTO")) == null ? void 0 : a.totalTaskNetWeight) ?? "-"), 1)];
    }), _: 2 }, 1024), s(e, { label: "制成品", align: "center", "min-width": "100px" }, { default: i((r) => {
      var a;
      return [d(o(((a = g(r.row, t, "partProgressStatisticsDTO")) == null ? void 0 : a.totalCompleteNetWeight) ?? "-"), 1)];
    }), _: 2 }, 1024), s(e, { label: "待制品", align: "center", "min-width": "100px" }, { default: i((r) => {
      var a;
      return [d(o(((a = g(r.row, t, "partProgressStatisticsDTO")) == null ? void 0 : a.totalInProductionNetWeight) ?? "-"), 1)];
    }), _: 2 }, 1024), s(e, { label: "损耗", align: "center", "min-width": "100px" }, { default: i((r) => {
      var a;
      return [d(o(((a = g(r.row, t, "partProgressStatisticsDTO")) == null ? void 0 : a.totalLossWeight) ?? "-"), 1)];
    }), _: 2 }, 1024), s(e, { label: "损耗率", align: "center", "min-width": "100px" }, { default: i((r) => {
      var a;
      return [d(o(((a = g(r.row, t, "partProgressStatisticsDTO")) == null ? void 0 : a.totalLossRate) ?? "-"), 1)];
    }), _: 2 }, 1024)]), _: 2 }, 1032, ["label"]))), 128))]), _: 1 })) : b("", true), l(h).visible("assemble") ? (u(), m(e, { label: "部件", prop: "assemble", key: "assemble", align: "center" }, { default: i(() => [s(e, { label: "排产量", align: "center", "min-width": "100px" }, { default: i((t) => {
      var n;
      return [d(o(((n = t.row.assembleProgressStatisticsDTO) == null ? void 0 : n.totalSchedulingNetWeight) ?? "-"), 1)];
    }), _: 1 }), (u(true), T(D, null, v(N.value, (t, n) => (u(), m(e, { key: n, label: t.name, align: "center" }, { default: i(() => [s(e, { label: "任务量", align: "center", "min-width": "100px" }, { default: i((r) => {
      var a;
      return [d(o(((a = g(r.row, t, "assembleProgressStatisticsDTO")) == null ? void 0 : a.totalTaskNetWeight) ?? "-"), 1)];
    }), _: 2 }, 1024), s(e, { label: "完成", align: "center", "min-width": "100px" }, { default: i((r) => {
      var a;
      return [d(o(((a = g(r.row, t, "assembleProgressStatisticsDTO")) == null ? void 0 : a.totalCompleteNetWeight) ?? "-"), 1)];
    }), _: 2 }, 1024), s(e, { label: "在制", align: "center", "min-width": "100px" }, { default: i((r) => {
      var a;
      return [d(o(((a = g(r.row, t, "assembleProgressStatisticsDTO")) == null ? void 0 : a.totalInProductionNetWeight) ?? "-"), 1)];
    }), _: 2 }, 1024)]), _: 2 }, 1032, ["label"]))), 128))]), _: 1 })) : b("", true), l(h).visible("artifact") ? (u(), m(e, { label: "构件", prop: "artifact", key: "artifact", align: "center" }, { default: i(() => [s(e, { label: "排产量", align: "center", "min-width": "100px" }, { default: i((t) => {
      var n;
      return [d(o(((n = t.row.artifactProgressStatisticsDTO) == null ? void 0 : n.totalSchedulingNetWeight) ?? "-"), 1)];
    }), _: 1 }), (u(true), T(D, null, v(W.value, (t, n) => (u(), m(e, { key: n, label: t.name, align: "center" }, { default: i(() => [s(e, { label: "任务量", align: "center", "min-width": "100px" }, { default: i((r) => {
      var a;
      return [d(o(((a = g(r.row, t, "artifactProgressStatisticsDTO")) == null ? void 0 : a.totalTaskNetWeight) ?? "-"), 1)];
    }), _: 2 }, 1024), s(e, { label: "完成", align: "center", "min-width": "100px" }, { default: i((r) => {
      var a;
      return [d(o(((a = g(r.row, t, "artifactProgressStatisticsDTO")) == null ? void 0 : a.totalCompleteNetWeight) ?? "-"), 1)];
    }), _: 2 }, 1024), s(e, { label: "在制", align: "center", "min-width": "100px" }, { default: i((r) => {
      var a;
      return [d(o(((a = g(r.row, t, "artifactProgressStatisticsDTO")) == null ? void 0 : a.totalInProductionNetWeight) ?? "-"), 1)];
    }), _: 2 }, 1024)]), _: 2 }, 1032, ["label"]))), 128))]), _: 1 })) : b("", true), l(h).visible("totalArtifactCompleteNetWeight") ? (u(), m(e, { label: "制成品", prop: "totalArtifactCompleteNetWeight", key: "totalArtifactCompleteNetWeight", align: "center", "min-width": "100px", fixed: "right" }, { default: i((t) => [y("span", null, o(t.row.totalArtifactCompleteNetWeight ?? "-"), 1)]), _: 1 })) : b("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[w, l(f).loading]]), s(l(X)), s(l(Z), { modelValue: O.value, "onUpdate:modelValue": p[0] || (p[0] = (t) => O.value = t), currentRow: R.value, query: l(f).query }, null, 8, ["modelValue", "currentRow", "query"])]);
  };
} };
export {
  yt as default
};
