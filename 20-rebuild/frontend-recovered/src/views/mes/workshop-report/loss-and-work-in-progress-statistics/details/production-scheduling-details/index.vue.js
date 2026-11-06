import { ref as D } from "vue";
import { computed as g } from "vue";
import { provide as j } from "vue";
import { nextTick as F } from "vue";
import { resolveComponent as q } from "vue";
import { openBlock as a } from "vue";
import { createBlock as n } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as I } from "vue";
import { toDisplayString as i } from "vue";
import { unref as t } from "vue";
import { createCommentVNode as u } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as O } from "vue";
import { withDirectives as G } from "vue";
import { createElementBlock as x } from "vue";
import { isRef as X } from "vue";
import { ElTag as Y } from "element-plus";
import { ElTableColumn as Z } from "element-plus";
import { vLoading as ee } from "element-plus";
import { l as te, x as re, u as oe, o as ae, sm as k, si as W, a3 as A, sn as se, p as le, P as ne } from "../../../../../../shared/runtime.js";
import ie from "./module/header.vue.js";
import "../../../../../../modules/loss-and-work-in-progress-statistics-3ddf318f.js";
import "../../../../../../modules/process-select-b35dffc0.js";
import "../../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../../modules/use-process-af1f8c99.js";
import "../../../../../../modules/use-scheduling-groups-e49a6ba2.js";
import "../../../../../../modules/artifact-f1b0ca44.js";
function ue(d) {
  return te({ url: "/api/mes/loss/progress/statistics/wastage/costSummary/mes/detail", method: "get", params: d });
}
const me = { get: ue }, ce = { class: "head-container" }, pe = { key: 0 }, de = { key: 1 }, Se = { __name: "index", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, minQuery: { type: Object, default: () => {
} }, datailCurrentRow: { type: Object, default: () => {
} }, currentWastageCostSummaryValueDTO: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(d, { emit: H }) {
  const Q = H, s = d, V = D(), C = D(), M = { batchAdd: false, add: false, edit: false, del: false, download: false }, { crud: m, columns: c, CRUD: L } = re({ title: "损耗统计-排产详情", optShow: { ...M }, sort: [], crudApi: { ...me }, queryOnPresenterCreated: false, hasPagination: true }, V), { visible: N, handleClose: B } = oe({ emit: Q, props: s, showHook: J, closeHook: K }), { maxHeight: U } = ae({ mainBox: ".production-scheduling-details", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, () => C.value.loaded);
  g(() => {
    var r;
    return ((r = s.currentWastageCostSummaryValueDTO) == null ? void 0 : r.lossWorkProgressStatisticsEnum) === k.SCHEDULING.V;
  });
  const E = g(() => {
    var r;
    return ((r = s.currentWastageCostSummaryValueDTO) == null ? void 0 : r.lossWorkProgressStatisticsEnum) === k.FINISHED.V;
  }), R = g(() => {
    var r;
    return ((r = s.currentWastageCostSummaryValueDTO) == null ? void 0 : r.lossWorkProgressStatisticsEnum) === k.PROCESS_TASK.V;
  }), h = g(() => {
    var r;
    return ((r = s.currentWastageCostSummaryValueDTO) == null ? void 0 : r.lossWorkProgressStatisticsEnum) === k.IN_PRODUCTION.V;
  }), _ = g(() => {
    var r;
    return ((r = s.currentWastageCostSummaryValueDTO) == null ? void 0 : r.lossWorkProgressStatisticsEnum) === k.PARTS_ALLOCATION.V;
  }), $ = g(() => E.value ? "完成时间" : _.value ? "使用时间" : "排产时间");
  j("isInProductionType", h), j("isTaskType", R), L.HOOK.beforeToQuery = () => {
    var r, y;
    m.query.projectOrWorkShopEnum = ((r = s.minQuery) == null ? void 0 : r.projectOrWorkShopEnum) || void 0, m.query.lossWorkProgressStatisticsEnum = ((y = s.currentWastageCostSummaryValueDTO) == null ? void 0 : y.lossWorkProgressStatisticsEnum) || void 0;
  };
  function P(r) {
    const [y, f] = r.split("-").map(Number), o = new Date(y, f - 1, 1).getTime(), b = new Date(y, f, 0).setHours(23, 59, 59, 999);
    return [o, b];
  }
  const z = g(() => s.minQuery.projectOrWorkShopEnum === W.PROJECT.V ? `项目：${s.currentRow.serialNumber} - ${s.currentRow.shortName}` : `车间：${s.currentRow.name}`);
  function J() {
    F(() => {
      var r, y, f, o, b, v, S, e, w;
      m.query.taskTypeEnum = (r = s.currentWastageCostSummaryValueDTO) == null ? void 0 : r.taskTypeEnum, m.query.processId = ((y = s.currentWastageCostSummaryValueDTO) == null ? void 0 : y.processId) || void 0, m.query.projectId = ((f = s.currentRow) == null ? void 0 : f.projectId) || void 0, m.query.workShopId = ((o = s.currentRow) == null ? void 0 : o.workShopId) || void 0, (b = s.currentWastageCostSummaryValueDTO) != null && b.yearMonth && !h.value && (m.query.dateTimeList = P((v = s.currentWastageCostSummaryValueDTO) == null ? void 0 : v.yearMonth), m.query.month = void 0), (S = s.currentWastageCostSummaryValueDTO) != null && S.yearMonth && h.value && (m.query.dateTimeList = [], m.query.month = (w = P((e = s.currentWastageCostSummaryValueDTO) == null ? void 0 : e.yearMonth)) == null ? void 0 : w[0]);
    }), m.toQuery();
  }
  function K() {
  }
  return (r, y) => {
    const f = Y, o = Z, b = q("common-table"), v = q("common-drawer"), S = ee;
    return a(), n(v, { ref_key: "drawerRef", ref: C, "append-to-body": "", modelValue: t(N), "onUpdate:modelValue": y[0] || (y[0] = (e) => X(N) ? N.value = e : null), title: z.value, "before-close": t(B), "close-on-click-modal": false, size: "100%", "custom-class": "production-scheduling-details" }, { titleAfter: l(() => [h.value ? u("", true) : (a(), n(f, { key: 0, size: "medium", class: "filter-item" }, { default: l(() => {
      var e, w, T;
      return [I(i(t(k).V[(e = d.currentWastageCostSummaryValueDTO) == null ? void 0 : e.lossWorkProgressStatisticsEnum].title) + " " + i(E.value && ((w = d.datailCurrentRow) != null && w.name) && t(m).query.processId ? ` - ${(T = d.datailCurrentRow) == null ? void 0 : T.name}` : ""), 1)];
    }), _: 1 })), h.value ? (a(), n(f, { key: 1, size: "medium", class: "filter-item" }, { default: l(() => {
      var e;
      return [I(i(((e = d.currentWastageCostSummaryValueDTO) == null ? void 0 : e.taskTypeEnum) === t(A).MACHINE_PART.V ? "待制品统计" : "在制品统计"), 1)];
    }), _: 1 })) : u("", true)]), content: l(() => [p("div", ce, [O(t(ie), { minQuery: d.minQuery, currentRow: d.currentRow }, null, 8, ["minQuery", "currentRow"])]), G((a(), n(b, { ref_key: "tableRef", ref: V, data: t(m).data, "max-height": t(U), showEmptySymbol: false, stripe: false }, { default: l(() => [O(o, { type: "index", label: "序号", align: "center", width: "60", fixed: "left" }), t(c).visible("生产车间") && d.minQuery.projectOrWorkShopEnum === t(W).PROJECT.V && _.value ? (a(), n(o, { "show-overflow-tooltip": "", prop: "produceWorkshopName", key: "produceWorkshopName", label: "生产车间", align: "center" }, { default: l((e) => [p("span", null, i(e.row.produceWorkshopName || "-"), 1)]), _: 1 })) : u("", true), t(c).visible("workshopName") && d.minQuery.projectOrWorkShopEnum === t(W).PROJECT.V ? (a(), n(o, { "show-overflow-tooltip": "", prop: "workshopName", key: "workshopName", label: _.value ? "使用车间" : "生产车间", align: "center" }, { default: l((e) => [p("span", null, i(e.row.workshopName || "-"), 1)]), _: 1 }, 8, ["label"])) : u("", true), t(c).visible("groupsName") ? (a(), n(o, { "show-overflow-tooltip": "", prop: "groupsName", key: "groupsName", label: "生产组", align: "center" }, { default: l((e) => [p("span", null, i(e.row.groupsName || "-"), 1)]), _: 1 })) : u("", true), t(c).visible("project") && d.minQuery.projectOrWorkShopEnum === t(W).WORKSHOP.V ? (a(), n(o, { "show-overflow-tooltip": "", prop: "project", key: "project", label: "项目", align: "center", "min-width": "150" }, { default: l((e) => {
      var w, T;
      return [p("span", null, i((w = e.row.project) == null ? void 0 : w.serialNumber) + " - " + i((T = e.row.project) == null ? void 0 : T.shortName), 1)];
    }), _: 1 })) : u("", true), t(c).visible("relationType") && t(m).query.taskTypeEnum === t(A).MACHINE_PART.V ? (a(), n(o, { "show-overflow-tooltip": "", prop: "relationType", key: "relationType", label: "零件类型", align: "center" }, { default: l((e) => [p("span", null, i(t(se).VL[e.row.relationType] || "-"), 1)]), _: 1 })) : u("", true), t(c).visible("name") ? (a(), n(o, { "show-overflow-tooltip": "", prop: "name", key: "name", label: "名称", align: "center" }, { default: l((e) => [p("span", null, i(e.row.name || "-"), 1)]), _: 1 })) : u("", true), t(c).visible("serialNumber") ? (a(), n(o, { "show-overflow-tooltip": "", prop: "serialNumber", key: "serialNumber", label: "编号", align: "center" }, { default: l((e) => [p("span", null, i(e.row.serialNumber || "-"), 1)]), _: 1 })) : u("", true), t(c).visible("specification") ? (a(), n(o, { "show-overflow-tooltip": "", prop: "specification", key: "specification", label: "规格", align: "center" }, { default: l((e) => [p("span", null, i(e.row.specification || "-"), 1)]), _: 1 })) : u("", true), t(c).visible("length") ? (a(), n(o, { "show-overflow-tooltip": "", prop: "length", key: "length", label: "长度(mm)", align: "center" }, { default: l((e) => [p("span", null, i(e.row.length || "-"), 1)]), _: 1 })) : u("", true), t(c).visible("material") ? (a(), n(o, { "show-overflow-tooltip": "", prop: "material", key: "material", label: "材质", align: "center" }, { default: l((e) => [p("span", null, i(e.row.material || "-"), 1)]), _: 1 })) : u("", true), t(c).visible("quantity") ? (a(), n(o, { "show-overflow-tooltip": "", prop: "quantity", key: "quantity", label: "数量", align: "center" }, { default: l((e) => [p("span", null, i(e.row.quantity || "-"), 1)]), _: 1 })) : u("", true), t(c).visible("netWeight") ? (a(), n(o, { "show-overflow-tooltip": "", prop: "netWeight", key: "netWeight", label: "单重(kg)", align: "center" }, { default: l((e) => [p("span", null, i(e.row.netWeight ?? "-"), 1)]), _: 1 })) : u("", true), t(c).visible("totalNetWeight") ? (a(), n(o, { "show-overflow-tooltip": "", prop: "totalNetWeight", key: "totalNetWeight", label: "总重(kg)", align: "center" }, { default: l((e) => [p("span", null, i(e.row.totalNetWeight ?? "-"), 1)]), _: 1 })) : u("", true), t(c).visible("processName") && h.value || R.value ? (a(), n(o, { "show-overflow-tooltip": "", prop: "processName", key: "processName", label: "当前工序", align: "center" }, { default: l((e) => [p("span", null, i(e.row.processName || "-"), 1)]), _: 1 })) : u("", true), t(c).visible("createTime") ? (a(), n(o, { "show-overflow-tooltip": "", prop: "createTime", key: "createTime", label: $.value, align: "center" }, { default: l((e) => [e.row.createTime ? (a(), x("span", pe, i(t(le)(e.row.createTime, "{y}-{m}-{d}")), 1)) : (a(), x("span", de, "-"))]), _: 1 }, 8, ["label"])) : u("", true)]), _: 1 }, 8, ["data", "max-height"])), [[S, t(m).loading]]), O(t(ne))]), _: 1 }, 8, ["modelValue", "title", "before-close"]);
  };
} };
export {
  Se as default
};
