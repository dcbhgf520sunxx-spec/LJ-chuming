import { computed as T } from "vue";
import { withDirectives as p } from "vue";
import { resolveDirective as o } from "vue";
import { createVNode as a } from "vue";
import { resolveComponent as C } from "vue";
import { ref as m } from "vue";
import { openBlock as L } from "vue";
import { createBlock as E } from "vue";
import { withCtx as f } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as oe } from "vue";
import { createElementVNode as z } from "vue";
import { unref as c } from "vue";
import { createCommentVNode as ue } from "vue";
import { normalizeStyle as de } from "vue";
import { isRef as ie } from "vue";
import { ElTag as ne } from "element-plus";
import { ElInput as se } from "element-plus";
import { ElTableV2 as pe } from "element-plus";
import { ElAutoResizer as ce } from "element-plus";
import { g as me } from "../../../../../../modules/craft-library-fde84566.js";
import { g as fe, p as ye } from "./preview.vue.js";
import { fg as he, aa as g, oG as y, u as ve, o as Ce, b as K, i as A, tG as be, tF as we, _ as ge } from "../../../../../../shared/runtime.js";
const Ve = { class: "bind-craft-header" }, Se = { __name: "bind", props: { modelValue: { type: Boolean, require: true }, customClass: { type: String, default: "bind-craft-drawer" }, param: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(j, { emit: H }) {
  const I = H, { projectMap: G, monomerMap: $, areaMap: O } = he(), d = j, q = T(() => {
    var e, t, i, s, n, b;
    return [(t = (e = G.value) == null ? void 0 : e[d.param.projectId]) == null ? void 0 : t.name, (s = (i = $.value) == null ? void 0 : i[d.param.monomerId]) == null ? void 0 : s.name, (b = (n = O.value) == null ? void 0 : n[d.param.areaId]) == null ? void 0 : b.name].join(" > ");
  }), D = T(() => N.value.filter((r) => r.techCappCraftCardStorehouseId !== r.originalTechCappCraftCardStorehouseId)), F = T(() => {
    var e;
    const r = [{ key: "index", dataKey: "index", title: "序号", minWidth: 60, align: "center", cellRenderer: ({ rowIndex: t }) => `${t + 1}` }, { key: "weldSerialNumber", dataKey: "weldSerialNumber", title: "焊缝编号", width: 1e3, align: "center", cellRenderer: ({ rowData: t }) => p(a("div", null, [t.weldSerialNumber]), [[o("ellipsis")], [o("empty-text")]]) }];
    return d.param.productType === g.ASSEMBLY.V && r.push({ key: "productName", dataKey: "productName", title: "部件名称", width: 1e3, align: "center", cellRenderer: ({ rowData: t }) => p(a("div", null, [t.productName]), [[o("ellipsis")], [o("empty-text")]]) }), r.push({ key: "productSerialNumber", dataKey: "productSerialNumber", title: `${(e = g.VL) == null ? void 0 : e[d.param.productType]}编号`, width: 1e3, align: "center", cellRenderer: ({ rowData: t }) => p(a("div", null, [t.productSerialNumber]), [[o("ellipsis")], [o("empty-text")]]) }, { key: "productSpecification", dataKey: "productSpecification", title: "规格", width: 1400, align: "center", cellRenderer: ({ rowData: t }) => p(a("div", null, [t.productSpecification]), [[o("ellipsis")], [o("empty-text")]]) }, { key: "productLength", dataKey: "productLength", title: "长度(mm)", width: 1e3, align: "center", cellRenderer: ({ rowData: t }) => p(a("div", null, [t.productLength]), [[o("ellipsis")], [o("empty-text")]]) }, { key: "productMaterial", dataKey: "productMaterial", title: "材质", width: 1e3, align: "center", cellRenderer: ({ rowData: t }) => p(a("div", null, [t.productMaterial]), [[o("ellipsis")], [o("empty-text")]]) }, { key: "weldCount", dataKey: "weldCount", title: "焊缝数量", width: 1e3, align: "center", cellRenderer: ({ rowData: t }) => p(a("div", null, [t.weldCount]), [[o("ellipsis")], [o("empty-text")]]) }, { key: "productDwgNum", dataKey: "productDwgNum", title: "图号", width: 1600, align: "center", cellRenderer: ({ rowData: t }) => p(a("div", null, [t.productDwgNum]), [[o("ellipsis")], [o("empty-text")]]) }, { key: "craftType", dataKey: "craftType", title: "工艺类型", minWidth: 200, align: "center", cellRenderer: ({ rowData: t }) => {
      var i;
      return t.isIssued ? p(a("div", null, [(i = y.VL) == null ? void 0 : i[t.craftType]]), [[o("ellipsis")], [o("empty-text")]]) : a(C("common-select"), { modelValue: t.craftType, "onUpdate:modelValue": (s) => t.craftType = s, options: y.ENUM, unshowOptions: [y.CUTTING.K, y.COATING.K], type: "enum", placeholder: "工艺类型", style: "width: 100%" }, null);
    } }, { key: "techCappCraftCardStorehouseId", dataKey: "techCappCraftCardStorehouseId", title: "工艺编号", minWidth: 200, align: "center", cellRenderer: ({ rowData: t }) => t.isIssued ? p(a("div", null, [t.techCappCraftCardStorehouseSerialNumber]), [[o("ellipsis")], [o("empty-text")]]) : a(C("common-select"), { modelValue: t.techCappCraftCardStorehouseId, "onUpdate:modelValue": (i) => t.techCappCraftCardStorehouseId = i, options: _.value, clearable: true, dataStructure: W.value, placeholder: "工艺编号", style: "width: 100%" }, null) }), r;
  }), { visible: V, handleClose: k } = ve({ emit: I, props: d, showHook: P }), M = m(40), B = m(), l = m({}), R = m(false), S = m([]), N = m([]), _ = m([]), W = m({ key: "id", label: "serialNumber", value: "id" }), x = m(false), { maxHeight: Q, fixMaxHeight: Y } = Ce({ mainBox: `.${d.customClass}`, extraBox: [".el-drawer__header", ".bind-craft-header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, B);
  async function P() {
    U(), await ee(), await Z(), h(), Y();
  }
  function U() {
    l.value = { craftType: d.param.craftType };
  }
  function h() {
    N.value = S.value.filter((r) => {
      const e = ["productName", "productSerialNumber", "productSpecification", "productMaterial", "weldSerialNumber", "productDwgNum"];
      return (K(l.value.isBind) || A(l.value.isBind) && !!r.techCappCraftCardStorehouseSerialNumber === l.value.isBind) && e.every((t) => J(r, t));
    });
  }
  function J(r, e) {
    var t, i, s, n;
    return K((t = l.value) == null ? void 0 : t[e]) || A((i = l.value) == null ? void 0 : i[e]) && ((n = r == null ? void 0 : r[e]) == null ? void 0 : n.includes((s = l.value) == null ? void 0 : s[e]));
  }
  function X() {
    U(), h();
  }
  async function Z() {
    R.value = true, S.value = [];
    try {
      const { content: r = [] } = await fe({ ...l.value, productType: d.param.productType, monomerId: d.param.monomerId, areaId: d.param.areaId });
      S.value = r.map((e) => (e.uuid = be(), e.techCappCraftCardStorehouseId = e.techCappCraftCardStorehouseId || void 0, e.originalTechCappCraftCardStorehouseId = e.techCappCraftCardStorehouseId, e.originalTechCappCraftCardStorehouseSerialNumber = e.techCappCraftCardStorehouseSerialNumber || "", e));
    } catch (r) {
      console.log("获取产品列表失败", r);
    } finally {
      R.value = false;
    }
  }
  async function ee() {
    try {
      _.value = await me({ craftType: d.param.craftType, projectId: d.param.projectId });
    } catch (r) {
      console.log("获取工艺编号列表失败", r);
    }
  }
  function te() {
    I("success"), k();
  }
  return (r, e) => {
    const t = ne, i = C("common-button"), s = C("common-radio-button"), n = se, b = pe, ae = ce, le = C("common-drawer");
    return L(), E(le, { title: "绑定工艺卡", "close-on-click-modal": false, modelValue: c(V), "onUpdate:modelValue": e[10] || (e[10] = (v) => ie(V) ? V.value = v : null), "before-close": c(k), "custom-class": d.customClass, size: "100%" }, { titleAfter: f(() => [a(t, { effect: "plain" }, { default: f(() => [w(oe(q.value), 1)]), _: 1 })]), titleRight: f(() => [a(i, { size: "default", type: "warning", disabled: !D.value.length, onClick: e[0] || (e[0] = (v) => x.value = true) }, { default: f(() => e[11] || (e[11] = [w("下一步")])), _: 1, __: [11] }, 8, ["disabled"])]), content: f(() => {
      var v;
      return [z("div", Ve, [z("div", null, [a(s, { modelValue: l.value.isBind, "onUpdate:modelValue": e[1] || (e[1] = (u) => l.value.isBind = u), options: c(we).ENUM, showOptionAll: "", type: "enum", onChange: h }, null, 8, ["modelValue", "options"]), a(s, { modelValue: l.value.craftType, "onUpdate:modelValue": e[2] || (e[2] = (u) => l.value.craftType = u), options: c(y).ENUM, disabledVal: [c(y).CUTTING.V, c(y).COATING.V], type: "enum", onChange: h }, null, 8, ["modelValue", "options", "disabledVal"]), d.param.productType === c(g).ASSEMBLY.V ? (L(), E(n, { key: 0, modelValue: l.value.productName, "onUpdate:modelValue": e[3] || (e[3] = (u) => l.value.productName = u), modelModifiers: { trim: true }, clearable: "", placeholder: "部件名称搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"])) : ue("", true), a(n, { modelValue: l.value.productSerialNumber, "onUpdate:modelValue": e[4] || (e[4] = (u) => l.value.productSerialNumber = u), modelModifiers: { trim: true }, clearable: "", placeholder: `${(v = c(g).VL) == null ? void 0 : v[d.param.productType]}编号搜索`, size: "default", style: { width: "170px" } }, null, 8, ["modelValue", "placeholder"]), a(n, { modelValue: l.value.productSpecification, "onUpdate:modelValue": e[5] || (e[5] = (u) => l.value.productSpecification = u), modelModifiers: { trim: true }, clearable: "", placeholder: "规格搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"]), a(n, { modelValue: l.value.productMaterial, "onUpdate:modelValue": e[6] || (e[6] = (u) => l.value.productMaterial = u), modelModifiers: { trim: true }, clearable: "", placeholder: "材质搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"]), a(n, { modelValue: l.value.weldSerialNumber, "onUpdate:modelValue": e[7] || (e[7] = (u) => l.value.weldSerialNumber = u), modelModifiers: { trim: true }, clearable: "", placeholder: "焊缝编号搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"]), a(n, { modelValue: l.value.productDwgNum, "onUpdate:modelValue": e[8] || (e[8] = (u) => l.value.productDwgNum = u), modelModifiers: { trim: true }, clearable: "", placeholder: "图号搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"]), a(i, { size: "default", type: "success", icon: "el-icon-search", onClick: h }, { default: f(() => e[12] || (e[12] = [w("搜索")])), _: 1, __: [12] }), a(i, { size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: X }, { default: f(() => e[13] || (e[13] = [w(" 重置 ")])), _: 1, __: [13] })])]), a(ae, { style: de({ height: `${c(Q)}px` }) }, { default: f(({ width: u, height: re }) => [a(b, { ref_key: "tableRef", ref: B, "row-key": "uuid", data: N.value, "header-height": M.value, "row-height": M.value, columns: F.value, width: u, height: re, class: "table-v2-border" }, null, 8, ["data", "header-height", "row-height", "columns", "width", "height"])]), _: 1 }, 8, ["style"]), a(c(ye), { modelValue: x.value, "onUpdate:modelValue": e[9] || (e[9] = (u) => x.value = u), param: d.param, craftList: _.value, tableData: D.value, onSuccess: te }, null, 8, ["modelValue", "param", "craftList", "tableData"])];
    }), _: 1 }, 8, ["modelValue", "before-close", "custom-class"]);
  };
} };
const ke = ge(Se, [["__scopeId", "data-v-2ed6f2b5"]]);
export {
  ke as default
};
