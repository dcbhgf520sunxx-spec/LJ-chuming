import { computed as i } from "vue";
import { ref as l } from "vue";
import { provide as j } from "vue";
import { watch as x } from "vue";
import { openBlock as h } from "vue";
import { createBlock as U } from "vue";
import { withCtx as w } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as m } from "vue";
import { ElForm as F } from "element-plus";
import { _ as O, jY as R, gG as f, bC as V, qS as E, zL as S, zN as C, b as N, V as T, x_ as B, yT as k } from "../../../../../../../../../shared/runtime.js";
import P from "../components/common-material-info.vue.js";
const z = { class: "material-info" }, Q = { class: "form-info" }, A = { __name: "aux-mat", props: { basicClass: { type: Number }, material: { type: Object } }, setup(p, { expose: g }) {
  const _ = p, s = (e, t, a) => {
    if (N(t)) return a(new Error("请填写数量"));
    if (t <= 0) return a(new Error("数量必须大于0"));
    if (t > d.value) return a(new Error("数量不可超过可操作数量"));
    a();
  }, { outboundCfg: v } = R(), n = i(() => {
    let e = { quantity: [{ required: true, validator: s, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }], outboundTypeSelection: [{ required: true, message: "请选择出库类型", trigger: "change" }], isNeedRemind: [{ required: true, message: "请选择出库成功是否提醒", trigger: "change" }] };
    return v.value.productionOutBoundUserIsRequired && (e = Object.assign(e, { recipientId: [{ required: true, message: "请选领用人", trigger: "change" }] })), r.value.outboundTypeSelection !== f.CONSTRUCTION_SITE_USE.V && (e = Object.assign(e, { workshopId: [{ required: true, message: "请选择出库车间", trigger: "change" }] })), e;
  }), u = l(), r = l({}), o = i(() => _.material || {});
  V(u, r, ["quantity"]);
  const d = i(() => !r.value || !r.value.projectId || !o.value.projectFrozenForUnitKV ? o.value.corOperableQuantity : o.value.corOperableQuantity + (o.value.projectFrozenForUnitKV[r.value.projectId] || 0));
  j("maxQuantity", d), x(o, (e) => {
    b(e);
  }, { immediate: true });
  function b(e) {
    const t = { materialId: e.id, workshopId: void 0, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, outboundAddress: E.FACTORY.V, projectId: e.project ? e.project.id : void 0, originProjectId: e.project ? e.project.id : void 0, recipientId: void 0, quantity: void 0, remark: void 0, outboundTypeSelection: f.PRODUCE.V, isNeedRemind: S.YES.V };
    r.value = t, n.value = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], quantity: [{ required: true, validator: s, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, t.projectId && (n.value.projectId = { required: true, message: "项目库辅材必须选择项目出库", trigger: "change" });
  }
  async function y() {
    if (!await u.value.validate()) return false;
    r.value.boolPartyA = true;
    const t = T(r.value);
    return await B(t, { unit: t.outboundUnit, precision: t.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), await k(t);
  }
  function q() {
    u.value.resetFields();
  }
  function I() {
    u.value && u.value.clearValidate();
  }
  return g({ submit: y, resetForm: q, clearValidate: I }), (e, t) => {
    const a = F;
    return h(), U(a, { ref_key: "formRef", ref: u, model: r.value, rules: n.value, class: "form", "label-position": "left", "label-width": "135px", size: "default" }, { default: w(() => [c("div", z, [m(P, { form: r.value, material: o.value }, null, 8, ["form", "material"])]), c("div", Q, [m(C, { form: r.value, material: o.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model", "rules"]);
  };
} }, K = O(A, [["__scopeId", "data-v-84e6e6a4"]]);
export {
  K as default
};
