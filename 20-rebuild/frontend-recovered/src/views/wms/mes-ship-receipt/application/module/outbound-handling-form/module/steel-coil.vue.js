import { ref as v } from "vue";
import { computed as h } from "vue";
import { watch as x } from "vue";
import { resolveComponent as B } from "vue";
import { resolveDirective as M } from "vue";
import { unref as y } from "vue";
import { openBlock as S } from "vue";
import { createBlock as A } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as c } from "vue";
import { toDisplayString as Q } from "vue";
import { withDirectives as L } from "vue";
import { createCommentVNode as j } from "vue";
import { ElFormItem as F } from "element-plus";
import { ElForm as q } from "element-plus";
import { _ as Y, hW as D, sQ as H, bC as $, iX as w, ky as O, qS as f, V as z, yQ as G, b as K } from "../../../../../../../shared/runtime.js";
import X from "../components/common-form-item.vue.js";
import J from "../components/common-material-info.vue.js";
import "../components/produce-form.vue.js";
const Z = { style: { "min-width": "800px" } }, ee = { style: { display: "flex" } }, te = { class: "form" }, oe = { class: "material-info" }, re = { __name: "steel-coil", props: { basicClass: { type: Number }, material: { type: Object }, currentRow: { type: Object, default: () => ({}) }, maxHeight: { type: Number } }, setup(C, { expose: N }) {
  const _ = { BY_LENGTH: { L: "按长度出库", K: "BY_LENGTH ", V: 1 }, BY_PLATE: { L: "按条板出库", K: "BY_PLATE", V: 2 } }, { mesWorkShopName: T } = D(), o = C, b = v({}), s = v(), a = v({ list: [] }), { loaded: V, baseUnit: I } = H(o.basicClass);
  $(s, a, ["outboundQuantity"]);
  const r = h(() => o.material || {}), k = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], outboundQuantity: [{ required: true, validator: (t, e, n) => {
    if (K(e)) return n(new Error("请填写数量"));
    if (e <= 0) return n(new Error("数量必须大于0"));
    if (e > R.value) return n(new Error("数量不可超过可操作数量"));
    n();
  }, trigger: "blur" }], projectId: [{ required: true, message: "请选择出库项目", trigger: "change" }], mesWorkshopId: [{ required: true, message: "请选择领用车间", trigger: "change" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, E = h(() => Object.assign({}, k)), R = h(() => {
    const t = r.value.corOperableQuantity, e = w(r.value.mete / r.value.quantity, r.value.accountingPrecision), n = o.currentRow.actualCanOutWarehouseWeight - (o.currentRow.currentOutboundMete || 0) ? Math.floor((o.currentRow.actualCanOutWarehouseWeight - (o.currentRow.currentOutboundMete || 0)) / e * (r.value.measurePrecision ? 10 ** r.value.measurePrecision : 1)) / (r.value.measurePrecision ? 10 ** r.value.measurePrecision : 1) : 0;
    return n > t ? t : n;
  });
  x(r, (t) => {
    g(t);
  }, { immediate: true });
  function g(t) {
    var n, u, i;
    const e = { materialOutboundMode: _.BY_LENGTH.V, materialId: t.id, monomerId: t == null ? void 0 : t.monomerId, areaId: t == null ? void 0 : t.areaId, mesWorkshopId: ((n = T.value) == null ? void 0 : n.findIndex((l) => {
      var p;
      return l.id === ((p = t.workshop) == null ? void 0 : p.id);
    })) > -1 ? (u = t.workshop) == null ? void 0 : u.id : void 0, outboundUnit: t.outboundUnit, outboundUnitPrecision: t.outboundUnitPrecision, projectId: t.project ? t.project.id : void 0, recipientId: void 0, outboundAddress: ((i = o.currentRow) == null ? void 0 : i.useProperty) === O.CONSTRUCTION_SITE.V ? f.CONSTRUCTION_SITE.V : f.FACTORY.V, remark: void 0 };
    a.value = e;
  }
  async function P() {
    var i, l;
    if (b.value = {}, !await s.value.validate()) return false;
    let e = z(a.value);
    e = { ...e, outboundUnitType: o.material.outboundUnitType, unitNet: o.material.unitNet };
    const n = { ...o.material, materialId: o.material.id, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, outboundAddress: ((i = o.currentRow) == null ? void 0 : i.useProperty) === O.CONSTRUCTION_SITE.V ? f.CONSTRUCTION_SITE.V : f.FACTORY.V, materialOutboundMode: G.WHOLE.V, remark: e.remark, outboundQuantity: e.outboundQuantity, outboundMete: w(e.outboundMete, o.material.accountingPrecision), boolPartyA: o.material.boolPartyA, mesWorkshopId: e.mesWorkshopId, projectId: e.projectId, recipientId: e.recipientId, uid: (l = o.currentRow) == null ? void 0 : l.uid, partName: o.currentRow.name, mesWorkshop: e.mesWorkshopId ? e.mesWorkshop : {}, userInfo: e.recipientId ? e.userInfo : {} };
    return b.value = n, true;
  }
  function U() {
    s.value.resetFields(), g(r);
  }
  function W() {
    s.value && s.value.clearValidate();
  }
  return N({ submit: P, resetForm: U, clearValidate: W, form: a, submitData: b }), (t, e) => {
    const n = B("common-radio"), u = F, i = q, l = M("empty");
    return y(V) ? (S(), A(i, { key: 0, ref_key: "formRef", ref: s, model: a.value, rules: E.value, "label-position": "left", "label-width": "120px", size: "default", style: { display: "flex", overflow: "auto" } }, { default: d(() => [m("div", Z, [c(u, { class: "material-outbound-mode-info", label: "出库方式" }, { default: d(() => [m("div", ee, [c(n, { modelValue: a.value.materialOutboundMode, "onUpdate:modelValue": e[0] || (e[0] = (p) => a.value.materialOutboundMode = p), options: _, unshowVal: [_.BY_PLATE.V], size: "default", type: "enum", onChange: t.materialOutboundModeChange }, null, 8, ["modelValue", "unshowVal", "onChange"])])]), _: 1 }), m("div", te, [m("div", oe, [c(J, { form: a.value, material: r.value }, { afterSpec: d(() => [c(u, { label: "厚 * 宽" }, { default: d(() => [m("span", null, Q(`${r.value.thickness}${y(I).thickness.unit} * ${r.value.width}${y(I).width.unit}`), 1)]), _: 1 })]), afterBrand: d(() => [c(u, { label: "炉批号/卷号" }, { default: d(() => [L(m("span", null, null, 512), [[l, { val: r.value.heatNoAndBatchNo }]])]), _: 1 })]), _: 1 }, 8, ["form", "material"])]), c(X, { form: a.value, material: r.value }, null, 8, ["form", "material"])])])]), _: 1 }, 8, ["model", "rules"])) : j("", true);
  };
} }, de = Y(re, [["__scopeId", "data-v-1fbc5889"]]);
export {
  de as default
};
