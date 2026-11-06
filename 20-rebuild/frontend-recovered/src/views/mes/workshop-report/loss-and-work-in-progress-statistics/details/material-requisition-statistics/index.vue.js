import { ref as T } from "vue";
import { computed as H } from "vue";
import { nextTick as U } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as s } from "vue";
import { createBlock as r } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as h } from "vue";
import { unref as o } from "vue";
import { withDirectives as B } from "vue";
import { toDisplayString as u } from "vue";
import { createCommentVNode as c } from "vue";
import { createElementBlock as E } from "vue";
import { isRef as I } from "vue";
import { ElTableColumn as M } from "element-plus";
import { ElTooltip as Q } from "element-plus";
import { vLoading as L } from "element-plus";
import { c as A, _ as $ } from "./module/header.vue.js";
import { u as K, x as z, o as F, si as P, cO as J, jl as G, sj as X, sk as Y, p as Z, pz as ee, P as te } from "../../../../../../shared/runtime.js";
const oe = { class: "head-container" }, se = { key: 0 }, ae = { key: 1 }, ie = { __name: "index", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, minQuery: { type: Object, default: () => {
} }, datailCurrentRow: { type: Object, default: () => {
} }, currentWastageCostSummaryValueDTO: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(_, { emit: O }) {
  const W = O, p = _, { visible: g, handleClose: N } = K({ emit: W, props: p, showHook: x, closeHook: D }), k = T(), V = { batchAdd: false, add: false, edit: false, del: false, download: false }, v = T(), { crud: m, columns: n, CRUD: S } = z({ title: "损耗统计-领料统计表", optShow: { ...V }, sort: [], crudApi: { ...A }, queryOnPresenterCreated: false, hasPagination: true }, k), { maxHeight: q } = F({ mainBox: ".material-requisition-statistics-detail", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, () => v.value.loaded), R = H(() => p.minQuery.projectOrWorkShopEnum === P.PROJECT.V ? `项目：${p.currentRow.serialNumber} - ${p.currentRow.shortName}` : `车间：${p.currentRow.name}`);
  function j(d) {
    const [l, t] = d.split("-").map(Number), f = new Date(l, t - 1, 1).getTime(), w = new Date(l, t, 0).setHours(23, 59, 59, 999);
    return [f, w];
  }
  S.HOOK.handleRefresh = async (d, { data: l }) => {
    l.content.forEach((t) => {
      t.oddNumbers = t.serialNumber, t.meteCount = t.mete;
    }), await J(l.content), l.content = await G(l.content, { toSmallest: false, toNum: false }), console.log(l.content);
  }, S.HOOK.beforeToQuery = () => {
    var d;
    m.query.projectOrWorkShopEnum = ((d = p.minQuery) == null ? void 0 : d.projectOrWorkShopEnum) || void 0;
  };
  function x() {
    U(() => {
      var d, l, t, f, w, y, b;
      m.query.taskTypeEnum = (d = p.currentWastageCostSummaryValueDTO) == null ? void 0 : d.taskTypeEnum, m.query.processId = ((l = p.currentWastageCostSummaryValueDTO) == null ? void 0 : l.processId) || void 0, m.query.projectId = ((t = p.currentRow) == null ? void 0 : t.projectId) || void 0, m.query.workShopId = ((f = p.currentRow) == null ? void 0 : f.workShopId) || void 0, m.query.lossWorkProgressStatisticsEnum = ((w = p.currentWastageCostSummaryValueDTO) == null ? void 0 : w.lossWorkProgressStatisticsEnum) || void 0, (y = p.currentWastageCostSummaryValueDTO) != null && y.yearMonth && (m.query.dateTimeList = j((b = p.currentWastageCostSummaryValueDTO) == null ? void 0 : b.yearMonth), m.query.month = void 0);
    }), console.log(m.query.lossWorkProgressStatisticsEnum, "crud.query.lossWorkProgressStatisticsEnum"), m.toQuery();
  }
  function D() {
  }
  return (d, l) => {
    const t = M, f = Q, w = C("common-table"), y = C("common-drawer"), b = L;
    return s(), r(y, { ref_key: "drawerRef", ref: v, "append-to-body": "", modelValue: o(g), "onUpdate:modelValue": l[0] || (l[0] = (e) => I(g) ? g.value = e : null), title: R.value, "before-close": o(N), "close-on-click-modal": false, size: "100%", "custom-class": "material-requisition-statistics-detail" }, { content: a(() => [i("div", oe, [h(o($))]), B((s(), r(w, { ref_key: "tableRef", ref: k, data: o(m).data, showEmptySymbol: false, stripe: false, "max-height": o(q) }, { default: a(() => [h(t, { type: "index", label: "序号", align: "center", width: "60", fixed: "left" }), o(n).visible("lossWorkProgressStatisticsEnum") ? (s(), r(t, { "show-overflow-tooltip": "", prop: "lossWorkProgressStatisticsEnum", key: "lossWorkProgressStatisticsEnum", label: "业务类型", align: "center" }, { default: a((e) => [i("span", null, u(o(X).V[e.row.lossWorkProgressStatisticsEnum].SL || "-"), 1)]), _: 1 })) : c("", true), o(n).visible("basicClass") ? (s(), r(t, { "show-overflow-tooltip": "", prop: "basicClass", key: "basicClass", label: "材料类型", align: "center" }, { default: a((e) => [i("span", null, u(o(Y).VL[e.row.basicClass] || "-"), 1)]), _: 1 })) : c("", true), o(n).visible("projectName") && _.minQuery.projectOrWorkShopEnum === o(P).WORKSHOP.V ? (s(), r(t, { "show-overflow-tooltip": "", prop: "projectName", key: "projectName", label: "项目", align: "center" }, { default: a((e) => [i("span", null, u(e.row.projectName || "-"), 1)]), _: 1 })) : c("", true), o(n).visible("reviewPassTime") ? (s(), r(t, { "show-overflow-tooltip": "", prop: "reviewPassTime", key: "reviewPassTime", label: "出(退)库日期", align: "center" }, { default: a((e) => [e.row.reviewPassTime ? (s(), E("span", se, u(o(Z)(e.row.reviewPassTime, "{y}-{m}-{d}")), 1)) : (s(), E("span", ae, "-"))]), _: 1 })) : c("", true), o(n).visible("oddNumbers") ? (s(), r(t, { "show-overflow-tooltip": "", prop: "oddNumbers", key: "oddNumbers", label: "出(退)库单号", align: "center" }, { default: a((e) => [i("span", null, u(e.row.oddNumbers || "-"), 1)]), _: 1 })) : c("", true), o(n).visible("useWorkshop") ? (s(), r(t, { "show-overflow-tooltip": "", prop: "useWorkshop", key: "useWorkshop", label: "领用车间", align: "center" }, { default: a((e) => [i("span", null, u(e.row.useWorkshop || "-"), 1)]), _: 1 })) : c("", true), o(n).visible("receivePerson") ? (s(), r(t, { "show-overflow-tooltip": "", prop: "receivePerson", key: "receivePerson", label: "领用人", align: "center" }, { default: a((e) => [i("span", null, u(e.row.receivePerson || "-"), 1)]), _: 1 })) : c("", true), o(n).visible("classifyName") ? (s(), r(t, { "show-overflow-tooltip": "", prop: "classifyName", key: "classifyName", label: "物料种类", align: "center" }, { default: a((e) => [i("span", null, u(e.row.classifyName || "-"), 1)]), _: 1 })) : c("", true), o(n).visible("spec") ? (s(), r(t, { "show-overflow-tooltip": "", prop: "spec", key: "spec", label: "规格", align: "center" }, { default: a((e) => [h(f, { content: o(ee)(e.row), placement: "left" }, { default: a(() => [i("span", null, u(e.row.spec || "-"), 1)]), _: 2 }, 1032, ["content"])]), _: 1 })) : c("", true), o(n).visible("specification") ? (s(), r(t, { "show-overflow-tooltip": "", prop: "specification", key: "specification", label: "材质/型号", align: "center" }, { default: a((e) => [i("span", null, u(e.row.specification || "-"), 1)]), _: 1 })) : c("", true), o(n).visible("quantity") ? (s(), r(t, { "show-overflow-tooltip": "", prop: "quantity", key: "quantity", label: "数量", align: "center" }, { default: a((e) => [i("span", null, u(e.row.quantity ?? "-"), 1)]), _: 1 })) : c("", true), o(n).visible("measureUnit") ? (s(), r(t, { "show-overflow-tooltip": "", prop: "measureUnit", key: "measureUnit", label: "计量单位", align: "center" }, { default: a((e) => [i("span", null, u(e.row.measureUnit || "-"), 1)]), _: 1 })) : c("", true), o(n).visible("meteCount") ? (s(), r(t, { "show-overflow-tooltip": "", prop: "meteCount", key: "meteCount", label: "核算量", align: "center" }, { default: a((e) => [i("span", null, u(e.row.meteCount || "-"), 1)]), _: 1 })) : c("", true), o(n).visible("accountingUnit") ? (s(), r(t, { "show-overflow-tooltip": "", prop: "accountingUnit", key: "accountingUnit", label: "核算单位", align: "center" }, { default: a((e) => [i("span", null, u(e.row.accountingUnit || "-"), 1)]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "max-height"])), [[b, o(m).loading]]), h(o(te))]), _: 1 }, 8, ["modelValue", "title", "before-close"]);
  };
} };
export {
  ie as default
};
