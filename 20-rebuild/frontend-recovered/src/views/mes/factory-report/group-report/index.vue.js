import { ref as n } from "vue";
import _ from "moment";
import { provide as M } from "vue";
import { watch as pe } from "vue";
import { onMounted as ce } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as me } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as H } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { createBlock as d } from "vue";
import { createCommentVNode as f } from "vue";
import { withCtx as p } from "vue";
import { createTextVNode as q } from "vue";
import { Fragment as fe } from "vue";
import { toDisplayString as w } from "vue";
import { withDirectives as A } from "vue";
import { withKeys as ye } from "vue";
import { withModifiers as F } from "vue";
import { ElDatePicker as ve } from "element-plus";
import { ElTag as he } from "element-plus";
import { ElInput as ge } from "element-plus";
import { ElTableColumn as _e } from "element-plus";
import { vLoading as be } from "element-plus";
import { c as we, g as Ie, a as ke } from "../../../../modules/group-report-de628baf.js";
import { _ as xe, x as Ce, nx as G, o as qe, I as Ve, fa as Te, aV as De, E as je, bb as Oe, ng as Ne, bZ as Re, P as Ue } from "../../../../shared/runtime.js";
import Ee from "./module/process-list.vue.js";
const Pe = { class: "app-container wrap" }, Se = { class: "head-container" }, ze = { class: "wrap-content" }, Qe = { class: "wrap-left" }, Be = { class: "wrap-right" }, We = { style: { display: "flex", "justify-content": "space-between", "margin-bottom": "8px" } }, Ke = { class: "head-container" }, Le = { __name: "index", setup(Me) {
  const $ = { add: false, edit: false, del: false, download: false }, S = n(), R = n({}), { crud: t, columns: y, CRUD: z } = Ce({ title: "班组报表", sort: [], permission: { ...G }, optShow: { ...$ }, crudApi: { ...we }, invisibleColumns: ["grossWeight", "totalGrossWeight"], requiredQuery: ["teamId"] }, S), Y = n([["scheduleTime", ["parse-time", "{y}-{m}-{d}"]]]), { maxHeight: Z } = qe({ paginate: true }), J = n(), Q = n([_().startOf("month").valueOf(), _().valueOf()]), I = n(_().startOf("month").valueOf()), k = n(_().valueOf()), c = n(), v = n(), X = n(), x = n(), B = n([]), U = n([]), E = n(false), V = n(), C = n(), T = n(), D = n();
  M("tableData", U), M("loading", E), pe([() => v.value, () => x.value], (a) => {
    t.query.groupsId = void 0, j(), h();
  }), ce(() => {
    h();
  });
  async function j() {
    try {
      const a = await Ie({ workshopId: v.value, projectId: c.value });
      B.value = a || [];
    } catch {
      console.log("获取班组的工序失败");
    }
  }
  async function h() {
    try {
      E.value = true, U.value = [];
      const a = await ke({ startDate: I.value, endDate: k.value, processId: x.value, workshopId: v.value, projectId: c.value });
      U.value = a || [];
    } catch (a) {
      console.log("获取工序列表错误", a);
    } finally {
      E.value = false;
    }
  }
  function ee() {
    x.value = void 0, j(), h();
  }
  async function te(a) {
    a && a.length > 1 ? (I.value = a[0], k.value = a[1]) : (I.value = _().startOf("month").valueOf(), k.value = _().valueOf()), j(), h(), t.query.groupsId = void 0;
  }
  z.HOOK.beforeToQuery = () => {
    t.query.projectId = c.value, t.query.monomerId = V.value, t.query.areaId = C.value, t.query.areaBatchId = T.value, t.query.serialNumber = D.value;
  }, z.HOOK.handleRefresh = (a, l) => {
    l.data.content = l.data.content.map((g) => g);
  };
  function ae() {
    v.value = void 0, j(), h();
  }
  function oe(a) {
    var l, g, O, N;
    t.query.processId = (l = a == null ? void 0 : a.process) == null ? void 0 : l.id, t.query.workshopId = (g = a == null ? void 0 : a.workshop) == null ? void 0 : g.id, t.query.groupsId = (O = a == null ? void 0 : a.groups) == null ? void 0 : O.id, t.query.teamId = (N = a == null ? void 0 : a.team) == null ? void 0 : N.id, t.query.taskTypeEnum = a == null ? void 0 : a.taskTypeEnum, t.query.startDate = I.value, t.query.endDate = k.value, t.query.projectId = c.value, R.value = a, t.toQuery();
  }
  function le() {
    c.value = void 0, V.value = void 0, C.value = void 0, T.value = void 0, D.value = void 0, t.toQuery();
  }
  return (a, l) => {
    var K;
    const g = ve, O = b("project-radio-button"), N = b("common-radio-button"), P = he, ne = b("print-table"), re = b("common-select"), se = ge, W = b("common-button"), m = _e, ie = b("common-table"), ue = me("permission"), de = be;
    return i(), H("div", Pe, [u("div", Se, [s(g, { modelValue: Q.value, "onUpdate:modelValue": l[0] || (l[0] = (o) => Q.value = o), type: "daterange", "range-separator": ":", size: "default", "value-format": "x", clearable: false, shortcuts: e(Ve), "unlink-panels": "", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px", "margin-right": "10px" }, class: "filter-item date-item", onChange: te }, null, 8, ["modelValue", "shortcuts"]), s(O, { size: "default", modelValue: c.value, "onUpdate:modelValue": l[1] || (l[1] = (o) => c.value = o), class: "filter-item", onChange: ae }, null, 8, ["modelValue"]), s(e(De), { modelValue: v.value, "onUpdate:modelValue": l[2] || (l[2] = (o) => v.value = o), placeholder: "请选择车间", "workshop-type": e(Te).BUILDING.V, "factory-id": X.value, style: { width: "200px" }, class: "filter-item", clearable: true, onChange: ee }, null, 8, ["modelValue", "workshop-type", "factory-id"]), v.value ? (i(), d(N, { key: 0, modelValue: x.value, "onUpdate:modelValue": l[3] || (l[3] = (o) => x.value = o), options: B.value, type: "other", class: "filter-item", dataStructure: { key: "id", label: "name", value: "id" }, showOptionAll: "", size: "default", onChange: h }, null, 8, ["modelValue", "options"])) : f("", true)]), u("div", ze, [u("div", Qe, [s(Ee, { ref_key: "processListRef", ref: J, onNestingTaskClick: oe }, null, 512)]), u("div", Be, [(K = e(t).query) != null && K.teamId ? (i(), H(fe, { key: 1 }, [u("div", We, [u("div", null, [s(P, { size: "large" }, { default: p(() => {
      var o, r;
      return [q("车间：" + w(((r = (o = R.value) == null ? void 0 : o.workshop) == null ? void 0 : r.name) || "-"), 1)];
    }), _: 1 }), s(P, { size: "large", style: { "margin-left": "10px" } }, { default: p(() => {
      var o, r;
      return [q("工序：" + w((r = (o = R.value) == null ? void 0 : o.process) == null ? void 0 : r.name), 1)];
    }), _: 1 })]), s(e(je), null, { optRight: p(() => [A(s(ne, { "api-key": "mesGroupsReport", params: { processId: e(t).query.processId, workshopId: v.value, startDate: I.value, endDate: k.value, taskTypeEnum: e(t).query.taskTypeEnum, groupsId: e(t).query.groupsId, teamId: e(t).query.teamId, projectId: e(t).query.projectId, monomerId: e(t).query.monomerId, areaId: e(t).query.areaId, serialNumber: e(t).query.serialNumber }, size: "default", type: "warning", class: "filter-item", style: { width: "300px" } }, null, 8, ["params"]), [[ue, e(G).print]])]), _: 1 })]), u("div", null, [u("div", Ke, [s(Oe, { modelValue: c.value, "onUpdate:modelValue": l[4] || (l[4] = (o) => c.value = o), clearable: "", class: "filter-item", style: { width: "300px" }, onChange: e(t).toQuery }, null, 8, ["modelValue", "onChange"]), s(e(Re), { monomerId: V.value, "onUpdate:monomerId": l[6] || (l[6] = (o) => V.value = o), areaId: C.value, "onUpdate:areaId": l[7] || (l[7] = (o) => C.value = o), productType: e(Ne).STRUCTURE.V, needConvert: "", clearable: "", "project-id": c.value, class: "filter-item", onChange: e(t).toQuery }, { right: p(({ planAreaBatch: o }) => [s(re, { modelValue: T.value, "onUpdate:modelValue": l[5] || (l[5] = (r) => T.value = r), options: o, size: "default", dataStructure: { key: "id", label: "name", value: "id" }, clearable: a.areaClearable, noDataText: C.value ? "暂无数据" : "未选择区域", class: "filter-item", placeholder: "请选择批次", style: { width: "200px" }, onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "clearable", "noDataText", "onChange"])]), _: 1 }, 8, ["monomerId", "areaId", "productType", "project-id", "onChange"]), u("div", null, [s(se, { modelValue: D.value, "onUpdate:modelValue": l[8] || (l[8] = (o) => D.value = o), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: ye(e(t).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), s(W, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: F(e(t).toQuery, ["stop"]) }, { default: p(() => l[10] || (l[10] = [q(" 搜索 ")])), _: 1, __: [10] }, 8, ["onClick"]), s(W, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: F(le, ["stop"]) }, { default: p(() => l[11] || (l[11] = [q(" 重置 ")])), _: 1, __: [11] })])]), A((i(), d(ie, { ref_key: "tableRef", ref: S, data: e(t).data, "empty-text": e(t).emptyText, dataFormat: Y.value, "max-height": e(Z) - 100, "show-empty-symbol": false, style: { width: "100%" } }, { default: p(() => [s(m, { label: "序号", type: "index", align: "center", width: "70" }), e(y).visible("project") ? (i(), d(m, { key: 0, "show-overflow-tooltip": true, label: "项目", type: "project", align: "center", "min-width": "120" }, { default: p(({ row: o }) => {
      var r, L;
      return [u("span", null, w((r = o.project) == null ? void 0 : r.serialNumber) + "-" + w((L = o.project) == null ? void 0 : L.name), 1)];
    }), _: 1 })) : f("", true), e(y).visible("monomer.name") ? (i(), d(m, { key: 1, "show-overflow-tooltip": true, prop: "monomer.name", label: "单体", align: "center" }, { default: p(({ row: o }) => {
      var r;
      return [u("span", null, w(o.monomer ? (r = o.monomer) == null ? void 0 : r.name : "/"), 1)];
    }), _: 1 })) : f("", true), e(y).visible("area.name") ? (i(), d(m, { key: 2, "show-overflow-tooltip": true, prop: "area.name", label: "区域", align: "center" }, { default: p(({ row: o }) => {
      var r;
      return [u("span", null, w(o.area ? (r = o.area) == null ? void 0 : r.name : "/"), 1)];
    }), _: 1 })) : f("", true), e(y).visible("serialNumber") ? (i(), d(m, { key: 3, "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", "min-width": "80px", align: "center" })) : f("", true), e(y).visible("specification") ? (i(), d(m, { key: 4, "show-overflow-tooltip": true, prop: "specification", label: "规格", "min-width": "80px", align: "center" })) : f("", true), e(y).visible("length") ? (i(), d(m, { key: 5, "show-overflow-tooltip": true, prop: "length", label: "长度", align: "center" })) : f("", true), e(y).visible("quantity") ? (i(), d(m, { key: 6, "show-overflow-tooltip": true, prop: "quantity", label: "数量", align: "center" })) : f("", true), e(y).visible("netWeight") ? (i(), d(m, { key: 7, "show-overflow-tooltip": true, prop: "netWeight", label: "单净重（kg）", align: "center" })) : f("", true), e(y).visible("grossWeight") ? (i(), d(m, { key: 8, "show-overflow-tooltip": true, prop: "grossWeight", label: "单毛重（kg）", align: "center" })) : f("", true)]), _: 1 }, 8, ["data", "empty-text", "dataFormat", "max-height"])), [[de, e(t).loading]]), s(e(Ue))])], 64)) : (i(), d(P, { key: 0, type: "info", size: "large" }, { default: p(() => l[9] || (l[9] = [q(" * 请点击左侧工序列表查看详情 ")])), _: 1, __: [9] }))])])]);
  };
} }, $e = xe(Le, [["__scopeId", "data-v-6f8567ed"]]);
export {
  $e as default
};
