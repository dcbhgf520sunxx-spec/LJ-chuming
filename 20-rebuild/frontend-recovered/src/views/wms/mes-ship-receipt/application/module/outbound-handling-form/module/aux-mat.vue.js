import { ref as c } from "vue";
import { computed as v } from "vue";
import { provide as C } from "vue";
import { watch as N } from "vue";
import { openBlock as W } from "vue";
import { createBlock as E } from "vue";
import { withCtx as V } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as I } from "vue";
import { ElForm as M } from "element-plus";
import { _ as S, hW as Q, bC as j, cS as _, iX as y, ky as h, qS as l, b as q, V as A } from "../../../../../../../shared/runtime.js";
import F from "../components/common-form-item.vue.js";
import B from "../components/common-material-info.vue.js";
import "../components/produce-form.vue.js";
const D = { class: "material-info" }, Y = { class: "form-info" }, z = { __name: "aux-mat", props: { basicClass: { type: Number }, currentRow: { type: Object, default: () => ({}) }, material: { type: Object } }, setup(w, { expose: R }) {
  const { mesWorkShopName: T } = Q(), m = c({}), t = w, p = (r, e, u) => {
    if (q(e)) return u(new Error("请填写数量"));
    if (e <= 0) return u(new Error("数量必须大于0"));
    if (e > f.value) return u(new Error("数量不可超过可操作数量"));
    u();
  }, d = c({ outboundQuantity: [{ required: true, validator: p, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }], projectId: [{ required: true, message: "请选择出库项目", trigger: "change" }], mesWorkshopId: [{ required: true, message: "请选择领用车间", trigger: "change" }] }), a = c(), n = c({}), o = v(() => t.material || {});
  j(a, n, ["outboundQuantity"]);
  const f = v(() => {
    let r = 0;
    const e = o.value.corOperableQuantity;
    if (o.value.outboundUnitType === _.MEASURE.V) {
      const u = y(o.value.mete / o.value.quantity, o.value.accountingPrecision), i = t.currentRow.actualCanOutWarehouseWeight - (t.currentRow.currentOutboundMete || 0) ? Math.floor((t.currentRow.actualCanOutWarehouseWeight - (t.currentRow.currentOutboundMete || 0)) / u * (o.value.measurePrecision ? 10 ** o.value.measurePrecision : 1)) / (o.value.measurePrecision ? 10 ** o.value.measurePrecision : 1) : 0;
      i > e ? r = e : r = i;
    } else {
      const u = Math.floor((t.currentRow.actualCanOutWarehouseWeight - (t.currentRow.currentOutboundMete || 0)) * (o.value.accountingPrecision ? 10 ** o.value.accountingPrecision : 1)) / (o.value.accountingPrecision ? 10 ** o.value.accountingPrecision : 1);
      u > e ? r = e : r = u;
    }
    return r;
  });
  C("maxQuantity", f), N(o, (r) => {
    O(r);
  }, { immediate: true });
  function O(r) {
    var u, i, s;
    const e = { materialId: r.id, monomerId: r == null ? void 0 : r.monomerId, areaId: r == null ? void 0 : r.areaId, mesWorkshopId: ((u = T.value) == null ? void 0 : u.findIndex((x) => {
      var b;
      return x.id === ((b = r.workshop) == null ? void 0 : b.id);
    })) > -1 ? (i = r.workshop) == null ? void 0 : i.id : void 0, outboundUnit: r.outboundUnit, outboundUnitPrecision: r.outboundUnitPrecision, outboundAddress: ((s = t.currentRow) == null ? void 0 : s.useProperty) === h.CONSTRUCTION_SITE.V ? l.CONSTRUCTION_SITE.V : l.FACTORY.V, projectId: r.project ? r.project.id : void 0, recipientId: void 0, outboundQuantity: void 0, remark: void 0 };
    n.value = e, d.value = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], outboundQuantity: [{ required: true, validator: p, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, e.projectId && (d.value.projectId = { required: true, message: "项目库辅材必须选择项目出库", trigger: "change" });
  }
  async function P() {
    var s;
    if (m.value = {}, !await a.value.validate()) return false;
    let e = A(n.value);
    e = { ...e, outboundUnitType: t.material.outboundUnitType, unitNet: t.material.unitNet };
    const u = { ...t.material, materialId: t.material.id, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, outboundAddress: ((s = t.currentRow) == null ? void 0 : s.useProperty) === h.CONSTRUCTION_SITE.V ? l.CONSTRUCTION_SITE.V : l.FACTORY.V, remark: e.remark, outboundQuantity: t.material.outboundUnitType === _.MEASURE.V ? e.outboundQuantity : void 0, outboundMete: y(e.outboundMete, t.material.accountingPrecision), boolPartyA: t.material.boolPartyA, mesWorkshopId: e.mesWorkshopId, projectId: e.projectId, recipientId: e.recipientId, uid: t.currentRow.uid, partName: t.currentRow.name, mesWorkshop: e.mesWorkshopId ? e.mesWorkshop : {}, userInfo: e.recipientId ? e.userInfo : {} };
    return m.value = u, true;
  }
  function U() {
    a.value.resetFields();
  }
  function k() {
    a.value && a.value.clearValidate();
  }
  return R({ submit: P, resetForm: U, clearValidate: k, form: n, submitData: m }), (r, e) => {
    const u = M;
    return W(), E(u, { ref_key: "formRef", ref: a, model: n.value, rules: d.value, class: "form", "label-position": "left", "label-width": "120px", size: "default" }, { default: V(() => [g("div", D, [I(B, { form: n.value, material: o.value }, null, 8, ["form", "material"])]), g("div", Y, [I(F, { form: n.value, material: o.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model", "rules"]);
  };
} }, K = S(z, [["__scopeId", "data-v-657f09b3"]]);
export {
  K as default
};
