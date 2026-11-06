import { inject as m } from "vue";
import { computed as I } from "vue";
import { resolveComponent as f } from "vue";
import { resolveDirective as L } from "vue";
import { openBlock as U } from "vue";
import { createBlock as k } from "vue";
import { withCtx as t } from "vue";
import { createVNode as l } from "vue";
import { createElementVNode as c } from "vue";
import { toDisplayString as o } from "vue";
import { withDirectives as F } from "vue";
import { mergeProps as R } from "vue";
import { unref as p } from "vue";
import { reactive as q } from "vue";
import { ElTableColumn as B } from "element-plus";
import { ElTooltip as D } from "element-plus";
import { ElInput as E } from "element-plus";
import { aw as T, aI as z, b as H } from "../../../../../../../../shared/runtime.js";
const A = { __name: "other-steel-material", props: { maxHeight: { type: Number } }, setup(d, { expose: _ }) {
  const n = m("crud").form, u = m("matSpecRef"), b = I(() => ({ classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], materialSnNew: [{ required: true, message: "请选择材料编码", trigger: "blur" }] })), { tableValidate: g, wrongCellMask: y, cleanUpData: N } = T({ rules: b, errorMsg: "请修正【其他钢材清单】中标红的信息" });
  function h(e) {
    return q({ uid: z(), materialSn: e.sn, specificationLabels: e.specificationLabels, classifySerialNumber: e.classify.serialNumber, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullPathId: e.classify.fullPathId, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationNew: e.spec, specificationName: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, materialSnNew: e.materialSnNew });
  }
  function S(e, i, s) {
    u.value ? u.value.delListItem(e, i) : n.otherSteelMaterialList.splice(i, 1);
  }
  function v() {
    if (H(n.otherSteelMaterialList)) return true;
    const { validResult: e, dealList: i } = g(n.otherSteelMaterialList);
    return e && N(i), e;
  }
  return _({ rowInit: h, validate: v }), (e, i) => {
    const s = B, x = D, C = E, P = f("common-button"), M = f("common-table"), V = L("empty-text");
    return U(), k(M, R({ "cell-class-name": p(y), data: p(n).otherSteelMaterialList, "max-height": d.maxHeight, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: t(() => [l(s, { align: "center", label: "序号" }, { default: t(({ $index: a }) => [c("span", null, o(a + 1), 1)]), _: 1 }), l(s, { align: "center", label: "编号", prop: "serialNumber" }, { default: t(({ row: a }) => [c("span", null, o(a.serialNumber), 1)]), _: 1 }), l(s, { align: "center", label: "物料名称", prop: "classifyName", "show-overflow-tooltip": "" }, { default: t(({ row: a }) => [l(x, { content: a.classifyParentFullName, disabled: !a.classifyParentFullName, "show-after": 500, placement: "top" }, { default: t(() => [F(c("span", null, null, 512), [[V, a.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), l(s, { align: "center", label: "规格", prop: "specification" }, { default: t(({ row: a }) => [c("span", null, o(a.specificationName), 1)]), _: 1 }), l(s, { align: "center", label: "材料编码", prop: "materialSnNew" }, { default: t(({ row: a }) => [l(C, { modelValue: a.materialSnNew, "onUpdate:modelValue": (r) => a.materialSnNew = r, modelModifiers: { trim: true }, maxlength: "20", placeholder: "材料编码", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(s, { align: "center", fixed: "right", label: "操作" }, { default: t(({ row: a, $index: r }) => [l(P, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (j) => S(a.materialSn, r, a) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data", "max-height"]);
  };
} };
export {
  A as default
};
