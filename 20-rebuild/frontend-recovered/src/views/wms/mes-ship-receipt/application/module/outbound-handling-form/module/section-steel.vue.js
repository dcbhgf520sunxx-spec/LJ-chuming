import { ref as f } from "vue";
import { computed as I } from "vue";
import { provide as Q } from "vue";
import { watch as x } from "vue";
import { unref as h } from "vue";
import { openBlock as M } from "vue";
import { createBlock as P } from "vue";
import { withCtx as d } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as m } from "vue";
import { toDisplayString as y } from "vue";
import { createCommentVNode as F } from "vue";
import { ElFormItem as j } from "element-plus";
import { ElForm as q } from "element-plus";
import { _ as A, hW as B, sQ as D, bC as z, iX as v, ky as g, qS as c, yQ as O, V as L, b as $ } from "../../../../../../../shared/runtime.js";
import H from "../components/common-form-item.vue.js";
import Y from "../components/common-material-info.vue.js";
import "../components/produce-form.vue.js";
const X = { class: "material-info" }, G = { class: "form-info" }, J = { __name: "section-steel", props: { basicClass: { type: Number }, currentRow: { type: Object, default: () => ({}) }, material: { type: Object } }, setup(w, { expose: N }) {
  const { mesWorkShopName: C } = B(), r = w, p = f({}), k = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], projectId: [{ required: true, message: "请选择出库项目", trigger: "change" }], mesWorkshopId: [{ required: true, message: "请选择领用车间", trigger: "change" }], materialOutboundMode: [{ required: true, message: "请选择物料出库方式", trigger: "change" }], outboundQuantity: [{ required: true, validator: (t, e, o) => {
    if ($(e)) return o(new Error("请填写数量"));
    if (e <= 0) return o(new Error("数量必须大于0"));
    if (e > b.value) return o(new Error("数量不可超过可操作数量"));
    o();
  }, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, u = f(), a = f({}), n = I(() => r.material || {}), { loaded: T, baseUnit: R } = D(r.basicClass);
  z(u, a, ["outboundQuantity", "halfSize"]);
  const b = I(() => {
    const t = n.value.corOperableQuantity, e = v(n.value.mete / n.value.quantity, n.value.accountingPrecision), o = r.currentRow.actualCanOutWarehouseWeight - (r.currentRow.currentOutboundMete || 0) ? Math.floor((r.currentRow.actualCanOutWarehouseWeight - (r.currentRow.currentOutboundMete || 0)) / e) : 0;
    return o > t ? t : o;
  });
  Q("maxQuantity", b), x(n, (t) => {
    U(t);
  }, { immediate: true, deep: true });
  function U(t) {
    var o, i, s;
    const e = { materialId: t.id, monomerId: t == null ? void 0 : t.monomerId, areaId: t == null ? void 0 : t.areaId, mesWorkshopId: ((o = C.value) == null ? void 0 : o.findIndex((E) => {
      var _;
      return E.id === ((_ = t.workshop) == null ? void 0 : _.id);
    })) > -1 ? (i = t.workshop) == null ? void 0 : i.id : void 0, outboundUnit: t.outboundUnit, outboundUnitPrecision: t.outboundUnitPrecision, outboundAddress: ((s = r.currentRow) == null ? void 0 : s.useProperty) === g.CONSTRUCTION_SITE.V ? c.CONSTRUCTION_SITE.V : c.FACTORY.V, projectId: t.project ? t.project.id : void 0, materialOutboundMode: O.WHOLE.V, recipientId: void 0, outboundQuantity: void 0, remark: void 0 };
    a.value = e;
  }
  async function W() {
    var s;
    if (p.value = {}, !await u.value.validate()) return false;
    let e = L(a.value);
    e = { ...e, outboundUnitType: r.material.outboundUnitType, unitNet: r.material.unitNet };
    const o = { ...r.material, materialId: r.material.id, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, outboundAddress: ((s = r.currentRow) == null ? void 0 : s.useProperty) === g.CONSTRUCTION_SITE.V ? c.CONSTRUCTION_SITE.V : c.FACTORY.V, materialOutboundMode: O.WHOLE.V, remark: e.remark, outboundQuantity: e.outboundQuantity, outboundMete: v(e.outboundMete, r.material.accountingPrecision), boolPartyA: r.material.boolPartyA, mesWorkshopId: e.mesWorkshopId, projectId: e.projectId, recipientId: e.recipientId, uid: r.currentRow.uid, partName: r.currentRow.name, mesWorkshop: e.mesWorkshopId ? e.mesWorkshop : {}, userInfo: e.recipientId ? e.userInfo : {} };
    return p.value = o, true;
  }
  function S() {
    u.value.resetFields();
  }
  function V() {
    u.value && u.value.clearValidate();
  }
  return N({ submit: W, resetForm: S, clearValidate: V, form: a, submitData: p }), (t, e) => {
    const o = j, i = q;
    return h(T) ? (M(), P(i, { key: 0, ref_key: "formRef", ref: u, model: a.value, rules: k, class: "form", "label-position": "left", "label-width": "130px", size: "default" }, { default: d(() => [l("div", X, [m(Y, { form: a.value, material: n.value }, { afterSpec: d(() => [m(o, { label: "定尺长度" }, { default: d(() => [l("span", null, y(`${n.value.length}${h(R).length.unit}`), 1)]), _: 1 })]), afterBrand: d(() => [m(o, { label: "炉批号/卷号" }, { default: d(() => [l("span", null, y(n.value.heatNoAndBatchNo), 1)]), _: 1 })]), _: 1 }, 8, ["form", "material"])]), l("div", G, [m(H, { form: a.value, material: n.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model"])) : F("", true);
  };
} }, ne = A(J, [["__scopeId", "data-v-a71851d1"]]);
export {
  ne as default
};
