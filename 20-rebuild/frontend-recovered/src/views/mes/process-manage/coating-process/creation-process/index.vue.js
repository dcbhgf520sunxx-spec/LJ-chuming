import { ref as y } from "vue";
import { nextTick as U } from "vue";
import { resolveComponent as D } from "vue";
import { resolveDirective as J } from "vue";
import { openBlock as R } from "vue";
import { createBlock as V } from "vue";
import { withCtx as s } from "vue";
import { createVNode as l } from "vue";
import { unref as n } from "vue";
import { createElementVNode as i } from "vue";
import { withDirectives as q } from "vue";
import { createTextVNode as $ } from "vue";
import { toDisplayString as p } from "vue";
import { isRef as K } from "vue";
import { ElTableColumn as Q } from "element-plus";
import { ElInputNumber as Y } from "element-plus";
import { vLoading as X } from "element-plus";
import { d as Z, p as ee } from "../../../../../modules/creation-process-d3879d47.js";
import { _ as ae, u as te, x as oe, o as le, bY as A, ov as S, L as ne, ow as ie, bV as re } from "../../../../../shared/runtime.js";
import se from "./module/header.vue.js";
import ce from "./module/form.vue.js";
const pe = { class: "sort-and-export" }, ue = { class: "sort-style" }, de = { class: "sort-item" }, me = { class: "sort-item" }, fe = { __name: "index", props: { visible: { type: Boolean, default: false }, secondaryData: { type: Object, default: () => {
} }, paintSelectList: { type: Array, default: () => [] }, paintBrandList: { type: Array, default: () => [] }, paintTypeList: { type: Array, default: () => [] } }, emits: ["update:visible", "creationClose"], setup(w, { emit: H }) {
  const F = H, u = w, L = y(), B = y(), N = y(), c = y(), M = y(), g = y(), h = y(), { visible: x, handleClose: P } = te({ emit: F, props: u, field: "visible", showHook: W, closeHook: j }), { crud: d, CRUD: O } = oe({ title: "工艺创建", crudApi: { ...Z }, sort: ["id.desc"], queryOnPresenterCreated: false, hasPagination: false }, L), { maxHeight: G } = le({ mainBox: ".creation-process", extraBox: [".el-drawer__header", ".head-container", ".sort-and-export"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, () => B.value.loaded);
  function I(r, e) {
    e.weight && (e.totalPrice = e.weight * r), E();
  }
  function W() {
    U(() => {
      var r, e, t, o, v, _, b, k, C, f;
      (e = (r = c.value) == null ? void 0 : r.formRef) == null || e.clearValidate(), u.secondaryData && c.value && (c.value.calculateForm.surfaceArea = (t = u.secondaryData) == null ? void 0 : t.surfaceArea, c.value.calculateForm.filmThickness = (o = u.secondaryData) == null ? void 0 : o.paintFilmThickness, c.value.calculateForm.lossCoefficient = (v = u.secondaryData) == null ? void 0 : v.lossCoefficient, d.query.paintingTypeEnum = ((_ = u.secondaryData) == null ? void 0 : _.paintingTypeEnum) || A.PRIMER.V, d.query.paintBrandList = (b = u.secondaryData) != null && b.paintBrand ? [(k = u.secondaryData) == null ? void 0 : k.paintBrand] : [], d.query.paintTypeList = (C = u.secondaryData) != null && C.paintType ? [(f = u.secondaryData) == null ? void 0 : f.paintType] : []);
    }), d.resetQuery();
  }
  O.HOOK.handleRefresh = async (r, { data: e }) => {
    u.secondaryData && c.value && c.value.calculateForm.surfaceArea && c.value.calculateForm.filmThickness && c.value.calculateForm.lossCoefficient && (r.data = e.content.map((t) => (t.theoreticalCoatingRate = t.volumeSolidContent * 10 / t.specificGravity / c.value.calculateForm.filmThickness, t.practicalSpreadingRate = t.theoreticalCoatingRate / c.value.calculateForm.lossCoefficient, t.weight = c.value.calculateForm.surfaceArea / t.practicalSpreadingRate, t.price = u.secondaryData.unitPrice, t.quantity = t.weight / t.packageWeight, t.weight && t.price && (t.totalPrice = t.weight * t.price), t))), M.value = JSON.parse(JSON.stringify(r.data));
  };
  function j() {
    d.data = [], U(() => {
      var r, e;
      (e = (r = c.value) == null ? void 0 : r.formRef) == null || e.resetFields();
    }), F("creationClose");
  }
  function T(r, e) {
    r && (e === "totalPrice" ? g.value = void 0 : h.value = void 0, d.data = d.data.sort((t, o) => r === S.DESC.V ? o[e] - t[e] : t[e] - o[e]));
  }
  function E() {
    if (g.value || h.value) {
      const r = g.value || h.value, e = g.value ? "weight" : h.value ? "totalPrice" : "";
      T(r, e);
    }
  }
  function z() {
    E();
  }
  return (r, e) => {
    const t = D("common-select"), o = Q, v = Y, _ = D("common-table"), b = D("common-drawer"), k = J("permission"), C = X;
    return R(), V(b, { "append-to-body": "", ref_key: "drawerRef", ref: B, "with-header": false, modelValue: n(x), "onUpdate:modelValue": e[5] || (e[5] = (f) => K(x) ? x.value = f : null), "before-close": n(P), size: "100%", customClass: "creation-process" }, { content: s(() => {
      var f;
      return [l(n(se), { ref_key: "headerRef", ref: c, paintBrandList: w.paintBrandList, paintTypeList: w.paintTypeList, paintSelectList: w.paintSelectList, secondaryData: w.secondaryData, onCalculate: z, onClose: n(P) }, null, 8, ["paintBrandList", "paintTypeList", "paintSelectList", "secondaryData", "onClose"]), i("div", pe, [i("div", ue, [i("div", de, [e[6] || (e[6] = i("span", { class: "sort-label" }, "重量排序：", -1)), l(t, { type: "enum", modelValue: g.value, "onUpdate:modelValue": e[0] || (e[0] = (a) => g.value = a), options: n(S).ENUM, placeholder: "请选择", clearable: "", style: { width: "240px" }, class: "filter-item", onChange: e[1] || (e[1] = (a) => T(a, "weight")) }, null, 8, ["modelValue", "options"])]), i("div", me, [e[7] || (e[7] = i("span", { class: "sort-label" }, "金额排序：", -1)), l(t, { type: "enum", modelValue: h.value, "onUpdate:modelValue": e[2] || (e[2] = (a) => h.value = a), options: n(S).ENUM, placeholder: "请选择", clearable: "", style: { width: "240px" }, class: "filter-item", onChange: e[3] || (e[3] = (a) => T(a, "totalPrice")) }, null, 8, ["modelValue", "options"])])]), q((R(), V(n(ne), { fn: n(ee), params: n(d).data, size: "default" }, { default: s(() => e[8] || (e[8] = [$(" 下载 ")])), _: 1, __: [8] }, 8, ["fn", "params"])), [[k, n(ie).export]])]), q((R(), V(_, { ref_key: "tableRef", ref: L, data: n(d).data, "empty-text": n(d).emptyText, "return-source-data": "", "show-empty-symbol": false, "max-height": n(G), style: { width: "100%" } }, { default: s(() => [l(o, { label: "序号", type: "index", align: "center", width: "60" }), l(o, { key: "paintingTypeEnum", prop: "paintingTypeEnum", "show-overflow-tooltip": "", label: "油漆类型", align: "center" }, { default: s((a) => [i("span", null, p(a.row.paintingTypeEnum ? n(A).VL[a.row.paintingTypeEnum] : "-"), 1)]), _: 1 }), l(o, { key: "paintBrand", prop: "paintBrand", "show-overflow-tooltip": "", label: "品牌", align: "center" }, { default: s((a) => [i("span", null, p(a.row.paintBrand || "-"), 1)]), _: 1 }), l(o, { key: "paintType", prop: "paintType", "show-overflow-tooltip": "", label: "材质", align: "center", "min-width": "160" }, { default: s((a) => [i("span", null, p(a.row.paintType || "-"), 1)]), _: 1 }), l(o, { key: "specificGravity", prop: "specificGravity", "show-overflow-tooltip": "", label: "比重（kg/L）", align: "center" }, { default: s((a) => [i("span", null, p(a.row.specificGravity || "-"), 1)]), _: 1 }), l(o, { key: "volumeSolidContent", prop: "volumeSolidContent", "show-overflow-tooltip": "", label: "体积固含量（%）", align: "center", "min-width": "100" }, { default: s((a) => [i("span", null, p(a.row.volumeSolidContent || "-"), 1)]), _: 1 }), l(o, { key: "packageWeight", prop: "packageWeight", "show-overflow-tooltip": "", label: "包装重量", align: "center" }, { default: s((a) => [i("span", null, p(a.row.packageWeight || "-"), 1)]), _: 1 }), l(o, { key: "unit", prop: "unit", "show-overflow-tooltip": "", label: "单位", align: "center" }, { default: s((a) => [i("span", null, p(a.row.unit || "-") + "/ " + p(a.row.packageUnit || "-"), 1)]), _: 1 }), l(o, { key: "practicalSpreadingRate", prop: "practicalSpreadingRate", "show-overflow-tooltip": "", label: "实际涂布率（㎡/kg）", align: "center", width: "140px" }, { default: s((a) => {
        var m;
        return [i("span", null, p(((m = a.row.practicalSpreadingRate) == null ? void 0 : m.toFixed(2)) || "-"), 1)];
      }), _: 1 }), l(o, { key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "数量", align: "center" }, { default: s((a) => {
        var m;
        return [i("span", null, p(((m = a.row.quantity) == null ? void 0 : m.toFixed(2)) || "-"), 1)];
      }), _: 1 }), l(o, { key: "packageUnit", prop: "packageUnit", "show-overflow-tooltip": "", label: "数量单位", align: "center" }, { default: s((a) => [i("span", null, p(a.row.packageUnit || "-"), 1)]), _: 1 }), l(o, { key: "weight", prop: "weight", "show-overflow-tooltip": "", label: "重量（kg）", align: "center" }, { default: s((a) => {
        var m;
        return [i("span", null, p(((m = a.row.weight) == null ? void 0 : m.toFixed(2)) || "-"), 1)];
      }), _: 1 }), l(o, { key: "price", prop: "price", "show-overflow-tooltip": "", label: "采购单价（元）", align: "center", width: "170px" }, { default: s((a) => [l(v, { modelValue: a.row.price, "onUpdate:modelValue": (m) => a.row.price = m, modelModifiers: { number: true }, min: 1e-6, max: 99999999999, step: 1, precision: 2, placeholder: "输入采购单价", "controls-position": "right", style: { width: "100%" }, onChange: (m) => I(m, a.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 }), l(o, { key: "totalPrice", prop: "totalPrice", "show-overflow-tooltip": "", label: "金额（元）", align: "center" }, { default: s((a) => [i("span", null, p(n(re)(a.row.totalPrice, 2) || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[C, n(d).loading]]), l(n(ce), { currentRow: N.value, calculateForm: (f = c.value) == null ? void 0 : f.calculateForm, secondaryData: w.secondaryData, onSubmitSuccess: e[4] || (e[4] = (a) => n(d).refresh()) }, null, 8, ["currentRow", "calculateForm", "secondaryData"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, _e = ae(fe, [["__scopeId", "data-v-236c8a0b"]]);
export {
  _e as default
};
