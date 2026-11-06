import { inject as _ } from "vue";
import { computed as L } from "vue";
import { resolveComponent as g } from "vue";
import { resolveDirective as k } from "vue";
import { openBlock as M } from "vue";
import { createBlock as U } from "vue";
import { withCtx as i } from "vue";
import { createVNode as s } from "vue";
import { createElementVNode as f } from "vue";
import { toDisplayString as d } from "vue";
import { withDirectives as T } from "vue";
import { mergeProps as F } from "vue";
import { unref as y } from "vue";
import { reactive as D } from "vue";
import { ElTableColumn as R } from "element-plus";
import { ElTooltip as q } from "element-plus";
import { ElInput as B } from "element-plus";
import { aw as O, cP as b, aI as W, b as j } from "../../../../../../../../shared/runtime.js";
const $ = { __name: "section-steel", props: { maxHeight: { type: Number } }, setup(N, { expose: h }) {
  const o = _("crud").form, S = _("matSpecRef"), C = L(() => ({ classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], materialSnNew: [{ required: true, message: "请选择材料编码", trigger: "blur" }] })), { tableValidate: V, wrongCellMask: v, cleanUpData: I } = O({ rules: C, errorMsg: "请修正【型材清单】中标红的信息" });
  function x(e) {
    var r, u;
    let l;
    e.classify.basicClass === b.SECTION_STEEL.V && (l = (u = (r = e.nationalStandardOptions) == null ? void 0 : r.find((n) => n.boolDefault === true)) == null ? void 0 : u.standardId);
    const t = D({ uid: W(), materialSn: e.sn, specificationLabels: e.specificationLabels, classifySerialNumber: e.classify.serialNumber, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullPathId: e.classify.fullPathId, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, specificationNew: e.spec, specificationName: e.plateSpecKV, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, unitWeight: e.unitWeight, conversionVal: e.unitWeight, materialSnNew: e.materialSnNew, standardId: l, sectionSteelSpec: void 0, doNotSectionSteelSpec: void 0 });
    if (e.classify.basicClass === b.SECTION_STEEL.V) {
      let n;
      const m = [];
      for (const c in t.specificationMap) c.indexOf("standard") > -1 ? n = t.specificationMap[c] : m.push(t.specificationMap[c]);
      t.sectionSteelSpec = n, t.doNotSectionSteelSpec = m.join(" * ");
    }
    return t;
  }
  function P(e, l, t) {
    S.value ? S.value.delListItem(e, l) : o.sectionSteelList.splice(l, 1);
  }
  function E() {
    if (j(o.sectionSteelList)) return true;
    const { validResult: e, dealList: l } = V(o.sectionSteelList);
    return e && I(l), e;
  }
  return h({ rowInit: x, validate: E }), (e, l) => {
    const t = R, r = q, u = B, n = g("common-button"), m = g("common-table"), c = k("empty-text");
    return M(), U(m, F({ "cell-class-name": y(v), data: y(o).sectionSteelList, "max-height": N.maxHeight, "show-empty-symbol": false, stripe: false, "return-source-data": "", "row-key": "uid" }, e.$attrs), { default: i(() => [s(t, { align: "center", label: "序号" }, { default: i(({ $index: a }) => [f("span", null, d(a + 1), 1)]), _: 1 }), s(t, { align: "center", label: "编号", prop: "materialSn" }, { default: i(({ row: a }) => [f("span", null, d(a.materialSn), 1)]), _: 1 }), s(t, { align: "center", label: "物料名称", prop: "classifyName", "show-overflow-tooltip": "" }, { default: i(({ row: a }) => [s(r, { content: a.classifyParentFullName, disabled: !a.classifyParentFullName, "show-after": 500, placement: "top" }, { default: i(() => [T(f("span", null, null, 512), [[c, a.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), s(t, { align: "center", label: "规格", prop: "specification" }, { default: i(({ row: a }) => [f("span", null, d(a.specification), 1)]), _: 1 }), s(t, { align: "center", label: "材料编码", prop: "materialSnNew" }, { default: i(({ row: a }) => [s(u, { modelValue: a.materialSnNew, "onUpdate:modelValue": (p) => a.materialSnNew = p, modelModifiers: { trim: true }, maxlength: "20", placeholder: "材料编码", size: "default" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(t, { align: "center", fixed: "right", label: "操作" }, { default: i(({ row: a, $index: p }) => [s(n, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (z) => P(a.materialSn, p, a) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["cell-class-name", "data", "max-height"]);
  };
} };
export {
  $ as default
};
