import { ref as m } from "vue";
import { computed as a } from "vue";
import { provide as U } from "vue";
import { watch as V } from "vue";
import { openBlock as j } from "vue";
import { createBlock as k } from "vue";
import { withCtx as q } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as c } from "vue";
import { ElForm as B } from "element-plus";
import { _ as N, hW as Q, m as C, bC as E, qS as O, yU as A, V as W, x_ as z, b as P } from "../../../../../../../shared/runtime.js";
import R from "../components/common-form-item.vue.js";
import S from "../components/common-material-info.vue.js";
import "../../../../../../../modules/workshop-select-210dd661.js";
const D = { class: "material-info" }, K = { class: "form-info" }, T = { __name: "gas", props: { basicClass: { type: Number }, material: { type: Object } }, setup(f, { expose: p }) {
  const { mesWorkShopName: v } = Q(), _ = f, b = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], quantity: [{ required: true, validator: (e, r, t) => {
    if (P(r)) return t(new Error("请填写数量"));
    if (r <= 0) return t(new Error("数量必须大于0"));
    if (r > s.value) return t(new Error("数量不可超过可操作数量"));
    t();
  }, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, i = m(), o = m({}), { user: y } = C("user"), n = a(() => _.material || {});
  E(i, o, ["quantity"]);
  const s = a(() => !o.value || !o.value.projectId || !n.value.projectFrozenForUnitKV ? n.value.corOperableQuantity : n.value.corOperableQuantity + (n.value.projectFrozenForUnitKV[o.value.projectId] || 0));
  U("maxQuantity", s), V(n, (e) => {
    g(e);
  }, { immediate: true });
  function g(e) {
    var t, u;
    const r = { materialId: e.id, monomerId: e == null ? void 0 : e.monomerId, areaId: e == null ? void 0 : e.areaId, workshopId: ((t = v.value) == null ? void 0 : t.findIndex((F) => {
      var l;
      return F.id === ((l = e.workshop) == null ? void 0 : l.id);
    })) > -1 ? (u = e.workshop) == null ? void 0 : u.id : void 0, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, outboundAddress: O.FACTORY.V, projectId: e.project ? e.project.id : void 0, recipientId: y.value.id, quantity: void 0, remark: void 0 };
    o.value = r;
  }
  const h = a(() => A);
  async function w() {
    if (!await i.value.validate()) return false;
    const r = W(o.value);
    return await z(r, { unit: r.outboundUnit, precision: r.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), await h.value(r);
  }
  function I() {
    i.value.resetFields();
  }
  function x() {
    i.value && i.value.clearValidate();
  }
  return p({ submit: w, resetForm: I, clearValidate: x }), (e, r) => {
    const t = B;
    return j(), k(t, { ref_key: "formRef", ref: i, model: o.value, rules: b, class: "form", "label-position": "left", "label-width": "120px", size: "default" }, { default: q(() => [d("div", D, [c(S, { form: o.value, material: n.value }, null, 8, ["form", "material"])]), d("div", K, [c(R, { form: o.value, material: n.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model"]);
  };
} }, M = N(T, [["__scopeId", "data-v-ee90636d"]]);
export {
  M as default
};
