import { ref as u } from "vue";
import { inject as ve } from "vue";
import { computed as ge } from "vue";
import { watch as ye } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as c } from "vue";
import { createBlock as g } from "vue";
import { withCtx as d } from "vue";
import { createVNode as o } from "vue";
import { createElementBlock as z } from "vue";
import { createElementVNode as I } from "vue";
import { unref as s } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as he } from "vue";
import { createCommentVNode as N } from "vue";
import { withKeys as V } from "vue";
import { withDirectives as be } from "vue";
import { resolveDynamicComponent as Ce } from "vue";
import { isRef as _e } from "vue";
import { ElTag as Ie } from "element-plus";
import { ElInput as Ve } from "element-plus";
import { ElBadge as we } from "element-plus";
import { ElTableColumn as je } from "element-plus";
import { ElPagination as Te } from "element-plus";
import { vLoading as xe } from "element-plus";
import { u as Ue, J as ke, kQ as p, o as Se, bZ as Le, z as Ee, V as B } from "../../../../../../shared/runtime.js";
import { b as Re, f as Pe, g as Ae } from "../../../../../../modules/list-valuation-9a754659.js";
import M from "../components/list-drawer-table/structure.vue.js";
import ze from "../components/list-drawer-table/enclosure.vue.js";
import Ne from "../components/list-drawer-table/auxiliary-material.vue.js";
import Be from "./list-create.vue.js";
import "../components/list-create-table/structure.vue.js";
import "../components/list-create-table/enclosure.vue.js";
import "../components/list-create-table/auxiliary-material.vue.js";
const Me = { key: 0 }, qe = { class: "head-container" }, He = { style: { float: "right" } }, De = { key: 1, style: { color: "red" } }, et = { __name: "list-drawer", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible", "refresh"], setup(q, { emit: H }) {
  const w = u(), D = ve("crud"), j = u(false), L = u([]), h = u({}), m = u({}), E = u([]), T = u(false), b = u([]), n = u([]), x = u(false), R = u(), P = H, K = q, t = u({ projectId: "" }), { visible: U, handleClose: Q } = Ue({ emit: P, props: K, field: "visible", showHook: Z }), { handleSizeChange: O, handleCurrentChange: W, total: $, setTotalPage: F, queryPage: k } = ke({ fetchHook: i }), J = ge(() => {
    switch (t.value.productType) {
      case p.STRUCTURE.V:
        return M;
      case p.ENCLOSURE.V:
        return ze;
      case p.AUXILIARY_MATERIAL.V:
        return Ne;
      default:
        return M;
    }
  }), { maxHeight: X } = Se({ mainBox: ".list-valuation-list-drawer", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], navbar: false, paginate: true, clientHRepMainH: true, extraHeight: 110 }, () => R.value.loaded);
  ye(() => t.value.projectId, async (a) => {
    a && (n.value = [], await C(), await i());
  }, { immediate: true });
  async function Y() {
    try {
      j.value = true, h.value = {};
      const { content: a } = await Ae();
      L.value = a.map((e) => (e.fullname = Ee(e), h.value[e.id] = e, e));
    } catch (a) {
      console.log(a);
    } finally {
      j.value = false;
    }
  }
  async function C() {
    var a;
    try {
      const e = await Re({ projectId: t.value.projectId, productType: t.value.productType });
      m.value = { ...e, ...(a = h.value) == null ? void 0 : a[t.value.projectId] };
    } catch (e) {
      console.log(e);
    }
  }
  function Z() {
    Y(), t.value = {}, t.value.productType = p.STRUCTURE.V, t.value.projectId = D.query.projectId, t.value.projectId && C();
  }
  async function i() {
    try {
      T.value = true;
      const { content: a, totalElements: e } = await Pe({ ...t.value, ...k });
      E.value = a.map((r) => (r.originQuantity = r.quantity, r.originMete = r.mete, r.enclosureTotalWeight = r.totalWeight, r.originTotalLength = r.totalLength, r.originTotalArea = r.totalArea, r)) || [], F(e);
    } catch (a) {
      console.log(a);
    } finally {
      T.value = false;
    }
  }
  function G() {
    const { projectId: a, productType: e } = t.value;
    t.value = { projectId: a, productType: e }, i();
  }
  function A(a) {
    return n.value.findIndex((e) => e.productId === a.productId) === -1;
  }
  function ee() {
    var a;
    i(), C(), b.value = [], (a = w.value) == null || a.clearSelection(), n.value = [];
  }
  function te(a) {
    b.value = a;
  }
  function ae() {
    var a;
    n.value = n.value.concat(B(b.value)), b.value = [], (a = w.value) == null || a.clearSelection();
  }
  function le() {
    var a;
    m.value = { ...m.value, ...(a = h.value) == null ? void 0 : a[t.value.projectId] }, x.value = true;
  }
  function oe(a) {
    n.value.push(B(a));
  }
  function ne() {
    n.value = [];
  }
  function re(a) {
    n.value.splice(a, 1);
  }
  function ie() {
    n.value = [], i(), P("refresh");
  }
  return (a, e) => {
    const r = v("common-select"), ue = v("common-radio-button"), se = Ie, _ = Ve, f = v("common-button"), de = we, S = je, ce = v("common-table"), pe = Te, me = v("common-drawer"), fe = xe;
    return c(), g(me, { ref_key: "drawerRef", ref: R, title: "清单计价", modelValue: s(U), "onUpdate:modelValue": e[9] || (e[9] = (l) => _e(U) ? U.value = l : null), direction: "rtl", "before-close": s(Q), size: "100%", "custom-class": "list-valuation-list-drawer" }, { titleAfter: d(() => [o(r, { modelValue: t.value.projectId, "onUpdate:modelValue": e[0] || (e[0] = (l) => t.value.projectId = l), options: L.value, loading: j.value, type: "other", class: "filter-item", dataStructure: { key: "id", label: "fullname", value: "id" }, clearable: "", filterable: "", placeholder: "请选择项目", style: { width: "350px" }, onChange: C }, null, 8, ["modelValue", "options", "loading"])]), titleRight: d(() => e[10] || (e[10] = [])), content: d(() => [t.value.projectId ? (c(), z("div", Me, [I("div", qe, [I("div", null, [o(ue, { modelValue: t.value.productType, "onUpdate:modelValue": e[1] || (e[1] = (l) => t.value.productType = l), options: s(p).ENUM, type: "enum", class: "filter-item", onChange: ee }, null, 8, ["modelValue", "options"]), o(se, { size: "large", effect: "plain", class: "filter-item" }, { default: d(() => [y(" 剩余：" + he(m.value.unPricingQuantity || 0) + "件未计价 ", 1)]), _: 1 })]), I("div", null, [t.value.productType !== s(p).ENCLOSURE.V ? (c(), g(s(Le), { key: 0, monomerId: t.value.monomerId, "onUpdate:monomerId": e[2] || (e[2] = (l) => t.value.monomerId = l), areaId: t.value.areaId, "onUpdate:areaId": e[3] || (e[3] = (l) => t.value.areaId = l), productType: t.value.productType, clearable: "", areaClearable: "", "project-id": t.value.projectId, onMonomerChange: i, onAreaChange: i }, null, 8, ["monomerId", "areaId", "productType", "project-id"])) : N("", true), o(_, { modelValue: t.value.name, "onUpdate:modelValue": e[4] || (e[4] = (l) => t.value.name = l), placeholder: "按名称搜索", class: "filter-item", style: { width: "200px" }, clearable: "", onKeyup: V(i, ["enter"]) }, null, 8, ["modelValue"]), o(_, { modelValue: t.value.serialNumber, "onUpdate:modelValue": e[5] || (e[5] = (l) => t.value.serialNumber = l), placeholder: "按编号搜索", class: "filter-item", style: { width: "200px" }, clearable: "", onKeyup: V(i, ["enter"]) }, null, 8, ["modelValue"]), o(_, { modelValue: t.value.specification, "onUpdate:modelValue": e[6] || (e[6] = (l) => t.value.specification = l), placeholder: "按规格搜索", class: "filter-item", style: { width: "200px" }, clearable: "", onKeyup: V(i, ["enter"]) }, null, 8, ["modelValue"]), t.value.productType === s(p).STRUCTURE.V ? (c(), g(_, { key: 1, modelValue: t.value.material, "onUpdate:modelValue": e[7] || (e[7] = (l) => t.value.material = l), placeholder: "按材质搜索", class: "filter-item", style: { width: "200px" }, clearable: "", onKeyup: V(i, ["enter"]) }, null, 8, ["modelValue"])) : N("", true), o(f, { class: "filter-item", type: "success", onClick: i }, { default: d(() => e[11] || (e[11] = [y("搜索")])), _: 1, __: [11] }), o(f, { class: "filter-item", type: "warning", onClick: G }, { default: d(() => e[12] || (e[12] = [y("重置")])), _: 1, __: [12] }), I("span", He, [o(f, { class: "filter-item", type: "primary", onClick: ae, icon: "el-icon-plus" }, { default: d(() => e[13] || (e[13] = [y("添加")])), _: 1, __: [13] }), o(de, { value: n.value.length, max: 99, hidden: n.value.length < 1 }, { default: d(() => [o(f, { class: "filter-item", type: "success", disabled: n.value.length < 1, onClick: le }, { default: d(() => e[14] || (e[14] = [y(" 清单计价 ")])), _: 1, __: [14] }, 8, ["disabled"])]), _: 1 }, 8, ["value", "hidden"])])])]), be((c(), g(ce, { ref_key: "tableRef", ref: w, data: E.value, "max-height": s(X), style: { width: "100%" }, onSelectionChange: te }, { default: d(() => [o(S, { type: "selection", align: "center", width: "60", class: "selection", selectable: A }), o(S, { label: "序号", type: "index", align: "center", width: "60" }), (c(), g(Ce(J.value))), o(S, { label: "操作", align: "center", width: "80" }, { default: d(({ row: l }) => [o(f, { type: "primary", disabled: !A(l), size: "small", icon: "el-icon-plus", onClick: (Ke) => oe(l) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[fe, T.value]]), o(pe, { total: s($), "current-page": s(k).pageNumber, "page-size": s(k).pageSize, "page-sizes": [10, 20, 30, 40, 50, 100, 200, 500], style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: s(O), onCurrentChange: s(W) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])])) : (c(), z("div", De, "* 请先选择项目再进行清单计价")), o(Be, { visible: x.value, "onUpdate:visible": e[8] || (e[8] = (l) => x.value = l), addList: n.value, projectInfo: m.value, query: t.value, onClearAll: ne, onClear: re, onSuccess: ie }, null, 8, ["visible", "addList", "projectInfo", "query"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  et as default
};
