import { ref as g } from "vue";
import { computed as S } from "vue";
import { watch as j } from "vue";
import { resolveComponent as P } from "vue";
import { openBlock as F } from "vue";
import { createBlock as H } from "vue";
import { withCtx as l } from "vue";
import { withDirectives as te } from "vue";
import { unref as n } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as i } from "vue";
import { isRef as le } from "vue";
import { ElTableColumn as ae } from "element-plus";
import { InfoFilled as ne } from "@element-plus/icons-vue";
import { ElIcon as re } from "element-plus";
import { ElTooltip as ie } from "element-plus";
import { vLoading as pe } from "element-plus";
import { _ as se, u as ue, o as de, p6 as v, qo as ce, qp as me, qq as we, a3 as Q, p as L, bV as fe } from "../../../../../shared/runtime.js";
import { u as be } from "../../../../../modules/use-drawing-8a7ba23b.js";
import { b as ge } from "../../../../../modules/bim-preview-drawer-7ca7893b.js";
import { a as ye } from "../../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../../modules/model-0ac957f7.js";
import "../../../../../modules/index-d6a37d29.js";
import "../../../../../modules/use-chart-59e4b63c.js";
import "../../../../../modules/index-18acf776.js";
const _e = { style: { display: "inline-block" } }, he = ["onDblclick"], ve = { class: "processing-wage" }, Te = { __name: "wage-composition", props: { visible: { type: Boolean, require: true }, currentRow: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(M, { emit: O }) {
  const U = O, y = M, T = g(), m = g(false), w = g(false), { visible: _, handleClose: $ } = ue({ emit: U, props: y, field: "visible", showHook: Y }), { showDrawing: k, drawingRow: s, drawingPreview: z } = be({ pidField: "productId", typeField: "productTypeEnum" }), { maxHeight: G } = de({ mainBox: ".reporting-approval-wage-composition", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, T), J = S(() => {
    var p;
    return ((p = y.currentRow) == null ? void 0 : p.subList.map((o) => {
      var u, d, f;
      return o.serialNumber = ((u = o.product) == null ? void 0 : u.serialNumber) || void 0, o.productId = ((d = o.product) == null ? void 0 : d.id) || void 0, o.monomerId = ((f = o.monomer) == null ? void 0 : f.id) || void 0, o.numbers = o.drawingNumbers, o;
    })) || [];
  }), K = g(false), X = S(() => {
    switch (y.currentRow.productTypeEnum) {
      case v.ARTIFACT.V:
        return we;
      case v.ASSEMBLE.V:
        return me;
      case v.MACHINE_PART.V:
        return ce;
      default:
        return;
    }
  });
  j([() => m.value, () => w.value], ([c, p]) => {
    !c && !p && (k.value = false);
  }), j(() => k.value, (c) => {
    var p, o, u, d;
    c && ((p = s.value) != null && p.productType && ((o = s.value) == null ? void 0 : o.productType) & Q.ARTIFACT.V && (m.value = true), (u = s.value) != null && u.productType && !(((d = s.value) == null ? void 0 : d.productType) & Q.ARTIFACT.V) && (w.value = true));
  });
  function Y() {
  }
  return (c, p) => {
    const o = ae, u = ne, d = re, f = ie, Z = P("common-table"), ee = P("common-dialog"), oe = pe;
    return F(), H(ee, { ref_key: "dialogRef", ref: T, title: "工价组成明细", modelValue: n(_), "onUpdate:modelValue": p[2] || (p[2] = (b) => le(_) ? _.value = b : null), width: "100%", "before-close": n($), "show-close": true, top: "10vh", "custom-class": "reporting-approval-wage-composition" }, { titleRight: l(() => p[3] || (p[3] = [])), default: l(() => {
      var b, N, I, C, V, x, D, E, R, B, A, W, q;
      return [te((F(), H(Z, { ref: "tableRef", data: J.value, "show-empty-symbol": false, "max-height": n(G), style: { width: "100%" } }, { default: l(() => [a(o, { label: "序号", type: "index", align: "center", width: "60" }), a(o, { key: "project", prop: "project", "show-overflow-tooltip": "", label: "项目", align: "center", "min-width": "240" }, { default: l((e) => {
        var t, h;
        return [r("span", null, i((t = e.row.project) == null ? void 0 : t.serialNumber) + " - " + i((h = e.row.project) == null ? void 0 : h.shortName), 1)];
      }), _: 1 }), a(o, { key: "taskOrderNumber", prop: "taskOrderNumber", "show-overflow-tooltip": "", label: "任务工单号", align: "center", "min-width": "200" }, { default: l((e) => [r("span", null, i(e.row.taskOrderNumber || "-"), 1)]), _: 1 }), a(o, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", label: "编号", align: "center" }, { header: l(() => [a(f, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: l(() => [r("div", _e, [p[4] || (p[4] = r("span", null, "编号", -1)), a(d, null, { default: l(() => [a(u)]), _: 1 })])]), _: 1 })]), default: l((e) => {
        var t;
        return [r("span", { style: { cursor: "pointer", color: "#409eff" }, onDblclick: (h) => n(z)(e.row) }, i(((t = e.row.product) == null ? void 0 : t.serialNumber) || "-"), 41, he)];
      }), _: 1 }), a(o, { key: "specification", prop: "specification", "show-overflow-tooltip": "", label: "规格", align: "center", "min-width": "140" }, { default: l((e) => {
        var t;
        return [r("span", null, i(((t = e.row.product) == null ? void 0 : t.specification) || "-"), 1)];
      }), _: 1 }), a(o, { key: "length", prop: "length", "show-overflow-tooltip": "", label: "长度", align: "center" }, { default: l((e) => {
        var t;
        return [r("span", null, i(((t = e.row.product) == null ? void 0 : t.length) || "-"), 1)];
      }), _: 1 }), a(o, { key: "material", prop: "material", "show-overflow-tooltip": "", label: "材质", align: "center" }, { default: l((e) => {
        var t;
        return [r("span", null, i(((t = e.row.product) == null ? void 0 : t.material) || "-"), 1)];
      }), _: 1 }), a(o, { key: "inspectionQuantity", prop: "inspectionQuantity", "show-overflow-tooltip": "", label: "数量", align: "center" }, { default: l((e) => [r("span", null, i(e.row.inspectionQuantity || "-"), 1)]), _: 1 }), a(o, { key: "netWeight", prop: "netWeight", "show-overflow-tooltip": "", label: "单净重(kg)", align: "center", "min-width": "100" }, { default: l((e) => {
        var t;
        return [r("span", null, i(((t = e.row.product) == null ? void 0 : t.netWeight) || "-"), 1)];
      }), _: 1 }), a(o, { key: "processName", prop: "processName", "show-overflow-tooltip": "", label: "工序", align: "center" }, { default: l((e) => {
        var t;
        return [r("span", null, i(((t = e.row.process) == null ? void 0 : t.name) || "-"), 1)];
      }), _: 1 }), a(o, { key: "inspector", prop: "reportTime", "show-overflow-tooltip": "", label: "质检", align: "center" }, { default: l((e) => {
        var t;
        return [r("span", null, i(((t = e.row.inspector) == null ? void 0 : t.name) || "-"), 1)];
      }), _: 1 }), a(o, { key: "teamName", prop: "teamName", "show-overflow-tooltip": "", label: "班组", align: "center" }, { default: l((e) => {
        var t;
        return [r("span", null, i(((t = e.row.team) == null ? void 0 : t.name) || "-"), 1)];
      }), _: 1 }), a(o, { key: "inspectionDate", prop: "inspectionDate", "show-overflow-tooltip": "", label: "质检日期", align: "center", "min-width": "140" }, { default: l((e) => [r("span", null, i(e.row.inspectionDate ? n(L)(e.row.inspectionDate, "{y}-{m}-{d} {h}:{i}") : "-"), 1)]), _: 1 }), a(o, { key: "reportTime", prop: "reportTime", "show-overflow-tooltip": "", label: "报工日期", align: "center", "min-width": "140" }, { default: l((e) => [r("span", null, i(e.row.reportTime ? n(L)(e.row.reportTime, "{y}-{m}-{d} {h}:{i}") : "-"), 1)]), _: 1 }), a(o, { key: "quotaConfigNumber", prop: "quotaConfigNumber", "show-overflow-tooltip": "", label: "定额编号", align: "center" }, { default: l((e) => [r("span", null, i(e.row.quotaConfigNumber || "-"), 1)]), _: 1 }), a(o, { key: "calculationWay", prop: "calculationWay", "show-overflow-tooltip": "", label: "计量方式", align: "center", "min-width": "140" }, { default: l((e) => [r("span", null, i(e.row.calculationWay ? X.value.VL[e.row.calculationWay] : "-"), 1)]), _: 1 }), a(o, { key: "defineType", prop: "defineType", "show-overflow-tooltip": "", label: "定义类型", align: "center", "min-width": "160" }, { default: l((e) => [r("span", null, i(e.row.defineType || "-"), 1)]), _: 1 }), a(o, { key: "price", prop: "price", "show-overflow-tooltip": "", label: "定额单价(元)", align: "center", "min-width": "100" }, { default: l((e) => [r("span", null, i(n(fe)(e.row.price, 2) || "-"), 1)]), _: 1 }), a(o, { key: "accountingQuantity", prop: "accountingQuantity", "show-overflow-tooltip": "", label: "核算量", align: "center", "min-width": "120" }, { default: l((e) => [r("span", null, i(e.row.accountingQuantity || "-") + " " + i(e.row.unit), 1)]), _: 1 }), a(o, { key: "totalPrice", prop: "totalPrice", "show-overflow-tooltip": "", label: "加工工价(元)", align: "center", fixed: "right", "min-width": "100" }, { default: l((e) => [r("span", ve, i(e.row.totalPrice || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[oe, K.value]]), a(n(ge), { visible: m.value, "onUpdate:visible": p[0] || (p[0] = (e) => m.value = e), "bool-bim": (b = n(s)) == null ? void 0 : b.boolBim, drawingSN: (N = n(s)) == null ? void 0 : N.drawingSN, "monomer-id": (I = n(s)) == null ? void 0 : I.monomerId, "serial-number": (C = n(s)) == null ? void 0 : C.serialNumber, productId: (V = n(s)) == null ? void 0 : V.productId, productType: (x = n(s)) == null ? void 0 : x.productType, projectType: (D = n(s)) == null ? void 0 : D.projectType }, null, 8, ["visible", "bool-bim", "drawingSN", "monomer-id", "serial-number", "productId", "productType", "projectType"]), a(n(ye), { modelValue: w.value, "onUpdate:modelValue": p[1] || (p[1] = (e) => w.value = e), drawingSN: (E = n(s)) == null ? void 0 : E.drawingSN, "bool-bim": (R = n(s)) == null ? void 0 : R.boolBim, "serial-number": (B = n(s)) == null ? void 0 : B.serialNumber, productId: (A = n(s)) == null ? void 0 : A.productId, productType: (W = n(s)) == null ? void 0 : W.productType, "monomer-id": (q = n(s)) == null ? void 0 : q.monomerId }, null, 8, ["modelValue", "drawingSN", "bool-bim", "serial-number", "productId", "productType", "monomer-id"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, We = se(Te, [["__scopeId", "data-v-e4eb4406"]]);
export {
  We as default
};
