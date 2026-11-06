import { ref as f } from "vue";
import { computed as C } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as b } from "vue";
import { createElementVNode as c } from "vue";
import { mergeProps as V } from "vue";
import { createVNode as e } from "vue";
import { withCtx as u } from "vue";
import { unref as A } from "vue";
import { createBlock as r } from "vue";
import { createCommentVNode as l } from "vue";
import { createTextVNode as B } from "vue";
import { toDisplayString as T } from "vue";
import { Fragment as y } from "vue";
import { ElTableColumn as N } from "element-plus";
import { _ as P, t as R, jX as D, bD as S, D as m, o as $, aR as j, k4 as E, jG as H, jH as U, k5 as I, vb as M, k6 as Y } from "../../../../../shared/runtime.js";
const F = { __name: "inspection-return-info", props: { basicClass: { type: Number }, list: { type: Array, default: () => [] }, showTableColumnSecondary: { type: Boolean }, showAmount: { type: Boolean }, boolPartyA: { type: Boolean } }, setup(a) {
  const { decimalPrecision: d } = R(), n = f(), i = f(), w = C(() => [...D, ["invoiceType", ["parse-enum", S, { f: "SL" }]], ["taxRate", ["suffix", "%"]], ["unitPrice", ["to-thousand", d.value.wms]], ["unitPriceExcludingVAT", ["to-thousand", d.value.wms]], ["amount", ["to-thousand", m.YUAN]], ["amountExcludingVAT", ["to-thousand", m.YUAN]], ["inputVAT", ["to-thousand", m.YUAN]], ["remark", "empty-text"]]), { maxHeight: x } = $({ mainBox: ".wms-inspection-return-list", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true }, n);
  function _() {
    n.value = true;
  }
  return (h, s) => {
    const k = N, v = p("common-table"), g = p("common-dialog");
    return o(), b(y, null, [c("span", V(h.$attrs, { class: "tip", onClick: _ }), " * 当前入库单据存在质检退回物料，点击可查看质检退回的物料信息 ", 16), e(g, { title: "质检退回物料列表", modelValue: n.value, "onUpdate:modelValue": s[1] || (s[1] = (t) => n.value = t), width: "95%", "show-close": true, "custom-class": "wms-inspection-return-list", top: "10vh" }, { default: u(() => [e(v, { ref: "tableRef", data: a.list, "data-format": w.value, "max-height": A(x), "default-expand-all": false, "expand-row-keys": i.value, "row-key": "id" }, { default: u(() => [e(j, { data: a.list, "expand-row-keys": i.value, "onUpdate:expandRowKeys": s[0] || (s[0] = (t) => i.value = t), "row-key": "id", fixed: "left" }, { default: u(({ row: t }) => [a.showTableColumnSecondary ? l("", true) : (o(), r(E, { key: 0, "basic-class": a.basicClass, row: t, "show-brand": "" }, null, 8, ["basic-class", "row"])), c("p", null, [s[2] || (s[2] = B(" 备注：")), c("span", null, T(t.remark), 1)])]), _: 1 }, 8, ["data", "expand-row-keys"]), e(H, { "basic-class": a.basicClass, fixed: "left" }, null, 8, ["basic-class"]), e(U, { "basic-class": a.basicClass }, null, 8, ["basic-class"]), a.showTableColumnSecondary ? (o(), r(I, { key: 0, "basic-class": a.basicClass }, null, 8, ["basic-class"])) : l("", true), a.showAmount ? (o(), b(y, { key: 1 }, [a.boolPartyA ? l("", true) : (o(), r(M, { key: 0 }))], 64)) : l("", true), e(k, { prop: "requisitionsSN", label: "申购单", align: "left", "min-width": "120px", "show-overflow-tooltip": "" }), e(Y, { "show-project": "" })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])]), _: 1 }, 8, ["modelValue"])], 64);
  };
} }, G = P(F, [["__scopeId", "data-v-2bd458ce"]]);
export {
  G as default
};
