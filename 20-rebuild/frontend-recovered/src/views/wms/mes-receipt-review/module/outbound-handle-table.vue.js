import { ref as b } from "vue";
import { inject as N } from "vue";
import { watch as B } from "vue";
import { resolveComponent as Q } from "vue";
import { openBlock as z } from "vue";
import { createElementBlock as q } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as l } from "vue";
import { unref as i } from "vue";
import { withCtx as y } from "vue";
import { createTextVNode as j } from "vue";
import { withModifiers as D } from "vue";
import { toDisplayString as h } from "vue";
import { createCommentVNode as R } from "vue";
import { createBlock as U } from "vue";
import { ElInput as ye } from "element-plus";
import { ElTableColumn as be } from "element-plus";
import { ElPagination as he } from "element-plus";
import { _ as we, Bm as _, pB as E, jX as _e, J as ge, i as w, am as I, cO as ke, jl as H, cS as M, gF as ze, aR as Ve, z as Ce, xY as A, ba as Qe, a as je } from "../../../../shared/runtime.js";
import { b as Re, e as Ee } from "../../../../modules/mes-receipt-review-377f871a.js";
import Ie from "./outbound-handling-form/index.vue.js";
import "./outbound-handling-form/module/steel-plate.vue.js";
import "./outbound-handling-form/components/common-form-item.vue.js";
import "./outbound-handling-form/components/produce-form.vue.js";
import "./outbound-handling-form/components/common-material-info.vue.js";
import "./outbound-handling-form/module/section-steel.vue.js";
const Me = { class: "head-container" }, Se = { key: 0 }, xe = { class: "color-green" }, Pe = { class: "color-green" }, Te = { __name: "outbound-handle-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, deleteRowObj: { type: Object, default: () => {
} }, maxHeight: { type: Number, default: 100 } }, emits: ["outboundSuccess"], setup(v, { expose: K, emit: J }) {
  const s = v, Y = J, O = b(), S = b(false), F = b({}), p = N("mainCurrentRow"), f = b([]), $ = N("workshopNameV3"), x = b([]), Z = b([_.PARTY_A.V]), X = N("handleDetailList"), n = b({ searchMode: _.PUBLIC.V, projectWarehouseType: E.PUBLIC.V, projectId: void 0, boolPartyA: false, workshopIds: [], workshopArr: [] }), G = b([..._e, ["remark", "empty-text"], ["project", "parse-project"], ["sourceProject", "parse-project"], ["outboundTime", ["parse-time", "{y}-{m}-{d} {h}:{i}:{s}"]]]);
  function ee(o) {
    return Qe(o, { props: ["quantity", "mete"] });
  }
  const { handleSizeChange: te, handleCurrentChange: oe, total: ae, setTotalPage: ne, queryPage: V } = ge({ fetchHook: g });
  function re() {
    g();
  }
  function le(o) {
    var e;
    switch (n.value.searchMode = o, o) {
      case _.PUBLIC.V:
        n.value.projectWarehouseType = E.PUBLIC.V, n.value.boolPartyA = false, n.value.projectId = void 0;
        break;
      case _.PROJECT.V:
        n.value.projectWarehouseType = E.PROJECT.V, n.value.boolPartyA = false, n.value.projectId = void 0;
        break;
      case _.PARTY_A.V:
        n.value.projectWarehouseType = void 0, n.value.boolPartyA = true, n.value.projectId = (e = p.value.project) == null ? void 0 : e.id;
        break;
    }
    g();
  }
  function ie(o) {
    return o.match(/^[A-Za-z]+/)[0];
  }
  function se(o) {
    return o.replace(/^[A-Za-z]+/, "").trim();
  }
  function ue() {
    g();
  }
  function ce() {
    var o, e;
    n.value = { searchMode: _.PUBLIC.V, projectWarehouseType: E.PUBLIC.V, projectId: void 0, boolPartyA: false, workshopIds: ((e = (o = O.value) == null ? void 0 : o.options) == null ? void 0 : e.map((c) => c.id)) || [], workshopArr: [] }, g();
  }
  B(() => s.currentRow, (o, e) => {
    g();
  }, { immediate: true, deep: true }), B(() => s.deleteRowObj, (o, e) => {
    w(s.deleteRowObj) && de(s.deleteRowObj);
  }, { immediate: true, deep: true });
  async function g() {
    var o;
    if (w(s.currentRow)) try {
      if (w(n.value.workshopArr)) n.value.workshopIds = n.value.workshopArr;
      else if (p.value.mesWorkshopId) {
        const t = [];
        $.value.forEach((r) => {
          w(r.mesWorkshopIds) && (r.mesWorkshopIds.includes(p.value.mesWorkshopId + "") || r.mesWorkshopIds.includes(p.value.mesWorkshopId)) && t.push(r);
        }), n.value.workshopIds = t.map((r) => r.id) || [];
      }
      const e = p.value.basicClass === I.STEEL_PLATE.V ? Re : Ee;
      let c = {};
      if (p.value.basicClass === I.STEEL_PLATE.V) c = { material: s.currentRow.material, thickness: s.currentRow.thick, ...n.value, ...V };
      else if (w(s.currentRow.specification)) {
        const t = ie(s.currentRow.specification), r = se(s.currentRow.specification) + " * " + s.currentRow.material;
        c = { specNumber: t, specification: r, ...n.value, ...V };
      } else return;
      const P = ((o = X.value) == null ? void 0 : o.find((t) => {
        var r;
        return t.uid === ((r = s.currentRow) == null ? void 0 : r.uid);
      })) || {}, { content: k = [], totalElements: T } = await e(c);
      await ke(k);
      const u = await H(k, { toSmallest: false, toNum: false });
      await Promise.all(u.map(async (t) => {
        var C;
        const r = ((C = P.currentOutBoundOptions) == null ? void 0 : C.find((m) => m.materialId === t.id)) || {};
        t.frozenQuantity = (Number(t.frozenQuantity) || 0) + ((r == null ? void 0 : r.outboundQuantity) || 0), t.frozenMete = (Number(t.frozenMete) || 0) + ((r == null ? void 0 : r.outboundMete) || 0), t.operableQuantity = t.quantity - (t.frozenQuantity || 0), t.operableMete = t.mete - (t.frozenMete || 0), t.outboundUnitType === M.MEASURE.V ? (t.corQuantity = t.quantity, t.corFrozenQuantity = t.frozenQuantity, t.corOperableQuantity = t.operableQuantity) : (t.corQuantity = t.mete, t.corFrozenQuantity = t.frozenMete, t.corOperableQuantity = t.operableMete), Array.isArray(t.projectFrozen) && (t.projectFrozenKV = {}, t.projectFrozenForUnitKV = {}, t.projectFrozen = await H(t.projectFrozen, { measureUnit: t.measureUnit, accountingUnit: t.accountingUnit, accountingPrecision: t.accountingPrecision, measurePrecision: t.measurePrecision, toSmallest: false, toNum: true }), t.projectFrozen.forEach((m) => {
          t.projectFrozenForUnitKV[m.projectId] = t.outboundUnitType === M.MEASURE.V ? m.quantity : m.mete, t.projectFrozenKV[m.projectId] = m;
        }));
      })), f.value = u, ne(T);
    } catch (e) {
      console.log("加载失败", e);
    } finally {
    }
  }
  function pe(o) {
    S.value = true, F.value = o;
  }
  function me(o) {
    const e = f.value.find((c) => c.id === o.materialId);
    w(e) && (e.frozenQuantity = (Number(e.frozenQuantity) || 0) + (Number(o.outboundQuantity) || 0), e.frozenMete = (Number(e.frozenMete) || 0) + (Number(o.outboundMete) || 0), e.operableQuantity = e.quantity - (e.frozenQuantity || 0), e.operableMete = e.mete - (e.frozenMete || 0), e.outboundUnitType === M.MEASURE.V ? (e.corQuantity = e.quantity, e.corFrozenQuantity = e.frozenQuantity, e.corOperableQuantity = e.operableQuantity) : (e.corQuantity = e.mete, e.corFrozenQuantity = e.frozenMete, e.corOperableQuantity = e.operableMete));
  }
  function de(o) {
    const e = f.value.find((c) => c.id === o.materialId);
    w(e) && (e.frozenQuantity = (Number(e.frozenQuantity) || 0) - (Number(o.outboundQuantity) || 0), e.frozenMete = (Number(e.frozenMete) || 0) - (Number(o.outboundMete) || 0), e.operableQuantity = e.quantity - (e.frozenQuantity || 0), e.operableMete = e.mete - (e.frozenMete || 0), e.outboundUnitType === M.MEASURE.V ? (e.corQuantity = e.quantity, e.corFrozenQuantity = e.frozenQuantity, e.corOperableQuantity = e.operableQuantity) : (e.corQuantity = e.mete, e.corFrozenQuantity = e.frozenMete, e.corOperableQuantity = e.operableMete));
  }
  function fe(o) {
    me(o), Y("outboundSuccess", o);
  }
  return K({}), (o, e) => {
    var m, L;
    const c = Q("common-radio-button"), P = ye, k = Q("common-button"), T = Q("table-cell-tag"), u = be, t = je, r = Q("common-table"), C = he;
    return z(), q("div", null, [e[8] || (e[8] = d("div", { class: "title-left" }, "实时库存数据", -1)), d("div", Me, [l(ze, { ref_key: "workshopSelectRef", ref: O, modelValue: n.value.workshopArr, "onUpdate:modelValue": e[0] || (e[0] = (a) => n.value.workshopArr = a), class: "filter-item", mesWorkshopId: (L = (m = i(p)) == null ? void 0 : m.mesWorkshop) == null ? void 0 : L.id, clearable: "", multiple: "", placeholder: "仓库", style: { width: "200px" }, onChange: re }, null, 8, ["modelValue", "mesWorkshopId"]), l(c, { modelValue: n.value.searchMode, "onUpdate:modelValue": e[1] || (e[1] = (a) => n.value.searchMode = a), options: i(_).ENUM, unshowVal: Z.value, class: "filter-item", size: "default", type: "enum", onChange: le }, null, 8, ["modelValue", "options", "unshowVal"]), e[7] || (e[7] = d("br", null, null, -1)), l(P, { modelValue: n.value.material, "onUpdate:modelValue": e[2] || (e[2] = (a) => n.value.material = a), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "关键字搜索", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"]), l(k, { class: "filter-item", icon: "el-icon-search", size: "default", type: "success", onClick: D(ue, ["stop"]) }, { default: y(() => e[5] || (e[5] = [j(" 搜索 ")])), _: 1, __: [5] }), l(k, { class: "filter-item", icon: "el-icon-refresh-left", size: "default", type: "warning", onClick: D(ce, ["stop"]) }, { default: y(() => e[6] || (e[6] = [j(" 重置 ")])), _: 1, __: [6] })]), l(r, { data: f.value, "data-format": G.value, "expand-row-keys": x.value, "max-height": s.maxHeight, "show-summary": "", "summary-method": ee, "row-key": "id" }, { default: y(() => [l(Ve, { "expand-row-keys": x.value, "onUpdate:expandRowKeys": e[3] || (e[3] = (a) => x.value = a), data: f.value, fixed: "left", "row-key": "id" }, { default: y(({ row: { sourceRow: a } }) => [d("p", null, "仓库：" + h(a.workshop.name), 1), d("p", null, "库位：" + h(a.warehouse.name), 1), i(w)(a.project) ? (z(), q("p", Se, "项目：" + h(i(Ce)(a.project)), 1)) : R("", true)]), _: 1 }, 8, ["expand-row-keys", "data"]), l(u, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }, { default: y(({ row: { sourceRow: a }, $index: W }) => [a.materialIsWhole === i(A).ODDMENT.V ? (z(), U(T, { key: 0, color: i(A).V[a.materialIsWhole].COLOR, name: i(A).VL[a.materialIsWhole], offset: 15 }, null, 8, ["color", "name"])) : R("", true), d("span", null, h(W + 1), 1)]), _: 1 }), l(u, { key: "serialNumber", align: "left", label: "物料编码", prop: "serialNumber", "show-overflow-tooltip": "", "min-width": "100" }), l(u, { key: "classifyName", align: "left", label: "物料种类", prop: "classifyName", "show-overflow-tooltip": "", "min-width": "100" }), i(p).basicClass === i(I).SECTION_STEEL.V ? (z(), U(u, { key: "specification", label: "规格", align: "center", prop: "specification", "show-overflow-tooltip": "", "min-width": "120px" })) : R("", true), i(p).basicClass === i(I).STEEL_PLATE.V ? (z(), U(u, { key: "thickness", label: "厚度(mm)", align: "center", prop: "thickness", "show-overflow-tooltip": "" })) : R("", true), l(u, { key: "measureUnit", "show-overflow-tooltip": "", prop: "measureUnit", label: "计量单位", align: "center", width: "80px" }), l(u, { prop: "quantity", "show-overflow-tooltip": "", align: "right", label: "可操作数/数量", "min-width": "140" }, { default: y(({ row: a }) => [d("span", null, [d("span", xe, h(a.operableQuantity), 1), j(" / " + h(a.quantity), 1)])]), _: 1 }), l(u, { key: "accountingUnit", "show-overflow-tooltip": "", prop: "accountingUnit", label: "核算单位", align: "center", width: "80px" }), l(u, { key: "mete", prop: "mete", "show-overflow-tooltip": "", align: "right", label: "可操作量/核算量", "min-width": "140" }, { default: y(({ row: a }) => [d("span", null, [d("span", Pe, h(a.operableMete), 1), j(" / " + h(a.mete), 1)])]), _: 1 }), l(u, { label: "操作", width: "100px", align: "center" }, { default: y(({ row: a }) => [l(k, { size: "default", type: "primary", disabled: a.operableQuantity <= 0, onClick: (W) => pe(a) }, { default: y(() => [l(t, { "icon-class": "wms-outbound" })]), _: 2 }, 1032, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"]), l(C, { total: i(ae), "current-page": i(V).pageNumber, "page-size": i(V).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: i(te), onCurrentChange: i(oe) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"]), l(Ie, { currentRow: v.currentRow, material: F.value, basicClass: i(p).basicClass, modelValue: S.value, "onUpdate:modelValue": e[4] || (e[4] = (a) => S.value = a), onSuccess: fe }, null, 8, ["currentRow", "material", "basicClass", "modelValue"])]);
  };
} }, qe = we(Te, [["__scopeId", "data-v-fc1c9b3c"]]);
export {
  qe as default
};
