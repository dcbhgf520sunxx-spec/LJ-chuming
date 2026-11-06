import { inject as P } from "vue";
import { computed as H } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as i } from "vue";
import { createBlock as b } from "vue";
import { withCtx as u } from "vue";
import { createVNode as o } from "vue";
import { createElementBlock as m } from "vue";
import { toDisplayString as r } from "vue";
import { unref as f } from "vue";
import { Fragment as C } from "vue";
import { createElementVNode as k } from "vue";
import { createTextVNode as S } from "vue";
import { createCommentVNode as _ } from "vue";
import { mergeProps as K } from "vue";
import { reactive as W } from "vue";
import { watch as G } from "vue";
import { ElMessage as X } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElInput as Z } from "element-plus";
import { xC as w, am as ee, i as y, b as V, hg as R, fv as ae, xD as te, aw as ne, aI as le, wL as ie, xE as se, cO as de, jl as oe, cS as E } from "../../../../../../../shared/runtime.js";
const ce = { key: 0 }, ue = { key: 0 }, pe = { key: 0 }, me = { key: 0 }, fe = { key: 0 }, re = { key: 0 }, ye = { class: "color-green" }, he = { class: "color-green" }, be = { key: 0, class: "flex-rbc" }, Ie = { style: { flex: "none", "margin-left": "10px", "text-align": "left" } }, _e = { key: 0, class: "flex-rbc" }, Ve = { key: 0, class: "flex-rbc" }, je = { __name: "other-table", setup(ge, { expose: M }) {
  const { realTimeValidate: L } = w(), N = ee.OTHER.V, T = P("classifyNameObj"), h = P("form"), p = P("classifyNameInventory"), O = H(() => y(T.value) ? T.value[N] || [] : []), B = { deficitProjectId: [{ validator: (e, s) => !(h.value.deficitType === R.PROJECT.V && !e && s.diffQuantity), message: "请选择项目", trigger: "change" }], realTime: [{ validator: L, message: "请选择实际盘亏时间", trigger: "change" }] }, { tableValidate: q, wrongCellMask: z } = ne({ rules: B, errorMsg: "请修正【其它清单】中标红的信息" });
  function $() {
    const e = W({ uid: le(), specification: void 0, classifyId: void 0, brand: void 0, color: void 0, projectId: void 0, warehouseId: void 0, quantity: void 0, mete: void 0, classifyNameInventory: [], basicClass: N });
    Q(e), h.value.otherList.push(e);
  }
  const x = ["specification", "brand", "projectId", "color", "warehouseId"];
  async function A(e) {
    var s;
    if (e.classifyId && (e.classifyName = (s = O.value.find((n) => n.id === e.classifyId)) == null ? void 0 : s.name, await ie([e.classifyId]), y(e.classifyName))) {
      if (V(p.value[e.classifyName])) {
        p.value[e.classifyName] = [];
        const n = await se({ basicClass: N, classifyName: e.classifyName, boolPartyA: false }) || [];
        await de(n), await oe(n, { toSmallest: false, toNum: true }), n == null || n.forEach((c) => {
          var I, d;
          c.projectId = ((I = c.project) == null ? void 0 : I.id) || "-", c.warehouseId = ((d = c.warehouse) == null ? void 0 : d.id) || "-";
          for (let t = 0; t < x.length; t++) c[x[t]] = c[x[t]] || "-";
        }), p.value[e.classifyName] = n;
      }
      e.measureUnit = p.value[e.classifyName][0].measureUnit, e.accountingUnit = p.value[e.classifyName][0].accountingUnit, e.accountingPrecision = p.value[e.classifyName][0].accountingPrecision, e.measurePrecision = p.value[e.classifyName][0].measurePrecision, e.outboundUnitType = p.value[e.classifyName][0].outboundUnitType;
    }
  }
  function Q(e) {
    G([() => e == null ? void 0 : e.specification, () => e == null ? void 0 : e.brand, () => e == null ? void 0 : e.color, () => e == null ? void 0 : e.projectId, () => e == null ? void 0 : e.warehouseId, () => {
      var s;
      return (s = p.value) == null ? void 0 : s[[e == null ? void 0 : e.classifyName]];
    }], () => {
      D(e);
    }, { deep: true });
  }
  function v(e) {
    e.quantity = void 0, e.mete = void 0, e.materialId = void 0, e.factoryId = void 0, e.operateQuantity = void 0, e.operateMete = void 0, e.maxQuantity = void 0, e.outboundUnitPrecision = void 0, e.outboundUnit = void 0, e.diffQuantity = void 0;
  }
  function D(e) {
    var s, n, c;
    if (e.classifyName && y(p.value[e.classifyName])) {
      let I = true;
      for (let d = 0; d < x.length; d++) {
        const t = x[d], g = t + "Options";
        e[g] = [], (s = p.value[e.classifyName]) == null || s.forEach((a) => {
          (!(t !== "specification" && e.specification) || a.specification === e.specification) && (!(t !== "brand" && e.brand) || a.brand === e.brand) && (!(t !== "projectId" && e.projectId) || a.projectId === e.projectId) && (!(t !== "warehouseId" && e.warehouseId) || a.warehouseId === e.warehouseId) && e[g].findIndex((l) => l.id === a[t]) < 0 && e[g].push({ id: a[t], serialNumber: t === "projectId" && y(a.project) ? a.project.serialNumber : void 0, shortName: t === "projectId" && y(a.project) ? a.project.shortName : void 0, name: t === "projectId" ? y(a.project) ? a.project.name : "-" : t === "warehouseId" ? y(a.warehouse) ? a.warehouse.name : "-" : a[t] });
        }), e[t] && !e[g].findIndex((a) => a.name === e[t]) < 0 && (e[t] = void 0), e[t] || (I = false);
      }
      if (I) {
        const d = p.value[e.classifyName].find((t) => t.specification === e.specification && t.brand === e.brand && t.projectId === e.projectId && t.warehouseId === e.warehouseId);
        y(d) ? ((n = h.value.otherList) == null ? void 0 : n.findIndex((t) => t.materialId === d.id)) > -1 ? (X.error("列表已添加该物料，请重新选择"), v(e)) : (e.quantity = d.quantity, e.mete = d.mete, e.materialId = d.id, e.factoryId = (c = d.factory) == null ? void 0 : c.id, e.operateQuantity = (d.quantity || 0) - (d.frozenQuantity || 0), e.operateMete = d.mete - (d.frozenMete || 0), e.maxQuantity = e.outboundUnitType === E.MEASURE.V ? e.operateQuantity : e.operateMete, e.outboundUnitPrecision = e.outboundUnitType === E.MEASURE.V ? e.measurePrecision : e.accountingPrecision, e.outboundUnit = e.outboundUnitType === E.MEASURE.V ? e.measureUnit : e.accountingUnit, e.diffQuantity = void 0) : v(e);
      } else v(e);
    }
  }
  function F(e, s) {
    h.value.otherList.splice(s, 1);
  }
  function J() {
    if (V(h.value.otherList)) return true;
    const { validResult: e, dealList: s } = q(h.value.otherList);
    return h.value.otherList = s, e;
  }
  return M({ addRow: $, rowWatch: Q, validate: J }), (e, s) => {
    const n = Y, c = j("common-select"), I = j("common-input-number"), d = Z, t = j("common-button"), g = j("common-table");
    return i(), b(g, K({ "cell-class-name": f(z), data: f(h).otherList, "show-empty-symbol": false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: u(() => [o(n, { align: "center", fixed: "left", label: "序号", type: "index", width: "60" }), o(n, { align: "center", fixed: "left", label: "名称", prop: "classifyName", "show-overflow-tooltip": "", sortable: "", width: "120" }, { default: u(({ row: a }) => [a.isImport ? (i(), m("span", ce, r(a.classifyName), 1)) : (i(), b(c, { key: 1, modelValue: a.classifyId, "onUpdate:modelValue": (l) => a.classifyId = l, options: O.value, dataStructure: { key: "id", label: "name", value: "id" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择物料名称", style: { width: "200px" }, onChange: (l) => A(a) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"]))]), _: 1 }), o(n, { align: "center", fixed: "left", label: "规格", prop: "specification", "show-overflow-tooltip": "", width: "100px" }, { default: u(({ row: a }) => [a.isImport ? (i(), m("span", ue, r(a.specification), 1)) : (i(), b(c, { key: 1, modelValue: a.specification, "onUpdate:modelValue": (l) => a.specification = l, options: a.specificationOptions, dataStructure: { key: "name", label: "name", value: "name" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择规格", disabled: !a.classifyId || f(V)(a.specificationOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))]), _: 1 }), o(n, { align: "center", label: "品牌", "min-width": "100px", prop: "brand" }, { default: u(({ row: a }) => [a.isImport ? (i(), m("span", pe, r(a.brand), 1)) : (i(), b(c, { key: 1, modelValue: a.brand, "onUpdate:modelValue": (l) => a.brand = l, options: a.brandOptions || [], dataStructure: { key: "name", label: "name", value: "name" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择品牌", disabled: !a.classifyId || f(V)(a.brandOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))]), _: 1 }), o(n, { align: "center", label: "颜色", "min-width": "150px", prop: "color" }, { default: u(({ row: a }) => [a.isImport ? (i(), m("span", me, r(a.color), 1)) : (i(), b(c, { key: 1, modelValue: a.color, "onUpdate:modelValue": (l) => a.color = l, options: a.colorOptions || [], dataStructure: { key: "name", label: "name", value: "name" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择颜色", disabled: !a.classifyId || f(V)(a.colorOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))]), _: 1 }), o(n, { align: "center", label: "项目", "min-width": "100px", prop: "projectId" }, { default: u(({ row: a }) => {
      var l;
      return [a.isImport ? (i(), m("span", fe, r(((l = a.project) == null ? void 0 : l.name) || "-"), 1)) : (i(), b(c, { key: 1, modelValue: a.projectId, "onUpdate:modelValue": (U) => a.projectId = U, options: a.projectIdOptions || [], dataStructure: { key: "id", label: "name", value: "id" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择项目", disabled: !a.classifyId || f(V)(a.projectIdOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))];
    }), _: 1 }), o(n, { align: "center", label: "仓库", "min-width": "150px", prop: "warehouseId" }, { default: u(({ row: a }) => {
      var l;
      return [a.isImport ? (i(), m("span", re, r(((l = a.warehouse) == null ? void 0 : l.name) || "-"), 1)) : (i(), b(c, { key: 1, modelValue: a.warehouseId, "onUpdate:modelValue": (U) => a.warehouseId = U, options: a.warehouseIdOptions || [], dataStructure: { key: "id", label: "name", value: "id" }, class: "input-underline", clearable: "", filterable: "", type: "other", placeholder: "可选择仓库", disabled: !a.classifyId || f(V)(a.warehouseIdOptions), style: { width: "200px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"]))];
    }), _: 1 }), o(n, { label: "现存数量", align: "center", prop: "quantity", width: "135px" }, { default: u(({ row: a }) => [a.measureUnit ? (i(), m(C, { key: 0 }, [f(y)(a.operateQuantity) ? (i(), m(C, { key: 0 }, [k("span", ye, r(a.operateQuantity), 1), s[0] || (s[0] = S(" / "))], 64)) : _("", true), k("span", null, r(a.quantity), 1)], 64)) : _("", true)]), _: 1 }), o(n, { key: "mete", label: "现存重量", align: "center", prop: "mete", width: "135px" }, { default: u(({ row: a }) => [f(y)(a.operateMete) ? (i(), m(C, { key: 0 }, [k("span", he, r(a.operateMete), 1), s[1] || (s[1] = S(" / "))], 64)) : _("", true), k("span", null, r(a.mete), 1)]), _: 1 }), o(n, { label: "盘亏数量", align: "center", prop: "diffQuantity", width: "135px" }, { default: u(({ row: a }) => [a.maxQuantity ? (i(), m("span", be, [o(I, { modelValue: a.diffQuantity, "onUpdate:modelValue": (l) => a.diffQuantity = l, controls: false, max: a.maxQuantity, min: 1, precision: a.outboundUnitPrecision, step: 1, "controls-position": "right", placeholder: "数量", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision"]), k("span", Ie, r(a.outboundUnit), 1)])) : _("", true)]), _: 1 }), f(h).deficitType === f(R).PROJECT.V ? (i(), b(n, { key: "deficitProjectId", label: "归属项目", align: "center", prop: "deficitProjectId", "min-width": "150px" }, { default: u(({ row: a }) => [a.maxQuantity ? (i(), m("span", _e, [o(f(ae), { modelValue: a.deficitProjectId, "onUpdate:modelValue": (l) => a.deficitProjectId = l, class: "input-underline", style: { width: "100%" }, filterable: "", clearable: "", placeholder: "可选择项目" }, null, 8, ["modelValue", "onUpdate:modelValue"])])) : _("", true)]), _: 1 })) : _("", true), o(te, { label: "实际盘亏时间" }), o(n, { key: "remark", prop: "remark", align: "center", label: "备注", "min-width": "150px" }, { default: u(({ row: a }) => [a.maxQuantity ? (i(), m("span", Ve, [o(d, { modelValue: a.remark, "onUpdate:modelValue": (l) => a.remark = l, placeholder: "备注", maxlength: "200", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])])) : _("", true)]), _: 1 }), o(n, { align: "center", fixed: "right", label: "操作", width: "80" }, { default: u(({ row: a, $index: l }) => [o(t, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (U) => F(a.sn, l) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data"]);
  };
} };
export {
  je as default
};
