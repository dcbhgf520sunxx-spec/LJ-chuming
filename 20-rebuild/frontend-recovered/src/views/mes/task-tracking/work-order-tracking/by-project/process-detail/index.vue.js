import { useStore as re } from "vuex";
import { useRouter as ue } from "vue-router";
import { ref as f } from "vue";
import { inject as x } from "vue";
import { computed as P } from "vue";
import { watch as U } from "vue";
import { resolveComponent as I } from "vue";
import { resolveDirective as de } from "vue";
import { openBlock as pe } from "vue";
import { createBlock as ce } from "vue";
import { withCtx as o } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as u } from "vue";
import { unref as l } from "vue";
import { createElementVNode as d } from "vue";
import { withDirectives as me } from "vue";
import { withKeys as fe } from "vue";
import { withModifiers as j } from "vue";
import { normalizeClass as D } from "vue";
import { isRef as ve } from "vue";
import { ElTag as ge } from "element-plus";
import { ElInput as ye } from "element-plus";
import { ElTableColumn as he } from "element-plus";
import { ElPagination as be } from "element-plus";
import { a as we } from "../../../../../../modules/project-overview-1b3937a7.js";
import { u as _e, J as Ie, o as ke, z as Ve, rU as Ce, ch as Ne, aV as xe, bZ as je, bo as q, a3 as De, ba as Te } from "../../../../../../shared/runtime.js";
import { _ as ze } from "../../../../../../modules/production-line-select-f08e245b.js";
const Se = { style: { display: "flex" } }, Ee = { class: "head-container" }, Qe = ["onClick"], Me = { __name: "index", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} }, projectId: { type: Number }, weightStatus: { type: Number }, dateQuery: { type: Object }, processData: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(p, { emit: M }) {
  const L = re(), B = ue(), O = M, T = f([]), v = f(), g = f(), y = f(), h = f(), b = f(), w = f(), r = p, R = x("monomerId"), A = x("areaId"), G = x("productionLineId"), z = P(() => ({ productType: r.detailData.productType, processId: r.detailData.id, projectId: r.projectId, ...r.dateQuery })), V = P(() => ({ workshopId: v.value, productionLineId: g.value ? g.value : G.value, monomerId: y.value ? y.value : R.value, areaId: h.value ? h.value : A.value, status: w.value })), { visible: _, handleClose: S } = _e({ emit: O, props: r, field: "visible", showHook: c }), { handleSizeChange: $, handleCurrentChange: H, total: K, setTotalPage: F, queryPage: C } = Ie({ fetchHook: c });
  U(() => _.value, (n) => {
    v.value = void 0, g.value = void 0, y.value = void 0, h.value = void 0, b.value = void 0, w.value = void 0, c();
  }, { deep: true }), U(() => V.value, (n) => {
    n && c();
  });
  async function c() {
    let n = [];
    if (_.value) try {
      const { content: t = [], totalElements: m } = await we({ serialNumber: b.value, ...V.value, ...z.value, ...C });
      F(m), n = t;
    } catch (t) {
      console.log("获取工序的生产明细失败", t);
    } finally {
      T.value = n;
    }
  }
  const { maxHeight: J } = ke({ extraBox: [".head-container"], paginate: true });
  function Z() {
    c();
  }
  function X() {
    v.value = void 0, g.value = void 0, y.value = void 0, h.value = void 0, b.value = void 0, w.value = void 0, c();
  }
  function Y(n) {
    var t, m;
    console.log(n, "row"), L.dispatch("project/setProjectId", r.projectId), B.push({ name: "MesProductionDashboardArtifactDashboard", params: { serialNumber: n.serialNumber, monomerId: (t = n.monomer) == null ? void 0 : t.id, areaId: (m = n.area) == null ? void 0 : m.id, id: n.id, projectId: r.projectId, productType: r.detailData.productType } });
  }
  function ee(n) {
    return Te(n, { props: ["quantity", "taskNetWeight", "taskGrossWeight", "completeQuantity", "completeNetWeight", "completeGrossWeight"] });
  }
  return (n, t) => {
    var E, Q;
    const m = ge, te = I("print-table"), N = I("common-button"), ae = I("common-radio-button"), oe = ye, s = he, le = I("common-table"), ne = be, se = I("common-dialog"), ie = de("permission");
    return pe(), ce(se, { ref: "drawerRef", fullscreen: "", modelValue: l(_), "onUpdate:modelValue": t[6] || (t[6] = (e) => ve(_) ? _.value = e : null), title: `${l(De).VL[(E = r.detailData) == null ? void 0 : E.productType]}：${(Q = r.detailData) == null ? void 0 : Q.name}生产明细`, "before-close": l(S), "close-on-click-modal": false, "show-close": false }, { titleAfter: o(() => [a(m, { type: "primary", size: "default" }, { default: o(() => {
      var e;
      return [k("项目： " + u(l(Ve)((e = p.processData) == null ? void 0 : e.project) || "-"), 1)];
    }), _: 1 }), a(m, { type: "warning", size: "default" }, { default: o(() => {
      var e;
      return [k("工序： " + u(((e = p.detailData) == null ? void 0 : e.name) || "-"), 1)];
    }), _: 1 })]), titleRight: o(() => [d("div", Se, [me(a(te, { "api-key": "mesProjectOverviewList", params: { ...z.value, ...V.value, serialNumber: b.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[ie, l(Ce).print]]), a(N, { size: "default", style: { "margin-left": "8px" }, onClick: l(S) }, { default: o(() => t[7] || (t[7] = [k("关 闭")])), _: 1, __: [7] }, 8, ["onClick"])])]), default: o(() => [d("div", Ee, [a(ae, { type: "enum", style: { "vertical-align": "middle" }, modelValue: w.value, "onUpdate:modelValue": t[0] || (t[0] = (e) => w.value = e), showOptionAll: "", class: "filter-item", options: l(Ne).ENUM }, null, 8, ["modelValue", "options"]), a(xe, { modelValue: v.value, "onUpdate:modelValue": t[1] || (t[1] = (e) => v.value = e), placeholder: "请选择车间", "factory-id": n.factoryId, style: { width: "150px" }, class: "filter-item", clearable: true }, null, 8, ["modelValue", "factory-id"]), a(l(ze), { modelValue: g.value, "onUpdate:modelValue": t[2] || (t[2] = (e) => g.value = e), "factory-id": n.factoryId, "workshop-id": v.value, productType: p.detailData.productType, clearable: true, class: "filter-item", style: { width: "150px" } }, null, 8, ["modelValue", "factory-id", "workshop-id", "productType"]), a(l(je), { monomerId: y.value, "onUpdate:monomerId": t[3] || (t[3] = (e) => y.value = e), areaId: h.value, "onUpdate:areaId": t[4] || (t[4] = (e) => h.value = e), needConvert: "", clearable: "", areaClearable: "", "project-id": p.projectId }, null, 8, ["monomerId", "areaId", "project-id"]), a(oe, { modelValue: b.value, "onUpdate:modelValue": t[5] || (t[5] = (e) => b.value = e), modelModifiers: { trim: true }, placeholder: "编号搜索", style: { width: "150px" }, class: "filter-item", clearable: "", onKeyup: fe(c, ["enter"]) }, null, 8, ["modelValue"]), a(N, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: j(Z, ["stop"]) }, { default: o(() => t[8] || (t[8] = [k("搜索")])), _: 1, __: [8] }), a(N, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: j(X, ["stop"]) }, { default: o(() => t[9] || (t[9] = [k(" 重置 ")])), _: 1, __: [9] })]), a(le, { ref: "tableRef", data: T.value, "max-height": l(J) + 110, "show-empty-symbol": false, "show-summary": "", "summary-method": ee, style: { width: "100%" } }, { default: o(() => [a(s, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), a(s, { "show-overflow-tooltip": true, prop: "workshop", label: "车间/产线", align: "center", "min-width": "140px" }, { default: o(({ row: e }) => {
      var i, W;
      return [d("span", null, u(((i = e.workshop) == null ? void 0 : i.name) + "/" + ((W = e.productionLine) == null ? void 0 : W.name)), 1)];
    }), _: 1 }), a(s, { "show-overflow-tooltip": true, prop: "monomer.name", label: "单体", align: "center", "min-width": "100px" }, { default: o(({ row: e }) => {
      var i;
      return [d("span", null, u(e.monomer ? (i = e.monomer) == null ? void 0 : i.name : "/"), 1)];
    }), _: 1 }), a(s, { "show-overflow-tooltip": true, prop: "area.name", label: "区域", align: "center", "min-width": "100px" }, { default: o(({ row: e }) => {
      var i;
      return [d("span", null, u(e.area ? (i = e.area) == null ? void 0 : i.name : "/"), 1)];
    }), _: 1 }), a(s, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", align: "center" }, { default: o(({ row: e }) => [d("span", { onClick: j((i) => Y(e), ["stop"]), style: { cursor: "pointer" }, class: "tc-primary" }, u(e.serialNumber), 9, Qe)]), _: 1 }), a(s, { "show-overflow-tooltip": true, prop: "specification", label: "规格", align: "center" }), a(s, { "show-overflow-tooltip": true, prop: "material", label: "材质", align: "center" }), a(s, { "show-overflow-tooltip": true, prop: "quantity", label: "任务数", align: "center" }), a(s, { "show-overflow-tooltip": true, prop: "taskNetWeight", label: "任务量（kg）", align: "center" }, { default: o(({ row: e }) => [d("span", null, u(p.weightStatus === l(q).NET.V ? e.taskNetWeight : e.taskGrossWeight), 1)]), _: 1 }), a(s, { "show-overflow-tooltip": true, prop: "completeQuantity", label: "已生产数", align: "center" }, { default: o(({ row: e }) => [d("span", { class: D(e.completeQuantity === e.quantity ? "tc-success" : "tc-danger") }, u(e.completeQuantity), 3)]), _: 1 }), a(s, { "show-overflow-tooltip": true, prop: "completeNetWeight", label: "生产量（kg）", align: "center" }, { default: o(({ row: e }) => [d("span", { class: D(e.completeQuantity === e.quantity ? "tc-success" : "tc-danger") }, u(p.weightStatus === l(q).NET.V ? e.completeNetWeight : e.completeGrossWeight), 3)]), _: 1 }), a(s, { "show-overflow-tooltip": true, prop: "team.name", label: "班组", align: "center" }, { default: o(({ row: e }) => {
      var i;
      return [d("span", { class: D(e.completeQuantity === e.quantity ? "tc-success" : "tc-danger") }, u(((i = e.team) == null ? void 0 : i.name) || "-"), 3)];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), a(ne, { total: l(K), "current-page": l(C).pageNumber, "page-size": l(C).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: l($), onCurrentChange: l(H) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "title", "before-close"]);
  };
} };
export {
  Me as default
};
