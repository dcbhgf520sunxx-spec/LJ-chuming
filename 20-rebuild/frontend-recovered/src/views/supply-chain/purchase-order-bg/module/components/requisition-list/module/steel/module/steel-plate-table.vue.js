import { inject as p } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as D } from "vue";
import { openBlock as F } from "vue";
import { createBlock as I } from "vue";
import { withCtx as i } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as c } from "vue";
import { toDisplayString as r } from "vue";
import { withDirectives as R } from "vue";
import { unref as o } from "vue";
import { createTextVNode as f } from "vue";
import { mergeProps as O } from "vue";
import { watch as u } from "vue";
import { ElTableColumn as Q } from "element-plus";
import { ElTooltip as U } from "element-plus";
import { am as z, sQ as A, aw as X, sT as Z, i as G, iX as b, uZ as H, c9 as g } from "../../../../../../../../../shared/runtime.js";
const J = { class: "color-green" }, K = { class: "color-green" }, le = { __name: "steel-plate-table", emits: ["add-purchase"], setup(Y, { expose: _, emit: y }) {
  var h;
  const T = y, W = z.STEEL_PLATE.V, x = p("bcListObj"), q = (h = p("cu")) == null ? void 0 : h.form, { baseUnit: n } = A(W), { handleMeteChangeCalcPrice: v } = H("weighingTotalWeight"), N = { width: [{ required: true, message: "请填写宽度", trigger: "blur" }, { pattern: g, message: "宽度必须大于0", trigger: "blur" }], weighingTotalWeight: [{ required: true, message: "请填写重量", trigger: "blur" }, { pattern: g, message: "重量必须大于0", trigger: "blur" }], length: [{ required: false, message: "请填写长度", trigger: "blur" }, { pattern: g, message: "长度必须大于0", trigger: "blur" }], quantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: g, message: "数量必须大于0", trigger: "blur" }] }, { tableValidate: k, wrongCellMask: C } = X({ rules: N, errorMsg: "请修正【钢板清单】中标红的信息" });
  function P(e) {
    var s;
    return ((s = q.steelPlateList) == null ? void 0 : s.findIndex((l) => l.id === e)) !== -1;
  }
  function w(e) {
    u([() => e.length, () => e.width, () => e.thickness, n], () => E(e)), u([() => e.theoryWeight, () => e.quantity], () => L(e)), u([() => e.weighingTotalWeight], () => v(e));
  }
  async function E(e) {
    e.theoryWeight = await Z({ classifyId: e.classifyId, name: e.classifyFullName, length: e.length, width: e.width, thickness: e.thickness });
  }
  function L(e) {
    G(e.theoryWeight) && e.quantity ? (e.theoryTotalWeight = b(e.theoryWeight * e.quantity, n.value.weight.precision), e.weighingTotalWeight = b(e.theoryWeight * e.quantity, n.value.weight.precision)) : (e.theoryTotalWeight = void 0, e.weighingTotalWeight = void 0);
  }
  function $(e, s) {
    T("add-purchase", e, s);
  }
  function M(e) {
    const { validResult: s } = k(e);
    return s;
  }
  return _({ rowWatch: w, validate: M }), (e, s) => {
    const l = Q, d = U, S = m("common-button"), V = m("common-table"), B = D("empty-text");
    return F(), I(V, O(e.$attrs, { data: o(x).steelPlateList, "cell-class-name": o(C), "show-empty-symbol": false, "return-source-data": "" }), { default: i(() => [a(l, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), a(l, { label: "申购单号", prop: "purchaseSN", fixed: "left", width: "140", align: "center" }, { default: i(({ row: t }) => [c("span", null, r(t.purchaseSN), 1)]), _: 1 }), a(l, { prop: "serialNumber", label: "编号", align: "center", fixed: "left" }), a(l, { prop: "classifyName", label: "物料种类", align: "center", fixed: "left", "show-overflow-tooltip": "" }, { default: i(({ row: t }) => [a(d, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: i(() => [R(c("span", null, null, 512), [[B, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), a(l, { prop: "specification", label: "规格", align: "center", fixed: "left", "show-overflow-tooltip": "" }, { default: i(({ row: t }) => [a(d, { content: t.specificationLabels, placement: "top" }, { default: i(() => [c("span", null, r(t.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), a(l, { prop: "thickness", align: "center", label: `厚 (${o(n).thickness.unit})` }, null, 8, ["label"]), a(l, { prop: "width", align: "center", label: `宽 (${o(n).width.unit})` }, null, 8, ["label"]), a(l, { prop: "length", align: "center", label: `长 (${o(n).length.unit})` }, null, 8, ["label"]), a(l, { prop: "quantity", align: "right", label: `可采购数/申购数 (${o(n).measure.unit})`, width: "140" }, { default: i(({ row: t }) => [c("span", null, [c("span", J, r(t.quantity), 1), f(" / " + r(t.originQuantity), 1)])]), _: 1 }, 8, ["label"]), a(l, { key: "weighingTotalWeight", prop: "weighingTotalWeight", align: "right", label: `可采购量/申购量 (${o(n).weight.unit})`, width: "140" }, { default: i(({ row: t }) => [c("span", null, [c("span", K, r(t.weighingTotalWeight), 1), f(" / " + r(t.originMete), 1)])]), _: 1 }, 8, ["label"]), a(l, { prop: "brand", label: "品牌", align: "center" }), a(l, { label: "操作", width: "90", align: "center", fixed: "right" }, { default: i(({ row: t, $index: j }) => [a(S, { icon: "el-icon-plus", disabled: P(t.id) || !t.quantity, type: "warning", size: "default", onClick: (ee) => $(t, j) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 16, ["data", "cell-class-name"]);
  };
} };
export {
  le as default
};
