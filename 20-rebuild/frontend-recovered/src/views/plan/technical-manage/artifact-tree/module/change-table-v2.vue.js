import { ref as i } from "vue";
import { inject as se } from "vue";
import { computed as ue } from "vue";
import { watch as de } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as q } from "vue";
import { createElementBlock as ce } from "vue";
import { createVNode as o } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as c } from "vue";
import { toDisplayString as u } from "vue";
import { unref as r } from "vue";
import { withModifiers as B } from "vue";
import { createTextVNode as s } from "vue";
import { withDirectives as me } from "vue";
import { createBlock as pe } from "vue";
import { isRef as fe } from "vue";
import { Fragment as ge } from "vue";
import { ElInput as we } from "element-plus";
import { ElBadge as _e } from "element-plus";
import { ElTableColumn as he } from "element-plus";
import { ElPagination as be } from "element-plus";
import { vLoading as ve } from "element-plus";
import { p as ye } from "../../../../../modules/artifact-tree-bcd3b733.js";
import { _ as xe, u as Ve, J as Ce, tx as M, o as ke, z as Ie, D as z } from "../../../../../shared/runtime.js";
import Se from "./change-detail-table.vue.js";
import je from "./collection-drawer.vue.js";
import "../../../../../modules/use-production-team-d8043fd6.js";
import "../../../../../modules/ExcelUploadBtn-acccae97.js";
import "./change-detail-form.vue.js";
import "../../../../../modules/index-61ce89a1.js";
import "./change-confirm-form.vue.js";
import "../../../../../modules/change-reason-select-73e53277.js";
const ze = { class: "head-container" }, Ne = { style: { "margin-bottom": "10px" } }, Te = { class: "search-container" }, Ae = { class: "left" }, Le = { class: "right" }, Ee = { style: { cursor: "pointer", "margin-left": "10px" } }, Re = { __name: "change-table-v2", props: { modelValue: { type: Boolean, require: true }, type: { type: [Number, String], default: void 0 }, projectId: { type: [Number, String] }, globalProject: { type: Object, required: true } }, emits: ["update:modelValue", "success"], setup(_, { emit: D }) {
  const N = D, V = _, { visible: h, handleClose: T } = Ve({ emit: N, props: V }), { handleSizeChange: P, handleCurrentChange: F, total: H, setTotalPage: A, queryPage: C } = Ce({ fetchHook: g }), b = i({}), v = i(), m = se("searchQuery"), k = i(), L = i(false), U = i([]), O = ue(() => ({ ...Number(V.type) === M.AREA.V ? { projectId: m.projectId, monomerId: v.value, areaId: m.areaId } : { projectId: m.projectId, monomerId: v.value }, ...b.value }));
  de(h, (l) => {
    l && (U.value = [], R.value = []);
  }, { immediate: true, deep: true });
  const p = i([]), E = i(), I = i(false), R = i([]), G = i([]), y = i([]), f = i([]), S = i(false);
  function K(l, t) {
    y.value = l;
  }
  function Q(l) {
    y.value = l;
  }
  function J() {
    f.value = y.value;
  }
  function X() {
    S.value = true;
  }
  function Y(l) {
    y.value = l, f.value = l, k.value.clearSelection(), l.forEach((t) => {
      k.value.toggleRowSelection(row, true);
    });
  }
  const { maxHeight: Z } = ke({ mainBox: ".inbound-record", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, E);
  function $() {
    b.value = {}, g();
  }
  function ee(l) {
    var t;
    l ? g() : (p.value = [], A((t = p.value) == null ? void 0 : t.length));
  }
  async function g() {
    let l = [];
    if (!m.projectId || Number(V.type) === M.AREA.V && !m.areaId) {
      p.value = [];
      return;
    }
    I.value = true;
    try {
      const { content: t = [], totalElements: j } = await ye({ ...O.value, ...C });
      l = t, A(j);
    } catch (t) {
      console.log("获取构件列表失败", t);
    } finally {
      p.value = l, I.value = false;
    }
  }
  function te() {
    g(), T(), N("success");
  }
  return (l, t) => {
    const j = w("monomer-select"), oe = we, x = w("common-button"), le = _e, n = he, W = w("table-cell-tag"), ae = w("common-table"), ne = be, ie = w("common-drawer"), re = ve;
    return q(), ce(ge, null, [o(ie, { ref_key: "drawerRef", ref: E, modelValue: r(h), "onUpdate:modelValue": t[3] || (t[3] = (d) => fe(h) ? h.value = d : null), "before-close": r(T), "close-on-click-modal": false, "custom-class": "inbound-record", direction: "rtl", size: "90%", title: "设计变更操作" }, { titleAfter: a(() => t[5] || (t[5] = [])), titleRight: a(() => t[6] || (t[6] = [])), content: a(() => {
      var d;
      return [c("div", ze, [c("div", Ne, "项目：" + u(r(Ie)(_.globalProject)), 1), c("div", Te, [c("div", Ae, [o(j, { modelValue: v.value, "onUpdate:modelValue": t[0] || (t[0] = (e) => v.value = e), default: false, "project-id": _.projectId, class: "filter-item", clearable: "", placeholder: "请选择单体", size: "default", onChange: ee }, null, 8, ["modelValue", "project-id"]), o(oe, { modelValue: b.value.serialNumber, "onUpdate:modelValue": t[1] || (t[1] = (e) => b.value.serialNumber = e), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "编号搜索", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"]), o(x, { class: "filter-item", icon: "el-icon-search", size: "default", type: "success", onClick: B(g, ["stop"]) }, { default: a(() => t[7] || (t[7] = [s(" 搜索 ")])), _: 1, __: [7] }), o(x, { class: "filter-item", icon: "el-icon-refresh", size: "default", type: "warning", onClick: B($, ["stop"]) }, { default: a(() => t[8] || (t[8] = [s(" 重置 ")])), _: 1, __: [8] })]), c("div", Le, [o(x, { icon: "el-icon-plus", size: "default", type: "primary", onClick: J }, { default: a(() => t[9] || (t[9] = [s("添加")])), _: 1, __: [9] }), o(le, { value: (d = f.value) == null ? void 0 : d.length }, { default: a(() => {
        var e;
        return [o(x, { disabled: !((e = f.value) != null && e.length), size: "default", style: { "margin-left": "6px" }, type: "warning", onClick: X }, { default: a(() => t[10] || (t[10] = [s(" 汇总 ")])), _: 1, __: [10] }, 8, ["disabled"])];
      }), _: 1 }, 8, ["value"])])])]), me((q(), pe(ae, { ref_key: "tableRef", ref: k, data: p.value, "max-height": r(Z) - 170, "return-source-data": "", "row-key": "id", onSelect: K, onSelectAll: Q }, { default: a(() => [o(n, { align: "center", type: "selection", width: "60" }), o(n, { align: "center", label: "序号", type: "index", width: "60" }), o(n, { key: "area.name", label: "区域", "min-width": "100px", prop: "area.name", "show-overflow-tooltip": "" }), o(n, { label: "批次", "min-width": "100px", "show-overflow-tooltip": "" }), o(n, { key: "name", label: "名称", "min-width": "100px", prop: "name", "show-overflow-tooltip": "" }), o(n, { key: "serialNumber", label: "构件编号", "min-width": "140px", prop: "serialNumber", "show-overflow-tooltip": "" }, { default: a((e) => [o(W, { show: e.row.dataType !== 2 && e.row.boolSendDirectly, name: "直发件" }, null, 8, ["show"]), o(W, { show: e.row.dataType !== 2 && e.row.relationType === 8, name: "配套件" }, null, 8, ["show"]), c("span", Ee, u(e.row.serialNumber), 1)]), _: 1 }), o(n, { key: "specification", label: "规格", "min-width": "120", prop: "specification", "show-overflow-tooltip": "" }, { default: a((e) => [s(u(e.row.specification ? e.row.specification : "-"), 1)]), _: 1 }), o(n, { key: "length", label: `长度
(mm)`, align: "left", "min-width": "85px", prop: "length", "show-overflow-tooltip": "" }, { default: a((e) => [s(u(e.row.length ? e.row.length.toFixed(r(z).MES_ARTIFACT_L__MM) : "-"), 1)]), _: 1 }), o(n, { key: "material", align: "center", label: "材质", "min-width": "80px", prop: "material", "show-overflow-tooltip": "" }, { default: a((e) => [s(u(e.row.material ? e.row.material : "-"), 1)]), _: 1 }), o(n, { key: "quantity", align: "left", label: "数量", "min-width": "80px", prop: "quantity", "show-overflow-tooltip": "" }, { default: a((e) => [s(u(e.row.quantity ? e.row.quantity : "-"), 1)]), _: 1 }), o(n, { key: "netWeight", label: `单净重
(kg)`, align: "left", "min-width": "80px", prop: "netWeight", "show-overflow-tooltip": "" }, { default: a((e) => [s(u(e.row.netWeight ? e.row.netWeight.toFixed(r(z).COM_WT__KG) : "-"), 1)]), _: 1 }), o(n, { key: "grossWeight", label: `单毛重
(kg)`, align: "left", "min-width": "80px", prop: "grossWeight", "show-overflow-tooltip": "" }, { default: a((e) => [s(u(e.row.grossWeight ? e.row.grossWeight.toFixed(r(z).COM_WT__KG) : "-"), 1)]), _: 1 }), o(n, { label: "生产数" })]), _: 1 }, 8, ["data", "max-height"])), [[re, I.value]]), o(ne, { "current-page": r(C).pageNumber, "page-size": r(C).pageSize, total: r(H), layout: "total, prev, pager, next, sizes", style: { "margin-top": "8px" }, onSizeChange: r(P), onCurrentChange: r(F) }, null, 8, ["current-page", "page-size", "total", "onSizeChange", "onCurrentChange"]), o(r(Se), { modelValue: L.value, "onUpdate:modelValue": t[2] || (t[2] = (e) => L.value = e), submitList: R.value, totalArea: G.value, type: _.type, onSuccess: te }, null, 8, ["modelValue", "submitList", "totalArea", "type"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]), o(je, { modelValue: S.value, "onUpdate:modelValue": t[4] || (t[4] = (d) => S.value = d), "collect-list": f.value, onUpdateList: Y }, null, 8, ["modelValue", "collect-list"])], 64);
  };
} }, Qe = xe(Re, [["__scopeId", "data-v-96741199"]]);
export {
  Qe as default
};
