import { ref as u } from "vue";
import { computed as M } from "vue";
import { watch as S } from "vue";
import { resolveComponent as P } from "vue";
import { openBlock as w } from "vue";
import { createElementBlock as V } from "vue";
import { createCommentVNode as U } from "vue";
import { withDirectives as $ } from "vue";
import { createBlock as z } from "vue";
import { withCtx as n } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as b } from "vue";
import { unref as o } from "vue";
import { toDisplayString as G } from "vue";
import { ElTableColumn as K } from "element-plus";
import { InfoFilled as O } from "@element-plus/icons-vue";
import { ElIcon as j } from "element-plus";
import { ElTooltip as J } from "element-plus";
import { vLoading as Q } from "element-plus";
import { u as X } from "../../../../../modules/use-drawing-8a7ba23b.js";
import { _ as Y, a3 as B } from "../../../../../shared/runtime.js";
import { b as Z } from "../../../../../modules/bim-preview-drawer-7ca7893b.js";
import { a as ee } from "../../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../../modules/model-0ac957f7.js";
import "../../../../../modules/index-d6a37d29.js";
import "../../../../../modules/use-chart-59e4b63c.js";
import "../../../../../modules/index-18acf776.js";
const oe = { key: 0, style: { color: "red", "font-size": "12px", "margin-top": "5px" } }, te = { style: { display: "inline-block" } }, ae = ["onDblclick"], le = { __name: "repeat-detail", props: { data: { type: Array, default: () => [] }, maxHeight: { type: [String, Number], default: void 0 } }, setup(c) {
  const R = c, E = u(false), F = u(), p = u(false), s = u(false), A = M(() => [["netWeight", ["to-fixed-ck", "COM_WT__KG"]]]), { showDrawing: f, drawingRow: e, drawingPreview: W } = X({ pidField: "id", typeField: "productType" });
  return S([() => p.value, () => s.value], ([i, a]) => {
    !i && !a && (f.value = false), console.log(i, a, f.value, "show");
  }), S(() => f.value, (i) => {
    var a, l, m, d;
    i && ((a = e.value) != null && a.productType && ((l = e.value) == null ? void 0 : l.productType) & B.ARTIFACT.V && (p.value = true), (m = e.value) != null && m.productType && !(((d = e.value) == null ? void 0 : d.productType) & B.ARTIFACT.V) && (s.value = true));
  }), (i, a) => {
    var _, g, v, y, h, k, x, N, T, D, I, C;
    const l = K, m = O, d = j, q = J, H = P("common-table"), L = Q;
    return w(), V("div", null, [c.data.length > 0 ? (w(), V("div", oe, "*您当前导入的清单与之前清单有重复，请确认！")) : U("", true), $((w(), z(H, { ref_key: "serialNumberRef", ref: F, data: R.data, "max-height": c.maxHeight - 80, "data-format": A.value, style: { margin: "5px 0" }, onRowDblclick: i.dbclick, s: "" }, { default: n(() => [t(l, { type: "index", label: "序号", align: "center", width: "80" }), t(l, { key: "name", prop: "name", "show-overflow-tooltip": "", label: "名称" }), t(l, { key: "serialNumber", prop: "serialNumber", sortable: "custom", "show-overflow-tooltip": true, label: "编号", "min-width": "140px" }, { header: n(() => [t(q, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: n(() => [b("div", te, [a[2] || (a[2] = b("span", { style: { "margin-left": "10px" } }, "编号", -1)), t(d, null, { default: n(() => [t(m)]), _: 1 })])]), _: 1 })]), default: n((r) => [b("span", { style: { cursor: "pointer", "margin-left": "10px" }, onDblclick: (ie) => o(W)(r.row) }, G(r.row.serialNumber), 41, ae)]), _: 1 }), t(l, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", "min-width": "120" }), t(l, { key: "length", prop: "length", "show-overflow-tooltip": "", label: "长度(mm)", align: "left", "min-width": "90px" }), t(l, { key: "material", prop: "material", "show-overflow-tooltip": "", label: "材质", align: "left", "min-width": "90px" }), t(l, { key: "quantity", prop: "quantity", "show-overflow-tooltip": "", label: "数量", "min-width": "120" }), t(l, { key: "netWeight", prop: "netWeight", "show-overflow-tooltip": "", label: "单净重(kg)", align: "left", "min-width": "90px" }), t(l, { key: "areaNames", prop: "areaNames", "show-overflow-tooltip": "", label: "涉及区域", align: "left", "min-width": "90px" })]), _: 1 }, 8, ["data", "max-height", "data-format", "onRowDblclick"])), [[L, E.value]]), t(o(Z), { visible: p.value, "onUpdate:visible": a[0] || (a[0] = (r) => p.value = r), "bool-bim": (_ = o(e)) == null ? void 0 : _.boolBim, drawingSN: (g = o(e)) == null ? void 0 : g.drawingSN, "monomer-id": (v = o(e)) == null ? void 0 : v.monomerId, "serial-number": (y = o(e)) == null ? void 0 : y.serialNumber, productId: (h = o(e)) == null ? void 0 : h.productId, productType: (k = o(e)) == null ? void 0 : k.productType }, null, 8, ["visible", "bool-bim", "drawingSN", "monomer-id", "serial-number", "productId", "productType"]), t(o(ee), { modelValue: s.value, "onUpdate:modelValue": a[1] || (a[1] = (r) => s.value = r), drawingSN: (x = o(e)) == null ? void 0 : x.drawingSN, "bool-bim": (N = o(e)) == null ? void 0 : N.boolBim, "serial-number": (T = o(e)) == null ? void 0 : T.serialNumber, productId: (D = o(e)) == null ? void 0 : D.productId, productType: (I = o(e)) == null ? void 0 : I.productType, "monomer-id": (C = o(e)) == null ? void 0 : C.monomerId }, null, 8, ["modelValue", "drawingSN", "bool-bim", "serial-number", "productId", "productType", "monomer-id"])]);
  };
} }, _e = Y(le, [["__scopeId", "data-v-6673e571"]]);
export {
  _e as default
};
