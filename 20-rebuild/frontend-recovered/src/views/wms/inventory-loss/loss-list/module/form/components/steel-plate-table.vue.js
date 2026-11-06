import { inject as O } from "vue";
import { computed as W } from "vue";
import { resolveComponent as P } from "vue";
import { openBlock as i } from "vue";
import { createBlock as r } from "vue";
import { withCtx as p } from "vue";
import { createVNode as d } from "vue";
import { createElementBlock as m } from "vue";
import { toDisplayString as f } from "vue";
import { unref as s } from "vue";
import { Fragment as A } from "vue";
import { createElementVNode as x } from "vue";
import { createTextVNode as C } from "vue";
import { createCommentVNode as N } from "vue";
import { mergeProps as G } from "vue";
import { reactive as H } from "vue";
import { watch as X } from "vue";
import { ElMessage as Y } from "element-plus";
import { ElTableColumn as Z } from "element-plus";
import { ElInput as w } from "element-plus";
import { xC as ee, am as te, sQ as ae, i as y, b, hg as Q, fv as ne, xD as le, aw as ie, aI as se, wL as de, xE as ue, cO as ce, jl as oe, cS as T } from "../../../../../../../shared/runtime.js";
const pe = { key: 0 }, me = { key: 0 }, fe = { key: 0 }, he = { key: 0 }, re = { key: 0 }, ye = { key: 0 }, be = { key: 0 }, Ie = { key: 0 }, _e = { key: 0 }, ge = { class: "color-green" }, ke = { class: "color-green" }, Ne = { key: 0, class: "flex-rbc" }, Ve = { style: { flex: "none", "margin-left": "10px", "text-align": "left" } }, xe = { key: 0, class: "flex-rbc" }, Ue = { key: 0, class: "flex-rbc" }, Te = { __name: "steel-plate-table", setup(je, { expose: L }) {
  const { realTimeValidate: M } = ee(), U = te.STEEL_PLATE.V, S = O("classifyNameObj"), I = O("form"), { baseUnit: _ } = ae(U), h = O("classifyNameInventory"), E = W(() => y(S.value) ? S.value[U] || [] : []), R = { deficitProjectId: [{ validator: (e, u) => !(I.value.deficitType === Q.PROJECT.V && !e && u.diffQuantity), message: "请选择项目", trigger: "change" }], realTime: [{ validator: M, message: "请选择实际盘亏时间", trigger: "change" }] }, { tableValidate: $, wrongCellMask: q } = ie({ rules: R, errorMsg: "请修正【钢板清单】中标红的信息" });
  function F() {
    const e = H({ uid: se(), specification: void 0, thickness: void 0, width: void 0, classifyId: void 0, length: void 0, brand: void 0, heatNoAndBatchNo: void 0, projectId: void 0, warehouseId: void 0, quantity: void 0, mete: void 0, classifyNameInventory: [], basicClass: U });
    v(e), I.value.steelPlateList.push(e);
  }
  const V = ["specification", "thickness", "width", "length", "brand", "heatNoAndBatchNo", "projectId", "warehouseId"];
  async function z(e) {
    var u;
    if (e.classifyId && (e.classifyName = (u = E.value.find((l) => l.id === e.classifyId)) == null ? void 0 : u.name, await de([e.classifyId]), y(e.classifyName))) {
      if (b(h.value[e.classifyName])) {
        h.value[e.classifyName] = [];
        const l = await ue({ basicClass: U, classifyName: e.classifyName, boolPartyA: false }) || [];
        await ce(l), await oe(l, { toSmallest: false, toNum: true }), l == null || l.forEach((c) => {
          var g, o;
          c.projectId = ((g = c.project) == null ? void 0 : g.id) || "-", c.warehouseId = ((o = c.warehouse) == null ? void 0 : o.id) || "-";
          for (let a = 0; a < V.length; a++) c[V[a]] = c[V[a]] || "-";
        }), h.value[e.classifyName] = l;
      }
      e.measureUnit = h.value[e.classifyName][0].measureUnit, e.accountingUnit = h.value[e.classifyName][0].accountingUnit, e.accountingPrecision = h.value[e.classifyName][0].accountingPrecision, e.measurePrecision = h.value[e.classifyName][0].measurePrecision, e.outboundUnitType = h.value[e.classifyName][0].outboundUnitType;
    }
  }
  function v(e) {
    X([() => e == null ? void 0 : e.specification, () => e == null ? void 0 : e.thickness, () => e == null ? void 0 : e.width, () => e == null ? void 0 : e.length, () => e == null ? void 0 : e.brand, () => e == null ? void 0 : e.heatNoAndBatchNo, () => e == null ? void 0 : e.projectId, () => e == null ? void 0 : e.warehouseId, () => {
      var u;
      return (u = h.value) == null ? void 0 : u[[e == null ? void 0 : e.classifyName]];
    }], () => {
      D(e);
    }, { deep: true });
  }
  function B(e) {
    e.quantity = void 0, e.mete = void 0, e.materialId = void 0, e.factoryId = void 0, e.operateQuantity = void 0, e.operateMete = void 0, e.maxQuantity = void 0, e.outboundUnitPrecision = void 0, e.outboundUnit = void 0, e.diffQuantity = void 0, e.realTime = void 0;
  }
  function D(e) {
    var u, l, c;
    if (e.classifyName && y(h.value[e.classifyName])) {
      let g = true;
      for (let o = 0; o < V.length; o++) {
        const a = V[o], k = a + "Options";
        e[k] = [], (u = h.value[e.classifyName]) == null || u.forEach((t) => {
          (!(a !== "specification" && e.specification) || t.specification === e.specification) && (!(a !== "thickness" && e.thickness) || t.thickness === e.thickness) && (!(a !== "width" && e.width) || t.width === e.width) && (!(a !== "length" && e.length) || t.length === e.length) && (!(a !== "brand" && e.brand) || t.brand === e.brand) && (!(a !== "heatNoAndBatchNo" && e.heatNoAndBatchNo) || t.heatNoAndBatchNo === e.heatNoAndBatchNo) && (!(a !== "projectId" && e.projectId) || t.projectId === e.projectId) && (!(a !== "warehouseId" && e.warehouseId) || t.warehouseId === e.warehouseId) && e[k].findIndex((n) => n.id === t[a]) < 0 && e[k].push({ id: t[a], serialNumber: a === "projectId" && y(t.project) ? t.project.serialNumber : void 0, shortName: a === "projectId" && y(t.project) ? t.project.shortName : void 0, name: a === "projectId" ? y(t.project) ? t.project.name : "-" : a === "warehouseId" ? y(t.warehouse) ? t.warehouse.name : "-" : t[a] });
        }), e[a] && !e[k].findIndex((t) => t.name === e[a]) < 0 && (e[a] = void 0), e[a] || (g = false);
      }
      if (g) {
        const o = h.value[e.classifyName].find((a) => a.specification === e.specification && a.thickness === e.thickness && a.width === e.width && a.length === e.length && a.brand === e.brand && a.heatNoAndBatchNo === e.heatNoAndBatchNo && a.projectId === e.projectId && a.warehouseId === e.warehouseId);
        y(o) ? ((l = I.value.steelPlateList) == null ? void 0 : l.findIndex((a) => a.materialId === o.id)) > -1 ? (Y.error("列表已添加该物料，请重新选择"), B(e)) : (e.quantity = o.quantity, e.mete = o.mete, e.materialId = o.id, e.factoryId = (c = o.factory) == null ? void 0 : c.id, e.operateQuantity = (o.quantity || 0) - (o.frozenQuantity || 0), e.operateMete = o.mete - (o.frozenMete || 0), e.maxQuantity = e.outboundUnitType === T.MEASURE.V ? e.operateQuantity : e.operateMete, e.outboundUnitPrecision = e.outboundUnitType === T.MEASURE.V ? e.measurePrecision : e.accountingPrecision, e.outboundUnit = e.outboundUnitType === T.MEASURE.V ? e.measureUnit : e.accountingUnit, e.diffQuantity = void 0, e.realTime = (/* @__PURE__ */ new Date()).getTime()) : B(e);
      } else B(e);
    }
  }
  function J(e, u) {
    I.value.steelPlateList.splice(u, 1);
  }
  function K() {
    if (b(I.value.steelPlateList)) return true;
    const { validResult: e, dealList: u } = $(I.value.steelPlateList);
    return I.value.steelPlateList = u, e;
  }
  return L({ addRow: F, rowWatch: v, validate: K }), (e, u) => {
    const l = Z, c = P("common-select"), g = P("common-input-number"), o = w, a = P("common-button"), k = P("common-table");
    return i(), r(k, G({ "cell-class-name": s(q), data: s(I).steelPlateList, "show-empty-symbol": false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: p(() => [d(l, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), d(l, { align: "center", fixed: "left", label: "名称", prop: "classifyName", "show-overflow-tooltip": "", sortable: "", width: "120" }, { default: p(({ row: t }) => [t.isImport ? (i(), m("span", pe, f(t.classifyName), 1)) : (i(), r(c, { key: 1, modelValue: t.classifyId, "onUpdate:modelValue": (n) => t.classifyId = n, options: E.value, dataStructure: { key: "id", label: "name", value: "id" }, filterable: "", class: "input-underline", clearable: "", type: "other", placeholder: "可选择物料名称", style: { width: "200px" }, onChange: (n) => z(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"]))]), _: 1 }), d(l, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "", width: "100px" }, { default: p(({ row: t }) => [t.isImport ? (i(), m("span", me, f(t.specification), 1)) : (i(), r(c, { key: 1, modelValue: t.specification, "onUpdate:modelValue": (n) => t.specification = n, options: t.specificationOptions, dataStructure: { key: "name", label: "name", value: "name" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择规格", disabled: !t.classifyId || s(b)(t.specificationOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))]), _: 1 }), d(l, { label: `厚 (${s(_).thickness.unit})`, align: "center", prop: "thickness", sortable: "", width: "100px" }, { default: p(({ row: t }) => [t.isImport ? (i(), m("span", fe, f(t.thickness), 1)) : (i(), r(c, { key: 1, modelValue: t.thickness, "onUpdate:modelValue": (n) => t.thickness = n, options: t.thicknessOptions || [], dataStructure: { key: "name", label: "name", value: "name" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择厚", disabled: !t.classifyId || s(b)(t.thicknessOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))]), _: 1 }, 8, ["label"]), d(l, { label: `宽 (${s(_).width.unit})`, align: "center", prop: "width", width: "135px" }, { default: p(({ row: t }) => [t.isImport ? (i(), m("span", he, f(t.width), 1)) : (i(), r(c, { key: 1, modelValue: t.width, "onUpdate:modelValue": (n) => t.width = n, options: t.widthOptions || [], dataStructure: { key: "name", label: "name", value: "name" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择宽", disabled: !t.classifyId || s(b)(t.widthOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))]), _: 1 }, 8, ["label"]), d(l, { label: `长 (${s(_).length.unit})`, align: "center", prop: "length", width: "135px" }, { default: p(({ row: t }) => [t.isImport ? (i(), m("span", re, f(t.length), 1)) : (i(), r(c, { key: 1, modelValue: t.length, "onUpdate:modelValue": (n) => t.length = n, options: t.lengthOptions || [], dataStructure: { key: "name", label: "name", value: "name" }, class: "input-underline", clearable: "", type: "other", filterable: "", placeholder: "可选择长", disabled: !t.classifyId || s(b)(t.lengthOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))]), _: 1 }, 8, ["label"]), d(l, { align: "center", label: "品牌", "min-width": "100px", prop: "brand" }, { default: p(({ row: t }) => [t.isImport ? (i(), m("span", ye, f(t.brand), 1)) : (i(), r(c, { key: 1, modelValue: t.brand, "onUpdate:modelValue": (n) => t.brand = n, options: t.brandOptions || [], dataStructure: { key: "name", label: "name", value: "name" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择品牌", disabled: !t.classifyId || s(b)(t.brandOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))]), _: 1 }), d(l, { align: "center", label: "炉批号", "min-width": "150px", prop: "heatNoAndBatchNo" }, { default: p(({ row: t }) => [t.isImport ? (i(), m("span", be, f(t.heatNoAndBatchNo), 1)) : (i(), r(c, { key: 1, modelValue: t.heatNoAndBatchNo, "onUpdate:modelValue": (n) => t.heatNoAndBatchNo = n, options: t.heatNoAndBatchNoOptions || [], dataStructure: { key: "name", label: "name", value: "name" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择炉批号", disabled: !t.classifyId || s(b)(t.heatNoAndBatchNoOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))]), _: 1 }), d(l, { align: "center", label: "项目", "min-width": "100px", prop: "projectId" }, { default: p(({ row: t }) => {
      var n;
      return [t.isImport ? (i(), m("span", Ie, f(((n = t.project) == null ? void 0 : n.name) || "-"), 1)) : (i(), r(c, { key: 1, modelValue: t.projectId, "onUpdate:modelValue": (j) => t.projectId = j, options: t.projectIdOptions || [], dataStructure: { key: "id", label: "name", value: "id" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择项目", disabled: !t.classifyId || s(b)(t.projectIdOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))];
    }), _: 1 }), d(l, { align: "center", label: "仓库", "min-width": "150px", prop: "warehouseId" }, { default: p(({ row: t }) => {
      var n;
      return [t.isImport ? (i(), m("span", _e, f(((n = t.warehouse) == null ? void 0 : n.name) || "-"), 1)) : (i(), r(c, { key: 1, modelValue: t.warehouseId, "onUpdate:modelValue": (j) => t.warehouseId = j, options: t.warehouseIdOptions || [], dataStructure: { key: "id", label: "name", value: "id" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择仓库", disabled: !t.classifyId || s(b)(t.warehouseIdOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))];
    }), _: 1 }), d(l, { label: `现存数量 (${s(_).measure.unit})`, align: "center", prop: "quantity", width: "135px" }, { default: p(({ row: t }) => [s(y)(t.operateQuantity) ? (i(), m(A, { key: 0 }, [x("span", ge, f(t.operateQuantity), 1), u[0] || (u[0] = C(" / "))], 64)) : N("", true), x("span", null, f(t.quantity), 1)]), _: 1 }, 8, ["label"]), d(l, { key: "mete", label: `现存重量 (${s(_).weight.unit})`, align: "center", prop: "mete", width: "135px" }, { default: p(({ row: t }) => [s(y)(t.operateMete) ? (i(), m(A, { key: 0 }, [x("span", ke, f(t.operateMete.toFixed(s(_).weight.precision)), 1), u[1] || (u[1] = C(" / "))], 64)) : N("", true), x("span", null, f(t.mete ? t.mete.toFixed(s(_).weight.precision) : "-"), 1)]), _: 1 }, 8, ["label"]), d(l, { label: "盘亏数量", align: "center", prop: "diffQuantity", width: "135px" }, { default: p(({ row: t }) => [t.maxQuantity ? (i(), m("span", Ne, [d(g, { modelValue: t.diffQuantity, "onUpdate:modelValue": (n) => t.diffQuantity = n, controls: false, max: t.maxQuantity, min: 1, precision: t.outboundUnitPrecision, step: 1, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"]), x("span", Ve, f(t.outboundUnit), 1)])) : N("", true)]), _: 1 }), s(I).deficitType === s(Q).PROJECT.V ? (i(), r(l, { key: "deficitProjectId", label: "归属项目", align: "center", prop: "deficitProjectId", "min-width": "150px" }, { default: p(({ row: t }) => [t.maxQuantity ? (i(), m("span", xe, [d(s(ne), { modelValue: t.deficitProjectId, "onUpdate:modelValue": (n) => t.deficitProjectId = n, class: "input-underline", style: { width: "100%" }, filterable: "", clearable: "", placeholder: "可选择项目" }, null, 8, ["modelValue", "onUpdate:modelValue"])])) : N("", true)]), _: 1 })) : N("", true), d(le, { label: "实际盘亏时间" }), d(l, { key: "remark", prop: "remark", align: "center", label: "备注", "min-width": "150px" }, { default: p(({ row: t }) => [t.maxQuantity ? (i(), m("span", Ue, [d(o, { modelValue: t.remark, "onUpdate:modelValue": (n) => t.remark = n, placeholder: "备注", maxlength: "200", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])])) : N("", true)]), _: 1 }), d(l, { align: "center", fixed: "right", label: "操作", width: "80" }, { default: p(({ row: t, $index: n }) => [d(a, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (j) => J(t.sn, n) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} };
export {
  Te as default
};
