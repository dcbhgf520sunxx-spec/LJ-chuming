import { computed as p } from "vue";
import { ref as l } from "vue";
import { inject as S } from "vue";
import { provide as j } from "vue";
import { watch as A } from "vue";
import { unref as w } from "vue";
import { openBlock as M } from "vue";
import { createBlock as O } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as d } from "vue";
import { toDisplayString as g } from "vue";
import { createCommentVNode as k } from "vue";
import { ElFormItem as L } from "element-plus";
import { ElForm as P } from "element-plus";
import { _ as T, sQ as z, bC as D, i as H, V as q, qS as W, yQ as K, iX as $, jN as X, b as Y } from "../../../../../../shared/runtime.js";
import G from "../components/common-form-item.vue.js";
import J from "../components/common-material-info.vue.js";
import "../components/produce-form.vue.js";
const Z = { class: "material-info clearfix" }, ee = { class: "form-info" }, te = { __name: "section-steel", props: { basicClass: { type: Number }, currentRow: { type: Object, default: () => ({}) }, material: { type: Object }, visible: { type: Boolean, default: false }, maxHeight: { type: Number, default: 100 } }, setup(c, { expose: U }) {
  const o = c, x = (n, r, e) => {
    if (Y(r)) return e(new Error("请填写数量"));
    if (r <= 0) return e(new Error("数量必须大于0"));
    if (r > v.value) return e(new Error("数量不可超过可操作数量"));
    e();
  }, F = p(() => ({ outboundQuantity: [{ required: true, validator: x, trigger: "blur" }] })), u = l(), t = l({}), I = S("mainCurrentRow"), m = l({}), a = p(() => o.material || {}), { loaded: N, baseUnit: Q } = z(o.basicClass);
  D(u, t, ["quantity", "halfSize"]);
  const v = p(() => !t.value || !t.value.projectId || !a.value.projectFrozenForUnitKV ? a.value.corOperableQuantity : a.value.corOperableQuantity + (a.value.projectFrozenForUnitKV[t.value.projectId] || 0));
  j("maxQuantity", v), A(a, (n) => {
    _(n);
  }, { immediate: true, deep: true });
  function _(n) {
    if (H(n)) {
      const r = { materialId: n.id, outboundUnit: n.outboundUnit, outboundUnitPrecision: n.outboundUnitPrecision, uid: o.currentRow.uid, outboundQuantity: void 0, outboundMete: void 0, currentArea: void 0, currentLength: void 0 };
      t.value = r;
    }
  }
  function B() {
    t.value.outboundQuantity = void 0, t.value.outboundMete = void 0, t.value.currentArea = void 0, t.value.currentLength = void 0;
  }
  const y = l();
  function E() {
    return y.value = true, f();
  }
  async function R() {
    return !(t.value.outboundQuantity > 0) ? false : (y.value = false, f());
  }
  async function f(n) {
    var h;
    if (m.value = {}, !await u.value.validate()) return false;
    let e = q(t.value);
    e = { ...e, outboundUnitType: o.material.outboundUnitType, unitNet: o.material.unitNet };
    const b = { ...o.material, materialId: o.material.id, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, outboundAddress: W.FACTORY.V, materialOutboundMode: K.WHOLE.V, remark: e.remark, outboundQuantity: e.outboundQuantity, outboundMete: $(e.outboundMete, X.weight.precision), currentLength: e.currentLength, boolPartyA: o.material.boolPartyA, workshopId: (h = I.value.mesWorkshop) == null ? void 0 : h.id, uid: o.currentRow.uid };
    return m.value = b, true;
  }
  function V() {
    u.value.resetFields(), _(a);
  }
  function C() {
    u.value && u.value.clearValidate();
  }
  return U({ submit: f, commonSubmit: R, auditSubmit: E, resetForm: V, clearValidate: C, form: t, formInitTwo: B, submitData: m }), (n, r) => {
    const e = L, b = P;
    return w(N) ? (M(), O(b, { key: 0, ref_key: "formRef", ref: u, model: t.value, rules: F.value, class: "form", "label-position": "left", "label-width": "130px", size: "default" }, { default: i(() => [s("div", Z, [d(J, { form: t.value, material: a.value }, { afterSpec: i(() => [d(e, { label: "定尺长度", class: "detail-item" }, { default: i(() => [s("span", null, g(`${a.value.length}${w(Q).length.unit}`), 1)]), _: 1 })]), afterBrand: i(() => [d(e, { label: "炉批号/卷号", class: "detail-item" }, { default: i(() => [s("span", null, g(a.value.heatNoAndBatchNo), 1)]), _: 1 })]), _: 1 }, 8, ["form", "material"])]), s("div", ee, [d(G, { form: t.value, material: a.value, currentRow: c.currentRow, maxHeight: c.maxHeight }, null, 8, ["form", "material", "currentRow", "maxHeight"])])]), _: 1 }, 8, ["model", "rules"])) : k("", true);
  };
} }, le = T(te, [["__scopeId", "data-v-0e0bb209"]]);
export {
  le as default
};
