import { ref as x } from "vue";
import { inject as ge } from "vue";
import { computed as V } from "vue";
import { watch as oe } from "vue";
import { resolveComponent as A } from "vue";
import { openBlock as y } from "vue";
import { createBlock as R } from "vue";
import { withCtx as r } from "vue";
import { createVNode as i } from "vue";
import { createTextVNode as te } from "vue";
import { toDisplayString as l } from "vue";
import { unref as t } from "vue";
import { createElementVNode as u } from "vue";
import { createCommentVNode as I } from "vue";
import { createElementBlock as O } from "vue";
import { Fragment as he } from "vue";
import { renderList as Te } from "vue";
import { isRef as Ee } from "vue";
import { ElMessageBox as ke } from "element-plus";
import { ElMessage as Ce } from "element-plus";
import { ElTag as Ve } from "element-plus";
import { ElTableColumn as Se } from "element-plus";
import { InfoFilled as Ne } from "@element-plus/icons-vue";
import { ElIcon as Re } from "element-plus";
import { ElTooltip as Le } from "element-plus";
import { b as Be } from "../../../../../modules/reporting-approval-2b65eecd.js";
import { _ as xe, u as Ae, o as Ie, a3 as w, q9 as Oe, qa as je, qb as Me, e8 as De, i as Pe, e0 as Fe, e1 as qe, bV as ne, ba as He } from "../../../../../shared/runtime.js";
import { u as Qe } from "../../../../../modules/use-drawing-8a7ba23b.js";
import { b as Ue } from "../../../../../modules/bim-preview-drawer-7ca7893b.js";
import { a as ze } from "../../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../../modules/model-0ac957f7.js";
import "../../../../../modules/index-d6a37d29.js";
import "../../../../../modules/use-chart-59e4b63c.js";
import "../../../../../modules/index-18acf776.js";
const Ye = { style: { display: "inline-block" } }, $e = ["onDblclick"], We = { key: 0, class: "detailList" }, Xe = { key: 1 }, Ge = { __name: "index", props: { modelValue: { type: Boolean, default: false }, selections: { type: Array, default: () => [] }, reviewStatus: { type: [String, Number], default: null }, currentRow: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(_, { emit: ae }) {
  const j = ae, m = _, S = x(), N = x(), M = x(), L = ge("wageDisplayPrecision"), { visible: B, handleClose: D } = Ae({ emit: j, props: m, showHook: me, closeHook: we }), { maxHeight: re } = Ie({ mainBox: ".reporting-approval-batch-review", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", navbar: false, clientHRepMainH: true, minHeight: 300 }, () => M.value.loaded), { showDrawing: P, drawingRow: p, drawingPreview: le } = Qe({ pidField: "productId", typeField: "productTypeEnum" }), ie = V(() => {
    var n, a, f;
    return ((n = m.currentRow) == null ? void 0 : n.productTypeEnum) === w.ARTIFACT.V ? Object.values(Oe.V).map((c) => ({ conditionEnum: c.V, name: c.L })) : ((a = m.currentRow) == null ? void 0 : a.productTypeEnum) === w.ASSEMBLE.V ? Object.values(je.V).map((c) => ({ conditionEnum: c.V, name: c.L })) : ((f = m.currentRow) == null ? void 0 : f.productTypeEnum) === w.MACHINE_PART.V ? Object.values(Me.V).map((c) => ({ conditionEnum: c.V, name: c.L })) : [];
  });
  oe([() => S.value, () => N.value], ([n, a]) => {
    !n && !a && (P.value = false);
  }), oe(() => P.value, (n) => {
    var a, f, c, s;
    n && ((a = p.value) != null && a.productType && ((f = p.value) == null ? void 0 : f.productType) & w.ARTIFACT.V && (S.value = true), (c = p.value) != null && c.productType && !(((s = p.value) == null ? void 0 : s.productType) & w.ARTIFACT.V) && (N.value = true));
  });
  function ue(n) {
    return He(n, { props: ["reportQuantity", ["measurementQuantity", 5], ["amount", L.value]], toThousandFields: ["amount"] });
  }
  V(() => {
    var n, a;
    return ((n = m.currentRow) == null ? void 0 : n.productTypeEnum) === w.ARTIFACT.V || ((a = m.currentRow) == null ? void 0 : a.productTypeEnum) === w.ASSEMBLE.V;
  });
  const se = V(() => {
    var n;
    return ((n = m.currentRow) == null ? void 0 : n.productTypeEnum) === w.MACHINE_PART.V;
  }), pe = V(() => {
    var n;
    return ((n = m.currentRow) == null ? void 0 : n.productTypeEnum) === w.ENCLOSURE.V;
  }), ce = V(() => (m.selections || []).every((n) => !n.conditionList || n.conditionList.length === 0));
  async function de() {
    try {
      await ke.confirm("是否确认批量通过？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await Be(m.selections || []), Ce.success("批量通过成功！"), D(), j("success");
    } catch (n) {
      console.log(n);
    }
  }
  function me() {
  }
  function we() {
  }
  return (n, a) => {
    const f = Ve, c = A("common-button"), s = Se, fe = Ne, be = Re, ye = Le, _e = A("common-table"), ve = A("common-drawer");
    return y(), R(ve, { ref_key: "drawerRef", ref: M, "append-to-body": "", modelValue: t(B), "onUpdate:modelValue": a[2] || (a[2] = (b) => Ee(B) ? B.value = b : null), "before-close": t(D), "close-on-click-modal": false, title: "批量审批", size: "100%", "custom-class": "reporting-approval-batch-review" }, { titleAfter: r(() => [i(f, { size: "large" }, { default: r(() => {
      var b, v, g, h, T, E;
      return [te(l((v = (b = _.currentRow) == null ? void 0 : b.workshop) == null ? void 0 : v.name) + ">" + l((h = (g = _.currentRow) == null ? void 0 : g.team) == null ? void 0 : h.name) + " | 工序: " + l((E = (T = _.currentRow) == null ? void 0 : T.process) == null ? void 0 : E.name), 1)];
    }), _: 1 })]), titleRight: r(() => [i(c, { type: "success", size: "default", class: "filter-item", onClick: de }, { default: r(() => a[3] || (a[3] = [te(" 批量通过 ")])), _: 1, __: [3] })]), content: r(() => {
      var b, v, g, h, T, E, F, q, H, Q, U, z, Y;
      return [i(_e, { ref: "tableRef", data: _.selections, "max-height": t(re), "return-source-data": "", "row-key": "id", style: { width: "100%" }, "show-summary": "", "summary-method": ue }, { default: r(() => [i(s, { prop: "index", label: "序号", align: "center", width: "50", type: "index", fixed: "left" }), i(s, { label: "项目", prop: "project", key: "project", "show-overflow-tooltip": "", align: "center", "min-width": "120px" }, { default: r((e) => {
        var o, d;
        return [u("span", null, l((o = e.row.project) == null ? void 0 : o.serialNumber) + " - " + l((d = e.row.project) == null ? void 0 : d.shortName), 1)];
      }), _: 1 }), i(s, { label: "单体/区域", prop: "monomer", key: "monomer", "show-overflow-tooltip": "", align: "center", "min-width": "120px" }, { default: r((e) => {
        var o, d, k, C;
        return [u("span", null, l((d = (o = e.row) == null ? void 0 : o.monomer) == null ? void 0 : d.name) + " / " + l((C = (k = e.row) == null ? void 0 : k.area) == null ? void 0 : C.name), 1)];
      }), _: 1 }), i(s, { label: "批次", prop: "areaBatch", key: "areaBatch", "show-overflow-tooltip": "", align: "center", "min-width": "100px" }, { default: r((e) => {
        var o;
        return [u("span", null, l(((o = e.row.areaBatch) == null ? void 0 : o.name) || "-"), 1)];
      }), _: 1 }), se.value ? (y(), R(s, { label: "类型", prop: "productClassificationEnum", key: "productClassificationEnum", "show-overflow-tooltip": "", align: "center", width: "120" }, { default: r((e) => {
        var o;
        return [u("span", null, l(t(De).VL[(o = e.row.product) == null ? void 0 : o.productClassificationEnum] || "-"), 1)];
      }), _: 1 })) : I("", true), pe.value ? (y(), R(s, { label: "围护类型", prop: "dict", key: "dict", "show-overflow-tooltip": "", align: "center", width: "120" }, { default: r((e) => {
        var o;
        return [u("span", null, l(((o = e.row.dict) == null ? void 0 : o.label) || "-"), 1)];
      }), _: 1 })) : I("", true), i(s, { label: "编号", prop: "productSerialNumber", key: "productSerialNumber", "show-overflow-tooltip": "", align: "center" }, { header: r(() => [i(ye, { class: "item", effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: r(() => [u("div", Ye, [a[4] || (a[4] = u("span", null, "编号", -1)), i(be, null, { default: r(() => [i(fe)]), _: 1 })])]), _: 1 })]), default: r((e) => {
        var o;
        return [u("span", { style: { cursor: "pointer", color: "#409eff" }, onDblclick: (d) => t(le)(e.row) }, l(((o = e.row.product) == null ? void 0 : o.serialNumber) || "-"), 41, $e)];
      }), _: 1 }), i(s, { label: "规格", prop: "productSpecification", key: "productSpecification", "show-overflow-tooltip": "", align: "center" }, { default: r((e) => {
        var o;
        return [u("span", null, l(((o = e.row.product) == null ? void 0 : o.specification) || "-"), 1)];
      }), _: 1 }), i(s, { label: "上报数", prop: "reportQuantity", key: "reportQuantity", "show-overflow-tooltip": "", align: "center", width: "80" }, { default: r((e) => [u("span", null, l(e.row.reportQuantity ?? "-"), 1)]), _: 1 }), i(s, { label: "定额编号", prop: "quotaConfigSerialNumber", key: "quotaConfigSerialNumber", "show-overflow-tooltip": "", align: "center", width: "100" }, { default: r((e) => [u("span", null, l(e.row.quotaConfigSerialNumber || "-"), 1)]), _: 1 }), ce.value ? I("", true) : (y(true), O(he, { key: 2 }, Te(ie.value, (e, o) => (y(), R(s, { key: o, prop: e.name, label: e.name, align: "center", "min-width": "120" }, { default: r((d) => {
        var k, C, $, W, X, G, J, K, Z, ee;
        return [t(Pe)((C = (k = d.row.conditionList) == null ? void 0 : k[o]) == null ? void 0 : C.numberOne) ? (y(), O("div", We, [u("span", null, l((W = ($ = d.row.conditionList) == null ? void 0 : $[o]) == null ? void 0 : W.numberOne), 1), u("span", null, l(t(Fe).VL[(G = (X = d.row.conditionList) == null ? void 0 : X[o]) == null ? void 0 : G.comparisonOperatorOne]), 1), a[5] || (a[5] = u("span", null, "X", -1)), u("span", null, l(t(qe).VL[(K = (J = d.row.conditionList) == null ? void 0 : J[o]) == null ? void 0 : K.comparisonOperatorTwo]), 1), u("span", null, l((ee = (Z = d.row.conditionList) == null ? void 0 : Z[o]) == null ? void 0 : ee.numberTwo), 1)])) : (y(), O("span", Xe, "-"))];
      }), _: 2 }, 1032, ["prop", "label"]))), 128)), i(s, { label: "计量单位", prop: "measureUnit", key: "measureUnit", "show-overflow-tooltip": "", align: "center", width: "80" }, { default: r((e) => [u("span", null, l(e.row.measureUnit || "-"), 1)]), _: 1 }), i(s, { label: "核算量", prop: "measurementQuantity", key: "measurementQuantity", "show-overflow-tooltip": "", align: "center", width: "100" }, { default: r((e) => [u("span", null, l(e.row.measurementQuantity ?? "-"), 1)]), _: 1 }), i(s, { label: "单价（元）", prop: "price", key: "price", "show-overflow-tooltip": "", align: "center", width: "100" }, { default: r((e) => [u("span", null, l(t(ne)(e.row.price, t(L)) ?? "-"), 1)]), _: 1 }), i(s, { label: "金额（元）", prop: "amount", key: "amount", "show-overflow-tooltip": "", align: "center", width: "100" }, { default: r((e) => [u("span", null, l(t(ne)(e.row.amount, t(L)) ?? "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), i(t(Ue), { visible: S.value, "onUpdate:visible": a[0] || (a[0] = (e) => S.value = e), "bool-bim": (b = t(p)) == null ? void 0 : b.boolBim, drawingSN: (v = t(p)) == null ? void 0 : v.drawingSN, "monomer-id": (g = t(p)) == null ? void 0 : g.monomerId, "serial-number": (h = t(p)) == null ? void 0 : h.serialNumber, productId: (T = t(p)) == null ? void 0 : T.productId, productType: (E = t(p)) == null ? void 0 : E.productType, projectType: (F = t(p)) == null ? void 0 : F.projectType }, null, 8, ["visible", "bool-bim", "drawingSN", "monomer-id", "serial-number", "productId", "productType", "projectType"]), i(t(ze), { modelValue: N.value, "onUpdate:modelValue": a[1] || (a[1] = (e) => N.value = e), drawingSN: (q = t(p)) == null ? void 0 : q.drawingSN, "bool-bim": (H = t(p)) == null ? void 0 : H.boolBim, "serial-number": (Q = t(p)) == null ? void 0 : Q.serialNumber, productId: (U = t(p)) == null ? void 0 : U.productId, productType: (z = t(p)) == null ? void 0 : z.productType, "monomer-id": (Y = t(p)) == null ? void 0 : Y.monomerId }, null, 8, ["modelValue", "drawingSN", "bool-bim", "serial-number", "productId", "productType", "monomer-id"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, so = xe(Ge, [["__scopeId", "data-v-b1103d1d"]]);
export {
  so as default
};
