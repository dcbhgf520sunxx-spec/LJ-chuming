import { inject as M } from "vue";
import { computed as z } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as h } from "vue";
import { ElIcon as V } from "element-plus";
import { InfoFilled as N } from "@element-plus/icons-vue";
import { ElTooltip as P } from "element-plus";
import { withDirectives as f } from "vue";
import { resolveDirective as w } from "vue";
import { resolveComponent as k } from "vue";
import { ref as y } from "vue";
import { reactive as ce } from "vue";
import { watch as de } from "vue";
import { nextTick as fe } from "vue";
import { openBlock as A } from "vue";
import { createBlock as G } from "vue";
import { withCtx as c } from "vue";
import { createElementBlock as me } from "vue";
import { vShow as I } from "vue";
import { unref as m } from "vue";
import { createElementVNode as E } from "vue";
import { normalizeStyle as pe } from "vue";
import { createSlots as ve } from "vue";
import { normalizeProps as ge } from "vue";
import { guardReactiveProps as he } from "vue";
import { createCommentVNode as ye } from "vue";
import { isRef as _e } from "vue";
import { cloneVNode as be } from "vue";
import { ElInput as xe } from "element-plus";
import { Loading as we } from "@element-plus/icons-vue";
import { ElTableV2 as Ee } from "element-plus";
import { ElAutoResizer as Ce } from "element-plus";
import { cU as T, cV as j, cW as Ve, u as ke, o as Fe, b as Re, _ as Ue } from "../../../../../shared/runtime.js";
import { u as Se } from "../../../../../modules/use-table-change-32e98420.js";
import { c as De } from "./config-preview.vue.js";
import "../../../../../modules/index-61ce89a1.js";
const Me = { class: "class-unit-config" }, ze = { class: "query-content" }, Ne = { class: "el-loading-mask", style: { display: "flex", "align-items": "center", "justify-content": "center" } }, Pe = { __name: "config", props: { classificationList: { type: Array, default: () => [] }, level: { type: Number, default: 2 }, visible: { type: Boolean, default: false }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(B, { emit: q }) {
  const J = q, d = B, Q = M("sourceMap"), X = M("permission"), F = M("lineHeight"), Y = z(() => [{ key: "index", title: "序号", width: 60, align: "center", cellRenderer: ({ rowIndex: e }) => e + 1 }, { key: "level1", dataKey: "level1", title: "一级", width: 160, align: "left", flexGrow: 1, class: "classify-name", cellRenderer: ({ rowData: e }) => t("span", null, [`${e.fullName[0]}-${e.fullSerialNumber[0]}`]), headerCellRenderer: () => t(P, { effect: "light", content: "一级科目（名称-编号）", placement: "top" }, { default: () => [t("div", { class: "flex-rsc" }, [t("span", null, [h("一级科目")]), t(V, null, { default: () => [t(N, null, null)] })])] }) }, { key: "level2", dataKey: "level2", hidden: !(d.level > 1), title: "二级", width: 160, align: "left", flexGrow: 1, class: "classify-name", cellRenderer: ({ rowData: e }) => t("span", null, [`${e.fullName[1]}-${e.fullSerialNumber[1]}`]), headerCellRenderer: () => t(P, { effect: "light", content: "二级科目（名称-编号）", placement: "top" }, { default: () => [t("div", { class: "flex-rsc" }, [t("span", null, [h("二级科目")]), t(V, null, { default: () => [t(N, null, null)] })])] }) }, { key: "level3", dataKey: "level3", hidden: !(d.level > 2), title: "三级", width: 160, align: "left", flexGrow: 1, class: "classify-name", cellRenderer: ({ rowData: e }) => t("span", null, [`${e.fullName[2]}-${e.fullSerialNumber[2]}`]), headerCellRenderer: () => t(P, { effect: "light", content: "三级科目（名称-编号）", placement: "top" }, { default: () => [t("div", { class: "flex-rsc" }, [t("span", null, [h("三级科目")]), t(V, null, { default: () => [t(N, null, null)] })])] }) }, { key: "sourceMeasureUnit", dataKey: "sourceMeasureUnit", title: "计量单位", width: 100, minWidth: "100px", align: "center", flexGrow: 1, cellRenderer: ({ rowData: e }) => r.value ? t(T, { modelValue: e.measureUnit, "onUpdate:modelValue": (l) => e.measureUnit = l, size: "default", style: { width: "100%" }, disabled: e.disabled, clearable: true, filterable: true, class: "input-border-none", onChange: (l) => W(e, e.measureUnit, "measurePrecision") }, null) : f(t("span", null, [e.sourceMeasureUnit]), [[w("empty-text")]]) }, { key: "sourceMeasurePrecision", dataKey: "sourceMeasurePrecision", title: "小数精度(计量)", width: 100, minWidth: "100px", align: "center", flexGrow: 1, cellRenderer: ({ rowData: e }) => r.value ? t(k("common-input-number"), { modelValue: e.measurePrecision, "onUpdate:modelValue": (l) => e.measurePrecision = l, step: 1, min: 0, max: 10, disabled: e.disabled, class: "input-border-none", size: "default", style: "width: 100%" }, null) : f(t("span", null, [e.sourceMeasurePrecision]), [[w("empty-text")]]) }, { key: "sourceAccountingUnit", dataKey: "sourceAccountingUnit", title: "核算单位", width: 100, minWidth: "100px", align: "center", flexGrow: 1, cellRenderer: ({ rowData: e }) => r.value ? t(T, { modelValue: e.accountingUnit, "onUpdate:modelValue": (l) => e.accountingUnit = l, size: "default", "unit-type": e.basicClass & j > 0 ? Ve.WEIGHT.K : void 0, style: { width: "100%" }, disabled: e.disabled, clearable: true, filterable: true, class: "input-border-none", onChange: (l) => W(e, e.accountingUnit, "accountingPrecision") }, null) : f(t("span", null, [e.sourceAccountingUnit]), [[w("empty-text")]]) }, { key: "sourceAccountingPrecision", dataKey: "sourceAccountingPrecision", title: "小数精度(核算)", width: 100, minWidth: "100px", align: "center", flexGrow: 1, cellRenderer: ({ rowData: e }) => r.value ? t(k("common-input-number"), { modelValue: e.accountingPrecision, "onUpdate:modelValue": (l) => e.accountingPrecision = l, step: 1, min: 0, max: 10, disabled: e.disabled, class: "input-border-none", size: "default", style: "width: 100%" }, null) : f(t("span", null, [e.sourceAccountingPrecision]), [[w("empty-text")]]) }]), $ = y(), R = y([]), U = ce({ nameOrCode: "" }), S = y(false), r = y(false), C = y(false), { visible: D, handleClose: Z } = ke({ emit: J, props: d, field: "visible", closeHook: L }), { changedCellMask: ee } = Se({ fieldMap: Q }), { maxHeight: le, getElHeight: H, getElement: te } = Fe({ mainBox: ".common-drawer", extraBox: [".el-drawer__header", ".query-content"], wrapperBox: [".el-drawer__body", ".class-unit-config"], navbar: false, clientHRepMainH: true, minHeight: 300, calcWidthFunc: ae }, () => $.value.loaded), ne = y(0);
  function ae() {
    const e = te({ type: "class", name: "class-unit-config" });
    ne.value = H(e, ["width"]) - H(e, ["paddingLeft", "paddingRight"]);
  }
  const ie = z(() => {
    const e = U.nameOrCode, l = R.value.filter((a) => a.fullName.some((i) => i.indexOf(e) > -1) || a.fullSerialNumber.some((i) => i.indexOf(e) > -1));
    return oe(l);
  });
  de([() => d.visible, () => d.classificationList, () => d.level], ([e]) => {
    e && K();
  }, { immediate: true });
  function K() {
    C.value = true, fe(() => {
      R.value = d.classificationList.map((e) => ({ ...e, disabled: (e.basicClass & j) > 0 })), C.value = false;
    });
  }
  function L() {
    r.value = false, K();
  }
  function se() {
    S.value = true;
  }
  function oe(e) {
    if (e.length === 0) return e;
    const l = [[], []], a = [-1, -1];
    return e.forEach((i) => {
      for (let n = 0; n < l.length; n++) {
        const p = i.fullId[n], g = a.length > n ? a[n] : void 0;
        p === g ? l[n][l[n].length - 1]++ : (l[n].push(1), a[n] = p);
      }
    }), l[0].reduce((i, n) => (e[i].name1_rowSpan = n, i += n, i), 0), l[1].reduce((i, n) => (e[i].name2_rowSpan = n, i += n, i), 0), e;
  }
  const O = z(() => {
    let e = [];
    return d.level > 1 && (e = [1, 2]), d.level > 2 && (e = [1, 2, 3]), e;
  }), _ = {}, ue = ({ rowData: e, rowIndex: l, cells: a, columns: i }) => {
    var n, p, g;
    for (let b = 0; b < O.value.length; b++) {
      const s = O.value[b];
      let o = 1;
      if (s === 1 && (o = e.name1_rowSpan || 0), s === 2 && (o = e.name2_rowSpan || 0), o === 0) {
        const v = a[s].props.style, x = { width: `${v.width}px`, height: "100%" };
        (n = _[s]) != null && n.includes(l) && (x.borderBottom = "1px solid #ebeef5"), s > 1 && (x.boxShadow = "-1px 0 0 0 #ebeef5"), a[s] = t("div", { style: { ...v, ...x } }, null);
        continue;
      }
      const u = { ...(g = (p = a[s]) == null ? void 0 : p.props) == null ? void 0 : g.style, height: `${o * F}px`, alignSelf: "flex-start", border: o > 1 ? "none" : "", zIndex: o > 1 ? 1 : 0 };
      if (o > 1) {
        const v = l + o - 1;
        _[s] || (_[s] = []), _[s].includes(v) || _[s].push(v);
      }
      s > 1 && o >= 1 && (u.boxShadow = "-1px 0 0 0 #ebeef5"), a[s] = be(a[s], { style: u });
    }
    return a;
  };
  function re() {
    r.value = false;
  }
  function W(e, l, a) {
    Re(l) && (e[a] = void 0);
  }
  return (e, l) => {
    const a = k("common-button"), i = xe, n = we, p = V, g = Ee, b = Ce, s = k("common-drawer"), o = w("permission");
    return A(), G(s, { ref_key: "drawerRef", ref: $, modelValue: m(D), "onUpdate:modelValue": l[3] || (l[3] = (u) => _e(D) ? D.value = u : null), direction: "rtl", size: "75%", title: "计量配置", "wrapper-closable": false, "before-close": m(Z) }, { titleRight: c(() => [f((A(), me("span", null, [f(t(a, { size: "default", type: "primary", onClick: se }, { default: c(() => l[4] || (l[4] = [h("保存预览")])), _: 1, __: [4] }, 512), [[I, r.value]]), f(t(a, { size: "default", type: "danger", onClick: L }, { default: c(() => l[5] || (l[5] = [h("退出编辑")])), _: 1, __: [5] }, 512), [[I, r.value]]), f(t(a, { size: "default", type: "primary", onClick: l[0] || (l[0] = (u) => r.value = true) }, { default: c(() => l[6] || (l[6] = [h("编辑")])), _: 1, __: [6] }, 512), [[I, !r.value]])])), [[o, m(X).edit]])]), content: c(() => [E("div", Me, [E("div", ze, [t(i, { modelValue: U.nameOrCode, "onUpdate:modelValue": l[1] || (l[1] = (u) => U.nameOrCode = u), modelModifiers: { trim: true }, placeholder: "输入科目名称、编号搜索", class: "filter-item", style: { width: "200px", "margin-bottom": "15px" }, size: "default", clearable: "" }, null, 8, ["modelValue"])]), t(b, { style: pe({ height: `${m(le)}px` }) }, { default: c(({ height: u, width: v }) => [C.value ? ye("", true) : (A(), G(g, { key: 0, data: ie.value, "header-height": m(F), "row-height": m(F), columns: Y.value, width: v, height: u, "cell-class-name": m(ee) }, ve({ row: c((x) => [t(ue, ge(he(x)), null, 16)]), empty: c(() => [l[7] || (l[7] = E("div", { class: "el-table__empty-block", style: { height: "100%", width: "100%" } }, [E("span", { class: "el-table__empty-text" }, "暂无数据")], -1))]), _: 2 }, [C.value ? { name: "overlay", fn: c(() => [E("div", Ne, [t(p, { class: "is-loading", color: "var(--el-color-primary)", size: 26 }, { default: c(() => [t(n)]), _: 1 })])]), key: "0" } : void 0]), 1032, ["data", "header-height", "row-height", "columns", "width", "height", "cell-class-name"]))]), _: 1 }, 8, ["style"]), t(m(De), { visible: S.value, "onUpdate:visible": l[2] || (l[2] = (u) => S.value = u), data: R.value, level: B.level, onSaveSuccess: re }, null, 8, ["visible", "data", "level"])])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
const Oe = Ue(Pe, [["__scopeId", "data-v-33475fc4"]]);
export {
  Oe as default
};
