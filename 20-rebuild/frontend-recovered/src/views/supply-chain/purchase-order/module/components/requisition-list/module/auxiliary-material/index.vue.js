import { inject as S } from "vue";
import { ref as T } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as D } from "vue";
import { openBlock as i } from "vue";
import { createBlock as Q } from "vue";
import { withCtx as l } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as o } from "vue";
import { withDirectives as p } from "vue";
import { createElementBlock as c } from "vue";
import { createTextVNode as d } from "vue";
import { mergeProps as R } from "vue";
import { unref as j } from "vue";
import { watch as F } from "vue";
import { ElTableColumn as L } from "element-plus";
import { ElTooltip as $ } from "element-plus";
import { aw as z, V as I, uZ as W, c9 as Z } from "../../../../../../../../shared/runtime.js";
const A = { key: 0 }, G = { class: "color-green" }, H = { key: 1 }, J = { key: 0 }, K = { class: "color-green" }, O = { key: 1 }, ne = { __name: "index", emits: ["add-purchase"], setup(X, { expose: b, emit: h }) {
  var f;
  const { handleMeteChangeCalcPrice: y } = W("mete"), v = h, x = (f = S("cu")) == null ? void 0 : f.form, m = T([]), k = { quantity: [{ validator: (a, s) => s.measureUnit ? !!a : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { pattern: Z, message: "核算量必须大于0", trigger: "blur" }] }, { tableValidate: w, wrongCellMask: C } = z({ rules: k });
  function N(a) {
    var s;
    return ((s = x.list) == null ? void 0 : s.findIndex((n) => n.id === a)) !== -1;
  }
  function U(a, s) {
    v("add-purchase", a, s);
  }
  function P(a) {
    F([() => a.mete], () => y(a));
  }
  function V(a) {
    const { validResult: s } = w(a);
    return s;
  }
  function q(a) {
    m.value = I(a);
  }
  return b({ initList: q, validate: V, rowWatch: P }), (a, s) => {
    const n = L, _ = $, B = g("common-button"), E = g("common-table"), u = D("empty-text");
    return i(), Q(E, R(a.$attrs, { data: m.value, "cell-class-name": j(C), "show-empty-symbol": false, "return-source-data": "", "row-key": "uid" }), { default: l(() => [t(n, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), t(n, { label: "申购单号", prop: "purchaseSN", fixed: "left", width: "140", align: "center" }, { default: l(({ row: e }) => [r("span", null, o(e.purchaseSN), 1)]), _: 1 }), t(n, { prop: "serialNumber", "show-overflow-tooltip": "", label: "编号", align: "center", fixed: "left" }), t(n, { prop: "classifyName", label: "物料种类", align: "center", fixed: "left", "show-overflow-tooltip": "" }, { default: l(({ row: e }) => [t(_, { content: e.classifyParentFullName, disabled: !e.classifyParentFullName, "show-after": 500, placement: "top" }, { default: l(() => [p(r("span", null, null, 512), [[u, e.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), t(n, { prop: "specification", label: "规格", align: "center", fixed: "left", "show-overflow-tooltip": "" }, { default: l(({ row: e }) => [t(_, { content: e.specificationLabels, placement: "top" }, { default: l(() => [p(r("span", null, null, 512), [[u, e.specification]])]), _: 2 }, 1032, ["content"])]), _: 1 }), t(n, { prop: "measureUnit", label: "计量单位", align: "center" }, { default: l(({ row: e }) => [p((i(), c("span", null, [d(o(e.measureUnit), 1)])), [[u]])]), _: 1 }), t(n, { prop: "quantity", label: "可采购数/申购数", align: "right" }, { default: l(({ row: e }) => [e.measureUnit ? (i(), c("span", A, [r("span", G, o(e.quantity), 1), d(" / " + o(e.originQuantity), 1)])) : (i(), c("span", H, "-"))]), _: 1 }), t(n, { prop: "accountingUnit", label: "核算单位", align: "center" }, { default: l(({ row: e }) => [p((i(), c("span", null, [d(o(e.accountingUnit), 1)])), [[u]])]), _: 1 }), t(n, { prop: "mete", label: "可采购量/申购量", align: "right" }, { default: l(({ row: e }) => [e.accountingUnit ? (i(), c("span", J, [r("span", K, o(e.mete), 1), d(" / " + o(e.originMete), 1)])) : (i(), c("span", O))]), _: 1 }), t(n, { prop: "color", label: "颜色", align: "center" }), t(n, { prop: "brand", label: "品牌", align: "center" }), t(n, { label: "操作", width: "90", align: "center", fixed: "right" }, { default: l(({ row: e, $index: M }) => [t(B, { icon: "el-icon-plus", disabled: N(e.id) || !e.mete, type: "warning", size: "default", onClick: (ee) => U(e, M) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 16, ["data", "cell-class-name"]);
  };
} };
export {
  ne as default
};
