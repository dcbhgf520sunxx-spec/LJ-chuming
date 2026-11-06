import { ref as y } from "vue";
import { computed as C } from "vue";
import { watch as Ve } from "vue";
import { provide as Te } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as I } from "vue";
import { createVNode as r } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as s } from "vue";
import { unref as d } from "vue";
import { createBlock as c } from "vue";
import { createCommentVNode as v } from "vue";
import { Fragment as V } from "vue";
import { renderList as O } from "vue";
import { withDirectives as Q } from "vue";
import { vShow as W } from "vue";
import { createTextVNode as ke } from "vue";
import { toDisplayString as _ } from "vue";
import { ElFormItem as Ee } from "element-plus";
import { ElOption as Le } from "element-plus";
import { ElSelect as Ce } from "element-plus";
import { ElCascader as Ne } from "element-plus";
import { ElForm as Pe } from "element-plus";
import { ElCard as Ue } from "element-plus";
import { ElTag as Se } from "element-plus";
import { ElTableColumn as Ae } from "element-plus";
import { ElInputNumber as Oe } from "element-plus";
import { vLoading as Qe } from "element-plus";
import { l as k, _ as Re, o$ as T, x as qe, q5 as Fe, o as je, a3 as m, fv as Ke, q as Me, aw as ze } from "../../../../../shared/runtime.js";
import { g as Be } from "../../../../../modules/process-config-df49251e.js";
import { g as $e } from "../../../../../modules/artifact-quota-config-f98bdf94.js";
import He from "./module/header.vue.js";
import { _ as De } from "../../../../../modules/index-c07af747.js";
import { _ as Ye } from "../../../../../modules/process-select-b35dffc0.js";
import { u as Je } from "../../../../../modules/use-production-team-d8043fd6.js";
function Ge(i) {
  return k({ module: "mes", url: "quota-config/manual-report/unreported-list", method: "get", params: i });
}
function go(i, w) {
  return k({ module: "mes", url: "quota-config/manual-report/batch-add-produce-report", method: "post", params: i, data: w });
}
function Xe(i) {
  return k({ module: "mes", url: "quota-config/manual-report/flexible-process-unreported-list", method: "get", params: i });
}
function vo(i, w) {
  return k({ module: "mes", url: "quota-config/manual-report/flexible-process-batch-add-produce-report", method: "post", params: i, data: w });
}
function We(i) {
  return k({ url: "/api/mes/enclosure/team/common-list", method: "get", params: i });
}
const Z = { get: Ge };
const Ze = { class: "flex-rbc" }, eo = { class: "button-list" }, oo = { class: "flex-rbc" }, ao = { class: "flex-rbc" }, lo = { class: "flex-rbc" }, to = { class: "head-container" }, ro = { __name: "index", props: { addList: { type: Array, default: () => [] } }, emits: ["update:addList"], setup(i, { expose: w, emit: ee }) {
  const R = ee, q = i, F = y(), oe = { boolFixedProcess: T.YES.V, workshopId: void 0, productType: void 0, processId: void 0, teamId: void 0, projectId: void 0, monomerId: void 0, areaId: void 0 }, e = y(JSON.parse(JSON.stringify(oe))), { loaded: ae, productionTeam: N } = Je();
  console.log(N, "productionTeamproductionTeamproductionTeam");
  const j = ["workshopId", "productType", "processId", "teamId", "projectId", "monomerId", "areaId"], P = y([]), { crud: b, CRUD: K } = qe({ title: "人工上报", permission: { ...Fe }, sort: [], crudApi: { ...Z }, dataPath: "", queryOnPresenterCreated: false, hasPagination: false }, F), { maxHeight: le } = je({ extraBox: [".manual-filling", ".head-container"], paginate: false, extraHeight: 64 }), te = { unreportedQuantity: [{ required: true, message: "请输入数量", trigger: "change" }] }, { tableValidate: re, wrongCellMask: ne } = ze({ rules: te }), E = y([]), M = y([]), z = y([]);
  y([]);
  const B = y([]), $ = y([]), de = C(() => ({ value: "value", label: "label", children: "children", expandTrigger: "hover", checkStrictly: false, emitPath: false })), H = C(() => {
    const t = N.value.filter((l) => l.workshopId === e.value.workshopId && l.processId === e.value.processId), o = /* @__PURE__ */ new Map();
    return t.forEach((l) => {
      o.has(l.productionLineId) || o.set(l.productionLineId, { label: l.productionLineName, value: l.productionLineId, children: [] }), o.get(l.productionLineId).children.push({ label: l.label, value: l.id });
    }), Array.from(o.values());
  }), D = C(() => e.value.productType === m.ENCLOSURE.V);
  K.HOOK.handleRefresh = (t, { data: o }) => {
    o = o.map((l) => (l.serialNumber = l.product.serialNumber, l.specification = l.product.specification, l.monomerId = l.monomer.id, l.monomerName = l.monomer.name, l.areaId = l.area.id, l.areaName = l.area.name, l.projectId = l.project.id, l.id = l.taskProcessId, l.rowKey = `${l.taskProcessId ?? ""}_${l.taskId ?? ""}`, l.teamId = e.value.teamId || void 0, l.reportQuantity = l.unreportedQuantity, l.sourceUnreportedQuantity = l.unreportedQuantity, l.reportPersonId = -1, l));
  };
  const Y = C(() => [e.value.workshopId, e.value.productType, e.value.processId, e.value.teamId, e.value.projectId, e.value.monomerId, e.value.areaId].every(Boolean));
  function se(t) {
    E.value = t || [], E.value.length > 0 && !e.value.areaId && (e.value.areaId = E.value[0].id);
  }
  const ue = { workshopId: [{ required: true, message: "请选择车间", trigger: "change" }], productType: [{ required: true, message: "请选择产品类型", trigger: "change" }], processId: [{ required: true, message: "请选择工序", trigger: "change" }], teamId: [{ required: true, message: "请选择班组", trigger: "change" }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }], monomerId: [{ required: true, message: "请选择单体", trigger: "change" }], areaId: [{ required: true, message: "请选择区域", trigger: "change" }] };
  function J(t) {
    var o;
    console.log(t, "teamChange teamChange teamChange"), t ? (console.log(e.value.teamId), P.value = ((o = N.value.find((l) => l.id === t)) == null ? void 0 : o.userLinkList) || []) : P.value = [];
  }
  K.HOOK.beforeToQuery = async (t) => {
    R("update:addList", []), e.value.boolFixedProcess === T.YES.V ? t.crudApi.get = Z.get : t.crudApi.get = Xe, j.forEach((o) => {
      t.query[o] = e.value[o];
    });
  };
  async function G() {
    try {
      const t = await Be({ boolFixedProcess: e.value.boolFixedProcess ?? void 0, productType: e.value.productType || void 0 });
      $.value = t || [];
    } catch (t) {
      console.log(t);
    }
  }
  Ve(() => j.map((t) => e.value[t]), (t) => {
    t.every((o) => o != null && o !== "") && b.toQuery();
  });
  function ie(t) {
    e.value.teamId = void 0;
  }
  function U(t) {
    console.log(H.value, "lineTeamOptions"), e.value.teamId = void 0;
  }
  function pe(t) {
    G(), e.value.processId = void 0, e.value.teamId = void 0;
  }
  function ce(t) {
    e.value.productType && G(), e.value.processId = void 0, e.value.teamId = void 0;
  }
  function me(t) {
    const { validResult: o } = re(b.data);
    if (!o) return o;
    t.reportPersonId = -1, q.addList.some((l) => l.rowKey === t.rowKey) || R("update:addList", [...q.addList, t]);
  }
  async function fe() {
    var t;
    try {
      const { content: o = [] } = await We();
      z.value = Array.from((t = new Map(o == null ? void 0 : o.map((l) => [l.processId, l]))) == null ? void 0 : t.values()) || [], M.value = o == null ? void 0 : o.map((l) => {
        const p = (l.userLinkList || []).find((L) => L.boolLeaderEnum === true);
        return p ? { teamId: l.id, teamName: p.userName } : null;
      }).filter(Boolean);
    } catch (o) {
      console.log(o);
    }
  }
  async function ye() {
    try {
      const { content: t } = await $e({ mesProductEnum: 1 });
      B.value = t || [];
    } catch (t) {
      console.log(t);
    }
  }
  return ye(), fe(), Te("artifactTypeList", B), w({ refresh: b.toQuery, crewList: P, form: e.value }), (t, o) => {
    const l = x("common-radio-button"), p = Ee, L = x("common-select"), S = Le, A = Ce, ge = Ne, ve = Pe, X = Ue, be = Se, f = Ae, he = x("table-cell-tag"), Ie = Oe, _e = x("common-button"), we = x("common-table"), xe = Qe;
    return u(), I("div", null, [r(X, { shadow: "always", class: "manual-filling", style: { "margin-bottom": "4px" } }, { header: n(() => [s("div", Ze, [o[11] || (o[11] = s("span", { class: "card-title" }, "人工填报", -1)), s("div", eo, [r(l, { modelValue: e.value.boolFixedProcess, "onUpdate:modelValue": o[0] || (o[0] = (a) => e.value.boolFixedProcess = a), options: d(T).ENUM, type: "enum", size: "default", class: "filter-item", onChange: ce }, null, 8, ["modelValue", "options"])])])]), default: n(() => [r(ve, { model: e.value, rules: ue, "label-width": "0" }, { default: n(() => [s("div", oo, [r(p, { prop: "workshopId" }, { default: n(() => [r(d(De), { modelValue: e.value.workshopId, "onUpdate:modelValue": o[1] || (o[1] = (a) => e.value.workshopId = a), placeholder: "车间", class: "filter-item", clearable: "", style: { width: "220px" }, onChange: ie }, null, 8, ["modelValue"])]), _: 1 }), r(p, { prop: "productType" }, { default: n(() => [r(L, { modelValue: e.value.productType, "onUpdate:modelValue": o[2] || (o[2] = (a) => e.value.productType = a), options: d(m).ENUM, type: "enum", "unshow-options": [d(m).MACHINE_PART.K, d(m).AUXILIARY_MATERIAL.K, d(m).ENCLOSURE.K], clearable: "", class: "filter-item", placeholder: "产品类型", style: { width: "220px" }, onChange: pe }, null, 8, ["modelValue", "options", "unshow-options"])]), _: 1 })]), s("div", ao, [r(p, { prop: "processId" }, { default: n(() => [e.value.productType !== d(m).ENCLOSURE.V && e.value.boolFixedProcess === d(T).YES.V ? (u(), c(d(Ye), { key: 0, modelValue: e.value.processId, "onUpdate:modelValue": o[3] || (o[3] = (a) => e.value.processId = a), size: "default", filterable: "", clearable: "", placeholder: "工序", multiple: false, disabled: !e.value.productType, productType: e.value.productType, style: { width: "220px" }, onChange: U }, null, 8, ["modelValue", "disabled", "productType"])) : v("", true), e.value.productType !== d(m).ENCLOSURE.V && e.value.boolFixedProcess === d(T).NO.V ? (u(), c(A, { key: 1, modelValue: e.value.processId, "onUpdate:modelValue": o[4] || (o[4] = (a) => e.value.processId = a), placeholder: "工序", size: "default", style: { width: "220px" }, disabled: !e.value.productType, onChange: U }, { default: n(() => [(u(true), I(V, null, O($.value, (a) => (u(), c(S, { key: a.id, label: a.name, value: a.id }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue", "disabled"])) : v("", true), e.value.productType === d(m).ENCLOSURE.V ? (u(), c(A, { key: 2, modelValue: e.value.processId, "onUpdate:modelValue": o[5] || (o[5] = (a) => e.value.processId = a), placeholder: "工序", size: "default", style: { width: "220px" }, onChange: U }, { default: n(() => [(u(true), I(V, null, O(z.value, (a) => (u(), c(S, { key: a.processId, label: a.processName, value: a.processId }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])) : v("", true)]), _: 1 }), r(p, { prop: "teamId" }, { default: n(() => [e.value.productType !== d(m).ENCLOSURE.V ? (u(), c(ge, { key: 0, modelValue: e.value.teamId, "onUpdate:modelValue": o[6] || (o[6] = (a) => e.value.teamId = a), props: de.value, options: H.value, placeholder: "班组", size: "default", disabled: !d(ae) || !e.value.workshopId || !e.value.processId, style: { width: "220px" }, "show-all-levels": false, onChange: J }, null, 8, ["modelValue", "props", "options", "disabled"])) : v("", true), e.value.productType === d(m).ENCLOSURE.V ? (u(), c(A, { key: 1, modelValue: e.value.teamId, "onUpdate:modelValue": o[7] || (o[7] = (a) => e.value.teamId = a), placeholder: "班组", size: "default", style: { width: "220px" }, onChange: J }, { default: n(() => [(u(true), I(V, null, O(M.value, (a) => (u(), c(S, { key: a.teamId, label: a.teamName, value: a.teamId }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])) : v("", true)]), _: 1 })]), s("div", null, [r(p, { prop: "projectId" }, { default: n(() => [r(d(Ke), { modelValue: e.value.projectId, "onUpdate:modelValue": o[8] || (o[8] = (a) => e.value.projectId = a), clearable: "", placeholder: "项目", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), s("div", lo, [r(p, { prop: "monomerId" }, { default: n(() => [r(d(Me), { modelValue: e.value.monomerId, "onUpdate:modelValue": o[9] || (o[9] = (a) => e.value.monomerId = a), "project-id": e.value.projectId, default: "", placeholder: "单体", class: "filter-item", style: { width: "220px" }, onGetAreaInfo: se }, null, 8, ["modelValue", "project-id"])]), _: 1 }), r(p, { prop: "areaId" }, { default: n(() => [r(L, { modelValue: e.value.areaId, "onUpdate:modelValue": o[10] || (o[10] = (a) => e.value.areaId = a), options: E.value, dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", class: "filter-item", placeholder: "区域", style: { width: "220px" } }, null, 8, ["modelValue", "options"])]), _: 1 })])]), _: 1 }, 8, ["model"])]), _: 1 }), Q(s("div", null, [r(be, { type: "info", size: "large" }, { default: n(() => o[12] || (o[12] = [ke(" *请先填写上方人工填报信息！")])), _: 1, __: [12] })], 512), [[W, !Y.value]]), Q(r(X, { shadow: "always", class: "incomplete-list" }, { header: n(() => o[13] || (o[13] = [s("span", { class: "card-title" }, "未完成列表", -1), s("div", { class: "button-list" }, null, -1)])), default: n(() => [s("div", to, [r(d(He))]), Q((u(), c(we, { ref_key: "tableRef", ref: F, data: d(b).data, "empty-text": d(b).emptyText, "max-height": d(le), "cell-class-name": d(ne), "return-source-data": "", "show-empty-symbol": false, style: { width: "100%" } }, { default: n(() => [r(f, { label: "序号", type: "index", align: "center", width: "50" }), D.value ? v("", true) : (u(), I(V, { key: 0 }, [r(f, { label: "编号", prop: "serialNumber", key: "serialNumber", "show-overflow-tooltip": "", align: "center" }, { default: n((a) => [a.row.boolAssist ? (u(), c(he, { key: 0, name: "协同", color: "#ff7300", offset: 0 })) : v("", true), s("span", null, _(a.row.serialNumber || "-"), 1)]), _: 1 }), r(f, { label: "规格", prop: "specification", key: "specification", "show-overflow-tooltip": "", align: "center", "min-width": "110" }, { default: n((a) => [s("span", null, _(a.row.specification || "-"), 1)]), _: 1 }), r(f, { label: "未上报数", prop: "unreportedQuantity", key: "unreportedQuantity", align: "center", "min-width": "70" }, { default: n((a) => {
      var g;
      return [r(Ie, { modelValue: a.row.unreportedQuantity, "onUpdate:modelValue": (h) => a.row.unreportedQuantity = h, placeholder: "输入", min: 1, max: a.row.sourceUnreportedQuantity, step: 1, disabled: (g = i.addList) == null ? void 0 : g.some((h) => h.rowKey === a.row.rowKey), "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "disabled"])];
    }), _: 1 })], 64)), D.value ? (u(), I(V, { key: 1 }, [r(f, { label: "类型", prop: "dict", key: "dict", align: "center" }, { default: n((a) => {
      var g;
      return [s("span", null, _(((g = a.row.dict) == null ? void 0 : g.label) || "-"), 1)];
    }), _: 1 }), r(f, { label: "版型", prop: "productSerialNumbers", key: "productSerialNumbers", align: "center" }, { default: n((a) => [s("span", null, _(a.row.productSerialNumbers || "-"), 1)]), _: 1 }), r(f, { label: "数量(张)", prop: "unreportedQuantity", key: "unreportedQuantity", align: "center" }, { default: n((a) => [s("span", null, _(a.row.unreportedQuantity || "-"), 1)]), _: 1 }), r(f, { label: "单长（米）", prop: "reportQuantity", key: "reportQuantity", align: "center" }, { default: n((a) => [s("span", null, _(a.row.reportQuantity || "-"), 1)]), _: 1 })], 64)) : v("", true), r(f, { label: "操作", align: "center", width: "65" }, { default: n((a) => {
      var g;
      return [r(_e, { icon: "el-icon-plus", size: "default", type: "success", disabled: (g = i.addList) == null ? void 0 : g.some((h) => h.rowKey === a.row.rowKey), onClick: (h) => me(a.row) }, null, 8, ["disabled", "onClick"])];
    }), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "cell-class-name"])), [[xe, d(b).loading]])]), _: 1 }, 512), [[W, Y.value]])]);
  };
} }, no = Re(ro, [["__scopeId", "data-v-e6bda209"]]), bo = Object.freeze(Object.defineProperty({ __proto__: null, default: no }, Symbol.toStringTag, { value: "Module" }));
export {
  go as b,
  vo as f,
  bo as i,
  no as u
};
