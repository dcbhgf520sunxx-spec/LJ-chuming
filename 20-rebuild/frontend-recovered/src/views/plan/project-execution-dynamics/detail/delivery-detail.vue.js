import { ref as _ } from "vue";
import { computed as re } from "vue";
import { resolveComponent as T } from "vue";
import { resolveDirective as le } from "vue";
import { openBlock as h } from "vue";
import { createBlock as b } from "vue";
import { withCtx as a } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as D } from "vue";
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
import { ElTag as pe } from "element-plus";
import { ElTableColumn as ue } from "element-plus";
import { ElDivider as de } from "element-plus";
import { ElPagination as me } from "element-plus";
import { vLoading as fe } from "element-plus";
import { b as he, c as ge } from "../../../../modules/project-execution-dynamics-721a6cb4.js";
import { _ as we, u as ye, J as _e, o as ve, G as S, ba as be } from "../../../../shared/runtime.js";
import { k as N } from "../../../../modules/plan-d12d7ccf.js";
const xe = { class: "wrap" }, Ne = { class: "wrap-left" }, ke = { key: 0, class: "monomerStyle" }, De = { key: 1 }, Se = { key: 0, class: "monomerStyle" }, Ie = { key: 0, class: "monomerStyle" }, Ce = { class: "wrap-right" }, Le = { class: "info-header" }, Re = { __name: "delivery-detail", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(I, { emit: F }) {
  const A = F, k = I, { visible: C, handleClose: G } = ye({ emit: A, props: k, showHook: X, closeHook: Y }), { handleSizeChange: J, handleCurrentChange: O, total: U, setTotalPage: $, queryPage: L } = _e({ fetchHook: B }), V = _(), H = _([]), R = _(false), d = _({}), W = _([]), z = _(false), { maxHeight: j } = ve({ mainBox: ".project-execution-dynamics-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], paginate: false, minHeight: 300, extraHeight: 40, clientHRepMainH: true }, () => V.value.loaded), K = re(() => {
    var r, l, c;
    return { projectId: (r = k.currentRow) == null ? void 0 : r.projectId, monomerId: (l = d.value) == null ? void 0 : l.monomerId, areaId: (c = d.value) == null ? void 0 : c.areaId };
  });
  async function Q() {
    var r;
    if (!S(N.getDelivery)) return false;
    R.value = true;
    try {
      const { content: l } = await ge((r = k.currentRow) == null ? void 0 : r.projectId), c = l.map((t, p) => (t.index = p + 1, t.areaList.forEach((u, w) => {
        u.index = t.index + "." + (w + 1);
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
    if (!S(N.getDeliveryDetail)) return false;
    let r = [];
    z.value = true;
    try {
      const p = { monomerId: (l = d.value) == null ? void 0 : l.monomerId, areaId: (c = d.value) == null ? void 0 : c.areaId }, { content: u = [], totalElements: w } = await he((t = k.currentRow) == null ? void 0 : t.projectId, { ...p, ...L });
      r = u, $(w);
    } catch (p) {
      console.log(p);
    } finally {
      W.value = r, z.value = false;
    }
  }
  function X() {
    Q();
  }
  function Y() {
  }
  function Z(r) {
    d.value = r, B();
  }
  function ee({ row: r, rowIndex: l }) {
    return r.areaList ? "monomerStyle-row" : "";
  }
  function te({ row: r, rowIndex: l }) {
    return r.areaList ? "monomerStyle-row" : "";
  }
  const ae = (r) => {
    const { columns: l, data: c } = r, t = [];
    return l.forEach((p, u) => {
      if (u === 0) {
        t[u] = "合计";
        return;
      }
      if (["totalWeight", "weight"].findIndex((y) => Array.isArray(y) ? y[0] === p.property : y === p.property) > -1) {
        const v = c.filter((m) => m.areaList).map((m) => Number(m[p.property]));
        v.every((m) => Number.isNaN(m)) ? t[u] = "" : (t[u] = v.reduce((m, f) => {
          const g = Number(f);
          return Number.isNaN(g) ? m : m + f;
        }, 0), (p.property === "totalWeight" || p.property === "weight") && (t[u] = t[u].toFixed(2)));
      }
    }), t;
  };
  function oe(r) {
    return be(r, { props: ["quantity", "productNetWeight", "productTotalNetWeight"] });
  }
  return (r, l) => {
    const c = pe, t = ue, p = T("common-table"), u = de, w = T("print-table"), q = me, y = T("common-drawer"), v = fe, m = le("permission");
    return h(), b(y, { ref_key: "drawerRef", ref: V, title: "发运进度", "close-on-click-modal": false, modelValue: s(C), "onUpdate:modelValue": l[0] || (l[0] = (f) => ce(C) ? C.value = f : null), direction: "rtl", "before-close": s(G), "wrapper-closable": false, "custom-class": "project-execution-dynamics-detail", size: "100%" }, { titleAfter: a(() => [o(c, null, { default: a(() => {
      var f, g;
      return [D("项目：" + n(((f = I.currentRow) == null ? void 0 : f.projectSerialNumber) || "-") + " " + n(((g = I.currentRow) == null ? void 0 : g.projectShortName) || "-"), 1)];
    }), _: 1 })]), content: a(() => {
      var f, g, M;
      return [i("div", xe, [i("div", Ne, [E((h(), b(p, { ref: "tableRef", data: H.value, "max-height": s(j), "empty-text": s(S)(s(N).getDelivery) ? "暂无数据" : "暂无权限", stripe: false, showEmptySymbol: false, "cell-class-name": te, "row-class-name": ee, style: { width: "100%", cursor: "pointer" }, "summary-method": ae, "show-summary": "", "highlight-current-row": "", onCurrentChange: Z }, { default: a(() => [o(t, { prop: "index", label: "序号", align: "center", width: "60" }), o(t, { key: "monomerName", prop: "monomerName", "show-overflow-tooltip": "", label: "单体/区域", align: "center" }, { default: a((e) => [e.row.areaList ? (h(), x("span", ke, n(e.row.monomerName || "-"), 1)) : (h(), x("span", De, n(e.row.areaName || "-"), 1))]), _: 1 }), o(t, { key: "totalWeight", prop: "totalWeight", "show-overflow-tooltip": "", label: "深化量（吨）", align: "center" }, { default: a((e) => [e.row.areaList ? (h(), x("span", Se, n(e.row.totalWeight.toFixed(2) ?? "-"), 1)) : P("", true)]), _: 1 }), o(t, { key: "weight", prop: "weight", "show-overflow-tooltip": "", label: "已发运（吨）", align: "center" }, { default: a((e) => [i("span", { class: ne({ monomerStyle: e.row.areaList }) }, n(e.row.weight.toFixed(2) ?? "-"), 3)]), _: 1 }), o(t, { key: "ratio", prop: "ratio", "show-overflow-tooltip": "", label: "完成率", align: "center" }, { default: a((e) => [e.row.areaList ? (h(), x("span", Ie, n((e.row.ratio * 100).toFixed(2) ?? "-") + "%", 1)) : P("", true)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "empty-text"])), [[v, R.value]])]), o(u, { direction: "vertical", style: ie(`height: ${s(j)}px`) }, null, 8, ["style"]), i("div", Ce, [!((f = d.value) != null && f.monomerId) && !((g = d.value) != null && g.areaId) ? (h(), b(c, { key: 0, type: "info", size: "large" }, { default: a(() => l[1] || (l[1] = [D(" * 点击左侧单体/区域行，查看清单明细 ")])), _: 1, __: [1] })) : (h(), x(se, { key: 1 }, [i("div", Le, [i("div", null, [o(c, { style: { "margin-right": "10px" } }, { default: a(() => {
        var e;
        return [D("单体：" + n(((e = d.value) == null ? void 0 : e.monomerName) || "-"), 1)];
      }), _: 1 }), (M = d.value) != null && M.areaName ? (h(), b(c, { key: 0 }, { default: a(() => {
        var e;
        return [D(" 区域：" + n(((e = d.value) == null ? void 0 : e.areaName) || "-"), 1)];
      }), _: 1 })) : P("", true)]), E(o(w, { "api-key": "deliveryDetailPrint", params: K.value, disabled: !W.value.length, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params", "disabled"]), [[m, s(N).deliveryDetailPrint]])]), E((h(), b(p, { ref: "infoTableRef", data: W.value, "empty-text": s(S)(s(N).getDeliveryDetail) ? "暂无数据" : "暂无权限", "max-height": s(j) - 70, "summary-method": oe, "show-summary": "" }, { default: a(() => [o(t, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), o(t, { key: "productName", prop: "productName", "show-overflow-tooltip": "", label: "名称", align: "center" }, { default: a((e) => [i("span", null, n(e.row.productName || "-"), 1)]), _: 1 }), o(t, { key: "productSerialNumber", prop: "productSerialNumber", "show-overflow-tooltip": "", label: "编号", align: "center" }, { default: a((e) => [i("span", null, n(e.row.productSerialNumber || "-"), 1)]), _: 1 }), o(t, { key: "productSpecification", prop: "productSpecification", "show-overflow-tooltip": "", label: "规格", align: "center", "min-width": "120" }, { default: a((e) => [i("span", null, n(e.row.productSpecification || "-"), 1)]), _: 1 }), o(t, { key: "productLength", prop: "productLength", "show-overflow-tooltip": "", label: "长度(mm)", align: "center", width: "90" }, { default: a((e) => [i("span", null, n(e.row.productLength ?? "-"), 1)]), _: 1 }), o(t, { key: "productMaterial", prop: "productMaterial", "show-overflow-tooltip": "", label: "材质", align: "center", width: "120" }, { default: a((e) => [i("span", null, n(e.row.productMaterial || "-"), 1)]), _: 1 }), o(t, { key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "数量", align: "center", width: "90" }, { default: a((e) => [i("span", null, n(e.row.quantity ?? "-"), 1)]), _: 1 }), o(t, { key: "productNetWeight", prop: "productNetWeight", "show-overflow-tooltip": "", label: "单净重（kg）", align: "center", width: "120" }, { default: a((e) => [i("span", null, n(e.row.productNetWeight ?? "-"), 1)]), _: 1 }), o(t, { key: "productTotalNetWeight", prop: "productTotalNetWeight", "show-overflow-tooltip": "", label: "总净重（kg）", align: "center", width: "120" }, { default: a((e) => [i("span", null, n(e.row.productTotalNetWeight ?? "-"), 1)]), _: 1 }), o(t, { key: "importDate", prop: "importDate", "show-overflow-tooltip": "", label: "发运日期", align: "center", width: "120" }, { default: a((e) => [i("span", null, n(e.row.importDate || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[v, z.value]]), o(q, { total: s(U), "current-page": s(L).pageNumber, "page-size": s(L).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: s(J), onCurrentChange: s(O) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])], 64))])])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ee = we(Re, [["__scopeId", "data-v-b11e9eb7"]]);
export {
  Ee as default
};
