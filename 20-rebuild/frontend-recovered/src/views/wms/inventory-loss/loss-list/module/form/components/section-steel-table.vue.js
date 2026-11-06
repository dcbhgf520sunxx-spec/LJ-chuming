import { inject as v } from "vue";
import { computed as W } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as i } from "vue";
import { createBlock as b } from "vue";
import { withCtx as p } from "vue";
import { createVNode as c } from "vue";
import { createElementBlock as f } from "vue";
import { toDisplayString as h } from "vue";
import { unref as u } from "vue";
import { Fragment as T } from "vue";
import { createElementVNode as k } from "vue";
import { createTextVNode as A } from "vue";
import { createCommentVNode as N } from "vue";
import { mergeProps as G } from "vue";
import { reactive as H } from "vue";
import { watch as X } from "vue";
import { ElMessage as Y } from "element-plus";
import { ElTableColumn as Z } from "element-plus";
import { ElInput as w } from "element-plus";
import { xC as ee, am as te, sQ as ae, i as r, b as I, hg as Q, fv as ne, xD as le, aw as ie, aI as se, wL as de, xE as ce, cO as ue, jl as oe, cS as E } from "../../../../../../../shared/runtime.js";
const pe = { key: 0 }, me = { key: 0 }, fe = { key: 0 }, he = { key: 0 }, re = { key: 0 }, ye = { key: 0 }, be = { key: 0 }, Ie = { class: "color-green" }, ge = { class: "color-green" }, _e = { key: 0, class: "flex-rbc" }, Ne = { style: { flex: "none", "margin-left": "10px", "text-align": "left" } }, Ve = { key: 0, class: "flex-rbc" }, xe = { key: 0, class: "flex-rbc" }, Be = { __name: "section-steel-table", setup(ke, { expose: M }) {
  const { realTimeValidate: L } = ee(), U = te.SECTION_STEEL.V, C = v("classifyNameObj"), { baseUnit: V } = ae(U), y = v("form"), m = v("classifyNameInventory"), O = W(() => r(C.value) ? C.value[U] || [] : []), R = { deficitProjectId: [{ validator: (e, s) => !(y.value.deficitType === Q.PROJECT.V && !e && s.diffQuantity), message: "请选择项目", trigger: "change" }], realTime: [{ validator: L, message: "请选择实际盘亏时间", trigger: "change" }] }, { tableValidate: q, wrongCellMask: $ } = ie({ rules: R, errorMsg: "请修正【型材清单】中标红的信息" });
  function F() {
    const e = H({ uid: se(), specification: void 0, thickness: void 0, width: void 0, classifyId: void 0, length: void 0, brand: void 0, heatNoAndBatchNo: void 0, projectId: void 0, warehouseId: void 0, quantity: void 0, mete: void 0, classifyNameInventory: [], basicClass: U });
    P(e), y.value.sectionSteelList.push(e);
  }
  const x = ["specification", "length", "brand", "heatNoAndBatchNo", "projectId", "warehouseId"];
  async function z(e) {
    var s;
    if (e.classifyId && (e.classifyName = (s = O.value.find((n) => n.id === e.classifyId)) == null ? void 0 : s.name, await de([e.classifyId]), r(e.classifyName))) {
      if (I(m.value[e.classifyName])) {
        m.value[e.classifyName] = [];
        const n = await ce({ basicClass: U, classifyName: e.classifyName, boolPartyA: false }) || [];
        await ue(n), await oe(n, { toSmallest: false, toNum: true }), n == null || n.forEach((o) => {
          var g, d;
          o.projectId = ((g = o.project) == null ? void 0 : g.id) || "-", o.warehouseId = ((d = o.warehouse) == null ? void 0 : d.id) || "-";
          for (let a = 0; a < x.length; a++) o[x[a]] = o[x[a]] || "-";
        }), m.value[e.classifyName] = n;
      }
      e.measureUnit = m.value[e.classifyName][0].measureUnit, e.accountingUnit = m.value[e.classifyName][0].accountingUnit, e.accountingPrecision = m.value[e.classifyName][0].accountingPrecision, e.measurePrecision = m.value[e.classifyName][0].measurePrecision, e.outboundUnitType = m.value[e.classifyName][0].outboundUnitType;
    }
  }
  function P(e) {
    X([() => e == null ? void 0 : e.specification, () => e == null ? void 0 : e.thickness, () => e == null ? void 0 : e.width, () => e == null ? void 0 : e.length, () => e == null ? void 0 : e.brand, () => e == null ? void 0 : e.heatNoAndBatchNo, () => e == null ? void 0 : e.projectId, () => e == null ? void 0 : e.warehouseId, () => {
      var s;
      return (s = m.value) == null ? void 0 : s[[e == null ? void 0 : e.classifyName]];
    }], () => {
      D(e);
    }, { deep: true });
  }
  function B(e) {
    e.quantity = void 0, e.mete = void 0, e.materialId = void 0, e.factoryId = void 0, e.operateQuantity = void 0, e.operateMete = void 0, e.maxQuantity = void 0, e.outboundUnitPrecision = void 0, e.outboundUnit = void 0, e.diffQuantity = void 0;
  }
  function D(e) {
    var s, n, o;
    if (e.classifyName && r(m.value[e.classifyName])) {
      let g = true;
      for (let d = 0; d < x.length; d++) {
        const a = x[d], _ = a + "Options";
        e[_] = [], (s = m.value[e.classifyName]) == null || s.forEach((t) => {
          (!(a !== "specification" && e.specification) || t.specification === e.specification) && (!(a !== "length" && e.length) || t.length === e.length) && (!(a !== "brand" && e.brand) || t.brand === e.brand) && (!(a !== "heatNoAndBatchNo" && e.heatNoAndBatchNo) || t.heatNoAndBatchNo === e.heatNoAndBatchNo) && (!(a !== "projectId" && e.projectId) || t.projectId === e.projectId) && (!(a !== "warehouseId" && e.warehouseId) || t.warehouseId === e.warehouseId) && e[_].findIndex((l) => l.id === t[a]) < 0 && e[_].push({ id: t[a], serialNumber: a === "projectId" && r(t.project) ? t.project.serialNumber : void 0, shortName: a === "projectId" && r(t.project) ? t.project.shortName : void 0, name: a === "projectId" ? r(t.project) ? t.project.name : "-" : a === "warehouseId" ? r(t.warehouse) ? t.warehouse.name : "-" : t[a] });
        }), e[a] && !e[_].findIndex((t) => t.name === e[a]) < 0 && (e[a] = void 0), e[a] || (g = false);
      }
      if (g) {
        const d = m.value[e.classifyName].find((a) => a.specification === e.specification && a.length === e.length && a.brand === e.brand && a.heatNoAndBatchNo === e.heatNoAndBatchNo && a.projectId === e.projectId && a.warehouseId === e.warehouseId);
        r(d) ? ((n = y.value.sectionSteelList) == null ? void 0 : n.findIndex((a) => a.materialId === d.id)) > -1 ? (Y.error("列表已添加该物料，请重新选择"), B(e)) : (e.quantity = d.quantity, e.mete = d.mete, e.materialId = d.id, e.factoryId = (o = d.factory) == null ? void 0 : o.id, e.operateQuantity = (d.quantity || 0) - (d.frozenQuantity || 0), e.operateMete = d.mete - (d.frozenMete || 0), e.maxQuantity = e.outboundUnitType === E.MEASURE.V ? e.operateQuantity : e.operateMete, e.outboundUnitPrecision = e.outboundUnitType === E.MEASURE.V ? e.measurePrecision : e.accountingPrecision, e.outboundUnit = e.outboundUnitType === E.MEASURE.V ? e.measureUnit : e.accountingUnit, e.diffQuantity = void 0) : B(e);
      } else B(e);
    }
  }
  function J(e, s) {
    y.value.sectionSteelList.splice(s, 1);
  }
  function K() {
    if (I(y.value.sectionSteelList)) return true;
    const { validResult: e, dealList: s } = q(y.value.sectionSteelList);
    return y.value.sectionSteelList = s, e;
  }
  return M({ addRow: F, rowWatch: P, validate: K }), (e, s) => {
    const n = Z, o = S("common-select"), g = S("common-input-number"), d = w, a = S("common-button"), _ = S("common-table");
    return i(), b(_, G({ "cell-class-name": u($), data: u(y).sectionSteelList, "show-empty-symbol": false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: p(() => [c(n, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), c(n, { align: "center", fixed: "left", label: "名称", prop: "classifyName", "show-overflow-tooltip": "", sortable: "", width: "120" }, { default: p(({ row: t }) => [t.isImport ? (i(), f("span", pe, h(t.classifyName), 1)) : (i(), b(o, { key: 1, modelValue: t.classifyId, "onUpdate:modelValue": (l) => t.classifyId = l, options: O.value, dataStructure: { key: "id", label: "name", value: "id" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择物料名称", style: { width: "200px" }, onChange: (l) => z(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"]))]), _: 1 }), c(n, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "", width: "100px" }, { default: p(({ row: t }) => [t.isImport ? (i(), f("span", me, h(t.specification), 1)) : (i(), b(o, { key: 1, modelValue: t.specification, "onUpdate:modelValue": (l) => t.specification = l, options: t.specificationOptions, dataStructure: { key: "name", label: "name", value: "name" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择规格", disabled: !t.classifyId || u(I)(t.specificationOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))]), _: 1 }), c(n, { label: `定尺长 (${u(V).length.unit})`, align: "center", prop: "length", width: "135px" }, { default: p(({ row: t }) => [t.isImport ? (i(), f("span", fe, h(t.length), 1)) : (i(), b(o, { key: 1, modelValue: t.length, "onUpdate:modelValue": (l) => t.length = l, options: t.lengthOptions || [], dataStructure: { key: "name", label: "name", value: "name" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择长", disabled: !t.classifyId || u(I)(t.lengthOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))]), _: 1 }, 8, ["label"]), c(n, { align: "center", label: "品牌", "min-width": "100px", prop: "brand" }, { default: p(({ row: t }) => [t.isImport ? (i(), f("span", he, h(t.brand), 1)) : (i(), b(o, { key: 1, modelValue: t.brand, "onUpdate:modelValue": (l) => t.brand = l, options: t.brandOptions || [], dataStructure: { key: "name", label: "name", value: "name" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择品牌", disabled: !t.classifyId || u(I)(t.brandOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))]), _: 1 }), c(n, { align: "center", label: "炉批号", "min-width": "150px", prop: "heatNoAndBatchNo" }, { default: p(({ row: t }) => [t.isImport ? (i(), f("span", re, h(t.heatNoAndBatchNo), 1)) : (i(), b(o, { key: 1, modelValue: t.heatNoAndBatchNo, "onUpdate:modelValue": (l) => t.heatNoAndBatchNo = l, options: t.heatNoAndBatchNoOptions || [], dataStructure: { key: "name", label: "name", value: "name" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择炉批号", disabled: !t.classifyId || u(I)(t.heatNoAndBatchNoOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))]), _: 1 }), c(n, { align: "center", label: "项目", "min-width": "100px", prop: "projectId" }, { default: p(({ row: t }) => {
      var l;
      return [t.isImport ? (i(), f("span", ye, h(((l = t.project) == null ? void 0 : l.name) || "-"), 1)) : (i(), b(o, { key: 1, modelValue: t.projectId, "onUpdate:modelValue": (j) => t.projectId = j, options: t.projectIdOptions || [], dataStructure: { key: "id", label: "name", value: "id" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择项目", disabled: !t.classifyId || u(I)(t.projectIdOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))];
    }), _: 1 }), c(n, { align: "center", label: "仓库", "min-width": "150px", prop: "warehouseId" }, { default: p(({ row: t }) => {
      var l;
      return [t.isImport ? (i(), f("span", be, h(((l = t.warehouse) == null ? void 0 : l.name) || "-"), 1)) : (i(), b(o, { key: 1, modelValue: t.warehouseId, "onUpdate:modelValue": (j) => t.warehouseId = j, options: t.warehouseIdOptions || [], dataStructure: { key: "id", label: "name", value: "id" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择仓库", disabled: !t.classifyId || u(I)(t.warehouseIdOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))];
    }), _: 1 }), c(n, { label: `现存数量 (${u(V).measure.unit})`, align: "center", prop: "quantity", width: "135px" }, { default: p(({ row: t }) => [u(r)(t.operateQuantity) ? (i(), f(T, { key: 0 }, [k("span", Ie, h(t.operateQuantity), 1), s[0] || (s[0] = A(" / "))], 64)) : N("", true), k("span", null, h(t.quantity), 1)]), _: 1 }, 8, ["label"]), c(n, { key: "mete", label: `现存重量 (${u(V).weight.unit})`, align: "center", prop: "mete", width: "135px" }, { default: p(({ row: t }) => [u(r)(t.operateMete) ? (i(), f(T, { key: 0 }, [k("span", ge, h(t.operateMete.toFixed(u(V).weight.precision)), 1), s[1] || (s[1] = A(" / "))], 64)) : N("", true), k("span", null, h(t.mete ? t.mete.toFixed(u(V).weight.precision) : "-"), 1)]), _: 1 }, 8, ["label"]), c(n, { label: "盘亏数量", align: "center", prop: "diffQuantity", width: "135px" }, { default: p(({ row: t }) => [t.maxQuantity ? (i(), f("span", _e, [c(g, { modelValue: t.diffQuantity, "onUpdate:modelValue": (l) => t.diffQuantity = l, controls: false, max: t.maxQuantity, min: 1, precision: t.outboundUnitPrecision, step: 1, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"]), k("span", Ne, h(t.outboundUnit), 1)])) : N("", true)]), _: 1 }), u(y).deficitType === u(Q).PROJECT.V ? (i(), b(n, { key: "deficitProjectId", label: "归属项目", align: "center", prop: "deficitProjectId", "min-width": "150px" }, { default: p(({ row: t }) => [t.maxQuantity ? (i(), f("span", Ve, [c(u(ne), { modelValue: t.deficitProjectId, "onUpdate:modelValue": (l) => t.deficitProjectId = l, class: "input-underline", style: { width: "100%" }, filterable: "", clearable: "", placeholder: "可选择项目" }, null, 8, ["modelValue", "onUpdate:modelValue"])])) : N("", true)]), _: 1 })) : N("", true), c(le, { label: "实际盘亏时间" }), c(n, { key: "remark", prop: "remark", align: "center", label: "备注", "min-width": "150px" }, { default: p(({ row: t }) => [t.maxQuantity ? (i(), f("span", xe, [c(d, { modelValue: t.remark, "onUpdate:modelValue": (l) => t.remark = l, placeholder: "备注", maxlength: "200", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])])) : N("", true)]), _: 1 }), c(n, { align: "center", fixed: "right", label: "操作", width: "80" }, { default: p(({ row: t, $index: l }) => [c(a, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (j) => J(t.sn, l) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} };
export {
  Be as default
};
