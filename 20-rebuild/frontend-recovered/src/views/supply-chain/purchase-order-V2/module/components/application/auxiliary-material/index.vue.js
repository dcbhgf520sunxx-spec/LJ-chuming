import { inject as P } from "vue";
import { watchEffect as B } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as O } from "vue";
import { openBlock as c } from "vue";
import { createBlock as d } from "vue";
import { withCtx as o } from "vue";
import { createVNode as a } from "vue";
import { unref as u } from "vue";
import { createCommentVNode as q } from "vue";
import { withDirectives as m } from "vue";
import { createElementVNode as x } from "vue";
import { createElementBlock as p } from "vue";
import { createTextVNode as _ } from "vue";
import { toDisplayString as f } from "vue";
import { mergeProps as Q } from "vue";
import { reactive as W } from "vue";
import { watch as G } from "vue";
import { ElTableColumn as K } from "element-plus";
import { ElTooltip as X } from "element-plus";
import { ElInput as Z } from "element-plus";
import { am as H, jY as J, i as b, iX as g, D as I, cS as R, uY as w, fv as ee, fE as k, aw as te, aI as ae, c9 as ne, uZ as le } from "../../../../../../../shared/runtime.js";
import { _ as ie } from "../../../../../../../modules/factory-select-b8d0a4ac.js";
const se = { key: 1 }, oe = { key: 1 }, ye = { __name: "index", setup(ue, { expose: T }) {
  var U;
  H.MATERIAL.V, J();
  const h = P("matSpecRef"), n = (U = P("cu")) == null ? void 0 : U.form;
  B(() => {
    let e = 0;
    b(n.list) && n.list.forEach((l) => {
      e += Number(l.amount) || 0;
    }), n.amount = g(e, I.YUAN), n.mete = void 0, n.meteUnit = "";
  });
  const E = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (e, l) => l.measureUnit ? !!e : true, message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { pattern: ne, message: "核算量必须大于0", trigger: "blur" }], unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (e, l) => b(l.mete) && b(l.unitPrice) ? +g(l.mete * l.unitPrice, I.YUAN) == +e : false, message: "金额有误，请手动修改", trigger: "blur" }], factoryId: [{ validator: (e, l) => n.orderPlace === k.FACTORY.V ? !!e : true, message: "请选择工厂", trigger: "blur" }] }, { handleMeteChangeCalcPrice: A } = le("mete"), { tableValidate: F, wrongCellMask: M } = te({ rules: E });
  function S(e) {
    const l = W({ uid: ae(), sn: e.sn, specificationLabels: e.specificationLabels, serialNumber: e.serialNumber, classifyId: e.classify.id, classifyFullPathId: e.classify.fullPathId, classifyFullName: e.classify.fullName, classifyName: e.classify.name, classifyParentFullName: e.classify.parentFullName, basicClass: e.classify.basicClass, specification: e.spec, model: e.spec, specificationMap: e.specKV, measureUnit: e.classify.measureUnit, accountingUnit: e.classify.accountingUnit, accountingPrecision: e.classify.accountingPrecision, measurePrecision: e.classify.measurePrecision, outboundUnitType: e.classify.outboundUnitType, unitNet: e.unitNet, accountingUnitNet: e.accountingUnitNet, mete: void 0, quantity: void 0 });
    return V(l), l;
  }
  function V(e) {
    G([() => e.mete], () => A(e));
  }
  function j(e, l) {
    h.value ? h.value.delListItem(e, l) : n.list.splice(l, 1);
  }
  function D(e) {
    n.useRequisitions && (e.mete = g(e.quantity * e.unitNet, e.accountingPrecision));
  }
  function L(e) {
    n.useRequisitions && (e.quantity = g(e.mete * e.accountingUnitNet, e.measurePrecision));
  }
  function Y() {
    const { validResult: e, dealList: l } = F(n.list);
    return n.list = l, e;
  }
  return T({ rowInit: S, validate: Y, rowWatch: V }), (e, l) => {
    const s = K, N = X, v = y("common-input-number"), C = Z, $ = y("common-button"), z = y("common-table"), r = O("empty-text");
    return c(), d(z, Q(e.$attrs, { data: u(n).list, "cell-class-name": u(M), "show-empty-symbol": false, "return-source-data": "", "row-key": "uid" }), { default: o(() => [a(s, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), u(n).useRequisitions ? (c(), d(s, { key: 0, label: "申购单号", prop: "purchaseSN", fixed: "left", width: "140", align: "center" })) : q("", true), a(s, { prop: "serialNumber", "show-overflow-tooltip": "", label: "编号", align: "center", fixed: "left" }), a(s, { prop: "classifyName", label: "物料种类", align: "center", fixed: "left", "show-overflow-tooltip": "" }, { default: o(({ row: t }) => [a(N, { content: t.classifyParentFullName, disabled: !t.classifyParentFullName, "show-after": 500, placement: "top" }, { default: o(() => [m(x("span", null, null, 512), [[r, t.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), a(s, { prop: "specification", label: "规格", align: "center", fixed: "left", "show-overflow-tooltip": "" }, { default: o(({ row: t }) => [a(N, { content: t.specificationLabels, placement: "top" }, { default: o(() => [m(x("span", null, null, 512), [[r, t.specification]])]), _: 2 }, 1032, ["content"])]), _: 1 }), a(s, { prop: "measureUnit", label: "计量单位", align: "center" }, { default: o(({ row: t }) => [m((c(), p("span", null, [_(f(t.measureUnit), 1)])), [[r]])]), _: 1 }), a(s, { prop: "quantity", label: "数量", align: "center" }, { default: o(({ row: t }) => [t.measureUnit && (!u(n).useRequisitions || u(n).useRequisitions && t.outboundUnitType === u(R).MEASURE.V) ? (c(), d(v, { key: 0, modelValue: t.quantity, "onUpdate:modelValue": (i) => t.quantity = i, min: 0, max: 999999999, controls: false, step: 1, precision: t.measurePrecision, size: "default", placeholder: "数量", onChange: (i) => D(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : m((c(), p("span", se, [_(f(t.quantity || "-"), 1)])), [[r]])]), _: 1 }), a(s, { prop: "accountingUnit", label: "核算单位", align: "center" }, { default: o(({ row: t }) => [m((c(), p("span", null, [_(f(t.accountingUnit), 1)])), [[r]])]), _: 1 }), a(s, { prop: "mete", label: "核算量", align: "center" }, { default: o(({ row: t }) => [!u(n).useRequisitions || u(n).useRequisitions && t.outboundUnitType === u(R).ACCOUNTING.V ? (c(), d(v, { key: 0, modelValue: t.mete, "onUpdate:modelValue": (i) => t.mete = i, min: 1e-6, max: 999999999, controls: false, step: 1, precision: t.accountingPrecision, size: "default", placeholder: "核算量", onChange: (i) => L(t) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onChange"])) : (c(), p("span", oe, f(t.mete || "-"), 1))]), _: 1 }), a(w, { "weight-attribute": "mete" }), a(s, { prop: "color", label: "颜色", align: "center" }, { default: o(({ row: t }) => [a(C, { modelValue: t.color, "onUpdate:modelValue": (i) => t.color = i, modelModifiers: { trim: true }, maxlength: "20", size: "default", placeholder: "颜色" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), a(s, { prop: "brand", label: "品牌", align: "center" }, { default: o(({ row: t }) => [a(C, { modelValue: t.brand, "onUpdate:modelValue": (i) => t.brand = i, modelModifiers: { trim: true }, maxlength: "60", size: "default", placeholder: "品牌" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), a(s, { prop: "projectId", label: "所属项目", align: "center", "min-width": "180px" }, { default: o(({ row: t }) => [a(u(ee), { modelValue: t.projectId, "onUpdate:modelValue": (i) => t.projectId = i, class: "filter-item", style: { width: "100%" }, clearable: "", placeholder: "可选择项目搜索" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), u(n).orderPlace === u(k).FACTORY.V ? (c(), d(s, { key: 1, prop: "factoryId", label: "所属工厂", align: "center", width: "140px" }, { default: o(({ row: t }) => [a(ie, { modelValue: t.factoryId, "onUpdate:modelValue": (i) => t.factoryId = i, placeholder: "选择工厂" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : q("", true), a(s, { label: "操作", width: "70", align: "center", fixed: "right" }, { default: o(({ row: t, $index: i }) => [a($, { icon: "el-icon-delete", type: "danger", size: "default", onClick: (me) => j(t.sn, i) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 16, ["data", "cell-class-name"]);
  };
} };
export {
  ye as default
};
