import { computed as u } from "vue";
import { ref as l } from "vue";
import { provide as q } from "vue";
import { watch as j } from "vue";
import { openBlock as I } from "vue";
import { createBlock as x } from "vue";
import { withCtx as F } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as m } from "vue";
import { ElForm as V } from "element-plus";
import { _ as w, jY as U, bC as R, qS as E, gG as N, zL as O, zN as C, b as B, V as P, x_ as z, yV as Q } from "../../../../../../../../../shared/runtime.js";
import S from "../components/common-material-info.vue.js";
const T = { class: "material-info" }, k = { class: "form-info" }, A = { __name: "other", props: { basicClass: { type: Number }, material: { type: Object } }, setup(f, { expose: p }) {
  const g = f, s = (e, r, o) => {
    if (B(r)) return o(new Error("请填写数量"));
    if (r <= 0) return o(new Error("数量必须大于0"));
    if (r > d.value) return o(new Error("数量不可超过可操作数量"));
    o();
  }, { outboundCfg: _ } = U(), n = u(() => {
    let e = { quantity: [{ required: true, validator: s, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }], isNeedRemind: [{ required: true, message: "请选择出库成功是否提醒", trigger: "change" }] };
    return _.value.productionOutBoundUserIsRequired && (e = Object.assign(e, { recipientId: [{ required: true, message: "请选领用人", trigger: "change" }] })), e;
  }), i = l(), t = l({}), a = u(() => g.material || {});
  R(i, t, ["quantity"]);
  const d = u(() => !t.value || !t.value.projectId || !a.value.projectFrozenForUnitKV ? a.value.corOperableQuantity : a.value.corOperableQuantity + (a.value.projectFrozenForUnitKV[t.value.projectId] || 0));
  q("maxQuantity", d), j(a, (e) => {
    v(e);
  }, { immediate: true });
  function v(e) {
    var o;
    const r = { materialId: e.id, factoryId: (o = e.factory) == null ? void 0 : o.id, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, outboundAddress: E.FACTORY.V, projectId: e.project ? e.project.id : void 0, originProjectId: e.project ? e.project.id : void 0, recipientId: void 0, quantity: void 0, remark: void 0, outboundTypeSelection: N.PRODUCE.V, isNeedRemind: O.YES.V };
    t.value = r, n.value = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], quantity: [{ required: true, validator: s, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }], outboundTypeSelection: [{ required: true, message: "请选择出库类型", trigger: "change" }], isNeedRemind: [{ required: true, message: "请选择出库成功是否提醒", trigger: "change" }] }, r.projectId && (n.value.projectId = { required: true, message: "项目库辅材必须选择项目出库", trigger: "change" });
  }
  async function b() {
    if (!await i.value.validate()) return false;
    t.value.boolPartyA = true;
    const r = P(t.value);
    return await z(r, { unit: r.outboundUnit, precision: r.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), await Q(r);
  }
  function y() {
    i.value.resetFields();
  }
  function h() {
    i.value && i.value.clearValidate();
  }
  return p({ submit: b, resetForm: y, clearValidate: h }), (e, r) => {
    const o = V;
    return I(), x(o, { ref_key: "formRef", ref: i, model: t.value, rules: n.value, class: "form", "label-position": "left", "label-width": "135px", size: "default" }, { default: F(() => [c("div", T, [m(S, { form: t.value, material: a.value }, null, 8, ["form", "material"])]), c("div", k, [m(C, { form: t.value, material: a.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model", "rules"]);
  };
} }, W = w(A, [["__scopeId", "data-v-9a94c14f"]]);
export {
  W as default
};
