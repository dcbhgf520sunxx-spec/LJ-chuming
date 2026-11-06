import { ref as r } from "vue";
import C from "moment";
import { provide as F } from "vue";
import { watch as oe } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as _e } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as p } from "vue";
import { unref as e } from "vue";
import { createBlock as s } from "vue";
import { withCtx as y } from "vue";
import { createTextVNode as T } from "vue";
import { createCommentVNode as u } from "vue";
import { toDisplayString as g } from "vue";
import { withDirectives as le } from "vue";
import { vShow as ke } from "vue";
import { withKeys as Ie } from "vue";
import { withModifiers as re } from "vue";
import { ElDatePicker as xe } from "element-plus";
import { ElTag as Te } from "element-plus";
import { ElInput as qe } from "element-plus";
import { ElTableColumn as Ve } from "element-plus";
import { vLoading as Ce } from "element-plus";
import { l as M, _ as De, x as Ee, nH as Y, o as Ne, nI as ne, fo as se, I as Pe, aV as Re, G as ue, L as Oe, c as je, D as Ue, E as Qe, bb as ze, bZ as Se, P as We } from "../../../../shared/runtime.js";
import Be from "./module/process-list.vue.js";
function Me(w) {
  return M({ module: "mes", url: "report/product/team/summary/reviewV2", method: "get", params: w });
}
function He(w) {
  return M({ module: "mes", url: "report/product/team/summary/list", method: "get", params: w });
}
function Ge(w) {
  return M({ module: "mes", url: "report/workshop/process/list", method: "get", params: w });
}
function Ke(w) {
  return M({ module: "mes", url: "report/product/team/summary/download", method: "get", params: w, responseType: "blob" });
}
const Le = { get: Me };
const Ae = { class: "app-container wrap" }, $e = { class: "head-container" }, Fe = { class: "wrap-content" }, Ye = { class: "wrap-left" }, Ze = { class: "wrap-right" }, Je = { class: "wrap-right-header", style: { display: "flex", "justify-content": "space-between", "margin-bottom": "8px" } }, Xe = { class: "head-container wrap-right-filter" }, et = { __name: "index", setup(w) {
  const ie = { add: false, edit: false, del: false, download: false }, P = r(), Z = r(), H = r(), J = r(), q = r({}), { crud: a, columns: m, CRUD: X } = Ee({ title: "统计报表", sort: [], permission: { ...Y }, optShow: { ...ie }, crudApi: { ...Le }, invisibleColumns: ["grossWeight", "totalGrossWeight"], requiredQuery: ["processId"], hasPagination: true }, J), de = r([["scheduleTime", ["parse-time", "{y}-{m}-{d}"]]]), { maxHeight: pe } = Ne({ extraBox: [".head-container", ".wrap-right-header", ".wrap-right-filter"], paginate: true }), me = r(), ee = r([C().valueOf() - 3600 * 1e3 * 24 * 30, C().valueOf()]), _ = r(C().valueOf() - 3600 * 1e3 * 24 * 30), k = r(C().valueOf()), b = r(), v = r(), ce = r(), V = r(), G = r([]), K = r([]), L = r(false), R = r(), I = r(ne.REPORT.V), A = r(se.NET_WEIGHT.V), D = r(), O = r(), j = r(), U = r(), te = r([]), ae = r([]);
  F("tableData", K), F("loading", L), F("weightType", A), oe(() => v.value, async (o) => {
    var t;
    a.query.groupsId = void 0, V.value = void 0, a.query.processId = void 0, H.value = await ((t = Z.value) == null ? void 0 : t.getOption(o)), P.value = null, q.value = null, R.value = void 0, a.data = [], a.toQuery(), $(), Q();
  }, { immediate: true }), oe(() => V.value, (o) => {
    var t;
    o ? (a.query.processId = o, a.toQuery()) : (a.query.processId = void 0, a.data = []), Q(), a.query.teamId = void 0, a.query.taskTypeEnum = void 0, q.value = null, P.value = (t = G.value) == null ? void 0 : t.find((c) => c.id === o);
  }, { immediate: true });
  async function $() {
    if (v.value) try {
      const o = await Ge({ workshopId: v.value, projectId: b.value, taskReportTypeEnum: I.value });
      G.value = o || [];
    } catch {
      console.log("获取班组的工序失败");
    }
  }
  async function Q() {
    try {
      L.value = true, K.value = [];
      const o = await He({ startDate: _.value, endDate: k.value, processId: V.value, workshopId: v.value, projectId: b.value, taskReportTypeEnum: I.value });
      K.value = o || [];
    } catch (o) {
      console.log("获取工序列表错误", o);
    } finally {
      L.value = false;
    }
  }
  async function fe(o) {
    v.value = void 0, V.value = void 0, o && o.length > 1 ? (_.value = o[0], k.value = o[1]) : (_.value = C().valueOf() - 3600 * 1e3 * 24 * 30, k.value = C().valueOf()), $(), Q(), a.toQuery();
  }
  function ye() {
    $(), Q();
  }
  X.HOOK.beforeToQuery = () => {
    a.query.projectId = b.value, a.query.monomerId = D.value, a.query.areaId = O.value, a.query.areaBatchId = j.value, a.query.workshopId = v.value, a.query.serialNumber = U.value, a.query.startDate = _.value, a.query.endDate = k.value, a.query.taskReportTypeEnum = I.value;
  }, X.HOOK.handleRefresh = (o, t) => {
    var c, x, h, z, S, W;
    t.data.totalElements = ((c = t.data.detailPages) == null ? void 0 : c.totalElements) || 0, t.data.hasNextPage = (x = t.data.detailPages) == null ? void 0 : x.hasNextPage, t.data.hasPreviousPage = (h = t.data.detailPages) == null ? void 0 : h.hasPreviousPage, R.value = (z = t.data) == null ? void 0 : z.totalNetWeight, t.data.content = (W = (S = t.data.detailPages) == null ? void 0 : S.content) == null ? void 0 : W.map((B) => B);
  };
  function ve(o) {
    te.value = o, ae.value = o == null ? void 0 : o.map((t) => {
      var c;
      return (c = t == null ? void 0 : t.team) == null ? void 0 : c.id;
    });
  }
  function he(o) {
    var t, c, x, h;
    a.query.processId = (t = o == null ? void 0 : o.process) == null ? void 0 : t.id, a.query.workshopId = (c = o == null ? void 0 : o.workshop) == null ? void 0 : c.id, a.query.groupsId = (x = o == null ? void 0 : o.groups) == null ? void 0 : x.id, a.query.teamId = (h = o == null ? void 0 : o.team) == null ? void 0 : h.id, a.query.taskTypeEnum = o == null ? void 0 : o.taskTypeEnum, a.query.startDate = _.value, a.query.endDate = k.value, a.query.projectId = b.value, q.value = o, a.toQuery();
  }
  function ge() {
    D.value = void 0, O.value = void 0, j.value = void 0, U.value = void 0, a.toQuery();
  }
  return (o, t) => {
    const c = N("common-radio-button"), x = xe, h = Te, z = N("print-table"), S = N("common-select"), W = qe, B = N("common-button"), d = Ve, we = N("common-table"), be = Ce;
    return n(), _e("div", Ae, [f("div", $e, [p(c, { modelValue: I.value, "onUpdate:modelValue": t[0] || (t[0] = (l) => I.value = l), type: "enum", options: e(ne).ENUM, class: "filter-item", size: "default", onChange: ye }, null, 8, ["modelValue", "options"]), p(x, { modelValue: ee.value, "onUpdate:modelValue": t[1] || (t[1] = (l) => ee.value = l), type: "daterange", "range-separator": ":", size: "default", "value-format": "x", clearable: false, shortcuts: e(Pe), "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px", "margin-right": "10px" }, class: "filter-item date-item", onChange: fe }, null, 8, ["modelValue", "shortcuts"]), p(c, { modelValue: A.value, "onUpdate:modelValue": t[2] || (t[2] = (l) => A.value = l), options: e(se).ENUM, type: "enum", class: "filter-item" }, null, 8, ["modelValue", "options"]), p(e(Re), { ref_key: "workshopRef", ref: Z, modelValue: v.value, "onUpdate:modelValue": t[3] || (t[3] = (l) => v.value = l), placeholder: "请选择车间", "factory-id": ce.value, style: { width: "200px" }, class: "filter-item", clearable: true }, null, 8, ["modelValue", "factory-id"]), e(ue)(e(Y).download) ? (n(), s(e(Oe), { key: 0, params: { startDate: _.value, endDate: k.value, processId: o.processId, workshopId: v.value, projectId: b.value, taskReportTypeEnum: I.value, teamIds: ae.value }, size: "default", fn: e(Ke), disabled: !te.value.length, "response-header-result": "", class: "filter-item" }, { default: y(() => t[10] || (t[10] = [T(" 班组报表下载 ")])), _: 1, __: [10] }, 8, ["params", "fn", "disabled"])) : u("", true), v.value ? (n(), s(c, { key: 1, modelValue: V.value, "onUpdate:modelValue": t[4] || (t[4] = (l) => V.value = l), options: G.value, type: "other", class: "filter-item", dataStructure: { key: "id", label: "name", value: "id" }, showOptionAll: "", size: "default" }, null, 8, ["modelValue", "options"])) : u("", true)]), f("div", Fe, [f("div", Ye, [p(Be, { ref_key: "processListRef", ref: me, onNestingTaskClick: he, onSelectionChange: ve }, null, 512)]), f("div", Ze, [f("div", null, [f("div", Je, [f("div", null, [p(h, { size: "large" }, { default: y(() => {
      var l;
      return [T("车间：" + g(H.value ? (l = H.value) == null ? void 0 : l.name : "全部"), 1)];
    }), _: 1 }), p(h, { size: "large", style: { "margin-left": "10px" } }, { default: y(() => {
      var l, i, E;
      return [T(" 工序：" + g(P.value ? (l = P.value) == null ? void 0 : l.name : q.value ? (E = (i = q.value) == null ? void 0 : i.process) == null ? void 0 : E.name : "-"), 1)];
    }), _: 1 }), p(h, { size: "large", style: { "margin-left": "10px" } }, { default: y(() => {
      var l, i;
      return [T("班组：" + g(((i = (l = q.value) == null ? void 0 : l.team) == null ? void 0 : i.name) || "-"), 1)];
    }), _: 1 }), p(h, { size: "large", style: { "margin-left": "10px" } }, { default: y(() => [T(" 产量：" + g(R.value ? e(je)(R.value, "kg", "t", e(Ue).COM_WT__T) : "-") + "吨 ", 1)]), _: 1 })]), p(e(Qe), null, { optRight: y(() => [e(ue)(e(Y).print) ? (n(), s(z, { key: 0, "api-key": "mesGroupsReport", params: { processId: e(a).query.processId, workshopId: v.value, startDate: _.value, endDate: k.value, taskTypeEnum: e(a).query.taskTypeEnum, groupsId: e(a).query.groupsId, teamId: e(a).query.teamId, projectId: e(a).query.projectId, monomerId: e(a).query.monomerId, areaId: e(a).query.areaId, serialNumber: e(a).query.serialNumber, taskReportTypeEnum: I.value }, size: "default", type: "warning", class: "filter-item", style: { width: "300px" } }, null, 8, ["params"])) : u("", true)]), _: 1 })]), f("div", null, [le(f("div", Xe, [p(ze, { modelValue: b.value, "onUpdate:modelValue": t[5] || (t[5] = (l) => b.value = l), clearable: "", class: "filter-item", style: { width: "300px" }, onChange: e(a).toQuery }, null, 8, ["modelValue", "onChange"]), p(e(Se), { monomerId: D.value, "onUpdate:monomerId": t[7] || (t[7] = (l) => D.value = l), areaId: O.value, "onUpdate:areaId": t[8] || (t[8] = (l) => O.value = l), needConvert: "", clearable: "", areaClearable: "", "project-id": b.value, onChange: e(a).toQuery }, { right: y(({ planAreaBatchInfo: l }) => [p(S, { modelValue: j.value, "onUpdate:modelValue": t[6] || (t[6] = (i) => j.value = i), options: l, size: "default", dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", noDataText: D.value ? "暂无数据" : "未选择单体", class: "filter-item", placeholder: "请选择批次", onChange: e(a).toQuery }, null, 8, ["modelValue", "options", "noDataText", "onChange"])]), _: 1 }, 8, ["monomerId", "areaId", "project-id", "onChange"]), f("div", null, [p(W, { modelValue: U.value, "onUpdate:modelValue": t[9] || (t[9] = (l) => U.value = l), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: Ie(e(a).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), p(B, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: re(e(a).toQuery, ["stop"]) }, { default: y(() => t[11] || (t[11] = [T(" 搜索 ")])), _: 1, __: [11] }, 8, ["onClick"]), p(B, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: re(ge, ["stop"]) }, { default: y(() => t[12] || (t[12] = [T(" 重置 ")])), _: 1, __: [12] })])], 512), [[ke, e(a).searchToggle]]), le((n(), s(we, { ref_key: "tableRef", ref: J, data: e(a).data, "empty-text": e(a).emptyText, dataFormat: de.value, "max-height": e(pe), "show-empty-symbol": false, style: { width: "100%" } }, { default: y(() => [p(d, { label: "序号", type: "index", align: "center", width: "70", fixed: "left" }), e(m).visible("project") ? (n(), s(d, { key: 0, "show-overflow-tooltip": true, label: "项目", type: "project", align: "center", "min-width": "140", fixed: "left" }, { default: y(({ row: l }) => {
      var i, E;
      return [f("span", null, g((i = l.project) == null ? void 0 : i.serialNumber) + "-" + g((E = l.project) == null ? void 0 : E.name), 1)];
    }), _: 1 })) : u("", true), e(m).visible("monomer.name") ? (n(), s(d, { key: 1, "show-overflow-tooltip": true, prop: "monomer.name", label: "单体", align: "center" }, { default: y(({ row: l }) => {
      var i;
      return [f("span", null, g(l.monomer ? (i = l.monomer) == null ? void 0 : i.name : "/"), 1)];
    }), _: 1 })) : u("", true), e(m).visible("area.name") ? (n(), s(d, { key: 2, "show-overflow-tooltip": true, prop: "area.name", label: "区域", align: "center" }, { default: y(({ row: l }) => {
      var i;
      return [f("span", null, g(l.area ? (i = l.area) == null ? void 0 : i.name : "/"), 1)];
    }), _: 1 })) : u("", true), e(m).visible("areaBatch.name") ? (n(), s(d, { key: 3, "show-overflow-tooltip": true, prop: "areaBatch.name", label: "批次", align: "center" }, { default: y(({ row: l }) => {
      var i;
      return [f("span", null, g(l.areaBatch ? (i = l.areaBatch) == null ? void 0 : i.name : "/"), 1)];
    }), _: 1 })) : u("", true), e(m).visible("serialNumber") ? (n(), s(d, { key: 4, "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", "min-width": "80px", align: "center" })) : u("", true), e(m).visible("name") ? (n(), s(d, { key: 5, "show-overflow-tooltip": true, prop: "name", label: "名称", "min-width": "100px", align: "center" })) : u("", true), e(m).visible("structureTypeName") ? (n(), s(d, { key: 6, "show-overflow-tooltip": true, prop: "structureTypeName", label: "结构类型", "min-width": "100px", align: "center" })) : u("", true), e(m).visible("specification") ? (n(), s(d, { key: 7, "show-overflow-tooltip": true, prop: "specification", label: "规格", "min-width": "100px", align: "center" })) : u("", true), e(m).visible("length") ? (n(), s(d, { key: 8, "show-overflow-tooltip": true, prop: "length", label: "长度", align: "center" })) : u("", true), e(m).visible("reportQuantity") ? (n(), s(d, { key: 9, "show-overflow-tooltip": true, prop: "reportQuantity", label: "上报数量", align: "center" })) : u("", true), e(m).visible("quantity") ? (n(), s(d, { key: 10, "show-overflow-tooltip": true, prop: "quantity", label: "质检数量", align: "center" })) : u("", true), e(m).visible("netWeight") ? (n(), s(d, { key: 11, "show-overflow-tooltip": true, prop: "netWeight", label: "单净重（kg）", align: "center", "min-width": "100" })) : u("", true), e(m).visible("grossWeight") ? (n(), s(d, { key: 12, "show-overflow-tooltip": true, prop: "grossWeight", label: "单毛重（kg）", align: "center", "min-width": "100" })) : u("", true), e(m).visible("totalNetWeight") ? (n(), s(d, { key: 13, "show-overflow-tooltip": true, prop: "totalNetWeight", label: "总净重（kg）", align: "center", "min-width": "100" })) : u("", true), e(m).visible("totalGrossWeight") ? (n(), s(d, { key: 14, "show-overflow-tooltip": true, prop: "totalGrossWeight", label: "总毛重（kg）", align: "center", "min-width": "100" })) : u("", true), e(m).visible("reporterName") ? (n(), s(d, { key: 15, "show-overflow-tooltip": true, prop: "reporterName", label: "上报人", align: "center" })) : u("", true), e(m).visible("reportingDate") ? (n(), s(d, { key: 16, "show-overflow-tooltip": true, prop: "reportingDate", label: "上报时间", align: "center", "min-width": "100" })) : u("", true)]), _: 1 }, 8, ["data", "empty-text", "dataFormat", "max-height"])), [[be, e(a).loading]]), p(e(We))])])])])]);
  };
} }, lt = De(et, [["__scopeId", "data-v-23aebdf1"]]);
export {
  lt as default
};
