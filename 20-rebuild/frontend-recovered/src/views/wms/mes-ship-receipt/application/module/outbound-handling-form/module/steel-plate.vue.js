import { ref as _ } from "vue";
import { computed as I } from "vue";
import { provide as Q } from "vue";
import { watch as M } from "vue";
import { unref as d } from "vue";
import { openBlock as S } from "vue";
import { createBlock as x } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as c } from "vue";
import { toDisplayString as g } from "vue";
import { createCommentVNode as F } from "vue";
import { ElFormItem as j } from "element-plus";
import { ElForm as q } from "element-plus";
import { _ as A, hW as B, sQ as $, bC as D, iX as O, ky as w, qS as p, yQ as N, yP as H, V as L, b as z } from "../../../../../../../shared/runtime.js";
import Y from "../components/common-form-item.vue.js";
import G from "../components/common-material-info.vue.js";
import "../components/produce-form.vue.js";
const X = { class: "material-info" }, J = { class: "form-info" }, K = { __name: "steel-plate", props: { basicClass: { type: Number }, currentRow: { type: Object, default: () => ({}) }, material: { type: Object } }, setup(k, { expose: C }) {
  const { mesWorkShopName: T } = B(), r = k, f = _({}), R = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], projectId: [{ required: true, message: "请选择出库项目", trigger: "change" }], mesWorkshopId: [{ required: true, message: "请选择领用车间", trigger: "change" }], materialOutboundMode: [{ required: true, message: "请选择物料出库方式", trigger: "change" }], outboundQuantity: [{ required: true, validator: (t, e, o) => {
    if (z(e)) return o(new Error("请填写数量"));
    if (e <= 0) return o(new Error("数量必须大于0"));
    if (e > h.value) return o(new Error("数量不可超过可操作数量"));
    o();
  }, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, a = _(), u = _({ outboundQuantity: void 0 }), n = I(() => r.material || {}), { loaded: U, baseUnit: b } = $(r.basicClass);
  D(a, u, ["outboundQuantity", "halfSize"]);
  const h = I(() => {
    const t = n.value.corOperableQuantity, e = O(n.value.mete / n.value.quantity, n.value.accountingPrecision), o = r.currentRow.actualCanOutWarehouseWeight - (r.currentRow.currentOutboundMete || 0) ? Math.floor((r.currentRow.actualCanOutWarehouseWeight - (r.currentRow.currentOutboundMete || 0)) / e) : 0;
    return o > t ? t : o;
  });
  Q("maxQuantity", h), M(n, (t) => {
    y(t);
  }, { immediate: true, deep: true });
  function y(t) {
    var o, i, s;
    const e = { materialId: t.id, monomerId: t == null ? void 0 : t.monomerId, areaId: t == null ? void 0 : t.areaId, mesWorkshopId: ((o = T.value) == null ? void 0 : o.findIndex((P) => {
      var v;
      return P.id === ((v = t.workshop) == null ? void 0 : v.id);
    })) > -1 ? (i = t.workshop) == null ? void 0 : i.id : void 0, outboundUnit: t.outboundUnit, outboundUnitPrecision: t.outboundUnitPrecision, outboundAddress: ((s = r.currentRow) == null ? void 0 : s.useProperty) === w.CONSTRUCTION_SITE.V ? p.CONSTRUCTION_SITE.V : p.FACTORY.V, projectId: t.project ? t.project.id : void 0, materialOutboundMode: N.WHOLE.V, halfMode: H.LENGTH.V, recipientId: void 0, outboundQuantity: void 0, remark: void 0 };
    u.value = e;
  }
  async function W() {
    var s;
    if (f.value = {}, !await a.value.validate()) return false;
    let e = L(u.value);
    e = { ...e, outboundUnitType: r.material.outboundUnitType, unitNet: r.material.unitNet };
    const o = { ...r.material, materialId: r.material.id, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, outboundAddress: ((s = r.currentRow) == null ? void 0 : s.useProperty) === w.CONSTRUCTION_SITE.V ? p.CONSTRUCTION_SITE.V : p.FACTORY.V, materialOutboundMode: N.WHOLE.V, remark: e.remark, outboundQuantity: e.outboundQuantity, outboundMete: O(e.outboundMete, r.material.accountingPrecision), boolPartyA: r.material.boolPartyA, mesWorkshopId: e.mesWorkshopId, projectId: e.projectId, recipientId: e.recipientId, uid: r.currentRow.uid, partName: r.currentRow.name, mesWorkshop: e.mesWorkshopId ? e.mesWorkshop : {}, userInfo: e.recipientId ? e.userInfo : {} };
    return f.value = o, true;
  }
  function E() {
    a.value && a.value.resetFields(), y(n);
  }
  function V() {
    a.value && a.value.clearValidate();
  }
  return C({ submit: W, resetForm: E, clearValidate: V, form: u, submitData: f }), (t, e) => {
    const o = j, i = q;
    return d(U) ? (S(), x(i, { key: 0, ref_key: "formRef", ref: a, model: u.value, rules: R, class: "form", "label-position": "left", "label-width": "120px", size: "default" }, { default: l(() => [m("div", X, [c(G, { form: u.value, material: n.value }, { afterSpec: l(() => [c(o, { label: "厚 * 宽 * 长" }, { default: l(() => [m("span", null, g(`${n.value.thickness}${d(b).thickness.unit} * ${n.value.width}${d(b).width.unit} * ${n.value.length}${d(b).length.unit}`), 1)]), _: 1 })]), afterBrand: l(() => [c(o, { label: "炉批号/卷号" }, { default: l(() => [m("span", null, g(n.value.heatNoAndBatchNo), 1)]), _: 1 })]), _: 1 }, 8, ["form", "material"])]), m("div", J, [c(Y, { form: u.value, material: n.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model"])) : F("", true);
  };
} }, ae = A(K, [["__scopeId", "data-v-c5cea5e2"]]);
export {
  ae as default
};
