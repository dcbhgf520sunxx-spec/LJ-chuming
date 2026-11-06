import { inject as P } from "vue";
import { computed as G } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as d } from "vue";
import { createBlock as I } from "vue";
import { withCtx as p } from "vue";
import { createVNode as u } from "vue";
import { createElementBlock as f } from "vue";
import { toDisplayString as r } from "vue";
import { unref as m } from "vue";
import { Fragment as C } from "vue";
import { createElementVNode as k } from "vue";
import { createTextVNode as O } from "vue";
import { createCommentVNode as _ } from "vue";
import { mergeProps as K } from "vue";
import { reactive as W } from "vue";
import { watch as H } from "vue";
import { ElMessage as X } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElInput as Z } from "element-plus";
import { xC as w, am as ee, i as y, b as V, hg as M, fv as ae, xD as te, aw as ne, aI as ie, wL as le, xE as se, cO as de, jl as ue, cS as E } from "../../../../../../../shared/runtime.js";
const ce = { key: 0 }, oe = { key: 0 }, pe = { key: 0 }, fe = { key: 0 }, me = { key: 0 }, re = { class: "color-green" }, ye = { class: "color-green" }, be = { key: 0, class: "flex-rbc" }, he = { style: { flex: "none", "margin-left": "10px", "text-align": "left" } }, Ie = { key: 0, class: "flex-rbc" }, _e = { key: 0, class: "flex-rbc" }, je = { __name: "gas-table", setup(ge, { expose: R }) {
  const { realTimeValidate: L } = w(), N = ee.GAS.V, Q = P("classifyNameObj"), b = P("form"), o = P("classifyNameInventory"), S = G(() => y(Q.value) ? Q.value[N] || [] : []), B = { deficitProjectId: [{ validator: (e, l) => !(b.value.deficitType === M.PROJECT.V && !e && l.diffQuantity), message: "请选择项目", trigger: "change" }], realTime: [{ validator: L, message: "请选择实际盘亏时间", trigger: "change" }] }, { tableValidate: q, wrongCellMask: A } = ne({ rules: B, errorMsg: "请修正【气体清单】中标红的信息" });
  function z() {
    const e = W({ uid: ie(), specification: void 0, classifyId: void 0, brand: void 0, heatNoAndBatchNo: void 0, projectId: void 0, warehouseId: void 0, quantity: void 0, mete: void 0, classifyNameInventory: [], basicClass: N });
    T(e), b.value.gasList.push(e);
  }
  const x = ["specification", "brand", "projectId", "warehouseId"];
  async function $(e) {
    var l;
    if (e.classifyId && (e.classifyName = (l = S.value.find((n) => n.id === e.classifyId)) == null ? void 0 : l.name, await le([e.classifyId]), y(e.classifyName))) {
      if (V(o.value[e.classifyName])) {
        o.value[e.classifyName] = [];
        const n = await se({ basicClass: N, classifyName: e.classifyName, boolPartyA: false }) || [];
        await de(n), await ue(n, { toSmallest: false, toNum: true }), n == null || n.forEach((c) => {
          var h, s;
          c.projectId = ((h = c.project) == null ? void 0 : h.id) || "-", c.warehouseId = ((s = c.warehouse) == null ? void 0 : s.id) || "-";
          for (let t = 0; t < x.length; t++) c[x[t]] = c[x[t]] || "-";
        }), o.value[e.classifyName] = n;
      }
      e.measureUnit = o.value[e.classifyName][0].measureUnit, e.accountingUnit = o.value[e.classifyName][0].accountingUnit, e.accountingPrecision = o.value[e.classifyName][0].accountingPrecision, e.measurePrecision = o.value[e.classifyName][0].measurePrecision, e.outboundUnitType = o.value[e.classifyName][0].outboundUnitType;
    }
  }
  function T(e) {
    H([() => e == null ? void 0 : e.specification, () => e == null ? void 0 : e.brand, () => e == null ? void 0 : e.projectId, () => e == null ? void 0 : e.warehouseId, () => {
      var l;
      return (l = o.value) == null ? void 0 : l[[e == null ? void 0 : e.classifyName]];
    }], () => {
      D(e);
    }, { deep: true });
  }
  function v(e) {
    e.quantity = void 0, e.mete = void 0, e.materialId = void 0, e.factoryId = void 0, e.operateQuantity = void 0, e.operateMete = void 0, e.maxQuantity = void 0, e.outboundUnitPrecision = void 0, e.outboundUnit = void 0, e.diffQuantity = void 0;
  }
  function D(e) {
    var l, n, c;
    if (e.classifyName && y(o.value[e.classifyName])) {
      let h = true;
      for (let s = 0; s < x.length; s++) {
        const t = x[s], g = t + "Options";
        e[g] = [], (l = o.value[e.classifyName]) == null || l.forEach((a) => {
          (!(t !== "specification" && e.specification) || a.specification === e.specification) && (!(t !== "brand" && e.brand) || a.brand === e.brand) && (!(t !== "projectId" && e.projectId) || a.projectId === e.projectId) && (!(t !== "warehouseId" && e.warehouseId) || a.warehouseId === e.warehouseId) && e[g].findIndex((i) => i.id === a[t]) < 0 && e[g].push({ id: a[t], serialNumber: t === "projectId" && y(a.project) ? a.project.serialNumber : void 0, shortName: t === "projectId" && y(a.project) ? a.project.shortName : void 0, name: t === "projectId" ? y(a.project) ? a.project.name : "-" : t === "warehouseId" ? y(a.warehouse) ? a.warehouse.name : "-" : a[t] });
        }), e[t] && !e[g].findIndex((a) => a.name === e[t]) < 0 && (e[t] = void 0), e[t] || (h = false);
      }
      if (h) {
        const s = o.value[e.classifyName].find((t) => t.specification === e.specification && t.brand === e.brand && t.projectId === e.projectId && t.warehouseId === e.warehouseId);
        y(s) ? ((n = b.value.gasList) == null ? void 0 : n.findIndex((t) => t.materialId === s.id)) > -1 ? (X.error("列表已添加该物料，请重新选择"), v(e)) : (e.quantity = s.quantity, e.mete = s.mete, e.materialId = s.id, e.factoryId = (c = s.factory) == null ? void 0 : c.id, e.operateQuantity = (s.quantity || 0) - (s.frozenQuantity || 0), e.operateMete = s.mete - (s.frozenMete || 0), e.maxQuantity = e.outboundUnitType === E.MEASURE.V ? e.operateQuantity : e.operateMete, e.outboundUnitPrecision = e.outboundUnitType === E.MEASURE.V ? e.measurePrecision : e.accountingPrecision, e.outboundUnit = e.outboundUnitType === E.MEASURE.V ? e.measureUnit : e.accountingUnit, e.diffQuantity = void 0) : v(e);
      } else v(e);
    }
  }
  function F(e, l) {
    b.value.gasList.splice(l, 1);
  }
  function J() {
    if (V(b.value.gasList)) return true;
    const { validResult: e, dealList: l } = q(b.value.gasList);
    return b.value.gasList = l, e;
  }
  return R({ addRow: z, rowWatch: T, validate: J }), (e, l) => {
    const n = Y, c = U("common-select"), h = U("common-input-number"), s = Z, t = U("common-button"), g = U("common-table");
    return d(), I(g, K({ "cell-class-name": m(A), data: m(b).gasList, "show-empty-symbol": false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: p(() => [u(n, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), u(n, { align: "center", fixed: "left", label: "名称", prop: "classifyName", "show-overflow-tooltip": "", sortable: "", width: "120" }, { default: p(({ row: a }) => [a.isImport ? (d(), f("span", ce, r(a.classifyName), 1)) : (d(), I(c, { key: 1, modelValue: a.classifyId, "onUpdate:modelValue": (i) => a.classifyId = i, options: S.value, dataStructure: { key: "id", label: "name", value: "id" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择物料名称", style: { width: "200px" }, onChange: (i) => $(a) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"]))]), _: 1 }), u(n, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "", width: "100px" }, { default: p(({ row: a }) => [a.isImport ? (d(), f("span", oe, r(a.specification), 1)) : (d(), I(c, { key: 1, modelValue: a.specification, "onUpdate:modelValue": (i) => a.specification = i, options: a.specificationOptions, dataStructure: { key: "name", label: "name", value: "name" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择规格", disabled: !a.classifyId || m(V)(a.specificationOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))]), _: 1 }), u(n, { align: "center", label: "品牌", "min-width": "100px", prop: "brand" }, { default: p(({ row: a }) => [a.isImport ? (d(), f("span", pe, r(a.brand), 1)) : (d(), I(c, { key: 1, modelValue: a.brand, "onUpdate:modelValue": (i) => a.brand = i, options: a.brandOptions || [], dataStructure: { key: "name", label: "name", value: "name" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择品牌", disabled: !a.classifyId || m(V)(a.brandOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))]), _: 1 }), u(n, { align: "center", label: "项目", "min-width": "100px", prop: "projectId" }, { default: p(({ row: a }) => {
      var i;
      return [a.isImport ? (d(), f("span", fe, r(((i = a.project) == null ? void 0 : i.name) || "-"), 1)) : (d(), I(c, { key: 1, modelValue: a.projectId, "onUpdate:modelValue": (j) => a.projectId = j, options: a.projectIdOptions || [], dataStructure: { key: "id", label: "name", value: "id" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择项目", disabled: !a.classifyId || m(V)(a.projectIdOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))];
    }), _: 1 }), u(n, { align: "center", label: "仓库", "min-width": "150px", prop: "warehouseId" }, { default: p(({ row: a }) => {
      var i;
      return [a.isImport ? (d(), f("span", me, r(((i = a.warehouse) == null ? void 0 : i.name) || "-"), 1)) : (d(), I(c, { key: 1, modelValue: a.warehouseId, "onUpdate:modelValue": (j) => a.warehouseId = j, options: a.warehouseIdOptions || [], dataStructure: { key: "id", label: "name", value: "id" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择仓库", disabled: !a.classifyId || m(V)(a.warehouseIdOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))];
    }), _: 1 }), u(n, { label: "现存数量", align: "center", prop: "quantity", width: "135px" }, { default: p(({ row: a }) => [a.measureUnit ? (d(), f(C, { key: 0 }, [m(y)(a.operateQuantity) ? (d(), f(C, { key: 0 }, [k("span", re, r(a.operateQuantity), 1), l[0] || (l[0] = O(" / "))], 64)) : _("", true), k("span", null, r(a.quantity), 1)], 64)) : _("", true)]), _: 1 }), u(n, { key: "mete", label: "现存重量", align: "center", prop: "mete", width: "135px" }, { default: p(({ row: a }) => [m(y)(a.operateMete) ? (d(), f(C, { key: 0 }, [k("span", ye, r(a.operateMete), 1), l[1] || (l[1] = O(" / "))], 64)) : _("", true), k("span", null, r(a.mete), 1)]), _: 1 }), u(n, { label: "盘亏数量", align: "center", prop: "diffQuantity", width: "135px" }, { default: p(({ row: a }) => [a.maxQuantity ? (d(), f("span", be, [u(h, { modelValue: a.diffQuantity, "onUpdate:modelValue": (i) => a.diffQuantity = i, controls: false, max: a.maxQuantity, min: 1, precision: a.outboundUnitPrecision, step: 1, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"]), k("span", he, r(a.outboundUnit), 1)])) : _("", true)]), _: 1 }), m(b).deficitType === m(M).PROJECT.V ? (d(), I(n, { key: "deficitProjectId", label: "归属项目", align: "center", prop: "deficitProjectId", "min-width": "150px" }, { default: p(({ row: a }) => [a.maxQuantity ? (d(), f("span", Ie, [u(m(ae), { modelValue: a.deficitProjectId, "onUpdate:modelValue": (i) => a.deficitProjectId = i, class: "input-underline", style: { width: "100%" }, filterable: "", clearable: "", placeholder: "可选择项目" }, null, 8, ["modelValue", "onUpdate:modelValue"])])) : _("", true)]), _: 1 })) : _("", true), u(te, { label: "实际盘亏时间" }), u(n, { key: "remark", prop: "remark", align: "center", label: "备注", "min-width": "150px" }, { default: p(({ row: a }) => [a.maxQuantity ? (d(), f("span", _e, [u(s, { modelValue: a.remark, "onUpdate:modelValue": (i) => a.remark = i, placeholder: "备注", maxlength: "200", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])])) : _("", true)]), _: 1 }), u(n, { align: "center", fixed: "right", label: "操作", width: "80" }, { default: p(({ row: a, $index: i }) => [u(t, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (j) => F(a.sn, i) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} };
export {
  je as default
};
