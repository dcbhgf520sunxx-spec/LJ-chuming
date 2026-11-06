import { useStore as ie } from "vuex";
import { useRouter as re } from "vue-router";
import { ref as p } from "vue";
import { inject as N } from "vue";
import { computed as Q } from "vue";
import { watch as U } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as ue } from "vue";
import { openBlock as de } from "vue";
import { createBlock as pe } from "vue";
import { withCtx as n } from "vue";
import { createVNode as a } from "vue";
import { unref as o } from "vue";
import { withKeys as me } from "vue";
import { withModifiers as T } from "vue";
import { createTextVNode as x } from "vue";
import { createElementVNode as u } from "vue";
import { withDirectives as ce } from "vue";
import { toDisplayString as m } from "vue";
import { normalizeClass as W } from "vue";
import { isRef as fe } from "vue";
import { ElInput as ve } from "element-plus";
import { ElTableColumn as ge } from "element-plus";
import { ElPagination as ye } from "element-plus";
import { a as he } from "../../../../../../modules/project-overview-1b3937a7.js";
import { u as be, J as we, o as Ie, ch as _e, aV as ke, bZ as Ve, ng as Ce, pH as Ne, bo as M, a3 as Te, ba as xe } from "../../../../../../shared/runtime.js";
import { _ as je } from "../../../../../../modules/production-line-select-f08e245b.js";
const De = { style: { display: "flex" } }, Se = ["onClick"], Ue = { __name: "index", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} }, projectId: { type: Number }, weightStatus: { type: Number }, dateQuery: { type: Object } }, emits: ["update:visible"], setup(b, { emit: R }) {
  const q = ie(), L = re(), A = R, j = p([]), c = p(), f = p(), v = p(), g = p(), y = p(), w = p(), i = b, B = N("monomerId"), G = N("areaId"), H = N("productionLineId"), D = Q(() => ({ productType: i.detailData.productType, processId: i.detailData.id, projectId: i.projectId, ...i.dateQuery })), k = Q(() => ({ workshopId: c.value, productionLineId: f.value ? f.value : H.value, monomerId: v.value ? v.value : B.value, areaId: g.value ? g.value : G.value, status: w.value })), { visible: I, handleClose: S } = be({ emit: A, props: i, field: "visible", showHook: d }), { handleSizeChange: O, handleCurrentChange: $, total: K, setTotalPage: J, queryPage: V } = we({ fetchHook: d });
  U(() => I.value, (l) => {
    c.value = void 0, f.value = void 0, v.value = void 0, g.value = void 0, y.value = void 0, w.value = void 0, d();
  }, { deep: true }), U(() => k.value, (l) => {
    l && d();
  });
  async function d() {
    let l = [];
    if (I.value) try {
      const { content: t = [], totalElements: h } = await he({ serialNumber: y.value, ...k.value, ...D.value, ...V });
      J(h), l = t;
    } catch (t) {
      console.log("获取工序的生产明细失败", t);
    } finally {
      j.value = l;
    }
  }
  const { maxHeight: Z } = Ie({ paginate: true });
  function F() {
    d();
  }
  function X() {
    c.value = void 0, f.value = void 0, v.value = void 0, g.value = void 0, y.value = void 0, w.value = void 0, d();
  }
  function Y(l) {
    var t, h;
    q.dispatch("project/setProjectId", i.projectId), L.push({ name: "MesProductionDashboardArtifactDashboard", params: { serialNumber: l.serialNumber, monomerId: (t = l.monomer) == null ? void 0 : t.id, areaId: (h = l.area) == null ? void 0 : h.id, id: l.id, projectId: i.projectId, productType: i.detailData.productType } });
  }
  function ee(l) {
    return xe(l, { props: ["quantity", "taskNetWeight", "taskGrossWeight", "completeQuantity", "completeNetWeight", "completeGrossWeight"] });
  }
  return (l, t) => {
    var z, E;
    const h = _("common-radio-button"), te = ve, C = _("common-button"), ae = _("print-table"), s = ge, oe = _("common-table"), le = ye, ne = _("common-dialog"), se = ue("permission");
    return de(), pe(ne, { ref: "drawerRef", fullscreen: "", modelValue: o(I), "onUpdate:modelValue": t[6] || (t[6] = (e) => fe(I) ? I.value = e : null), title: `${o(Te).VL[(z = i.detailData) == null ? void 0 : z.productType]}：${(E = i.detailData) == null ? void 0 : E.name}生产明细`, "before-close": o(S), "close-on-click-modal": false, "show-close": false }, { titleAfter: n(() => [a(h, { type: "enum", style: { "vertical-align": "middle" }, modelValue: w.value, "onUpdate:modelValue": t[0] || (t[0] = (e) => w.value = e), showOptionAll: "", options: o(_e).ENUM }, null, 8, ["modelValue", "options"]), a(ke, { modelValue: c.value, "onUpdate:modelValue": t[1] || (t[1] = (e) => c.value = e), placeholder: "请选择车间", "factory-id": l.factoryId, style: { width: "150px" }, class: "filter-item", clearable: true }, null, 8, ["modelValue", "factory-id"]), a(o(je), { modelValue: f.value, "onUpdate:modelValue": t[2] || (t[2] = (e) => f.value = e), "factory-id": l.factoryId, "workshop-id": c.value, productType: b.detailData.productType, clearable: true, class: "filter-item", style: { width: "150px" } }, null, 8, ["modelValue", "factory-id", "workshop-id", "productType"]), a(o(Ve), { monomerId: v.value, "onUpdate:monomerId": t[3] || (t[3] = (e) => v.value = e), areaId: g.value, "onUpdate:areaId": t[4] || (t[4] = (e) => g.value = e), productType: o(Ce).STRUCTURE.V, needConvert: "", clearable: "", areaClearable: "", "project-id": b.projectId }, null, 8, ["monomerId", "areaId", "productType", "project-id"]), a(te, { modelValue: y.value, "onUpdate:modelValue": t[5] || (t[5] = (e) => y.value = e), modelModifiers: { trim: true }, placeholder: "编号搜索", style: { width: "150px" }, class: "filter-item", clearable: "", onKeyup: me(d, ["enter"]) }, null, 8, ["modelValue"]), a(C, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: T(F, ["stop"]) }, { default: n(() => t[7] || (t[7] = [x("搜索")])), _: 1, __: [7] }), a(C, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: T(X, ["stop"]) }, { default: n(() => t[8] || (t[8] = [x(" 重置 ")])), _: 1, __: [8] })]), titleRight: n(() => [u("div", De, [ce(a(ae, { "api-key": "mesProjectOverviewList", params: { ...D.value, ...k.value, serialNumber: y.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[se, o(Ne).print]]), a(C, { size: "default", style: { "margin-left": "8px" }, onClick: o(S) }, { default: n(() => t[9] || (t[9] = [x("关 闭")])), _: 1, __: [9] }, 8, ["onClick"])])]), default: n(() => [a(oe, { ref: "tableRef", data: j.value, "max-height": o(Z) + 110, "show-empty-symbol": false, "show-summary": "", "summary-method": ee, style: { width: "100%" } }, { default: n(() => [a(s, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), a(s, { "show-overflow-tooltip": true, prop: "workshop", label: "车间/产线", "header-align": "center", "min-width": "140px" }, { default: n(({ row: e }) => {
      var r, P;
      return [u("span", null, m(((r = e.workshop) == null ? void 0 : r.name) + "/" + ((P = e.productionLine) == null ? void 0 : P.name)), 1)];
    }), _: 1 }), a(s, { "show-overflow-tooltip": true, prop: "monomer.name", label: "单体", align: "center", "min-width": "100px" }, { default: n(({ row: e }) => {
      var r;
      return [u("span", null, m(e.monomer ? (r = e.monomer) == null ? void 0 : r.name : "/"), 1)];
    }), _: 1 }), a(s, { "show-overflow-tooltip": true, prop: "area.name", label: "区域", align: "center", "min-width": "100px" }, { default: n(({ row: e }) => {
      var r;
      return [u("span", null, m(e.area ? (r = e.area) == null ? void 0 : r.name : "/"), 1)];
    }), _: 1 }), a(s, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", align: "center" }, { default: n(({ row: e }) => [u("span", { onClick: T((r) => Y(e), ["stop"]), style: { cursor: "pointer" }, class: "tc-primary" }, m(e.serialNumber), 9, Se)]), _: 1 }), a(s, { "show-overflow-tooltip": true, prop: "specification", label: "规格", align: "center" }), a(s, { "show-overflow-tooltip": true, prop: "material", label: "材质", align: "center" }), a(s, { "show-overflow-tooltip": true, prop: "quantity", label: "任务数", align: "center" }), a(s, { "show-overflow-tooltip": true, prop: "taskNetWeight", label: "任务量（kg）", align: "center" }, { default: n(({ row: e }) => [u("span", null, m(b.weightStatus === o(M).NET.V ? e.taskNetWeight : e.taskGrossWeight), 1)]), _: 1 }), a(s, { "show-overflow-tooltip": true, prop: "completeQuantity", label: "已生产数", align: "center" }, { default: n(({ row: e }) => [u("span", { class: W(e.completeQuantity === e.quantity ? "tc-success" : "tc-danger") }, m(e.completeQuantity), 3)]), _: 1 }), a(s, { "show-overflow-tooltip": true, prop: "completeNetWeight", label: "生产量（kg）", align: "center" }, { default: n(({ row: e }) => [u("span", { class: W(e.completeQuantity === e.quantity ? "tc-success" : "tc-danger") }, m(b.weightStatus === o(M).NET.V ? e.completeNetWeight : e.completeGrossWeight), 3)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), a(le, { total: o(K), "current-page": o(V).pageNumber, "page-size": o(V).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: o(O), onCurrentChange: o($) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "title", "before-close"]);
  };
} };
export {
  Ue as default
};
