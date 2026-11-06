import { computed as _ } from "vue";
import { ref as l } from "vue";
import { inject as C } from "vue";
import { provide as k } from "vue";
import { watch as P } from "vue";
import { unref as s } from "vue";
import { openBlock as j } from "vue";
import { createBlock as M } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as c } from "vue";
import { toDisplayString as g } from "vue";
import { createCommentVNode as O } from "vue";
import { ElFormItem as S } from "element-plus";
import { ElForm as T } from "element-plus";
import { _ as $, sQ as z, bC as D, i as H, V as L, qS as q, yQ as W, iX as K, jN as X, b as Y } from "../../../../../../shared/runtime.js";
import G from "../components/common-form-item.vue.js";
import J from "../components/common-material-info.vue.js";
import "../components/produce-form.vue.js";
const Z = { class: "material-info clearfix" }, ee = { class: "form-info" }, te = { __name: "steel-plate", props: { basicClass: { type: Number }, currentRow: { type: Object, default: () => ({}) }, material: { type: Object }, visible: { type: Boolean, default: false }, maxHeight: { type: Number, default: 100 } }, setup(m, { expose: x }) {
  const o = m, F = (n, u, e) => {
    if (Y(u)) return e(new Error("请填写数量"));
    if (u <= 0) return e(new Error("数量必须大于0"));
    if (u > y.value) return e(new Error("数量不可超过可操作数量"));
    e();
  }, I = _(() => ({ outboundQuantity: [{ required: true, validator: F, trigger: "blur" }] })), r = l(), t = l({ list: [] }), a = _(() => o.material || {}), N = C("mainCurrentRow"), f = l({}), { loaded: Q, baseUnit: p } = z(o.basicClass);
  D(r, t, ["quantity", "halfSize"]);
  const y = _(() => !t.value || !t.value.projectId || !a.value.projectFrozenForUnitKV ? a.value.corOperableQuantity : a.value.corOperableQuantity + (a.value.projectFrozenForUnitKV[t.value.projectId] || 0));
  k("maxQuantity", y), P(a, (n) => {
    h(n);
  }, { immediate: true, deep: true });
  function h(n) {
    if (H(n)) {
      const u = { materialId: n.id, outboundUnit: n.outboundUnit, outboundUnitPrecision: n.outboundUnitPrecision, uid: o.currentRow.uid, outboundQuantity: void 0, outboundMete: void 0, currentArea: void 0, currentLength: void 0 };
      t.value = u;
    }
  }
  function B() {
    t.value.outboundQuantity = void 0, t.value.outboundMete = void 0, t.value.currentArea = void 0, t.value.currentLength = void 0;
  }
  const w = l();
  function E() {
    return w.value = true, v();
  }
  async function R() {
    return !(t.value.outboundQuantity > 0) ? false : (w.value = false, v());
  }
  async function v(n) {
    var U;
    if (f.value = {}, !await r.value.validate()) return false;
    let e = L(t.value);
    e = { ...e, outboundUnitType: o.material.outboundUnitType, unitNet: o.material.unitNet };
    const b = { ...o.material, materialId: o.material.id, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, outboundAddress: q.FACTORY.V, materialOutboundMode: W.WHOLE.V, remark: e.remark, outboundQuantity: e.outboundQuantity, outboundMete: K(e.outboundMete, X.weight.precision), currentArea: e.currentArea, boolPartyA: o.material.boolPartyA, workshopId: (U = N.value.mesWorkshop) == null ? void 0 : U.id, uid: o.currentRow.uid };
    return f.value = b, true;
  }
  function V() {
    r.value && r.value.resetFields(), h(a);
  }
  function A() {
    r.value && r.value.clearValidate();
  }
  return x({ submit: v, commonSubmit: R, auditSubmit: E, resetForm: V, clearValidate: A, form: t, formInitTwo: B, submitData: f }), (n, u) => {
    const e = S, b = T;
    return s(Q) ? (j(), M(b, { key: 0, ref_key: "formRef", ref: r, model: t.value, rules: I.value, class: "form", "label-position": "left", "label-width": "120px", size: "default" }, { default: i(() => [d("div", Z, [c(J, { form: t.value, material: a.value }, { afterSpec: i(() => [c(e, { label: "厚 * 宽 * 长", class: "detail-item" }, { default: i(() => [d("span", null, g(`${a.value.thickness}${s(p).thickness.unit} * ${a.value.width}${s(p).width.unit} * ${a.value.length}${s(p).length.unit}`), 1)]), _: 1 })]), afterBrand: i(() => [c(e, { label: "炉批号/卷号", class: "detail-item" }, { default: i(() => [d("span", null, g(a.value.heatNoAndBatchNo), 1)]), _: 1 })]), _: 1 }, 8, ["form", "material"])]), d("div", ee, [c(G, { form: t.value, material: a.value, currentRow: m.currentRow, maxHeight: m.maxHeight }, null, 8, ["form", "material", "currentRow", "maxHeight"])])]), _: 1 }, 8, ["model", "rules"])) : O("", true);
  };
} }, le = $(te, [["__scopeId", "data-v-716946a1"]]);
export {
  le as default
};
