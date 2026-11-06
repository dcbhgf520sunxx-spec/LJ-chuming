import { ref as u } from "vue";
import { computed as F } from "vue";
import { resolveComponent as c } from "vue";
import { resolveDirective as J } from "vue";
import { openBlock as T } from "vue";
import { createBlock as V } from "vue";
import { withCtx as d } from "vue";
import { withDirectives as D } from "vue";
import { createVNode as e } from "vue";
import { unref as l } from "vue";
import { createElementVNode as _ } from "vue";
import { withKeys as Q } from "vue";
import { createTextVNode as I } from "vue";
import { toDisplayString as k } from "vue";
import { isRef as X } from "vue";
import { ElInput as Y } from "element-plus";
import { ElTableColumn as Z } from "element-plus";
import { ElPagination as $ } from "element-plus";
import { vLoading as ee } from "element-plus";
import { a as te } from "../../../../../../modules/box-product-receive-send-storage-9ef20b12.js";
import { g as ae } from "../../../../../../modules/ship-manage-3066b2ed.js";
import { u as oe, J as ne, D as p, bb as le, q as ie } from "../../../../../../shared/runtime.js";
const re = { class: "head-container" }, se = { class: "header-div" }, pe = { __name: "detail-drawer", props: { showDetailDrawer: { type: Boolean }, query: { type: Object, default: () => {
} }, inventoryType: { type: Number } }, emits: ["update:showDetailDrawer"], setup(P, { emit: j }) {
  const n = P, x = j, { visible: g, handleClose: N } = oe({ emit: x, props: n, field: "showDetailDrawer", showHook: r }), { handleSizeChange: W, handleCurrentChange: S, total: z, setTotalPage: q, queryPage: f } = ne({ fetchHook: r }), i = u({ monomerId: void 0, areaId: void 0, serialNumber: void 0 }), h = u([]), v = u([]), m = F(() => ({ projectId: n.query.projectId, productType: n.query.productType, dateTime: n.query.dateTime, type: n.inventoryType })), y = u(false), G = u([["netWeight", ["to-fixed", p.COM_WT__KG]], ["grossWeight", ["to-fixed", p.COM_WT__KG]], ["totalNetWeight", ["to-fixed", p.COM_WT__KG]], ["totalGrossWeight", ["to-fixed", p.COM_WT__KG]]]);
  function K(s) {
    h.value = s || [];
  }
  async function r() {
    v.value = [], y.value = true;
    try {
      const s = await te({ ...m.value, ...i.value, ...f });
      v.value = s.content, q(s.totalElements), console.log(s);
    } catch (s) {
      console.log(s);
    } finally {
      y.value = false;
    }
  }
  function M() {
    i.value = {}, r();
  }
  return (s, t) => {
    const O = c("print-table"), E = c("common-select"), R = Y, b = c("common-button"), a = Z, U = c("common-table"), B = $, L = c("common-drawer"), A = J("permission"), H = ee;
    return T(), V(L, { onClose: l(N), modelValue: l(g), "onUpdate:modelValue": t[4] || (t[4] = (o) => X(g) ? g.value = o : null), size: "90%", title: n.inventoryType === 1 ? "期初库存量" : n.inventoryType === 2 ? "入库量" : n.inventoryType === 3 ? "出库量" : "期末库存量" }, { titleRight: d(() => [D(e(O, { "api-key": n.inventoryType === 1 ? "sectionProductStartDetail" : n.inventoryType === 2 ? "sectionProductInDetail" : n.inventoryType === 3 ? "sectionProductOutDetail" : "sectionProductEndDetail", params: { ...m.value, ...i.value } }, null, 8, ["api-key", "params"]), [[A, l(ae).detailPrint]])]), content: d(() => [_("div", re, [_("div", se, [e(l(le), { class: "filter-item", modelValue: m.value.projectId, "onUpdate:modelValue": t[0] || (t[0] = (o) => m.value.projectId = o), onChange: r, clearable: "" }, null, 8, ["modelValue"]), e(l(ie), { class: "filter-item", ref: "monomerSelectRef", modelValue: i.value.monomerId, "onUpdate:modelValue": t[1] || (t[1] = (o) => i.value.monomerId = o), "project-id": m.value.projectId, clearable: "", default: false, onChange: r, onGetAreaInfo: K }, null, 8, ["modelValue", "project-id"]), e(E, { class: "filter-item", placeholder: "请选择区域", modelValue: i.value.areaId, "onUpdate:modelValue": t[2] || (t[2] = (o) => i.value.areaId = o), options: h.value, dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", onChange: r }, null, 8, ["modelValue", "options"]), e(R, { class: "filter-item", style: { width: "200px" }, placeholder: "编号搜索", modelValue: i.value.serialNumber, "onUpdate:modelValue": t[3] || (t[3] = (o) => i.value.serialNumber = o), modelModifiers: { trim: true }, onKeyup: Q(r, ["enter"]) }, null, 8, ["modelValue"]), e(b, { class: "filter-item", type: "success", size: "default", icon: "el-icon-search", onClick: r, style: { "margin-left": "10px" } }, { default: d(() => t[5] || (t[5] = [I("搜索")])), _: 1, __: [5] }), e(b, { class: "filter-item", type: "warning", size: "default", icon: "el-icon-refresh-left", onClick: M }, { default: d(() => t[6] || (t[6] = [I("重置")])), _: 1, __: [6] })]), D((T(), V(U, { data: v.value, "data-format": G.value }, { default: d(() => [e(a, { label: "序号", type: "index", align: "center", "min-width": "55" }), e(a, { label: "项目简称", align: "center", "min-width": "120", prop: "project" }, { default: d(({ row: o }) => {
      var w, C;
      return [_("span", null, k(((w = o.project) == null ? void 0 : w.serialNumber) || "") + "-" + k(((C = o.project) == null ? void 0 : C.shortName) || ""), 1)];
    }), _: 1 }), e(a, { label: "单体", align: "center", "min-width": "100", prop: "monomer.name" }), e(a, { label: "区域", align: "center", "min-width": "100", prop: "area.name" }), e(a, { label: "编号", align: "center", "min-width": "100", prop: "serialNumber" }), e(a, { label: "规格", align: "center", "min-width": "100", prop: "specification" }), e(a, { label: "长度(mm)", align: "center", "min-width": "80", prop: "length" }), e(a, { label: "材质", align: "center", "min-width": "80", prop: "material" }), e(a, { label: "数量", align: "center", "min-width": "55", prop: "quantity" }), e(a, { label: "单净重(kg)", align: "center", "min-width": "80", prop: "netWeight", key: "netWeight" }), e(a, { label: "单毛重(kg)", align: "center", "min-width": "80", prop: "grossWeight" }), e(a, { label: "总净重(kg)", align: "center", "min-width": "80", prop: "totalNetWeight" }), e(a, { label: "总毛重(kg)", align: "center", "min-width": "80", prop: "totalGrossWeight" })]), _: 1 }, 8, ["data", "data-format"])), [[H, y.value]]), e(B, { total: l(z), "current-page": l(f).pageNumber, "page-size": l(f).pageSize, onSizeChange: l(W), onCurrentChange: l(S), layout: "total, prev, pager, next, sizes", style: { "margin-top": "8px" } }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])])]), _: 1 }, 8, ["onClose", "modelValue", "title"]);
  };
} };
export {
  pe as default
};
