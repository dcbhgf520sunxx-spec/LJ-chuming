import { inject as $ } from "vue";
import { ref as w } from "vue";
import { computed as U } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as d } from "vue";
import { createBlock as b } from "vue";
import { withCtx as i } from "vue";
import { withDirectives as O } from "vue";
import { createTextVNode as G } from "vue";
import { unref as n } from "vue";
import { createVNode as e } from "vue";
import { createCommentVNode as J } from "vue";
import { createElementBlock as K } from "vue";
import { Fragment as L } from "vue";
import { createElementVNode as y } from "vue";
import { toDisplayString as V } from "vue";
import { isRef as X } from "vue";
import { ElTableColumn as Y } from "element-plus";
import { t as Z, u as ee, o as ae, cf as I, aT as m } from "../../../../../shared/runtime.js";
import { u as oe } from "../../../../../modules/use-table-change-32e98420.js";
import te from "./edit-preview.vue.js";
import "../../../../../modules/wage-adjust-5476478d.js";
import "../../../../../modules/index-61ce89a1.js";
const de = { __name: "edit-dialog", props: { visible: { type: Boolean, default: false }, selections: { type: Array, default: () => [] }, processInfo: { type: Object, default: () => {
} } }, emits: ["update:visible", "refresh"], setup(k, { emit: Q }) {
  const { decimalPrecision: u } = Z(), W = Q, p = k, N = /* @__PURE__ */ new Map([["wage", "sourceWage"], ["intermediatePaintWage", "sourceIntermediatePaintWage"], ["primerWage", "sourcePrimerWage"], ["sourceTopcoatWage", "topcoatWage"]]), { visible: c, handleClose: x } = ee({ emit: W, props: p, field: "visible", showHook: A, closeHook: R }), { maxHeight: M } = ae({ extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, c), { changedCellMask: B } = oe({ fieldMap: N }), E = $("permission"), H = [["wageQuotaTypeStr", ["parse-enum", m, { f: "meteUnit" }], { source: "wageQuotaType" }]], g = w([]), _ = w(false), T = w(false), v = w(false), C = U(() => {
    var l;
    return !!(p.processInfo && ((l = p.processInfo) == null ? void 0 : l.type) & I.PAINT.V && v.value);
  });
  function A() {
    g.value = p.selections.map((l) => (l.wageQuotaType & m.AREA.V && (v.value = true), l));
  }
  const P = U(() => g.value.filter((l) => l.sourceWage !== l.wage || l.sourceIntermediatePaintWage !== l.intermediatePaintWage || l.sourcePrimerWage !== l.primerWage || l.sourceTopcoatWage !== l.topcoatWage));
  function D() {
    T.value = true, x();
  }
  function R() {
    g.value = [], v.value = false, T.value && W("refresh");
  }
  return (l, r) => {
    const S = h("common-button"), a = Y, f = h("common-input-number"), j = h("common-table"), q = h("common-dialog"), F = z("permission");
    return d(), b(q, { title: "批量调整工价", modelValue: n(c), "onUpdate:modelValue": r[2] || (r[2] = (s) => X(c) ? c.value = s : null), width: "1500px", top: "5vh", "before-close": n(x) }, { titleRight: i(() => [O((d(), b(S, { type: "primary", size: "default", disabled: !P.value.length, onClick: r[0] || (r[0] = (s) => _.value = true) }, { default: i(() => r[3] || (r[3] = [G("预览并保存")])), _: 1, __: [3] }, 8, ["disabled"])), [[F, n(E).edit]])]), default: i(() => [e(j, { ref: "tableRef", "return-source-data": "", "show-empty-symbol": false, "data-format": H, data: g.value, "max-height": n(M) - 100, "row-key": "rowId", style: { width: "100%" }, "cell-class-name": n(B) }, { default: i(() => {
      var s;
      return [e(a, { label: "序号", type: "index", align: "center", width: "60" }), e(a, { prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), e(a, { prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), e(a, { prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": "", "min-width": "100px" }), e(a, { prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "", "min-width": "130px" }), e(a, { prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": "", "min-width": "70px" }), e(a, { prop: "netWeight", label: "重量(kg)", align: "center", "show-overflow-tooltip": "", "min-width": "90px" }), ((s = p.processInfo) == null ? void 0 : s.type) !== n(I).PAINT.V ? (d(), b(a, { key: 0, prop: "wageQuotaTypeStr", align: "center", "show-overflow-tooltip": "", label: "核算单位", width: "70px" })) : J("", true), C.value ? (d(), K(L, { key: 1 }, [e(a, { align: "center", prop: "primer", label: "底漆", width: "150" }, { default: i(() => [e(a, { prop: "primerWageQuotaType", align: "center", "show-overflow-tooltip": "", label: "核算单位", width: "70px" }, { default: i(({ row: o }) => {
        var t;
        return [y("span", null, V((t = n(m).V[o.primerWageQuotaType]) == null ? void 0 : t.C_UNIT), 1)];
      }), _: 1 }), e(a, { align: "center", prop: "primerWage", label: "定额单价", width: "150" }, { default: i(({ row: o }) => [e(f, { modelValue: o.primerWage, "onUpdate:modelValue": (t) => o.primerWage = t, placeholder: "请输入单价", precision: n(u).mes, controls: false, style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 })]), _: 1 }), e(a, { align: "center", prop: "intermediatePaint", label: "中间漆", width: "150" }, { default: i(() => [e(a, { prop: "intermediatePaintWageQuotaType", align: "center", "show-overflow-tooltip": "", label: "核算单位", width: "70px" }, { default: i(({ row: o }) => {
        var t;
        return [y("span", null, V((t = n(m).V[o.intermediatePaintWageQuotaType]) == null ? void 0 : t.C_UNIT), 1)];
      }), _: 1 }), e(a, { align: "center", prop: "intermediatePaintWage", label: "定额单价", width: "150" }, { default: i(({ row: o }) => [e(f, { modelValue: o.intermediatePaintWage, "onUpdate:modelValue": (t) => o.intermediatePaintWage = t, placeholder: "请输入单价", precision: n(u).mes, controls: false, style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 })]), _: 1 }), e(a, { align: "center", prop: "topcoat", label: "面漆", width: "150" }, { default: i(() => [e(a, { prop: "topcoatWageQuotaType", align: "center", "show-overflow-tooltip": "", label: "核算单位", width: "70px" }, { default: i(({ row: o }) => {
        var t;
        return [y("span", null, V((t = n(m).V[o.topcoatWageQuotaType]) == null ? void 0 : t.C_UNIT), 1)];
      }), _: 1 }), e(a, { align: "center", prop: "topcoatWage", label: "定额单价", width: "150" }, { default: i(({ row: o }) => [e(f, { modelValue: o.topcoatWage, "onUpdate:modelValue": (t) => o.topcoatWage = t, placeholder: "请输入单价", precision: n(u).mes, controls: false, style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 })]), _: 1 })], 64)) : (d(), b(a, { key: 2, align: "center", prop: "wage", label: "定额单价", width: "200" }, { default: i(({ row: o }) => [e(f, { modelValue: o.wage, "onUpdate:modelValue": (t) => o.wage = t, placeholder: "请输入单价", precision: n(u).mes, controls: false, min: 0, style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }))];
    }), _: 1 }, 8, ["data", "max-height", "cell-class-name"]), e(te, { visible: _.value, "onUpdate:visible": r[1] || (r[1] = (s) => _.value = s), "modified-data": P.value, showMoreColumn: C.value, onSuccess: D }, null, 8, ["visible", "modified-data", "showMoreColumn"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  de as default
};
