import { ref as u } from "vue";
import { computed as q } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as A } from "vue";
import { openBlock as K } from "vue";
import { createBlock as F } from "vue";
import { withCtx as n } from "vue";
import { createVNode as t } from "vue";
import { unref as o } from "vue";
import { withKeys as J } from "vue";
import { withModifiers as C } from "vue";
import { createTextVNode as I } from "vue";
import { withDirectives as L } from "vue";
import { createElementVNode as b } from "vue";
import { toDisplayString as v } from "vue";
import { normalizeClass as x } from "vue";
import { isRef as Z } from "vue";
import { ElInput as G } from "element-plus";
import { ElTableColumn as O } from "element-plus";
import { ElPagination as X } from "element-plus";
import { a as Y } from "../../../../../modules/scheduling-data-3ad04307.js";
import { u as $, J as ee, o as te, bb as ae, bZ as oe, rE as le, z as ne } from "../../../../../shared/runtime.js";
const ue = { __name: "scheduling-detail", props: { visible: { type: Boolean, default: false }, dateTime: { type: Number }, workshopId: { type: Number } }, emits: ["update:visible"], setup(N, { emit: V }) {
  const z = V, y = u([]), i = u(), p = u(), c = u(), m = u(), s = N, _ = q(() => ({ projectId: i.value, monomerId: p.value, areaId: c.value, serialNumber: m.value })), { visible: d, handleClose: T } = $({ emit: z, props: s, field: "visible", showHook: r }), { handleSizeChange: Q, handleCurrentChange: j, total: S, setTotalPage: B, queryPage: f } = ee({ fetchHook: r }), { maxHeight: D } = te({ mainBox: ".scheduling-detail-drawer", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, d);
  async function r() {
    let h = [];
    try {
      const { content: a = [], totalElements: w } = await Y({ dateTime: s.dateTime, workshopId: s.workshopId, ..._.value, ...f });
      B(w), h = a;
    } catch (a) {
      console.log("获取排产数据详情失败", a);
    } finally {
      y.value = h;
    }
  }
  function H() {
    r();
  }
  function M() {
    i.value = void 0, p.value = void 0, c.value = void 0, m.value = void 0, r();
  }
  return (h, a) => {
    const w = G, k = g("common-button"), P = g("print-table"), l = O, R = g("common-table"), E = X, U = g("common-drawer"), W = A("permission");
    return K(), F(U, { ref: "drawerRef", "custom-class": "scheduling-detail-drawer", title: "排产及生产明细", modelValue: o(d), "onUpdate:modelValue": a[4] || (a[4] = (e) => Z(d) ? d.value = e : null), direction: "rtl", "before-close": o(T), size: "90%" }, { titleAfter: n(() => [t(o(ae), { modelValue: i.value, "onUpdate:modelValue": a[0] || (a[0] = (e) => i.value = e), class: "filter-item", clearable: "", style: { width: "270px" }, onChange: r }, null, 8, ["modelValue"]), t(o(oe), { monomerId: p.value, "onUpdate:monomerId": a[1] || (a[1] = (e) => p.value = e), areaId: c.value, "onUpdate:areaId": a[2] || (a[2] = (e) => c.value = e), needConvert: "", clearable: "", areaClearable: "", "project-id": i.value, onChange: r }, null, 8, ["monomerId", "areaId", "project-id"]), t(w, { modelValue: m.value, "onUpdate:modelValue": a[3] || (a[3] = (e) => m.value = e), modelModifiers: { trim: true }, placeholder: "编号搜索", style: { width: "150px" }, class: "filter-item", clearable: "", onKeyup: J(r, ["enter"]) }, null, 8, ["modelValue"]), t(k, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: C(H, ["stop"]) }, { default: n(() => a[5] || (a[5] = [I("搜索")])), _: 1, __: [5] }), t(k, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: C(M, ["stop"]) }, { default: n(() => a[6] || (a[6] = [I(" 重置 ")])), _: 1, __: [6] })]), titleRight: n(() => [L(t(P, { "api-key": "mesSchedulingDataList", params: { dateTime: s.dateTime, workshopId: s.workshopId, ..._.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[W, o(le).print]])]), content: n(() => [t(R, { ref: "tableRef", "show-empty-symbol": false, "max-height": o(D), data: y.value, "return-source-data": "", style: { width: "100%" } }, { default: n(() => [t(l, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(l, { "show-overflow-tooltip": true, prop: "project", key: "project.shortName", label: "项目", "min-width": "180" }, { default: n((e) => [b("span", null, v(e.row.project ? o(ne)(e.row.project) : "-"), 1)]), _: 1 }), t(l, { "show-overflow-tooltip": true, prop: "monomer.name", key: "monomer.name", label: "单体", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "area.name", key: "area.name", label: "区域", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "serialNumber", key: "serialNumber", label: "编号", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "specification", key: "specification", label: "规格", "min-width": "120", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "material", key: "material", label: "材质", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "schedulingQuantity", key: "schedulingQuantity", label: "排产数", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "schedulingTotalNetWeight", key: "schedulingTotalNetWeight", label: "排产量（kg）", align: "center" }), t(l, { "show-overflow-tooltip": true, prop: "completeQuantity", key: "completeQuantity", label: "完成数", align: "center" }, { default: n(({ row: e }) => [b("span", { class: x(e.schedulingQuantity === e.completeQuantity ? "tc-success" : "tc-danger") }, v(e.completeQuantity), 3)]), _: 1 }), t(l, { "show-overflow-tooltip": true, prop: "completeTotalNetWeight", key: "completeTotalNetWeight", label: "完成量（kg）", align: "center" }, { default: n(({ row: e }) => [b("span", { class: x(e.schedulingQuantity === e.completeQuantity ? "tc-success" : "tc-danger") }, v(e.completeTotalNetWeight), 3)]), _: 1 })]), _: 1 }, 8, ["max-height", "data"]), t(E, { total: o(S), "current-page": o(f).pageNumber, "page-size": o(f).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: o(Q), onCurrentChange: o(j) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ue as default
};
