import { inject as m } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as D } from "vue";
import { openBlock as F } from "vue";
import { createElementBlock as O } from "vue";
import { createVNode as a } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as c } from "vue";
import { withDirectives as z } from "vue";
import { unref as r } from "vue";
import { createTextVNode as p } from "vue";
import { mergeProps as Q } from "vue";
import { Fragment as H } from "vue";
import { watch as u } from "vue";
import { ElTableColumn as X } from "element-plus";
import { ElTooltip as Z } from "element-plus";
import { am as A, sQ as G, v6 as J, aw as K, sU as Y, i as f, v9 as ee, iX as b, uZ as te, c9 as y } from "../../../../../../../../../shared/runtime.js";
const ae = { class: "color-green" }, le = { class: "color-green" }, ce = { __name: "section-steel-table", emits: ["add-purchase"], setup(ie, { expose: _, emit: W }) {
  var d;
  const S = W, T = A.SECTION_STEEL.V, v = m("bcListObj"), q = (d = m("cu")) == null ? void 0 : d.form, { baseUnit: o } = G(T), { handleMeteChangeCalcPrice: C } = te("weighingTotalWeight"), V = { quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: y, message: "数量必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: y, message: "重量必须大于0", trigger: "blur" }] }, { tableValidate: L, wrongCellMask: N } = K({ rules: V, errorMsg: "请修正【型材清单】中标红的信息" });
  function x(e) {
    var i;
    return ((i = q.sectionSteelList) == null ? void 0 : i.findIndex((l) => l.id === e)) !== -1;
  }
  function k(e) {
    u([() => e.length, () => e.unitWeight, o], () => w(e), { immediate: true }), u([() => e.theoryWeight, () => e.quantity], () => {
      M(e);
    }), u([() => e.length, () => e.quantity], () => {
      E(e);
    }), u([() => e.weighingTotalWeight], () => C(e));
  }
  async function w(e) {
    e.theoryWeight = await Y({ length: e.length, unitWeight: e.unitWeight });
  }
  function E(e) {
    f(e.length) && e.quantity ? e.totalLength = ee({ length: e.length, quantity: e.quantity }) : e.totalLength = void 0;
  }
  function M(e) {
    f(e.theoryWeight) && e.quantity ? (e.theoryTotalWeight = b(e.theoryWeight * e.quantity, o.value.weight.precision), e.weighingTotalWeight = b(e.theoryWeight * e.quantity, o.value.weight.precision)) : (e.theoryTotalWeight = void 0, e.weighingTotalWeight = void 0);
  }
  function P(e, i) {
    S("add-purchase", e, i);
  }
  function R(e) {
    const { validResult: i } = L(e);
    return i;
  }
  return _({ rowWatch: k, validate: R }), (e, i) => {
    const l = X, h = Z, B = g("common-button"), I = g("common-table"), U = g("common-drawer"), $ = D("empty-text");
    return F(), O(H, null, [a(I, Q(e.$attrs, { data: r(v).sectionSteelList, "cell-class-name": r(N), "show-empty-symbol": false, "return-source-data": "", "row-key": "uid" }), { default: n(() => [a(l, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), a(l, { label: "申购单号", prop: "purchaseSN", fixed: "left", width: "140", align: "center" }, { default: n(({ row: t }) => [s("span", null, c(t.purchaseSN), 1)]), _: 1 }), a(l, { prop: "serialNumber", label: "编号", align: "center", fixed: "left" }), a(l, { prop: "classifyName", label: "物料种类", align: "center", fixed: "left", "show-overflow-tooltip": "" }, { default: n(({ row: t }) => [a(h, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: n(() => [z(s("span", null, null, 512), [[$, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), a(l, { prop: "specification", label: "规格", align: "center", fixed: "left", "show-overflow-tooltip": "", "min-width": "140" }, { default: n(({ row: t }) => [a(h, { content: t.specificationLabels, placement: "top" }, { default: n(() => [s("span", null, c(t.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), a(l, { prop: "length", align: "center", label: `定尺长度 (${r(o).length.unit})`, "min-width": "120" }, null, 8, ["label"]), a(l, { prop: "quantity", align: "right", label: `可采购数/申购数
 (${r(o).measure.unit})`, width: "140" }, { default: n(({ row: t }) => [s("span", null, [s("span", ae, c(t.quantity), 1), p(" / " + c(t.originQuantity), 1)])]), _: 1 }, 8, ["label"]), a(l, { prop: "totalLength", align: "center", label: "总长度 (m)" }), a(l, { key: "weighingTotalWeight", prop: "weighingTotalWeight", align: "right", label: `可采购量/申购量
 (${r(o).weight.unit})`, width: "140" }, { default: n(({ row: t }) => [s("span", null, [s("span", le, c(t.weighingTotalWeight), 1), p(" / " + c(t.originMete), 1)])]), _: 1 }, 8, ["label"]), a(l, { prop: "brand", label: "品牌", align: "center" }), a(l, { label: "操作", width: "90", align: "center", fixed: "right" }, { default: n(({ row: t, $index: j }) => [a(B, { icon: "el-icon-plus", disabled: x(t.id) || !t.quantity, type: "warning", size: "default", onClick: (ne) => P(t, j) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 16, ["data", "cell-class-name"]), a(U, { ref: "drawerRef", modelValue: e.materialSelectVisible, "onUpdate:modelValue": i[1] || (i[1] = (t) => e.materialSelectVisible = t), title: "型材规格选择", "show-close": true, size: 900, "custom-class": "material-spec-select" }, { content: n(() => [a(J, { ref: "specRef", modelValue: e.editList, "onUpdate:modelValue": i[0] || (i[0] = (t) => e.editList = t), visible: e.materialSelectVisible, classifyId: e.editRow.classifyId, "show-classify": false, mode: "selector", "max-height": e.specSelectMaxHeight, "expand-query": "", onChange: e.handleSpecChange }, null, 8, ["modelValue", "visible", "classifyId", "max-height", "onChange"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} };
export {
  ce as default
};
