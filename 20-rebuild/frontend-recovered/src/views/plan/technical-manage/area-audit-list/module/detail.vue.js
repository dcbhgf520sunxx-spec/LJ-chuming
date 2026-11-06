import { ref as g } from "vue";
import { computed as ne } from "vue";
import { watch as re } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as z } from "vue";
import { createBlock as F } from "vue";
import { withCtx as a } from "vue";
import { createVNode as e } from "vue";
import { unref as o } from "vue";
import { createTextVNode as n } from "vue";
import { toDisplayString as s } from "vue";
import { withKeys as se } from "vue";
import { withModifiers as O } from "vue";
import { createElementBlock as me } from "vue";
import { Fragment as ce } from "vue";
import { createCommentVNode as de } from "vue";
import { withDirectives as ue } from "vue";
import { createElementVNode as k } from "vue";
import { isRef as K } from "vue";
import { ElMessage as pe } from "element-plus";
import { ElTag as fe } from "element-plus";
import { ElInput as ge } from "element-plus";
import { ElDescriptionsItem as we } from "element-plus";
import { ElDescriptions as be } from "element-plus";
import { ElTableColumn as _e } from "element-plus";
import { ElTooltip as ye } from "element-plus";
import { ElPagination as he } from "element-plus";
import { vLoading as ve } from "element-plus";
import { d as ke, a as xe, b as We } from "../../../../../modules/area-audit-list-39a1a7c7.js";
import { _ as Re, u as Ce, J as Te, o as Ne, m9 as w, L as ze, G as Ve, z as De, D as V, p as Ee, c as Me } from "../../../../../shared/runtime.js";
import { u as Ge } from "../../../../../modules/use-drawing-8a7ba23b.js";
import { b as Ie } from "../../../../../modules/bim-preview-drawer-7ca7893b.js";
import "../../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../../modules/model-0ac957f7.js";
import "../../../../../modules/index-d6a37d29.js";
import "../../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../../modules/use-chart-59e4b63c.js";
import "../../../../../modules/index-18acf776.js";
const Le = ["onDblclick"], Se = { __name: "detail", props: { modelValue: { type: Boolean, require: true }, permission: { type: Object, default: () => {
} }, currentRow: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "deleteModifyItem", "success"], setup(l, { emit: B }) {
  const D = B, x = l, { visible: y, handleClose: E } = Ce({ emit: D, props: x, closeHook: Y }), { handleSizeChange: P, handleCurrentChange: j, total: H, setTotalPage: U, queryPage: W } = Te({ fetchHook: _ }), { showDrawing: R, drawingRow: f, drawingPreview: q } = Ge({ pidField: "id", typeField: "productType" }), M = g([]), G = g(), C = g(false), $ = g(), h = g(false), b = g({ fuzzy: void 0 }), J = ne(() => [["project", "parse-project"], ["createTime", ["parse-time", "{y}-{m}-{d} {h}:{i}"]], ["netWeight", ["to-fixed-ck", "COM_WT__KG"]], ["totalNetWeight", ["to-fixed-ck", "COM_WT__KG"]], ["grossWeight", ["to-fixed-ck", "COM_WT__KG"]], ["totalGrossWeight", ["to-fixed-ck", "COM_WT__KG"]], ["drawingWeight", ["to-fixed-ck", "COM_WT__KG"]], ["drawingTotalWeight", ["to-fixed-ck", "COM_WT__KG"]]]);
  re(y, (c) => {
    c && _();
  }, { immediate: true, deep: true });
  const { maxHeight: Q } = Ne({ mainBox: ".inbound-record", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, G);
  function X() {
    b.value = {}, _();
  }
  async function _() {
    let c = [];
    C.value = true;
    try {
      const { content: t = [], totalElements: T } = await ke({ inventoryId: x.currentRow.id, ...b.value, ...W });
      c = t, U(T);
    } catch (t) {
      console.log("获取区域清单待审核详情", t);
    } finally {
      M.value = c, C.value = false;
    }
  }
  async function I(c) {
    try {
      h.value = true;
      const t = { checkStatus: c, id: x.currentRow.id };
      await We(t), pe({ message: w.VL[c] + "成功", type: "success" }), D("success"), E();
    } catch (t) {
      console.log("区域清单审核", t);
    } finally {
      h.value = false;
    }
  }
  function Y() {
    b.value = {};
  }
  return (c, t) => {
    const T = fe, Z = ge, v = N("common-button"), d = we, ee = be, i = _e, te = ye, oe = N("common-table"), ae = he, le = N("common-drawer"), ie = ve;
    return z(), F(le, { ref_key: "drawerRef", ref: G, title: "审核明细", "close-on-click-modal": false, modelValue: o(y), "onUpdate:modelValue": t[4] || (t[4] = (r) => K(y) ? y.value = r : null), direction: "rtl", "before-close": o(E), "custom-class": "inbound-record", size: "90%" }, { titleAfter: a(() => {
      var r, u;
      return [e(T, { type: (u = o(w).V[(r = l.currentRow) == null ? void 0 : r.inventoryReviewedEnum]) == null ? void 0 : u.T }, { default: a(() => {
        var p;
        return [n(s(o(w).VL[(p = l.currentRow) == null ? void 0 : p.inventoryReviewedEnum]), 1)];
      }), _: 1 }, 8, ["type"]), e(Z, { modelValue: b.value.fuzzy, "onUpdate:modelValue": t[0] || (t[0] = (p) => b.value.fuzzy = p), placeholder: "输入名称、编号、规格搜索", class: "filter-item", maxlength: "15", clearable: "", style: { width: "270px" }, onKeyup: se(_, ["enter"]) }, null, 8, ["modelValue"]), e(v, { class: "filter-item", size: "mini", type: "success", icon: "el-icon-search", onClick: O(_, ["stop"]) }, { default: a(() => t[5] || (t[5] = [n("搜索")])), _: 1, __: [5] }), e(v, { class: "filter-item", size: "mini", type: "warning", icon: "el-icon-refresh", onClick: O(X, ["stop"]) }, { default: a(() => t[6] || (t[6] = [n(" 重置 ")])), _: 1, __: [6] })];
    }), titleRight: a(() => {
      var r;
      return [e(ze, { fn: o(xe), params: { inventoryId: (r = l.currentRow) == null ? void 0 : r.id } }, { default: a(() => t[7] || (t[7] = [n(" 审核明细 ")])), _: 1, __: [7] }, 8, ["fn", "params"]), l.currentRow.inventoryReviewedEnum === o(w).UNAUDITED.V && o(Ve)(l.permission.audit) ? (z(), me(ce, { key: 0 }, [e(v, { loading: h.value, type: "primary", size: "default", onClick: t[1] || (t[1] = (u) => I(o(w).PASSED.V)) }, { default: a(() => t[8] || (t[8] = [n("通过")])), _: 1, __: [8] }, 8, ["loading"]), e(v, { loading: h.value, type: "warning", size: "default", onClick: t[2] || (t[2] = (u) => I(o(w).FAIL.V)) }, { default: a(() => t[9] || (t[9] = [n("驳回")])), _: 1, __: [9] }, 8, ["loading"])], 64)) : de("", true)];
    }), content: a(() => {
      var r, u, p, L, S, A;
      return [e(ee, { class: "margin-top", column: 4, border: "" }, { default: a(() => [e(d, { "label-class-name": "contractLabel", label: "项目" }, { default: a(() => [n(s(o(De)(l.currentRow.projectInfo)), 1)]), _: 1 }), e(d, { "label-class-name": "contractLabel", label: "单体" }, { default: a(() => {
        var m;
        return [n(s((m = l.currentRow.monomer) == null ? void 0 : m.name), 1)];
      }), _: 1 }), e(d, { "label-class-name": "contractLabel", label: "创建人" }, { default: a(() => [n(s(l.currentRow.createUserName), 1)]), _: 1 }), e(d, { "label-class-name": "contractLabel", label: "清单数量(件)" }, { default: a(() => [n(s(l.currentRow.totalQuantity), 1)]), _: 1 }), e(d, { "label-class-name": "contractLabel", label: "清单净重（kg）" }, { default: a(() => [n(s(l.currentRow.totalWeight ? l.currentRow.totalWeight.toFixed(o(V).COM_WT__KG) : "-"), 1)]), _: 1 }), e(d, { "label-class-name": "contractLabel", label: "清单毛重（kg）" }, { default: a(() => [n(s(l.currentRow.totalGrossWeight ? l.currentRow.totalGrossWeight.toFixed(o(V).COM_WT__KG) : "-"), 1)]), _: 1 }), e(d, { "label-class-name": "contractLabel", label: "日期" }, { default: a(() => [n(s(o(Ee)(l.currentRow.createTime, "{y}-{m}-{d}")), 1)]), _: 1 })]), _: 1 }), ue((z(), F(oe, { ref_key: "serialNumberRef", ref: $, data: M.value, "max-height": o(Q) - 160, "data-format": J.value, style: { margin: "20px 0" } }, { default: a(() => [e(i, { type: "index", label: "序号", align: "center", width: "80" }), e(i, { key: "name", prop: "name", "show-overflow-tooltip": "", label: "名称" }), e(i, { key: "serialNumber", "show-overflow-tooltip": "", label: "编号", "min-width": "140px", prop: "serialNumber", sortable: "custom" }, { header: a(() => [e(te, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: a(() => t[10] || (t[10] = [k("div", { style: { display: "inline-block" } }, [k("span", { style: { "margin-left": "10px" } }, "编号"), k("i", { class: "el-icon-info" })], -1)])), _: 1, __: [10] })]), default: a((m) => [k("span", { style: { cursor: "pointer" }, onDblclick: (Ae) => o(q)(m.row) }, s(m.row.serialNumber), 41, Le)]), _: 1 }), e(i, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", "min-width": "120" }), e(i, { key: "length", prop: "length", "show-overflow-tooltip": "", label: "长度(mm)", align: "left", "min-width": "90px" }), e(i, { key: "material", prop: "material", "show-overflow-tooltip": "", label: "材质", align: "left", "min-width": "90px" }), e(i, { key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "数量", "min-width": "120" }), e(i, { key: "netWeight", prop: "netWeight", "show-overflow-tooltip": "", label: "单净重(kg)", align: "left", "min-width": "90px" }), e(i, { key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": "", label: "总净重(kg)", align: "left", "min-width": "90px" }), e(i, { key: "grossWeight", prop: "grossWeight", "show-overflow-tooltip": "", label: "单毛重(kg)", align: "left", "min-width": "90px" }), e(i, { key: "totalGrossWeight", prop: "totalGrossWeight", "show-overflow-tooltip": "", label: "总毛重(kg)", align: "left", "min-width": "90px" }), e(i, { key: "drawingWeight", prop: "drawingWeight", "show-overflow-tooltip": "", label: "单图纸重(kg)", align: "left", "min-width": "90px" }), e(i, { key: "drawingTotalWeight", prop: "drawingTotalWeight", "show-overflow-tooltip": "", label: "总图纸重(kg)", align: "left", "min-width": "90px" }), e(i, { key: "surfaceArea", prop: "surfaceArea", "show-overflow-tooltip": "", label: `面积
(㎡)`, align: "left", "min-width": "80px" }, { default: a((m) => [n(s(o(Me)(m.row.surfaceArea, "mm²", "m²", o(V).COM_AREA__M2)), 1)]), _: 1 }), e(i, { key: "remark", prop: "remark", "show-overflow-tooltip": "", label: "备注", align: "left", "min-width": "80px" })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[ie, C.value]]), e(ae, { total: o(H), "current-page": o(W).pageNumber, "page-size": o(W).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: o(P), onCurrentChange: o(j) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), e(o(Ie), { visible: o(R), "onUpdate:visible": t[3] || (t[3] = (m) => K(R) ? R.value = m : null), "bool-bim": (r = o(f)) == null ? void 0 : r.boolBim, drawingSN: (u = o(f)) == null ? void 0 : u.drawingSN, "monomer-id": (p = o(f)) == null ? void 0 : p.monomerId, "serial-number": (L = o(f)) == null ? void 0 : L.serialNumber, productId: (S = o(f)) == null ? void 0 : S.productId, productType: (A = o(f)) == null ? void 0 : A.productType }, null, 8, ["visible", "bool-bim", "drawingSN", "monomer-id", "serial-number", "productId", "productType"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Xe = Re(Se, [["__scopeId", "data-v-bf7a3b46"]]);
export {
  Xe as default
};
