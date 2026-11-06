import { ref as _ } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as m } from "vue";
import { createBlock as b } from "vue";
import { withCtx as a } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as r } from "vue";
import { createElementVNode as c } from "vue";
import { withDirectives as T } from "vue";
import { unref as d } from "vue";
import { createElementBlock as v } from "vue";
import { createCommentVNode as V } from "vue";
import { normalizeClass as ee } from "vue";
import { normalizeStyle as te } from "vue";
import { Fragment as ae } from "vue";
import { isRef as oe } from "vue";
import { ElTag as re } from "element-plus";
import { ElTableColumn as le } from "element-plus";
import { ElDivider as ne } from "element-plus";
import { ElPagination as ie } from "element-plus";
import { vLoading as se } from "element-plus";
import { g as ce, a as pe } from "../../../../modules/project-execution-dynamics-721a6cb4.js";
import { _ as ue, u as de, J as me, o as fe, p as he, ba as ge } from "../../../../shared/runtime.js";
const we = { class: "wrap" }, _e = { class: "wrap-left" }, ye = { key: 0, class: "monomerStyle" }, be = { key: 1 }, ve = { key: 0, class: "monomerStyle" }, Ne = { key: 0, class: "monomerStyle" }, xe = { class: "wrap-right" }, ke = { class: "info-header" }, Se = { __name: "deepen-detail", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(k, { emit: q }) {
  const M = q, S = k, { visible: C, handleClose: P } = de({ emit: M, props: S, showHook: $, closeHook: G }), { handleSizeChange: A, handleCurrentChange: F, total: J, setTotalPage: O, queryPage: D } = me({ fetchHook: j }), E = _(), H = _([]), I = _(false), f = _({}), W = _([]), L = _(false), { maxHeight: z } = fe({ mainBox: ".project-execution-deepen-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], paginate: false, minHeight: 300, extraHeight: 40, clientHRepMainH: true }, E);
  async function U() {
    var l;
    I.value = true;
    try {
      const { content: i } = await pe((l = S.currentRow) == null ? void 0 : l.projectId), u = i.map((t, s) => (t.index = s + 1, t.areaList.forEach((p, g) => {
        p.index = t.index + "." + (g + 1);
      }), [t, ...t.areaList]));
      H.value = u.flat();
    } catch (i) {
      console.log(i);
    } finally {
      I.value = false;
    }
  }
  async function j() {
    var i, u, t;
    let l = [];
    L.value = true;
    try {
      const s = { monomerId: (i = f.value) == null ? void 0 : i.monomerId, areaId: (u = f.value) == null ? void 0 : u.areaId }, { content: p = [], totalElements: g } = await ce((t = S.currentRow) == null ? void 0 : t.projectId, { ...s, ...D });
      l = p, O(g);
    } catch (s) {
      console.log(s);
    } finally {
      W.value = l, L.value = false;
    }
  }
  function $() {
    U();
  }
  function G() {
  }
  function K(l) {
    f.value = l, j();
  }
  function Q({ row: l, rowIndex: i }) {
    return l.areaList ? "monomerStyle-row" : "";
  }
  function X({ row: l, rowIndex: i }) {
    return l.areaList ? "monomerStyle-row" : "";
  }
  const Y = (l) => {
    const { columns: i, data: u } = l, t = [];
    return i.forEach((s, p) => {
      if (p === 0) {
        t[p] = "合计";
        return;
      }
      if (["totalWeight", "weight"].findIndex((w) => Array.isArray(w) ? w[0] === s.property : w === s.property) > -1) {
        const y = u.filter((n) => n.areaList).map((n) => Number(n[s.property]));
        y.every((n) => Number.isNaN(n)) ? t[p] = "" : (t[p] = y.reduce((n, h) => {
          const N = Number(h);
          return Number.isNaN(N) ? n : n + h;
        }, 0), (s.property === "totalWeight" || s.property === "weight") && (t[p] = t[p].toFixed(5)));
      }
    }), t;
  };
  function Z(l) {
    return ge(l, { props: ["quantity", "productNetWeight"] });
  }
  return (l, i) => {
    const u = re, t = le, s = R("common-table"), p = ne, g = R("print-table"), B = ie, w = R("common-drawer"), y = se;
    return m(), b(w, { ref_key: "drawerRef", ref: E, title: "图纸深化进度", "close-on-click-modal": false, modelValue: d(C), "onUpdate:modelValue": i[0] || (i[0] = (n) => oe(C) ? C.value = n : null), direction: "rtl", "before-close": d(P), "wrapper-closable": false, "custom-class": "project-execution-deepen-detail", size: "100%" }, { titleAfter: a(() => [o(u, null, { default: a(() => {
      var n, h;
      return [x("项目：" + r(((n = k.currentRow) == null ? void 0 : n.projectSerialNumber) || "-") + " " + r(((h = k.currentRow) == null ? void 0 : h.projectShortName) || "-"), 1)];
    }), _: 1 })]), content: a(() => {
      var n, h, N;
      return [c("div", we, [c("div", _e, [T((m(), b(s, { ref: "tableRef", data: H.value, "max-height": d(z), "empty-text": "暂无数据", stripe: false, showEmptySymbol: false, "cell-class-name": X, "row-class-name": Q, style: { width: "100%", cursor: "pointer" }, "summary-method": Y, "show-summary": "", "highlight-current-row": "", onCurrentChange: K }, { default: a(() => [o(t, { prop: "index", label: "序号", align: "center", width: "60" }), o(t, { key: "monomerName", prop: "monomerName", "show-overflow-tooltip": "", label: "单体/区域", align: "center" }, { default: a((e) => [e.row.areaList ? (m(), v("span", ye, r(e.row.monomerName || "-"), 1)) : (m(), v("span", be, r(e.row.areaName || "-"), 1))]), _: 1 }), o(t, { key: "totalWeight", prop: "totalWeight", "show-overflow-tooltip": "", label: "合同量（吨）", align: "center" }, { default: a((e) => [e.row.areaList ? (m(), v("span", ve, r(e.row.totalWeight || "-"), 1)) : V("", true)]), _: 1 }), o(t, { key: "weight", prop: "weight", "show-overflow-tooltip": "", label: "累计完成（吨）", align: "center" }, { default: a((e) => [c("span", { class: ee({ monomerStyle: e.row.areaList }) }, r(e.row.weight || "-"), 3)]), _: 1 }), o(t, { key: "ratio", prop: "ratio", "show-overflow-tooltip": "", label: "完成率", align: "center" }, { default: a((e) => [e.row.areaList ? (m(), v("span", Ne, r((e.row.ratio * 100).toFixed(2) ?? "-") + "%", 1)) : V("", true)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[y, I.value]])]), o(p, { direction: "vertical", style: te(`height: ${d(z)}px`) }, null, 8, ["style"]), c("div", xe, [!((n = f.value) != null && n.monomerId) && !((h = f.value) != null && h.areaId) ? (m(), b(u, { key: 0, type: "info", size: "large" }, { default: a(() => i[1] || (i[1] = [x(" * 点击左侧单体/区域行，查看清单明细 ")])), _: 1, __: [1] })) : (m(), v(ae, { key: 1 }, [c("div", ke, [c("div", null, [o(u, { style: { "margin-right": "10px" } }, { default: a(() => {
        var e;
        return [x("单体：" + r(((e = f.value) == null ? void 0 : e.monomerName) || "-"), 1)];
      }), _: 1 }), (N = f.value) != null && N.areaName ? (m(), b(u, { key: 0 }, { default: a(() => {
        var e;
        return [x(" 区域：" + r(((e = f.value) == null ? void 0 : e.areaName) || "-"), 1)];
      }), _: 1 })) : V("", true)]), o(g, { "api-key": "", params: {}, size: "default", type: "warning", class: "filter-item" })]), T((m(), b(s, { ref: "infoTableRef", data: W.value, "empty-text": "暂无数据", "max-height": d(z) - 70, "summary-method": Z, "show-summary": "" }, { default: a(() => [o(t, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), o(t, { key: "productName", prop: "productName", "show-overflow-tooltip": "", label: "名称", align: "center" }, { default: a((e) => [c("span", null, r(e.row.productName || "-"), 1)]), _: 1 }), o(t, { key: "productSerialNumber", prop: "productSerialNumber", "show-overflow-tooltip": "", label: "编号", align: "center" }, { default: a((e) => [c("span", null, r(e.row.productSerialNumber || "-"), 1)]), _: 1 }), o(t, { key: "productSpecification", prop: "productSpecification", "show-overflow-tooltip": "", label: "规格", align: "center" }, { default: a((e) => [c("span", null, r(e.row.productSpecification || "-"), 1)]), _: 1 }), o(t, { key: "productLength", prop: "productLength", "show-overflow-tooltip": "", label: "长度(mm)", align: "center" }, { default: a((e) => [c("span", null, r(e.row.productLength || "-"), 1)]), _: 1 }), o(t, { key: "productMaterial", prop: "productMaterial", "show-overflow-tooltip": "", label: "材质", align: "center" }, { default: a((e) => [c("span", null, r(e.row.productMaterial || "-"), 1)]), _: 1 }), o(t, { key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "数量", align: "center" }, { default: a((e) => [c("span", null, r(e.row.quantity || "-"), 1)]), _: 1 }), o(t, { key: "productNetWeight", prop: "productNetWeight", "show-overflow-tooltip": "", label: "单净重（kg）", align: "center" }, { default: a((e) => [c("span", null, r(e.row.productNetWeight || "-"), 1)]), _: 1 }), o(t, { key: "importDate", prop: "importDate", "show-overflow-tooltip": "", label: "导入日期", align: "center" }, { default: a((e) => [c("span", null, r(e.row.importDate ? d(he)(e.row.importDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[y, L.value]]), o(B, { total: d(J), "current-page": d(D).pageNumber, "page-size": d(D).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: d(A), onCurrentChange: d(F) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])], 64))])])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Le = ue(Se, [["__scopeId", "data-v-df7167df"]]);
export {
  Le as default
};
