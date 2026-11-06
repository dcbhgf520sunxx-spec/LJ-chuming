import { inject as p } from "vue";
import { computed as I } from "vue";
import { resolveComponent as r } from "vue";
import { resolveDirective as F } from "vue";
import { openBlock as L } from "vue";
import { createBlock as q } from "vue";
import { withCtx as i } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as o } from "vue";
import { toDisplayString as u } from "vue";
import { withDirectives as M } from "vue";
import { mergeProps as R } from "vue";
import { unref as f } from "vue";
import { reactive as B } from "vue";
import { ElTableColumn as D } from "element-plus";
import { ElTooltip as E } from "element-plus";
import { ElInput as $ } from "element-plus";
import { aw as z, aI as T, b as H } from "../../../../../../../../shared/runtime.js";
const G = { __name: "steel-plate", props: { maxHeight: { type: Number } }, setup(d, { expose: _ }) {
  const c = p("crud").form, m = p("matSpecRef"), g = I(() => ({ classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], materialSnNew: [{ required: true, message: "请选择材料编码", trigger: "blur" }], thickness: [{ required: true, message: "请输入厚", trigger: "blur" }] })), { tableValidate: b, wrongCellMask: y, cleanUpData: h } = z({ rules: g, errorMsg: "请修正【钢板清单】中标红的信息" });
  function N(e) {
    return console.log(e, "row"), B({ uid: T(), materialSn: e.sn, specificationLabels: e.specificationLabels, classifySerialNumber: e.classify.serialNumber, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullPathId: e.classify.fullPathId, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, thickness: e.thickness, materialSnNew: e.materialSnNew, specificationNew: e.specificationNew });
  }
  function k(e, s) {
    m.value ? m.value.delListItem(e, s) : c.steelPlateList.splice(s, 1);
  }
  function S() {
    if (H(c.steelPlateList)) return true;
    const { validResult: e, dealList: s } = b(c.steelPlateList);
    return e && (h(s), s == null || s.forEach((l) => {
      l.specificationNew = l.specification ? `${l.thickness} * ${l.specification}` : `${l.thickness}`;
    })), e;
  }
  return _({ validate: S, rowInit: N }), (e, s) => {
    const l = D, P = E, V = r("common-input-number"), x = $, C = r("common-button"), U = r("common-table"), v = F("empty-text");
    return L(), q(U, R({ "cell-class-name": f(y), data: f(c).steelPlateList, "max-height": d.maxHeight, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: i(() => [t(l, { align: "center", fixed: "left", label: "序号" }, { default: i(({ $index: a }) => [o("span", null, u(a + 1), 1)]), _: 1 }), t(l, { align: "center", label: "编号", prop: "materialSn" }, { default: i(({ row: a }) => [o("span", null, u(a.materialSn), 1)]), _: 1 }), t(l, { align: "center", label: "物料名称", prop: "classifyName", "show-overflow-tooltip": "" }, { default: i(({ row: a }) => [t(P, { content: a.classifyParentFullName, disabled: !a.classifyParentFullName, "show-after": 500, placement: "top" }, { default: i(() => [M(o("span", null, null, 512), [[v, a.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), t(l, { align: "center", label: "规格", prop: "specification" }, { default: i(({ row: a }) => [o("span", null, u(a.specification), 1)]), _: 1 }), t(l, { align: "center", label: "厚", prop: "thickness" }, { default: i(({ row: a }) => [t(V, { modelValue: a.thickness, "onUpdate:modelValue": (n) => a.thickness = n, controls: false, max: 999999999, min: 1e-6, step: 1, placeholder: "厚", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(l, { align: "center", label: "材料编码", prop: "materialSnNew" }, { default: i(({ row: a }) => [t(x, { modelValue: a.materialSnNew, "onUpdate:modelValue": (n) => a.materialSnNew = n, modelModifiers: { trim: true }, maxlength: "20", placeholder: "材料编码", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(l, { align: "center", fixed: "right", label: "操作" }, { default: i(({ row: a, $index: n }) => [t(C, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (j) => k(a.materialSn, n, a) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data", "max-height"]);
  };
} };
export {
  G as default
};
