import { inject as I } from "vue";
import { ref as R } from "vue";
import { computed as B } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as S } from "vue";
import { openBlock as i } from "vue";
import { createBlock as D } from "vue";
import { withCtx as l } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as u } from "vue";
import { toDisplayString as o } from "vue";
import { withDirectives as d } from "vue";
import { createElementBlock as c } from "vue";
import { createTextVNode as m } from "vue";
import { mergeProps as Q } from "vue";
import { unref as A } from "vue";
import { watch as F } from "vue";
import { ElTableColumn as $ } from "element-plus";
import { ElTooltip as z } from "element-plus";
import { jP as h, aw as H, V as O, uZ as W, c9 as Z } from "../../../../../../../../shared/runtime.js";
const G = { key: 0 }, J = { class: "color-green" }, K = { key: 1 }, X = { key: 0 }, Y = { class: "color-green" }, ee = { key: 1 }, ie = { __name: "index", emits: ["add-purchase"], setup(te, { expose: y, emit: v }) {
  var _;
  const { handleMeteChangeCalcPrice: x } = W("mete"), w = v, r = (_ = I("cu")) == null ? void 0 : _.form, f = R([]), C = { quantity: [{ validator: (t, s) => s.measureUnit ? !!t : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { pattern: Z, message: "核算量必须大于0", trigger: "blur" }] }, { tableValidate: k, wrongCellMask: N } = H({ rules: C }), V = B(() => {
    switch (r.currentMaterial) {
      case h.MATERIAL.V:
        return r.auxiliaryMaterialList;
      case h.OTHER.V:
        return r.otherList;
      default:
        return r.gasList;
    }
  });
  function P(t) {
    var s;
    return !!(((s = V.value) == null ? void 0 : s.findIndex((n) => n.id === t.id)) !== -1 || r.projectId && t.projectId !== r.projectId);
  }
  function E(t, s) {
    w("add-purchase", t, s);
  }
  function L(t) {
    F([() => t.mete], () => x(t));
  }
  function M(t) {
    const { validResult: s } = k(t);
    return s;
  }
  function U(t) {
    f.value = O(t);
  }
  return y({ initList: U, validate: M, rowWatch: L }), (t, s) => {
    const n = $, g = z, j = b("common-button"), T = b("common-table"), p = S("empty-text");
    return i(), D(T, Q(t.$attrs, { data: f.value, "cell-class-name": A(N), "show-empty-symbol": false, "return-source-data": "", "row-key": "uid" }), { default: l(() => [a(n, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), a(n, { label: "申购单号", prop: "purchaseSN", fixed: "left", width: "140", align: "center" }, { default: l(({ row: e }) => [u("span", null, o(e.purchaseSN), 1)]), _: 1 }), a(n, { prop: "serialNumber", "show-overflow-tooltip": "", label: "编号", align: "center", fixed: "left" }), a(n, { prop: "classifyName", label: "物料种类", align: "center", fixed: "left", "show-overflow-tooltip": "" }, { default: l(({ row: e }) => [a(g, { content: e.classifyParentFullName, disabled: !e.classifyParentFullName, "show-after": 500, placement: "top" }, { default: l(() => [d(u("span", null, null, 512), [[p, e.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), a(n, { prop: "specification", label: "规格", align: "center", fixed: "left", "show-overflow-tooltip": "" }, { default: l(({ row: e }) => [a(g, { content: e.specificationLabels, placement: "top" }, { default: l(() => [d(u("span", null, null, 512), [[p, e.specification]])]), _: 2 }, 1032, ["content"])]), _: 1 }), a(n, { prop: "measureUnit", label: "计量单位", align: "center" }, { default: l(({ row: e }) => [d((i(), c("span", null, [m(o(e.measureUnit), 1)])), [[p]])]), _: 1 }), a(n, { prop: "quantity", label: "可采购数/申购数", align: "right" }, { default: l(({ row: e }) => [e.measureUnit ? (i(), c("span", G, [u("span", J, o(e.quantity), 1), m(" / " + o(e.originQuantity), 1)])) : (i(), c("span", K, "-"))]), _: 1 }), a(n, { prop: "accountingUnit", label: "核算单位", align: "center" }, { default: l(({ row: e }) => [d((i(), c("span", null, [m(o(e.accountingUnit), 1)])), [[p]])]), _: 1 }), a(n, { prop: "mete", label: "可采购量/申购量", align: "right" }, { default: l(({ row: e }) => [e.accountingUnit ? (i(), c("span", X, [u("span", Y, o(e.mete), 1), m(" / " + o(e.originMete), 1)])) : (i(), c("span", ee))]), _: 1 }), a(n, { prop: "color", label: "颜色", align: "center" }), a(n, { prop: "brand", label: "品牌", align: "center" }), a(n, { label: "操作", width: "90", align: "center", fixed: "right" }, { default: l(({ row: e, $index: q }) => [a(j, { icon: "el-icon-plus", disabled: P(e), type: "warning", size: "default", onClick: (ne) => E(e, q) }, null, 8, ["disabled", "onClick"])]), _: 1 })]), _: 1 }, 16, ["data", "cell-class-name"]);
  };
} };
export {
  ie as default
};
