import { ref as T } from "vue";
import { provide as A } from "vue";
import { computed as F } from "vue";
import { onUnmounted as q } from "vue";
import { nextTick as J } from "vue";
import { openBlock as Q } from "vue";
import { createElementBlock as X } from "vue";
import { createVNode as t } from "vue";
import { unref as L } from "vue";
import { withCtx as p } from "vue";
import { createSlots as Y } from "vue";
import { normalizeProps as Z } from "vue";
import { guardReactiveProps as ee } from "vue";
import { createElementVNode as N } from "vue";
import { normalizeStyle as te } from "vue";
import { createTextVNode as k } from "vue";
import { ElIcon as x } from "element-plus";
import { InfoFilled as D } from "@element-plus/icons-vue";
import { ElTooltip as S } from "element-plus";
import { withDirectives as h } from "vue";
import { resolveDirective as y } from "vue";
import { cloneVNode as le } from "vue";
import { Loading as ne } from "@element-plus/icons-vue";
import { ElTableV2 as ae } from "element-plus";
import { ElAutoResizer as ie } from "element-plus";
import { o as re, cR as oe, i as z, cS as se, _ as ue } from "../../../../shared/runtime.js";
import de from "./module/header.vue.js";
import "./module/config-preview.vue.js";
import "../../../../modules/index-61ce89a1.js";
import "./module/config.vue.js";
import "../../../../modules/use-table-change-32e98420.js";
const ce = { class: "app-container" }, fe = { class: "el-loading-mask", style: { display: "flex", "align-items": "center", "justify-content": "center" } }, w = 30, me = { __name: "index", setup(pe) {
  const _ = T(), v = T(true), { maxHeight: B } = re({});
  A("permission", oe);
  const O = [{ key: "index", title: "序号", width: 60, align: "center", cellRenderer: ({ rowIndex: e }) => e + 1 }, { key: "level1", dataKey: "level1", title: "一级", width: 160, align: "left", flexGrow: 1, cellRenderer: ({ rowData: e }) => t("div", { class: "classify-name" }, [t("span", null, [`${e.fullName[0]}-${e.fullSerialNumber[0]}`])]), headerCellRenderer: () => t(S, { effect: "light", content: "一级科目（名称-编号）", placement: "top" }, { default: () => [t("div", { class: "flex-rsc" }, [t("span", null, [k("一级科目")]), t(x, null, { default: () => [t(D, null, null)] })])] }) }, { key: "level2", dataKey: "level2", title: "二级", width: 160, align: "left", flexGrow: 1, cellRenderer: ({ rowData: e }) => t("div", { class: "classify-name" }, [t("span", null, [`${e.fullName[1]}-${e.fullSerialNumber[1]}`])]), headerCellRenderer: () => t(S, { effect: "light", content: "二级科目（名称-编号）", placement: "top" }, { default: () => [t("div", { class: "flex-rsc" }, [t("span", null, [k("二级科目")]), t(x, null, { default: () => [t(D, null, null)] })])] }) }, { key: "level3", dataKey: "level3", title: "三级", width: 160, align: "left", flexGrow: 1, cellRenderer: ({ rowData: e }) => t("div", { class: "classify-name" }, [t("span", null, [`${e.fullName[2]}-${e.fullSerialNumber[2]}`])]), headerCellRenderer: () => t(S, { effect: "light", content: "三级科目（名称-编号）", placement: "top" }, { default: () => [t("div", { class: "flex-rsc" }, [t("span", null, [k("三级科目")]), t(x, null, { default: () => [t(D, null, null)] })])] }) }, { key: "measureUnit", dataKey: "measureUnit", title: "计量单位", width: 100, minWidth: "100px", align: "center", flexGrow: 1, cellRenderer: ({ rowData: e }) => h(t("span", null, [e.measureUnit]), [[y("empty-text")]]) }, { key: "measurePrecision", dataKey: "measurePrecision", title: "小数精度(计量)", width: 100, minWidth: "100px", align: "center", flexGrow: 1, cellRenderer: ({ rowData: e }) => h(t("span", null, [e.measurePrecision]), [[y("empty-text")]]) }, { key: "accountingUnit", dataKey: "accountingUnit", title: "核算单位", width: 100, minWidth: "100px", align: "center", flexGrow: 1, cellRenderer: ({ rowData: e }) => h(t("span", null, [e.accountingUnit]), [[y("empty-text")]]) }, { key: "accountingPrecision", dataKey: "accountingPrecision", title: "小数精度(核算)", width: 100, minWidth: "100px", align: "center", flexGrow: 1, cellRenderer: ({ rowData: e }) => h(t("span", null, [e.accountingPrecision]), [[y("empty-text")]]) }, { key: "outboundUnitType", dataKey: "outboundUnitType", title: "出库单位", width: 100, minWidth: "100px", align: "center", flexGrow: 1, cellRenderer: ({ rowData: e }) => h(t("span", null, [se.VL[e.outboundUnitType]]), [[y("empty-text")]]) }];
  A("lineHeight", w);
  const V = F(() => {
    var e;
    return (e = _.value) == null ? void 0 : e.tableLoading;
  }), b = F(() => {
    var e;
    return (e = _.value) == null ? void 0 : e.query;
  }), W = F(() => {
    var a;
    let e = ((a = _.value) == null ? void 0 : a.tableData) || [];
    if (b.value && z(b.value.nameOrCode)) {
      const l = b.value.nameOrCode;
      e = e.filter((i) => i.fullName.some((r) => r.indexOf(l) > -1) || i.fullSerialNumber.some((r) => r.indexOf(l) > -1));
    }
    return H(e);
  });
  q(() => {
  });
  function H(e) {
    if (e.length === 0) return e;
    const a = [[], []], l = [-1, -1];
    return e.forEach((i, r) => {
      for (let o = 0; o < a.length; o++) {
        const d = i.fullId[o], c = l.length > o ? l[o] : void 0;
        d === c && z(c) ? a[o][a[o].length - 1]++ : (a[o].push(1), l[o] = d);
      }
    }), a[0].reduce((i, r) => (e[i].name1_rowSpan = r, i += r, i), 0), a[1].reduce((i, r) => (e[i].name2_rowSpan = r, i += r, i), 0), setTimeout(() => {
      v.value = false, J(() => {
        v.value = true;
      });
    }, 1e3), e;
  }
  const M = [0, 2, 1], I = [1, 2, 3], m = {}, j = ({ rowData: e, rowIndex: a, cells: l, columns: i }) => {
    var r, o, d, c, g, C, U, $, G;
    for (let E = 0; E < I.length; E++) {
      const n = I[E];
      let f = 1, s = 1;
      n === 1 && (f = e.fullName.length === 1 ? 3 : 1, s = e.name1_rowSpan || 0), n === 2 && (f = M[e.fullName.length - 1], s = e.name2_rowSpan || 0), n === 3 && (f = e.fullName.length < 3 ? 0 : 1, s = 1);
      let K = Number.parseInt((d = (o = (r = l[n]) == null ? void 0 : r.props) == null ? void 0 : o.style) == null ? void 0 : d.width);
      if (f === 0) {
        l[n] = null;
        continue;
      }
      if (s === 0) {
        const u = l[n].props.style, R = { width: `${u.width}px`, height: "100%" };
        (c = m[n]) != null && c.includes(a) && (R.borderBottom = "var(--el-table-border)"), n > 1 && (R.borderLeft = "var(--el-table-border)"), l[n] = t("div", { style: { ...u, ...R } }, null);
        continue;
      }
      for (let u = 1; u < f; u++) K += Number.parseInt((U = (C = (g = l[n + u]) == null ? void 0 : g.props) == null ? void 0 : C.style) == null ? void 0 : U.width);
      const P = { ...(G = ($ = l[n]) == null ? void 0 : $.props) == null ? void 0 : G.style, width: `${K}px`, flexGrow: f, height: `${s * w}px`, alignSelf: "flex-start", border: s > 1 ? "none" : "", zIndex: s > 1 ? 1 : 0 };
      if (s > 1) {
        const u = a + s - 1;
        m[n] || (m[n] = []), m[n].includes(u) || m[n].push(u);
      }
      n > 1 && (s >= 1 || f > 1) && (P.borderLeft = "var(--el-table-border)"), l[n] = le(l[n], { style: P });
    }
    return l;
  };
  return (e, a) => {
    const l = ne, i = x, r = ae, o = ie;
    return Q(), X("div", ce, [t(L(de), { ref_key: "headerRef", ref: _ }, null, 512), t(o, { style: te({ height: `${L(B)}px` }) }, { default: p(({ height: d, width: c }) => [t(r, { ref: "tableRef", data: W.value, "header-height": w, "row-height": w, columns: O, width: c, height: d }, Y({ row: p((g) => [t(j, Z(ee(g)), null, 16)]), empty: p(() => [a[0] || (a[0] = N("div", { class: "el-table__empty-block", style: { height: "100%", width: "100%" } }, [N("span", { class: "el-table__empty-text" }, "暂无数据")], -1))]), _: 2 }, [!v.value || V.value ? { name: "overlay", fn: p(() => [N("div", fe, [t(i, { class: "is-loading", color: "var(--el-color-primary)", size: 26 }, { default: p(() => [t(l)]), _: 1 })])]), key: "0" } : void 0]), 1032, ["data", "width", "height"])]), _: 1 }, 8, ["style"])]);
  };
} };
const Re = ue(me, [["__scopeId", "data-v-d1189f4c"]]);
export {
  Re as default
};
