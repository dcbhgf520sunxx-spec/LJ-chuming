import { ref as p } from "vue";
import { inject as B } from "vue";
import { watch as q } from "vue";
import { resolveComponent as P } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as T } from "vue";
import { createElementVNode as b } from "vue";
import { createTextVNode as x } from "vue";
import { unref as r } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as h } from "vue";
import { toDisplayString as m } from "vue";
import { createCommentVNode as w } from "vue";
import { createVNode as l } from "vue";
import { withDirectives as pe } from "vue";
import { ElTag as me } from "element-plus";
import { ElInput as ye } from "element-plus";
import { ElTableColumn as fe } from "element-plus";
import { ElPagination as be } from "element-plus";
import { vLoading as he } from "element-plus";
import { _ as we, Bm as y, jX as ge, J as _e, i as z, cO as ze, jl as L, cS as R, xL as je, r8 as Ve, r9 as ke, fv as Qe, ap as Ce, aR as Ie, z as Pe, xY as E, iX as W, ba as xe, a as Re } from "../../../../../shared/runtime.js";
import { g as Ue } from "../../../../../modules/mes-ship-receipt-ae6ae43f.js";
import Me from "./outbound-handling-form/index.vue.js";
import "./outbound-handling-form/module/steel-plate.vue.js";
import "./outbound-handling-form/components/common-form-item.vue.js";
import "./outbound-handling-form/components/produce-form.vue.js";
import "./outbound-handling-form/components/common-material-info.vue.js";
import "./outbound-handling-form/module/section-steel.vue.js";
import "./outbound-handling-form/module/steel-coil.vue.js";
import "./outbound-handling-form/module/aux-mat.vue.js";
import "./outbound-handling-form/module/gas.vue.js";
import "./outbound-handling-form/module/other.vue.js";
const Ne = { class: "title-left" }, ve = { class: "head-container" }, Se = { key: 0 }, Te = { key: 0 }, Ee = { class: "color-green" }, Ae = { class: "color-green" }, Oe = { __name: "outbound-handle-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, deleteRowObj: { type: Object, default: () => {
} }, maxHeight: { type: Number, default: 100 } }, emits: ["outboundSuccess"], setup(j, { expose: D, emit: H }) {
  const f = j, K = H, J = p(), U = p(false), M = p({}), i = p([]), N = p([]), $ = p([y.PARTY_A.V]), X = B("handleDetailList"), Y = B("globalProjectId"), v = p(false), o = p({ projectWarehouseType: y.PUBLIC.V, projectId: void 0, workshopId: void 0, warehouseId: void 0, shipmentName: void 0, boolPartyA: false, classifyId: void 0, specification: void 0 }), G = p([...ge, ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]);
  function Z(n) {
    return xe(n, { props: ["quantity", "mete"] });
  }
  const { handleSizeChange: ee, handleCurrentChange: te, total: ae, setTotalPage: oe, queryPage: C } = _e({ fetchHook: c });
  function ne(n) {
    switch (o.value.projectWarehouseType = n, C.pageNumber = 1, n) {
      case y.PUBLIC.V:
        o.value.boolPartyA = false, o.value.projectId = void 0;
        break;
      case y.PROJECT.V:
        o.value.boolPartyA = false, o.value.projectId = void 0;
        break;
    }
    c();
  }
  function le() {
    o.value.boolPartyA && (o.value.projectId = Y.value), c();
  }
  q(() => f.currentRow, (n, e) => {
    (n == null ? void 0 : n.uid) !== (e == null ? void 0 : e.uid) && (o.value = { projectWarehouseType: y.PUBLIC.V, projectId: void 0, workshopId: void 0, warehouseId: void 0, shipmentName: void 0, boolPartyA: false }, c());
  }, { immediate: true, deep: true }), q(() => f.deleteRowObj, (n, e) => {
    z(f.deleteRowObj) && ie(f.deleteRowObj);
  }, { immediate: true, deep: true });
  async function c() {
    var n;
    if (i.value = [], !!z(f.currentRow)) {
      v.value = true;
      try {
        const e = { ...o.value, shipmentName: f.currentRow.name, ...C }, g = ((n = X.value) == null ? void 0 : n.find((t) => {
          var u;
          return t.uid === ((u = f.currentRow) == null ? void 0 : u.uid);
        })) || {}, { content: V = [], totalElements: S } = await Ue(e);
        i.value = V, await ze(i.value);
        const k = [];
        i.value = await L(i.value, { toSmallest: false, toNum: false }), i.value.forEach(async (t) => {
          var I;
          const u = ((I = g.currentOutBoundOptions) == null ? void 0 : I.find((d) => d.materialId === t.id)) || {};
          t.frozenQuantity = (Number(t.frozenQuantity) || 0) + ((u == null ? void 0 : u.outboundQuantity) || 0), t.frozenMete = (Number(t.frozenMete) || 0) + ((u == null ? void 0 : u.outboundMete) || 0), t.operableQuantity = t.quantity - (t.frozenQuantity || 0), t.operableMete = t.mete - (t.frozenMete || 0), t.outboundUnitType === R.MEASURE.V ? (t.corQuantity = t.quantity, t.corFrozenQuantity = t.frozenQuantity, t.corOperableQuantity = t.operableQuantity) : (t.corQuantity = t.mete, t.corFrozenQuantity = t.frozenMete, t.corOperableQuantity = t.operableMete), Array.isArray(t.projectFrozen) && (t.projectFrozenKV = {}, t.projectFrozenForUnitKV = {}, t.projectFrozen = await L(t.projectFrozen, { measureUnit: t.measureUnit, accountingUnit: t.accountingUnit, accountingPrecision: t.accountingPrecision, measurePrecision: t.measurePrecision, toSmallest: false, toNum: true }), k.push(t.projectFrozen), t.projectFrozen.forEach((d) => {
            t.projectFrozenForUnitKV[d.projectId] = t.outboundUnitType === R.MEASURE.V ? d.quantity : d.mete, t.projectFrozenKV[d.projectId] = d;
          }));
        }), await Promise.all(k), await Promise.all(V), oe(S);
      } catch (e) {
        console.log("加载失败", e);
      } finally {
        v.value = false;
      }
    }
  }
  function re(n) {
    U.value = true, M.value = n;
  }
  function ue(n) {
    const e = i.value.find((g) => g.id === n.materialId);
    z(e) && (e.frozenQuantity = (Number(e.frozenQuantity) || 0) + (Number(n.outboundQuantity) || 0), e.frozenMete = (Number(e.frozenMete) || 0) + (Number(n.outboundMete) || 0), e.operableQuantity = e.quantity - (e.frozenQuantity || 0), e.operableMete = e.mete - (e.frozenMete || 0), e.outboundUnitType === R.MEASURE.V ? (e.corQuantity = e.quantity, e.corFrozenQuantity = e.frozenQuantity, e.corOperableQuantity = e.operableQuantity) : (e.corQuantity = e.mete, e.corFrozenQuantity = e.frozenMete, e.corOperableQuantity = e.operableMete));
  }
  function ie(n) {
    const e = i.value.find((g) => g.id === n.materialId);
    z(e) && (e.frozenQuantity = (Number(e.frozenQuantity) || 0) - (Number(n.outboundQuantity) || 0), e.frozenMete = (Number(e.frozenMete) || 0) - (Number(n.outboundMete) || 0), e.operableQuantity = e.quantity - (e.frozenQuantity || 0), e.operableMete = e.mete - (e.frozenMete || 0), e.outboundUnitType === R.MEASURE.V ? (e.corQuantity = e.quantity, e.corFrozenQuantity = e.frozenQuantity, e.corOperableQuantity = e.operableQuantity) : (e.corQuantity = e.mete, e.corFrozenQuantity = e.frozenMete, e.corOperableQuantity = e.operableMete));
  }
  function se(n) {
    ue(n), K("outboundSuccess", n);
  }
  return D({}), (n, e) => {
    var A, O;
    const g = me, V = P("common-radio-button"), S = ye, k = P("table-cell-tag"), t = fe, u = Re, I = P("common-button"), d = P("common-table"), ce = be, de = he;
    return s(), T("div", null, [b("div", Ne, [e[9] || (e[9] = x("实时库存数据 ")), r(z)(j.currentRow) ? (s(), _(g, { key: 0, style: { "margin-left": "10px" } }, { default: h(() => [x(m(j.currentRow.name), 1)]), _: 1 })) : w("", true)]), b("div", ve, [l(V, { modelValue: o.value.projectWarehouseType, "onUpdate:modelValue": e[0] || (e[0] = (a) => o.value.projectWarehouseType = a), options: r(y).ENUM, unshowVal: $.value, class: "filter-item", size: "default", type: "enum", onChange: ne }, null, 8, ["modelValue", "options", "unshowVal"]), ((A = o.value) == null ? void 0 : A.projectWarehouseType) === r(y).PROJECT.V ? (s(), _(V, { key: 0, modelValue: o.value.boolPartyA, "onUpdate:modelValue": e[1] || (e[1] = (a) => o.value.boolPartyA = a), options: r(je).ENUM, class: "filter-item", size: "default", type: "enumSL", onChange: le }, null, 8, ["modelValue", "options"])) : w("", true), l(Ve, { ref_key: "workshopSelectRef", ref: J, modelValue: o.value.workshopId, "onUpdate:modelValue": e[2] || (e[2] = (a) => o.value.workshopId = a), class: "filter-item", clearable: "", placeholder: "仓库", style: { width: "200px" }, onChange: c }, null, 8, ["modelValue"]), l(ke, { modelValue: o.value.warehouseId, "onUpdate:modelValue": e[3] || (e[3] = (a) => o.value.warehouseId = a), "workshop-id": o.value.workshopId, "basic-class": j.currentRow.basicClass, class: "filter-item", disabled: !o.value.workshopId, placeholder: "存储位置", onChange: c }, null, 8, ["modelValue", "workshop-id", "basic-class", "disabled"]), ((O = o.value) == null ? void 0 : O.projectWarehouseType) === r(y).PROJECT.V ? (s(), _(Qe, { key: 1, modelValue: o.value.projectId, "onUpdate:modelValue": e[4] || (e[4] = (a) => o.value.projectId = a), class: "filter-item", disabled: o.value.boolPartyA, clearable: "", isFirst: "", placeholder: "项目", style: { width: "220px" }, onChange: c }, null, 8, ["modelValue", "disabled"])) : w("", true), l(Ce, { modelValue: o.value.classifyId, "onUpdate:modelValue": e[5] || (e[5] = (a) => o.value.classifyId = a), multiple: "", "check-strictly": "", class: "filter-item", clearable: "", placeholder: "可选择/输入科目、编号搜索", separator: " > ", "show-all-levels": "", size: "default", style: { width: "270px" }, onChange: c }, null, 8, ["modelValue"]), l(S, { modelValue: o.value.specification, "onUpdate:modelValue": e[6] || (e[6] = (a) => o.value.specification = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "规格", size: "default", style: { width: "200px" }, onBlur: c }, null, 8, ["modelValue"])]), pe((s(), _(d, { data: i.value, "data-format": G.value, "expand-row-keys": N.value, "max-height": f.maxHeight, "show-summary": "", "summary-method": Z, "row-key": "id" }, { default: h(() => [l(Ie, { "expand-row-keys": N.value, "onUpdate:expandRowKeys": e[7] || (e[7] = (a) => N.value = a), data: i.value, fixed: "left", "row-key": "id" }, { default: h(({ row: { sourceRow: a } }) => [b("p", null, "仓库：" + m(a.workshop.name), 1), b("p", null, "库位：" + m(a.warehouse.name), 1), r(z)(a.project) ? (s(), T("p", Se, "项目：" + m(r(Pe)(a.project)), 1)) : w("", true)]), _: 1 }, 8, ["expand-row-keys", "data"]), l(t, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }, { default: h(({ row: a, $index: Q }) => {
      var F;
      return [a.boolPartyA ? (s(), _(k, { key: 0, show: !!a.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"])) : w("", true), !a.boolPartyA && a.materialIsWhole === r(E).ODDMENT.V ? (s(), _(k, { key: 1, color: (F = r(E).V[a.materialIsWhole]) == null ? void 0 : F.COLOR, name: r(E).VL[a.materialIsWhole], offset: 15 }, null, 8, ["color", "name"])) : w("", true), b("span", null, m(Q + 1), 1)];
    }), _: 1 }), l(t, { key: "serialNumber", align: "left", label: "物料编码", prop: "serialNumber", "show-overflow-tooltip": "" }), l(t, { key: "classifyName", align: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "", "min-width": "100" }), l(t, { key: "specification", label: "规格", align: "center", prop: "specification", "show-overflow-tooltip": "", "min-width": "120px" }), l(t, { key: "brand", label: "品牌", align: "center", prop: "brand", "show-overflow-tooltip": "" }), o.value.projectWarehouseType !== r(y).PUBLIC.V ? (s(), _(t, { key: "project", label: "所属项目", align: "center", prop: "project", "show-overflow-tooltip": "", "min-width": "120px" })) : w("", true), l(t, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center", width: "80px" }), l(t, { prop: "quantity", align: "right", label: "可操作数/数量", "min-width": "140" }, { default: h(({ row: a }) => {
      var Q;
      return [(Q = a.sourceRow) != null && Q.measureUnit ? (s(), T("span", Te, [b("span", Ee, m(r(W)(a.operableQuantity, a.measurePrecision)), 1), x(" / " + m(a.quantity), 1)])) : w("", true)];
    }), _: 1 }), l(t, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center", width: "80px" }), l(t, { key: "mete", prop: "mete", align: "right", label: "可操作量/核算量", "min-width": "140" }, { default: h(({ row: a }) => [b("span", null, [b("span", Ae, m(r(W)(a.operableMete, a.accountingPrecision)), 1), x(" / " + m(a.mete), 1)])]), _: 1 }), l(t, { label: "操作", width: "70px", align: "center" }, { default: h(({ row: { sourceRow: a } }) => [l(I, { size: "default", type: "primary", disabled: a.corOperableQuantity <= 0, onClick: (Q) => re(a) }, { default: h(() => [l(u, { "icon-class": "wms-outbound" })]), _: 2 }, 1032, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])), [[de, v.value]]), l(ce, { total: r(ae), "current-page": r(C).pageNumber, "page-size": r(C).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: r(ee), onCurrentChange: r(te) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), l(Me, { currentRow: j.currentRow, material: M.value, basicClass: M.value.basicClass, modelValue: U.value, "onUpdate:modelValue": e[8] || (e[8] = (a) => U.value = a), onSuccess: se }, null, 8, ["currentRow", "material", "basicClass", "modelValue"])]);
  };
} }, Ze = we(Oe, [["__scopeId", "data-v-7cc88ab5"]]);
export {
  Ze as default
};
