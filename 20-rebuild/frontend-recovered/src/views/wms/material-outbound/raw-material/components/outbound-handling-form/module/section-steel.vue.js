import { ref as h } from "vue";
import { computed as f } from "vue";
import { provide as M } from "vue";
import { watch as k } from "vue";
import { resolveComponent as y } from "vue";
import { unref as l } from "vue";
import { openBlock as w } from "vue";
import { createBlock as V } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as i } from "vue";
import { toDisplayString as I } from "vue";
import { createCommentVNode as S } from "vue";
import { ElFormItem as Q } from "element-plus";
import { ElForm as A } from "element-plus";
import { _ as H, hW as W, sQ as D, bC as L, qS as P, yQ as _, yS as R, V as $, x_ as K, b as x } from "../../../../../../../shared/runtime.js";
import T from "../components/common-form-item.vue.js";
import Y from "../components/common-material-info.vue.js";
import "../../../../../../../modules/workshop-select-210dd661.js";
const G = { class: "material-info" }, J = { class: "form-info" }, X = { __name: "section-steel", props: { basicClass: { type: Number }, material: { type: Object } }, setup(F, { expose: U }) {
  const { mesWorkShopName: O } = W(), v = F, z = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], projectId: [{ required: true, message: "请选择出库项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择出库车间", trigger: "change" }], materialOutboundMode: [{ required: true, message: "请选择物料出库方式", trigger: "change" }], halfSize: [{ required: true, validator: (e, t, o) => {
    if (x(t)) return o(new Error("请填写半出尺寸"));
    if (t <= 0) return o(new Error("半出尺寸必须大于0"));
    if (t > n.value.length) return o(new Error("半出尺寸不可超过当前物料定尺长度"));
    o();
  }, trigger: "blur" }], quantity: [{ required: true, validator: (e, t, o) => {
    if (x(t)) return o(new Error("请填写数量"));
    if (t <= 0) return o(new Error("数量必须大于0"));
    if (t > g.value) return o(new Error("数量不可超过可操作数量"));
    o();
  }, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, u = h(), r = h({}), n = f(() => v.material || {}), { loaded: E, baseUnit: b } = D(v.basicClass);
  L(u, r, ["quantity", "halfSize"]);
  const g = f(() => !r.value || !r.value.projectId || !n.value.projectFrozenForUnitKV ? n.value.corOperableQuantity : n.value.corOperableQuantity + (n.value.projectFrozenForUnitKV[r.value.projectId] || 0));
  M("maxQuantity", g), k(n, (e) => {
    q(e);
  }, { immediate: true, deep: true });
  function q(e) {
    var o, s;
    const t = { materialId: e.id, monomerId: e == null ? void 0 : e.monomerId, areaId: e == null ? void 0 : e.areaId, workshopId: ((o = O.value) == null ? void 0 : o.findIndex((c) => {
      var m;
      return c.id === ((m = e.workshop) == null ? void 0 : m.id);
    })) > -1 ? (s = e.workshop) == null ? void 0 : s.id : void 0, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, outboundAddress: P.FACTORY.V, projectId: e.project ? e.project.id : void 0, materialOutboundMode: _.WHOLE.V, recipientId: void 0, quantity: void 0, remark: void 0 };
    r.value = t;
  }
  const N = f(() => R);
  async function j() {
    if (!await u.value.validate()) return false;
    const t = $(r.value);
    return await K(t, { unit: t.outboundUnit, precision: t.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), await N.value(t);
  }
  function B() {
    u.value.resetFields();
  }
  function C() {
    u.value && u.value.clearValidate();
  }
  return U({ submit: j, resetForm: B, clearValidate: C }), (e, t) => {
    const o = Q, s = y("common-radio"), c = y("common-input-number"), m = A;
    return l(E) ? (w(), V(m, { key: 0, ref_key: "formRef", ref: u, model: r.value, rules: z, class: "form", "label-position": "left", "label-width": "130px", size: "default" }, { default: a(() => [d("div", G, [i(Y, { form: r.value, material: n.value }, { afterSpec: a(() => [i(o, { label: "定尺长度" }, { default: a(() => [d("span", null, I(`${n.value.length}${l(b).length.unit}`), 1)]), _: 1 })]), afterBrand: a(() => [i(o, { label: "炉批号/卷号" }, { default: a(() => [d("span", null, I(n.value.heatNoAndBatchNo), 1)]), _: 1 })]), _: 1 }, 8, ["form", "material"])]), d("div", J, [i(o, { label: "出库方式", prop: "materialOutboundMode" }, { default: a(() => [i(s, { modelValue: r.value.materialOutboundMode, "onUpdate:modelValue": t[0] || (t[0] = (p) => r.value.materialOutboundMode = p), options: l(_).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), r.value.materialOutboundMode === l(_).HALF.V ? (w(), V(o, { key: 0, label: "半出尺寸(mm)", prop: "halfSize" }, { default: a(() => [i(c, { modelValue: r.value.halfSize, "onUpdate:modelValue": t[1] || (t[1] = (p) => r.value.halfSize = p), max: +n.value.length, min: 0, precision: l(b).length.precision, "controls-position": "right" }, null, 8, ["modelValue", "max", "precision"])]), _: 1 })) : S("", true), i(T, { form: r.value, material: n.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model"])) : S("", true);
  };
} }, ie = H(X, [["__scopeId", "data-v-a6baba17"]]);
export {
  ie as default
};
