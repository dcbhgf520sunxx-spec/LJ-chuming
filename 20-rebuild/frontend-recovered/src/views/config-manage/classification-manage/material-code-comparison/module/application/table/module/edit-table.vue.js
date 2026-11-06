import { inject as V } from "vue";
import { computed as C } from "vue";
import { resolveComponent as P } from "vue";
import { resolveDirective as v } from "vue";
import { openBlock as U } from "vue";
import { createBlock as F } from "vue";
import { withCtx as l } from "vue";
import { createVNode as s } from "vue";
import { createElementVNode as i } from "vue";
import { toDisplayString as n } from "vue";
import { unref as r } from "vue";
import { withDirectives as I } from "vue";
import { mergeProps as M } from "vue";
import { reactive as k } from "vue";
import { ElTableColumn as D } from "element-plus";
import { ElTooltip as E } from "element-plus";
import { ElInput as L } from "element-plus";
import { cJ as q, aw as B, aI as T } from "../../../../../../../../shared/runtime.js";
const R = { __name: "edit-table", props: { maxHeight: { type: Number } }, setup(u, { expose: m }) {
  const o = V("crud").form, p = C(() => ({ materialSnNew: [{ required: true, message: "请选择材料编码", trigger: "blur" }] })), { tableValidate: f, wrongCellMask: d, cleanUpData: _ } = B({ rules: p });
  function b(e) {
    return k({ uid: T(), materialSn: e.sn, specificationLabels: e.specificationLabels, classifySerialNumber: e.classify.serialNumber, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullPathId: e.classify.fullPathId, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, materialSnNew: e.materialSnNew, specificationNew: e.specificationNew });
  }
  function y() {
    const { validResult: e, dealList: c } = f(o.list);
    return e && _(c), e;
  }
  return m({ validate: y, rowInit: b }), (e, c) => {
    const t = D, N = E, g = L, h = P("common-table"), S = v("empty-text");
    return U(), F(h, M({ "cell-class-name": r(d), data: r(o).list, "show-empty-symbol": false, stripe: false, "max-height": u.maxHeight, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: l(() => [s(t, { align: "center", fixed: "left", label: "序号" }, { default: l(({ $index: a }) => [i("span", null, n(a + 1), 1)]), _: 1 }), s(t, { align: "center", label: "材料类型", prop: "materialSn" }, { default: l(({ row: a }) => [i("span", null, n(r(q).VL[a.basicClass] || "-"), 1)]), _: 1 }), s(t, { align: "center", label: "编号", prop: "materialSn" }, { default: l(({ row: a }) => [i("span", null, n(a.materialSn), 1)]), _: 1 }), s(t, { align: "center", label: "物料名称", prop: "classifyName", "show-overflow-tooltip": "" }, { default: l(({ row: a }) => [s(N, { content: a.classifyParentFullName, disabled: !a.classifyParentFullName, "show-after": 500, placement: "top" }, { default: l(() => [I(i("span", null, null, 512), [[S, a.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(t, { align: "center", label: "规格", prop: "specification" }, { default: l(({ row: a }) => [i("span", null, n(a.specificationNew), 1)]), _: 1 }), s(t, { align: "center", label: "材料编码", prop: "materialSnNew" }, { default: l(({ row: a }) => [s(g, { modelValue: a.materialSnNew, "onUpdate:modelValue": (x) => a.materialSnNew = x, modelModifiers: { trim: true }, maxlength: "20", placeholder: "材料编码", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data", "max-height"]);
  };
} };
export {
  R as default
};
