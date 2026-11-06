import { inject as W } from "vue";
import { ref as x } from "vue";
import { computed as X } from "vue";
import { resolveComponent as p } from "vue";
import { resolveDirective as Z } from "vue";
import { withDirectives as w } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as N } from "vue";
import { createBlock as C } from "vue";
import { withCtx as d } from "vue";
import { createVNode as l } from "vue";
import { createElementVNode as I } from "vue";
import { unref as g } from "vue";
import { createCommentVNode as ee } from "vue";
import { toDisplayString as v } from "vue";
import { reactive as R } from "vue";
import { ElInput as te } from "element-plus";
import { vLoading as ae } from "element-plus";
import { _ as ie, tC as se, am as le, i as r, zw as ne, zx as oe, aw as ce, aI as j, b as ue, iX as U, D as de } from "../../../../../../../../shared/runtime.js";
const re = { style: {} }, me = { key: 0, class: "flex-rsc mtb-20", style: { "margin-left": "30px", width: "100%" } }, fe = { key: 1 }, pe = { __name: "gas-table", props: { boolPartyA: { type: Boolean, default: false }, fillableAmount: { type: Boolean, default: false }, order: { type: Object, default: () => {
} } }, setup(k, { expose: A }) {
  const f = k, P = W("matSpecRef"), { cu: u, form: s } = se(), V = x(le.GAS.V), S = x(false), F = x({ resizable: true }), z = x({ enabled: true, gt: 0, oSize: 10, scrollToTopOnChange: false, threshold: 80 }), L = { classifyId: [{ required: true, message: "请选择物料种类", trigger: "change" }], quantity: [{ validator: (t, a) => (a.measureUnit && r(a.measurePrecision) && r(a.quantity) && (a.quantity = U(a.quantity, a.measurePrecision)), a.measureUnit && r(a.measurePrecision) ? !!a.quantity : true), message: "请填写数量", trigger: "blur" }], mete: [{ required: true, message: "请填写核算量", trigger: "blur" }, { validator: (t, a) => (a.accountingUnit && r(a.accountingPrecision) && r(a.mete) && (a.mete = U(a.mete, a.accountingPrecision)), !!a.mete), message: "核算量必须大于0", trigger: "blur" }], projectId: [{ required: true, message: "请选择项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择仓库", trigger: "change" }], warehouseId: [{ required: true, message: "请选择存储位置", trigger: "change" }] }, B = { unitPrice: [{ required: true, message: "请填写单价", trigger: "blur" }], amount: [{ required: true, message: "请填写金额", trigger: "blur" }, { validator: (t, a) => r(a.mete) && r(a.unitPrice) ? +U(a.mete * a.unitPrice, de.YUAN) == +t : false, message: "金额有误，请手动修改", trigger: "blur" }] }, T = X(() => {
    let t = Object.assign({}, L);
    return !f.boolPartyA && f.fillableAmount && (t = Object.assign(t, B)), t;
  }), D = /* @__PURE__ */ new Map([["projectId", -1], ["workshopId", -1], ["warehouseId", -1]]), { tableValidate: M, cleanUpData: O, wrongCellMask: E } = ce({ rules: T, ditto: D });
  function $({ row: t, rowIndex: a }) {
    var e, o;
    if ((o = (e = u == null ? void 0 : u.submitResult) == null ? void 0 : e.data) != null && o.includes(t.classifyId)) return { backgroundColor: "#ffdede" };
  }
  function J(t) {
    const a = R({ uid: j(), sn: t.sn, specificationLabels: t.specificationLabels, serialNumber: t.serialNumber, classifyId: t.classify.id, classifySerialNumber: t.classify.serialNumber, classifyFullName: t.classify.fullName, classifyName: t.classify.name, classifyParentFullName: t.classify.parentFullName, basicClass: t.classify.basicClass, specification: t.spec, specificationMap: t.specKV, measureUnit: t.classify.measureUnit, accountingUnit: t.classify.accountingUnit, accountingPrecision: t.classify.accountingPrecision, measurePrecision: t.classify.measurePrecision, quantity: void 0, projectId: s.list.length > 0 ? -1 : void 0, workshopId: s.list.length > 0 ? -1 : void 0, warehouseId: s.list.length > 0 ? -1 : void 0 });
    return !f.boolPartyA && f.fillableAmount && (a.unitPrice = void 0, a.amount = void 0), a;
  }
  function Q(t, a, e) {
    var o, n, y, h;
    if ((n = (o = u == null ? void 0 : u.submitResult) == null ? void 0 : o.data) != null && n.includes(e.classifyId)) {
      const c = (y = u == null ? void 0 : u.submitResult) == null ? void 0 : y.data.findIndex((b) => b === e.classifyId);
      s.list.filter((b) => b.classifyId === e.classifyId).length === 1 && ((h = u == null ? void 0 : u.submitResult) == null || h.data.splice(c, 1));
    }
    if (P.value ? P.value.delListItem(t, a) : s.list.splice(a, 1), r(s.list) && s.list.length > 0) {
      const c = s.list[0];
      s.list[0].projectId = c.projectId && c.projectId !== -1 ? c.projectId : void 0, s.list[0].workshopId = c.workshopId && c.workshopId !== -1 ? c.workshopId : void 0, s.list[0].warehouseId = c.warehouseId && c.warehouseId !== -1 ? c.warehouseId : void 0;
    }
  }
  function Y(t, a) {
    const e = JSON.parse(JSON.stringify(t)), o = R({ uid: j(), sn: t.sn, specificationLabels: e.specificationLabels, classifySerialNumber: e.classifySerialNumber, serialNumber: e.serialNumber, classifyId: e.classifyId, classifyFullPathId: e.classifyFullPathId, classifyFullName: e.classifyFullName, classifyName: e.classifyName, classifyParentFullName: e.classifyParentFullName, basicClass: e.basicClass, specification: e.specification, model: e.model, specificationMap: e.specificationMap, measureUnit: e.measureUnit, accountingUnit: e.accountingUnit, accountingPrecision: e.accountingPrecision, measurePrecision: e.measurePrecision, outboundUnitType: e.outboundUnitType, unitNet: e.unitNet, accountingUnitNet: e.accountingUnitNet, mete: e.mete, quantity: e.quantity, projectId: e.projectId, workshopId: e.workshopId, warehouseId: e.warehouseId, color: e.color, rowIndex: s.list.length, unitPrice: f.boolPartyA || !f.fillableAmount ? void 0 : e.unitPrice, amount: f.boolPartyA || !f.fillableAmount ? void 0 : e.amount });
    s.list.push(o), P.value.initSelected([o]);
  }
  function G() {
    if (ue(s.list)) return true;
    const t = s.list.filter((e, o) => (e.dataIndex = o, true)), { validResult: a } = M(t);
    return a && (O(t), t.forEach((e) => {
      var o, n;
      s.list[e.dataIndex].projectId = e.projectId, s.list[e.dataIndex].workshopId = e.workshopId || ((o = e.workshop) == null ? void 0 : o.id), s.list[e.dataIndex].warehouseId = e.warehouseId || ((n = e.warehouse) == null ? void 0 : n.id), s.list[e.dataIndex].quantity = e.measureUnit && r(e.measurePrecision) ? e.quantity : void 0;
    })), a;
  }
  return A({ rowInit: J, validate: G }), (t, a) => {
    const e = te, o = p("inbound-info-table"), n = p("vxe-column"), y = p("vxe-tooltip"), h = p("common-input-number"), c = p("common-button"), q = p("vxe-table"), b = Z("empty-text"), H = ae;
    return w((_(), N("div", null, [(_(), C(q, { key: `inbound_${V.value}`, "cell-class-name": g(E), "column-config": F.value, data: g(s).list, "empty-text": "暂无数据", "max-height": t.maxHeight, "row-style": $, "scroll-y": z.value, border: "", class: "myTable-style", "show-footer-overflow": "", "show-header-overflow": "", "show-overflow": "tooltip" }, { default: d(() => [l(n, { type: "expand", width: "60" }, { content: d(({ row: i }) => [I("div", re, [l(e, { modelValue: i.remark, "onUpdate:modelValue": (m) => i.remark = m, autosize: { minRows: 1, maxRows: 1 }, rows: 1, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "400px" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"]), g(r)(i.inboundList) ? (_(), N("div", me, [l(o, { "basic-class": V.value, list: i.inboundList, material: i, stripe: false }, null, 8, ["basic-class", "list", "material"])])) : ee("", true)])]), _: 1 }), l(n, { title: "序号", type: "seq", width: "55" }), l(n, { align: "center", title: "编号", "min-width": "110px", field: "serialNumber" }), l(n, { align: "center", field: "classifyName", "min-width": "100", title: "物料种类" }, { default: d(({ row: i }) => [l(y, { content: i.classifyParentFullName, disabled: !i.classifyParentFullName, "show-after": 500, placement: "top" }, { default: d(() => [w(I("span", null, null, 512), [[b, i.classifyName]])]), _: 2 }, 1032, ["content", "disabled"])]), _: 1 }), l(n, { align: "center", field: "specification", "min-width": "100", "show-overflow-tooltip": "", title: "规格" }, { default: d(({ row: i }) => [l(y, { content: i.specificationLabels, placement: "top" }, { default: d(() => [I("span", null, v(i.specification), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), l(n, { align: "center", field: "measureUnit", "min-width": "100", title: "计量单位" }, { default: d(({ row: i }) => [I("span", null, v(i.measureUnit || "-"), 1)]), _: 1 }), l(n, { align: "center", field: "quantity", "min-width": "135px", title: "数量" }, { default: d(({ row: i }) => [g(r)(i.measureUnit) ? (_(), C(h, { key: 0, modelValue: i.quantity, "onUpdate:modelValue": (m) => i.quantity = m, controls: false, max: 999999999, min: 0, precision: i.measurePrecision, step: 1, placeholder: "数量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])) : (_(), N("span", fe, v(i.quantity), 1))]), _: 1 }), l(n, { align: "center", field: "accountingUnit", "min-width": "100", title: "核算单位" }, { default: d(({ row: i }) => [I("span", null, v(i.accountingUnit || "-"), 1)]), _: 1 }), l(n, { align: "center", field: "mete", "min-width": "120px", title: "核算量" }, { default: d(({ row: i }) => [l(h, { modelValue: i.mete, "onUpdate:modelValue": (m) => i.mete = m, controls: false, max: 999999999, min: 1e-6, precision: i.accountingPrecision, step: 1, placeholder: "核算量", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), l(n, { align: "center", field: "brand", title: "品牌", width: "120" }, { default: d(({ row: i }) => [l(e, { modelValue: i.brand, "onUpdate:modelValue": (m) => i.brand = m, modelModifiers: { trim: true }, maxlength: "60", placeholder: "品牌", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(ne, { list: g(s).list, order: k.order }, null, 8, ["list", "order"]), l(oe, { list: g(s).list, showWarehouse: "" }, null, 8, ["list"]), l(n, { align: "center", fixed: "right", title: "操作", width: "160" }, { default: d(({ row: i, rowIndex: m }) => [l(c, { icon: "el-icon-document-copy", size: "default", type: "success", onClick: (K) => Y(i, m) }, null, 8, ["onClick"]), l(c, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (K) => Q(i.sn, m, i) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["cell-class-name", "column-config", "data", "max-height", "scroll-y"]))])), [[H, S.value]]);
  };
} }, Ie = ie(pe, [["__scopeId", "data-v-6a1e827f"]]);
export {
  Ie as default
};
