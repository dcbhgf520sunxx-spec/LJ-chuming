import { computed as c } from "vue";
import { ref as h } from "vue";
import { provide as T } from "vue";
import { watch as P } from "vue";
import { resolveComponent as S } from "vue";
import { unref as u } from "vue";
import { openBlock as f } from "vue";
import { createBlock as p } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as s } from "vue";
import { toDisplayString as V } from "vue";
import { createCommentVNode as _ } from "vue";
import { ElFormItem as H } from "element-plus";
import { ElForm as Q } from "element-plus";
import { _ as k, jY as A, gG as O, sQ as D, bC as L, qS as Y, yQ as g, yP as W, zL as $, zN as G, i as K, V as J, x_ as X, yS as Z, b as U } from "../../../../../../../../../shared/runtime.js";
import ee from "../components/common-material-info.vue.js";
const te = { class: "material-info" }, re = { class: "form-info" }, oe = { __name: "section-steel", props: { basicClass: { type: Number }, material: { type: Object } }, setup(E, { expose: w }) {
  const d = E, I = (t, e, o) => {
    if (U(e)) return o(new Error("请填写数量"));
    if (e <= 0) return o(new Error("数量必须大于0"));
    if (e > y.value) return o(new Error("数量不可超过可操作数量"));
    o();
  }, q = (t, e, o) => {
    if (U(e)) return o(new Error("请填写半出尺寸"));
    if (e <= 0) return o(new Error("半出尺寸必须大于0"));
    if (e > n.value.length) return o(new Error("半出尺寸不可超过当前物料定尺长度"));
    o();
  }, { outboundCfg: b } = A(), N = c(() => {
    let t = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], projectId: [{ required: true, message: "请选择出库项目", trigger: "change" }], halfSize: [{ required: true, validator: q, trigger: "blur" }], quantity: [{ required: true, validator: I, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }], materialOutboundMode: [{ required: true, message: "请选择出库类型", trigger: "change" }], isNeedRemind: [{ required: true, message: "请选择出库成功是否提醒", trigger: "change" }] };
    return r.value.outboundTypeSelection !== O.CONSTRUCTION_SITE_USE.V && (t = Object.assign(t, { workshopId: [{ required: true, message: "请选择出库车间", trigger: "change" }] })), b.value.productionOutBoundUserIsRequired && (t = Object.assign(t, { recipientId: [{ required: true, message: "请选领用人", trigger: "change" }] })), t;
  }), i = h(), r = h({}), n = c(() => d.material || {}), { loaded: j, baseUnit: v } = D(d.basicClass);
  L(i, r, ["quantity", "halfSize"]);
  const y = c(() => !r.value || !r.value.projectId || !n.value.projectFrozenForUnitKV ? n.value.corOperableQuantity : n.value.corOperableQuantity + (n.value.projectFrozenForUnitKV[r.value.projectId] || 0));
  T("maxQuantity", y), P(n, (t) => {
    x(t);
  }, { immediate: true, deep: true });
  function x(t) {
    const e = { materialId: t.id, workshopId: void 0, outboundUnit: t.outboundUnit, outboundUnitPrecision: t.outboundUnitPrecision, outboundAddress: Y.FACTORY.V, projectId: t.project ? t.project.id : void 0, originProjectId: t.project ? t.project.id : void 0, materialOutboundMode: g.WHOLE.V, recipientId: void 0, halfMode: W.LENGTH.V, quantity: void 0, remark: void 0, outboundTypeSelection: O.PRODUCE.V, isNeedRemind: $.YES.V };
    r.value = e;
  }
  async function C() {
    if (!await i.value.validate()) return false;
    r.value.boolPartyA = true;
    const e = J(r.value);
    return await X(e, { unit: e.outboundUnit, precision: e.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), await Z(e);
  }
  function F() {
    i.value.resetFields();
  }
  function z() {
    i.value && i.value.clearValidate();
  }
  return w({ submit: C, resetForm: F, clearValidate: z }), (t, e) => {
    const o = H, R = S("common-radio"), B = S("common-input-number"), M = Q;
    return u(j) ? (f(), p(M, { key: 0, ref_key: "formRef", ref: i, model: r.value, rules: N.value, class: "form", "label-position": "left", "label-width": "135px", size: "default" }, { default: a(() => [l("div", te, [s(ee, { form: r.value, material: n.value }, { afterSpec: a(() => [s(o, { label: "定尺长度" }, { default: a(() => [l("span", null, V(`${n.value.length}${u(v).length.unit}`), 1)]), _: 1 })]), afterBrand: a(() => [s(o, { label: "炉批号/卷号" }, { default: a(() => [l("span", null, V(n.value.heatNoAndBatchNo), 1)]), _: 1 })]), _: 1 }, 8, ["form", "material"])]), l("div", re, [s(G, { form: r.value, material: n.value }, { extra: a(() => [!u(K)(d.material.dxfUrl) && u(b).showHalfOut ? (f(), p(o, { key: 0, label: "出库方式", prop: "materialOutboundMode" }, { default: a(() => [s(R, { modelValue: r.value.materialOutboundMode, "onUpdate:modelValue": e[0] || (e[0] = (m) => r.value.materialOutboundMode = m), options: u(g).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 })) : _("", true), r.value.materialOutboundMode === u(g).HALF.V ? (f(), p(o, { key: 1, label: "半出尺寸(mm)", prop: "halfSize" }, { default: a(() => [s(B, { modelValue: r.value.halfSize, "onUpdate:modelValue": e[1] || (e[1] = (m) => r.value.halfSize = m), max: +n.value.length, min: 0, precision: u(v).length.precision, "controls-position": "right" }, null, 8, ["modelValue", "max", "precision"])]), _: 1 })) : _("", true)]), _: 1 }, 8, ["form", "material"])])]), _: 1 }, 8, ["model", "rules"])) : _("", true);
  };
} }, ie = k(oe, [["__scopeId", "data-v-84fb4b68"]]);
export {
  ie as default
};
