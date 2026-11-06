import { inject as M } from "vue";
import { computed as K } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as d } from "vue";
import { createBlock as h } from "vue";
import { withCtx as c } from "vue";
import { createVNode as u } from "vue";
import { createElementBlock as r } from "vue";
import { toDisplayString as f } from "vue";
import { unref as m } from "vue";
import { Fragment as P } from "vue";
import { createElementVNode as x } from "vue";
import { createTextVNode as O } from "vue";
import { createCommentVNode as k } from "vue";
import { mergeProps as W } from "vue";
import { reactive as G } from "vue";
import { watch as H } from "vue";
import { ElMessage as X } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElInput as Z } from "element-plus";
import { xC as w, am as ee, i as y, b as _, hg as Q, fv as ae, xD as te, aw as ne, aI as ie, wL as le, xE as se, cO as de, jl as ue, cS as C } from "../../../../../../../shared/runtime.js";
const oe = { key: 0 }, ce = { key: 0 }, pe = { key: 0 }, me = { key: 0 }, fe = { key: 0 }, re = { key: 0 }, ye = { class: "color-green" }, be = { class: "color-green" }, he = { key: 0, class: "flex-rbc" }, Ie = { style: { flex: "none", "margin-left": "10px", "text-align": "left" } }, ke = { __name: "auxiliary-material", setup(_e, { expose: R }) {
  const { realTimeValidate: L } = w(), N = ee.MATERIAL.V, E = M("classifyNameObj"), b = M("form"), p = M("classifyNameInventory"), T = K(() => y(E.value) ? E.value[N] || [] : []), B = { deficitProjectId: [{ validator: (e, l) => !(b.value.deficitType === Q.PROJECT.V && !e && l.diffQuantity), message: "请选择项目", trigger: "change" }], realTime: [{ validator: L, message: "请选择实际盘亏时间", trigger: "change" }] }, { tableValidate: q, wrongCellMask: A } = ne({ rules: B, errorMsg: "请修正【辅材清单】中标红的信息" });
  function z() {
    const e = G({ uid: ie(), specification: void 0, classifyId: void 0, brand: void 0, color: void 0, projectId: void 0, warehouseId: void 0, quantity: void 0, mete: void 0, classifyNameInventory: [], basicClass: N });
    S(e), b.value.auxiliaryMaterialList.push(e);
  }
  const g = ["specification", "brand", "projectId", "color", "warehouseId"];
  async function $(e) {
    var l;
    if (e.classifyId && (e.classifyName = (l = T.value.find((n) => n.id === e.classifyId)) == null ? void 0 : l.name, await le([e.classifyId]), y(e.classifyName))) {
      if (_(p.value[e.classifyName])) {
        p.value[e.classifyName] = [];
        const n = await se({ basicClass: N, classifyName: e.classifyName, boolPartyA: false }) || [];
        await de(n), await ue(n, { toSmallest: false, toNum: true }), n == null || n.forEach((o) => {
          var I, s;
          o.projectId = ((I = o.project) == null ? void 0 : I.id) || "-", o.warehouseId = ((s = o.warehouse) == null ? void 0 : s.id) || "-";
          for (let t = 0; t < g.length; t++) o[g[t]] = o[g[t]] || "-";
        }), p.value[e.classifyName] = n;
      }
      e.measureUnit = p.value[e.classifyName][0].measureUnit, e.accountingUnit = p.value[e.classifyName][0].accountingUnit, e.accountingPrecision = p.value[e.classifyName][0].accountingPrecision, e.measurePrecision = p.value[e.classifyName][0].measurePrecision, e.outboundUnitType = p.value[e.classifyName][0].outboundUnitType;
    }
  }
  function S(e) {
    H([() => e == null ? void 0 : e.specification, () => e == null ? void 0 : e.brand, () => e == null ? void 0 : e.color, () => e == null ? void 0 : e.projectId, () => e == null ? void 0 : e.warehouseId, () => {
      var l;
      return (l = p.value) == null ? void 0 : l[[e == null ? void 0 : e.classifyName]];
    }], () => {
      D(e);
    }, { deep: true });
  }
  function v(e) {
    e.quantity = void 0, e.mete = void 0, e.materialId = void 0, e.factoryId = void 0, e.operateQuantity = void 0, e.operateMete = void 0, e.maxQuantity = void 0, e.outboundUnitPrecision = void 0, e.outboundUnit = void 0, e.diffQuantity = void 0;
  }
  function D(e) {
    var l, n, o;
    if (e.classifyName && y(p.value[e.classifyName])) {
      let I = true;
      for (let s = 0; s < g.length; s++) {
        const t = g[s], V = t + "Options";
        e[V] = [], (l = p.value[e.classifyName]) == null || l.forEach((a) => {
          (!(t !== "specification" && e.specification) || a.specification === e.specification) && (!(t !== "brand" && e.brand) || a.brand === e.brand) && (!(t !== "projectId" && e.projectId) || a.projectId === e.projectId) && (!(t !== "warehouseId" && e.warehouseId) || a.warehouseId === e.warehouseId) && e[V].findIndex((i) => i.id === a[t]) < 0 && e[V].push({ id: a[t], serialNumber: t === "projectId" && y(a.project) ? a.project.serialNumber : void 0, shortName: t === "projectId" && y(a.project) ? a.project.shortName : void 0, name: t === "projectId" ? y(a.project) ? a.project.name : "-" : t === "warehouseId" ? y(a.warehouse) ? a.warehouse.name : "-" : a[t] });
        }), e[t] && !e[V].findIndex((a) => a.name === e[t]) < 0 && (e[t] = void 0), e[t] || (I = false);
      }
      if (I) {
        const s = p.value[e.classifyName].find((t) => t.specification === e.specification && t.brand === e.brand && t.projectId === e.projectId && t.warehouseId === e.warehouseId);
        y(s) ? ((n = b.value.auxiliaryMaterialList) == null ? void 0 : n.findIndex((t) => t.materialId === s.id)) > -1 ? (X.error("列表已添加该物料，请重新选择"), v(e)) : (e.quantity = s.quantity, e.mete = s.mete, e.materialId = s.id, e.factoryId = (o = s.factory) == null ? void 0 : o.id, e.operateQuantity = (s.quantity || 0) - (s.frozenQuantity || 0), e.operateMete = s.mete - (s.frozenMete || 0), e.maxQuantity = e.outboundUnitType === C.MEASURE.V ? e.operateQuantity : e.operateMete, e.outboundUnitPrecision = e.outboundUnitType === C.MEASURE.V ? e.measurePrecision : e.accountingPrecision, e.outboundUnit = e.outboundUnitType === C.MEASURE.V ? e.measureUnit : e.accountingUnit, e.diffQuantity = void 0) : v(e);
      } else v(e);
    }
  }
  function F(e, l) {
    b.value.auxiliaryMaterialList.splice(l, 1);
  }
  function J() {
    if (_(b.value.auxiliaryMaterialList)) return true;
    const { validResult: e, dealList: l } = q(b.value.auxiliaryMaterialList);
    return b.value.auxiliaryMaterialList = l, e;
  }
  return R({ addRow: z, rowWatch: S, validate: J }), (e, l) => {
    const n = Y, o = j("common-select"), I = j("common-input-number"), s = Z, t = j("common-button"), V = j("common-table");
    return d(), h(V, W({ "cell-class-name": m(A), data: m(b).auxiliaryMaterialList, "show-empty-symbol": false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: c(() => [u(n, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), u(n, { align: "center", fixed: "left", label: "名称", prop: "classifyName", "show-overflow-tooltip": "", sortable: "", width: "120" }, { default: c(({ row: a }) => [a.isImport ? (d(), r("span", oe, f(a.classifyName), 1)) : (d(), h(o, { key: 1, modelValue: a.classifyId, "onUpdate:modelValue": (i) => a.classifyId = i, options: T.value, dataStructure: { key: "id", label: "name", value: "id" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择物料名称", style: { width: "200px" }, onChange: (i) => $(a) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"]))]), _: 1 }), u(n, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "", width: "100px" }, { default: c(({ row: a }) => [a.isImport ? (d(), r("span", ce, f(a.specification), 1)) : (d(), h(o, { key: 1, modelValue: a.specification, "onUpdate:modelValue": (i) => a.specification = i, options: a.specificationOptions, dataStructure: { key: "name", label: "name", value: "name" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择规格", disabled: !a.classifyId || m(_)(a.specificationOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))]), _: 1 }), u(n, { align: "center", label: "品牌", "min-width": "100px", prop: "brand" }, { default: c(({ row: a }) => [a.isImport ? (d(), r("span", pe, f(a.brand), 1)) : (d(), h(o, { key: 1, modelValue: a.brand, "onUpdate:modelValue": (i) => a.brand = i, options: a.brandOptions || [], dataStructure: { key: "name", label: "name", value: "name" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择品牌", disabled: !a.classifyId || m(_)(a.brandOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))]), _: 1 }), u(n, { align: "center", label: "颜色", "min-width": "150px", prop: "color" }, { default: c(({ row: a }) => [a.isImport ? (d(), r("span", me, f(a.color), 1)) : (d(), h(o, { key: 1, modelValue: a.color, "onUpdate:modelValue": (i) => a.color = i, options: a.colorOptions || [], dataStructure: { key: "name", label: "name", value: "name" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择颜色", disabled: !a.classifyId || m(_)(a.colorOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))]), _: 1 }), u(n, { align: "center", label: "项目", "min-width": "100px", prop: "projectId" }, { default: c(({ row: a }) => {
      var i;
      return [a.isImport ? (d(), r("span", fe, f(((i = a.project) == null ? void 0 : i.name) || "-"), 1)) : (d(), h(o, { key: 1, modelValue: a.projectId, "onUpdate:modelValue": (U) => a.projectId = U, options: a.projectIdOptions || [], dataStructure: { key: "id", label: "name", value: "id" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择项目", disabled: !a.classifyId || m(_)(a.projectIdOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))];
    }), _: 1 }), u(n, { align: "center", label: "仓库", "min-width": "150px", prop: "warehouseId" }, { default: c(({ row: a }) => {
      var i;
      return [a.isImport ? (d(), r("span", re, f(((i = a.warehouse) == null ? void 0 : i.name) || "-"), 1)) : (d(), h(o, { key: 1, modelValue: a.warehouseId, "onUpdate:modelValue": (U) => a.warehouseId = U, options: a.warehouseIdOptions || [], dataStructure: { key: "id", label: "name", value: "id" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择仓库", disabled: !a.classifyId || m(_)(a.warehouseIdOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))];
    }), _: 1 }), u(n, { label: "现存数量", align: "center", prop: "quantity", width: "135px" }, { default: c(({ row: a }) => [a.measureUnit ? (d(), r(P, { key: 0 }, [m(y)(a.operateQuantity) ? (d(), r(P, { key: 0 }, [x("span", ye, f(a.operateQuantity), 1), l[0] || (l[0] = O(" / "))], 64)) : k("", true), x("span", null, f(a.quantity), 1)], 64)) : k("", true)]), _: 1 }), u(n, { key: "mete", label: "现存重量", align: "center", prop: "mete", width: "135px" }, { default: c(({ row: a }) => [m(y)(a.operateMete) ? (d(), r(P, { key: 0 }, [x("span", be, f(a.operateMete), 1), l[1] || (l[1] = O(" / "))], 64)) : k("", true), x("span", null, f(a.mete), 1)]), _: 1 }), u(n, { label: "盘亏数量", align: "center", prop: "diffQuantity", width: "135px" }, { default: c(({ row: a }) => [a.maxQuantity ? (d(), r("span", he, [u(I, { modelValue: a.diffQuantity, "onUpdate:modelValue": (i) => a.diffQuantity = i, controls: false, max: a.maxQuantity, min: 1, precision: a.outboundUnitPrecision, step: 1, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"]), x("span", Ie, f(a.outboundUnit), 1)])) : k("", true)]), _: 1 }), m(b).deficitType === m(Q).PROJECT.V ? (d(), h(n, { key: "deficitProjectId", label: "归属项目", align: "center", prop: "deficitProjectId", "min-width": "150px" }, { default: c(({ row: a }) => [u(m(ae), { modelValue: a.deficitProjectId, "onUpdate:modelValue": (i) => a.deficitProjectId = i, class: "input-underline", style: { width: "100%" }, filterable: "", clearable: "", placeholder: "可选择项目" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : k("", true), u(te, { label: "实际盘亏时间" }), u(n, { key: "remark", prop: "remark", align: "center", label: "备注", "min-width": "150px" }, { default: c(({ row: a }) => [u(s, { modelValue: a.remark, "onUpdate:modelValue": (i) => a.remark = i, placeholder: "备注", maxlength: "200", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), u(n, { align: "center", fixed: "right", label: "操作", width: "80" }, { default: c(({ row: a, $index: i }) => [u(t, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (U) => F(a.sn, i) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} };
export {
  ke as default
};
