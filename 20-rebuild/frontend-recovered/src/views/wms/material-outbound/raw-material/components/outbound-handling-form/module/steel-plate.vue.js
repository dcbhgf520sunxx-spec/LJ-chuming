import { ref as w } from "vue";
import { computed as p } from "vue";
import { provide as C } from "vue";
import { watch as P } from "vue";
import { resolveComponent as I } from "vue";
import { unref as i } from "vue";
import { openBlock as M } from "vue";
import { createBlock as Q } from "vue";
import { withCtx as u } from "vue";
import { createElementVNode as v } from "vue";
import { createVNode as n } from "vue";
import { toDisplayString as E } from "vue";
import { createElementBlock as $ } from "vue";
import { Fragment as T } from "vue";
import { createCommentVNode as U } from "vue";
import { ElFormItem as W } from "element-plus";
import { ElForm as A } from "element-plus";
import { _ as D, hW as L, sQ as R, bC as G, yP as s, qS as K, yQ as h, yR as Y, V as J, x_ as X, b as x } from "../../../../../../../shared/runtime.js";
import Z from "../components/common-form-item.vue.js";
import ee from "../components/common-material-info.vue.js";
import "../../../../../../../modules/workshop-select-210dd661.js";
const te = { class: "material-info" }, oe = { class: "form-info" }, re = { __name: "steel-plate", props: { basicClass: { type: Number }, material: { type: Object } }, setup(F, { expose: z }) {
  const { mesWorkShopName: N } = L(), b = F, S = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], projectId: [{ required: true, message: "请选择出库项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择出库车间", trigger: "change" }], materialOutboundMode: [{ required: true, message: "请选择物料出库方式", trigger: "change" }], halfMode: [{ required: true, message: "请选择物料半出方式", trigger: "change" }], halfSize: [{ required: true, validator: (o, e, r) => {
    if (x(e)) return r(new Error("请填写半出尺寸"));
    if (e <= 0) return r(new Error("半出尺寸必须大于0"));
    if (e > g.value) return r(new Error("半出尺寸不可超过当前物料尺寸"));
    r();
  }, trigger: "blur" }], quantity: [{ required: true, validator: (o, e, r) => {
    if (x(e)) return r(new Error("请填写数量"));
    if (e <= 0) return r(new Error("数量必须大于0"));
    if (e > V.value) return r(new Error("数量不可超过可操作数量"));
    r();
  }, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, l = w(), t = w({ quantity: void 0 }), a = p(() => b.material || {}), { loaded: q, baseUnit: d } = R(b.basicClass);
  G(l, t, ["quantity", "halfSize"]);
  const g = p(() => t.value.halfMode === s.LENGTH.V ? +a.value.length : t.value.halfMode === s.WIDTH.V ? +a.value.width : 0), y = p(() => t.value.halfMode === s.LENGTH.V ? d.value.length : t.value.halfMode === s.WIDTH.V ? d.value.width : {}), V = p(() => !t.value || !t.value.projectId || !a.value.projectFrozenForUnitKV ? a.value.corOperableQuantity : a.value.corOperableQuantity + (a.value.projectFrozenForUnitKV[t.value.projectId] || 0));
  C("maxQuantity", V), P(a, (o) => {
    O(o);
  }, { immediate: true, deep: true });
  function O(o) {
    var r, m;
    const e = { materialId: o.id, monomerId: o == null ? void 0 : o.monomerId, areaId: o == null ? void 0 : o.areaId, workshopId: ((r = N.value) == null ? void 0 : r.findIndex((_) => {
      var c;
      return _.id === ((c = o.workshop) == null ? void 0 : c.id);
    })) > -1 ? (m = o.workshop) == null ? void 0 : m.id : void 0, outboundUnit: o.outboundUnit, outboundUnitPrecision: o.outboundUnitPrecision, outboundAddress: K.FACTORY.V, projectId: o.project ? o.project.id : void 0, materialOutboundMode: h.WHOLE.V, halfMode: s.LENGTH.V, recipientId: void 0, quantity: void 0, remark: void 0 };
    t.value = e;
  }
  const H = p(() => Y);
  async function k() {
    if (!await l.value.validate()) return false;
    const e = J(t.value);
    return await X(e, { unit: e.outboundUnit, precision: e.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), await H.value(e);
  }
  function B() {
    l.value && l.value.resetFields();
  }
  function j() {
    l.value && l.value.clearValidate();
  }
  return z({ submit: k, resetForm: B, clearValidate: j }), (o, e) => {
    const r = W, m = I("common-radio"), _ = I("common-input-number"), c = A;
    return i(q) ? (M(), Q(c, { key: 0, ref_key: "formRef", ref: l, model: t.value, rules: S, class: "form", "label-position": "left", "label-width": "120px", size: "default" }, { default: u(() => [v("div", te, [n(ee, { form: t.value, material: a.value }, { afterSpec: u(() => [n(r, { label: "厚 * 宽 * 长" }, { default: u(() => [v("span", null, E(`${a.value.thickness}${i(d).thickness.unit} * ${a.value.width}${i(d).width.unit} * ${a.value.length}${i(d).length.unit}`), 1)]), _: 1 })]), afterBrand: u(() => [n(r, { label: "炉批号/卷号" }, { default: u(() => [v("span", null, E(a.value.heatNoAndBatchNo), 1)]), _: 1 })]), _: 1 }, 8, ["form", "material"])]), v("div", oe, [n(r, { label: "出库方式", prop: "materialOutboundMode" }, { default: u(() => [n(m, { modelValue: t.value.materialOutboundMode, "onUpdate:modelValue": e[0] || (e[0] = (f) => t.value.materialOutboundMode = f), options: i(h).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), t.value.materialOutboundMode === i(h).HALF.V ? (M(), $(T, { key: 0 }, [n(r, { label: "半出方式", prop: "halfMode" }, { default: u(() => [n(m, { modelValue: t.value.halfMode, "onUpdate:modelValue": e[1] || (e[1] = (f) => t.value.halfMode = f), options: i(s).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), n(r, { label: `半出尺寸(${y.value.unit})`, prop: "halfSize" }, { default: u(() => [n(_, { modelValue: t.value.halfSize, "onUpdate:modelValue": e[2] || (e[2] = (f) => t.value.halfSize = f), max: g.value, min: 0, precision: y.value.precision, "controls-position": "right" }, null, 8, ["modelValue", "max", "precision"])]), _: 1 }, 8, ["label"])], 64)) : U("", true), n(Z, { form: t.value, material: a.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model"])) : U("", true);
  };
} }, me = D(re, [["__scopeId", "data-v-de93c03b"]]);
export {
  me as default
};
