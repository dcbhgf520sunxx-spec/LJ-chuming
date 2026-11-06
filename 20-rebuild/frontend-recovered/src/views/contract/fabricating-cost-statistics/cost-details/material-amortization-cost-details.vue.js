import { ref as L } from "vue";
import { inject as K } from "vue";
import { resolveComponent as M } from "vue";
import { openBlock as e } from "vue";
import { createBlock as V } from "vue";
import { withCtx as l } from "vue";
import { withDirectives as Q } from "vue";
import { unref as _ } from "vue";
import { createVNode as y } from "vue";
import { createElementBlock as r } from "vue";
import { normalizeClass as X } from "vue";
import { toDisplayString as w } from "vue";
import { createCommentVNode as s } from "vue";
import { isRef as Z } from "vue";
import { ElTableColumn as tt } from "element-plus";
import { vLoading as ot } from "element-plus";
import { _ as et, u as at, o as nt, bs as N, bV as b, cO as P, jl as H, D as k, cH as rt } from "../../../../shared/runtime.js";
import { a as lt } from "../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../modules/model-0ac957f7.js";
const ut = { key: 0 }, it = { key: 0 }, st = { key: 0 }, wt = { key: 0 }, dt = { key: 0 }, mt = { key: 0 }, ct = { key: 0 }, ft = { key: 0 }, yt = { key: 0, style: { color: "red" } }, pt = { key: 1 }, gt = { key: 2 }, ht = { key: 0, style: { color: "red" } }, _t = { key: 1 }, bt = { key: 0, style: { color: "red" } }, Ct = { key: 1 }, Rt = { key: 0 }, kt = { key: 0 }, vt = { __name: "material-amortization-cost-details", props: { visible: { type: Boolean, require: true }, data: { type: Array, default: () => [] } }, emits: ["update:visible"], setup(Y, { emit: z }) {
  const F = z, S = Y, U = L(), v = K("query"), x = L([]), E = L(false), { visible: A, handleClose: O } = at({ emit: F, props: S, field: "visible", showHook: J, closeHook: G }), { maxHeight: W } = nt({ mainBox: ".reporting-approval-parts-summary-list", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, U);
  async function j() {
    try {
      E.value = true, x.value = [], JSON.parse(JSON.stringify(S.data)).forEach(async (o, n) => {
        var t, I, T, q, D, B;
        let d = 0, m = 0, c = 0, h = 0, g = [], i = [];
        (t = o.outboundList) != null && t.length ? (await P(o.outboundList, { multipleSpec: true }), g = await H(o.outboundList, { toSmallest: false, toNum: true }, { quantity: ["quantityCount"], mete: ["meteCount"] }), d = g.reduce((a, p) => a + +p.meteCount, 0), m = g.reduce((a, p) => a + (v.boolTaxIncluded ? +p.amountCount : +p.amountExcludingVatCount), 0), g.forEach((a, p) => {
          a.index = p + 1;
        }), (g == null ? void 0 : g.length) > 0 && o.outboundList.push({ totalRow: true, type: "小计", meteCount: N(d, 3) || 0, amountCount: b(m, k.YUAN), amountExcludingVatCount: b(m, k.YUAN) })) : g = [], (I = o.returnList) != null && I.length ? (await P(o.returnList, { multipleSpec: true }), i = await H(o.returnList, { toSmallest: false, toNum: true }, { quantity: ["quantityCount"], mete: ["meteCount"] }), i.forEach((a) => {
          a.meteCount = a.meteCount && -a.meteCount, a.amountCount = a.amountCount && -a.amountCount, a.amountExcludingVatCount = a.amountExcludingVatCount && -a.amountExcludingVatCount;
        }), c = i.reduce((a, p) => a + +p.meteCount, 0), h = i.reduce((a, p) => a + (v.boolTaxIncluded ? +p.amountCount : +p.amountExcludingVatCount), 0), i.forEach((a, p) => {
          a.index = p + 1;
        }), (i == null ? void 0 : i.length) > 0 && o.returnList.push({ totalRow: true, type: "小计", meteCount: N(c, 3) || 0, amountCount: b(h, k.YUAN), amountExcludingVatCount: b(h, k.YUAN) })) : o.returnList = [];
        const C = { index: rt(n + 1), titleRow: true, yearMonth: ((q = (T = o.outboundList) == null ? void 0 : T[0]) == null ? void 0 : q.yearMonth) || ((B = (D = o.returnList) == null ? void 0 : D[0]) == null ? void 0 : B.yearMonth) || "-" }, f = { totalRow: true, type: "月合计", meteCount: N(d + c, 3), amountCount: b(m + h, k.YUAN), amountExcludingVatCount: b(m + h, k.YUAN) }, R = [C, ...o.outboundList || [], ...o.returnList || [], f];
        x.value.push(...R);
      });
    } catch (u) {
      console.log(u);
    } finally {
      E.value = false;
    }
  }
  function J() {
    j();
  }
  const $ = (u) => {
    const { columns: o, data: n } = u, d = [];
    return o.forEach((m, c) => {
      if (c === 0) {
        d[c] = "总合计";
        return;
      }
      if (["meteCount", "amountCount", "amountExcludingVatCount"].findIndex((i) => Array.isArray(i) ? i[0] === m.property : i === m.property) > -1) {
        const C = n.filter((f) => !f.titleRow && !f.totalRow).map((f) => Number(f[m.property]));
        C.every((f) => Number.isNaN(f)) ? d[c] = "" : (d[c] = C.reduce((f, R) => {
          const t = Number(R);
          return Number.isNaN(t) ? f : f + R;
        }, 0), (m.property === "amountCount" || m.property === "amountExcludingVatCount") && (d[c] = b(d[c], k.YUAN)), m.property === "meteCount" && (d[c] = N(d[c], 3)));
      }
    }), d;
  };
  function G() {
    x.value = [];
  }
  return (u, o) => {
    const n = tt, d = M("common-table"), m = M("common-dialog"), c = ot;
    return e(), V(m, { ref_key: "dialogRef", ref: U, title: "辅材明细", modelValue: _(A), "onUpdate:modelValue": o[1] || (o[1] = (h) => Z(A) ? A.value = h : null), width: "70%", "before-close": _(O), "show-close": true, top: "5vh", "custom-class": "reporting-approval-parts-summary-list" }, { titleAfter: l(() => o[2] || (o[2] = [])), default: l(() => {
      var h, g, i, C, f, R;
      return [Q((e(), V(d, { ref: "tableRef", data: x.value, "max-height": _(W), "data-format": u.columnsDataFormat, "summary-method": $, "show-summary": "", showEmptySymbol: false, stripe: false, "cell-class-name": u.cellClassName, "row-class-name": u.handleRowClassName }, { default: l(() => [y(n, { prop: "index", key: "index", label: "序号", align: "center", fixed: "left" }), y(n, { "show-overflow-tooltip": "", prop: "yearMonth", key: "yearMonth", label: "出/退库日期", align: "center" }, { default: l((t) => [t.row.totalRow ? s("", true) : (e(), r("span", { key: 0, class: X([t.row.titleRow ? "blod" : ""]) }, w(t.row.yearMonth || "-"), 3))]), _: 1 }), y(n, { "show-overflow-tooltip": "", prop: "type", key: "type", label: "类型", align: "center" }, { default: l((t) => [t.row.titleRow ? s("", true) : (e(), r("span", ut, w(t.row.type || "-"), 1))]), _: 1 }), y(n, { "show-overflow-tooltip": "", prop: "classifyName", key: "classifyName", label: "物料种类", align: "center" }, { default: l((t) => [!t.row.titleRow && !t.row.totalRow ? (e(), r("span", it, w(t.row.classifyName || "-"), 1)) : s("", true)]), _: 1 }), y(n, { "show-overflow-tooltip": "", prop: "specification", key: "specification", label: "规格", align: "center" }, { default: l((t) => [!t.row.titleRow && !t.row.totalRow ? (e(), r("span", st, w(t.row.specification || "-"), 1)) : s("", true)]), _: 1 }), y(n, { "show-overflow-tooltip": "", prop: "model", key: "model", label: "材质", align: "center" }, { default: l((t) => [!t.row.titleRow && !t.row.totalRow ? (e(), r("span", wt, w(t.row.model || "-"), 1)) : s("", true)]), _: 1 }), y(n, { "show-overflow-tooltip": "", prop: "measureUnit", key: "measureUnit", label: "计量单位", align: "center" }, { default: l((t) => [!t.row.titleRow && !t.row.totalRow ? (e(), r("span", dt, w(t.row.measureUnit || "-"), 1)) : s("", true)]), _: 1 }), y(n, { "show-overflow-tooltip": "", prop: "quantityCount", key: "quantityCount", label: "数量", align: "center" }, { default: l((t) => [!t.row.titleRow && !t.row.totalRow ? (e(), r("span", mt, w(t.row.quantityCount || t.row.quantityCount === 0 ? t.row.quantityCount : "-"), 1)) : s("", true)]), _: 1 }), y(n, { "show-overflow-tooltip": "", prop: "accountingUnit", key: "accountingUnit", label: "核算单位", align: "center" }, { default: l((t) => [!t.row.titleRow && !t.row.totalRow ? (e(), r("span", ct, w(t.row.accountingUnit || "-"), 1)) : s("", true)]), _: 1 }), y(n, { "show-overflow-tooltip": "", prop: "meteCount", key: "meteCount", label: "核算量", align: "center" }, { default: l((t) => [t.row.titleRow ? s("", true) : (e(), r("span", ft, w(t.row.meteCount || t.row.meteCount === 0 ? _(N)(t.row.meteCount, 3) : "-"), 1))]), _: 1 }), y(n, { "show-overflow-tooltip": "", prop: "unitPrice", key: "unitPrice", label: "单价(元)", align: "center" }, { default: l((t) => [!t.row.titleRow && !t.row.totalRow && !t.row.boolWeighting ? (e(), r("span", yt, " 未月末加权 ")) : !t.row.titleRow && !t.row.totalRow && _(v).boolTaxIncluded ? (e(), r("span", pt, w(t.row.unitPrice || t.row.unitPrice === 0 ? _(b)(t.row.unitPrice, 3) : "-"), 1)) : !t.row.titleRow && !t.row.totalRow && !_(v).boolTaxIncluded ? (e(), r("span", gt, w(t.row.unitPriceExcludingVAT || t.row.unitPriceExcludingVAT === 0 ? _(b)(t.row.unitPriceExcludingVAT, 3) : "-"), 1)) : s("", true)]), _: 1 }), _(v).boolTaxIncluded ? (e(), V(n, { "show-overflow-tooltip": "", prop: "amountCount", key: "amountCount", label: "金额", align: "center" }, { default: l((t) => [!t.row.titleRow && !t.row.totalRow && !t.row.boolWeighting ? (e(), r("span", ht, " 未月末加权 ")) : t.row.titleRow ? s("", true) : (e(), r("span", _t, w(t.row.amountCount || t.row.amountCount === 0 ? t.row.amountCount : "-"), 1))]), _: 1 })) : s("", true), _(v).boolTaxIncluded ? s("", true) : (e(), V(n, { "show-overflow-tooltip": "", prop: "amountExcludingVatCount", key: "amountExcludingVatCount", label: "金额", align: "center" }, { default: l((t) => [!t.row.titleRow && !t.row.totalRow && !t.row.boolWeighting ? (e(), r("span", bt, " 未月末加权 ")) : t.row.titleRow ? s("", true) : (e(), r("span", Ct, w(t.row.amountExcludingVatCount || t.row.amountExcludingVatCount === 0 ? t.row.amountExcludingVatCount : "-"), 1))]), _: 1 })), y(n, { "show-overflow-tooltip": "", prop: "serialNumber", key: "serialNumber", label: "出/退库单据号", align: "center", width: "140px" }, { default: l((t) => [!t.row.titleRow && !t.row.totalRow ? (e(), r("span", Rt, w(t.row.serialNumber || "-"), 1)) : s("", true)]), _: 1 }), y(n, { "show-overflow-tooltip": "", prop: "workshopName", key: "workshopName", label: "领用车间", align: "center" }, { default: l((t) => [!t.row.titleRow && !t.row.totalRow ? (e(), r("span", kt, w(t.row.workshopName || "-"), 1)) : s("", true)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "data-format", "cell-class-name", "row-class-name"])), [[c, E.value]]), y(_(lt), { modelValue: u.showDrawing, "onUpdate:modelValue": o[0] || (o[0] = (t) => u.showDrawing = t), drawingSN: (h = u.drawingRow) == null ? void 0 : h.drawingSN, "bool-bim": (g = u.drawingRow) == null ? void 0 : g.boolBim, "serial-number": (i = u.drawingRow) == null ? void 0 : i.serialNumber, productId: (C = u.drawingRow) == null ? void 0 : C.productId, productType: (f = u.drawingRow) == null ? void 0 : f.productType, "monomer-id": (R = u.drawingRow) == null ? void 0 : R.monomerId }, null, 8, ["modelValue", "drawingSN", "bool-bim", "serial-number", "productId", "productType", "monomer-id"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Lt = et(vt, [["__scopeId", "data-v-180be141"]]);
export {
  Lt as default
};
