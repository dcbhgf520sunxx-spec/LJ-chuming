import { ref as c } from "vue";
import { watch as te } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as k } from "vue";
import { createBlock as C } from "vue";
import { withCtx as l } from "vue";
import { createVNode as a } from "vue";
import { unref as t } from "vue";
import { createTextVNode as W } from "vue";
import { createElementVNode as p } from "vue";
import { toDisplayString as d } from "vue";
import { isRef as ae } from "vue";
import { ElFormItem as oe } from "element-plus";
import { ElTag as le } from "element-plus";
import { ElForm as ne } from "element-plus";
import { ElTableColumn as se } from "element-plus";
import { ElPagination as ie } from "element-plus";
import { _ as re, r5 as o, J as ce, u as ue, o as pe, rH as de, rI as me, c as B, rJ as fe } from "../../../../../shared/runtime.js";
const he = { class: "head-container" }, _e = { __name: "stock", props: { visible: { type: Boolean, default: false }, list: { type: Object, default: () => ({}) }, taskOrderIds: { type: Array, default: () => [] }, schedulingGroups: { type: Array, default: () => [] }, bindingWorkshopId: { type: Number } }, emits: ["update:visible", "success", "handleDel", "handleBatchDel"], setup(L, { emit: S }) {
  const j = S, u = L, z = c(false), N = c([]), m = c(void 0), _ = c(void 0), g = c(void 0), I = c(void 0), x = c(void 0), O = c(void 0), H = c(void 0), V = c(0);
  te(() => m.value, () => {
    m.value ? m.value === o.PUBLIC.V ? (_.value = o.PUBLIC.projectWarehouseType, g.value = o.PUBLIC.materialIsWhole) : m.value === o.PROJECT.V ? (_.value = o.PROJECT.projectWarehouseType, g.value = o.PROJECT.materialIsWhole) : m.value === o.REMAIN.V && (_.value = void 0, g.value = o.REMAIN.materialIsWhole) : (_.value = void 0, g.value = void 0), w();
  });
  const { handleSizeChange: U, handleCurrentChange: J, total: q, setTotalPage: $, queryPage: b } = ce({ fetchHook: w }), { visible: y, handleClose: E } = ue({ emit: j, props: u, field: "visible", showHook: G }), { maxHeight: D } = pe({ navbar: false, paginate: true }, y);
  async function w() {
    var f;
    const i = { workshopId: x.value, specification: Z((f = u.list) == null ? void 0 : f.specificationAndMaterial), projectWarehouseType: _.value, materialIsWhole: g.value, specNumber: I.value, ...b }, s = await de(i);
    $(s.totalElements), N.value = s.content;
    const h = await me(i);
    V.value = B(h, "㎜", "m");
  }
  function G() {
    var i, s, h, f;
    console.log(u.list, "list"), x.value = u.bindingWorkshopId, O.value = (s = (i = u.list) == null ? void 0 : i.project) == null ? void 0 : s.id, H.value = (h = u.list) == null ? void 0 : h.specificationAndMaterial, I.value = F((f = u.list) == null ? void 0 : f.specificationAndMaterial), w();
  }
  function F(i) {
    return i.match(/^[A-Za-z]+/)[0];
  }
  function Z(i) {
    return i.replace(/^[A-Za-z]+/, "").trim();
  }
  return (i, s) => {
    const h = v("common-button"), f = v("common-select"), T = oe, K = le, Q = ne, r = se, A = v("table-cell-tag"), X = v("common-table"), Y = ie, ee = v("common-drawer");
    return k(), C(ee, { customClass: "machine-part-scheduling-preview-dlg", title: "库存表", modelValue: t(y), "onUpdate:modelValue": s[1] || (s[1] = (e) => ae(y) ? y.value = e : null), size: "80%", "before-close": t(E), showClose: false, closeOnClickModal: false }, { titleRight: l(() => [a(h, { onClick: t(E), type: "info", loading: z.value }, { default: l(() => s[2] || (s[2] = [W(" 关闭 ")])), _: 1, __: [2] }, 8, ["onClick", "loading"])]), content: l(() => [p("div", he, [a(Q, { style: { display: "flex", "flex-wrap": "wrap" } }, { default: l(() => [a(T, null, { default: l(() => [a(f, { modelValue: m.value, "onUpdate:modelValue": s[0] || (s[0] = (e) => m.value = e), options: t(o).ENUM, placeholder: "选择仓库", type: "enum", clearable: "", style: { width: "200px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), a(T, null, { default: l(() => [a(K, { type: "primary" }, { default: l(() => {
      var e, n;
      return [W(d(`需求长度: ${((e = u.list) == null ? void 0 : e.length) / 1e3 * ((n = u.list) == null ? void 0 : n.wastageRate)}米 | 库存长度:${V.value}米`), 1)];
    }), _: 1 })]), _: 1 })]), _: 1 })]), a(X, { data: N.value, "return-source-data": "", "max-height": t(D), style: { width: "100%" }, id: "listTables" }, { default: l(() => [a(r, { label: "序号", type: "index", align: "center", width: "55" }), a(r, { key: "classifyName", prop: "classifyName", label: "物料种类", align: "center", "show-overflow-tooltip": true }, { default: l(({ row: e }) => {
      var n, M, P, R;
      return [e.materialIsWhole === t(o).REMAIN.materialIsWhole ? (k(), C(A, { key: 0, name: t(o).VL[t(o).REMAIN.V], color: (M = (n = t(o)) == null ? void 0 : n.V[t(o).REMAIN.V]) == null ? void 0 : M.COLOR, offset: 15 }, null, 8, ["name", "color"])) : (k(), C(A, { key: 1, name: t(o).VL[e.warehouseType], color: (R = (P = t(o)) == null ? void 0 : P.V[e.warehouseType]) == null ? void 0 : R.COLOR, offset: 15 }, null, 8, ["name", "color"])), p("span", null, d(e.classifyName), 1)];
    }), _: 1 }), a(r, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": true, width: "120px" }, { default: l(({ row: e }) => [p("span", null, d(`${e.serialNumber}${e.specification}`), 1)]), _: 1 }), a(r, { key: "LENGTH", prop: "LENGTH", label: "单长", align: "center", "min-width": "100px", "show-overflow-tooltip": true }, { default: l(({ row: e }) => [p("span", null, d(e.length), 1)]), _: 1 }), a(r, { key: "quantity", prop: "quantity", label: "数量", align: "center" }, { default: l(({ row: e }) => [p("span", null, d(Math.round(e.quantity)), 1)]), _: 1 }), a(r, { key: "mete", prop: "mete", label: "库存重量（kg）", align: "center", "min-width": "120px", "show-overflow-tooltip": true }, { default: l(({ row: e }) => {
      var n;
      return [p("span", null, d(t(B)(e.mete, (n = t(fe)[e.basicClass].weight) == null ? void 0 : n.unit, "kg")), 1)];
    }), _: 1 }), a(r, { key: "brand", prop: "brand", label: "品牌", align: "center", "show-overflow-tooltip": true }), a(r, { key: "heatNoAndBatchNo", prop: "heatNoAndBatchNo", label: "炉批号", align: "center", "show-overflow-tooltip": true }), a(r, { key: "projectName", prop: "projectName", label: "所属项目", align: "center", "show-overflow-tooltip": true }, { default: l(({ row: e }) => {
      var n;
      return [p("span", null, d(((n = e == null ? void 0 : e.project) == null ? void 0 : n.name) || "-"), 1)];
    }), _: 1 }), a(r, { key: "warehouseName", prop: "warehouseName", label: "库位", align: "center", "min-width": "100px", "show-overflow-tooltip": true }, { default: l(({ row: e }) => {
      var n;
      return [p("span", null, d((n = e.warehouse) == null ? void 0 : n.name), 1)];
    }), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), a(Y, { total: t(q), "current-page": t(b).pageNumber, "page-size": t(b).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(U), onCurrentChange: t(J) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ye = re(_e, [["__scopeId", "data-v-30f88523"]]);
export {
  ye as default
};
