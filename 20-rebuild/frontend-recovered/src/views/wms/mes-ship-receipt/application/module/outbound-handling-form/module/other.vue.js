import { ref as s } from "vue";
import { computed as b } from "vue";
import { provide as U } from "vue";
import { watch as C } from "vue";
import { openBlock as E } from "vue";
import { createBlock as N } from "vue";
import { withCtx as k } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as v } from "vue";
import { ElForm as V } from "element-plus";
import { _ as W, bC as x, cS as y, iX as I, ky as _, qS as c, b as S, V as M } from "../../../../../../../shared/runtime.js";
import Q from "../components/common-form-item.vue.js";
import j from "../components/common-material-info.vue.js";
import "../components/produce-form.vue.js";
const q = { class: "material-info" }, A = { class: "form-info" }, F = { __name: "other", props: { basicClass: { type: Number }, currentRow: { type: Object, default: () => ({}) }, material: { type: Object } }, setup(h, { expose: R }) {
  const t = h, l = s({}), d = (r, e, u) => {
    if (S(e)) return u(new Error("请填写数量"));
    if (e <= 0) return u(new Error("数量必须大于0"));
    if (e > p.value) return u(new Error("数量不可超过可操作数量"));
    u();
  }, m = s({ outboundQuantity: [{ required: true, validator: d, trigger: "blur" }], mesWorkshopId: [{ required: true, message: "请选择领用车间", trigger: "change" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }), a = s(), n = s({}), o = b(() => t.material || {});
  x(a, n, ["outboundQuantity"]);
  const p = b(() => {
    let r = 0;
    const e = o.value.corOperableQuantity;
    if (o.value.outboundUnitType === y.MEASURE.V) {
      const u = I(o.value.mete / o.value.quantity, o.value.accountingPrecision), i = t.currentRow.actualCanOutWarehouseWeight - (t.currentRow.currentOutboundMete || 0) ? Math.floor((t.currentRow.actualCanOutWarehouseWeight - (t.currentRow.currentOutboundMete || 0)) / u * (o.value.measurePrecision ? 10 ** o.value.measurePrecision : 1)) / (o.value.measurePrecision ? 10 ** o.value.measurePrecision : 1) : 0;
      i > e ? r = e : r = i;
    } else {
      const u = Math.floor((t.currentRow.actualCanOutWarehouseWeight - (t.currentRow.currentOutboundMete || 0)) * (o.value.accountingPrecision ? 10 ** o.value.accountingPrecision : 1)) / (o.value.accountingPrecision ? 10 ** o.value.accountingPrecision : 1);
      u > e ? r = e : r = u;
    }
    return r;
  });
  U("maxQuantity", p), C(o, (r) => {
    T(r);
  }, { immediate: true });
  function T(r) {
    var u, i;
    const e = { materialId: r.id, monomerId: r == null ? void 0 : r.monomerId, areaId: r == null ? void 0 : r.areaId, factoryId: (u = r.factory) == null ? void 0 : u.id, outboundUnit: r.outboundUnit, outboundUnitPrecision: r.outboundUnitPrecision, outboundAddress: ((i = t.currentRow) == null ? void 0 : i.useProperty) === _.CONSTRUCTION_SITE.V ? c.CONSTRUCTION_SITE.V : c.FACTORY.V, projectId: r.project ? r.project.id : void 0, recipientId: void 0, outboundQuantity: void 0, remark: void 0 };
    n.value = e, m.value = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], projectId: [{ required: true, message: "请选择出库项目", trigger: "change" }], mesWorkshopId: [{ required: true, message: "请选择领用车间", trigger: "change" }], outboundQuantity: [{ required: true, validator: d, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, e.projectId && (m.value.projectId = { required: true, message: "项目库辅材必须选择项目出库", trigger: "change" });
  }
  async function w() {
    var f;
    if (l.value = {}, !await a.value.validate()) return false;
    let e = M(n.value);
    e = { ...e, outboundUnitType: t.material.outboundUnitType, unitNet: t.material.unitNet };
    const u = { ...t.material, materialId: t.material.id, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, outboundAddress: ((f = t.currentRow) == null ? void 0 : f.useProperty) === _.CONSTRUCTION_SITE.V ? c.CONSTRUCTION_SITE.V : c.FACTORY.V, remark: e.remark, outboundQuantity: t.material.outboundUnitType === y.MEASURE.V ? e.outboundQuantity : void 0, outboundMete: I(e.outboundMete, t.material.accountingPrecision), boolPartyA: t.material.boolPartyA, mesWorkshopId: e.mesWorkshopId, projectId: e.projectId, recipientId: e.recipientId, uid: t.currentRow.uid, partName: t.currentRow.name, mesWorkshop: e.mesWorkshopId ? e.mesWorkshop : {}, userInfo: e.recipientId ? e.userInfo : {} };
    return l.value = u, true;
  }
  function O() {
    a.value.resetFields();
  }
  function P() {
    a.value && a.value.clearValidate();
  }
  return R({ submit: w, resetForm: O, clearValidate: P, form: n, submitData: l }), (r, e) => {
    const u = V;
    return E(), N(u, { ref_key: "formRef", ref: a, model: n.value, rules: m.value, class: "form", "label-position": "left", "label-width": "120px", size: "default" }, { default: k(() => [g("div", q, [v(j, { form: n.value, material: o.value }, null, 8, ["form", "material"])]), g("div", A, [v(Q, { form: n.value, material: o.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model", "rules"]);
  };
} }, $ = W(F, [["__scopeId", "data-v-848347eb"]]);
export {
  $ as default
};
