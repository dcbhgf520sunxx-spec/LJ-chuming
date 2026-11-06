import { ref as c } from "vue";
import { computed as Z } from "vue";
import { provide as $ } from "vue";
import { watch as f } from "vue";
import { resolveComponent as x } from "vue";
import { resolveDirective as J } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as X } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { withDirectives as q } from "vue";
import { vShow as L } from "vue";
import { withCtx as m } from "vue";
import { createTextVNode as N } from "vue";
import { toDisplayString as b } from "vue";
import { withModifiers as T } from "vue";
import { createBlock as u } from "vue";
import { createCommentVNode as p } from "vue";
import { ElTag as Y } from "element-plus";
import { ElInput as ee } from "element-plus";
import { ElTableColumn as te } from "element-plus";
import { vLoading as oe } from "element-plus";
import { g as re } from "../../../../modules/process-sluggish-cb943bdd.js";
import { _ as ae, x as ne, rP as E, o as ie, bb as se, bZ as le, E as ue, z as de, bo as W, p as pe, P as ce, cf as me } from "../../../../shared/runtime.js";
import ye from "./module/header.vue.js";
import fe from "./production-line-detail/index.vue.js";
const ge = { class: "app-container" }, he = { class: "app-wrap" }, ve = { class: "project-chart" }, _e = { class: "head-container" }, we = { class: "content", style: { padding: "0 0 0 20px" } }, be = { class: "head-container" }, Ie = { style: { display: "flex", "justify-content": "space-between" } }, ke = { __name: "index", setup(xe) {
  const P = { add: false, edit: false, del: false, download: false }, z = c([["createTime", "parse-time"], ["startDate", ["parse-time", "{y}-{m}-{d}"]], ["endDate", ["parse-time", "{y}-{m}-{d}"]], ["completeDate", ["parse-time", "{y}-{m}-{d}"]]]), S = c(), g = c(), D = c([]), h = c({}), y = c(), v = c(), _ = c(), w = c(), C = Z(() => t.query.workShopId);
  $("workShopId", C);
  const { crud: t, CRUD: R, columns: d } = ne({ title: "工序呆滞", sort: [], optShow: { ...P }, crudApi: { get: re }, permission: { ...E }, requiredQuery: ["processId", "productType"], hasPagination: true }, S);
  f(() => y.value, (o) => {
    t.query.projectId = y.value, t.toQuery();
  }), f(() => g.value, (o) => {
    t.query.groupId = o, t.toQuery();
  }), f(() => v.value, (o) => {
    t.query.monomerId = v.value, t.toQuery();
  }), f(() => _.value, (o) => {
    t.query.areaId = _.value, t.toQuery();
  }), f(() => w.value, (o) => {
    t.query.serialNumber = w.value, t.toQuery();
  }), f(() => C.value, (o) => {
    h.value = {}, t.toQuery();
  });
  const { maxHeight: U } = ie({ paginate: true });
  function M(o) {
    var a, I, k;
    h.value = o, t.query.processId = (a = o == null ? void 0 : o.process) == null ? void 0 : a.id, t.query.productType = o == null ? void 0 : o.productType, g.value = void 0, ((I = o == null ? void 0 : o.process) == null ? void 0 : I.type) === me.DRILL_HOLE.V ? t.query.productionLineId = void 0 : t.query.productionLineId = (k = o == null ? void 0 : o.productionLine) == null ? void 0 : k.id, D.value = o == null ? void 0 : o.groupList, t.toQuery();
  }
  function O() {
    t.toQuery();
  }
  function B() {
    v.value = void 0, _.value = void 0, y.value = void 0, w.value = void 0, g.value = void 0, t.toQuery();
  }
  return R.HOOK.handleRefresh = (o, a) => {
  }, (o, a) => {
    var V, j;
    const I = Y, k = x("common-radio-button"), H = x("print-table"), A = ee, Q = x("common-button"), l = te, F = x("common-table"), G = J("permission"), K = oe;
    return s(), X("div", ge, [n("div", he, [n("div", ve, [n("div", _e, [i(e(ye))]), i(fe, { workShopId: e(t).query.workShopId, weightStatus: e(t).query.weightStatus, onChange: M }, null, 8, ["workShopId", "weightStatus"])]), a[8] || (a[8] = n("div", { style: { "border-right": "1px solid #ededed", margin: "0 20px", height: "calc(100vh - 130px)" } }, null, -1)), n("div", we, [q(n("div", null, a[5] || (a[5] = [n("div", { class: "my-code" }, "*点击左侧未完成任务的工序图表查看详情", -1)]), 512), [[L, !((V = h.value.process) != null && V.id)]]), q(n("div", null, [n("div", be, [n("div", Ie, [n("div", null, [i(I, { class: "filter-item", size: "default" }, { default: m(() => {
      var r;
      return [N("工序：" + b((r = h.value.process) == null ? void 0 : r.name), 1)];
    }), _: 1 }), i(se, { modelValue: y.value, "onUpdate:modelValue": a[0] || (a[0] = (r) => y.value = r), clearable: "", class: "filter-item" }, null, 8, ["modelValue"]), i(k, { modelValue: g.value, "onUpdate:modelValue": a[1] || (a[1] = (r) => g.value = r), options: D.value, type: "other", class: "filter-item", showOptionAll: "", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", onChange: e(t).toQuery }, null, 8, ["modelValue", "options", "onChange"])]), q(i(H, { "api-key": "mesProcessList", params: { productionLineId: e(t).query.productionLineId, productType: e(t).query.productType, processId: e(t).query.processId, projectId: e(t).query.projectId, monomerId: e(t).query.monomerId, areaId: e(t).query.areaId, serialNumber: e(t).query.serialNumber, groupId: e(t).query.groupId }, size: "default", type: "warning" }, null, 8, ["params"]), [[G, e(E).print]])]), i(e(ue), null, { optLeft: m(() => [i(e(le), { monomerId: v.value, "onUpdate:monomerId": a[2] || (a[2] = (r) => v.value = r), areaId: _.value, "onUpdate:areaId": a[3] || (a[3] = (r) => _.value = r), needConvert: "", clearable: "", "project-id": y.value }, null, 8, ["monomerId", "areaId", "project-id"]), i(A, { modelValue: w.value, "onUpdate:modelValue": a[4] || (a[4] = (r) => w.value = r), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), i(Q, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: T(O, ["stop"]) }, { default: m(() => a[6] || (a[6] = [N(" 搜索 ")])), _: 1, __: [6] }), i(Q, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: T(B, ["stop"]) }, { default: m(() => a[7] || (a[7] = [N(" 重置 ")])), _: 1, __: [7] })]), _: 1 })]), q((s(), u(F, { ref_key: "tableRef", ref: S, data: e(t).data, "data-format": z.value, "return-source-data": "", "empty-text": e(t).emptyText, "max-height": e(U) - 50, style: { width: "100%" } }, { default: m(() => [i(l, { prop: "index", label: "序号", align: "center", width: "60", type: "index", fixed: "left" }), e(d).visible("project") ? (s(), u(l, { key: "project.shortName", prop: "project", "show-overflow-tooltip": true, "min-width": "150", label: "项目" }, { default: m((r) => [n("span", null, b(e(de)(r.row.project)), 1)]), _: 1 })) : p("", true), e(d).visible("monomer.name") ? (s(), u(l, { key: "monomer.name", prop: "monomer.name", "show-overflow-tooltip": true, "min-width": "110", align: "center", label: "单体" })) : p("", true), e(d).visible("area.name") ? (s(), u(l, { "show-overflow-tooltip": true, key: "area.name", prop: "area.name", label: "区域", align: "center", "min-width": "100" })) : p("", true), e(d).visible("serialNumber") ? (s(), u(l, { "show-overflow-tooltip": true, key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "min-width": "100" })) : p("", true), e(d).visible("specification") ? (s(), u(l, { "show-overflow-tooltip": true, key: "specification", prop: "specification", label: "规格", align: "center", "min-width": "100" })) : p("", true), e(d).visible("unQuantity") ? (s(), u(l, { "show-overflow-tooltip": true, key: "unQuantity", prop: "unQuantity", label: "未完成数", align: "center" })) : p("", true), e(d).visible("netWeight") ? (s(), u(l, { "show-overflow-tooltip": true, key: "netWeight", prop: "netWeight", label: "单重（kg）", align: "center" }, { default: m(({ row: r }) => [n("span", null, b(e(t).query.weightStatus === e(W).NET.V ? r.netWeight : r.grossWeight), 1)]), _: 1 })) : p("", true), e(d).visible("unNetWeight") ? (s(), u(l, { "show-overflow-tooltip": true, key: "unNetWeight", prop: "unNetWeight", label: "总重（kg）", align: "center" }, { default: m(({ row: r }) => [n("span", null, b(e(t).query.weightStatus === e(W).NET.V ? r.unNetWeight : r.unGrossWeight), 1)]), _: 1 })) : p("", true), e(d).visible("completeDate") ? (s(), u(l, { "show-overflow-tooltip": true, key: "completeDate", prop: "completeDate", label: "完成日期", align: "center" }, { default: m((r) => [n("span", null, b(r.row.completeDate ? e(pe)(r.row.completeDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : p("", true), e(d).visible("groupName") ? (s(), u(l, { "show-overflow-tooltip": true, key: "groupName", prop: "groupName", label: "负责班组", align: "center" })) : p("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[K, e(t).loading]]), i(e(ce))], 512), [[L, (j = h.value.process) == null ? void 0 : j.id]])])])]);
  };
} }, Qe = ae(ke, [["__scopeId", "data-v-4b120f41"]]);
export {
  Qe as default
};
