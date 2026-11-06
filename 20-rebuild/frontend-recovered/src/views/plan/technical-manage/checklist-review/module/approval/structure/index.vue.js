import { ref as g } from "vue";
import { computed as re } from "vue";
import { watch as se } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as z } from "vue";
import { createBlock as F } from "vue";
import { withCtx as a } from "vue";
import { createVNode as e } from "vue";
import { unref as t } from "vue";
import { createTextVNode as n } from "vue";
import { toDisplayString as s } from "vue";
import { withKeys as me } from "vue";
import { withModifiers as O } from "vue";
import { createElementBlock as ce } from "vue";
import { Fragment as de } from "vue";
import { createCommentVNode as ue } from "vue";
import { withDirectives as pe } from "vue";
import { createElementVNode as _ } from "vue";
import { normalizeStyle as fe } from "vue";
import { isRef as B } from "vue";
import { ElMessage as ge } from "element-plus";
import { ElTag as we } from "element-plus";
import { ElInput as be } from "element-plus";
import { ElDescriptionsItem as ye } from "element-plus";
import { ElDescriptions as _e } from "element-plus";
import { ElTableColumn as he } from "element-plus";
import { ElTooltip as ve } from "element-plus";
import { ElPagination as ke } from "element-plus";
import { vLoading as xe } from "element-plus";
import { d as We, a as Re, b as Ce } from "../../../../../../../modules/area-audit-list-39a1a7c7.js";
import { _ as Ne, u as Te, J as ze, o as Se, m9 as w, L as Ee, G as Ve, z as De, D as S, p as Me, c as Ae, i as K } from "../../../../../../../shared/runtime.js";
import { u as Ge } from "../../../../../../../modules/use-drawing-8a7ba23b.js";
import { b as Ie } from "../../../../../../../modules/bim-preview-drawer-7ca7893b.js";
import "../../../../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../../../../modules/model-0ac957f7.js";
import "../../../../../../../modules/index-d6a37d29.js";
import "../../../../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../../../../modules/use-chart-59e4b63c.js";
import "../../../../../../../modules/index-18acf776.js";
const Le = ["onDblclick"], Fe = { __name: "index", props: { modelValue: { type: Boolean, require: true }, permission: { type: Object, default: () => {
} }, currentRow: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "deleteModifyItem", "success"], setup(i, { emit: P }) {
  const E = P, x = i, { visible: h, handleClose: V } = Te({ emit: E, props: x, closeHook: Z }), { handleSizeChange: j, handleCurrentChange: H, total: U, setTotalPage: q, queryPage: W } = ze({ fetchHook: y }), { showDrawing: R, drawingRow: f, drawingPreview: $ } = Ge({ pidField: "id", typeField: "productType" }), D = g([]), M = g(), C = g(false), J = g(), v = g(false), b = g({ fuzzy: void 0 }), Q = re(() => [["project", "parse-project"], ["createTime", ["parse-time", "{y}-{m}-{d} {h}:{i}"]], ["netWeight", ["to-fixed-ck", "COM_WT__KG"]], ["totalNetWeight", ["to-fixed-ck", "COM_WT__KG"]], ["grossWeight", ["to-fixed-ck", "COM_WT__KG"]], ["totalGrossWeight", ["to-fixed-ck", "COM_WT__KG"]], ["drawingWeight", ["to-fixed-ck", "COM_WT__KG"]], ["drawingTotalWeight", ["to-fixed-ck", "COM_WT__KG"]]]);
  se(h, (d) => {
    d && y();
  }, { immediate: true, deep: true });
  const { maxHeight: X } = Se({ mainBox: ".inbound-record", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, M);
  function Y() {
    b.value = {}, y();
  }
  async function y() {
    let d = [];
    C.value = true;
    try {
      const { content: o = [], totalElements: N } = await We({ inventoryId: x.currentRow.id, ...b.value, ...W });
      d = o, q(N);
    } catch (o) {
      console.log("获取区域清单待审核详情", o);
    } finally {
      D.value = d, C.value = false;
    }
  }
  async function A(d) {
    try {
      v.value = true;
      const o = { checkStatus: d, id: x.currentRow.id };
      await Ce(o), ge({ message: w.VL[d] + "成功", type: "success" }), E("success"), V();
    } catch (o) {
      console.log("区域清单审核", o);
    } finally {
      v.value = false;
    }
  }
  function Z() {
    b.value = {};
  }
  return (d, o) => {
    const N = we, ee = be, k = T("common-button"), p = ye, te = _e, l = he, oe = ve, ae = T("common-table"), le = ke, ie = T("common-drawer"), ne = xe;
    return z(), F(ie, { ref_key: "drawerRef", ref: M, modelValue: t(h), "onUpdate:modelValue": o[4] || (o[4] = (m) => B(h) ? h.value = m : null), "before-close": t(V), "close-on-click-modal": false, "custom-class": "inbound-record", direction: "rtl", size: "90%", title: "审核明细" }, { titleAfter: a(() => {
      var m, u;
      return [e(N, { type: (u = t(w).V[(m = i.currentRow) == null ? void 0 : m.inventoryReviewedEnum]) == null ? void 0 : u.T }, { default: a(() => {
        var c;
        return [n(s(t(w).VL[(c = i.currentRow) == null ? void 0 : c.inventoryReviewedEnum]), 1)];
      }), _: 1 }, 8, ["type"]), e(ee, { modelValue: b.value.fuzzy, "onUpdate:modelValue": o[0] || (o[0] = (c) => b.value.fuzzy = c), class: "filter-item", clearable: "", maxlength: "15", placeholder: "输入名称、编号、规格搜索", style: { width: "270px" }, onKeyup: me(y, ["enter"]) }, null, 8, ["modelValue"]), e(k, { class: "filter-item", icon: "el-icon-search", size: "mini", type: "success", onClick: O(y, ["stop"]) }, { default: a(() => o[5] || (o[5] = [n(" 搜索 ")])), _: 1, __: [5] }), e(k, { class: "filter-item", icon: "el-icon-refresh", size: "mini", type: "warning", onClick: O(Y, ["stop"]) }, { default: a(() => o[6] || (o[6] = [n(" 重置 ")])), _: 1, __: [6] })];
    }), titleRight: a(() => {
      var m, u;
      return [e(Ee, { fn: t(Re), params: { inventoryId: (m = i.currentRow) == null ? void 0 : m.id } }, { default: a(() => o[7] || (o[7] = [n(" 审核明细")])), _: 1, __: [7] }, 8, ["fn", "params"]), ((u = i.currentRow) == null ? void 0 : u.inventoryReviewedEnum) === t(w).UNAUDITED.V && t(Ve)(i.permission.audit) ? (z(), ce(de, { key: 0 }, [e(k, { loading: v.value, size: "default", type: "primary", onClick: o[1] || (o[1] = (c) => A(t(w).PASSED.V)) }, { default: a(() => o[8] || (o[8] = [n(" 通过 ")])), _: 1, __: [8] }, 8, ["loading"]), e(k, { loading: v.value, size: "default", type: "warning", onClick: o[2] || (o[2] = (c) => A(t(w).FAIL.V)) }, { default: a(() => o[9] || (o[9] = [n(" 驳回 ")])), _: 1, __: [9] }, 8, ["loading"])], 64)) : ue("", true)];
    }), content: a(() => {
      var m, u, c, G, I, L;
      return [e(te, { column: 4, border: "", class: "margin-top" }, { default: a(() => [e(p, { label: "项目", "label-class-name": "contractLabel" }, { default: a(() => [n(s(t(De)(i.currentRow.projectInfo)), 1)]), _: 1 }), e(p, { label: "单体", "label-class-name": "contractLabel" }, { default: a(() => {
        var r;
        return [n(s((r = i.currentRow.monomer) == null ? void 0 : r.name), 1)];
      }), _: 1 }), e(p, { label: "创建人", "label-class-name": "contractLabel" }, { default: a(() => [n(s(i.currentRow.createUserName), 1)]), _: 1 }), e(p, { label: "清单数量(件)", "label-class-name": "contractLabel" }, { default: a(() => [n(s(i.currentRow.totalQuantity), 1)]), _: 1 }), e(p, { label: "清单净重（kg）", "label-class-name": "contractLabel" }, { default: a(() => [n(s(i.currentRow.totalWeight ? i.currentRow.totalWeight.toFixed(t(S).COM_WT__KG) : "-"), 1)]), _: 1 }), e(p, { label: "清单毛重（kg）", "label-class-name": "contractLabel" }, { default: a(() => [n(s(i.currentRow.totalGrossWeight ? i.currentRow.totalGrossWeight.toFixed(t(S).COM_WT__KG) : "-"), 1)]), _: 1 }), e(p, { label: "日期", "label-class-name": "contractLabel" }, { default: a(() => [n(s(t(Me)(i.currentRow.createTime, "{y}-{m}-{d}")), 1)]), _: 1 })]), _: 1 }), pe((z(), F(ae, { ref_key: "serialNumberRef", ref: J, data: D.value, "data-format": Q.value, "return-source-data": "", showEmptySymbol: false, "max-height": t(X) - 160, style: { margin: "20px 0" } }, { default: a(() => [e(l, { align: "center", label: "序号", type: "index", width: "80" }), e(l, { key: "name", label: "名称", prop: "name", "show-overflow-tooltip": "" }), e(l, { key: "serialNumber", label: "编号", "min-width": "140px", prop: "serialNumber", "show-overflow-tooltip": "", sortable: "custom" }, { header: a(() => [e(oe, { content: "双击编号可预览图纸", class: "item", effect: "light", placement: "top" }, { default: a(() => o[10] || (o[10] = [_("div", { style: { display: "inline-block" } }, [_("span", { style: { "margin-left": "10px" } }, "编号"), _("i", { class: "el-icon-info" })], -1)])), _: 1, __: [10] })]), default: a((r) => [_("span", { style: { cursor: "pointer" }, onDblclick: (Oe) => t($)(r.row) }, s(r.row.serialNumber), 41, Le)]), _: 1 }), e(l, { key: "specification", label: "规格", "min-width": "120", prop: "specification", "show-overflow-tooltip": "" }), e(l, { key: "length", align: "left", label: "长度(mm)", "min-width": "90px", prop: "length", "show-overflow-tooltip": "" }), e(l, { key: "material", align: "left", label: "材质", "min-width": "90px", prop: "material", "show-overflow-tooltip": "" }), e(l, { key: "quantity", label: "数量", "min-width": "120", prop: "quantity", "show-overflow-tooltip": "" }), e(l, { key: "netWeight", align: "left", label: "单净重(kg)", "min-width": "90px", prop: "netWeight", "show-overflow-tooltip": "" }), e(l, { key: "totalNetWeight", align: "left", label: "总净重(kg)", "min-width": "90px", prop: "totalNetWeight", "show-overflow-tooltip": "" }), e(l, { key: "grossWeight", align: "left", label: "单毛重(kg)", "min-width": "90px", prop: "grossWeight", "show-overflow-tooltip": "" }), e(l, { key: "totalGrossWeight", align: "left", label: "总毛重(kg)", "min-width": "90px", prop: "totalGrossWeight", "show-overflow-tooltip": "" }), e(l, { key: "drawingWeight", align: "left", label: "单图纸重(kg)", "min-width": "90px", prop: "drawingWeight", "show-overflow-tooltip": "" }), e(l, { key: "drawingTotalWeight", align: "left", label: "总图纸重(kg)", "min-width": "90px", prop: "drawingTotalWeight", "show-overflow-tooltip": "" }), e(l, { key: "surfaceArea", label: `面积
(㎡)`, align: "left", "min-width": "80px", prop: "surfaceArea", "show-overflow-tooltip": "" }, { default: a((r) => [n(s(t(Ae)(r.row.surfaceArea, "mm²", "m²", t(S).COM_AREA__M2)), 1)]), _: 1 }), e(l, { key: "drawingAndSerialNumber", prop: "drawingAndSerialNumber", label: "是否导入图纸", align: "center", width: "100" }, { default: a((r) => [_("span", { style: fe({ color: t(K)(r.row.drawingAndSerialNumber) ? "#67c23a" : "#f56c6c" }) }, s(t(K)(r.row.drawingAndSerialNumber) ? "是" : "否"), 5)]), _: 1 }), e(l, { key: "remark", align: "left", label: "备注", "min-width": "80px", prop: "remark", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[ne, C.value]]), e(le, { "current-page": t(W).pageNumber, "page-size": t(W).pageSize, total: t(U), layout: "total, prev, pager, next, sizes", style: { "margin-top": "8px" }, onSizeChange: t(j), onCurrentChange: t(H) }, null, 8, ["current-page", "page-size", "total", "onSizeChange", "onCurrentChange"]), e(t(Ie), { visible: t(R), "onUpdate:visible": o[3] || (o[3] = (r) => B(R) ? R.value = r : null), "bool-bim": (m = t(f)) == null ? void 0 : m.boolBim, drawingSN: (u = t(f)) == null ? void 0 : u.drawingSN, "monomer-id": (c = t(f)) == null ? void 0 : c.monomerId, productId: (G = t(f)) == null ? void 0 : G.productId, productType: (I = t(f)) == null ? void 0 : I.productType, "serial-number": (L = t(f)) == null ? void 0 : L.serialNumber }, null, 8, ["visible", "bool-bim", "drawingSN", "monomer-id", "productId", "productType", "serial-number"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ze = Ne(Fe, [["__scopeId", "data-v-f85abcb5"]]);
export {
  Ze as default
};
