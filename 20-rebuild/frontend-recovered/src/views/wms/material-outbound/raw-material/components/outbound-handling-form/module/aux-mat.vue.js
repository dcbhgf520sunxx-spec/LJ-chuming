import { ref as u } from "vue";
import { computed as s } from "vue";
import { provide as q } from "vue";
import { watch as j } from "vue";
import { openBlock as k } from "vue";
import { createBlock as U } from "vue";
import { withCtx as V } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as p } from "vue";
import { ElForm as B } from "element-plus";
import { _ as N, hW as C, bC as E, qS as O, yT as Q, b as A, V as W, x_ as z } from "../../../../../../../shared/runtime.js";
import M from "../components/common-form-item.vue.js";
import P from "../components/common-material-info.vue.js";
import "../../../../../../../modules/workshop-select-210dd661.js";
const R = { class: "material-info" }, S = { class: "form-info" }, T = { __name: "aux-mat", props: { basicClass: { type: Number }, material: { type: Object } }, setup(v, { expose: _ }) {
  const { mesWorkShopName: g } = C(), b = v, l = (e, r, t) => {
    if (A(r)) return t(new Error("请填写数量"));
    if (r <= 0) return t(new Error("数量必须大于0"));
    if (r > m.value) return t(new Error("数量不可超过可操作数量"));
    t();
  }, i = u({ quantity: [{ required: true, validator: l, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }], workshopId: [{ required: true, message: "请选择出库车间", trigger: "change" }] }), n = u(), o = u({}), a = s(() => b.material || {});
  E(n, o, ["quantity"]);
  const m = s(() => !o.value || !o.value.projectId || !a.value.projectFrozenForUnitKV ? a.value.corOperableQuantity : a.value.corOperableQuantity + (a.value.projectFrozenForUnitKV[o.value.projectId] || 0));
  q("maxQuantity", m), j(a, (e) => {
    y(e);
  }, { immediate: true });
  function y(e) {
    var t, d;
    const r = { materialId: e.id, monomerId: e == null ? void 0 : e.monomerId, areaId: e == null ? void 0 : e.areaId, workshopId: ((t = g.value) == null ? void 0 : t.findIndex((F) => {
      var c;
      return F.id === ((c = e.workshop) == null ? void 0 : c.id);
    })) > -1 ? (d = e.workshop) == null ? void 0 : d.id : void 0, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, outboundAddress: O.FACTORY.V, projectId: e.project ? e.project.id : void 0, recipientId: void 0, quantity: void 0, remark: void 0 };
    o.value = r, i.value = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], quantity: [{ required: true, validator: l, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, r.projectId && (i.value.projectId = { required: true, message: "项目库辅材必须选择项目出库", trigger: "change" });
  }
  const h = s(() => Q);
  async function x() {
    if (!await n.value.validate()) return false;
    const r = W(o.value);
    return await z(r, { unit: r.outboundUnit, precision: r.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), await h.value(r);
  }
  function I() {
    n.value.resetFields();
  }
  function w() {
    n.value && n.value.clearValidate();
  }
  return _({ submit: x, resetForm: I, clearValidate: w }), (e, r) => {
    const t = B;
    return k(), U(t, { ref_key: "formRef", ref: n, model: o.value, rules: i.value, class: "form", "label-position": "left", "label-width": "120px", size: "default" }, { default: V(() => [f("div", R, [p(P, { form: o.value, material: a.value }, null, 8, ["form", "material"])]), f("div", S, [p(M, { form: o.value, material: a.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model", "rules"]);
  };
} }, G = N(T, [["__scopeId", "data-v-f04fac67"]]);
export {
  G as default
};
