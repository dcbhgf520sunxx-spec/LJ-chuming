import { inject as F } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as R } from "vue";
import { openBlock as c } from "vue";
import { createBlock as g } from "vue";
import { withCtx as l } from "vue";
import { createVNode as a } from "vue";
import { withDirectives as r } from "vue";
import { createElementVNode as b } from "vue";
import { createElementBlock as p } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as x } from "vue";
import { unref as d } from "vue";
import { mergeProps as L } from "vue";
import { reactive as M } from "vue";
import { ElTableColumn as S } from "element-plus";
import { ElTooltip as T } from "element-plus";
import { tC as z, ky as B, aw as w, aI as D, c9 as j } from "../../../../../../shared/runtime.js";
const Q = { key: 1 }, J = { __name: "aux-mat-table", setup(K, { expose: U }) {
  const f = F("matSpecRef"), { form: u } = z(), v = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (t, i) => i.measureUnit ? !!t : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { pattern: j, message: "核算量必须大于0", trigger: "blur" }], useProperty: [{ required: true, message: "请选择使用范围", trigger: "change" }] }, { tableValidate: P, wrongCellMask: V } = w({ rules: v });
  function N(t) {
    return M({ uid: D(), sn: t.sn, specificationLabels: t.specificationLabels, serialNumber: t.serialNumber, classifyId: t.classify.id, classifyFullPathId: t.classify.fullPathId, classifyFullName: t.classify.fullName, classifyName: t.classify.name, classifyParentFullName: t.classify.parentFullName, basicClass: t.classify.basicClass, specification: t.spec, specificationMap: t.specKV, measureUnit: t.classify.measureUnit, accountingUnit: t.classify.accountingUnit, accountingPrecision: t.classify.accountingPrecision, measurePrecision: t.classify.measurePrecision, quantity: void 0, useProperty: void 0 });
  }
  function C(t, i) {
    f.value ? f.value.delListItem(t, i) : u.list.splice(i, 1);
  }
  function q() {
    const { validResult: t, dealList: i } = P(u.list);
    return u.list = i, t;
  }
  return U({ rowInit: N, validate: q }), (t, i) => {
    const n = S, y = T, _ = m("common-input-number"), k = m("common-select"), E = m("common-button"), I = m("common-table"), o = R("empty-text");
    return c(), g(I, L(t.$attrs, { data: d(u).list, "cell-class-name": d(V), "return-source-data": "", showEmptySymbol: false }), { default: l(() => [a(n, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), a(n, { prop: "serialNumber", label: "编号", align: "center", width: "110px", fixed: "left", "show-overflow-tooltip": "" }), a(n, { prop: "classifyName", label: "名称", align: "center", fixed: "left", "min-width": "150", "show-overflow-tooltip": "" }, { default: l(({ row: e }) => [a(y, { content: e.classifyParentFullName, disabled: !e.classifyParentFullName, "show-after": 500, placement: "top" }, { default: l(() => [r(b("span", null, null, 512), [[o, e.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), a(n, { prop: "specification", label: "规格", align: "center", "min-width": "200px", fixed: "left", "show-overflow-tooltip": "" }, { default: l(({ row: e }) => [a(y, { content: e.specificationLabels, placement: "top" }, { default: l(() => [r(b("span", null, null, 512), [[o, e.specification]])]), _: 2 }, 1032, ["content"])]), _: 1 }), a(n, { prop: "measureUnit", label: "计量单位", align: "center", "min-width": "70px" }, { default: l(({ row: e }) => [r((c(), p("span", null, [h(x(e.measureUnit), 1)])), [[o]])]), _: 1 }), a(n, { prop: "quantity", label: "数量", align: "center", "min-width": "120px" }, { default: l(({ row: e }) => [e.measureUnit ? (c(), g(_, { key: 0, modelValue: e.quantity, "onUpdate:modelValue": (s) => e.quantity = s, min: 0, max: 999999999, controls: false, step: 1, precision: e.measurePrecision, size: "default", placeholder: "数量" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : r((c(), p("span", Q, null, 512)), [[o]])]), _: 1 }), a(n, { prop: "accountingUnit", label: "核算单位", align: "center", "min-width": "70px" }, { default: l(({ row: e }) => [r((c(), p("span", null, [h(x(e.accountingUnit), 1)])), [[o]])]), _: 1 }), a(n, { prop: "mete", label: "核算量", align: "center", "min-width": "120px" }, { default: l(({ row: e }) => [a(_, { modelValue: e.mete, "onUpdate:modelValue": (s) => e.mete = s, min: 1e-6, max: 999999999, controls: false, step: 1, precision: e.accountingPrecision, size: "default", placeholder: "核算量" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), a(n, { prop: "useProperty", label: "使用范围", align: "center", "min-width": "120px" }, { default: l(({ row: e }) => [a(k, { modelValue: e.useProperty, "onUpdate:modelValue": (s) => e.useProperty = s, options: d(B).ENUM, type: "enum", size: "default", clearable: "", placeholder: "使用范围" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 1 }), a(n, { label: "操作", width: "70", align: "center", fixed: "right" }, { default: l(({ row: e, $index: s }) => [a(E, { icon: "el-icon-delete", type: "danger", size: "default", onClick: (A) => C(e.sn, s) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["data", "cell-class-name"]);
  };
} };
export {
  J as default
};
