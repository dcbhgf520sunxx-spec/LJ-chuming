import { computed as i } from "vue";
import { ref as s } from "vue";
import { provide as q } from "vue";
import { watch as h } from "vue";
import { openBlock as w } from "vue";
import { createBlock as F } from "vue";
import { withCtx as I } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as l } from "vue";
import { ElForm as U } from "element-plus";
import { _ as x, jY as V, bC as E, qS as O, gG as R, zL as C, zN as N, V as B, x_ as P, yU as z, b as Q } from "../../../../../../../../../shared/runtime.js";
import S from "../components/common-material-info.vue.js";
const T = { class: "material-info" }, k = { class: "form-info" }, A = { __name: "gas", props: { basicClass: { type: Number }, material: { type: Object } }, setup(c, { expose: m }) {
  const f = c, p = (e, t, n) => {
    if (Q(t)) return n(new Error("请填写数量"));
    if (t <= 0) return n(new Error("数量必须大于0"));
    if (t > u.value) return n(new Error("数量不可超过可操作数量"));
    n();
  }, { outboundCfg: _ } = V(), g = i(() => {
    let e = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], quantity: [{ required: true, validator: p, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }], outboundTypeSelection: [{ required: true, message: "请选择出库类型", trigger: "change" }], isNeedRemind: [{ required: true, message: "请选择出库成功是否提醒", trigger: "change" }] };
    return _.value.productionOutBoundUserIsRequired && (e = Object.assign(e, { recipientId: [{ required: true, message: "请选领用人", trigger: "change" }] })), e;
  }), a = s(), r = s({}), o = i(() => f.material || {});
  E(a, r, ["quantity"]);
  const u = i(() => !r.value || !r.value.projectId || !o.value.projectFrozenForUnitKV ? o.value.corOperableQuantity : o.value.corOperableQuantity + (o.value.projectFrozenForUnitKV[r.value.projectId] || 0));
  q("maxQuantity", u), h(o, (e) => {
    v(e);
  }, { immediate: true });
  function v(e) {
    const t = { materialId: e.id, workshopId: void 0, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, outboundAddress: O.FACTORY.V, projectId: e.project ? e.project.id : void 0, originProjectId: e.project ? e.project.id : void 0, recipientId: void 0, quantity: void 0, remark: void 0, outboundTypeSelection: R.PRODUCE.V, isNeedRemind: C.YES.V };
    r.value = t;
  }
  async function b() {
    if (!await a.value.validate()) return false;
    r.value.boolPartyA = true;
    const t = B(r.value);
    return await P(t, { unit: t.outboundUnit, precision: t.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), await z(t);
  }
  function y() {
    a.value.resetFields();
  }
  function j() {
    a.value && a.value.clearValidate();
  }
  return m({ submit: b, resetForm: y, clearValidate: j }), (e, t) => {
    const n = U;
    return w(), F(n, { ref_key: "formRef", ref: a, model: r.value, rules: g.value, class: "form", "label-position": "left", "label-width": "135px", size: "default" }, { default: I(() => [d("div", T, [l(S, { form: r.value, material: o.value }, null, 8, ["form", "material"])]), d("div", k, [l(N, { form: r.value, material: o.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model", "rules"]);
  };
} }, W = x(A, [["__scopeId", "data-v-ab364262"]]);
export {
  W as default
};
