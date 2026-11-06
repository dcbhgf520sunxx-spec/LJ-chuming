import { ref as d } from "vue";
import { computed as f } from "vue";
import { provide as C } from "vue";
import { watch as N } from "vue";
import { openBlock as W } from "vue";
import { createBlock as E } from "vue";
import { withCtx as V } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as v } from "vue";
import { ElForm as x } from "element-plus";
import { _ as S, hW as M, bC as Q, cS as _, iX as y, ky as I, qS as c, V as A, b as j } from "../../../../../../../shared/runtime.js";
import F from "../components/common-form-item.vue.js";
import q from "../components/common-material-info.vue.js";
import "../components/produce-form.vue.js";
const B = { class: "material-info" }, D = { class: "form-info" }, Y = { __name: "gas", props: { basicClass: { type: Number }, currentRow: { type: Object, default: () => ({}) }, material: { type: Object } }, setup(g, { expose: h }) {
  const { mesWorkShopName: w } = M(), r = g, l = d({}), R = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], projectId: [{ required: true, message: "请选择出库项目", trigger: "change" }], mesWorkshopId: [{ required: true, message: "请选择领用车间", trigger: "change" }], outboundQuantity: [{ required: true, validator: (t, e, n) => {
    if (j(e)) return n(new Error("请填写数量"));
    if (e <= 0) return n(new Error("数量必须大于0"));
    if (e > m.value) return n(new Error("数量不可超过可操作数量"));
    n();
  }, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, a = d(), u = d({}), o = f(() => r.material || {});
  Q(a, u, ["outboundQuantity"]);
  const m = f(() => {
    let t = 0;
    const e = o.value.corOperableQuantity;
    if (o.value.outboundUnitType === _.MEASURE.V) {
      const n = y(o.value.mete / o.value.quantity, o.value.accountingPrecision), i = r.currentRow.actualCanOutWarehouseWeight - (r.currentRow.currentOutboundMete || 0) ? Math.floor((r.currentRow.actualCanOutWarehouseWeight - (r.currentRow.currentOutboundMete || 0)) / n * (o.value.measurePrecision ? 10 ** o.value.measurePrecision : 1)) / (o.value.measurePrecision ? 10 ** o.value.measurePrecision : 1) : 0;
      i > e ? t = e : t = i;
    } else {
      const n = Math.floor((r.currentRow.actualCanOutWarehouseWeight - (r.currentRow.currentOutboundMete || 0)) * (o.value.accountingPrecision ? 10 ** o.value.accountingPrecision : 1)) / (o.value.accountingPrecision ? 10 ** o.value.accountingPrecision : 1);
      n > e ? t = e : t = n;
    }
    return t;
  });
  C("maxQuantity", m), N(o, (t) => {
    T(t);
  }, { immediate: true });
  function T(t) {
    var n, i, s;
    const e = { materialId: t.id, monomerId: t == null ? void 0 : t.monomerId, areaId: t == null ? void 0 : t.areaId, mesWorkshopId: ((n = w.value) == null ? void 0 : n.findIndex((k) => {
      var p;
      return k.id === ((p = t.workshop) == null ? void 0 : p.id);
    })) > -1 ? (i = t.workshop) == null ? void 0 : i.id : void 0, outboundUnit: t.outboundUnit, outboundUnitPrecision: t.outboundUnitPrecision, outboundAddress: ((s = r.currentRow) == null ? void 0 : s.useProperty) === I.CONSTRUCTION_SITE.V ? c.CONSTRUCTION_SITE.V : c.FACTORY.V, projectId: t.project ? t.project.id : void 0, recipientId: void 0, outboundQuantity: void 0, remark: void 0 };
    u.value = e;
  }
  async function O() {
    var s;
    if (l.value = {}, !await a.value.validate()) return false;
    let e = A(u.value);
    e = { ...e, outboundUnitType: r.material.outboundUnitType, unitNet: r.material.unitNet };
    const n = { ...r.material, materialId: r.material.id, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, outboundAddress: ((s = r.currentRow) == null ? void 0 : s.useProperty) === I.CONSTRUCTION_SITE.V ? c.CONSTRUCTION_SITE.V : c.FACTORY.V, remark: e.remark, outboundQuantity: r.material.outboundUnitType === _.MEASURE.V ? e.outboundQuantity : void 0, outboundMete: y(e.outboundMete, r.material.accountingPrecision), boolPartyA: r.material.boolPartyA, mesWorkshopId: e.mesWorkshopId, projectId: e.projectId, recipientId: e.recipientId, uid: r.currentRow.uid, partName: r.currentRow.name, mesWorkshop: e.mesWorkshopId ? e.mesWorkshop : {}, userInfo: e.recipientId ? e.userInfo : {} };
    return l.value = n, true;
  }
  function P() {
    a.value.resetFields();
  }
  function U() {
    a.value && a.value.clearValidate();
  }
  return h({ submit: O, resetForm: P, clearValidate: U, form: u, submitData: l }), (t, e) => {
    const n = x;
    return W(), E(n, { ref_key: "formRef", ref: a, model: u.value, rules: R, class: "form", "label-position": "left", "label-width": "120px", size: "default" }, { default: V(() => [b("div", B, [v(q, { form: u.value, material: o.value }, null, 8, ["form", "material"])]), b("div", D, [v(F, { form: u.value, material: o.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model"]);
  };
} }, K = S(Y, [["__scopeId", "data-v-56eedf1c"]]);
export {
  K as default
};
