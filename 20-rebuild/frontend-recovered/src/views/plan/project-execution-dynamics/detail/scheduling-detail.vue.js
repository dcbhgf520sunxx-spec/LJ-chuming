import { ref as y } from "vue";
import { computed as re } from "vue";
import { resolveComponent as T } from "vue";
import { resolveDirective as le } from "vue";
import { openBlock as f } from "vue";
import { createBlock as b } from "vue";
import { withCtx as a } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as S } from "vue";
import { toDisplayString as n } from "vue";
import { createElementVNode as i } from "vue";
import { withDirectives as E } from "vue";
import { unref as s } from "vue";
import { createElementBlock as x } from "vue";
import { createCommentVNode as P } from "vue";
import { normalizeClass as ne } from "vue";
import { normalizeStyle as ie } from "vue";
import { Fragment as se } from "vue";
import { isRef as ce } from "vue";
import { ElTag as ue } from "element-plus";
import { ElTableColumn as de } from "element-plus";
import { ElDivider as pe } from "element-plus";
import { ElPagination as me } from "element-plus";
import { vLoading as he } from "element-plus";
import { i as fe, j as ge } from "../../../../modules/project-execution-dynamics-721a6cb4.js";
import { _ as we, u as _e, J as ye, o as ve, G as I, ba as be } from "../../../../shared/runtime.js";
import { k as N } from "../../../../modules/plan-d12d7ccf.js";
const xe = { class: "wrap" }, Ne = { class: "wrap-left" }, ke = { key: 0, class: "monomerStyle" }, Se = { key: 1 }, Ie = { key: 0, class: "monomerStyle" }, Ce = { key: 0, class: "monomerStyle" }, De = { class: "wrap-right" }, Le = { class: "info-header" }, Re = { __name: "scheduling-detail", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(C, { emit: F }) {
  const A = F, k = C, { visible: D, handleClose: G } = _e({ emit: A, props: k, showHook: X, closeHook: Y }), { handleSizeChange: J, handleCurrentChange: O, total: U, setTotalPage: $, queryPage: L } = ye({ fetchHook: B }), V = y(), H = y([]), R = y(false), p = y({}), W = y([]), j = y(false), { maxHeight: z } = ve({ mainBox: ".project-execution-scheduling-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], paginate: false, minHeight: 300, extraHeight: 40, clientHRepMainH: true }, () => V.value.loaded), K = re(() => {
    var r, l, c;
    return { projectId: (r = k.currentRow) == null ? void 0 : r.projectId, monomerId: (l = p.value) == null ? void 0 : l.monomerId, areaId: (c = p.value) == null ? void 0 : c.areaId };
  });
  async function Q() {
    var r;
    if (!I(N.getScheduling)) return false;
    R.value = true;
    try {
      const { content: l } = await ge((r = k.currentRow) == null ? void 0 : r.projectId), c = l.map((t, u) => (t.index = u + 1, t.areaList.forEach((d, w) => {
        d.index = t.index + "." + (w + 1);
      }), [t, ...t.areaList]));
      H.value = c.flat();
    } catch (l) {
      console.log(l);
    } finally {
      R.value = false;
    }
  }
  async function B() {
    var l, c, t;
    if (!I(N.getSchedulingDetail)) return false;
    let r = [];
    j.value = true;
    try {
      const u = { monomerId: (l = p.value) == null ? void 0 : l.monomerId, areaId: (c = p.value) == null ? void 0 : c.areaId }, { content: d = [], totalElements: w } = await fe((t = k.currentRow) == null ? void 0 : t.projectId, { ...u, ...L });
      r = d, $(w);
    } catch (u) {
      console.log(u);
    } finally {
      W.value = r, j.value = false;
    }
  }
  function X() {
    Q();
  }
  function Y() {
  }
  function Z(r) {
    p.value = r, B();
  }
  function ee({ row: r, rowIndex: l }) {
    return r.areaList ? "monomerStyle-row" : "";
  }
  function te({ row: r, rowIndex: l }) {
    return r.areaList ? "monomerStyle-row" : "";
  }
  const ae = (r) => {
    const { columns: l, data: c } = r, t = [];
    return l.forEach((u, d) => {
      if (d === 0) {
        t[d] = "合计";
        return;
      }
      if (["totalWeight", "weight"].findIndex((_) => Array.isArray(_) ? _[0] === u.property : _ === u.property) > -1) {
        const v = c.filter((m) => m.areaList).map((m) => Number(m[u.property]));
        v.every((m) => Number.isNaN(m)) ? t[d] = "" : (t[d] = v.reduce((m, h) => {
          const g = Number(h);
          return Number.isNaN(g) ? m : m + h;
        }, 0), (u.property === "totalWeight" || u.property === "weight") && (t[d] = t[d].toFixed(2)));
      }
    }), t;
  };
  function oe(r) {
    return be(r, { props: ["quantity", "productNetWeight", "productTotalNetWeight"] });
  }
  return (r, l) => {
    const c = ue, t = de, u = T("common-table"), d = pe, w = T("print-table"), q = me, _ = T("common-drawer"), v = he, m = le("permission");
    return f(), b(_, { ref_key: "drawerRef", ref: V, title: "排产进度", "close-on-click-modal": false, modelValue: s(D), "onUpdate:modelValue": l[0] || (l[0] = (h) => ce(D) ? D.value = h : null), direction: "rtl", "before-close": s(G), "wrapper-closable": false, "custom-class": "project-execution-scheduling-detail", size: "100%" }, { titleAfter: a(() => [o(c, null, { default: a(() => {
      var h, g;
      return [S("项目：" + n(((h = C.currentRow) == null ? void 0 : h.projectSerialNumber) || "-") + " " + n(((g = C.currentRow) == null ? void 0 : g.projectShortName) || "-"), 1)];
    }), _: 1 })]), content: a(() => {
      var h, g, M;
      return [i("div", xe, [i("div", Ne, [E((f(), b(u, { ref: "tableRef", data: H.value, "max-height": s(z), "empty-text": s(I)(s(N).getScheduling) ? "暂无数据" : "暂无权限", stripe: false, showEmptySymbol: false, "cell-class-name": te, "row-class-name": ee, style: { width: "100%", cursor: "pointer" }, "summary-method": ae, "show-summary": "", "highlight-current-row": "", onCurrentChange: Z }, { default: a(() => [o(t, { prop: "index", label: "序号", align: "center", width: "60" }), o(t, { key: "monomerName", prop: "monomerName", "show-overflow-tooltip": "", label: "单体/区域", align: "center" }, { default: a((e) => [e.row.areaList ? (f(), x("span", ke, n(e.row.monomerName || "-"), 1)) : (f(), x("span", Se, n(e.row.areaName || "-"), 1))]), _: 1 }), o(t, { key: "totalWeight", prop: "totalWeight", "show-overflow-tooltip": "", label: "深化量（吨）", align: "center" }, { default: a((e) => [e.row.areaList ? (f(), x("span", Ie, n(e.row.totalWeight.toFixed(2) ?? "-"), 1)) : P("", true)]), _: 1 }), o(t, { key: "weight", prop: "weight", "show-overflow-tooltip": "", label: "已排产（吨）", align: "center" }, { default: a((e) => [i("span", { class: ne({ monomerStyle: e.row.areaList }) }, n(e.row.weight.toFixed(2) ?? "-"), 3)]), _: 1 }), o(t, { key: "ratio", prop: "ratio", "show-overflow-tooltip": "", label: "完成率", align: "center" }, { default: a((e) => [e.row.areaList ? (f(), x("span", Ce, n((e.row.ratio * 100).toFixed(2) ?? "-") + "%", 1)) : P("", true)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "empty-text"])), [[v, R.value]])]), o(d, { direction: "vertical", style: ie(`height: ${s(z)}px`) }, null, 8, ["style"]), i("div", De, [!((h = p.value) != null && h.monomerId) && !((g = p.value) != null && g.areaId) ? (f(), b(c, { key: 0, type: "info", size: "large" }, { default: a(() => l[1] || (l[1] = [S(" * 点击左侧单体/区域行，查看清单明细 ")])), _: 1, __: [1] })) : (f(), x(se, { key: 1 }, [i("div", Le, [i("div", null, [o(c, { style: { "margin-right": "10px" } }, { default: a(() => {
        var e;
        return [S("单体：" + n(((e = p.value) == null ? void 0 : e.monomerName) || "-"), 1)];
      }), _: 1 }), (M = p.value) != null && M.areaName ? (f(), b(c, { key: 0 }, { default: a(() => {
        var e;
        return [S(" 区域：" + n(((e = p.value) == null ? void 0 : e.areaName) || "-"), 1)];
      }), _: 1 })) : P("", true)]), E(o(w, { "api-key": "schedulingDetailPrint", params: K.value, disabled: !W.value.length, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params", "disabled"]), [[m, s(N).schedulingDetailPrint]])]), E((f(), b(u, { ref: "infoTableRef", data: W.value, "empty-text": s(I)(s(N).getSchedulingDetail) ? "暂无数据" : "暂无权限", "max-height": s(z) - 70, "summary-method": oe, "show-summary": "" }, { default: a(() => [o(t, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), o(t, { key: "productName", prop: "productName", "show-overflow-tooltip": "", label: "名称", align: "center" }, { default: a((e) => [i("span", null, n(e.row.productName || "-"), 1)]), _: 1 }), o(t, { key: "productSerialNumber", prop: "productSerialNumber", "show-overflow-tooltip": "", label: "编号", align: "center" }, { default: a((e) => [i("span", null, n(e.row.productSerialNumber || "-"), 1)]), _: 1 }), o(t, { key: "productSpecification", prop: "productSpecification", "show-overflow-tooltip": "", label: "规格", align: "center", "min-width": "120" }, { default: a((e) => [i("span", null, n(e.row.productSpecification || "-"), 1)]), _: 1 }), o(t, { key: "productLength", prop: "productLength", "show-overflow-tooltip": "", label: "长度(mm)", align: "center", width: "90" }, { default: a((e) => [i("span", null, n(e.row.productLength ?? "-"), 1)]), _: 1 }), o(t, { key: "productMaterial", prop: "productMaterial", "show-overflow-tooltip": "", label: "材质", align: "center", width: "100" }, { default: a((e) => [i("span", null, n(e.row.productMaterial || "-"), 1)]), _: 1 }), o(t, { key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "数量", align: "center", width: "90" }, { default: a((e) => [i("span", null, n(e.row.quantity ?? "-"), 1)]), _: 1 }), o(t, { key: "productNetWeight", prop: "productNetWeight", "show-overflow-tooltip": "", label: "单净重（kg）", align: "center", width: "120" }, { default: a((e) => [i("span", null, n(e.row.productNetWeight ?? "-"), 1)]), _: 1 }), o(t, { key: "productTotalNetWeight", prop: "productTotalNetWeight", "show-overflow-tooltip": "", label: "总净重（kg）", align: "center", width: "120" }, { default: a((e) => [i("span", null, n(e.row.productTotalNetWeight ?? "-"), 1)]), _: 1 }), o(t, { key: "importDate", prop: "importDate", "show-overflow-tooltip": "", label: "排产日期", align: "center", width: "120" }, { default: a((e) => [i("span", null, n(e.row.importDate || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[v, j.value]]), o(q, { total: s(U), "current-page": s(L).pageNumber, "page-size": s(L).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: s(J), onCurrentChange: s(O) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])], 64))])])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ee = we(Re, [["__scopeId", "data-v-f1332598"]]);
export {
  Ee as default
};
