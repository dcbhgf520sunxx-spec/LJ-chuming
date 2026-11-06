import { ref as c } from "vue";
import { inject as A } from "vue";
import { computed as J } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as $ } from "vue";
import { openBlock as B } from "vue";
import { createBlock as U } from "vue";
import { withCtx as o } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as G } from "vue";
import { createElementVNode as n } from "vue";
import { toDisplayString as i } from "vue";
import { unref as t } from "vue";
import { withDirectives as V } from "vue";
import { isRef as K } from "vue";
import { ElTag as Q } from "element-plus";
import { ElTableColumn as W } from "element-plus";
import { ElPagination as X } from "element-plus";
import { vLoading as Y } from "element-plus";
import { g as Z } from "../../../../../modules/product-statistics-2cabaaff.js";
import { nz as d, u as ee, J as te, am as ae, o as oe, cO as ne, jl as le, p as se } from "../../../../../shared/runtime.js";
const ie = { class: "head-drawer", style: { display: "flex", "justify-content": "space-between", "margin-bottom": "8px" } }, ce = { __name: "total-raw-material-outbound", props: { visible: { type: Boolean, default: false }, info: { type: Object } }, emits: ["update:visible"], setup(f, { emit: T }) {
  const h = c(), u = c(d.OUTBOUND.V), k = T, y = f, z = A("permission"), { visible: g, handleClose: O } = ee({ emit: k, props: y, field: "visible", showHook: w }), { handleSizeChange: N, handleCurrentChange: j, total: S, setTotalPage: E, queryPage: _ } = te({ fetchHook: w }), D = c([["basicClass", ["parse-enum", ae, { bit: true }]]]), { maxHeight: H } = oe({ extraBox: [".el-drawer__header", ".head-drawer"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, h), b = c(false), p = c([]), C = J(() => {
    var r;
    return { projectId: (r = y.info.project) == null ? void 0 : r.id, type: u.value };
  });
  async function w() {
    try {
      p.value = [], b.value = true;
      const { content: r = [], totalElements: l } = await Z({ ...C.value, ..._ });
      E(l), p.value = r.map((v) => v), await ne(p.value), await le(p.value, { toSmallest: false, accountingUnit: "kg", toNum: false });
    } catch (r) {
      console.log("获取出库记录详情失败", r);
    } finally {
      b.value = false;
    }
  }
  return (r, l) => {
    const v = Q, L = m("common-radio-button"), M = m("print-table"), s = W, R = m("common-table"), q = X, P = m("common-drawer"), I = $("permission"), F = Y;
    return B(), U(P, { ref_key: "drawerRef", ref: h, title: "累计出库记录", modelValue: t(g), "onUpdate:modelValue": l[1] || (l[1] = (e) => K(g) ? g.value = e : null), direction: "rtl", "before-close": t(O), size: "70%" }, { titleAfter: o(() => [a(v, { size: "default", effect: "plain" }, { default: o(() => {
      var e, x;
      return [l[2] || (l[2] = G(" 项目：")), n("span", null, i((e = f.info.project) == null ? void 0 : e.serialNumber) + "-" + i((x = f.info.project) == null ? void 0 : x.name), 1)];
    }), _: 1, __: [2] })]), content: o(() => [n("div", ie, [a(L, { modelValue: u.value, "onUpdate:modelValue": l[0] || (l[0] = (e) => u.value = e), options: t(d).ENUM, class: "filter-item", type: "enum", onChange: w }, null, 8, ["modelValue", "options"]), n("div", null, [V(a(M, { "api-key": u.value === t(d).OUTBOUND.V ? "mesOutBoundStatisticsList" : "mesBackBoundStatisticsList", params: { ...C.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"]), [[I, t(z).print]])])]), V((B(), U(R, { data: p.value, "data-format": D.value, "max-height": t(H), style: { width: "100%" } }, { default: o(() => [a(s, { label: "序号", type: "index", align: "center", width: "60" }), a(s, { prop: "basicClass", "show-overflow-tooltip": true, label: "物料种类", width: "150" }), a(s, { "show-overflow-tooltip": true, key: "specMerge", prop: "specMerge", label: "规格", align: "center" }, { default: o((e) => [n("span", null, i(e.row.specMerge), 1)]), _: 1 }), a(s, { "show-overflow-tooltip": true, align: "center", prop: "measureUnit", label: "计量单位" }, { default: o(({ row: e }) => [n("span", null, i(e.measureUnit), 1)]), _: 1 }), a(s, { "show-overflow-tooltip": true, align: "center", prop: "quantity", label: "数量" }, { default: o(({ row: e }) => [n("span", null, i(e.quantity), 1)]), _: 1 }), a(s, { "show-overflow-tooltip": true, align: "center", prop: "accountingUnit", label: "核算单位", width: "120" }, { default: o(({ row: e }) => [n("span", null, i(e.accountingUnit), 1)]), _: 1 }), a(s, { "show-overflow-tooltip": true, align: "center", prop: "mete", label: "核算量", width: "100" }, { default: o(({ row: e }) => [n("span", null, i(e.mete), 1)]), _: 1 }), a(s, { "show-overflow-tooltip": true, align: "center", prop: "outboundTime", label: `${u.value === t(d).OUTBOUND.V ? "出库" : "退库"}日期`, width: "120" }, { default: o(({ row: e }) => [n("span", null, i(t(se)(e.outboundTime, "{y}-{m}-{d}")), 1)]), _: 1 }, 8, ["label"])]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[F, b.value]]), a(q, { total: t(S), "current-page": t(_).pageNumber, "page-size": t(_).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(N), onCurrentChange: t(j) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ce as default
};
