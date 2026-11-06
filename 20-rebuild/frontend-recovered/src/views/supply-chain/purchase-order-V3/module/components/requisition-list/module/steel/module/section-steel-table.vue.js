import { inject as f } from "vue";
import { resolveComponent as p } from "vue";
import { resolveDirective as $ } from "vue";
import { openBlock as F } from "vue";
import { createElementBlock as z } from "vue";
import { createVNode as a } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as o } from "vue";
import { toDisplayString as r } from "vue";
import { withDirectives as D } from "vue";
import { unref as s } from "vue";
import { createTextVNode as O } from "vue";
import { mergeProps as Q } from "vue";
import { Fragment as H } from "vue";
import { watch as u } from "vue";
import { ElTableColumn as X } from "element-plus";
import { ElTooltip as Z } from "element-plus";
import { am as A, sQ as G, i as d, p as J, z as K, v6 as Y, aw as ee, sU as te, v9 as ae, iX as b, uZ as le, c9 as y } from "../../../../../../../../../shared/runtime.js";
const ie = { class: "color-green" }, re = { __name: "section-steel-table", emits: ["add-purchase"], setup(ne, { expose: _, emit: T }) {
  var h;
  const v = T, W = A.SECTION_STEEL.V, S = f("bcListObj"), g = (h = f("cu")) == null ? void 0 : h.form, { baseUnit: c } = G(W), { handleMeteChangeCalcPrice: C } = le("weighingTotalWeight"), q = { quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: y, message: "数量必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: y, message: "重量必须大于0", trigger: "blur" }] }, { tableValidate: V, wrongCellMask: N } = ee({ rules: q, errorMsg: "请修正【型材清单】中标红的信息" });
  function L(e) {
    var i;
    return !!(((i = g.sectionSteelList) == null ? void 0 : i.findIndex((l) => l.id === e.id)) !== -1 || g.projectId && e.projectId !== g.projectId);
  }
  function j(e) {
    u([() => e.length, () => e.unitWeight, c], () => x(e), { immediate: true }), u([() => e.theoryWeight, () => e.quantity], () => {
      k(e);
    }), u([() => e.length, () => e.quantity], () => {
      w(e);
    }), u([() => e.weighingTotalWeight], () => C(e));
  }
  async function x(e) {
    e.theoryWeight = await te({ length: e.length, unitWeight: e.unitWeight });
  }
  function w(e) {
    d(e.length) && e.quantity ? e.totalLength = ae({ length: e.length, quantity: e.quantity }) : e.totalLength = void 0;
  }
  function k(e) {
    d(e.theoryWeight) && e.quantity ? (e.theoryTotalWeight = b(e.theoryWeight * e.quantity, c.value.weight.precision), e.weighingTotalWeight = b(e.theoryWeight * e.quantity, c.value.weight.precision)) : (e.theoryTotalWeight = void 0, e.weighingTotalWeight = void 0);
  }
  function E(e, i) {
    v("add-purchase", e, i);
  }
  function I(e) {
    const { validResult: i } = V(e);
    return i;
  }
  return _({ rowWatch: j, validate: I }), (e, i) => {
    const l = X, m = Z, P = p("common-button"), M = p("common-table"), R = p("common-drawer"), B = $("empty-text");
    return F(), z(H, null, [a(M, Q(e.$attrs, { data: s(S).sectionSteelList, "cell-class-name": s(N), "show-empty-symbol": false, "return-source-data": "", "row-key": "uid" }), { default: n(() => [a(l, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), a(l, { label: "申购单号", prop: "purchaseSN", fixed: "left", width: "140", align: "center" }, { default: n(({ row: t }) => [o("span", null, r(t.purchaseSN), 1)]), _: 1 }), a(l, { prop: "serialNumber", label: "编号", align: "center", fixed: "left" }), a(l, { prop: "classifyName", label: "物料种类", align: "center", fixed: "left", "show-overflow-tooltip": "" }, { default: n(({ row: t }) => [a(m, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: n(() => [D(o("span", null, null, 512), [[B, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), a(l, { prop: "specification", label: "规格", align: "center", fixed: "left", "show-overflow-tooltip": "", "min-width": "140" }, { default: n(({ row: t }) => [a(m, { content: t.specificationLabels, placement: "top" }, { default: n(() => [o("span", null, r(t.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), a(l, { prop: "length", align: "center", label: `定尺长度 (${s(c).length.unit})`, "min-width": "120" }, null, 8, ["label"]), a(l, { prop: "quantity", align: "right", label: `可采购数/申购数
 (${s(c).measure.unit})`, width: "140" }, { default: n(({ row: t }) => [o("span", null, [o("span", ie, r(t.quantity), 1), O(" / " + r(t.originQuantity), 1)])]), _: 1 }, 8, ["label"]), a(l, { prop: "totalLength", align: "center", label: "总长度 (m)" }), a(l, { key: "weighingTotalWeight", prop: "weighingTotalWeight", align: "right", label: `可采购量/申购量
 (${s(c).weight.unit})`, width: "140" }, null, 8, ["label"]), a(l, { prop: "brand", label: "品牌", align: "center" }), a(l, { align: "center", label: "需求时间", prop: "arrivalTime", "show-overflow-tooltip": "" }, { default: n(({ row: t }) => [o("span", null, r(s(d)(t.arrivalTime) ? s(J)(t.arrivalTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), a(l, { align: "center", label: "项目", prop: "project", "show-overflow-tooltip": "" }, { default: n(({ row: t }) => [o("span", null, r(s(d)(t.project) ? s(K)(t.project) : "-"), 1)]), _: 1 }), a(l, { label: "操作", width: "90", align: "center", fixed: "right" }, { default: n(({ row: t, $index: U }) => [a(P, { icon: "el-icon-plus", disabled: L(t), type: "warning", size: "default", onClick: (se) => E(t, U) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 16, ["data", "cell-class-name"]), a(R, { ref: "drawerRef", modelValue: e.materialSelectVisible, "onUpdate:modelValue": i[1] || (i[1] = (t) => e.materialSelectVisible = t), title: "型材规格选择", "show-close": true, size: 900, "custom-class": "material-spec-select" }, { content: n(() => [a(Y, { ref: "specRef", modelValue: e.editList, "onUpdate:modelValue": i[0] || (i[0] = (t) => e.editList = t), visible: e.materialSelectVisible, classifyId: e.editRow.classifyId, "show-classify": false, mode: "selector", "max-height": e.specSelectMaxHeight, "expand-query": "", onChange: e.handleSpecChange }, null, 8, ["modelValue", "visible", "classifyId", "max-height", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} };
export {
  re as default
};
