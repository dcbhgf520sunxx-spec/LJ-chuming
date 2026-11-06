import { ref as p } from "vue";
import { computed as $ } from "vue";
import { provide as G } from "vue";
import { watch as y } from "vue";
import { resolveComponent as x } from "vue";
import { resolveDirective as J } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as W } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as n } from "vue";
import { unref as t } from "vue";
import { withDirectives as k } from "vue";
import { vShow as L } from "vue";
import { withCtx as f } from "vue";
import { createTextVNode as q } from "vue";
import { toDisplayString as D } from "vue";
import { withModifiers as T } from "vue";
import { createBlock as d } from "vue";
import { createCommentVNode as c } from "vue";
import { ElTag as X } from "element-plus";
import { ElInput as Y } from "element-plus";
import { ElTableColumn as ee } from "element-plus";
import { vLoading as te } from "element-plus";
import { g as oe } from "../../../../modules/process-sluggish-6aee505d.js";
import { I as P } from "../../../../modules/bridge-86f96a4f.js";
import { _ as re, x as ae, o as ie, bb as ne, bZ as se, z as le, p as de, P as ue, cf as pe } from "../../../../shared/runtime.js";
import ce from "./module/header.vue.js";
import me from "./production-line-detail/index.vue.js";
const ye = { class: "app-container" }, fe = { class: "app-wrap" }, ve = { class: "project-chart" }, _e = { class: "head-container" }, we = { class: "content", style: { padding: "0 0 0 20px" } }, ge = { style: { display: "flex", "justify-content": "space-between" } }, he = { class: "head-container" }, be = { __name: "index", setup(Ie) {
  const R = { add: false, edit: false, del: false, download: false }, U = p([["createTime", "parse-time"], ["startDate", ["parse-time", "{y}-{m}-{d}"]], ["endDate", ["parse-time", "{y}-{m}-{d}"]], ["completeDate", ["parse-time", "{y}-{m}-{d}"]]]), C = p(), v = p(), N = p([]), _ = p({}), m = p(), w = p(), g = p(), h = p(), Q = $(() => e.query.workShopId);
  G("workShopId", Q);
  const { crud: e, CRUD: z, columns: u } = ae({ title: "工序呆滞", sort: [], optShow: { ...R }, crudApi: { get: oe }, permission: { ...P }, invisibleColumns: [], requiredQuery: ["processId", "productType"], hasPagination: true }, C);
  y(() => m.value, (o) => {
    e.query.projectId = m.value, e.toQuery();
  }), y(() => v.value, (o) => {
    e.query.groupId = o, e.toQuery();
  }), y(() => w.value, (o) => {
    e.query.monomerId = w.value, e.toQuery();
  }), y(() => g.value, (o) => {
    e.query.areaId = g.value, e.toQuery();
  }), y(() => h.value, (o) => {
    e.query.serialNumber = h.value, e.toQuery();
  }), y(() => Q.value, (o) => {
    _.value = {}, e.toQuery();
  });
  const { maxHeight: E } = ie({ paginate: true });
  function M(o) {
    var r, b, I;
    _.value = o, e.query.processId = (r = o == null ? void 0 : o.process) == null ? void 0 : r.id, e.query.productType = o == null ? void 0 : o.productType, v.value = void 0, ((b = o == null ? void 0 : o.process) == null ? void 0 : b.type) === pe.DRILL_HOLE.V ? e.query.productionLineId = void 0 : e.query.productionLineId = (I = o == null ? void 0 : o.productionLine) == null ? void 0 : I.id, N.value = o == null ? void 0 : o.groupList, e.toQuery();
  }
  function B() {
    e.toQuery();
  }
  function H() {
    w.value = void 0, g.value = void 0, m.value = void 0, h.value = void 0, v.value = void 0, e.toQuery();
  }
  return z.HOOK.handleRefresh = (o, r) => {
  }, (o, r) => {
    var S, V;
    const b = X, I = x("common-radio-button"), O = Y, j = x("common-button"), A = x("print-table"), l = ee, F = x("common-table"), K = J("permission"), Z = te;
    return s(), W("div", ye, [i("div", fe, [i("div", ve, [i("div", _e, [n(t(ce))]), n(me, { workShopId: t(e).query.workShopId, onChange: M }, null, 8, ["workShopId"])]), r[8] || (r[8] = i("div", { style: { "border-right": "1px solid #ededed", margin: "0 20px", height: "calc(100vh - 130px)" } }, null, -1)), i("div", we, [k(i("div", null, r[5] || (r[5] = [i("div", { class: "my-code" }, "*点击左侧未完成任务的工序图表查看详情", -1)]), 512), [[L, !((S = _.value.process) != null && S.id)]]), k(i("div", null, [i("div", ge, [i("div", he, [n(b, { class: "filter-item" }, { default: f(() => {
      var a;
      return [q("工序：" + D((a = _.value.process) == null ? void 0 : a.name), 1)];
    }), _: 1 }), n(ne, { modelValue: m.value, "onUpdate:modelValue": r[0] || (r[0] = (a) => m.value = a), clearable: "", class: "filter-item", style: { width: "300px" } }, null, 8, ["modelValue"]), n(I, { modelValue: v.value, "onUpdate:modelValue": r[1] || (r[1] = (a) => v.value = a), options: N.value, type: "other", class: "filter-item", showOptionAll: "", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", onChange: t(e).toQuery }, null, 8, ["modelValue", "options", "onChange"]), i("div", null, [n(t(se), { monomerId: w.value, "onUpdate:monomerId": r[2] || (r[2] = (a) => w.value = a), areaId: g.value, "onUpdate:areaId": r[3] || (r[3] = (a) => g.value = a), needConvert: "", clearable: "", "project-id": m.value, style: { width: "100px !important" } }, null, 8, ["monomerId", "areaId", "project-id"]), n(O, { modelValue: h.value, "onUpdate:modelValue": r[4] || (r[4] = (a) => h.value = a), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), n(j, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: T(B, ["stop"]) }, { default: f(() => r[6] || (r[6] = [q(" 搜索 ")])), _: 1, __: [6] }), n(j, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: T(H, ["stop"]) }, { default: f(() => r[7] || (r[7] = [q(" 重置 ")])), _: 1, __: [7] })])]), k(n(A, { "api-key": "bridgeProcessList", params: { productionLineId: t(e).query.productionLineId, productType: t(e).query.productType, processId: t(e).query.processId, projectId: t(e).query.projectId, monomerId: t(e).query.monomerId, areaId: t(e).query.areaId, serialNumber: t(e).query.serialNumber, groupId: t(e).query.groupId }, style: { width: "300px" }, size: "default", type: "warning" }, null, 8, ["params"]), [[K, t(P).print]])]), k((s(), d(F, { ref_key: "tableRef", ref: C, data: t(e).data, "data-format": U.value, "return-source-data": "", "empty-text": t(e).emptyText, "max-height": t(E) - 50, style: { width: "100%" } }, { default: f(() => [n(l, { prop: "index", label: "序号", align: "center", width: "60", type: "index", fixed: "left" }), t(u).visible("project") ? (s(), d(l, { key: "project.shortName", prop: "project", "show-overflow-tooltip": true, "min-width": "160", label: "项目" }, { default: f((a) => [i("span", null, D(t(le)(a.row.project)), 1)]), _: 1 })) : c("", true), t(u).visible("monomer.name") ? (s(), d(l, { key: "monomer.name", prop: "monomer.name", "show-overflow-tooltip": true, "min-width": "120", align: "center", label: "单体" })) : c("", true), t(u).visible("area.name") ? (s(), d(l, { "show-overflow-tooltip": true, key: "area.name", prop: "area.name", label: "区域", align: "center", "min-width": "100" })) : c("", true), t(u).visible("serialNumber") ? (s(), d(l, { "show-overflow-tooltip": true, key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "min-width": "100" })) : c("", true), t(u).visible("specification") ? (s(), d(l, { "show-overflow-tooltip": true, key: "specification", prop: "specification", label: "规格", align: "center", "min-width": "100" })) : c("", true), t(u).visible("unQuantity") ? (s(), d(l, { "show-overflow-tooltip": true, key: "unQuantity", prop: "unQuantity", label: "未完成数", align: "center" })) : c("", true), t(u).visible("weight") ? (s(), d(l, { "show-overflow-tooltip": true, key: "weight", prop: "weight", label: "单重", align: "center" })) : c("", true), t(u).visible("completeDate") ? (s(), d(l, { "show-overflow-tooltip": true, key: "completeDate", prop: "completeDate", label: "完成日期", align: "center" }, { default: f((a) => [i("span", null, D(a.row.completeDate ? t(de)(a.row.completeDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : c("", true), t(u).visible("groupName") ? (s(), d(l, { "show-overflow-tooltip": true, key: "groupName", prop: "groupName", label: "负责班组", align: "center" })) : c("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[Z, t(e).loading]]), n(t(ue))], 512), [[L, (V = _.value.process) == null ? void 0 : V.id]])])])]);
  };
} }, Qe = re(be, [["__scopeId", "data-v-f5dd29ad"]]);
export {
  Qe as default
};
