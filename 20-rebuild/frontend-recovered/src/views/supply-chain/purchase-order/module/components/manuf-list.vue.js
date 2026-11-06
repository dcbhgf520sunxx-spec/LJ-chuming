import { ref as d } from "vue";
import { inject as K } from "vue";
import { watch as Q } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as C } from "vue";
import { createElementBlock as F } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as t } from "vue";
import { unref as s } from "vue";
import { withKeys as G } from "vue";
import { withCtx as u } from "vue";
import { createTextVNode as _ } from "vue";
import { withModifiers as N } from "vue";
import { createBlock as z } from "vue";
import { toDisplayString as I } from "vue";
import { normalizeStyle as W } from "vue";
import { createCommentVNode as J } from "vue";
import { withDirectives as Z } from "vue";
import { ElMessage as $ } from "element-plus";
import { ElInput as X } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElPagination as ee } from "element-plus";
import { vLoading as ae } from "element-plus";
import { J as te, u_ as ne, u$ as le, i as oe, V as ie, v0 as se, mw as re, bZ as ue, bW as ce } from "../../../../../shared/runtime.js";
const de = { class: "head-container" }, me = { style: { float: "right" } }, he = { __name: "manuf-list", props: { visible: { type: Boolean, default: false }, projectId: { type: Number }, maxHeight: { type: Number } }, emits: ["add"], setup(x, { emit: j }) {
  var V;
  const k = j, p = x, a = d({}), f = d([]), h = d([]), g = d(false), y = d([]), P = (V = K("crud")) == null ? void 0 : V.form, { handleSizeChange: S, handleCurrentChange: T, total: U, setTotalPage: E, queryPage: w } = te({ fetchHook: c });
  Q([() => p.projectId, () => a.value.monomerId, () => a.value.areaId], () => {
    a.value.projectId = p.projectId, c();
  }, { immediate: true }), Q(() => p.visible, (i) => {
    i && b();
  }, { immediate: true });
  function L(i) {
    return !!i.canPurchaseQuantity;
  }
  function q() {
    a.value.monomerId = void 0, a.value.areaId = void 0, a.value.serialNumber = void 0, c();
  }
  async function c() {
    var i;
    if (f.value = [], y.value = [], a.value.structureClassId = void 0, !!a.value.projectId) try {
      const { content: e } = await ne({ ...a.value });
      e != null && e.length && (f.value = e, a.value.structureClassId = (i = e[0]) == null ? void 0 : i.id, b());
    } catch (e) {
      console.log(e, "获取构件类型");
    }
  }
  async function b() {
    if (a.value.structureClassId) try {
      g.value = true;
      const { content: i, totalElements: e } = await le({ ...a.value, ...w });
      y.value = i.map((n) => {
        var r;
        if (oe((r = P.manufListObj) == null ? void 0 : r[n.id])) {
          const l = ie(P.manufListObj[n.id]);
          n.canPurchaseQuantity = n.quantity - n.purchaseQuantity - l.curPurchaseQuantity;
        } else n.canPurchaseQuantity = n.quantity - n.purchaseQuantity;
        return n.canPurchaseQuantity = n.canPurchaseQuantity > 0 ? n.canPurchaseQuantity : 0, n.curPurchaseQuantity = n.canPurchaseQuantity, n.basicClass = se.STRUC_MANUFACTURED.V, n;
      }), E(e);
    } catch (i) {
      console.log(i, "获取成品清单");
    } finally {
      g.value = false;
    }
  }
  function B(i) {
    h.value = i;
  }
  function D() {
    if (!h.value.length) {
      $.warning("请至少选择一条数据");
      return;
    }
    k("add", h.value);
  }
  return (i, e) => {
    const n = X, r = v("common-button"), l = Y, M = v("common-input-number"), A = v("common-table"), O = ee, R = ae;
    return C(), F("div", null, [m("div", de, [t(s(ue), { monomerId: a.value.monomerId, "onUpdate:monomerId": e[0] || (e[0] = (o) => a.value.monomerId = o), areaId: a.value.areaId, "onUpdate:areaId": e[1] || (e[1] = (o) => a.value.areaId = o), areaType: s(re).OUTSOURCE.V, clearable: "", areaClearable: "", "project-id": p.projectId }, null, 8, ["monomerId", "areaId", "areaType", "project-id"]), t(n, { modelValue: a.value.serialNumber, "onUpdate:modelValue": e[2] || (e[2] = (o) => a.value.serialNumber = o), modelModifiers: { trim: true }, placeholder: "输入编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: G(c, ["enter"]) }, null, 8, ["modelValue"]), t(r, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: N(c, ["stop"]) }, { default: u(() => e[4] || (e[4] = [_("搜索")])), _: 1, __: [4] }), t(r, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: N(q, ["stop"]) }, { default: u(() => e[5] || (e[5] = [_(" 重置 ")])), _: 1, __: [5] }), m("div", null, [f.value.length ? (C(), z(s(ce), { key: 0, modelValue: a.value.structureClassId, "onUpdate:modelValue": e[3] || (e[3] = (o) => a.value.structureClassId = o), class: "filter-item", style: W(["width:calc(100% - 230px)", { display: "inline-block" }]), data: f.value, itemKey: "id", onChange: b }, { default: u(({ item: o }) => [m("span", null, I(o.name) + "(件/kg)：", 1), m("span", null, I(o.quantity) + "/" + I(o.mete), 1)]), _: 1 }, 8, ["modelValue", "data"])) : J("", true), m("span", me, [t(r, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-plus", onClick: D }, { default: u(() => e[6] || (e[6] = [_(" 选择加入 ")])), _: 1, __: [6] })])])]), Z((C(), z(A, { data: y.value, "max-height": x.maxHeight, style: { width: "100%" }, onSelectionChange: B }, { default: u(() => [t(l, { type: "selection", width: "55", align: "center", selectable: L }), t(l, { label: "序号", type: "index", align: "center", width: "60" }), t(l, { prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": "", "min-width": "120px" }), t(l, { prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": "", "min-width": "120px" }), t(l, { prop: "name", label: "名称", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), t(l, { prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), t(l, { prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "", "min-width": "140px" }), t(l, { prop: "length", label: "长度（mm）", align: "center", "show-overflow-tooltip": "" }), t(l, { prop: "material", label: "材质", align: "center", "show-overflow-tooltip": "" }), t(l, { prop: "quantity", label: "清单数量", align: "center", "show-overflow-tooltip": "" }), t(l, { prop: "canPurchaseQuantity", label: "可采购数量", align: "center", "show-overflow-tooltip": "" }), t(l, { label: "采购数量", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }, { default: u(({ row: { sourceRow: o } }) => [t(M, { modelValue: o.curPurchaseQuantity, "onUpdate:modelValue": (H) => o.curPurchaseQuantity = H, min: 0, max: o.canPurchaseQuantity, "controls-position": "right", controls: false, step: 5, size: "default", placeholder: "数量" }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])]), _: 1 }), t(l, { prop: "totalNetWeight", label: "总重（kg）", align: "center", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "max-height"])), [[R, g.value]]), t(O, { total: s(U), "current-page": s(w).pageNumber, "page-size": s(w).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: s(S), onCurrentChange: s(T) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]);
  };
} };
export {
  he as default
};
