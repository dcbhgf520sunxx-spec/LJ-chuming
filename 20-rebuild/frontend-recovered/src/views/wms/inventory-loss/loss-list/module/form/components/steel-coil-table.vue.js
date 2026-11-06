import { inject as O } from "vue";
import { computed as W } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as l } from "vue";
import { createBlock as r } from "vue";
import { withCtx as p } from "vue";
import { createVNode as u } from "vue";
import { createElementBlock as m } from "vue";
import { toDisplayString as f } from "vue";
import { unref as s } from "vue";
import { Fragment as A } from "vue";
import { createElementVNode as x } from "vue";
import { createTextVNode as Q } from "vue";
import { createCommentVNode as V } from "vue";
import { mergeProps as G } from "vue";
import { reactive as H } from "vue";
import { watch as X } from "vue";
import { ElMessage as Y } from "element-plus";
import { ElTableColumn as Z } from "element-plus";
import { ElInput as w } from "element-plus";
import { xC as ee, am as te, sQ as ae, i as y, b as I, hg as T, fv as ne, xD as ie, aw as le, aI as se, wL as de, xE as ce, cO as ue, jl as oe, cS as v } from "../../../../../../../shared/runtime.js";
const pe = { key: 0 }, me = { key: 0 }, fe = { key: 0 }, he = { key: 0 }, re = { key: 0 }, ye = { key: 0 }, be = { key: 0 }, Ie = { key: 0 }, _e = { class: "color-green" }, Ne = { class: "color-green" }, ke = { key: 0, class: "flex-rbc" }, Ve = { style: { flex: "none", "margin-left": "10px", "text-align": "left" } }, ge = { key: 0, class: "flex-rbc" }, xe = { key: 0, class: "flex-rbc" }, Oe = { __name: "steel-coil-table", setup(Ue, { expose: L }) {
  const { realTimeValidate: M } = ee(), U = te.STEEL_COIL.V, S = O("classifyNameObj"), { baseUnit: N } = ae(U), b = O("form"), h = O("classifyNameInventory"), E = W(() => y(S.value) ? S.value[U] || [] : []), R = { deficitProjectId: [{ validator: (e, d) => !(b.value.deficitType === T.PROJECT.V && !e && d.diffQuantity), message: "请选择项目", trigger: "change" }], realTime: [{ validator: M, message: "请选择实际盘亏时间", trigger: "change" }] }, { tableValidate: $, wrongCellMask: q } = le({ rules: R, errorMsg: "请修正【钢卷清单】中标红的信息" });
  function F() {
    const e = H({ uid: se(), specification: void 0, thickness: void 0, width: void 0, classifyId: void 0, brand: void 0, heatNoAndBatchNo: void 0, projectId: void 0, warehouseId: void 0, quantity: void 0, mete: void 0, classifyNameInventory: [], basicClass: U });
    P(e), b.value.steelCoilList.push(e);
  }
  const g = ["specification", "thickness", "width", "brand", "heatNoAndBatchNo", "projectId", "warehouseId"];
  async function z(e) {
    var d;
    if (e.classifyId && (e.classifyName = (d = E.value.find((i) => i.id === e.classifyId)) == null ? void 0 : d.name, await de([e.classifyId]), y(e.classifyName))) {
      if (I(h.value[e.classifyName])) {
        h.value[e.classifyName] = [];
        const i = await ce({ basicClass: U, classifyName: e.classifyName, boolPartyA: false }) || [];
        await ue(i), await oe(i, { toSmallest: false, toNum: true }), i == null || i.forEach((o) => {
          var _, c;
          o.projectId = ((_ = o.project) == null ? void 0 : _.id) || "-", o.warehouseId = ((c = o.warehouse) == null ? void 0 : c.id) || "-";
          for (let a = 0; a < g.length; a++) o[g[a]] = o[g[a]] || "-";
        }), h.value[e.classifyName] = i;
      }
      e.measureUnit = h.value[e.classifyName][0].measureUnit, e.accountingUnit = h.value[e.classifyName][0].accountingUnit, e.accountingPrecision = h.value[e.classifyName][0].accountingPrecision, e.measurePrecision = h.value[e.classifyName][0].measurePrecision, e.outboundUnitType = h.value[e.classifyName][0].outboundUnitType;
    }
  }
  function P(e) {
    X([() => e == null ? void 0 : e.specification, () => e == null ? void 0 : e.thickness, () => e == null ? void 0 : e.width, () => e == null ? void 0 : e.brand, () => e == null ? void 0 : e.heatNoAndBatchNo, () => e == null ? void 0 : e.projectId, () => e == null ? void 0 : e.warehouseId, () => {
      var d;
      return (d = h.value) == null ? void 0 : d[[e == null ? void 0 : e.classifyName]];
    }], () => {
      D(e);
    }, { deep: true });
  }
  function B(e) {
    e.quantity = void 0, e.mete = void 0, e.materialId = void 0, e.factoryId = void 0, e.operateQuantity = void 0, e.operateMete = void 0, e.maxQuantity = void 0, e.outboundUnitPrecision = void 0, e.outboundUnit = void 0, e.diffQuantity = void 0;
  }
  function D(e) {
    var d, i, o;
    if (e.classifyName && y(h.value[e.classifyName])) {
      let _ = true;
      for (let c = 0; c < g.length; c++) {
        const a = g[c], k = a + "Options";
        e[k] = [], (d = h.value[e.classifyName]) == null || d.forEach((t) => {
          (!(a !== "specification" && e.specification) || t.specification === e.specification) && (!(a !== "thickness" && e.thickness) || t.thickness === e.thickness) && (!(a !== "width" && e.width) || t.width === e.width) && (!(a !== "brand" && e.brand) || t.brand === e.brand) && (!(a !== "heatNoAndBatchNo" && e.heatNoAndBatchNo) || t.heatNoAndBatchNo === e.heatNoAndBatchNo) && (!(a !== "projectId" && e.projectId) || t.projectId === e.projectId) && (!(a !== "warehouseId" && e.warehouseId) || t.warehouseId === e.warehouseId) && e[k].findIndex((n) => n.id === t[a]) < 0 && e[k].push({ id: t[a], serialNumber: a === "projectId" && y(t.project) ? t.project.serialNumber : void 0, shortName: a === "projectId" && y(t.project) ? t.project.shortName : void 0, name: a === "projectId" ? y(t.project) ? t.project.name : "-" : a === "warehouseId" ? y(t.warehouse) ? t.warehouse.name : "-" : t[a] });
        }), e[a] && !e[k].findIndex((t) => t.name === e[a]) < 0 && (e[a] = void 0), e[a] || (_ = false);
      }
      if (_) {
        const c = h.value[e.classifyName].find((a) => a.specification === e.specification && a.thickness === e.thickness && a.width === e.width && a.brand === e.brand && a.heatNoAndBatchNo === e.heatNoAndBatchNo && a.projectId === e.projectId && a.warehouseId === e.warehouseId);
        y(c) ? ((i = b.value.steelCoilList) == null ? void 0 : i.findIndex((a) => a.materialId === c.id)) > -1 ? (Y.error("列表已添加该物料，请重新选择"), B(e)) : (e.quantity = c.quantity, e.mete = c.mete, e.materialId = c.id, e.factoryId = (o = c.factory) == null ? void 0 : o.id, e.operateQuantity = (c.quantity || 0) - (c.frozenQuantity || 0), e.operateMete = c.mete - (c.frozenMete || 0), e.maxQuantity = e.outboundUnitType === v.MEASURE.V ? e.operateQuantity : e.operateMete, e.outboundUnitPrecision = e.outboundUnitType === v.MEASURE.V ? e.measurePrecision : e.accountingPrecision, e.outboundUnit = e.outboundUnitType === v.MEASURE.V ? e.measureUnit : e.accountingUnit, e.diffQuantity = void 0) : B(e);
      } else B(e);
    }
  }
  function J(e, d) {
    b.value.steelCoilList.splice(d, 1);
  }
  function K() {
    if (I(b.value.steelCoilList)) return true;
    const { validResult: e, dealList: d } = $(b.value.steelCoilList);
    return b.value.steelCoilList = d, e;
  }
  return L({ addRow: F, rowWatch: P, validate: K }), (e, d) => {
    const i = Z, o = C("common-select"), _ = C("common-input-number"), c = w, a = C("common-button"), k = C("common-table");
    return l(), r(k, G({ "cell-class-name": s(q), data: s(b).steelCoilList, "show-empty-symbol": false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: p(() => [u(i, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), u(i, { align: "center", fixed: "left", label: "名称", prop: "classifyName", "show-overflow-tooltip": "", sortable: "", width: "120" }, { default: p(({ row: t }) => [t.isImport ? (l(), m("span", pe, f(t.classifyName), 1)) : (l(), r(o, { key: 1, modelValue: t.classifyId, "onUpdate:modelValue": (n) => t.classifyId = n, options: E.value, dataStructure: { key: "id", label: "name", value: "id" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择物料名称", style: { width: "200px" }, onChange: (n) => z(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"]))]), _: 1 }), u(i, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "", width: "100px" }, { default: p(({ row: t }) => [t.isImport ? (l(), m("span", me, f(t.specification), 1)) : (l(), r(o, { key: 1, modelValue: t.specification, "onUpdate:modelValue": (n) => t.specification = n, options: t.specificationOptions, dataStructure: { key: "name", label: "name", value: "name" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择规格", disabled: !t.classifyId || s(I)(t.specificationOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))]), _: 1 }), u(i, { label: `厚 (${s(N).thickness.unit})`, align: "center", prop: "thickness", sortable: "", width: "100px" }, { default: p(({ row: t }) => [t.isImport ? (l(), m("span", fe, f(t.thickness), 1)) : (l(), r(o, { key: 1, modelValue: t.thickness, "onUpdate:modelValue": (n) => t.thickness = n, options: t.thicknessOptions || [], dataStructure: { key: "name", label: "name", value: "name" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择厚", disabled: !t.classifyId || s(I)(t.thicknessOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))]), _: 1 }, 8, ["label"]), u(i, { label: `宽 (${s(N).width.unit})`, align: "center", prop: "width", width: "135px" }, { default: p(({ row: t }) => [t.isImport ? (l(), m("span", he, f(t.width), 1)) : (l(), r(o, { key: 1, modelValue: t.width, "onUpdate:modelValue": (n) => t.width = n, options: t.widthOptions || [], dataStructure: { key: "name", label: "name", value: "name" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择宽", disabled: !t.classifyId || s(I)(t.widthOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))]), _: 1 }, 8, ["label"]), u(i, { align: "center", label: "品牌", "min-width": "100px", prop: "brand" }, { default: p(({ row: t }) => [t.isImport ? (l(), m("span", re, f(t.brand), 1)) : (l(), r(o, { key: 1, modelValue: t.brand, "onUpdate:modelValue": (n) => t.brand = n, options: t.brandOptions || [], dataStructure: { key: "name", label: "name", value: "name" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择品牌", disabled: !t.classifyId || s(I)(t.brandOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))]), _: 1 }), u(i, { align: "center", label: "卷号", "min-width": "150px", prop: "heatNoAndBatchNo" }, { default: p(({ row: t }) => [t.isImport ? (l(), m("span", ye, f(t.heatNoAndBatchNo), 1)) : (l(), r(o, { key: 1, modelValue: t.heatNoAndBatchNo, "onUpdate:modelValue": (n) => t.heatNoAndBatchNo = n, options: t.heatNoAndBatchNoOptions || [], dataStructure: { key: "name", label: "name", value: "name" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择炉批号", disabled: !t.classifyId || s(I)(t.heatNoAndBatchNoOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))]), _: 1 }), u(i, { align: "center", label: "项目", "min-width": "100px", prop: "projectId" }, { default: p(({ row: t }) => {
      var n;
      return [t.isImport ? (l(), m("span", be, f(((n = t.project) == null ? void 0 : n.name) || "-"), 1)) : (l(), r(o, { key: 1, modelValue: t.projectId, "onUpdate:modelValue": (j) => t.projectId = j, options: t.projectIdOptions || [], dataStructure: { key: "id", label: "name", value: "id" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择项目", disabled: !t.classifyId || s(I)(t.projectIdOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))];
    }), _: 1 }), u(i, { align: "center", label: "仓库", "min-width": "150px", prop: "warehouseId" }, { default: p(({ row: t }) => {
      var n;
      return [t.isImport ? (l(), m("span", Ie, f(((n = t.warehouse) == null ? void 0 : n.name) || "-"), 1)) : (l(), r(o, { key: 1, modelValue: t.warehouseId, "onUpdate:modelValue": (j) => t.warehouseId = j, options: t.warehouseIdOptions || [], dataStructure: { key: "id", label: "name", value: "id" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择仓库", disabled: !t.classifyId || s(I)(t.warehouseIdOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))];
    }), _: 1 }), u(i, { label: `现存数量 (${s(N).measure.unit})`, align: "center", prop: "quantity", width: "135px" }, { default: p(({ row: t }) => [s(y)(t.operateQuantity) ? (l(), m(A, { key: 0 }, [x("span", _e, f(t.operateQuantity), 1), d[0] || (d[0] = Q(" / "))], 64)) : V("", true), x("span", null, f(t.quantity), 1)]), _: 1 }, 8, ["label"]), u(i, { key: "mete", label: `现存重量 (${s(N).weight.unit})`, align: "center", prop: "mete", width: "135px" }, { default: p(({ row: t }) => [s(y)(t.operateMete) ? (l(), m(A, { key: 0 }, [x("span", Ne, f(t.operateMete.toFixed(s(N).weight.precision)), 1), d[1] || (d[1] = Q(" / "))], 64)) : V("", true), x("span", null, f(t.mete ? t.mete.toFixed(s(N).weight.precision) : "-"), 1)]), _: 1 }, 8, ["label"]), u(i, { label: "盘亏数量", align: "center", prop: "diffQuantity", width: "135px" }, { default: p(({ row: t }) => [t.maxQuantity ? (l(), m("span", ke, [u(_, { modelValue: t.diffQuantity, "onUpdate:modelValue": (n) => t.diffQuantity = n, controls: false, max: t.maxQuantity, min: 1, precision: t.outboundUnitPrecision, step: 1, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"]), x("span", Ve, f(t.outboundUnit), 1)])) : V("", true)]), _: 1 }), s(b).deficitType === s(T).PROJECT.V ? (l(), r(i, { key: "deficitProjectId", label: "归属项目", align: "center", prop: "deficitProjectId", "min-width": "150px" }, { default: p(({ row: t }) => [t.maxQuantity ? (l(), m("span", ge, [u(s(ne), { modelValue: t.deficitProjectId, "onUpdate:modelValue": (n) => t.deficitProjectId = n, class: "input-underline", style: { width: "100%" }, filterable: "", clearable: "", placeholder: "可选择项目" }, null, 8, ["modelValue", "onUpdate:modelValue"])])) : V("", true)]), _: 1 })) : V("", true), u(ie, { label: "实际盘亏时间" }), u(i, { key: "remark", prop: "remark", align: "center", label: "备注", "min-width": "150px" }, { default: p(({ row: t }) => [t.maxQuantity ? (l(), m("span", xe, [u(c, { modelValue: t.remark, "onUpdate:modelValue": (n) => t.remark = n, placeholder: "备注", maxlength: "200", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])])) : V("", true)]), _: 1 }), u(i, { align: "center", fixed: "right", label: "操作", width: "80" }, { default: p(({ row: t, $index: n }) => [u(a, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (j) => J(t.sn, n) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} };
export {
  Oe as default
};
